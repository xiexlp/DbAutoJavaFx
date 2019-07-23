package com.js.bean.relations;

import com.js.common.anno.*;
import com.js.common.db.DbUtils;
import com.js.dbauto.BField;
import com.js.dbauto.BFieldWrapper;
import com.js.dbauto.BTable;
import com.js.dbauto.BTableWrapper;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/***
 * 这个项目的功能是根据对象生成数据库表格
 * 使用方法就是把className写入就可以，配置使用myisam或innodb
 * 使用方法，将要修改或更新的Bean放入className即可更新或者创建新的表格,现在整合到一起，这样总体更好操作
 */
public class BeanRelationUtil {


    static String javaRelativeDir = "\\src\\main\\java\\";
    static String engine = com.js.code.Config.MYISAM;

    static BTableWrapper bTableWrapper;

    public static void main(String[] args) {
        //本目录下的
        String className = "com.js.cms.orm.Blogarticletag";
        String databasename = "iplatform";
        createTableByClassName(databasename, className, engine);
    }

    /**
     * 把包里面所有的bean建表
     *
     * @param args
     */
    public static void main123(String[] args) {
        String packageName = "com.js.jshop.orm";
        String projectDir = "F:\\java workplace\\BeanRelation";
        String databasename = "iplatform";
        createTableForPackage(databasename, packageName, projectDir);
    }


    public static void createTableForPackage(String databasename, String packageName, String projectDir) {
        try {
            List<String> classNameList = getClassNameList(projectDir, packageName);
            for (String className : classNameList) {
                createTableByClassName(databasename, className, engine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int createTableByClassName(String databasename, String className, String engine) {
        TableWrapper tableWrapper = getTableWrapperByClassName(className);
        return createTable(databasename, tableWrapper, engine);
    }


    /***
     * 修改bean信息后，根据bean信息更新数据表格定义
     * @param className
     * @param engine
     */
    public static void createTableByClassNameUpdate(String databasename, String className, String engine) {
        TableWrapper tableWrapper = getTableWrapperByClassName(className);
        //真实的表格
        String tablename = tableWrapper.getTableName();

        //判断表是否存在,如果不存在建立新表，如果存在则更新

        bTableWrapper = initTableParameters(tablename);
        //从bean中定义的
        List<FieldWrapper> fieldListBeanDef = tableWrapper.getFieldWrapperList();
        //从数据库中定义的
        List<BFieldWrapper> fieldListTableDef = bTableWrapper.getbFieldWrapperList();
        StringBuffer sqlBuffer = new StringBuffer("");
        //修改字段定义
        doAlterFieldColumn(tableWrapper,fieldListBeanDef,databasename,tablename);

        //如果发现表格中有，而bean中没有定义的，则drop表格中的多余的字段
        for (BFieldWrapper bFieldWrapper : fieldListTableDef) {
            String javaFieldName = bFieldWrapper.getFieldname();
            System.out.println("java Field Name:" + javaFieldName);
            FieldWrapper fieldWrapper = tableWrapper.getFieldWrapperMap().get(javaFieldName);
            //说明表格里面有而bean里面没有，需要drop掉表格里面的
            if (fieldWrapper == null) {
                sqlBuffer.append("alter table ").append(tablename).append(" drop ").append(bFieldWrapper.getbField().getField()).append("");
            } else {
            }
            String sql = sqlBuffer.toString();
            System.out.println("要执行的语句:" + sql);
            exeSqlLocal(databasename, sql);
            sqlBuffer = new StringBuffer("");
        }
        //createTable(tableWrapper,engine);
    }

    /**
     * 对表格增加新的字段
     * @param tableWrapper
     * @param fieldWrapper
     * @param tablename
     * @param databasename
     */
    private static void doAddColumn(TableWrapper tableWrapper,FieldWrapper fieldWrapper,String tablename,String databasename){
        StringBuffer sqlBuffer=new StringBuffer("");
        System.out.println("需要新建字段:" + fieldWrapper.getFieldNameSql());
        //新建一个列
        //StringBuffer addColumnSql= new StringBuffer();
        sqlBuffer.append("alter table ").append(tablename).append(" add ").append(fieldWrapper.getFieldSqlUnderLine());
        if (fieldWrapper.getLen() > 0) {
            //不带少数点
            if (fieldWrapper.getPointLen() < 1)
                sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append("(").append(fieldWrapper.getLen()).append(")").append(" not null ");
                //带少数点情况
            else
                sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append("(").append(fieldWrapper.getLen()).append(",").append(fieldWrapper.getPointLen()).append(")").append(" not null ");
            String javaType = fieldWrapper.getTypeJava();
            String defaultValue = getDefaultValueByJavaType(javaType);

            String sqlType = fieldWrapper.getTypeSql();
            System.out.println("sqlType:" + sqlType);
            //BLOB, TEXT, GEOMETRY or JSON column 'item_desc' can't have a default value
            if (sqlType.equalsIgnoreCase("BLOB") || sqlType.equalsIgnoreCase("TEXT") || sqlType.equalsIgnoreCase("JSON") || sqlType.equalsIgnoreCase("mediumtext")) {
                sqlBuffer.append(" ;").append("\n");
            } else {
                sqlBuffer.append(" default ").append(defaultValue);
                sqlBuffer.append(" ;").append("\n");
            }
        } else {
            sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append(" not null ");
            String javaType = fieldWrapper.getTypeJava();
            System.out.println("java type3333:" + javaType);
            String defaultValue = getDefaultValueByJavaType(javaType);

            String sqlType = fieldWrapper.getTypeSql();
            System.out.println("sqlType:" + sqlType);
            //BLOB, TEXT, GEOMETRY or JSON column 'item_desc' can't have a default value
            if (sqlType.equalsIgnoreCase("BLOB") || sqlType.equalsIgnoreCase("TEXT") || sqlType.equalsIgnoreCase("JSON") || sqlType.equalsIgnoreCase("mediumtext")) {
                sqlBuffer.append(" ;").append("\n");
            } else {
                sqlBuffer.append(" default ").append(defaultValue);
                sqlBuffer.append(" ;").append("\n");
            }
        }
        //如果该字段有索引定义的话，需要创建索引
        if (fieldWrapper.isIndex) {
            sqlBuffer.append(SqlUtil.indexCreateSQLByFieldWrapper(tableWrapper, fieldWrapper));
        }

        System.out.println("增加字段语句:"+sqlBuffer.toString());
        //修改类型语句的执行
        exeSqlLocal(databasename, sqlBuffer.toString());
    }

    private static void doAlterFieldType(TableWrapper tableWrapper,BFieldWrapper bFieldWrapper ,FieldWrapper fieldWrapper,String tablename,String databasename){
        //需要修改表字段的定义，建立alter语句
        StringBuffer sqlBuffer= new StringBuffer("");
        sqlBuffer.append("alter table ").append(tablename).append(" modify column ").append(bFieldWrapper.getbField().getField());
        //sqlBuffer.append(" ").append(fieldWrapper.getFieldNameSql());
        if (fieldWrapper.getLen() > 0) {
            //不带少数点
            if (fieldWrapper.getPointLen() < 1)
                sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append("(").append(fieldWrapper.getLen()).append(")").append(" not null ");
                //带少数点情况
            else
                sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append("(").append(fieldWrapper.getLen()).append(",").append(fieldWrapper.getPointLen()).append(")").append(" not null ");
            //String defaultValue = getDefaultValueByJavaType(fieldWrapper.getTypeJava());
        } else {
            sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append(" not null ");
        }
        //增加默认值
        String javaType = fieldWrapper.getTypeJava();
        String defaultValue = getDefaultValueByJavaType(javaType);

        String sqlType = fieldWrapper.getTypeSql();
        System.out.println("sqlType:" + sqlType);
        //BLOB, TEXT, GEOMETRY or JSON column 'item_desc' can't have a default value
        if (sqlType.equalsIgnoreCase("BLOB") || sqlType.equalsIgnoreCase("TEXT") || sqlType.equalsIgnoreCase("JSON") || sqlType.equalsIgnoreCase("mediumtext")) {
            sqlBuffer.append(" ;").append("\n");
        } else {
            sqlBuffer.append(" default ").append(defaultValue);
            sqlBuffer.append(" ;").append("\n");
        }

        System.out.println("修改类型语句:"+sqlBuffer.toString());
        //修改类型语句的执行
        exeSqlLocal(databasename, sqlBuffer.toString());

        //执行之后清空
        sqlBuffer.setLength(0);
    }


    private static void doAlterFieldColumn(TableWrapper tableWrapper, List<FieldWrapper> fieldListBeanDef, String databasename, String tablename) {
        StringBuffer sqlBuffer = new StringBuffer("");
        for (FieldWrapper fieldWrapper : fieldListBeanDef) {
            //如果是map则继续，这个不需要执行
            if (fieldWrapper.getFieldNameJava().equalsIgnoreCase("map")) {
                System.out.println("map字段不需要执行");
                continue;
            }

            //在表格中的字段定义
            BFieldWrapper bFieldWrapper = bTableWrapper.getbFieldWrapperMap().get(fieldWrapper.getFieldNameJava());

            //在源文件定义中有在表格中没有这时候增加字段
            if (bFieldWrapper == null) {
                //增加字段
                doAddColumn(tableWrapper,fieldWrapper,tablename,databasename);
            } else {
                System.out.println("bean定义的字段名:" + fieldWrapper.getFieldNameSql());
                System.out.println("数据库中定义的字段名:" + bFieldWrapper.getTableFieldName());
                // type size
                //数据库类型
                String type = bFieldWrapper.getbField().getType();
                System.out.println("数据库中定义的type:" + type);
                //bean定义的数据类型
                String beantype = fieldWrapper.getTypeSql();
                System.out.println("bean中定义的 type:" + beantype);

                //如果字段的数据类型发生了变化,则需要执行修改语句
                if (!type.equalsIgnoreCase(beantype)) {
                    doAlterFieldType(tableWrapper,bFieldWrapper,fieldWrapper,tablename,databasename);
                }

                //如果增加了索引定义，且当前表格没有该字段的索引，则创建索引,跟前面没有关系
                if (fieldWrapper.isIndex && !bFieldWrapper.isIndex()) {
                    //这部分还需要,需要创建index
                    String createIndexSQL = SqlUtil.indexCreateSQLByFieldWrapper(tableWrapper, fieldWrapper);
                    System.out.println(fieldWrapper.getFieldNameSql() + " createIndex SQL:" + createIndexSQL);
                    //sqlBuffer.append("\n");
                    sqlBuffer.append(createIndexSQL);
                    //修改index语句的执行
                    exeSqlLocal(databasename, sqlBuffer.toString());
                }

                System.out.println("新提交的大小:" + fieldWrapper.getLen());
                System.out.println("目前数据中定义的大小:" + bFieldWrapper.getSqlSize());
                //如果都为varchar类型，且数据定义的大小不同，则需要更新
                if (fieldWrapper.getTypeSql().equalsIgnoreCase("varchar") && bFieldWrapper.getSqlType().equalsIgnoreCase("varchar")) {
                    if (fieldWrapper.getLen() != Integer.parseInt(bFieldWrapper.getSqlSize())) {
                        //需要修改表字段的定义，建立alter语句
                        sqlBuffer.append("alter table ").append(tablename).append(" modify column ").append(bFieldWrapper.getbField().getField());
                        //sqlBuffer.append(" ").append(fieldWrapper.getTypeSql());
                        if (fieldWrapper.getLen() > 0) {
                            //不带少数点
                            if (fieldWrapper.getPointLen() < 1)
                                sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append("(").append(fieldWrapper.getLen()).append(")").append(" not null ");
                                //带少数点情况
                            else
                                sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append("(").append(fieldWrapper.getLen()).append(",").append(fieldWrapper.getPointLen()).append(")").append(" not null ");
                        } else {
                            sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append(" not null ");
                        }

                        //增加默认值
                        String javaType = fieldWrapper.getTypeJava();
                        String defaultValue = getDefaultValueByJavaType(javaType);
                        String sqlType = fieldWrapper.getTypeSql();
                        System.out.println("sqlType:" + sqlType);
                        //BLOB, TEXT, GEOMETRY or JSON column 'item_desc' can't have a default value
                        if (sqlType.equalsIgnoreCase("BLOB") || sqlType.equalsIgnoreCase("TEXT") || sqlType.equalsIgnoreCase("JSON") || sqlType.equalsIgnoreCase("mediumtext")) {
                            sqlBuffer.append(" ;").append("\n");
                        } else {
                            sqlBuffer.append(" default ").append(defaultValue);
                            sqlBuffer.append(" ;").append("\n");
                        }
                    }
                }

                //需要有default value;
                if (bFieldWrapper.getDefaultValue() == null || bFieldWrapper.getDefaultValue().equalsIgnoreCase("NULL")) {
                    System.out.println("当前表格中默认值为 null");
                    if (!bFieldWrapper.getExtra().equalsIgnoreCase("auto_increment")) {
                        //alter table timetest alter createtime set default '0000-00-00 00:00:00';
                        sqlBuffer = new StringBuffer();
                        sqlBuffer.append("alter table ").append(tablename).append(" modify column ").append(bFieldWrapper.getbField().getField());

                        //sqlBuffer.append(" default ");
                        String defaultValue = getDefaultValueByJavaType(bFieldWrapper.getJavatype());
                        String sqlType = fieldWrapper.getTypeSql();

                        System.out.println("sqlType:" + sqlType);
                        //sqlBuffer.append(" ").append(sqlType).append(" ");

                        if (fieldWrapper.getLen() > 0) {
                            //不带少数点
                            if (fieldWrapper.getPointLen() < 1)
                                sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append("(").append(fieldWrapper.getLen()).append(")").append(" not null ");
                                //带少数点情况
                            else
                                sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append("(").append(fieldWrapper.getLen()).append(",").append(fieldWrapper.getPointLen()).append(")").append(" not null ");
                        } else {
                            sqlBuffer.append(" ").append(fieldWrapper.getTypeSql()).append(" not null ");
                        }


                        //BLOB, TEXT, GEOMETRY or JSON column 'item_desc' can't have a default value
                        if (sqlType.equalsIgnoreCase("BLOB") || sqlType.equalsIgnoreCase("TEXT") || sqlType.equalsIgnoreCase("JSON") || sqlType.equalsIgnoreCase("mediumtext")) {
                            sqlBuffer.append(" ;").append("\n");
                        } else {
                            sqlBuffer.append(" default ").append(defaultValue);
                            sqlBuffer.append(" ;").append("\n");
                        }
                    }
                }

            }
            String sql = sqlBuffer.toString();
            System.out.println("要执行的语句:" + sql);
            exeSqlLocal(databasename, sql);
            sqlBuffer = new StringBuffer("");
        }
    }


    private static String getJavaTypeByTypeSQL(String typeSql) {
        String typeJava="";
        if(typeSql.equalsIgnoreCase("varchar")){
            typeJava="String";
        }else if(typeSql.equalsIgnoreCase("int")){
            typeJava="int";
        }
        return typeJava;
    }


    private static String getDefaultValueByJavaType(String javaType){

        System.out.println("javaType222:"+javaType);

        List zeroList =new ArrayList();
        zeroList.add("long");zeroList.add("int");zeroList.add("Integer");zeroList.add("double");
        zeroList.add("Double");zeroList.add("Float");zeroList.add("float");


        List currentTimeList = new ArrayList();
        currentTimeList.add("Timestamp");currentTimeList.add("Date");

        List emptyStringList = new ArrayList();
        emptyStringList.add("String");


        if(zeroList.contains(javaType)){
            return "0";
        }
        //如果字符串,default value为空字符串
        if(emptyStringList.contains(javaType)){
            return "\"\"";
        }

        if(currentTimeList.contains(javaType)){
            //return " CURRENT_TIMESTAMP ";
            //return "'0000-00-00 00:00:00'";
            //YYYYMMDD HHMMSS
            //
            //return "'00000000 000000'";
           //
            return "'1971-01-01 00:00:00'";
        }
        return "";
    }

    private static void exeSqlLocal(String databasename,String sql){
        if(sql.equalsIgnoreCase("")){
            System.out.println("字段不需要执行sql语句");
        }
        else {
            int result =DBUtil.exeSql(databasename,sql);
            if(result>=0){
                System.out.println("执行sql:"+sql+" 成功!");
            }else {
                System.out.println("执行sql:"+sql+" 失败");
            }
        }
    }


    private static BTableWrapper initTableParameters(String tablename){
        //String packageName = packageNameTextField.getText();
        //String packageNameCurrent = currentPackageNameTextField.getText();
        System.out.println("tablename:" + tablename);

        BTableWrapper theBTableWrapper=null;

        BTable thBTable=new BTable();

        //XTable xTable = new XTable();

        thBTable.setDatabasename(com.js.code.Config.DBNAME);
        //thBTable.setCommonPackage(commonPackageTextField.getText().trim());
        //thBTable.setPackageNameCurrent(packageNameCurrent);


        //XTableEx xtableEx = tableExMap.get(tablename);

        try {
            PreparedStatement p = com.js.code.db.DBUtil.getConn().prepareStatement("desc " + tablename);
            ResultSet r = p.executeQuery();
            List<BField> list = new ArrayList();
            List<BField> keyList = new ArrayList();
            List<BField> indexList = new ArrayList<>();

            BField keyField = new BField();
            BField indexField = new BField();

            //  XField xfield = new XField();
//            List<XField> xfieldList = new ArrayList<>();
//            List<XField> keyXFields=new ArrayList<>();

            while (r.next()) {
                BField tField = new BField();
                String fieldname = r.getString(1);

                //查看是否索引 show index from ejf_doc where column_name like 'doc_id'
                PreparedStatement p1 = com.js.code.db.DBUtil.getConn().prepareStatement("show index from " + tablename+" where COLUMN_NAME like '"+fieldname+"'");
                ResultSet r1 = p1.executeQuery();
                boolean isIndex = false;
                while (r1.next()){
                    isIndex = true;
                }
                //XField xField = xtableEx.getXfieldMap().get(fieldname);
                //System.out.println("中文名:"+xField.getCnname());

                String pretype = r.getString(2);
                String type=null;
                int left = pretype.indexOf("(");
                if (left > 0) {
                    type = pretype.substring(0, left);
                }else type = pretype;
                String sqlSize=null;
                int right = pretype.indexOf(")");
                if(right>0){
                    sqlSize = pretype.substring(left+1,right);
                }
                System.out.println("type:" + type);

                String isnull = r.getString(3);
                String key = r.getString(4);

                String defaultvalue = r.getString(5);
                String extra = r.getString(6);

                tField.setField(fieldname);
                tField.setType(type);
                tField.setIsNull(isnull);
                tField.setIsKey(key);
                tField.setDefaultKey(defaultvalue);
                tField.setExtra(extra);
                tField.setIndex(isIndex);

                tField.setSqlSize(sqlSize);
                tField.setDefaultValue(defaultvalue);

                //tField.setCnname(xField.getCnname());
                if (key.equals("PRI")) {
                    keyField = tField;
                    //增加一项主键项目
                    keyList.add(keyField);
                    //keyXFields.add(xfield);
                }else{
                    //fieldList.add(tfield);
                }

                if(isIndex){
                    indexField = tField;
                    indexList.add(indexField);
                }

                //所有的表项
                list.add(tField);
            }

            thBTable.setKeybField(keyField);
            thBTable.setName(tablename);
            thBTable.setFieldList(list);
            thBTable.setKeyFieldList(keyList);
            thBTable.setIndexFieldList(indexList);
            thBTable.setKey(keyField.getField());
            //thBTable.setPackageName(packageName);

            //xTable.setTablename(tablename);
            //xTable.setXfields(xfieldList);

            theBTableWrapper = new BTableWrapper(thBTable);
            //theBTableWrapper.setRelativepath(relativepath);
            //theBTableWrapper.setCnname(xtableEx.getTable().getCnname());
            bTableWrapper = theBTableWrapper;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theBTableWrapper;
    }


    public static TableWrapper getTableWrapperByClassName(String className){
        TableWrapper tableWrapper=null;
        try {
            tableWrapper = getClassInfo(className);
            //如果是class，修改这些问题
            List<FieldWrapper> fieldWrapperList = getSuperClassFields(className);

            for(FieldWrapper fieldWrapper:fieldWrapperList){
                String javaFieldName = fieldWrapper.getFieldNameJava();
                tableWrapper.fieldWrapperMap.put(javaFieldName,fieldWrapper);
            }

            List<FieldWrapper> keyFieldWrapperList = getKeyFieldWrapperList(fieldWrapperList);
            List<FieldWrapper> indexFieldWrapperList = getIndexFieldWrapperList(fieldWrapperList);
            tableWrapper.setFieldWrapperList(fieldWrapperList);
            tableWrapper.setKeyFieldWrapperList(keyFieldWrapperList);
            tableWrapper.setIndexWrapperList(indexFieldWrapperList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tableWrapper;
    }

    public static int createTable(String databasename,TableWrapper tableWrapper,String engine){
        if(!DBUtil.validateTableNameExist(databasename,tableWrapper.getTableName())) {
            String dropSql = SqlUtil.getDropTableSql(tableWrapper);
            String createTableSql = genCreateTableSql(tableWrapper, engine);
            //不能轻易删表,所以这句就暂时不执行
            //int r1 = DBUtil.exeSql(dropSql);
            int r2 = DBUtil.exeSql(databasename,createTableSql);
            //成功创建
            return 1;
        }else {
            //已经存在，不需要创建
            return 0;
        }
    }

    public static void testCreateTable(String[] args)  {
        String className= "com.js.jshop.orm.Action";
        String engine = com.js.code.Config.MYISAM;
        try {
            TableWrapper tableWrapper=getClassInfo(className);
            List<FieldWrapper> fieldWrapperList=getSuperClassFields(className);
            tableWrapper.setFieldWrapperList(fieldWrapperList);
            System.out.println(tableWrapper.getFieldWrapperList().size());
            String dropSql = SqlUtil.getDropTableSql(tableWrapper);
            String createTableSql=genCreateTableSql(tableWrapper,engine);
            System.out.println("drop table sql:"+dropSql);
            int r1= 0;
            //r1=DBUtil.exeSql(dropSql);

            if(r1>0){
                System.out.println("删表成功");
            }else {
                System.out.println("删表失败");
            }
            int r=0;
            r=DBUtil.exeSql(createTableSql);
            if(r>0){
                System.out.println("建表成功");
            }else {
                System.out.println("建表失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static String genCreateTableSqlByClassName(String className,String engine){
        String createTableSql=null;
        try {
            TableWrapper tableWrapper=getClassInfo(className);
            List<FieldWrapper> fieldWrapperList=getSuperClassFields(className);
            List<FieldWrapper> keyFieldWrapperList = getKeyFieldWrapperList(fieldWrapperList);
            tableWrapper.setFieldWrapperList(fieldWrapperList);
            tableWrapper.setKeyFieldWrapperList(keyFieldWrapperList);
            System.out.println(tableWrapper.getFieldWrapperList().size());
            createTableSql=genCreateTableSql(tableWrapper,engine);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return createTableSql;
    }

    public static String genCreateTableSql(TableWrapper tableWrapper,String engine){
        String createTableSql = SqlUtil.getCreateSql(tableWrapper,engine);
        System.out.println(createTableSql);
        return createTableSql;
    }


    public static void test1(String[] args) throws Exception{
        try {
            String packageName = "com.js.jshop.orm";
            String projectDir = "F:\\java workplace\\BeanRelation";
            List<String> classNameList = getClassNameList(projectDir,packageName);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //不包含父类的info
    public static TableWrapper getClassInfo(String className) throws ClassNotFoundException {
        TableWrapper tableWrapper = new TableWrapper();

        System.out.println("类名:"+className);
        Class c = Class.forName(className);

        TableAnno tableAnno=(TableAnno) c.getAnnotation(TableAnno.class);
        String tableName =tableAnno.name();
        System.out.println("table name:"+tableName);
        tableWrapper.setTableName(tableName);
        tableWrapper.setJavaName(c.getSimpleName());

        Field[] fields=c.getDeclaredFields();
        int l = fields.length;
        System.out.println("field size:"+l);
        return tableWrapper;
    }

    //不包含父类的info,这个是得到父类的fields
    public static List<FieldWrapper> getClassFields(String className) throws ClassNotFoundException {
        Class c = Class.forName(className);
        Field[] fields=c.getDeclaredFields();
        int l = fields.length;
        System.out.println("field size:"+l);
        List<FieldWrapper> fieldWrappers = new ArrayList<FieldWrapper>();
        for(int i=0;i<l;i++){
            FieldWrapper fieldWrapper = new FieldWrapper();
            Field f = fields[i];
            fieldWrapper.setFieldNameJava(f.getName());
            fieldWrapper.setTypeJava(f.getType().getName());
            System.out.println("name:"+f.getName()+" type:"+f.getType().getSimpleName());
            String name = f.getName();
            fieldWrapper.setFieldNameJava(f.getName());
            fieldWrapper.setFieldNameSql(f.getName());
            fieldWrapper.setTypeJava(f.getType().getSimpleName());
            setFieldType(fieldWrapper,f);
            isPrimaryKey(fieldWrapper,f);
            setFieldLen(fieldWrapper,f);
            setAutoIncrement(fieldWrapper,f);
            fieldWrappers.add(fieldWrapper);
        }
        return  fieldWrappers;
    }


    //不包含父类的info,这个是得到父类的fields
    public static List<FieldWrapper> getSuperClassFields(String className) throws ClassNotFoundException {
        Class c = Class.forName(className);
        Field[] fields=c.getSuperclass().getDeclaredFields();
        int l = fields.length;
        System.out.println("field size:"+l);
        List<FieldWrapper> fieldWrappers = new ArrayList<FieldWrapper>();
        for(int i=0;i<l;i++){
            FieldWrapper fieldWrapper = new FieldWrapper();
            Field f = fields[i];
            fieldWrapper.setFieldNameJava(f.getName());
            fieldWrapper.setTypeJava(f.getType().getName());
            System.out.println("name:"+f.getName()+" type:"+f.getType().getSimpleName());
            String name = f.getName();
            fieldWrapper.setFieldNameJava(f.getName());
            fieldWrapper.setFieldNameSql(StringTool.humpToUnderLine(f.getName()));
            fieldWrapper.setTypeJava(f.getType().getSimpleName());
            setFieldType(fieldWrapper,f);
            isPrimaryKey(fieldWrapper,f);
            isIndex(fieldWrapper,f);
            isPartField(fieldWrapper,f);
            setFieldLen(fieldWrapper,f);
            setAutoIncrement(fieldWrapper,f);
            fieldWrappers.add(fieldWrapper);
        }
        return  fieldWrappers;
    }

    public static List<FieldWrapper> getKeyFieldWrapperList(List<FieldWrapper> fieldWrappers){
        List<FieldWrapper> keyFieldWrapperList = new ArrayList<FieldWrapper>();
        for(FieldWrapper fieldWrapper:fieldWrappers){
            if(fieldWrapper.isPrimaryKey()){
                keyFieldWrapperList.add(fieldWrapper);
            }
        }
        return keyFieldWrapperList;
    }


    public static List<FieldWrapper> getIndexFieldWrapperList(List<FieldWrapper> fieldWrappers){
        List<FieldWrapper> indexFieldWrapperList = new ArrayList<FieldWrapper>();
        for(FieldWrapper fieldWrapper:fieldWrappers){
            if(fieldWrapper.isIndex()){
                indexFieldWrapperList.add(fieldWrapper);
            }
        }
        return indexFieldWrapperList;
    }


    public static void isPartField(FieldWrapper fieldWrapper,Field f){
        PartField partField=f.getAnnotation(PartField.class);
        if(partField!=null){
            System.out.println("是否列表显示:"+partField.value());
            boolean isPart = partField.value();
            if(isPart) fieldWrapper.setPart(isPart);
            else fieldWrapper.setPart(false);
            //这个暂时不用
           // boolean indexUnique = partField.unique();
           // if(indexUnique) fieldWrapper.setIndexUnique(indexUnique);
        }else fieldWrapper.setIndex(false);
    }

    public static void isIndex(FieldWrapper fieldWrapper,Field f){
        TableIndex tableIndex=f.getAnnotation(TableIndex.class);
        if(tableIndex!=null){
            boolean isIndex = tableIndex.value();
            if(isIndex) fieldWrapper.setIndex(isIndex);
            else fieldWrapper.setIndex(false);
            //这个暂时不用
            boolean indexUnique = tableIndex.unique();
            if(indexUnique) fieldWrapper.setIndexUnique(indexUnique);
        }else fieldWrapper.setIndex(false);
    }

    public static void isPrimaryKey(FieldWrapper fieldWrapper,Field f){
        PrimaryKey primaryKey=f.getAnnotation(PrimaryKey.class);
        if(primaryKey!=null){
            boolean isPrimaryKey = primaryKey.value();
            if(isPrimaryKey) fieldWrapper.setPrimaryKey(isPrimaryKey);
        }else fieldWrapper.setPrimaryKey(false);
    }

    public static void setFieldLen(FieldWrapper fieldWrapper,Field f){
        TableField tableField = f.getAnnotation(TableField.class);
        if(tableField!=null){
        int len = tableField.len();
            fieldWrapper.setLen(len);
       int pointLen = tableField.pointLen();
            fieldWrapper.setPointLen(pointLen);
        }else{ fieldWrapper.setLen(0);
            fieldWrapper.setPointLen(0);
        }
    }

    public static void setAutoIncrement(FieldWrapper fieldWrapper,Field f){
        AutoIncrement autoIncrement = f.getAnnotation(AutoIncrement.class);
        if(autoIncrement!=null){
            fieldWrapper.setAutoIncrement(true);
        }else fieldWrapper.setAutoIncrement(false);
    }

    public static void setFieldType(FieldWrapper fieldWrapper,Field f){
        TableFieldType fieldType = f.getAnnotation(TableFieldType.class);
        System.out.println("field name:"+f.getName());
        if(fieldType!=null){
            if(fieldType.fieldType()==TableFieldType.TYPE.VARCHAR){
                System.out.println("varchar");
                fieldWrapper.setTypeSql("varchar");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.TEXT){
                System.out.println("text");
                fieldWrapper.setTypeSql("text");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.MEDIUMTEXT){
                System.out.println("text");
                fieldWrapper.setTypeSql("mediumtext");
            }
            else if(fieldType.fieldType()==TableFieldType.TYPE.INT){
                System.out.println("int");
                fieldWrapper.setTypeSql("int");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.BIGINT){
                System.out.println("bigint");
                fieldWrapper.setTypeSql("bigint");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.CHAR){
                System.out.println("char");
                fieldWrapper.setTypeSql("char");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.TINYINT){
                System.out.println("tinyint");
                fieldWrapper.setTypeSql("tinyint");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.SMALLINT){
                System.out.println("smallint");
                fieldWrapper.setTypeSql("smallint");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.TEXT){
                System.out.println("text");
                fieldWrapper.setTypeSql("text");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.DOUBLE){
                System.out.println("double");
                fieldWrapper.setTypeSql("double");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.FLOAT){
                System.out.println("float");
                fieldWrapper.setTypeSql("float");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.DATETIME){
                System.out.println("datetime");
                fieldWrapper.setTypeSql("datetime");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.DATE){
                System.out.println("date");
                fieldWrapper.setTypeSql("date");
            }else if(fieldType.fieldType()==TableFieldType.TYPE.DECIMAL){
                System.out.println("decimal");
                fieldWrapper.setTypeSql("decimal");
            }
        }else {
            fieldWrapper.setTypeSql("varchar");
        }
    }


    public static List<String> getClassNameList(String projectDir,String packageName){
        String classDir = packageName.replace(".","\\");
        System.out.println("class dir:"+classDir);
        String fullJavaDir = projectDir+javaRelativeDir+classDir;
        System.out.println("java dir:"+fullJavaDir);
        File javaDirFile = new File(fullJavaDir);
        File[] javaFiles = javaDirFile.listFiles();
        int l= javaFiles.length;
        List<String> classNameList = new ArrayList();
        for(int i=0;i<l;i++){
            File f = javaFiles[i];
            System.out.println("javaname:"+f.getName());
            int indexPoint = f.getName().indexOf(".");
            String javaName = f.getName().substring(0,indexPoint);
            String className = packageName+"."+javaName;
            System.out.println("class name:"+className);
            classNameList.add(className);
        }
        return classNameList;
    }

}
