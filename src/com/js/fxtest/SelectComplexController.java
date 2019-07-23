package com.js.fxtest;

import com.js.code.Controller;
import com.js.code.db.DBUtil;
import com.js.dbauto.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.swing.*;
import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectComplexController implements Initializable{

    int VGAP=4;
    int HGAP=4;

    private MainController mainController ;
    @FXML
    String tablename;
    @FXML
    TextField tablenameTextField;
    @FXML
    //字段checkRadio
    FlowPane checkRadioPane;
    @FXML
    // 要查询选择的字段
    ListView fieldListView;
    @FXML
    //查询条件
    ListView conditionListView;
    @FXML
    //查询的顺序排列
    ListView orderByListView;

    //操作符选项(> < >= <= =操作符 默认为=)
    @FXML
    ChoiceBox operatorChoiceBox;
    //降序还是升序(默认降序)
    @FXML
    ChoiceBox orderByChoiceBox;
    //是否分页(默认分页)
    @FXML
    ChoiceBox isPageChoiceBox;
    //返回值类型(List<Bean> List<Type> 默认List<Bean>)
    @FXML
    ChoiceBox returnResultChoiceBox;
    //函数名是否拼接,用于选择所有字段的时候使用
    @FXML
    ChoiceBox fieldNameConcatChoiceBox;


    List<String> fieldList;

    private Controller controller;
    boolean useKey=true;

    CheckBox[] cbs;
    RadioButton[] rbs;
    RadioButton[]  rbOrders;

    private BTableWrapper tableWrapper;
    //这个是查询字段信息的选择的List
    List<BFieldWrapper> searchFieldWrapperList;
    //这个FieldList 查询条件需要的field
    List<BFieldWrapper> selectByFieldWrapperList;
    List<BFieldWrapper> conditionFieldWrapperList;
    List<Condition> conditions;
    List<OrderBy> orders;

    VelocityEngine velocityEngine = new VelocityEngine();
    VelocityContext context = new VelocityContext();

    List<String> selectFieldNameList = new ArrayList();
    List<String> conditionList= new ArrayList();
    List<String> orderByList = new ArrayList();
    String isPageable="Pageable";
    String returnType="bean";
    String fieldNameConcat="fieldConcat";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("select complex controller...");
        System.out.println("tablename:"+tablename);
        tablenameTextField.setText(tablename);

        checkRadioPane.setHgap(10);
        checkRadioPane.setVgap(10);

        if(!useKey){
            fieldList = DBUtil.getFieldNotPrimaryKeyList(tablename);
        }else {
            fieldList = DBUtil.getFieldList(tablename);
        }

        //初始化条件字段
        doInitConditionList();

        //初始化要选择字段
        doInitSelectList();

        ObservableList<String> conditionStrList = FXCollections.observableArrayList(conditionList);
        conditionListView.setItems(conditionStrList);

        MenuItem deleteConditionItem = new MenuItem("delete condition item");
        ContextMenu  contextConditionMenu = new ContextMenu(deleteConditionItem);
        conditionListView.addEventHandler(MouseEvent.MOUSE_CLICKED,  (MouseEvent  me) ->  {
            if (me.getButton() == MouseButton.SECONDARY  || me.isControlDown())  {
                System.out.println("condition list 单击右键");
                contextConditionMenu.show(conditionListView, me.getScreenX(), me.getScreenY());
            }  else  {
                contextConditionMenu.hide();
            }
        });

        deleteConditionItem.setOnAction((ActionEvent t) -> {
            System.out.println("delete condition item");
            int selectIndex = conditionListView.getSelectionModel().getSelectedIndex();
            if(selectIndex==-1){
                System.out.println("请先选择项目");
            }
            conditionListView.getItems().remove(selectIndex);
        });


        ObservableList<String> orderByStrList = FXCollections.observableArrayList(orderByList);
        orderByListView.setItems(orderByStrList);
        MenuItem deleteOrderItem = new MenuItem("delete order item");
        ContextMenu  contextFileMenu1 = new ContextMenu(deleteOrderItem);
        orderByListView.addEventHandler(MouseEvent.MOUSE_CLICKED,  (MouseEvent  me) ->  {
            if (me.getButton() == MouseButton.SECONDARY  || me.isControlDown())  {
                System.out.println("order by list 单击右键");
                contextFileMenu1.show(orderByListView, me.getScreenX(), me.getScreenY());
            }  else  {
                contextFileMenu1.hide();
            }
        });

        deleteOrderItem.setOnAction((ActionEvent t) -> {
            System.out.println("delete order item");
            int selectIndex = orderByListView.getSelectionModel().getSelectedIndex();
            if(selectIndex==-1){
                System.out.println("请先选择项目");
            }
            orderByListView.getItems().remove(selectIndex);
        });

        //初始化话choicebox
        String[] operatorList = {"=", ">", "<",">=","<=","<>"};
        //operatorChoiceBox = new ChoiceBox(FXCollections.observableArrayList());
        operatorChoiceBox.setItems(FXCollections.observableArrayList(operatorList));
        operatorChoiceBox.setTooltip(new Tooltip("Select sql 操作符，默认等于="));
        operatorChoiceBox.getSelectionModel().selectFirst();

        //初始化升序降序choicebox
        String[] orderByStringList = {"desc","asc"};
        orderByChoiceBox.setItems(FXCollections.observableArrayList(orderByStringList));
        orderByChoiceBox.setTooltip(new Tooltip("选择升序或者降序desc，默认为降序asc"));
        orderByChoiceBox.getSelectionModel().selectNext();

        //初始化分页choicebox
        String[] isPageable = {"Pageable","noPageable"};
        isPageChoiceBox.setItems(FXCollections.observableArrayList(isPageable));
        isPageChoiceBox.setTooltip(new Tooltip("选择是否分页，默认为分页pageable,不分页noPageable"));
        isPageChoiceBox.getSelectionModel().selectFirst();

        //初始化返回类型
        String[] returnTypeList = {"bean","Integer","String","Long"};
        returnResultChoiceBox.setItems(FXCollections.observableArrayList(returnTypeList));
        returnResultChoiceBox.setTooltip(new Tooltip("选择返回类型，默认为bean"));
        returnResultChoiceBox.getSelectionModel().selectFirst();

        //函数名是否字段名串接，一般需要，只有在字段全选的时候不使用字段连接
        String[] fieldNameConcatList = {"fieldConcat","fieldNoConcate"};
        fieldNameConcatChoiceBox.setItems(FXCollections.observableArrayList(fieldNameConcatList));
        fieldNameConcatChoiceBox.setTooltip(new Tooltip("函数名是否使用字段连接，默认使用字段连接，只有在字段全选的时候不使用字段连接"));
        fieldNameConcatChoiceBox.getSelectionModel().select(1);
    }

    private void doInitSelectList(){
        int len = fieldList.size();
        //初始化话要选择的字段
        ObservableList<String> strList = FXCollections.observableArrayList(fieldList);
        //ListView<String> listView = new ListView<>(strList);
        fieldListView.setItems(strList);
        fieldListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //默认是全选
        fieldListView.getSelectionModel().selectAll();

        fieldListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {

                        int selectSize =fieldListView.getSelectionModel().getSelectedItems().size();
                        System.out.println("list view 改变 个数:"+selectSize);
                        //如果是全选则选1不用concat
                        if(selectSize==len) {
                            fieldNameConcatChoiceBox.getSelectionModel().select(1);
                        }else fieldNameConcatChoiceBox.getSelectionModel().select(0);

                        //只选了一个，则在返回List上面选择具体类型，否则就是bean.一般只有具体类型
                        if(selectSize==1){
                            String fieldname=(String)fieldListView.getSelectionModel().getSelectedItem();
                            System.out.println("选择的字段名:"+fieldname);
                            BFieldWrapper bFieldWrapper=tableWrapper.getbFieldWrapperMap().get(StringTool.underLineToHump(fieldname));
                            System.out.println("字段的java类型:"+bFieldWrapper.getJavatype());
                            String javaType = bFieldWrapper.getJavatype();
                            if(javaType.equalsIgnoreCase("int")||javaType.equalsIgnoreCase("Integer")){
                                //否则选bean,为第一项
                                System.out.println("选择integer");
                                returnResultChoiceBox.getSelectionModel().select(1);
                            }else if(javaType.equalsIgnoreCase("long")){
                                System.out.println("选择long");
                                returnResultChoiceBox.getSelectionModel().select(3);
                            }else if(javaType.equalsIgnoreCase("String")){
                                System.out.println("选择string");
                                returnResultChoiceBox.getSelectionModel().select(2);
                            }

                        }else {
                            //否则选bean,为第一项
                            System.out.println("选择bean");
                            returnResultChoiceBox.getSelectionModel().select(0);
                        }
                    }
                });
    }

    private void doInitConditionList(){
        int len = fieldList.size();
        cbs = new CheckBox[len];
        rbs = new RadioButton[len];

        rbOrders = new RadioButton[len];
        checkRadioPane.getChildren().add(new Label("以下是条件选择字段"));
        VBox vBox = new VBox();
        checkRadioPane.getChildren().add(vBox);
        vBox.setMaxWidth(200);

        Separator separator1 = new Separator();
        separator1.setMinWidth(300);
        vBox.getChildren().add(separator1);
        FlowPane conditionFlowPane = new FlowPane();

        ScrollPane scrollPane = new ScrollPane(conditionFlowPane);
        scrollPane.setPrefHeight(300);scrollPane.setMinHeight(300);
        scrollPane.setMinWidth(100);scrollPane.setMaxWidth(150);scrollPane.setPrefWidth(150);
        vBox.getChildren().add(conditionFlowPane);
        //初始化要操作的字段 condition
        for(int i=0;i<len;i++){
            String fieldname = fieldList.get(i);
            //如果是updateTime则让其选定
            CheckBox cb=cbs[i]=new CheckBox(fieldname);
            RadioButton rb = rbs[i] = new RadioButton(fieldname);
            conditionFlowPane.getChildren().add(rb);
            conditionFlowPane.setVgap(VGAP);
            conditionFlowPane.setHgap(HGAP);
            //这个非常好，已经搞定
            rb.setOnAction(event->{
                System.out.println("i am clicked:"+rb.getText());
                doAddCondition();
                //rb.setText("Hello World, I am JavaFX!");
            });
        }
        Separator separator2 = new Separator();
        separator2.setMinWidth(300);
        //checkRadioPane.getChildren().add(separator2);
        //checkRadioPane.getChildren().add(new Label("以下是顺序选择字段"));
        Separator separator3 = new Separator();
        separator2.setMinWidth(300);
        vBox.getChildren().add(new Label("以下是顺序选择字段"));
        vBox.getChildren().add(separator2);
        //checkRadioPane.getChildren().add(separator3);

        FlowPane orderByFlowPane = new FlowPane();
        ScrollPane scrollPane1 = new ScrollPane(orderByFlowPane);
        scrollPane1.setPrefHeight(300);scrollPane1.setMinHeight(300);
        scrollPane1.setMinWidth(100);scrollPane1.setMaxWidth(150);scrollPane1.prefWidth(150);

        vBox.getChildren().add(orderByFlowPane);
        scrollPane.setMaxWidth(300);
        //checkRadioPane.getChildren().addAll(scrollPane);

        //初始化 初始化顺序 order
        for(int i=0;i<len;i++){
            String fieldname = fieldList.get(i);
            //如果是updateTime则让其选定
            //CheckBox cb=cbs[i]=new CheckBox(fieldname);
            RadioButton rb = rbOrders[i] = new RadioButton(fieldname);
            //checkRadioPane.getChildren().add(rb);
            orderByFlowPane.getChildren().add(rb);
            orderByFlowPane.setHgap(HGAP);
            orderByFlowPane.setVgap(VGAP);
            //这个非常好，已经搞定
            rb.setOnAction(event->{
                System.out.println("i am clicked:"+rb.getText());
                doAddOrderBy();
                //rb.setText("Hello World, I am JavaFX!");
            });
        }
    }

    private void getSelectedFieldListFromRadioButtons(){
        selectByFieldWrapperList =new ArrayList<>();
        int len = rbs.length;
        for(int i=0;i<len;i++){
            RadioButton rb = rbs[i];
            if(rb.isSelected()){
                String tablefieldname = rb.getText();
                System.out.println("table field name:"+tablefieldname);
                String fieldname = StringTool.underLineToHump(tablefieldname);
                System.out.println("field name:"+fieldname);
                BFieldWrapper selectFieldWrapper = getTableWrapper().getbFieldWrapperMap().get(fieldname);
                selectByFieldWrapperList.add(selectFieldWrapper);
            }
        }
        if(selectByFieldWrapperList.size()<1) System.out.println("请选择字段");
    }


    private void getSelectedOrderByFieldListFromRadioButtons(){
        selectByFieldWrapperList =new ArrayList<>();
        int len = rbOrders.length;
        for(int i=0;i<len;i++){
            RadioButton rb = rbOrders[i];
            if(rb.isSelected()){
                String tablefieldname = rb.getText();
                System.out.println("table field name:"+tablefieldname);
                String fieldname = StringTool.underLineToHump(tablefieldname);
                System.out.println("field name:"+fieldname);
                BFieldWrapper selectFieldWrapper = getTableWrapper().getbFieldWrapperMap().get(fieldname);
                selectByFieldWrapperList.add(selectFieldWrapper);
            }
        }
        if(selectByFieldWrapperList.size()<1) System.out.println("请选择字段");
    }

    private void clearRadioButtonsSelected(){
        int len = rbs.length;
        for(int i=0;i<len;i++){
            RadioButton rb = rbs[i];
            if(rb.isSelected()){
                rb.setSelected(false);
            }
        }

        int len2 = rbOrders.length;
        for(int i=0;i<len;i++){
            RadioButton rb = rbOrders[i];
            if(rb.isSelected()){
                rb.setSelected(false);
            }
        }
    }

    @FXML
    public void getSelectFieldNameList(){
        selectFieldNameList = fieldListView.getSelectionModel().getSelectedItems();
    }

    public String getReturnTypeFromChoiceBox(){
        returnType = (String)returnResultChoiceBox.getSelectionModel().getSelectedItem();
        return returnType;
    }

    @FXML
    public void doAddCondition(){
        getSelectedFieldListFromRadioButtons();
        //第一个
        BFieldWrapper fieldWrapper = selectByFieldWrapperList.get(0);
        String tableFieldName = fieldWrapper.getTableFieldName();
        String operator = (String)operatorChoiceBox.getSelectionModel().getSelectedItem();
        StringBuffer sb = new StringBuffer(tableFieldName);
        sb.append(operator).append("?");

        Condition condition = new Condition(tableFieldName,operator);
        conditionListView.getItems().add(condition);
        clearRadioButtonsSelected();
    }

    @FXML
    public void doAddOrderBy(){
        getSelectedOrderByFieldListFromRadioButtons();
        //第一个
        BFieldWrapper fieldWrapper = selectByFieldWrapperList.get(0);
        String fieldname = fieldWrapper.getFieldname();
        String order = (String)orderByChoiceBox.getSelectionModel().getSelectedItem();
        StringBuffer sb = new StringBuffer(fieldname);
        sb.append(" ").append(order);
       // orderByList.clear();
        //orderByList.add(sb.toString());

        OrderBy orderBy = new OrderBy(fieldname,order);
        orderByListView.getItems().add(orderBy);
        clearRadioButtonsSelected();
    }

    @FXML
    public void doCreateUpdateCode(){
        System.out.println("您选择了一下字段:");
        selectByFieldWrapperList = new ArrayList<>();
        doFillSelectFieldList();
        System.out.println("选择的字段大小:"+selectByFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectByFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }
        CodeConcat codeConcat = getCodeConcat();
    }

    @FXML
    public void doCreateSelectFieldComplexCodeNoBean(){
        System.out.println("您选择了一下字段:");

        conditions = conditionListView.getItems();

        System.out.println("conditions size:"+conditions.size());
        orders = orderByListView.getItems();
        System.out.println("orderbys size:"+orders.size());
        selectByFieldWrapperList = new ArrayList<>();
        for(Condition c:conditions){
            String fieldname = c.getTablefieldname();
            String humpName = StringTool.underLineToHump(fieldname);
            System.out.println("hump name:"+humpName);
            BFieldWrapper bFieldWrapper = getTableWrapper().getbFieldWrapperMap().get(humpName);
            selectByFieldWrapperList.add(bFieldWrapper);
        }
        getSelectFieldNameList();

        System.out.println("选择的字段大小:"+selectByFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectByFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }

        fieldNameConcat = (String) fieldNameConcatChoiceBox.getSelectionModel().getSelectedItem();



        CodeConcat codeConcat = getCodeConcatWithSearchFields(selectFieldNameList,fieldNameConcat);
        conditionList = conditionListView.getSelectionModel().getSelectedItems();
        orderByList = orderByListView.getSelectionModel().getSelectedItems();
        isPageable = (String)isPageChoiceBox.getSelectionModel().getSelectedItem();//0降序，1升序
        doGenCreateSelectComplexFieldCode(codeConcat,selectFieldNameList,conditions,orders,isPageable);
    }


    @FXML
    public void doCreateSelectFieldComplexCodeNoBeanNoReplace(){
        System.out.println("您选择了一下字段:");

        conditions = conditionListView.getItems();

        System.out.println("conditions size:"+conditions.size());
        orders = orderByListView.getItems();
        System.out.println("orderbys size:"+orders.size());
        selectByFieldWrapperList = new ArrayList<>();
        for(Condition c:conditions){
            String fieldname = c.getTablefieldname();
            String humpName = StringTool.underLineToHump(fieldname);
            System.out.println("hump name:"+humpName);
            BFieldWrapper bFieldWrapper = getTableWrapper().getbFieldWrapperMap().get(humpName);
            selectByFieldWrapperList.add(bFieldWrapper);
        }
        getSelectFieldNameList();

        System.out.println("选择的字段大小:"+selectByFieldWrapperList.size());
        for(BFieldWrapper bFieldWrapper:selectByFieldWrapperList){
            System.out.println(bFieldWrapper.getFieldname());
        }

        fieldNameConcat = (String) fieldNameConcatChoiceBox.getSelectionModel().getSelectedItem();



        CodeConcat codeConcat = getCodeConcatWithSearchFields(selectFieldNameList,fieldNameConcat);
        conditionList = conditionListView.getSelectionModel().getSelectedItems();
        orderByList = orderByListView.getSelectionModel().getSelectedItems();
        isPageable = (String)isPageChoiceBox.getSelectionModel().getSelectedItem();//0降序，1升序
        doGenCreateSelectComplexFieldCodeNoReplace(codeConcat,selectFieldNameList,conditions,orders,isPageable);
    }

    private void doGenCreateSelectComplexFieldCode(CodeConcat codeConcat,List<String> selectFieldNameList,List<Condition> conditions,List<OrderBy> orders,String isPageable){
        System.out.println("create bean code");
        //initTableParameters();
        String orderByFields="";
        for(OrderBy orderBy:orders){
            //首写字母最好还是大写
            orderByFields += StringUtil.capital(orderBy.getFieldname())+StringUtil.capital(orderBy.getOrder());
        }

        String fieldConditionConcat=getFieldConditionConcat(conditions);

        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        context.put("orderByFields",orderByFields);
        context.put("fieldConditionConcat",fieldConditionConcat);

        SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectByFieldWrapperList);

        String select_complex_sql = SqlUtils.getFindComplexSql(tableWrapper.getTablename(),selectFieldNameList,conditions,orders,isPageable);
        String returnType = getReturnTypeFromChoiceBox();
        String select_complex_set_param = SqlUtils.getFindComplexSetParam(tableWrapper,selectFieldNameList,returnType);
        String select_complex_sql_param = SqlUtils.getFindComplexSqlParam(tableWrapper,conditions,isPageable);
        context.put("sqlAndParam",sqlAndParam);
        context.put("select_complex_sql",select_complex_sql);
        context.put("select_complex_sql_param",select_complex_sql_param);
        context.put("select_complex_set_param",select_complex_set_param);
        context.put("returnType",returnType);

        StringWriter sw = new StringWriter();

        if(isPageable.equalsIgnoreCase("Pageable")){
            velocityEngine.mergeTemplate("src/templates/findComplexBySelectFieldPageNoBean.vm", "utf-8", context, sw);
        }else if(isPageable.equalsIgnoreCase("noPageable")){
            velocityEngine.mergeTemplate("src/templates/findComplexBySelectFieldNoBean.vm", "utf-8", context, sw);
        }
        System.out.println(sw.toString());
        //在相应的文件中增加代码
        //replaceCodeFile(sw.toString());
        replaceCodeFile(sw.toString());
        controller.setSqlTextArea(sw.toString());
    }

    /**
     * 不修改源代码,作为测试使用比较好
     * @param codeConcat
     * @param selectFieldNameList
     * @param conditions
     * @param orders
     * @param isPageable
     */
    private void doGenCreateSelectComplexFieldCodeNoReplace(CodeConcat codeConcat,List<String> selectFieldNameList,List<Condition> conditions,List<OrderBy> orders,String isPageable){
        System.out.println("create bean code");

        String orderByFields="";
        for(OrderBy orderBy:orders){
            //首写字母最好还是大写
            orderByFields += StringUtil.capital(orderBy.getFieldname())+StringUtil.capital(orderBy.getOrder());
        }

        String fieldConditionConcat=getFieldConditionConcat(conditions);


        //initTableParameters();
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);
        context.put("orderByFields",orderByFields);
        context.put("fieldConditionConcat",fieldConditionConcat);

        SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectByFieldWrapperList);

        String select_complex_sql = SqlUtils.getFindComplexSql(tableWrapper.getTablename(),selectFieldNameList,conditions,orders,isPageable);
        String returnType = getReturnTypeFromChoiceBox();
        String select_complex_set_param = SqlUtils.getFindComplexSetParam(tableWrapper,selectFieldNameList,returnType);
        String select_complex_sql_param = SqlUtils.getFindComplexSqlParam(tableWrapper,conditions,isPageable);
        context.put("sqlAndParam",sqlAndParam);
        context.put("select_complex_sql",select_complex_sql);
        context.put("select_complex_sql_param",select_complex_sql_param);
        context.put("select_complex_set_param",select_complex_set_param);
        context.put("returnType",returnType);

        StringWriter sw = new StringWriter();

        if(isPageable.equalsIgnoreCase("Pageable")){
            velocityEngine.mergeTemplate("src/templates/findComplexBySelectFieldPageNoBean.vm", "utf-8", context, sw);
        }else if(isPageable.equalsIgnoreCase("noPageable")){
            velocityEngine.mergeTemplate("src/templates/findComplexBySelectFieldNoBean.vm", "utf-8", context, sw);
        }
        System.out.println(sw.toString());
        //在相应的文件中增加代码
        //replaceCodeFile(sw.toString());

        controller.setSqlTextArea(sw.toString());
    }


    private String getFieldConditionConcat(List<Condition> conditions){
        String fieldConditionConcat="";
        for(Condition condition:conditions){
            System.out.println("conditions list --------------------------");
            System.out.println("table field name:"+condition.getTablefieldname()+" hump:"+StringTool.capitalStr(StringTool.underLineToHump(condition.getTablefieldname())));
            String fieldHump= StringTool.capitalStr(StringTool.underLineToHump(condition.getTablefieldname()));
            System.out.println("operator:"+condition.getOperator());
            String opLabel = getOperateLabel(condition.getOperator());
            fieldConditionConcat+=fieldHump+opLabel;
        }
        return fieldConditionConcat;
    }

    private String getOperateLabel(String operator){
        if(operator.equalsIgnoreCase("=")){
            return "Eq";
        }else if(operator.equalsIgnoreCase(">")){
            return "Gt";
        }else if(operator.equalsIgnoreCase("<")){
            return "Lt";
        }else if(operator.equalsIgnoreCase(">=")){
            return "GtEqual";
        }else if(operator.equalsIgnoreCase("<=")){
            return "LtEqual";
        }else if(operator.equalsIgnoreCase("<>")){
            return "NotEqual";
        }
        return "";
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
                String fullPath = getPath() + "\\servread\\" + tableWrapper.getBeanname() + "ServRead.java";
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





    private void doGetSelectTableFieldList(){
        selectFieldNameList = fieldListView.getSelectionModel().getSelectedItems();
    }

    /**
     *这个目的是得到所选定的字段,这里需要修改一下
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
                selectByFieldWrapperList.add(selectFieldWrapper);
            }
        }
        if(selectByFieldWrapperList.size()<1) System.out.println("请选择字段");
    }


    private void doFillSelectFieldFromListView(){
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
                selectByFieldWrapperList.add(selectFieldWrapper);
            }
        }
        if(selectByFieldWrapperList.size()<1) System.out.println("请选择字段");
    }

    /**
     * 包括得到选择的字段拼接，用于函数名的拼接
     * @param selectFieldNameList
     * @return
     */
    private CodeConcat getCodeConcatWithSearchFields(List<String> selectFieldNameList,String fieldNameConcat){
        searchFieldWrapperList = new ArrayList<>();
        for(String f:selectFieldNameList){
            String keyname = StringTool.underLineToHump(f);
            BFieldWrapper bFieldWrapper = getTableWrapper().getbFieldWrapperMap().get(keyname);
            searchFieldWrapperList.add(bFieldWrapper);
        }

        CodeConcat codeConcat = new CodeConcat();
        //codeConcat.setKeyConcat(getKeyList());
        codeConcat.setKeyConcatWithType(getKeyListWithType());
        codeConcat.setKeyConcatWithComma(getKeyListWithComma());
        codeConcat.setFieldConcat(getSelectFieldList());
        codeConcat.setFieldConcatWithComma(getSelectFieldListWithComma());
        codeConcat.setFieldConcatWithType(getSelectFieldListWithType());
        codeConcat.setSearchFieldConcat(getSearchFieldConcat(fieldNameConcat));
        return codeConcat;

    }

    /**
     * 得到search field concat
     * 得到如
     * @return  GroupIdGroupName
     */
    private String getSearchFieldConcat(String fieldNameConcat){
        StringBuffer sb = new StringBuffer("");
        if(!fieldNameConcat.equalsIgnoreCase("fieldNoConcate")){
            for(BFieldWrapper bFieldWrapper:searchFieldWrapperList){
                sb.append(StringTool.capitalStr(bFieldWrapper.getFieldname()));
            }
        }
        return sb.toString();
    }

    /***
     * 用于函数名称的拼接和函数形参实参的拼接
     * @return
     */
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

    /**
     * ActionIdGroupId
     * @return
     */
    private String getKeyList(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbKeyFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(MyStringUtils.UpperFirstString(bFieldWrapper.getFieldname()));
        }
        return sb.toString();
    }

    /**
     * 关键字段的连接，用于实参
     * 如 actionId,groupId等，现在一般只有一个主键，则只用groupActionId,没有类型
     * @return
     */
    private String getKeyListWithComma(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbKeyFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()));
            sb.append(",");
        }
        String results = sb.substring(0,sb.length()-1);
        return results;
    }

    /**
     * 包含主键
     * int userId,int groupId或者actionId,由于现在都只有一个主键，所以返回类似于 int groupActionId,包括字段类型
     * 用于函数参数update语句
     * @return
     */
    private String getKeyListWithType(){
        StringBuffer sb = new StringBuffer();
        List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbKeyFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:bFieldWrapperList){
            sb.append(bFieldWrapper.getJavatype());sb.append(" ");sb.append(bFieldWrapper.getFieldname());
            sb.append(",");
        }
        String results = sb.substring(0,sb.length()-1);
        return results;
    }

    /***
     * 用于函数名称,放在By后面
     * GroupIdUserId
     * @return
     */
    private String getSelectFieldList(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        int size =selectByFieldWrapperList.size();
        if(size>=1) {
            for (BFieldWrapper bFieldWrapper : selectByFieldWrapperList) {
                sb.append(MyStringUtils.UpperFirstString(bFieldWrapper.getFieldname()));
            }
        }else sb.append("All");
        //System.out.println("字段的拼接,用在函数的命名:"+sb.toString());
        return sb.toString();
    }

    /**
     *  返回类似于函数实参的连接串
     *  groupId,userId
     * @return
     */
    private String getSelectFieldListWithComma(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        int size = selectByFieldWrapperList.size();
        String results ="";
        if(size>=1) {
            for (BFieldWrapper bFieldWrapper : selectByFieldWrapperList) {
                sb.append(MyStringUtils.lowFirstString(bFieldWrapper.getFieldname()));
                sb.append(",");
            }
            results = sb.substring(0, sb.length() - 1);
        }
        //System.out.println("字段的使用函数参数拼接，用在函数使用的时候参数列表:"+results);
        return results;
    }

    /***
     * 函数的形参包括类型
     * int groupId,int userId
     * @return
     */
    private String getSelectFieldListWithType(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        int size = selectByFieldWrapperList.size();
        String result="";
        if(size>=1) {
            for (BFieldWrapper bFieldWrapper : selectByFieldWrapperList) {
                sb.append(bFieldWrapper.getJavatype());
                sb.append(" ");
                sb.append(bFieldWrapper.getFieldname());
                sb.append(",");
            }
            result = sb.substring(0, sb.length() - 1);
        } //System.out.println("字段的函数声明，用在函数参数的声明，包括类型:"+results);
        return result;
    }

    public void init(){
        System.out.println("init alert...");
        //this.tablename ="js_action";
        if(tablenameTextField==null){
            System.out.println("tablename is null");
        }else {
            tablenameTextField.setText(tablename);
        }
    }


    public void init(BTableWrapper bTableWrapper){
        System.out.println("init alert...");
        System.out.println(getTablename());
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
}
