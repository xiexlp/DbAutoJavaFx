package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-09 17:08:14"
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomerEx{


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int customerId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int customerGroupId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String groupName;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int storeId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int languageId;


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


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 255)
    private String password;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 9)
    private String salt;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String cart;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String wishlist;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int newsletter;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int addressId;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String customField;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 40)
    private String ip;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;


    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int safe;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String token;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 40)
    private String code;


    @TableFieldType(fieldType = TableFieldType.TYPE.DATETIME)
    private Timestamp dateAdded;


    Map<String,Object> map=null;

    public CustomerEx(){}

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
    public int getStoreId(){
        return storeId;
    }

    public void setStoreId(int storeId){
        this.storeId = storeId;
    }
    public int getLanguageId(){
        return languageId;
    }

    public void setLanguageId(int languageId){
        this.languageId = languageId;
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
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getSalt(){
        return salt;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }
    public String getCart(){
        return cart;
    }

    public void setCart(String cart){
        this.cart = cart;
    }
    public String getWishlist(){
        return wishlist;
    }

    public void setWishlist(String wishlist){
        this.wishlist = wishlist;
    }
    public int getNewsletter(){
        return newsletter;
    }

    public void setNewsletter(int newsletter){
        this.newsletter = newsletter;
    }
    public int getAddressId(){
        return addressId;
    }

    public void setAddressId(int addressId){
        this.addressId = addressId;
    }
    public String getCustomField(){
        return customField;
    }

    public void setCustomField(String customField){
        this.customField = customField;
    }
    public String getIp(){
        return ip;
    }

    public void setIp(String ip){
        this.ip = ip;
    }
    public int getStatus(){
        return status;
    }

    public void setStatus(int status){
        this.status = status;
    }
    public int getSafe(){
        return safe;
    }

    public void setSafe(int safe){
        this.safe = safe;
    }
    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }
    public Timestamp getDateAdded(){
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded){
        this.dateAdded = dateAdded;
    }

    public Map toMap(){
        if(map==null){
            map = new HashMap();
            map.put("customer_id",this.getCustomerId());
            map.put("customer_group_id",this.getCustomerGroupId());
            map.put("store_id",this.getStoreId());
            map.put("language_id",this.getLanguageId());
            map.put("fullname",this.getFullname());
            map.put("email",this.getEmail());
            map.put("telephone",this.getTelephone());
            map.put("fax",this.getFax());
            map.put("password",this.getPassword());
            map.put("salt",this.getSalt());
            map.put("cart",this.getCart());
            map.put("wishlist",this.getWishlist());
            map.put("newsletter",this.getNewsletter());
            map.put("address_id",this.getAddressId());
            map.put("custom_field",this.getCustomField());
            map.put("ip",this.getIp());
            map.put("status",this.getStatus());
            map.put("safe",this.getSafe());
            map.put("token",this.getToken());
            map.put("code",this.getCode());
            map.put("date_added",this.getDateAdded());
        }
        return map;
    }


}