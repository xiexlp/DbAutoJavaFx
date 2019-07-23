package com.js.cms.ishop.ormex;

/**
 * last update time:"18-06-08 17:43:56"
 * last update user:pku
 */

import com.js.common.anno.AutoIncrement;
import com.js.common.anno.PrimaryKey;
import com.js.common.anno.TableField;
import com.js.common.anno.TableFieldType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class AddressEx{


    @PrimaryKey
    @AutoIncrement
    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int addressId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int customerId;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 64)
    private String fullname;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 32)
    private String telephone;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 60)
    private String company;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 128)
    private String address1;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 128)
    private String address2;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 128)
    private String city;


    @TableFieldType(fieldType = TableFieldType.TYPE.VARCHAR)
    @TableField(len = 10)
    private String postcode;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int countryId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int zoneId;


    @TableFieldType(fieldType = TableFieldType.TYPE.TEXT)
    private String customField;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int cityId;


    @TableFieldType(fieldType = TableFieldType.TYPE.INT)
    @TableField(len = 11)
    private int countyId;

    @TableFieldType(fieldType = TableFieldType.TYPE.TINYINT)
    @TableField(len = 1)
    private int status;




    Map<String,Object> map=null;

    public AddressEx(){}

    public int getAddressId(){
        return addressId;
    }

    public void setAddressId(int addressId){
        this.addressId = addressId;
    }
    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public String getFullname(){
        return fullname;
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public String getCompany(){
        return company;
    }

    public void setCompany(String company){
        this.company = company;
    }
    public String getAddress1(){
        return address1;
    }

    public void setAddress1(String address1){
        this.address1 = address1;
    }
    public String getAddress2(){
        return address2;
    }

    public void setAddress2(String address2){
        this.address2 = address2;
    }
    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String getPostcode(){
        return postcode;
    }

    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    public int getCountryId(){
        return countryId;
    }

    public void setCountryId(int countryId){
        this.countryId = countryId;
    }
    public int getZoneId(){
        return zoneId;
    }

    public void setZoneId(int zoneId){
        this.zoneId = zoneId;
    }
    public String getCustomField(){
        return customField;
    }

    public void setCustomField(String customField){
        this.customField = customField;
    }
    public int getCityId(){
        return cityId;
    }

    public void setCityId(int cityId){
        this.cityId = cityId;
    }
    public int getCountyId(){
        return countyId;
    }

    public void setCountyId(int countyId){
        this.countyId = countyId;
    }

    public Map toMap(){
        if(map==null){
            map = new HashMap();
            map.put("address_id",this.getAddressId());
            map.put("customer_id",this.getCustomerId());
            map.put("fullname",this.getFullname());
            map.put("telephone",this.getTelephone());
            map.put("company",this.getCompany());
            map.put("address_1",this.getAddress1());
            map.put("address_2",this.getAddress2());
            map.put("city",this.getCity());
            map.put("postcode",this.getPostcode());
            map.put("country_id",this.getCountryId());
            map.put("zone_id",this.getZoneId());
            map.put("custom_field",this.getCustomField());
            map.put("city_id",this.getCityId());
            map.put("county_id",this.getCountyId());
        }
        return map;
    }


}