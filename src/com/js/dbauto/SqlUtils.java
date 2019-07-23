package com.js.dbauto;


import java.util.List;

public class SqlUtils {

    SQLAndParam sqlAndParam;
    static String prefix="a";

    public static String getFindComplexSql(String tablename,List<String> selectNameList,List<Condition> conditionList,List<OrderBy> orderByList,String isPageable){
        //BTableWrapper bTableWrapper = sqlAndParam.getbTableWrapper();
       String sql = "select "+ buildFieldNameListWithPrefix(selectNameList)+" from "+tablename+" as "+prefix+buildConditionsWithPrefix(conditionList)+buildOrderBysWithPrefix(orderByList)+buildLimit(isPageable);
       return sql;
    }

    private static  String buildFieldNameListWithPrefix(List<String> fieldNameList){
        int size = fieldNameList.size();
        StringBuffer sb = new StringBuffer();
        if(size>=1) {
            for (int i = 0;i<size;i++ ){
                String fieldname = fieldNameList.get(i);
                sb.append(prefix).append(".").append(fieldname).append(",");
            }
        }
        String resultFieldList = sb.substring(0,sb.length()-1);
        return  resultFieldList;
    }

    private static  String buildFieldNameList(List<String> fieldNameList){
        int size = fieldNameList.size();
        StringBuffer sb = new StringBuffer();
        if(size>=1) {
            for (int i = 0;i<size;i++ ){
                String fieldname = fieldNameList.get(i);
                sb.append(fieldname).append(",");
            }
        }
        String resultFieldList = sb.substring(0,sb.length()-1);
        return  resultFieldList;
    }

    /***
     * 构造条件语句
     * @param conditions
     * @return
     */
    private static String buildConditions(List<Condition> conditions){
        StringBuffer sb = new StringBuffer(" where ");
        int size = conditions.size();
        if(size>=1){
            for(int i=0;i<size;i++){
                Condition condition= conditions.get(i);
                sb.append(condition.getTablefieldname()).append(condition.getOperator()).append("? and ");
            }
        }
        sb.append(" 1=1 ");
        return sb.toString();
    }

    /***
     * 构造条件语句
     * @param conditions
     * @return
     */
    private static String buildConditionsWithPrefix(List<Condition> conditions){
        StringBuffer sb = new StringBuffer(" where ");
        int size = conditions.size();
        if(size>=1){
            for(int i=0;i<size;i++){
                Condition condition= conditions.get(i);
                sb.append(prefix).append(".").append(condition.getTablefieldname()).append(condition.getOperator()).append("? and ");
            }
        }
        sb.append(" 1=1 ");
        return sb.toString();
    }


    /**
     * 得到order 语句 如 order by create_time ase,update_time desc
     * @param orders
     * @return
     */
    private static String buildOrderBys(List<OrderBy> orders){
        StringBuffer sb = new StringBuffer("");
        String orderByStat=" ";
        int size = orders.size();
        if(size>=1){
            sb.append(" order by ");
            for(int i=0;i<size;i++){
                OrderBy orderBy= orders.get(i);
                sb.append(StringTool.humpToUnderLine(orderBy.getFieldname())).append(" ").append(orderBy.getOrder()).append(",");
            }
            orderByStat = sb.substring(0,sb.length()-1);
        }

        return orderByStat;
    }

    /**
     * 得到order 语句 如 order by create_time ase,update_time desc
     * @param orders
     * @return
     */
    private static String buildOrderBysWithPrefix(List<OrderBy> orders){
        StringBuffer sb = new StringBuffer("");
        String orderByStat=" ";
        int size = orders.size();
        if(size>=1){
            sb.append(" order by ");
            for(int i=0;i<size;i++){
                OrderBy orderBy= orders.get(i);
                sb.append(prefix).append(".").append(StringTool.humpToUnderLine(orderBy.getFieldname())).append(" ").append(orderBy.getOrder()).append(",");
            }
            orderByStat = sb.substring(0,sb.length()-1);
        }

        return orderByStat;
    }

    /**
     * 构造 limit语句 如 limit ?,?,如果不分页，则为空
     * @param isPageable
     * @return
     */
    private static String buildLimit(String isPageable){
        StringBuffer sb = new StringBuffer();
        //分页
        if(isPageable.equalsIgnoreCase("Pageable")){
            sb.append(" limit ?,?");
        }else {
        }
        return sb.toString();
    }


    //type =0 List<bean> type=1 List<Type>

    /**
     * 构造语句的参数设置部分如 p.setObject(1,userId);
     * @param tableWrapper
     * @param conditions
     * @param isPageable
     * @return
     */
    public static String getFindComplexSqlParam(BTableWrapper tableWrapper,List<Condition> conditions,String isPageable){
        int size = conditions.size();
        String selectSqlSetParam="";
            for (int i = 0; i < size; i++) {
                int index = i + 1;
                Condition condition = conditions.get(i);
                String fieldname = condition.getTablefieldname();
                String keyname = StringTool.underLineToHump(fieldname);
                BFieldWrapper bFieldWrapper = tableWrapper.getbFieldWrapperMap().get(keyname);
                selectSqlSetParam+="p.set"+"Object"+"("+index+","+keyname+");\n";
            }
            //分页
            if(isPageable.equalsIgnoreCase("Pageable")){
                selectSqlSetParam+="p.set"+"Int"+"("+(size+1)+",list.getOffset());\n";
                selectSqlSetParam+="p.set"+"Int"+"("+(size+2)+",list.getPageSize());\n";
            }
            //如果是单个则为一种类型，则selectList size为1
        return selectSqlSetParam;
    }

    //type =0 List<bean> type=1 List<Type>

    /***
     * 得到查询语句的返回部分设置
     * @param tableWrapper
     * @param selectNameList
     * @param type
     * @return
     */
    public static String getFindComplexSetParam(BTableWrapper tableWrapper,List<String> selectNameList,String type){
        int size = selectNameList.size();
        String selectSetParam="";
        if(type.equalsIgnoreCase("bean")) {
            for (int i = 0; i < size; i++) {
                int index = i + 1;
                String fieldname = selectNameList.get(i);
                String keyname = StringTool.underLineToHump(fieldname);
                BFieldWrapper bFieldWrapper = tableWrapper.getbFieldWrapperMap().get(keyname);
                selectSetParam += tableWrapper.getInstancename() + ".set" + bFieldWrapper.getCapitalname() + "(r.get" + bFieldWrapper.getCapitalJavatype() + "(" + index + "));\n";
            }
            //如果是单个则为一种类型，则selectList size为1
        }else {
            String fieldname = selectNameList.get(0);
            String keyname = StringTool.underLineToHump(fieldname);
            BFieldWrapper bFieldWrapper = tableWrapper.getbFieldWrapperMap().get(keyname);
            //selectSetParam += tableWrapper.getInstancename() + ".set" + bFieldWrapper.getCapitalname() + "(r.get" + bFieldWrapper.getCapitalJavatype() + "(" + index + "));\n";
            selectSetParam+= "result"+"=r.get"+bFieldWrapper.getCapitalJavatype()+"(" + 1 + ");\n";
        }
        return selectSetParam;
    }
}
