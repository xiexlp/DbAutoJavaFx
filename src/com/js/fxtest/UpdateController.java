package com.js.fxtest;

import com.js.code.Controller;
import com.js.code.db.DBUtil;
import com.js.dbauto.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.swing.*;
import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateController implements Initializable{

    private MainController mainController ;
    @FXML
    String tablename;
    @FXML
    TextField tablenameTextField;

    @FXML
    FlowPane checkboxPane;


    @FXML
    FlowPane checkboxPaneCondition;

    List<String> fieldList;

    private Controller controller;
    boolean useKey;

    boolean addCondtion;

    CheckBox[] cbs;

    CheckBox[] cbsCondition;

    private BTableWrapper tableWrapper;
    List<BFieldWrapper> selectFieldWrapperList;

    List<BFieldWrapper> conditionFieldWrapperList;

    VelocityEngine velocityEngine = new VelocityEngine();
    VelocityContext context = new VelocityContext();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("alert controller...");
        System.out.println("tablename:"+tablename);
        tablenameTextField.setText(tablename);

        checkboxPane.setHgap(10);
        checkboxPane.setVgap(10);

        if(!useKey){
            fieldList = DBUtil.getFieldNotPrimaryKeyList(tablename);
        }else {
            fieldList = DBUtil.getFieldList(tablename);
        }

        int len = fieldList.size();
        cbs = new CheckBox[len];

        for(int i=0;i<len;i++){
            String fieldname = fieldList.get(i);
            //如果是updateTime则让其选定
            CheckBox cb=cbs[i]=new CheckBox(fieldname);
            if(fieldname.equalsIgnoreCase("updateTime")||fieldname.equalsIgnoreCase("update_time")||fieldname.equalsIgnoreCase("updatetime")){
                cb.setSelected(true);
            }
            checkboxPane.getChildren().add(cb);
        }
        checkboxPaneCondition.setHgap(10);
        checkboxPaneCondition.setVgap(10);

        cbsCondition = new CheckBox[len];
        for(int i=0;i<len;i++){
            String fieldname = fieldList.get(i);
            CheckBox cb=cbsCondition[i]=new CheckBox(fieldname);
            checkboxPaneCondition.getChildren().add(cb);
        }
    }

    @FXML
    public void doCreateUpdateCode(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        //doGenCreateFindCode(codeConcat);
    }

    @FXML
    public void doCreateIncSelectFieldCodeNoBean(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        doGenCreateIncSelectFieldCodeNoBean(codeConcat);
    }


    @FXML
    public void doCreateUpdateCondtionCodeNoBean(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();
        conditionFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }

        System.out.println("条件的字段大小:"+conditionFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:conditionFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcatCondition();
        doGenCreateUpdateConditionCodeNoBean(codeConcat);
    }

    @FXML
    public void doCreateIncCondtionCodeNoBean(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();
        conditionFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }

        System.out.println("条件的字段大小:"+conditionFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:conditionFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcatConditionInc();
        doGenCreateIncConditionCodeNoBean(codeConcat);
    }

    @FXML
    public void doCreateUpdateSelectFieldCode(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        doGenCreateUpdateSelectFieldCode(codeConcat);
    }


    @FXML
    public void doCreateDeleteSelectFieldCodeNoBean(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        doGenCreateDeleteSelectFieldCode(codeConcat);

    }




    @FXML
    public void doCreateUpdateSelectFieldCodeNoBean(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        doGenCreateUpdateSelectFieldNoBeanCode(codeConcat);
    }

    private void doGenCreateIncSelectFieldCodeNoBean(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();

        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectFieldWrapperList);
        context.put("sqlAndParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/incSelectFieldNoBean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.setSqlTextArea(sw.toString());
    }


    private void doGenCreateIncConditionCodeNoBean(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();

        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        context.put("inc_sql",SqlVelocity.buildIncSql(tableWrapper,selectFieldWrapperList,conditionFieldWrapperList));
        context.put("inc_set",SqlVelocity.buildIncSet(tableWrapper,selectFieldWrapperList,conditionFieldWrapperList));
        //SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectFieldWrapperList);
        //context.put("sqlAndParam",sqlAndParam);
        StringWriter sw = new StringWriter();

        velocityEngine.mergeTemplate("src/templates/incConditionNoBean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());

        replaceCodeFile(sw.toString());

        controller.setSqlTextArea(sw.toString());
    }

    private void doGenCreateUpdateConditionCodeNoBean(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();

        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        context.put("update_sql",SqlVelocity.buildUpdateSql(tableWrapper,selectFieldWrapperList,conditionFieldWrapperList));
        context.put("update_set",SqlVelocity.buildUpdateSet(tableWrapper,selectFieldWrapperList,conditionFieldWrapperList));
        //SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectFieldWrapperList);
        //context.put("sqlAndParam",sqlAndParam);
        StringWriter sw = new StringWriter();

        velocityEngine.mergeTemplate("src/templates/updateConditionNoBean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());

        replaceCodeFile(sw.toString());


        controller.setSqlTextArea(sw.toString());
    }



    private void doGenCreateUpdateSelectFieldCode(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectFieldWrapperList);
        context.put("sqlAndParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/updateSelectFieldBean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.setSqlTextArea(sw.toString());
    }

    private void doGenCreateUpdateSelectFieldNoBeanCode(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectFieldWrapperList);
        context.put("sqlAndParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/updateSelectFieldNoBean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.setSqlTextArea(sw.toString());
    }

    private void doGenCreateDeleteSelectFieldCode(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectFieldWrapperList);
        context.put("sqlAndParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/deleteByFieldNoBean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());

        replaceCodeFile(sw.toString());

        controller.setSqlTextArea(sw.toString());
    }



    private String getPath(){
        //serv
        String basePackage = tableWrapper.getPackagenameCurrent();
        String packageName = tableWrapper.getPackagename();
        System.out.println("basePackage:"+basePackage);
        System.out.println("package name:"+packageName);
        String projectDir = tableWrapper.getProjectDir();
        System.out.println("project dir:"+projectDir);
        String servPath = tableWrapper.getServJavafilename();
        System.out.println("serPath:"+servPath);

        String path = projectDir+"\\src\\main\\java\\";
        String packageDir = packageName.replace(".","\\");
        return path+packageDir;
    }

    /***
     * 将相应文件增加
     * @param allCode
     */
    private void replaceCodeFile(String allCode) {
        String result = allCode;
        String[] resultsArray = result.split("//--");
        for (String r : resultsArray) {
            System.out.println(r);
            System.out.println("---------------------分隔符-------------------");
        }
        int len = resultsArray.length;
        for (int i = 0; i < len; i++) {
            String code = resultsArray[i];
            if (i == 0) {
                //前提是这个文件必须先存在
                String fullPath = getPath() + "\\servupdate\\" + tableWrapper.getBeanname() + "ServUpdate.java";
                System.out.println("fullPath:" + fullPath);
                File file = new File(fullPath);
                if(!file.exists()){
                    JOptionPane.showMessageDialog(null,file.getAbsoluteFile()+"不文件存在，请先建立Read文件？");
                    System.out.println("result:"+result);
                    return;
                }
                System.out.println("file:" + file.getAbsolutePath() + ":" + file.exists());
                //写入文件
                FileUtil.javaCodeAppend(fullPath, code);

            } else if (i == 2) {
                //dao
                String fullPath = getPath() + "\\dao\\" + tableWrapper.getBeanname() + "Dao.java";
                //String daoPath = tableWrapper.getDaoJavafilename();
                System.out.println("daoPath:" + fullPath);
                File file = new File(fullPath);
                System.out.println("file:" + file.getAbsolutePath() + ":" + file.exists());
                //写入文件
                FileUtil.javaCodeAppend(fullPath, code);

            } else if (i == 3) {
                //daoimpl
                String fullPath = getPath() + "\\daoimpl\\" + tableWrapper.getBeanname() + "Daoimpl.java";
                //String daoimplPath = tableWrapper.getDaoimplJavafilename();
                System.out.println("daoimplpath:" + fullPath);
                File file = new File(fullPath);
                System.out.println("file:" + file.getAbsolutePath() + ":" + file.exists());
                //写入文件
                FileUtil.javaCodeAppend(fullPath, code);
            }
        }
    }


    private void doGenCreateUpdateSelectFieldCodeNoBean(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/updateSelectFieldNoBean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.setSqlTextArea(sw.toString());
    }

    @FXML
    public void doCreateUpdateBySelectFieldCodePage(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        //doGenCreateFindBySelectFieldCodePage(codeConcat);
    }

    /**
     *这个目的是得到所选定的字段
     */
    private void doFillSelectFieldList(){
        int len = cbs.length;
        for(int i=0;i<len;i++){
            CheckBox cb = cbs[i];
            if(cb.isSelected()){
                //System.out.println(cb.getText());
                String tablefieldname = cb.getText();
                System.out.println("table field name:"+tablefieldname);
                String fieldname = StringTool.underLineToHump(tablefieldname);
                System.out.println("field name:"+fieldname);
                BFieldWrapper selectFieldWrapper = getTableWrapper().getbFieldWrapperMap().get(fieldname);
                selectFieldWrapperList.add(selectFieldWrapper);
            }
        }
        if(selectFieldWrapperList.size()<1) System.out.println("请选择字段");

        int len1 = cbsCondition.length;
        for(int i=0;i<len;i++){
            if(addCondtion) {
                CheckBox cb = cbsCondition[i];
                if (cb.isSelected()) {
                    //System.out.println(cb.getText());
                    String tablefieldname = cb.getText();
                    System.out.println("table field name:" + tablefieldname);
                    String fieldname = StringTool.underLineToHump(tablefieldname);
                    System.out.println("field name:" + fieldname);
                    BFieldWrapper selectFieldWrapper1 = getTableWrapper().getbFieldWrapperMap().get(fieldname);
                    conditionFieldWrapperList.add(selectFieldWrapper1);
                }
            }
        }

    }







    private CodeConcat getCodeConcat(){
        CodeConcat codeConcat = new CodeConcat();
        //codeConcat.setKeyConcat(getKeyList());
        codeConcat.setKeyConcatWithType(getKeyListWithType());
        codeConcat.setKeyConcatWithComma(getKeyListWithComma());
        codeConcat.setFieldConcat(getSelectFieldList());
        codeConcat.setFieldConcatWithComma(getSelectFieldListWithComma());
        codeConcat.setFieldConcatWithType(getSelectFieldListWithType());

        return codeConcat;
    }

    private CodeConcat getCodeConcatCondition(){
        CodeConcat codeConcat = new CodeConcat();
        //codeConcat.setKeyConcat(getKeyList());
        if(addCondtion){
            //条件语句是根据条件而不是主键来产生update语句的
            codeConcat.setConditionConcatWithType(getCondtionListWithType());
            codeConcat.setConditionConcatWithComma(getConditionListWithComma());
            codeConcat.setFieldConcat(getSelectFieldList());
            codeConcat.setConditionConcat(getConditionFieldList());
            codeConcat.setFieldConcatWithComma(getSelectFieldListWithComma());
            codeConcat.setFieldConcatWithType(getSelectFieldListWithType());
        }else {
            codeConcat.setKeyConcatWithType(getKeyListWithType());
            codeConcat.setKeyConcatWithComma(getKeyListWithComma());
            codeConcat.setFieldConcat(getSelectFieldList());
            codeConcat.setFieldConcatWithComma(getSelectFieldListWithComma());
            codeConcat.setFieldConcatWithType(getSelectFieldListWithType());
        }
        return codeConcat;
    }


    private CodeConcat getCodeConcatConditionInc(){
        CodeConcat codeConcat = new CodeConcat();
        //codeConcat.setKeyConcat(getKeyList());
        if(addCondtion){
            //条件语句是根据条件而不是主键来产生update语句的
            codeConcat.setConditionConcatWithType(getCondtionListWithType());
            codeConcat.setConditionConcatWithComma(getConditionListWithComma());
            codeConcat.setFieldConcat(getSelectFieldList());
            codeConcat.setConditionConcat(getConditionFieldList());
            codeConcat.setFieldConcatWithComma(getSelectFieldListWithCommaInc());
            codeConcat.setFieldConcatWithType(getSelectFieldListWithTypeInc());
        }else {
            codeConcat.setKeyConcatWithType(getKeyListWithType());
            codeConcat.setKeyConcatWithComma(getKeyListWithComma());
            codeConcat.setFieldConcat(getSelectFieldList());
            codeConcat.setFieldConcatWithComma(getSelectFieldListWithCommaInc());
            codeConcat.setFieldConcatWithType(getSelectFieldListWithTypeInc());
        }
        return codeConcat;
    }

    private String getKeyList(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbKeyFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(MyStringUtils.UpperFirstString(bFieldWrapper.getFieldname()));
        }
        //System.out.println("字段的拼接,用在函数的命名:"+sb.toString());
        return sb.toString();
    }

    private String getKeyListWithComma(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbKeyFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()));
            sb.append(",");
        }
        String results = sb.substring(0,sb.length()-1);
        //System.out.println("字段的使用函数参数拼接，用在函数使用的时候参数列表:"+results);
        return results;
    }

    private String getConditionListWithComma(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = conditionFieldWrapperList;
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()));
            sb.append(",");
        }
        String results = sb.substring(0,sb.length()-1);
        //System.out.println("字段的使用函数参数拼接，用在函数使用的时候参数列表:"+results);
        return results;
    }

    private String getKeyListWithType(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbKeyFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(bFieldWrapper.getJavatype());sb.append(" ");sb.append(bFieldWrapper.getFieldname());
            sb.append(",");
        }
        String results = sb.substring(0,sb.length()-1);
        //System.out.println("字段的函数声明，用在函数参数的声明，包括类型:"+results);
        return results;
    }


    private String getCondtionListWithType(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = conditionFieldWrapperList;
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(bFieldWrapper.getJavatype());sb.append(" ");sb.append(bFieldWrapper.getFieldname());
            sb.append(",");
        }
        String results = sb.substring(0,sb.length()-1);
        //System.out.println("字段的函数声明，用在函数参数的声明，包括类型:"+results);
        return results;
    }

    private String getSelectFieldList(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            sb.append(MyStringUtils.UpperFirstString(bFieldWrapper.getFieldname()));
        }
        //System.out.println("字段的拼接,用在函数的命名:"+sb.toString());
        return sb.toString();
    }

    private String getConditionFieldList(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:conditionFieldWrapperList){
            sb.append(MyStringUtils.UpperFirstString(bFieldWrapper.getFieldname()));
        }
        //System.out.println("字段的拼接,用在函数的命名:"+sb.toString());
        return sb.toString();
    }

    private String getSelectFieldListWithComma(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){

//            if(!bFieldWrapper.getFieldname().equalsIgnoreCase("updateTime")) {
//                sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()) + "Inc");
//                sb.append(",");
//            }else {
                sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()));
                sb.append(",");
//            }
        }
        String results = sb.substring(0,sb.length()-1);
        //System.out.println("字段的使用函数参数拼接，用在函数使用的时候参数列表:"+results);
        return results;
    }

    private String getSelectFieldListWithCommaInc(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            if(!bFieldWrapper.getFieldname().equalsIgnoreCase("updateTime")) {
                sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()) + "Inc");
                sb.append(",");
            }else {
                sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()));
                sb.append(",");
            }
        }
        String results = sb.substring(0,sb.length()-1);
        //System.out.println("字段的使用函数参数拼接，用在函数使用的时候参数列表:"+results);
        return results;
    }

    private String getSelectFieldListWithType(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
//            if(!bFieldWrapper.getFieldname().equalsIgnoreCase("updateTime")) {
//                sb.append(bFieldWrapper.getJavatype());sb.append(" ");sb.append(bFieldWrapper.getFieldname()+"Inc");
//                sb.append(",");
//            }else {
                sb.append(bFieldWrapper.getJavatype());sb.append(" ");sb.append(bFieldWrapper.getFieldname());
                sb.append(",");
//            }
        }
        String results = sb.substring(0,sb.length()-1);
        //System.out.println("字段的函数声明，用在函数参数的声明，包括类型:"+results);
        return results;
    }


    private String getSelectFieldListWithTypeInc(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            if(!bFieldWrapper.getFieldname().equalsIgnoreCase("updateTime")) {
                sb.append(bFieldWrapper.getJavatype());sb.append(" ");sb.append(bFieldWrapper.getFieldname()+"Inc");
                sb.append(",");
            }else {
                sb.append(bFieldWrapper.getJavatype());sb.append(" ");sb.append(bFieldWrapper.getFieldname());
                sb.append(",");
            }
        }
        String results = sb.substring(0,sb.length()-1);
        //System.out.println("字段的函数声明，用在函数参数的声明，包括类型:"+results);
        return results;
    }

    public void init(){
        System.out.println("init alert...");
        //this.tablename ="js_action";
        if(tablenameTextField==null){
            System.out.println("tablename is null");
        }else {
            tablenameTextField.setText(tablename);
        }
        //this.tableWrapper=bTableWrapper;
    }


    public void init(BTableWrapper bTableWrapper){
        System.out.println("init alert...");
        //this.tablename ="js_action";
        System.out.println(getTablename());
//        tablenameTextField.setText(getTablename());
//        if(tablenameTextField==null){
//            System.out.println("tablename is null");
//        }else {
//            tablenameTextField.setText(tablename);
//        }
        this.tableWrapper=bTableWrapper;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController ;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public BTableWrapper getTableWrapper() {
        return tableWrapper;
    }

    public void setTableWrapper(BTableWrapper tableWrapper) {
        this.tableWrapper = tableWrapper;
    }


    public boolean isUseKey() {
        return useKey;
    }

    public void setUseKey(boolean useKey) {
        this.useKey = useKey;
    }

    public boolean isAddCondtion() {
        return addCondtion;
    }

    public void setAddCondtion(boolean addCondtion) {
        this.addCondtion = addCondtion;
    }
}
