package com.js.fxtest;

import com.js.code.Config;
import com.js.code.Controller;
import com.js.code.db.DBUtil;
import com.js.code.def.FrameWorkType;
import com.js.code.def.ViewTemplate;
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
import java.io.*;
import java.net.URL;
import java.util.*;

public class UpdateFieldsController implements Initializable{

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
    ListView updateFieldListView;
    @FXML
    //查询的顺序排列
    ListView orderByListView;

    @FXML
    ChoiceBox htmlCompnentChoiceBox;

    @FXML
    ChoiceBox fieldNameConcatChoiceBox;

    boolean addCondtion;

    List<String> fieldList;

    private Controller controller;
    boolean useKey=true;

    CheckBox[] cbs;
    RadioButton[] rbs;
    RadioButton[]  rbOrders;

    private BTableWrapper tableWrapper;
    //这个是查询字段信息的选择的List
    List<BFieldWrapper> searchFieldWrapperList=new ArrayList<>();
    List<BFieldWrapper> selectFieldWrapperList=new ArrayList<>();


    //这个FieldList 查询条件需要的field
    List<BFieldWrapper> selectByFieldWrapperList=new ArrayList<>();
    List<BFieldWrapper> conditionFieldWrapperList=new ArrayList<>();
    List<Condition> conditions;
    List<OrderBy> orders;

    VelocityEngine velocityEngine = new VelocityEngine();
    VelocityContext context = new VelocityContext();

    List<String> selectFieldNameList = new ArrayList();
    //List<String> conditionList= new ArrayList();

    //List<String> selectUpdateField
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
        //doInitConditionList();

        //初始化要选择字段
        doInitSelectList();

        updateFieldListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        MenuItem deleteFieldItem = new MenuItem("delete field item");
        ContextMenu  contextConditionMenu = new ContextMenu(deleteFieldItem);

        updateFieldListView.addEventHandler(MouseEvent.MOUSE_CLICKED,  (MouseEvent  me) ->  {
            if (me.getButton() == MouseButton.SECONDARY  || me.isControlDown())  {
                System.out.println("field list 单击右键");
                contextConditionMenu.show(updateFieldListView, me.getScreenX(), me.getScreenY());
            }  else  {
                contextConditionMenu.hide();
            }
        });

        deleteFieldItem.setOnAction((ActionEvent t) -> {
            System.out.println("delete field item");
            int selectIndex = updateFieldListView.getSelectionModel().getSelectedIndex();
            if(selectIndex==-1){
                System.out.println("请先选择项目");
            }
            updateFieldListView.getItems().remove(selectIndex);
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


        //初始化html choicebox
        //初始化话choicebox
        String[] htmlComponentList = {"text", "password", "select","textarea","radio","checkbox"};
        //operatorChoiceBox = new ChoiceBox(FXCollections.observableArrayList());
        htmlCompnentChoiceBox.setItems(FXCollections.observableArrayList(htmlComponentList));
        htmlCompnentChoiceBox.setTooltip(new Tooltip("html 组件，默认为text"));
        htmlCompnentChoiceBox.getSelectionModel().selectFirst();



    }

    private void doInitSelectList(){
        //init();
        int len = fieldList.size();
        //初始化话要选择的字段
        ObservableList<String> strList = FXCollections.observableArrayList(fieldList);
        //ListView<String> listView = new ListView<>(strList);
        fieldListView.setItems(strList);
        fieldListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //默认是不选
        //fieldListView.getSelectionModel().selectAll();

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
                        }else {
                        }
                    }
                });
    }

    private void doInitUpdateList(){
        int len = fieldList.size();
        cbs = new CheckBox[len];
        rbs = new RadioButton[len];


        rbOrders = new RadioButton[len];
        checkRadioPane.getChildren().add(new Label("以下是field选择字段"));
        VBox vBox = new VBox();
        checkRadioPane.getChildren().add(vBox);
        vBox.setMaxWidth(200);

        Separator separator1 = new Separator();
        separator1.setMinWidth(300);
        vBox.getChildren().add(separator1);
        FlowPane conditionFlowPane = new FlowPane();
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
                doAddUpdateField();
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
        vBox.getChildren().add(orderByFlowPane);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxWidth(300);
        scrollPane.setContent(orderByFlowPane);
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

    private void getSelectedFieldListFromListView(){
        selectByFieldWrapperList =new ArrayList<>();
        String selectFieldName=(String)fieldListView.getSelectionModel().getSelectedItem();
        System.out.println("field name:"+selectFieldName);
        String fieldname= StringUtil.getTableNameHump(selectFieldName);
        BFieldWrapper selectFieldWrapper = getTableWrapper().getbFieldWrapperMap().get(fieldname);
        selectByFieldWrapperList.add(selectFieldWrapper);
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

    private void clearFieldListViewSelected(){
        fieldListView.getSelectionModel().clearSelection();
    }

    @FXML
    public void getSelectFieldNameList(){
        selectFieldNameList = fieldListView.getSelectionModel().getSelectedItems();
    }



    @FXML
    public void doAddUpdateField(){
        //getSelectedFieldListFromListView();
        //第一个
        //BFieldWrapper fieldWrapper = selectByFieldWrapperList.get(0);
        String tableFieldName = (String)fieldListView.getSelectionModel().getSelectedItem();
        String fieldname = StringTool.underLineToHump(tableFieldName);
        String htmlComponentName = (String)htmlCompnentChoiceBox.getSelectionModel().getSelectedItem();

        System.out.println("fieldname:"+fieldname);
        System.out.println("map:"+tableWrapper.getbFieldWrapperMap());

        BFieldWrapper bFieldWrapper = tableWrapper.getbFieldWrapperMap().get(fieldname);

        HtmlFieldWrapper htmlFieldWrapper = new HtmlFieldWrapper();
        htmlFieldWrapper.setbFieldWrapper(bFieldWrapper);
        htmlFieldWrapper.setHtmlComponent(htmlComponentName);

        updateFieldListView.getItems().add(htmlFieldWrapper);
        updateFieldListView.getSelectionModel().selectAll();
        clearFieldListViewSelected();
    }

    @FXML
    public void doAddOrderBy(){
        getSelectedOrderByFieldListFromRadioButtons();
        //第一个
        BFieldWrapper fieldWrapper = selectByFieldWrapperList.get(0);
        String fieldname = fieldWrapper.getFieldname();
        String order ="";
        StringBuffer sb = new StringBuffer(fieldname);
        sb.append(" ").append(order);
        orderByList.add(sb.toString());

        OrderBy orderBy = new OrderBy(fieldname,order);
        orderByListView.getItems().add(orderBy);
        //clearRadioButtonsSelected();
    }

    @FXML
    private void doCreateUpdateFieldsCode(){
        System.out.println("table:"+tableWrapper.getBeanname());
        System.out.println(" field size:"+tableWrapper.getbFieldWrapperList().size());
        //updateFieldListView.getSelectionModel().getSelectedItems();

        List<BFieldWrapper> bFieldWrapperList = tableWrapper.getbFieldWrapperList();
        for(BFieldWrapper fieldWrapper:bFieldWrapperList){
            System.out.println("fieldname:"+fieldWrapper.getFieldname());
        }
        Map<String,BFieldWrapper> bFieldWrapperMap = tableWrapper.getbFieldWrapperMap();
        Set<String> fieldWrapperSet = bFieldWrapperMap.keySet();
        for(String key:fieldWrapperSet){
            System.out.println("fname:"+key);
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(key);
            System.out.println("map fname:"+bFieldWrapper.getFieldname());
        }

        List<HtmlFieldWrapper> htmlFieldWrapperList = updateFieldListView.getSelectionModel().getSelectedItems();
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
        }
        doCreateBeanUpdateViewCode(htmlFieldWrapperList);
    }

    @FXML private void doCreateListFieldsControllerCode(){
        System.out.println("list controller");
        System.out.println("list file ");
        System.out.println("table:"+tableWrapper.getBeanname());
        System.out.println(" field size:"+tableWrapper.getbFieldWrapperList().size());
        //updateFieldListView.getSelectionModel().getSelectedItems();

        List<BFieldWrapper> bFieldWrapperList = tableWrapper.getbFieldWrapperList();
        for(BFieldWrapper fieldWrapper:bFieldWrapperList){
            System.out.println("fieldname:"+fieldWrapper.getFieldname());
        }
        Map<String,BFieldWrapper> bFieldWrapperMap = tableWrapper.getbFieldWrapperMap();
        Set<String> fieldWrapperSet = bFieldWrapperMap.keySet();
        for(String key:fieldWrapperSet){
            System.out.println("fname:"+key);
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(key);
            System.out.println("map fname:"+bFieldWrapper.getFieldname());
        }

        List<HtmlFieldWrapper> htmlFieldWrapperList = updateFieldListView.getSelectionModel().getSelectedItems();
        System.out.println("selectFieldList size:"+htmlFieldWrapperList.size());
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
        }
        doCreateBeanPartPageControllerCode(htmlFieldWrapperList);
    }

    @FXML private void doCreateListFieldsFileCode(){
        System.out.println("list file ");
        System.out.println("table:"+tableWrapper.getBeanname());
        System.out.println(" field size:"+tableWrapper.getbFieldWrapperList().size());
        //updateFieldListView.getSelectionModel().getSelectedItems();

        List<BFieldWrapper> bFieldWrapperList = tableWrapper.getbFieldWrapperList();
        for(BFieldWrapper fieldWrapper:bFieldWrapperList){
            System.out.println("fieldname:"+fieldWrapper.getFieldname());
        }
        Map<String,BFieldWrapper> bFieldWrapperMap = tableWrapper.getbFieldWrapperMap();
        Set<String> fieldWrapperSet = bFieldWrapperMap.keySet();
        for(String key:fieldWrapperSet){
            System.out.println("fname:"+key);
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(key);
            System.out.println("map fname:"+bFieldWrapper.getFieldname());
        }

        List<HtmlFieldWrapper> htmlFieldWrapperList = updateFieldListView.getSelectionModel().getSelectedItems();
        System.out.println("selectFieldList size:"+htmlFieldWrapperList.size());
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
        }
        makeViewListFieldsFile(tableWrapper,htmlFieldWrapperList,getFieldNameConcat(htmlFieldWrapperList));
    }

    /**
     * 部分字段增加
     */
    @FXML private void doCreateAddFieldsFileCode(){
        System.out.println("list file ");
        System.out.println("table:"+tableWrapper.getBeanname());
        System.out.println(" field size:"+tableWrapper.getbFieldWrapperList().size());
        //updateFieldListView.getSelectionModel().getSelectedItems();

        List<BFieldWrapper> bFieldWrapperList = tableWrapper.getbFieldWrapperList();
        for(BFieldWrapper fieldWrapper:bFieldWrapperList){
            System.out.println("fieldname:"+fieldWrapper.getFieldname());
        }
        Map<String,BFieldWrapper> bFieldWrapperMap = tableWrapper.getbFieldWrapperMap();
        Set<String> fieldWrapperSet = bFieldWrapperMap.keySet();
        for(String key:fieldWrapperSet){
            System.out.println("fname:"+key);
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(key);
            System.out.println("map fname:"+bFieldWrapper.getFieldname());
        }

        List<HtmlFieldWrapper> htmlFieldWrapperList = updateFieldListView.getSelectionModel().getSelectedItems();
        System.out.println("selectFieldList size:"+htmlFieldWrapperList.size());
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
        }
        makeViewAddFieldsFile(tableWrapper,htmlFieldWrapperList,getFieldNameConcat(htmlFieldWrapperList));
    }



    @FXML
    private void doCreateUpdateFieldsControllerCode(){
        System.out.println("table:"+tableWrapper.getBeanname());
        System.out.println(" field size:"+tableWrapper.getbFieldWrapperList().size());
        //updateFieldListView.getSelectionModel().getSelectedItems();

        List<BFieldWrapper> bFieldWrapperList = tableWrapper.getbFieldWrapperList();
        for(BFieldWrapper fieldWrapper:bFieldWrapperList){
            System.out.println("fieldname:"+fieldWrapper.getFieldname());
        }
        Map<String,BFieldWrapper> bFieldWrapperMap = tableWrapper.getbFieldWrapperMap();
        Set<String> fieldWrapperSet = bFieldWrapperMap.keySet();
        for(String key:fieldWrapperSet){
            System.out.println("fname:"+key);
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(key);
            System.out.println("map fname:"+bFieldWrapper.getFieldname());
        }

        List<HtmlFieldWrapper> htmlFieldWrapperList = updateFieldListView.getSelectionModel().getSelectedItems();
        System.out.println("selectFieldList size:"+htmlFieldWrapperList.size());
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
        }
        doCreateBeanUpdateControllerCode(htmlFieldWrapperList);
    }


    @FXML
    private void doCreateUpdateFieldsServCode(){
        System.out.println("table:"+tableWrapper.getBeanname());
        System.out.println(" field size:"+tableWrapper.getbFieldWrapperList().size());
        //updateFieldListView.getSelectionModel().getSelectedItems();
        conditionFieldWrapperList = new ArrayList<>();
        selectByFieldWrapperList = new ArrayList<>();
        selectFieldWrapperList = new ArrayList<>();


        List<BFieldWrapper> bFieldWrapperList = tableWrapper.getbFieldWrapperList();
        for(BFieldWrapper fieldWrapper:bFieldWrapperList){
            System.out.println("fieldname:"+fieldWrapper.getFieldname());
        }

        List<BFieldWrapper> keyFieldWrapperList = tableWrapper.getbKeyFieldWrapperList();
        System.out.println("key field wrapper list");
        for(BFieldWrapper bFieldWrapper:keyFieldWrapperList){
            System.out.println("key field name:"+bFieldWrapper.getFieldname());
            conditionFieldWrapperList.add(bFieldWrapper);
        }

        Map<String,BFieldWrapper> bFieldWrapperMap = tableWrapper.getbFieldWrapperMap();
        Set<String> fieldWrapperSet = bFieldWrapperMap.keySet();
        for(String key:fieldWrapperSet){
            System.out.println("fname:"+key);
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(key);
            System.out.println("map fname:"+bFieldWrapper.getFieldname());
            //条件就是主键
            //conditionFieldWrapperList.add(bFieldWrapper);
        }

        List<HtmlFieldWrapper> htmlFieldWrapperList = updateFieldListView.getSelectionModel().getSelectedItems();
        System.out.println("selectFieldList size:"+htmlFieldWrapperList.size());
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(htmlFieldWrapper.getbFieldWrapper().getFieldname());
            //选择的字段选项列表
            selectFieldWrapperList.add(bFieldWrapper);
            selectByFieldWrapperList.add(bFieldWrapper);
        }
        CodeConcat codeConcat = getCodeConcatCondition();
        doCreateBeanUpdateServCode(codeConcat);
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



    private String getConditionFieldList(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        for(BFieldWrapper bFieldWrapper:conditionFieldWrapperList){
            sb.append(MyStringUtils.UpperFirstString(bFieldWrapper.getFieldname()));
        }
        //System.out.println("字段的拼接,用在函数的命名:"+sb.toString());
        return sb.toString();
    }

    private CodeConcat getCodeConcatCondition(){
        CodeConcat codeConcat = new CodeConcat();
        //codeConcat.setKeyConcat(getKeyList());
        addCondtion = true;
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

    @FXML
    private void doCreateUpdateFieldsCodeFile(){
        System.out.println("table:"+tableWrapper.getBeanname());
        System.out.println(" field size:"+tableWrapper.getbFieldWrapperList().size());
        //updateFieldListView.getSelectionModel().getSelectedItems();

        List<BFieldWrapper> bFieldWrapperList = tableWrapper.getbFieldWrapperList();
        for(BFieldWrapper fieldWrapper:bFieldWrapperList){
            System.out.println("fieldname:"+fieldWrapper.getFieldname());
        }
        Map<String,BFieldWrapper> bFieldWrapperMap = tableWrapper.getbFieldWrapperMap();
        Set<String> fieldWrapperSet = bFieldWrapperMap.keySet();
        for(String key:fieldWrapperSet){
            System.out.println("fname:"+key);
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(key);
            System.out.println("map fname:"+bFieldWrapper.getFieldname());
        }

        List<HtmlFieldWrapper> htmlFieldWrapperList = updateFieldListView.getSelectionModel().getSelectedItems();
        System.out.println("selectFieldList size:"+htmlFieldWrapperList.size());
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
        }
        makeViewUpdateCodeFile(tableWrapper,htmlFieldWrapperList,getFieldNameConcat(htmlFieldWrapperList));
    }

    private String getFieldNameConcat(List<HtmlFieldWrapper> htmlFieldWrapperList){
        StringBuffer sb =new StringBuffer();
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
            sb.append(StringTool.capitalStr(htmlFieldWrapper.getbFieldWrapper().getFieldname()));
        }
        return sb.toString();
    }

    private void doCreateBeanPartPageControllerCode(List<HtmlFieldWrapper> htmlFieldWrapperList){
        String fieldnameConcat= getFieldNameConcat(htmlFieldWrapperList);
        System.out.println("create bean edit view code");
        //initTableParameters();
        context.put("packagename", tableWrapper.getPackagename());
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("keylist", tableWrapper.getbKeyFieldWrapperList());
        context.put("selectFieldList",htmlFieldWrapperList);
        context.put("fieldnameConcat",fieldnameConcat);
        context.put("nameNoTypeConcat",getNameNoTypeConcatWithComma(htmlFieldWrapperList));
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE== ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/controller_partfields_page.vm", "utf-8", context, sw);
        }
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.sqlTextArea.setText(sw.toString());
        //sqlTextArea.setText(sw.toString());
    }


    private void doCreateBeanUpdateServCode(CodeConcat codeConcat){
        //String fieldnameConcat= getFieldNameConcat(htmlFieldWrapperList);
        System.out.println("create bean edit view code");

        System.out.println("create bean code");
        //initTableParameters();
        System.out.println("select field wrapper");
        for(BFieldWrapper bFieldWrapper:selectFieldWrapperList){
            System.out.println("fieldname:"+bFieldWrapper.getFieldname());
        }
        System.out.println("condition field wrapper");
        for(BFieldWrapper bFieldWrapper:conditionFieldWrapperList){
            System.out.println("fieldname:"+bFieldWrapper.getFieldname());
        }

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

        replaceCodeFile(sw.toString(),"update");
        controller.setSqlTextArea(sw.toString());

        //sqlTextArea.setText(sw.toString());
    }



    private void doCreateBeanUpdateControllerCode(List<HtmlFieldWrapper> htmlFieldWrapperList){
        String fieldnameConcat= getFieldNameConcat(htmlFieldWrapperList);
        System.out.println("create bean edit view code");
        //initTableParameters();
        context.put("packagename", tableWrapper.getPackagename());
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("keylist", tableWrapper.getbKeyFieldWrapperList());
        context.put("selectFieldList",htmlFieldWrapperList);
        context.put("fieldnameConcat",fieldnameConcat);
        context.put("nameNoTypeConcat",getNameNoTypeConcatWithComma(htmlFieldWrapperList));
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE== ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/controller_updatebean_fields.vm", "utf-8", context, sw);
        }
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.sqlTextArea.setText(sw.toString());
        //sqlTextArea.setText(sw.toString());
    }

    private void doCreateBeanListControllerCode(List<HtmlFieldWrapper> htmlFieldWrapperList){
        String fieldnameConcat= getFieldNameConcat(htmlFieldWrapperList);
        System.out.println("create bean edit view code");
        //initTableParameters();
        context.put("packagename", tableWrapper.getPackagename());
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("keylist", tableWrapper.getbKeyFieldWrapperList());
        context.put("selectFieldList",htmlFieldWrapperList);
        context.put("fieldnameConcat",fieldnameConcat);
        context.put("nameNoTypeConcat",getNameNoTypeConcatWithComma(htmlFieldWrapperList));
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE== ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_s_fields_enjoy.vm", "utf-8", context, sw);
        }
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.sqlTextArea.setText(sw.toString());
        //sqlTextArea.setText(sw.toString());
    }

    private void doCreateBeanListViewCode(List<HtmlFieldWrapper> htmlFieldWrapperList){
        String fieldnameConcat= getFieldNameConcat(htmlFieldWrapperList);
        System.out.println("create bean edit view code");
        //initTableParameters();
        context.put("packagename", tableWrapper.getPackagename());
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("keylist", tableWrapper.getbKeyFieldWrapperList());
        context.put("selectFieldList",htmlFieldWrapperList);
        context.put("fieldnameConcat",fieldnameConcat);
        context.put("nameNoTypeConcat",getNameNoTypeConcatWithComma(htmlFieldWrapperList));
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE== ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_s_fields_enjoy.vm", "utf-8", context, sw);
        }
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.sqlTextArea.setText(sw.toString());
        //sqlTextArea.setText(sw.toString());
    }


    /**
     * 实参列表
     * @param htmlFieldWrapperList
     * @return
     */
    private String getNameNoTypeConcatWithComma(List<HtmlFieldWrapper> htmlFieldWrapperList){
        StringBuffer sb =new StringBuffer();
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            sb.append(StringTool.lowerFirstStr(htmlFieldWrapper.getFieldname())).append(",");
        }
        if(sb.length()>1) return sb.substring(0,sb.length()-1);
        else return "";
    }

    private void doCreateBeanUpdateViewCode(List<HtmlFieldWrapper> htmlFieldWrapperList){
        String fieldnameConcat= getFieldNameConcat(htmlFieldWrapperList);
        System.out.println("create bean edit view code");
        //initTableParameters();
        context.put("packagename", tableWrapper.getPackagename());
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("keylist", tableWrapper.getbKeyFieldWrapperList());
        context.put("selectFieldList",htmlFieldWrapperList);
        context.put("fieldnameConcat",fieldnameConcat);
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE== ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_beanupdate_fields_enjoy.vm", "utf-8", context, sw);
        }
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        controller.sqlTextArea.setText(sw.toString());
        //sqlTextArea.setText(sw.toString());
    }


    private void makeViewListFieldsFile(BTableWrapper theTableWrapper,List<HtmlFieldWrapper> htmlFieldWrapperList,String fieldNameConcat){
        String viewFileName = getViewHtmlFileName(theTableWrapper,fieldNameConcat,"page");
        File file = new File(viewFileName);
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos,"utf-8");
            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);

            context.put("keylist", tableWrapper.getbKeyFieldWrapperList());
            context.put("selectFieldList",htmlFieldWrapperList);
            context.put("fieldnameConcat",fieldNameConcat);

            StringWriter sw = new StringWriter();
            if(Config.FRAMEWORKTYPE== FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/view_s_fields_enjoy.vm", "utf-8", context, sw);
            }
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            // if(codetype==CODE_OR) theTableWrapper.setServfilename(javafilefullname);
            //else if(codetype==CODE_EX)
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }


    private void makeViewAddFieldsFile(BTableWrapper theTableWrapper,List<HtmlFieldWrapper> htmlFieldWrapperList,String fieldNameConcat){
        String viewFileName = getViewHtmlFileName(theTableWrapper,fieldNameConcat,"PartAdd");
        File file = new File(viewFileName);
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos,"utf-8");
            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);

            context.put("keylist", tableWrapper.getbKeyFieldWrapperList());
            context.put("selectFieldList",htmlFieldWrapperList);
            context.put("fieldnameConcat",fieldNameConcat);

            StringWriter sw = new StringWriter();
            if(Config.FRAMEWORKTYPE== FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/view_beanadd_fields_enjoy.vm", "utf-8", context, sw);
            }
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            // if(codetype==CODE_OR) theTableWrapper.setServfilename(javafilefullname);
            //else if(codetype==CODE_EX)
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }


    private void makeViewUpdateCodeFile(BTableWrapper theTableWrapper,List<HtmlFieldWrapper> htmlFieldWrapperList,String fieldNameConcat){
        String viewFileName = getViewHtmlFileName(theTableWrapper,fieldNameConcat,"update");
        File file = new File(viewFileName);
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos,"utf-8");
            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);

            context.put("keylist", tableWrapper.getbKeyFieldWrapperList());
            context.put("selectFieldList",htmlFieldWrapperList);
            context.put("fieldnameConcat",fieldNameConcat);

            StringWriter sw = new StringWriter();
            if(Config.FRAMEWORKTYPE== FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/view_beanupdate_fields_enjoy.vm", "utf-8", context, sw);
            }
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            // if(codetype==CODE_OR) theTableWrapper.setServfilename(javafilefullname);
            //else if(codetype==CODE_EX)
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private String getViewHtmlFileName(BTableWrapper theTableWrapper,String fieldNameConcat,String suffix){
        String webRelativeDir = controller.webRelativeTextField.getText();
        String webFileDir = controller.projectDirTextField.getText()+webRelativeDir;
        //F:\jfinal\jfinalseries\jfinal-3.2_demo_maven\jfinal_demo_for_maven\src\main\webapp
        System.out.println("webfiledir:"+webFileDir);
        String beanDir = "\\"+theTableWrapper.getInstancename();
        String webBeanDir = webFileDir+beanDir;
        //F:\jfinal\jfinalseries\jfinal-3.2_demo_maven\jfinal_demo_for_maven\src\main\webapp\brand
        System.out.println("webBeanDir:"+webBeanDir);
        File f=new File(webBeanDir);
        if(!f.exists()) f.mkdirs();
        String viewFileName="";
        if(suffix.equalsIgnoreCase("new")){
            //F:\jfinal\jfinalseries\jfinal-3.2_demo_maven\jfinal_demo_for_maven\src\main\webapp\brand\brandnew.html
            viewFileName = theTableWrapper.getInstancename()+fieldNameConcat+"new.html";
        }else if(suffix.equalsIgnoreCase("edit")){
            viewFileName = theTableWrapper.getInstancename()+fieldNameConcat+"edit.html";
        }else if(suffix.equalsIgnoreCase("list")){
            viewFileName = theTableWrapper.getInstancename()+fieldNameConcat+"list.html";
        }else if(suffix.equalsIgnoreCase("add")){
            viewFileName = theTableWrapper.getInstancename()+fieldNameConcat+"add.html";
        }else if(suffix.equalsIgnoreCase("PartAdd")){
            viewFileName = theTableWrapper.getInstancename()+"PartAdd.html";
        }
        else if(suffix.equalsIgnoreCase("s")){
            viewFileName = theTableWrapper.getInstancename()+fieldNameConcat+"s.html";
        }else if(suffix.equalsIgnoreCase("update")){
            viewFileName = theTableWrapper.getInstancename()+fieldNameConcat+"Update.html";
        }else if(suffix.equalsIgnoreCase("page")){
            viewFileName = theTableWrapper.getInstancename()+"Part"+"Page.html";
        }

        String viewFileFullName = webBeanDir+"\\"+viewFileName;
        System.out.println("view File Full Name:"+viewFileFullName);

        //String viewFileFullName = getViewHtmlFileName(theTableWrapper,"new");
        File htmlFile = new File(viewFileFullName);
        int result=0;
        if(htmlFile.exists()){
            result=JOptionPane.showConfirmDialog(null,"文件存在，需要覆盖吗？");
            System.out.println("result:"+result);
            if(result==0){
                //肯定
                System.out.println("肯定");System.out.println("覆盖");
            }else if(result==1) {
                System.out.println("否定");System.out.println("返回");
                return null;
            }
        }else {
            result =-1;
            System.out.println("不存在");
            try {
                htmlFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return viewFileFullName;
    }

    @FXML private void doCreateListFieldsViewCode(){
        System.out.println("create list code");
        System.out.println("list file ");
        System.out.println("table:"+tableWrapper.getBeanname());
        System.out.println(" field size:"+tableWrapper.getbFieldWrapperList().size());
        //updateFieldListView.getSelectionModel().getSelectedItems();

        List<BFieldWrapper> bFieldWrapperList = tableWrapper.getbFieldWrapperList();
        for(BFieldWrapper fieldWrapper:bFieldWrapperList){
            System.out.println("fieldname:"+fieldWrapper.getFieldname());
        }
        Map<String,BFieldWrapper> bFieldWrapperMap = tableWrapper.getbFieldWrapperMap();
        Set<String> fieldWrapperSet = bFieldWrapperMap.keySet();
        for(String key:fieldWrapperSet){
            System.out.println("fname:"+key);
            BFieldWrapper bFieldWrapper = bFieldWrapperMap.get(key);
            System.out.println("map fname:"+bFieldWrapper.getFieldname());
        }

        List<HtmlFieldWrapper> htmlFieldWrapperList = updateFieldListView.getSelectionModel().getSelectedItems();
        System.out.println("selectFieldList size:"+htmlFieldWrapperList.size());
        for(HtmlFieldWrapper htmlFieldWrapper:htmlFieldWrapperList){
            System.out.println(htmlFieldWrapper.getbFieldWrapper().getFieldname()+" "+htmlFieldWrapper.getHtmlComponent());
        }
        doCreateBeanListViewCode(htmlFieldWrapperList);


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

        conditions = updateFieldListView.getItems();

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
        //conditionList = updateFieldListView.getSelectionModel().getSelectedItems();
        orderByList = orderByListView.getSelectionModel().getSelectedItems();

        doGenCreateSelectComplexFieldCode(codeConcat,selectFieldNameList,conditions,orders,isPageable);
    }


    @FXML
    public void doCreateSelectFieldComplexCodeNoBeanNoReplace(){
        System.out.println("您选择了一下字段:");

        conditions = updateFieldListView.getItems();

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
        //conditionList = updateFieldListView.getSelectionModel().getSelectedItems();
        orderByList = orderByListView.getSelectionModel().getSelectedItems();

        doGenCreateSelectComplexFieldCodeNoReplace(codeConcat,selectFieldNameList,conditions,orders,isPageable);
    }

    private void doGenCreateSelectComplexFieldCode(CodeConcat codeConcat,List<String> selectFieldNameList,List<Condition> conditions,List<OrderBy> orders,String isPageable){
        System.out.println("create bean code");
        //initTableParameters();
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);

        SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectByFieldWrapperList);

        String select_complex_sql = SqlUtils.getFindComplexSql(tableWrapper.getTablename(),selectFieldNameList,conditions,orders,isPageable);
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


    private void doGenCreateSelectComplexFieldCodeNoReplace(CodeConcat codeConcat,List<String> selectFieldNameList,List<Condition> conditions,List<OrderBy> orders,String isPageable){
        System.out.println("create bean code");
        //initTableParameters();
        context.put("tableWrapper", tableWrapper);
        context.put("list", tableWrapper.getbFieldWrapperList());
        context.put("codeConcat",codeConcat);

        SQLAndParam sqlAndParam= new SQLAndParam(tableWrapper,selectByFieldWrapperList);

        String select_complex_sql = SqlUtils.getFindComplexSql(tableWrapper.getTablename(),selectFieldNameList,conditions,orders,isPageable);

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
        String type ="update";
        //在相应的文件中增加代码
        replaceCodeFile(sw.toString(),type);

        controller.setSqlTextArea(sw.toString());
    }


    /***
     * 将相应文件增加
     * @param allCode
     */
    private void replaceCodeFile(String allCode,String type) {
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
                String fullPath ="";
                if(type.equalsIgnoreCase("read")) {
                    //前提是这个文件必须先存在
                    fullPath = getPath() + "\\servread\\" + tableWrapper.getBeanname() + "ServRead.java";
                }
                else if(type.equalsIgnoreCase("update")) {
                    fullPath =getPath() + "\\servupdate\\" + tableWrapper.getBeanname() + "ServUpdate.java";

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
                }

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
     * 用于函数名称,放在By前面
     * GroupIdUserId
     * @return
     */
    private String getSelectFieldList(){
        StringBuffer sb = new StringBuffer();
        //List<BFieldWrapper> bFieldWrapperList = getTableWrapper().getbFieldWrapperList();
        int size =selectFieldWrapperList.size();
        if(size>=1) {
            for (BFieldWrapper bFieldWrapper : selectFieldWrapperList) {
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
