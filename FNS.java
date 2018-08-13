import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FNS {
    private static HttpClient httpclient = HttpClients.createMinimal();
    private static final String LOGIN_PATH = "/v1/mobile/users/login";
    private static final String RESTORE_PATH = "v1/mobile/users/restore";
    private static final String SIGN_UP = "/v1/mobile/users/signup";

    private FNS() {

    }

    /**
     * Регистрация пользователя. Посылает POST запрос в ФНС для регистрации нового пользователя. В качестве логина будет использован
     * его телефон, пароль выдает ФНС через смс.
     *
     * @param email
     * @param name
     * @param phone формат "+79161234567"
     * @throws InternalFnsException      какая-то внутреняя ошибка. Можно проигнорировать или засунуть ее в свой логгер.
     * @throws IOException               проблемы с сетью
     * @throws IllegalArgumentException
     * @throws UserAlreadyExistException Пользователь уже существует в ФНС
     */
    public static void signUp(String email, String name, String phone) throws InternalFnsException,
            IOException, UserAlreadyExistException {//409 если существует
        String jsonString = null;
        try {
            jsonString = new JSONObject()
                    .put("email", email)
                    .put("name", name)
                    .put("phone", phone).toString();
            URI uri = createUri(SIGN_UP).build();
            HttpPost post = new HttpPost(uri);
            addDefaultHeaders(post);
            StringEntity entity = new StringEntity(jsonString, ContentType.APPLICATION_JSON);
            post.setEntity(entity);
            HttpResponse response = httpclient.execute(post);
            if (response.getStatusLine().getStatusCode() != 204) {
                if (response.getStatusLine().getStatusCode() == 409) {
                    throw new UserAlreadyExistException("Пользователь с данными" + jsonString + " уже существует в базе ФНС");
                } else throw new IOException("Ошибка взаимодействия с сервером ФНС");
            }
        } catch (JSONException e) {//
            throw new IllegalArgumentException(e); // Может произойти только если подать на вход неверные данные
        } catch (URISyntaxException e) {
            throw new InternalFnsException(e);
        }
    }

    /**
     * Логин пользователя
     *
     * @param login    номер телефона в формате "+79161234567"
     * @param password пароль сгенерированный ФНС.
     * @return true если успешно
     * @throws IOException          в случае проблем с сетью
     * @throws InternalFnsException какая-то внутреняя ошибка. Можно проигнорировать или засунуть ее в свой логгер.
     */
    public static boolean login(String login, String password) throws InternalFnsException, IOException {
        HttpGet get = createGet(LOGIN_PATH, login, password, null);
        return httpclient.execute(get).getStatusLine().getStatusCode() == 200;
    }

    /**
     * Восстановить пароль. Пароль пришлет ФНС через смс.
     *
     * @param login номер телефона в формате "+79161234567"
     * @throws InternalFnsException      какая-то внутреняя ошибка. Можно проигнорировать или засунуть ее в свой логгер.
     * @throws IOException               Проблемы с сетью
     * @throws UserDoesNotExistException Пользователь не существует
     */
    public static void restorePassword(String login) throws InternalFnsException, IOException, UserDoesNotExistException {
        try {
            URI uri = createUri(RESTORE_PATH).build();
            HttpPost post = new HttpPost(uri);
            addDefaultHeaders(post);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("phone", login);
            StringEntity entity = new StringEntity(jsonObject.toString(), ContentType.APPLICATION_JSON);
            post.setEntity(entity);
            HttpResponse response = httpclient.execute(post);
            if (response.getStatusLine().getStatusCode() != 204) {
                if (response.getStatusLine().getStatusCode() == 404) {
                    throw new UserDoesNotExistException("Пользователя с логином" + login + " не существует");
                }
                throw new InternalFnsException("Статус запроса отличается от обычного");
            }
        } catch (JSONException | URISyntaxException e) { //Этого не может произойти
            throw new InternalFnsException(e);
        }


    }

    /**
     * Проверит существование чека в базе ФНС
     *
     * @param login    номер телефона в формате "+79161234567"
     * @param password пароль
     * @param FN       Фискальный Номер
     * @param FD       Фискальный документ
     * @param FPD      Фискальный Признак Документа
     * @param date     дата в формате 2018-07-23T10:14:00
     * @param sum      итоговая сумма по чеку в копейках
     * @throws InternalFnsException
     * @throws IOException
     */
    public static boolean isCheckExist(String login, String password,
                                       String FN, String FD, String FPD,
                                       String date, String sum) throws InternalFnsException, IOException {
        String path = "/v1/ofds/*/inns/*/fss/" + FN + "/operations/1/tickets/" + FD;
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("fiscalSign", FPD));
        params.add(new BasicNameValuePair("date", date));
        params.add(new BasicNameValuePair("sum", sum));
        HttpGet get = createGet(path, login, password, params);
        return httpclient.execute(get).getStatusLine().getStatusCode() == 204;
    }

    /**
     * Проверит существование чека в базе ФНС.
     *
     * @param qr       расшифрованный qr код с чека
     * @param login    телефон пользователя в формате "+79161234567"
     * @param password пароль пользователя
     * @throws InternalFnsException
     * @throws IOException
     */
    public static boolean isCheckExist(String qr, String login, String password) throws IOException, InternalFnsException {

        qr = qr.replaceAll("&", "\n");
        ByteArrayInputStream stream = new ByteArrayInputStream(qr.getBytes());
        Properties properties = new Properties();
        properties.load(stream);
        checkProperties(properties, "fn", "i", "fp", "t", "s");
        return isCheckExist(login, password, properties.getProperty("fn"),
                properties.getProperty("i"), properties.getProperty("fp"),
                properties.getProperty("t"), properties.getProperty("s").replaceAll(".", ""));


    }

    /**
     * Получить чек из фнс
     *
     * @param qr       qr код с чека
     * @param login    телефон пользователя в формате "+79161234567"
     * @param password
     * @return Чек полученный из ФНС
     * @throws IllegalArgumentException  если передана неверная qr строка
     * @throws IOException               Ошибки с сетью
     * @throws InternalFnsException      внутреняя ошибка
     * @throws UserDoesNotExistException пользоватлеь не найден
     * @throws CheckNotFoundException    чек с такими данными не найден
     */
    public static FnsCheck getCheck(String qr, String login, String password) throws CheckNotFoundException, InternalFnsException, UserDoesNotExistException, IOException {
        qr = qr.replaceAll("&", "\n");
        ByteArrayInputStream stream = new ByteArrayInputStream(qr.getBytes());
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return getCheck(login, password, properties.getProperty("fn"),
                properties.getProperty("i"), properties.getProperty("fp"),
                properties.getProperty("t"), properties.getProperty("s").replaceAll("\\.", ""));
    }

    /**
     * Получить чек из ФНС
     *
     * @param login    телефон пользователя в формате "+79161234567"
     * @param password
     * @param FN       Фискальный Номер
     * @param FD       Фискальный документ
     * @param FPD      Фискальный Признак Документа
     * @param date     дата в формате 2018-07-23T10:14:00
     * @param sum      итоговая сумма по чеку в копейках
     * @return
     * @throws IOException               Ошибки с сетью
     * @throws InternalFnsException      внутреняя ошибка
     * @throws UserDoesNotExistException пользоватлеь не найден
     * @throws CheckNotFoundException    чек с такими данными не найден
     */
    public static FnsCheck getCheck(String login, String password, String FN, String FD, String FPD, String date, String sum) throws IOException, InternalFnsException, UserDoesNotExistException, CheckNotFoundException {
        isCheckExist(login, password, FN, FD, FPD, date, sum);
        String path = "v1/inns/*/kkts/*/fss/" + FN + "/tickets/" + FD;
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("fiscalSign", FPD));
        params.add(new BasicNameValuePair("sendToEmail", "no"));
        createGet(path, login, password, params).getURI();
        HttpResponse response = httpclient.execute(createGet(path, login, password, params));
        if (response.getStatusLine().getStatusCode() != 200) {
            if (response.getStatusLine().getStatusCode() == 403) {
                throw new UserDoesNotExistException();
            } else if (response.getStatusLine().getStatusCode() == 406) {
                throw new CheckNotFoundException();
            } else {
                throw new IOException("Неизвестный код пришел от ФНС");

            }
        }
        InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
        FnsCheck check = new Gson().fromJson(reader, FnsCheck.class);
        reader.close();
        return check;

    }


    private static HttpGet createGet(String path, String login, String password, List<NameValuePair> params) throws InternalFnsException {
        try {
            if (params == null) {
                params = new ArrayList<>();
            }
            URI uri = createUri(path).addParameters(params).build();
            UsernamePasswordCredentials creds = new UsernamePasswordCredentials(login, password);
            HttpGet get = new HttpGet(uri);
            get.addHeader(new BasicScheme().authenticate(creds, get));
            addDefaultHeaders(get);
            return get;
        } catch (URISyntaxException e) {
            throw new InternalFnsException(e);
        } catch (AuthenticationException e) {
            throw new InternalFnsException(e);
        }

    }

    private static URIBuilder createUri(String path) {
        return new URIBuilder()
                .setScheme("https")
                .setHost("proverkacheka.nalog.ru")
                .setPort(9999)
                .setPath(path);
    }

    /**
     * Доба
     *
     * @param addTo
     */
    private static void addDefaultHeaders(HttpRequestBase addTo) {
        addTo.addHeader("Device-OS", "Adnroid 6.0");
        addTo.addHeader("Device-Id", "");
        addTo.addHeader("Version", "2");
        addTo.addHeader("Accept-Encoding", "gzip");
        addTo.addHeader("ClientVersion", "1.4.4.4");
    }

    private static void checkProperties(Properties prop, String... check) {
        for (String s : check
                ) {
            if (!prop.containsKey(s)) {
                throw new IllegalArgumentException("в qr строке не найден параметр" + s);
            }
        }
    }

}
