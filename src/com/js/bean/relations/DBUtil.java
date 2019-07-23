package com.js.bean.relations;

 import com.js.common.db.DbUtils;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.Statement;

/**
 * 使用原生态的JDBC
 */
public class DBUtil {

     //private static final String URL="jdbc:mysql://localhost:3306/ishop?useUnicode=true&amp;characterEncoding=utf8";
      private static final String URL="jdbc:mysql://localhost:"+com.js.code.Config.PORT+"/"+com.js.code.Config.DBNAME+"?useUnicode=true&amp;characterEncoding=utf8";
     private static final String NAME="root";
     private static final String PASSWORD="";

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

    public static int exeSql(String databasename,String sql){
        System.out.println("需要执行的语句:"+sql);

        int r=0;
        try {
            conn = getConn(databasename);
            //3.通过数据库的连接操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            r = stmt.executeUpdate(sql);//选择import java.sql.ResultSet;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    public static long exeBatchSql(String databasename,String sql){
        System.out.println("需要执行的语句:"+sql);

        long r=0;
        try {
            conn = getConn(databasename);
            //3.通过数据库的连接操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            r = stmt.executeLargeUpdate(sql);//选择import java.sql.ResultSet;
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }


     public static int exeSql(String sql){
         System.out.println("需要执行的语句:"+sql);

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


    public static boolean validateTableNameExist(String tableName) {
       try {
           //Connection con = getYourCnnection;
           ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null);
           if (rs.next()) {
               return true;
           }else {
               return false;
           }
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }

    public static boolean validateTableNameExist(String databasename,String tableName) {
        try {
            //Connection con = getYourCnnection;
            conn = getConn(databasename);
            ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null);
            if (rs.next()) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws Exception{
        String mulSql = "CREATE TABLE `ejf_role_action`\n" +
                "(\n" +
                "  `role_action_id` int(10)  PRIMARY KEY AUTO_INCREMENT ,\n" +
                "  `role_id` int(10) not null   default 0,\n" +
                "  `role_name` varchar(60) not null  default '',\n" +
                "  `action_id` int(10) not null   default 0,\n" +
                "  `action_name` varchar(60) not null  default '',\n" +
                "  `create_time` bigint(20) default 0 not null,\n" +
                "  `update_time` bigint(20) default 0 not null,\n" +
                "  `end_time` bigint(20) default 0 not null,\n" +
                "  `status` tinyint(1) not null default 0\n" +
                ")ENGINE=MyISAM DEFAULT CHARSET=utf8; \n create index role_id_index  on ejf_role_action(role_id);\n" +
                " create index action_id_index  on ejf_role_action(action_id);";

        //这条语句还是不能执行
        DBUtil.exeBatchSql("iforum",mulSql);

     }
 }