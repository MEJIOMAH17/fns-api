package com.github.mejiomah17.fns.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Receipt {

    @SerializedName("ecashTotalSum")
    @Expose
    private long ecashTotalSum;
    @SerializedName("userInn")
    @Expose
    private String userInn;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("requestNumber")
    @Expose
    private long requestNumber;
    @SerializedName("provisionSum")
    @Expose
    private long provisionSum;
    @SerializedName("fiscalSign")
    @Expose
    private long fiscalSign;
    @SerializedName("fiscalDocumentNumber")
    @Expose
    private long fiscalDocumentNumber;
    @SerializedName("operationType")
    @Expose
    private long operationType;
    @SerializedName("taxationType")
    @Expose
    private long taxationType;
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
    private long cashTotalSum;
    @SerializedName("longernetSign")
    @Expose
    private long longernetSign;
    @SerializedName("shiftNumber")
    @Expose
    private long shiftNumber;
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
    private long ndsNo;
    @SerializedName("totalSum")
    @Expose
    private long totalSum;
    @SerializedName("fiscalDocumentFormatVer")
    @Expose
    private long fiscalDocumentFormatVer;
    @SerializedName("rawData")
    @Expose
    private String rawData;
    @SerializedName("prepaidSum")
    @Expose
    private long prepaidSum;
    @SerializedName("paymentAgentType")
    @Expose
    private long paymentAgentType;
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
    private long receiptCode;
    @SerializedName("creditSum")
    @Expose
    private long creditSum;
    @SerializedName("kktRegId")
    @Expose
    private String kktRegId;
    @SerializedName("buyerAddress")
    @Expose
    private String buyerAddress;

    public long getEcashTotalSum() {
        return ecashTotalSum;
    }

    public void setEcashTotalSum(long ecashTotalSum) {
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

    public long getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(long requestNumber) {
        this.requestNumber = requestNumber;
    }

    public long getProvisionSum() {
        return provisionSum;
    }

    public void setProvisionSum(long provisionSum) {
        this.provisionSum = provisionSum;
    }

    public long getFiscalSign() {
        return fiscalSign;
    }

    public void setFiscalSign(long fiscalSign) {
        this.fiscalSign = fiscalSign;
    }

    public long getFiscalDocumentNumber() {
        return fiscalDocumentNumber;
    }

    public void setFiscalDocumentNumber(long fiscalDocumentNumber) {
        this.fiscalDocumentNumber = fiscalDocumentNumber;
    }

    public long getOperationType() {
        return operationType;
    }

    public void setOperationType(long operationType) {
        this.operationType = operationType;
    }

    public long getTaxationType() {
        return taxationType;
    }

    public void setTaxationType(long taxationType) {
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

    public long getCashTotalSum() {
        return cashTotalSum;
    }

    public void setCashTotalSum(long cashTotalSum) {
        this.cashTotalSum = cashTotalSum;
    }

    public long getlongernetSign() {
        return longernetSign;
    }

    public void setlongernetSign(long longernetSign) {
        this.longernetSign = longernetSign;
    }

    public long getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(long shiftNumber) {
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

    public long getNdsNo() {
        return ndsNo;
    }

    public void setNdsNo(long ndsNo) {
        this.ndsNo = ndsNo;
    }

    public long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(long totalSum) {
        this.totalSum = totalSum;
    }

    public long getFiscalDocumentFormatVer() {
        return fiscalDocumentFormatVer;
    }

    public void setFiscalDocumentFormatVer(long fiscalDocumentFormatVer) {
        this.fiscalDocumentFormatVer = fiscalDocumentFormatVer;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public long getPrepaidSum() {
        return prepaidSum;
    }

    public void setPrepaidSum(long prepaidSum) {
        this.prepaidSum = prepaidSum;
    }

    public long getPaymentAgentType() {
        return paymentAgentType;
    }

    public void setPaymentAgentType(long paymentAgentType) {
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

    public long getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(long receiptCode) {
        this.receiptCode = receiptCode;
    }

    public long getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(long creditSum) {
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