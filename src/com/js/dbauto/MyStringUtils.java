/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

/**
 *
 * @author Administrator
 */
public class MyStringUtils {
    
    public static void main(String[] args) {
        System.out.println("ss:"+lowFirstString("WWWWst"));
    }
    
    public static String lowFirstString(String s){
        return s.substring(0, 1).toLowerCase()+s.substring(1);
    }
    
    public static String UpperFirstString(String s){
        return s.substring(0, 1).toUpperCase()+s.substring(1);
    }
    
    
}
