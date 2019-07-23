package com.js.fxtest;

import com.js.code.Controller;
import com.js.code.db.DBUtil;
import com.js.dbauto.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.ResourceBundle;

public class AlertController implements Initializable{

    private MainController mainController ;
    @FXML
    String tablename;
    @FXML
    TextField tablenameTextField;

    @FXML
    FlowPane checkboxPane;

    List<String> fieldList;

    private Controller controller;

    CheckBox[] cbs;
    private BTableWrapper tableWrapper;
    List<BFieldWrapper> selectFieldWrapperList;

    VelocityEngine velocityEngine = new VelocityEngine();
    VelocityContext context = new VelocityContext();

    boolean noBean=false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("alert controller...");
        System.out.println("tablename:"+tablename);
        tablenameTextField.setText(tablename);

        fieldList = DBUtil.getFieldList(tablename);
        int len = fieldList.size();
        cbs = new CheckBox[len];
        checkboxPane.setHgap(10);
        checkboxPane.setVgap(10);

        for(int i=0;i<len;i++){
            CheckBox cb=cbs[i]=new CheckBox(fieldList.get(i));
            checkboxPane.getChildren().add(cb);
        }
    }

    @FXML
    public void doCreateFindCode(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        doGenCreateFindCode(codeConcat);
    }

    @FXML
    public void doCreateFindBySelectFieldCode(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        doGenCreateFindBySelectFieldCode(codeConcat);
    }

    @FXML
    public void doCreateFindBySelectFieldCodeNoBean(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        noBean = true;
        doGenCreateFindBySelectFieldCode(codeConcat);
    }

    @FXML
    public void doCreateFindBySelectFieldCodePage(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        doGenCreateFindBySelectFieldCodePage(codeConcat);
    }

    @FXML
    public void doCreateFindBySelectFieldCodePageNoBean(){
        System.out.println("您选择了一下字段:");
        selectFieldWrapperList = new ArrayList<>();

        doFillSelectFieldList();

        System.out.println("选择的字段大小:"+selectFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
        noBean=true;
        doGenCreateFindBySelectFieldCodePage(codeConcat);
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
    }

    private void doGenCreateFindBySelectFieldCode(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();
        SQLAndParam sqlAndParam = new SQLAndParam(tableWrapper,selectFieldWrapperList);
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        context.put("sqlAndParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        if(noBean)
            velocityEngine.mergeTemplate("src/templates/findBySelectFieldNoBean.vm", "utf-8", context, sw);
        else
            velocityEngine.mergeTemplate("src/templates/findBySelectField.vm", "utf-8", context, sw);

        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.setSqlTextArea(sw.toString());
    }

    private void doGenCreateFindBySelectFieldCodePage(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();
        SQLAndParam sqlAndParam = new SQLAndParam(tableWrapper,selectFieldWrapperList);
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        context.put("sqlAndParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        if(noBean)
            velocityEngine.mergeTemplate("src/templates/findBySelectFieldPageNoBean.vm", "utf-8", context, sw);
        else
            velocityEngine.mergeTemplate("src/templates/findBySelectFieldPage.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.setSqlTextArea(sw.toString());
    }

    private void doGenCreateFindCode(CodeConcat codeConcat){
        System.out.println("create bean code");
        //initTableParameters();
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/find.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.setSqlTextArea(sw.toString());
    }

    private CodeConcat getCodeConcat(){
        CodeConcat codeConcat = new CodeConcat();
        codeConcat.setKeyConcat(getKeyList());
        codeConcat.setKeyConcatWithType(getKeyListWithType());
        codeConcat.setKeyConcatWithComma(getKeyListWithComma());
        codeConcat.setFieldConcat(getSelectFieldList());
        codeConcat.setFieldConcatWithComma(getSelectFieldListWithComma());
        codeConcat.setFieldConcatWithType(getSelectFieldListWithType());
        return codeConcat;
    }

    private String getKeyList(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbKeyFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(MyStringUtils.UpperFirstString(bFieldWrapper.getFieldname()));
        }
        System.out.println("字段的拼接,用在函数的命名:"+sb.toString());
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
        System.out.println("字段的使用函数参数拼接，用在函数使用的时候参数列表:"+results);
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
        System.out.println("字段的函数声明，用在函数参数的声明，包括类型:"+results);
        return results;
    }

    private String getSelectFieldList(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            sb.append(MyStringUtils.UpperFirstString(bFieldWrapper.getFieldname()));
        }
        System.out.println("字段的拼接,用在函数的命名:"+sb.toString());
        return sb.toString();
    }

    private String getSelectFieldListWithComma(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()));
            sb.append(",");
        }
        String results = sb.substring(0,sb.length()-1);
        System.out.println("字段的使用函数参数拼接，用在函数使用的时候参数列表:"+results);
        return results;
    }

    private String getSelectFieldListWithType(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            sb.append(bFieldWrapper.getJavatype());sb.append(" ");sb.append(bFieldWrapper.getFieldname());
            sb.append(",");
        }
        String results = sb.substring(0,sb.length()-1);
        System.out.println("字段的函数声明，用在函数参数的声明，包括类型:"+results);
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
        if(tablenameTextField==null){
            System.out.println("tablename is null");
        }else {
            tablenameTextField.setText(tablename);
        }
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
}
