package com.js.code.db;

//import com.js.code.Config;
import com.js.code.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    private static final String URL="jdbc:mysql://localhost:3306/"+ Config.DBNAME+"?useUnicode=true&amp;characterEncoding=utf8";
    private static final String NAME="root";
    private static final String PASSWORD="";

    //static Logger log = Logger.getLogger(DBUtil.class);

    static Connection conn=null;
    static {
        init();
    }

    public static void  init(){
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConn(String databaseName){
        try {
            String url ="jdbc:mysql://localhost:3306/"+ databaseName+"?useUnicode=true&amp;characterEncoding=utf8";
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            conn = DriverManager.getConnection(url, NAME, PASSWORD);
            return conn;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static Connection getConn() {
        return conn;
    }

    public static int exeSql(String sql){
        int r=0;
        try {
            //3.通过数据库的连接操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            r = stmt.executeUpdate(sql);//选择import java.sql.ResultSet;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    public static List<String> getTableList(String databasename){
        List<String> tablenameList = null;
        try {
            tablenameList = new ArrayList();
            conn = getConn(databasename);
            PreparedStatement p = conn.prepareStatement("show tables");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String tablename = r.getString(1);
                tablenameList.add(tablename);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tablenameList;
    }


    public static List<String> getFieldList(String databasename,String tablename){
        List<String> fieldnameList = null;
        try {
            fieldnameList = new ArrayList();
            conn = getConn(databasename);
            PreparedStatement p = conn.prepareStatement("desc "+tablename);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String fieldname = r.getString(1);
                fieldnameList.add(fieldname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fieldnameList;
    }

    public static List<String> getFieldList(String tablename){
        List<String> fieldnameList = null;
        try {
            fieldnameList = new ArrayList();
            PreparedStatement p = conn.prepareStatement("desc "+tablename);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String fieldname = r.getString(1);
                fieldnameList.add(fieldname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fieldnameList;
    }

    public static List<String> getFieldNotPrimaryKeyList(String databasename,String tablename){
        List<String> fieldnameList = null;
        try {
            fieldnameList = new ArrayList();
            conn = getConn(databasename);
            PreparedStatement p = conn.prepareStatement("desc "+tablename);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String fieldname = r.getString(1);
                String primaryLabel = r.getString(4);
                //System.out.println("fieldname:"+fieldname+" primaryLabel:"+primaryLabel);
                if(primaryLabel!=null&&primaryLabel.equalsIgnoreCase("PRI")){
                    //System.out.println("is primary key");
                }else {
                    fieldnameList.add(fieldname);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fieldnameList;
    }

    public static List<String> getFieldNotPrimaryKeyList(String tablename){
        List<String> fieldnameList = null;
        try {
            fieldnameList = new ArrayList();
            PreparedStatement p = conn.prepareStatement("desc "+tablename);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String fieldname = r.getString(1);
                String primaryLabel = r.getString(4);
                //System.out.println("fieldname:"+fieldname+" primaryLabel:"+primaryLabel);
                if(primaryLabel!=null&&primaryLabel.equalsIgnoreCase("PRI")){
                    //System.out.println("is primary key");
                }else {
                    fieldnameList.add(fieldname);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fieldnameList;
    }


    public static void main(String[] args) throws Exception{
        getFieldNotPrimaryKeyList("js_action");
    }
}