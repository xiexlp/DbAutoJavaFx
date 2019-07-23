/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

import java.util.StringTokenizer;

/**
 *
 * @author Administrator
 */
public class StringUtil {
    
    public static void main(String[] args) {
        String tablename="cart_user_comment";
        String tablename_org = getTablenameOrg(tablename);
        String tablename_hump = getTableNameHump(tablename);
        System.out.println("tablename_hump:"+tablename_hump);
        System.out.println("tablename_org:"+tablename_org);
    }

    public static Character getLetterByIndex(int index){
        int char1=65+index;
        char c1= (char)char1;
        return Character.toUpperCase(c1);
    }
    
    
    public  static String getBeanname(String tablename){
        int index= tablename.indexOf("_");
        String tablename_org="";
        if(index>0){
            tablename_org= tablename.substring(index+1);
            int ind = tablename_org.indexOf("_");
            if(ind>0){
                tablename_org = tablename_org.replace("_", "");
            }
        }
        return  capital(tablename_org);
    }
    
    public static String capital(String str){
        String s = str.substring(0, 1).toUpperCase();
        return new StringBuffer(s).append(str.substring(1)).toString();
    }

    /**
     * 表名到对象名
     * @param tablename
     * @return
     */
    public static String getTablenameOrg(String tablename){
        int index= tablename.indexOf("_");
        String tablename_org="";
        if(index>0){
            tablename_org= tablename.substring(index+1);
            int ind = tablename_org.indexOf("_");
            if(ind>0){
                tablename_org = tablename_org.replace("_", "");
            }
        }
        else tablename_org = tablename;
        return tablename_org;
    }

    public static String getTableNameHump(String tablenamme){
        int index = tablenamme.indexOf("_");
        String tableNameOffPrefix = tablenamme.substring(index+1,tablenamme.length());

        StringTokenizer st = new StringTokenizer(tableNameOffPrefix,"_");
        StringBuffer sb=new StringBuffer();
        while (st.hasMoreTokens()){
            sb.append(MyStringUtils.UpperFirstString(st.nextToken()));
        }
        return sb.toString();
    }
    
}
