import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Receipt {

    @SerializedName("ecashTotalSum")
    @Expose
    private int ecashTotalSum;
    @SerializedName("userInn")
    @Expose
    private String userInn;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("requestNumber")
    @Expose
    private int requestNumber;
    @SerializedName("provisionSum")
    @Expose
    private int provisionSum;
    @SerializedName("fiscalSign")
    @Expose
    private int fiscalSign;
    @SerializedName("fiscalDocumentNumber")
    @Expose
    private int fiscalDocumentNumber;
    @SerializedName("operationType")
    @Expose
    private int operationType;
    @SerializedName("taxationType")
    @Expose
    private int taxationType;
    @SerializedName("messageFiscalSign")
    @Expose
    private long messageFiscalSign;
    @SerializedName("fiscalDriveNumber")
    @Expose
    private String fiscalDriveNumber;
    @SerializedName("machineNumber")
    @Expose
    private String machineNumber;
    @SerializedName("cashTotalSum")
    @Expose
    private int cashTotalSum;
    @SerializedName("internetSign")
    @Expose
    private int internetSign;
    @SerializedName("shiftNumber")
    @Expose
    private int shiftNumber;
    @SerializedName("operator")
    @Expose
    private String operator;
    @SerializedName("retailPlace")
    @Expose
    private String retailPlace;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("ndsNo")
    @Expose
    private int ndsNo;
    @SerializedName("totalSum")
    @Expose
    private int totalSum;
    @SerializedName("fiscalDocumentFormatVer")
    @Expose
    private int fiscalDocumentFormatVer;
    @SerializedName("rawData")
    @Expose
    private String rawData;
    @SerializedName("prepaidSum")
    @Expose
    private int prepaidSum;
    @SerializedName("paymentAgentType")
    @Expose
    private int paymentAgentType;
    @SerializedName("sellerAddress")
    @Expose
    private String sellerAddress;
    @SerializedName("propertiesUser")
    @Expose
    private PropertiesUser propertiesUser;
    @SerializedName("fnsSite")
    @Expose
    private String fnsSite;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("receiptCode")
    @Expose
    private int receiptCode;
    @SerializedName("creditSum")
    @Expose
    private int creditSum;
    @SerializedName("kktRegId")
    @Expose
    private String kktRegId;
    @SerializedName("buyerAddress")
    @Expose
    private String buyerAddress;

    public int getEcashTotalSum() {
        return ecashTotalSum;
    }

    public void setEcashTotalSum(int ecashTotalSum) {
        this.ecashTotalSum = ecashTotalSum;
    }

    public String getUserInn() {
        return userInn;
    }

    public void setUserInn(String userInn) {
        this.userInn = userInn;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public int getProvisionSum() {
        return provisionSum;
    }

    public void setProvisionSum(int provisionSum) {
        this.provisionSum = provisionSum;
    }

    public int getFiscalSign() {
        return fiscalSign;
    }

    public void setFiscalSign(int fiscalSign) {
        this.fiscalSign = fiscalSign;
    }

    public int getFiscalDocumentNumber() {
        return fiscalDocumentNumber;
    }

    public void setFiscalDocumentNumber(int fiscalDocumentNumber) {
        this.fiscalDocumentNumber = fiscalDocumentNumber;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public int getTaxationType() {
        return taxationType;
    }

    public void setTaxationType(int taxationType) {
        this.taxationType = taxationType;
    }

    public long getMessageFiscalSign() {
        return messageFiscalSign;
    }

    public void setMessageFiscalSign(long messageFiscalSign) {
        this.messageFiscalSign = messageFiscalSign;
    }

    public String getFiscalDriveNumber() {
        return fiscalDriveNumber;
    }

    public void setFiscalDriveNumber(String fiscalDriveNumber) {
        this.fiscalDriveNumber = fiscalDriveNumber;
    }

    public String getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(String machineNumber) {
        this.machineNumber = machineNumber;
    }

    public int getCashTotalSum() {
        return cashTotalSum;
    }

    public void setCashTotalSum(int cashTotalSum) {
        this.cashTotalSum = cashTotalSum;
    }

    public int getInternetSign() {
        return internetSign;
    }

    public void setInternetSign(int internetSign) {
        this.internetSign = internetSign;
    }

    public int getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(int shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRetailPlace() {
        return retailPlace;
    }

    public void setRetailPlace(String retailPlace) {
        this.retailPlace = retailPlace;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getNdsNo() {
        return ndsNo;
    }

    public void setNdsNo(int ndsNo) {
        this.ndsNo = ndsNo;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getFiscalDocumentFormatVer() {
        return fiscalDocumentFormatVer;
    }

    public void setFiscalDocumentFormatVer(int fiscalDocumentFormatVer) {
        this.fiscalDocumentFormatVer = fiscalDocumentFormatVer;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public int getPrepaidSum() {
        return prepaidSum;
    }

    public void setPrepaidSum(int prepaidSum) {
        this.prepaidSum = prepaidSum;
    }

    public int getPaymentAgentType() {
        return paymentAgentType;
    }

    public void setPaymentAgentType(int paymentAgentType) {
        this.paymentAgentType = paymentAgentType;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public PropertiesUser getPropertiesUser() {
        return propertiesUser;
    }

    public void setPropertiesUser(PropertiesUser propertiesUser) {
        this.propertiesUser = propertiesUser;
    }

    public String getFnsSite() {
        return fnsSite;
    }

    public void setFnsSite(String fnsSite) {
        this.fnsSite = fnsSite;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(int receiptCode) {
        this.receiptCode = receiptCode;
    }

    public int getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(int creditSum) {
        this.creditSum = creditSum;
    }

    public String getKktRegId() {
        return kktRegId;
    }

    public void setKktRegId(String kktRegId) {
        this.kktRegId = kktRegId;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

}