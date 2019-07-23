package com.js.cms.ishop.ormex;

/**
* last update time:"18-06-08 17:22:45"
* last update user:pku
*/
import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class OrderEx{


@PrimaryKey
@AutoIncrement
@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderId;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int invoiceNo;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 26)
private String invoicePrefix;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int storeId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String storeName;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String storeUrl;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 20)
private int customerId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int customerAccountId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private int customerName;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int sellerId;

    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int sellerAccountId;

    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private int sellerName;



@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int customerGroupId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String fullname;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 96)
private String email;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String telephone;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String fax;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String customField;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String paymentFullname;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String paymentTelephone;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 60)
private String paymentCompany;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String paymentAddress1;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String paymentAddress2;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String paymentCity;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int paymentCityId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 10)
private String paymentPostcode;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String paymentCountry;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int paymentCountryId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String paymentZone;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int paymentZoneId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String paymentCounty;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int paymentCountyId;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String paymentAddressFormat;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String paymentCustomField;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String paymentMethod;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String paymentCode;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String shippingFullname;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 32)
private String shippingTelephone;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 60)
private String shippingCompany;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String shippingAddress1;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String shippingAddress2;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String shippingCity;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int shippingCityId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 10)
private String shippingPostcode;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String shippingCountry;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int shippingCountryId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String shippingZone;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int shippingZoneId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String shippingCounty;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int shippingCountyId;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String shippingAddressFormat;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String shippingCustomField;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String shippingMethod;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 128)
private String shippingCode;


@TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
private String comment;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double total;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int orderStatusId;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 2)
    private int orderStatus;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int affiliateId;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double commission;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int marketingId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 64)
private String tracking;


@TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int languageId;

    /**
     * 使用的货币,没问题
     */
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
@TableField(len = 11)
private int currencyId;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 3)
private String currencyCode;


@TableFieldType(fieldType = TableFieldType.TYPE.DECIMAL)
@TableField(len = 15)
private double currencyValue;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 40)
private String ip;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 40)
private String forwardedIp;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String userAgent;


@TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
@TableField(len = 255)
private String acceptLanguage;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateAdded;


@TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
private Timestamp dateModified;


Map<String,Object> map=null;

public OrderEx(){}

public int getOrderId(){
return orderId;
}

public void setOrderId(int orderId){
this.orderId = orderId;
}
public int getInvoiceNo(){
return invoiceNo;
}

public void setInvoiceNo(int invoiceNo){
this.invoiceNo = invoiceNo;
}
public String getInvoicePrefix(){
return invoicePrefix;
}

public void setInvoicePrefix(String invoicePrefix){
this.invoicePrefix = invoicePrefix;
}
public int getStoreId(){
return storeId;
}

public void setStoreId(int storeId){
this.storeId = storeId;
}
public String getStoreName(){
return storeName;
}

public void setStoreName(String storeName){
this.storeName = storeName;
}
public String getStoreUrl(){
return storeUrl;
}

public void setStoreUrl(String storeUrl){
this.storeUrl = storeUrl;
}
public int getCustomerId(){
return customerId;
}

public void setCustomerId(int customerId){
this.customerId = customerId;
}
public int getCustomerGroupId(){
return customerGroupId;
}

public void setCustomerGroupId(int customerGroupId){
this.customerGroupId = customerGroupId;
}
public String getFullname(){
return fullname;
}

public void setFullname(String fullname){
this.fullname = fullname;
}
public String getEmail(){
return email;
}

public void setEmail(String email){
this.email = email;
}
public String getTelephone(){
return telephone;
}

public void setTelephone(String telephone){
this.telephone = telephone;
}
public String getFax(){
return fax;
}

public void setFax(String fax){
this.fax = fax;
}
public String getCustomField(){
return customField;
}

public void setCustomField(String customField){
this.customField = customField;
}
public String getPaymentFullname(){
return paymentFullname;
}

public void setPaymentFullname(String paymentFullname){
this.paymentFullname = paymentFullname;
}
public String getPaymentTelephone(){
return paymentTelephone;
}

public void setPaymentTelephone(String paymentTelephone){
this.paymentTelephone = paymentTelephone;
}
public String getPaymentCompany(){
return paymentCompany;
}

public void setPaymentCompany(String paymentCompany){
this.paymentCompany = paymentCompany;
}
public String getPaymentAddress1(){
return paymentAddress1;
}

public void setPaymentAddress1(String paymentAddress1){
this.paymentAddress1 = paymentAddress1;
}
public String getPaymentAddress2(){
return paymentAddress2;
}

public void setPaymentAddress2(String paymentAddress2){
this.paymentAddress2 = paymentAddress2;
}
public String getPaymentCity(){
return paymentCity;
}

public void setPaymentCity(String paymentCity){
this.paymentCity = paymentCity;
}
public int getPaymentCityId(){
return paymentCityId;
}

public void setPaymentCityId(int paymentCityId){
this.paymentCityId = paymentCityId;
}
public String getPaymentPostcode(){
return paymentPostcode;
}

public void setPaymentPostcode(String paymentPostcode){
this.paymentPostcode = paymentPostcode;
}
public String getPaymentCountry(){
return paymentCountry;
}

public void setPaymentCountry(String paymentCountry){
this.paymentCountry = paymentCountry;
}
public int getPaymentCountryId(){
return paymentCountryId;
}

public void setPaymentCountryId(int paymentCountryId){
this.paymentCountryId = paymentCountryId;
}
public String getPaymentZone(){
return paymentZone;
}

public void setPaymentZone(String paymentZone){
this.paymentZone = paymentZone;
}
public int getPaymentZoneId(){
return paymentZoneId;
}

public void setPaymentZoneId(int paymentZoneId){
this.paymentZoneId = paymentZoneId;
}
public String getPaymentCounty(){
return paymentCounty;
}

public void setPaymentCounty(String paymentCounty){
this.paymentCounty = paymentCounty;
}
public int getPaymentCountyId(){
return paymentCountyId;
}

public void setPaymentCountyId(int paymentCountyId){
this.paymentCountyId = paymentCountyId;
}
public String getPaymentAddressFormat(){
return paymentAddressFormat;
}

public void setPaymentAddressFormat(String paymentAddressFormat){
this.paymentAddressFormat = paymentAddressFormat;
}
public String getPaymentCustomField(){
return paymentCustomField;
}

public void setPaymentCustomField(String paymentCustomField){
this.paymentCustomField = paymentCustomField;
}
public String getPaymentMethod(){
return paymentMethod;
}

public void setPaymentMethod(String paymentMethod){
this.paymentMethod = paymentMethod;
}
public String getPaymentCode(){
return paymentCode;
}

public void setPaymentCode(String paymentCode){
this.paymentCode = paymentCode;
}
public String getShippingFullname(){
return shippingFullname;
}

public void setShippingFullname(String shippingFullname){
this.shippingFullname = shippingFullname;
}
public String getShippingTelephone(){
return shippingTelephone;
}

public void setShippingTelephone(String shippingTelephone){
this.shippingTelephone = shippingTelephone;
}
public String getShippingCompany(){
return shippingCompany;
}

public void setShippingCompany(String shippingCompany){
this.shippingCompany = shippingCompany;
}
public String getShippingAddress1(){
return shippingAddress1;
}

public void setShippingAddress1(String shippingAddress1){
this.shippingAddress1 = shippingAddress1;
}
public String getShippingAddress2(){
return shippingAddress2;
}

public void setShippingAddress2(String shippingAddress2){
this.shippingAddress2 = shippingAddress2;
}
public String getShippingCity(){
return shippingCity;
}

public void setShippingCity(String shippingCity){
this.shippingCity = shippingCity;
}
public int getShippingCityId(){
return shippingCityId;
}

public void setShippingCityId(int shippingCityId){
this.shippingCityId = shippingCityId;
}
public String getShippingPostcode(){
return shippingPostcode;
}

public void setShippingPostcode(String shippingPostcode){
this.shippingPostcode = shippingPostcode;
}
public String getShippingCountry(){
return shippingCountry;
}

public void setShippingCountry(String shippingCountry){
this.shippingCountry = shippingCountry;
}
public int getShippingCountryId(){
return shippingCountryId;
}

public void setShippingCountryId(int shippingCountryId){
this.shippingCountryId = shippingCountryId;
}
public String getShippingZone(){
return shippingZone;
}

public void setShippingZone(String shippingZone){
this.shippingZone = shippingZone;
}
public int getShippingZoneId(){
return shippingZoneId;
}

public void setShippingZoneId(int shippingZoneId){
this.shippingZoneId = shippingZoneId;
}
public String getShippingCounty(){
return shippingCounty;
}

public void setShippingCounty(String shippingCounty){
this.shippingCounty = shippingCounty;
}
public int getShippingCountyId(){
return shippingCountyId;
}

public void setShippingCountyId(int shippingCountyId){
this.shippingCountyId = shippingCountyId;
}
public String getShippingAddressFormat(){
return shippingAddressFormat;
}

public void setShippingAddressFormat(String shippingAddressFormat){
this.shippingAddressFormat = shippingAddressFormat;
}
public String getShippingCustomField(){
return shippingCustomField;
}

public void setShippingCustomField(String shippingCustomField){
this.shippingCustomField = shippingCustomField;
}
public String getShippingMethod(){
return shippingMethod;
}

public void setShippingMethod(String shippingMethod){
this.shippingMethod = shippingMethod;
}
public String getShippingCode(){
return shippingCode;
}

public void setShippingCode(String shippingCode){
this.shippingCode = shippingCode;
}
public String getComment(){
return comment;
}

public void setComment(String comment){
this.comment = comment;
}
public double getTotal(){
return total;
}

public void setTotal(double total){
this.total = total;
}
public int getOrderStatusId(){
return orderStatusId;
}

public void setOrderStatusId(int orderStatusId){
this.orderStatusId = orderStatusId;
}
public int getAffiliateId(){
return affiliateId;
}

public void setAffiliateId(int affiliateId){
this.affiliateId = affiliateId;
}
public double getCommission(){
return commission;
}

public void setCommission(double commission){
this.commission = commission;
}
public int getMarketingId(){
return marketingId;
}

public void setMarketingId(int marketingId){
this.marketingId = marketingId;
}
public String getTracking(){
return tracking;
}

public void setTracking(String tracking){
this.tracking = tracking;
}
public int getLanguageId(){
return languageId;
}

public void setLanguageId(int languageId){
this.languageId = languageId;
}
public int getCurrencyId(){
return currencyId;
}

public void setCurrencyId(int currencyId){
this.currencyId = currencyId;
}
public String getCurrencyCode(){
return currencyCode;
}

public void setCurrencyCode(String currencyCode){
this.currencyCode = currencyCode;
}
public double getCurrencyValue(){
return currencyValue;
}

public void setCurrencyValue(double currencyValue){
this.currencyValue = currencyValue;
}
public String getIp(){
return ip;
}

public void setIp(String ip){
this.ip = ip;
}
public String getForwardedIp(){
return forwardedIp;
}

public void setForwardedIp(String forwardedIp){
this.forwardedIp = forwardedIp;
}
public String getUserAgent(){
return userAgent;
}

public void setUserAgent(String userAgent){
this.userAgent = userAgent;
}
public String getAcceptLanguage(){
return acceptLanguage;
}

public void setAcceptLanguage(String acceptLanguage){
this.acceptLanguage = acceptLanguage;
}
public Timestamp getDateAdded(){
return dateAdded;
}

public void setDateAdded(Timestamp dateAdded){
this.dateAdded = dateAdded;
}
public Timestamp getDateModified(){
return dateModified;
}

public void setDateModified(Timestamp dateModified){
this.dateModified = dateModified;
}

public Map toMap(){
if(map==null){
    map = new HashMap();
        map.put("order_id",this.getOrderId());
        map.put("invoice_no",this.getInvoiceNo());
        map.put("invoice_prefix",this.getInvoicePrefix());
        map.put("store_id",this.getStoreId());
        map.put("store_name",this.getStoreName());
        map.put("store_url",this.getStoreUrl());
        map.put("customer_id",this.getCustomerId());
        map.put("customer_group_id",this.getCustomerGroupId());
        map.put("fullname",this.getFullname());
        map.put("email",this.getEmail());
        map.put("telephone",this.getTelephone());
        map.put("fax",this.getFax());
        map.put("custom_field",this.getCustomField());
        map.put("payment_fullname",this.getPaymentFullname());
        map.put("payment_telephone",this.getPaymentTelephone());
        map.put("payment_company",this.getPaymentCompany());
        map.put("payment_address_1",this.getPaymentAddress1());
        map.put("payment_address_2",this.getPaymentAddress2());
        map.put("payment_city",this.getPaymentCity());
        map.put("payment_city_id",this.getPaymentCityId());
        map.put("payment_postcode",this.getPaymentPostcode());
        map.put("payment_country",this.getPaymentCountry());
        map.put("payment_country_id",this.getPaymentCountryId());
        map.put("payment_zone",this.getPaymentZone());
        map.put("payment_zone_id",this.getPaymentZoneId());
        map.put("payment_county",this.getPaymentCounty());
        map.put("payment_county_id",this.getPaymentCountyId());
        map.put("payment_address_format",this.getPaymentAddressFormat());
        map.put("payment_custom_field",this.getPaymentCustomField());
        map.put("payment_method",this.getPaymentMethod());
        map.put("payment_code",this.getPaymentCode());
        map.put("shipping_fullname",this.getShippingFullname());
        map.put("shipping_telephone",this.getShippingTelephone());
        map.put("shipping_company",this.getShippingCompany());
        map.put("shipping_address_1",this.getShippingAddress1());
        map.put("shipping_address_2",this.getShippingAddress2());
        map.put("shipping_city",this.getShippingCity());
        map.put("shipping_city_id",this.getShippingCityId());
        map.put("shipping_postcode",this.getShippingPostcode());
        map.put("shipping_country",this.getShippingCountry());
        map.put("shipping_country_id",this.getShippingCountryId());
        map.put("shipping_zone",this.getShippingZone());
        map.put("shipping_zone_id",this.getShippingZoneId());
        map.put("shipping_county",this.getShippingCounty());
        map.put("shipping_county_id",this.getShippingCountyId());
        map.put("shipping_address_format",this.getShippingAddressFormat());
        map.put("shipping_custom_field",this.getShippingCustomField());
        map.put("shipping_method",this.getShippingMethod());
        map.put("shipping_code",this.getShippingCode());
        map.put("comment",this.getComment());
        map.put("total",this.getTotal());
        map.put("order_status_id",this.getOrderStatusId());
        map.put("affiliate_id",this.getAffiliateId());
        map.put("commission",this.getCommission());
        map.put("marketing_id",this.getMarketingId());
        map.put("tracking",this.getTracking());
        map.put("language_id",this.getLanguageId());
        map.put("currency_id",this.getCurrencyId());
        map.put("currency_code",this.getCurrencyCode());
        map.put("currency_value",this.getCurrencyValue());
        map.put("ip",this.getIp());
        map.put("forwarded_ip",this.getForwardedIp());
        map.put("user_agent",this.getUserAgent());
        map.put("accept_language",this.getAcceptLanguage());
        map.put("date_added",this.getDateAdded());
        map.put("date_modified",this.getDateModified());
    }
return map;
}


}