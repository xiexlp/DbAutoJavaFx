package com.js.dbauto;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.List;

public class SqlVelocity {

    public  static VelocityEngine velocityEngine = new VelocityEngine();
   // public  static VelocityContext vcontext = new VelocityContext();

    public static String buildUpdateSql(BTableWrapper bTableWrapper,List<BFieldWrapper> selectFieldWrapperList, List<BFieldWrapper> conditionFieldWrapperList){
        StringBuffer sb = new StringBuffer("update ");
        sb.append(bTableWrapper.getTablename());
        int selectSize = selectFieldWrapperList.size();
        int conditionSize =conditionFieldWrapperList.size();
        //String selectTemplate ="set ${fieldname}=?, "
        String updateSql = "";
        sb.append(" set ");
        for(int i=0;i<selectSize;i++){
            BFieldWrapper bFieldWrapper= selectFieldWrapperList.get(i);
            sb.append("`").append(bFieldWrapper.getTableFieldName()).append("`").append("=?,");
        }
        StringBuffer sb2=new StringBuffer(sb.substring(0,sb.length()-1));
        System.out.println("condition Size:"+conditionSize);
        if(conditionSize>0){
            sb2.append(" where ");
            for(int i=0;i<conditionSize;i++){
                BFieldWrapper bFieldWrapper= conditionFieldWrapperList.get(i);
                System.out.println("condition field:"+bFieldWrapper.getTableFieldName());
                sb2.append("`").append(bFieldWrapper.getTableFieldName()).append("`").append("=? and");
            }
            updateSql=sb2.substring(0,sb2.length()-3);
        }else {
            updateSql = sb2.toString();
        }
        System.out.println("update sql:"+updateSql);
        return updateSql;
    }


    public static String buildIncSql(BTableWrapper bTableWrapper,List<BFieldWrapper> selectFieldWrapperList, List<BFieldWrapper> conditionFieldWrapperList){
        StringBuffer sb = new StringBuffer("update ");
        sb.append(bTableWrapper.getTablename());
        int selectSize = selectFieldWrapperList.size();
        int conditionSize =conditionFieldWrapperList.size();
        //String selectTemplate ="set ${fieldname}=?, "
        String updateSql = "";
        sb.append(" set ");
        for(int i=0;i<selectSize;i++){
            BFieldWrapper bFieldWrapper= selectFieldWrapperList.get(i);
            //update使用普通的，不能使用增量
            if(bFieldWrapper.getTableFieldName().equalsIgnoreCase("update_time")||bFieldWrapper.getTableFieldName().equalsIgnoreCase("create_time")){
                sb.append(bFieldWrapper.getTableFieldName()).append("=?,");
            //普通的使用inc,最好使用一个
            }else {
                sb.append(bFieldWrapper.getTableFieldName()).append("=").append(bFieldWrapper.getTableFieldName()).append("+?,");
            }
        }
        StringBuffer sb2=new StringBuffer(sb.substring(0,sb.length()-1));
        System.out.println("condition Size:"+conditionSize);
        if(conditionSize>0){
            sb2.append(" where ");
            for(int i=0;i<conditionSize;i++){
                BFieldWrapper bFieldWrapper= conditionFieldWrapperList.get(i);
                System.out.println("condition field:"+bFieldWrapper.getTableFieldName());
                sb2.append(bFieldWrapper.getTableFieldName()).append("=? and");
            }
            updateSql=sb2.substring(0,sb2.length()-3);
        }else {
            updateSql = sb2.toString();
        }
        System.out.println("update sql:"+updateSql);
        return updateSql;
    }


    public static String buildUpdateSet(BTableWrapper tableWrapper,List<BFieldWrapper> selectFieldWrapperList, List<BFieldWrapper> conditionFieldWrapperList){
        int selectSize = selectFieldWrapperList.size();
        int conditionSize =conditionFieldWrapperList.size();
        StringBuffer sb = new StringBuffer("");
        String template="p.set${javaType}(${index},${fieldname});\n";
        StringWriter writer = new StringWriter();
        for(int i=0;i<selectSize;i++){
            BFieldWrapper bFieldWrapper = selectFieldWrapperList.get(i);
            VelocityContext vcontext = new VelocityContext();
            vcontext.put("javaType",bFieldWrapper.getCapitalJavatype());
            vcontext.put("index",i+1);
            vcontext.put("fieldname",bFieldWrapper.getFieldname());
            velocityEngine.evaluate(vcontext,writer,"test",template);
            System.out.println("set statement:"+writer.toString());
            sb.append(writer.toString());
            writer = new StringWriter();
        }
        writer = new StringWriter();
        if(conditionSize>0){
            for(int i=0;i<conditionSize;i++){
                BFieldWrapper bFieldWrapper = conditionFieldWrapperList.get(i);
                VelocityContext vcontext = new VelocityContext();
                vcontext.put("javaType",bFieldWrapper.getCapitalJavatype());
                vcontext.put("index",selectSize+(i+1));
                vcontext.put("fieldname",bFieldWrapper.getFieldname());
                velocityEngine.evaluate(vcontext,writer,"test",template);
                System.out.println("set statement:"+writer.toString());
                sb.append(writer.toString());
                writer = new StringWriter();
            }
        }


        String updateSet = sb.toString();
        return updateSet;
    }


    public static String buildIncSet(BTableWrapper tableWrapper,List<BFieldWrapper> selectFieldWrapperList, List<BFieldWrapper> conditionFieldWrapperList){
        int selectSize = selectFieldWrapperList.size();
        int conditionSize =conditionFieldWrapperList.size();
        StringBuffer sb = new StringBuffer("");
        String template="p.set${javaType}(${index},${fieldname});\n";

        String incTemplate="p.set${javaType}(${index},${fieldname}Inc);\n";
        StringWriter writer = new StringWriter();
        for(int i=0;i<selectSize;i++){
            BFieldWrapper bFieldWrapper = selectFieldWrapperList.get(i);
            VelocityContext vcontext = new VelocityContext();
            vcontext.put("javaType",bFieldWrapper.getCapitalJavatype());
            vcontext.put("index",i+1);
            vcontext.put("fieldname",bFieldWrapper.getFieldname());
            if(bFieldWrapper.getFieldname().equalsIgnoreCase("updateTime")) {
                velocityEngine.evaluate(vcontext, writer, "test", template);
            }else {
                velocityEngine.evaluate(vcontext, writer, "test", incTemplate);
            }
            System.out.println("set statement:"+writer.toString());
            sb.append(writer.toString());
            writer = new StringWriter();
        }
        writer = new StringWriter();
        if(conditionSize>0){
            for(int i=0;i<conditionSize;i++){
                BFieldWrapper bFieldWrapper = conditionFieldWrapperList.get(i);
                VelocityContext vcontext = new VelocityContext();
                vcontext.put("javaType",bFieldWrapper.getCapitalJavatype());
                vcontext.put("index",selectSize+(i+1));
                vcontext.put("fieldname",bFieldWrapper.getFieldname());
                velocityEngine.evaluate(vcontext,writer,"test",template);
                System.out.println("set statement:"+writer.toString());
                sb.append(writer.toString());
                writer = new StringWriter();
            }
        }


        String updateSet = sb.toString();
        return updateSet;
    }

}
