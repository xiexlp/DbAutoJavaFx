package com.js.code;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.js.bean.relations.BeanRelationUtil;
import com.js.bean.relations.TableWrapper;
import com.js.code.configs.DynamicConfig;
import com.js.code.db.DBUtil;
import com.js.code.def.FrameWorkType;
import com.js.code.def.ProjectType;
import com.js.code.def.ViewTemplate;
import com.js.dbauto.*;
import com.js.fxtest.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Controller implements Initializable {

    public static final String ORM="orm";
    public static final String CONFIG="config";
    public static final String DAO="dao";
    public static final String DAOIMPL="daoImpl";
    public static final String SERV="serv";
    public static final String CONTROL="controller";
    public static final String VIEW="view";

    public static final String EXSUFFEX="ex";

    public static final int CODE_EX=1;
    public static final int CODE_OR=2;

    VelocityEngine velocityEngine = new VelocityEngine();
    VelocityContext context = new VelocityContext();
    boolean isMavenProject = true;

    //String projectDir="F:\\jfinal\\jfinalseries\\jfinal-3.2_demo_maven\\jfinal_demo_for_maven";
    //String projectDir="G:\\javaworkplace\\sforum-jfinal-beetl-1.0";
    //String webRelativeDir = "\\src\\main\\webapp\\boot";


    @FXML
    ListView tableList;

    @FXML
    ListView codeModeList;



    @FXML
    TextField databaseTextField;
    @FXML
    Label tableLabel;
    @FXML
    TextField packageNameTextField;
    @FXML
    public  TextField projectDirTextField;
    @FXML
    TextField currentPackageNameTextField;
    @FXML
    public TextArea sqlTextArea;
    @FXML
    TextField commonPackageTextField;
    @FXML
    public  TextField webRelativeTextField;

    @FXML
    TextField relativePathTextField;

    @FXML
    AlertController alertController;
    @FXML
    UpdateController updateController;
    @FXML
    SelectComplexController selectComplexController;
    @FXML
    UpdateFieldsController updateFieldsController;

    @FXML
    UpdateTabFieldsController updateTabFieldsController;

    @FXML
    ValidateController validateController;

    @FXML
    TextField beanNameTextField;

    Stage alertStage;
    Stage validateStage;

    public BTableWrapper bTableWrapper;
    public Map<String,BTableWrapper> tableWrapperMap = new HashMap<String, BTableWrapper>();


    @FXML
    TextField programeNameTextField;
    @FXML
    ListView programeRecentListView;

    private DynamicConfig dynamicConfig;
    private Map<String,DynamicConfig> configMap =new HashMap<>();
    private String configFile ="little.properties";
    private List<String> programeRecentList=new ArrayList();
    String selectProgrameName ="jfinal_demo_for_maven_iforum";

    @FXML
    private void handleDataBaseButton(ActionEvent event){
        System.out.println("you click button");
        List attrList = new ArrayList();
        //attrList.add("aaa");
        //attrList.add("bbb");
        String databaseName = databaseTextField.getText().trim();

        attrList = DBUtil.getTableList(databaseName);

        //先清除
        //tableList.getItems().clear();

        doFillTableList();

        ObservableList<String> strList = FXCollections.observableList(attrList);
        tableList.setItems(strList);
        //String item=listView.getSelectionModel().selectedItemProperty().getValue().toString();
        //String item = listView.getSelectionModel().selectedItemProperty().getName();
        //System.out.println("item:"+item);
    }


    private BTableWrapper initTableParameters() {
        ObservableList<Integer> selectIndexs =  tableList.getSelectionModel().getSelectedIndices();
        Object[] selectIndice = selectIndexs.toArray();
        //int[] selectIndice =  tableList.getSelectionModel().getSelectedIndices();
        if (selectIndice.length > 1) {
            tableLabel.setText("只能选一项");
            return null;
        }else if(selectIndice.length<=0){
            //System.out.println();
            tableLabel.setText("请先选择表格对象");
            //OptionPane.showMessageDialog(null, "请先选择表格对象");
            return null;
        }
        String tablename = (String) tableList.getSelectionModel().getSelectedItem();
        return initTableParameters(tablename);
    }

    private BTableWrapper initTableParameters(String tablename){
        String packageName = packageNameTextField.getText();
        String packageNameCurrent = currentPackageNameTextField.getText();
        String basePackage =  packageNameTextField.getText();
        String projectDir = projectDirTextField.getText();
        System.out.println("tablename:" + tablename);


        int indexPackage =  beanNameTextField.getText().trim().lastIndexOf(".");
        String beanPackageName = beanNameTextField.getText().trim().substring(0,indexPackage+1);

        String className = beanPackageName+StringTool.upperFirstStr(StringUtil.getTableNameHump(tablename));


        TableWrapper tableWrapper = BeanRelationUtil.getTableWrapperByClassName(className);
        BTableWrapper theBTableWrapper=null;

        BTable thBTable=new BTable();

        //XTable xTable = new XTable();

        thBTable.setDatabasename(databaseTextField.getText().trim());
        thBTable.setCommonPackage(commonPackageTextField.getText().trim());
        thBTable.setPackageNameCurrent(packageNameCurrent);
        thBTable.setRelativePath(relativePathTextField.getText().trim());
        thBTable.setPackageName(basePackage);
        thBTable.setProjectDir(projectDir);

        //XTableEx xtableEx = tableExMap.get(tablename);

        try {
            PreparedStatement p = DBUtil.getConn().prepareStatement("desc " + tablename);
            ResultSet r = p.executeQuery();
            List<BField> list = new ArrayList();
            List<BField> keyList = new ArrayList();

            BField keyField = new BField();

            //  XField xfield = new XField();
//            List<XField> xfieldList = new ArrayList<>();
//            List<XField> keyXFields=new ArrayList<>();

            while (r.next()) {
                BField tField = new BField();
                String fieldname = r.getString(1);

                //XField xField = xtableEx.getXfieldMap().get(fieldname);
                //System.out.println("中文名:"+xField.getCnname());

                //查看是否索引 show index from ejf_doc where column_name like 'doc_id'
                PreparedStatement p1 = com.js.code.db.DBUtil.getConn().prepareStatement("show index from " + tablename+" where COLUMN_NAME like '"+fieldname+"'");
                ResultSet r1 = p1.executeQuery();
                boolean isIndex = false;
                while (r1.next()){
                    isIndex = true;
                }

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
                boolean isPartField = tableWrapper.getFieldWrapperMap().get(StringTool.underLineToHump(fieldname)).isPart();
                System.out.println(fieldname+":isPartField8888:"+isPartField);
                tField.setPart(isPartField);

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


                //所有的表项
                list.add(tField);
            }

            System.out.println("key list size:"+keyList.size());

            //thBTable.setKeybField(keyField);
            thBTable.setName(tablename);
            thBTable.setFieldList(list);
            thBTable.setKeyFieldList(keyList);
            thBTable.setKey(keyField.getField());
            thBTable.setPackageName(packageName);

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


    @FXML
    private void doMakeBeanCodeFile(){
        System.out.println("make bean code");
        BTableWrapper TableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeBeanCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeValidatorJSCodeFile(){
        System.out.println("make bean code");
        BTableWrapper TableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeValidatorJSNewCodeFile(bTableWrapper);
    }


    @FXML
    private void doMakeConfigCodeFile(){
        System.out.println("make bean code");
        BTableWrapper TableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeConfigCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeConfigExCodeFile(){
        System.out.println("make bean code");
        BTableWrapper TableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeBeanConfigExCodeFile(bTableWrapper);
    }


    @FXML
    /**
     * 生成所有config bean,dao,daoimpl,beanex,daoex,daoimplex,serv,servex
     */
    private void doMakeCodeFileAll(){
        doMakeConfigCodeFile();
        doMakeBeanCodeFile();
        doMakeDaoCodeFile();
        doMakeDaoImplCodeFile();
        doMakeServCodeFile();

        //生成所有的ex,在修改了bean文件之后使用
        doMakeConfigExCodeFile();
        doMakeBeanExCodeFile();
        doMakeDaoExCodeFile();
        doMakeDaoImplExCodeFile();
        doMakeServExCodeFile();

        //生成controller
        doMakeControllerCodeFile();
        doMakeControllerExCodeFile();

        //生成所有的view
        doMakeViewNewCodeFile();
        doMakeViewEditCodeFile();
        doMakeViewListCodeFile();
    }

    @FXML
    private void doMakeBeanFileAll(){
        doMakeConfigCodeFile();
        doMakeBeanCodeFile();
        doMakeDaoCodeFile();
        doMakeDaoImplCodeFile();
        doMakeServCodeFile();
        doMakeControllerCodeFile();


//        doMakeConfigCodeFile();
//        doMakeBeanExCodeFile();
//        doMakeDaoExCodeFile();
//        doMakeDaoImplExCodeFile();
//        doMakeServExCodeFile();
//        doMakeControllerExCodeFile();
    }

    @FXML
    private void doMakeViewFileAll(){
        //生成所有的view
        doMakeViewNewCodeFile();
        doMakeViewEditCodeFile();
        doMakeViewListCodeFile();
        doMakeViewPartSCodeFile();
        //生成javascript验证文件
        doMakeValidatorJSCodeFile();
    }



    @FXML
    private void doMakeBeanExFileAll(){
        //生成所有的ex,在修改了bean文件之后使用
        //doMakeConfigCodeFile();

        doMakeBeanConfigExCodeFile();
        doMakeBeanExCodeFile();
        doMakeDaoExCodeFile();
        doMakeDaoImplExCodeFile();
        doMakeServExCodeFile();
        doMakeControllerExCodeFile();
    }

    /**
     * 得到代码的文件名
     * @param type serv
     * @param tablename blog
     * @param suffix ex,read
     * @return
     */
    private String getCodeFileNew(String type,String tablename,String suffix){
        String packageName="";
        if(type.equalsIgnoreCase(CONTROL))
            packageName = currentPackageNameTextField.getText();
        else packageName = packageNameTextField.getText();

        BTableWrapper bTableWrapper = tableWrapperMap.get(tablename);

        if(packageName.equalsIgnoreCase("")){
            System.out.println("请输入包名");
            tableLabel.setText("请输入包名");
            //JOptionPane.showMessageDialog(null, "请输入包名");
            return null;
        }

        String dirName = projectDirTextField.getText();
        if(dirName.equalsIgnoreCase("")){
            //JOptionPane.showMessageDialog(null, "请输入工程目录");
            System.out.println("请输入工程目录");
            return null;
        }
        //bTable.setPackageName(packageName);
        String baseDir = dirName.replace("\\","/");
        String codeDir = packageName.replace(".", "/");

        String codeBaseDir = baseDir+"/src/"+codeDir;

        if(Config.PROJECTTYPE== ProjectType.MAVEN){
            codeBaseDir = baseDir+"/src/main/java/"+codeDir;
        }else if(Config.PROJECTTYPE==ProjectType.ECLIPSE) {
            codeBaseDir = baseDir+"/src/"+codeDir;
        }
        System.out.println("code base dir:"+codeBaseDir);
        //File f =new File(baseDir+"/src/"+codeDir);
        File f =new File(codeBaseDir);
        //建立基础包
        if(!f.exists())
            f.mkdirs();

        if(tablename==null&&tablename.equalsIgnoreCase("")){
            System.out.println("未选择表格");
            tableLabel.setText("请选择表格");
            //JOptionPane.showMessageDialog(null, "请选择表格");
            return null;
        }

        String beanname=  StringUtil.getTableNameHump(tablename);
        String javaFileName = "";
        //type
        //String filetype = fileTextField.getText();
        String codeExDir="";
        File codedirFile = null;
        //创建bean下的目录
        String codesubdir = "";
        //增加exdir没有
        codesubdir = type.toLowerCase()+suffix.toLowerCase();
        //else if (codetype==CODE_OR) codesubdir = type.toLowerCase();
//                if(codetype==CODE_EX) codeExDir = codeBaseDir+"/"+type.toLowerCase()+EXSUFFEX;
//                else codeExDir = codeBaseDir+"/"+type.toLowerCase();

        codeExDir =codeBaseDir+"/"+codesubdir;

        codedirFile=new File(codeExDir);
        if(!codedirFile.exists()) codedirFile.mkdirs();

        String javaName=beanname;

        //java文件的名称
//                if(type.equalsIgnoreCase(ORM)){
//                    javaFileName = javaName+".java";
//                }else{
        javaName = beanname + StringUtil.capital(suffix)+".java";
        javaFileName = beanname+StringUtil.capital(type.toLowerCase())+StringUtil.capital(suffix)+".java";

//                }
        //
        //如com.js.sforum.orm;
        String codepackageforimport = packageName+ "."+codesubdir;
        //如com.js.sforum.orm.User;
        String codefileforimport = packageName+"."+codesubdir+"."+javaName;

        //setCodePackagenameAndJavaname(type, codetype, bTableWrapper, codeExDir, javaFileName,javaName,codepackageforimport,codefileforimport);
        bTableWrapper.setServReadPackage(codepackageforimport);
        String javafilefullname= codeExDir+"/"+javaFileName;
        System.out.println("java file full name:"+javafilefullname);
        return  javafilefullname;
    }

    //注意，这里controller不太一样，可以设置与基础包不同的目录
    private String getCodeFile(String type,String tablename,int codetype){
        String packageName="";
        if(type.equalsIgnoreCase(CONTROL))
            packageName = currentPackageNameTextField.getText();
        else packageName = packageNameTextField.getText();

        BTableWrapper bTableWrapper = tableWrapperMap.get(tablename);

        if(packageName.equalsIgnoreCase("")){
            System.out.println("请输入包名");
            tableLabel.setText("请输入包名");
            //JOptionPane.showMessageDialog(null, "请输入包名");
            return null;
        }

        String dirName = projectDirTextField.getText();
        if(dirName.equalsIgnoreCase("")){
            //JOptionPane.showMessageDialog(null, "请输入工程目录");
            System.out.println("请输入工程目录");
            return null;
        }
        //bTable.setPackageName(packageName);
        String baseDir = dirName.replace("\\","/");
        String codeDir = packageName.replace(".", "/");

        String codeBaseDir = baseDir+"/src/"+codeDir;

        if(Config.PROJECTTYPE== ProjectType.MAVEN){
            codeBaseDir = baseDir+"/src/main/java/"+codeDir;
        }else if(Config.PROJECTTYPE==ProjectType.ECLIPSE) {
            codeBaseDir = baseDir+"/src/"+codeDir;
        }
        System.out.println("code base dir:"+codeBaseDir);
        //File f =new File(baseDir+"/src/"+codeDir);
        File f =new File(codeBaseDir);
        //建立基础包
        if(!f.exists())
            f.mkdirs();

        if(tablename==null&&tablename.equalsIgnoreCase("")){
            System.out.println("未选择表格");
            tableLabel.setText("请选择表格");
            //JOptionPane.showMessageDialog(null, "请选择表格");
            return null;
        }

        String beanname=  StringUtil.getTableNameHump(tablename);
        String javaFileName = "";
        //type
        //String filetype = fileTextField.getText();
        String codeExDir="";
        File codedirFile = null;
        //创建bean下的目录
        String codesubdir = "";
        //增加exdir没有
        if(codetype==CODE_EX) codesubdir = type.toLowerCase()+EXSUFFEX;
        else if (codetype==CODE_OR) codesubdir = type.toLowerCase();
//                if(codetype==CODE_EX) codeExDir = codeBaseDir+"/"+type.toLowerCase()+EXSUFFEX;
//                else codeExDir = codeBaseDir+"/"+type.toLowerCase();

        codeExDir =codeBaseDir+"/"+codesubdir;

        codedirFile=new File(codeExDir);
        if(!codedirFile.exists()) codedirFile.mkdirs();

        String javaName=beanname;

        //java文件的名称
//                if(type.equalsIgnoreCase(ORM)){
//                    javaFileName = javaName+".java";
//                }else{
        if(codetype==CODE_OR){
            if(type==ORM)
                javaName = beanname;
            else javaName = beanname+StringUtil.capital(type.toLowerCase());
            javaFileName =javaName +".java";
        }else if(codetype==CODE_EX){
            if(type==ORM)
                javaName = beanname+"Ex";
            else javaName = beanname+StringUtil.capital(type.toLowerCase())+"Ex";
            javaFileName = javaName+".java";
        }
//                }
        //
        //如com.js.sforum.orm;
        String codepackageforimport = packageName+ "."+codesubdir;
        //如com.js.sforum.orm.User;
        String codefileforimport = packageName+"."+codesubdir+"."+javaName;

        setCodePackagenameAndJavaname(type, codetype, bTableWrapper, codeExDir, javaFileName,javaName,codepackageforimport,codefileforimport);

        String javafilefullname= codeExDir+"/"+javaFileName;
        return  javafilefullname;
    }


    private void setCodePackagenameAndJavaname(String type,int codetype,BTableWrapper bTableWrapper,String codeDir,String javaFileName,String javaName,String codepackageforimport,String codefileforimport){
        if(type.equals(ORM)){
            if(codetype==CODE_OR){
                bTableWrapper.setBeanpackagename(codeDir);
                bTableWrapper.setBeanjavaname(javaName);
                bTableWrapper.setBeanJavafilename(javaFileName);
                bTableWrapper.setBeanpackageforimport(codepackageforimport);
                bTableWrapper.setBeanfileforimport(codefileforimport);
            }else if(codetype==CODE_EX){
                bTableWrapper.setBeanExpackagename(codeDir);
                bTableWrapper.setBeanExjavaname(javaName);
                bTableWrapper.setBeanExJavafilename(javaFileName);
                bTableWrapper.setBeanexpackageforimport(codepackageforimport);
                bTableWrapper.setBeanexfileforimport(codefileforimport);
            }
        }else if(type.equals(DAO)){
            if(codetype==CODE_OR){
                bTableWrapper.setDaopackname(codeDir);
                bTableWrapper.setDaojavaname(javaName);
                bTableWrapper.setDaoJavafilename(javaFileName);
                bTableWrapper.setDaopackageforimport(codepackageforimport);
                bTableWrapper.setDaofileforimport(codefileforimport);
            }else if(codetype==CODE_EX){
                bTableWrapper.setDaoExpackname(codeDir);
                bTableWrapper.setDaoExjavaname(javaName);
                bTableWrapper.setDaoExJavafilename(javaFileName);
                bTableWrapper.setDaoexpackageforimport(codepackageforimport);
                bTableWrapper.setDaoexfileforimport(codefileforimport);
            }
        }else if(type.equals(DAOIMPL)){
            if(codetype==CODE_OR){
                bTableWrapper.setDaoimplpackname(codeDir);
                bTableWrapper.setDaoimpljavaname(javaName);
                bTableWrapper.setDaoJavafilename(javaFileName);
                bTableWrapper.setDaoimplpackageforimport(codepackageforimport);
                bTableWrapper.setDaoimplfileforimport(codefileforimport);
            }else if(codetype==CODE_EX){
                bTableWrapper.setDaoimplExpackname(codeDir);
                bTableWrapper.setDaoimplExjavaname(javaName);
                bTableWrapper.setDaoimplExJavafilename(javaFileName);

                bTableWrapper.setDaoimplexpackageforimport(codepackageforimport);
                bTableWrapper.setDaoimplexfileforimport(codefileforimport);

            }
        }
        else if(type.equals(SERV)){
            if(codetype==CODE_OR){
                bTableWrapper.setServpackname(codeDir);
                bTableWrapper.setServjavaname(javaName);
                bTableWrapper.setServJavafilename(javaFileName);

                bTableWrapper.setServpackageforimport(codepackageforimport);
                bTableWrapper.setServfileforimport(codefileforimport);

            }else if(codetype==CODE_EX){
                bTableWrapper.setServExpackname(codeDir);
                bTableWrapper.setServExjavaname(javaName);
                bTableWrapper.setServExJavafilename(javaFileName);

                bTableWrapper.setServexpackageforimport(codepackageforimport);
                bTableWrapper.setServexfileforimport(codefileforimport);

            }
        }else if(type.equals(CONTROL)){
            if(codetype==CODE_OR){
                bTableWrapper.setControlpackagename(codeDir);
                bTableWrapper.setControljavaname(javaName);
                bTableWrapper.setControlJavafilename(javaFileName);

                bTableWrapper.setControlpackageforimport(codepackageforimport);
                bTableWrapper.setControlfileforimport(codefileforimport);

            }else if(codetype==CODE_EX){
                bTableWrapper.setControlExpackagename(codeDir);
                bTableWrapper.setControlExjavaname(javaName);
                bTableWrapper.setControlExJavafilename(javaFileName);

                bTableWrapper.setControlexpackageforimport(codepackageforimport);
                bTableWrapper.setControlexfileforimport(codefileforimport);

            }

        }
    }

    private void makeConfigCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname=getCodeFile(CONFIG,theTableWrapper.getTablename(),CODE_OR);

            if(javafilefullname==null){
                //JOptionPane.showMessageDialog(null, "请检查出错原因");
                System.out.println("请检查出错原因");
                tableLabel.setText("请检查出错原因");
            }
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else{

                //需要一个确认
                int result=JOptionPane.showConfirmDialog(null,javafilefullname+"文件存在，请确定需要覆盖，删除不可恢复？");
                System.out.println("result:"+result);
                if(result==0){
                    //肯定
                    System.out.println("肯定");System.out.println("覆盖");
                }else if(result==1) {
                    System.out.println("否定");System.out.println("返回");
                    return ;
                }
                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();

            velocityEngine.mergeTemplate("src/templates/config.vm", "utf-8", context, sw);

            System.out.println(sw.toString());
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            //设置bean文件路径
            //theTableWrapper.setBeanfullname(javafilefullname);
            theTableWrapper.setBeanfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }



    private void makeBeanCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname=getCodeFile(ORM,theTableWrapper.getTablename(),CODE_OR);

            if(javafilefullname==null){
                //JOptionPane.showMessageDialog(null, "请检查出错原因");
                System.out.println("请检查出错原因");
                tableLabel.setText("请检查出错原因");
            }
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else{

                //需要一个确认
                int result=JOptionPane.showConfirmDialog(null,javafilefullname+"文件存在，请确定需要覆盖，删除不可恢复？");
                System.out.println("result:"+result);
                if(result==0){
                    //肯定
                    System.out.println("肯定");System.out.println("覆盖");
                }else if(result==1) {
                    System.out.println("否定");System.out.println("返回");
                    return ;
                }

                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();

            velocityEngine.mergeTemplate("src/templates/bean.vm", "utf-8", context, sw);

            System.out.println(sw.toString());
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            //设置bean文件路径
            //theTableWrapper.setBeanfullname(javafilefullname);
            theTableWrapper.setBeanfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    @FXML
    private void doMakeDaoCodeFile(){
        System.out.println("make dao code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeDaoCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeDaoImplCodeFile(){
        System.out.println("make daoimpl code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeDaoimplCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeServCodeFile(){
        System.out.println("make serv code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeServCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeServerReadCodeFile(){
        System.out.println("make serv code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeServReadFile(bTableWrapper);
    }

    @FXML
    private void doMakeServerUpdateCodeFile(){
        System.out.println("make serv code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeServUpdateFile(bTableWrapper);
    }

    @FXML
    private void doMakeBeanExCodeFile(){
        System.out.println("make beanex.vm code");
        BTableWrapper TableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeBeanExCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeBeanConfigExCodeFile(){
        System.out.println("make beanex.vm code");
        BTableWrapper TableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeBeanConfigExCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeDaoExCodeFile(){
        System.out.println("make daoex code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeDaoExCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeDaoImplExCodeFile(){
        System.out.println("make daoimplex.vm code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeDaoimplExCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeServExCodeFile(){
        System.out.println("make servex code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeServExCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeControllerCodeFile(){
        System.out.println("make controller code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeControllerCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeControllerExCodeFile(){
        System.out.println("make controllerex code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeControllerExCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeViewNewCodeFile(){
        System.out.println("make controllerex code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeViewNewCodeFile(bTableWrapper);
    }


    @FXML
    private void doMakeViewAddCodeFile(){
        System.out.println("make controllerex code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeViewAddCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeViewEditCodeFile(){
        System.out.println("make controllerex code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeViewEditCodeFile(bTableWrapper);
    }

    @FXML
    private void doMakeViewUpdateCodeFile(){
        System.out.println("make controllerex code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeViewUpdateCodeFile(bTableWrapper);
    }


    @FXML
    private void doMakeViewListCodeFile(){
        System.out.println("make controllerex code");
        BTableWrapper bTableWrapper=initTableParameters();
        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeViewListCodeFile(bTableWrapper,"list");
    }


    @FXML
    private void doMakeViewSCodeFile(){
        System.out.println("make controllerex code");
        //从数据得到的beanFieldWrapper
        BTableWrapper bTableWrapper=initTableParameters();
        //从bean代码中得到的bfield
        //TableWrapper tableWrapper =BeanRelationUtil.getTableWrapperByClassName(className);

        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeViewListCodeFile(bTableWrapper,"s");
    }

    @FXML
    private void doMakeViewPartSCodeFile(){
        //从数据得到的beanFieldWrapper
        BTableWrapper bTableWrapper=initTableParameters();
        //从bean代码中得到的bfield
        //TableWrapper tableWrapper =BeanRelationUtil.getTableWrapperByClassName(className);

        tableWrapperMap.put(bTableWrapper.getTablename(), bTableWrapper);
        makeViewPartListCodeFile(bTableWrapper,"PartPage");
    }

    @FXML
    private void doCreateBeanCode(){
        System.out.println("create bean code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/bean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }


    @FXML
    private void doCreateBeanWithAnnoCode(){
        System.out.println("create bean code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/bean.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateDaoCode(){
        System.out.println("create dao code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/dao.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateGetBeanFromRequestCode(){
        System.out.println("create new bean code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controller_getBeanFromRequest.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateGetBeanFromRequestEditCode(){
        System.out.println("create bean edit code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controller_getBeanFromRequestEdit.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateControlNewBeanCode(){
        System.out.println("create bean edit code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controller_newbean", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateControlEditBeanCode(){
        System.out.println("create bean edit code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controller_editbean", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateControlListCode(){
        System.out.println("create bean edit code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controller_list", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateControlDeleteCode(){
        System.out.println("create bean edit code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controller_delete", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doShowUpdateFieldsDialog(){
        try {
            String selectTableName = (String)tableList.getSelectionModel().getSelectedItem();
            if(selectTableName==null) {
                tableLabel.setText("请选择表格");
                return;
            }

            alertStage= new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxtest/updatefieldsdialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了
            initTableParameters();
            updateFieldsController = new UpdateFieldsController();
            updateFieldsController.setTablename(selectTableName);
            updateFieldsController.setTableWrapper(bTableWrapper);
            fxmlLoader.setController(updateFieldsController);
            //AlertController alertController1 = fxmlLoader.getController();

            //updateFieldsController.init(bTableWrapper);
            updateFieldsController.setController(this);
            Parent root = fxmlLoader.load();

            //TextField tablenameTextField = (TextField)root.lookup("#tablenameTextField");
            //tablenameTextField.setText("js_action1");

            alertStage.setTitle("更新或查询部分表格字段代码管理");
            alertStage.setScene(new Scene(root, 700, 800));
            alertStage.setX(1000);
            alertStage.setY(100);
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    private void doShowUpdateTabFieldsDialog(){
        try {
            String selectTableName = (String)tableList.getSelectionModel().getSelectedItem();
            if(selectTableName==null) {
                tableLabel.setText("请选择表格");
                return;
            }

            alertStage= new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxtest/updatetabfieldsdialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了
            initTableParameters();
            updateTabFieldsController = new UpdateTabFieldsController();
            updateTabFieldsController.setTablename(selectTableName);
            updateTabFieldsController.setTableWrapper(bTableWrapper);
            fxmlLoader.setController(updateTabFieldsController);
            //AlertController alertController1 = fxmlLoader.getController();

            //updateFieldsController.init(bTableWrapper);
            updateTabFieldsController.setController(this);
            Parent root = fxmlLoader.load();

            //TextField tablenameTextField = (TextField)root.lookup("#tablenameTextField");
            //tablenameTextField.setText("js_action1");

            alertStage.setTitle("部分更新表格字段Tab代码管理");
            alertStage.setScene(new Scene(root, 1000, 800));
            alertStage.setX(1000);
            alertStage.setY(100);
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void doCreateControlAllCode(){
        System.out.println("create bean edit code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controller_all", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());

    }

    @FXML
    private void doCreateValidatorJs(){
        System.out.println("create validator-js code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/validator-js-orm.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateBeanNewViewCode(){
        System.out.println("create bean new view code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE==ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beannew_beetl", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_beannew_enjoy.vm", "utf-8", context, sw);
        }


       // velocityEngine.mergeTemplate("templates/view_beannew_enjoy.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateBeanAddViewCode(){
        System.out.println("create bean new view code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE==ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beanadd_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_beanadd_enjoy.vm", "utf-8", context, sw);
        }


        // velocityEngine.mergeTemplate("templates/view_beannew_enjoy.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void configSaveProgram(){
        System.out.println("saveProgramConfig...");
        String name = programeNameTextField.getText().trim();
        //String configJson = JSON.toJSONString(name);
        //当前的配置
        if(configMap==null) configMap = new HashMap<>();
        configMap.put(name,getDynamicConfigNew());
        String configJson = JSON.toJSONString(configMap);
        try {
            FileUtil.writeFileContent(configFile,configJson);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private DynamicConfig getDynamicConfigFromMap(){
        String programName = programeNameTextField.getText().trim();
        DynamicConfig dynamicConfig = configMap.get(programName);
        return dynamicConfig;
    }

    private DynamicConfig getDynamicConfigCurrent(){
        String programName = programeNameTextField.getText().trim();
        DynamicConfig dynamicConfig = configMap.get(programName);
        return dynamicConfig;
    }

    private DynamicConfig getDynamicConfigNew(){
        DynamicConfig dynamicConfig= new DynamicConfig();
        dynamicConfig.setProjectDir(projectDirTextField.getText().trim());
        dynamicConfig.setCommonPackage(commonPackageTextField.getText().trim());
        dynamicConfig.setControllerPackage(currentPackageNameTextField.getText().trim());
        dynamicConfig.setWebRelativeDir(webRelativeTextField.getText().trim());
        dynamicConfig.setRelativePath(relativePathTextField.getText().trim());
        dynamicConfig.setBasePackageName(packageNameTextField.getText().trim());
        dynamicConfig.setDbname(databaseTextField.getText().trim());
        dynamicConfig.setInitableBean(beanNameTextField.getText().trim());
        String beanName =beanNameTextField.getText().trim();
        int index= beanName.lastIndexOf(".");
        String initBeanNamePackage = beanName.substring(0,index);
        dynamicConfig.setBeanDefParentPackage(initBeanNamePackage);
        return dynamicConfig;

    }

    private void configToGui(){
        System.out.println("暂时不用");
    }

    @FXML
    private void configReloadRecent(){
        try {
            String configJson = FileUtil.readFileAllContent(configFile);

            configMap = JSON.parseObject(configJson, new TypeReference<HashMap<String,DynamicConfig>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(configMap!=null&&configMap.size()>0) {
            programeRecentList.clear();
            Iterator it = configMap.keySet().iterator();
            while (it.hasNext()) {
                String element= (String)it.next();
                System.out.println("key:" + element);
                programeRecentList.add(element);
            }
        }

        ObservableList<String> strList = FXCollections.observableList(programeRecentList);
        programeRecentListView.setItems(strList);
        programeRecentListView.getSelectionModel().selectFirst();


    }

    private void configLoadLastedProgram(){
        System.out.println("config load.....");
        try {
            String configJson = FileUtil.readFileAllContent(configFile);
            System.out.println("config json:"+configJson);
            //configMap = (HashMap)JSON.parse(configJson);

            configMap = JSON.parseObject(configJson, new TypeReference<HashMap<String,DynamicConfig>>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(configMap!=null&&configMap.size()>0) {
            Iterator it = configMap.keySet().iterator();
            while (it.hasNext()) {
                String element = (String)it.next();
                System.out.println("key:" + element);
                programeRecentList.add(element);

            }
        }
    }

    @FXML
    private void doCreateBeanEditViewCode(){
        System.out.println("create bean edit view code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE==ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beanedit_beetl", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_beanedit_enjoy.vm", "utf-8", context, sw);
        }

        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateBeanUpdateViewCode(){
        System.out.println("create bean edit view code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE==ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_beanupdate_enjoy.vm", "utf-8", context, sw);
        }

        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateBeanListViewCode(){
        System.out.println("create bean edit view code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE==ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_s_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_s_enjoy.vm", "utf-8", context, sw);
        }

        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateBeanListTableViewCode(){
        System.out.println("create bean edit view code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE==ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_s_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_list_table_enjoy.vm", "utf-8", context, sw);
        }

        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateBeanSViewCode(){
        System.out.println("create bean edit view code");
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();

        if(Config.VIEWTEMPLATE==ViewTemplate.BEETL){
            velocityEngine.mergeTemplate("src/templates/view_s_beetl.vm", "utf-8", context, sw);

        }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
            velocityEngine.mergeTemplate("src/templates/view_s_enjoy.vm", "utf-8", context, sw);
        }

        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateSelectOptionCode(){
        String packageNameCurrent = currentPackageNameTextField.getText();
        int index = packageNameCurrent.lastIndexOf(".");
        String suffix= packageNameCurrent.substring(index+1,packageNameCurrent.length());
        System.out.println(suffix);

        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        context.put("suffix",suffix);
        StringWriter sw = new StringWriter();

        velocityEngine.mergeTemplate("src/templates/view_select_option.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateRouteCode(){
        String packageNameCurrent = currentPackageNameTextField.getText();
        int index = packageNameCurrent.lastIndexOf(".");
        String suffix= packageNameCurrent.substring(index+1,packageNameCurrent.length());
        System.out.println(suffix);

        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        context.put("suffix",suffix);
        StringWriter sw = new StringWriter();

        velocityEngine.mergeTemplate("src/templates/route_href", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }


    @FXML
    /**
     * 根据beanname创建表格
     */
    private void doCreateTableFromBean(){
        String beanName = beanNameTextField.getText().trim();
        String databasename = databaseTextField.getText().trim();
        int r=BeanRelationUtil.createTableByClassName(databasename,beanName, com.js.code.Config.MYISAM);
        String info="";
        if(r==0){
             info="已经存在表格，不需要创建";
        }else if(r==1){
             info="成功创建表格";
        }
        sqlTextArea.setText(info);

    }

    @FXML
    /***
     * 修改bean file 更新表格字段
     */
    private void doUpdateTableFromBean(){
        String beanName = beanNameTextField.getText().trim();
        String databasename= databaseTextField.getText().trim();
        BeanRelationUtil.createTableByClassNameUpdate(databasename,beanName, com.js.code.Config.MYISAM);
    }
    @FXML
    protected void copyTextArea(){
        String content = sqlTextArea.getText();
        ClipboardUtil.setToClipboardText(content);
    }

    @FXML
    protected void cutTextArea(){
        String content = sqlTextArea.getText();
        ClipboardUtil.setToClipboardText(content);
        sqlTextArea.setText("");
    }

    @FXML
    protected void pasteTextArea(){
        try {
            //sqlTextArea.setText("");
            sqlTextArea.setText(ClipboardUtil.getClipboardText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @FXML
    private void doCreateDaoImplCode(){
        initTableParameters();
        SQLAndParam sQLAndParam = new SQLAndParam(bTableWrapper);

        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        context.put("sqlParam",sQLAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/daoimpl.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateServCode(){
        initTableParameters();
        context.put("packagename", bTableWrapper.getPackagename());
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/serv.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateBeanExCode(){
        System.out.println("create beanex code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/beanex.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    //注释bean 使用relation
    @FXML
    private void doCreateBeanExWithAnnoCode(){
        System.out.println("create beanex code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/beanexwithanno.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateDaoExCode(){
        System.out.println("create daoex code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        SQLAndParam sqlAndParam = new SQLAndParam(bTableWrapper);
        context.put("sqlParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/daoex.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateDaoImplExCode(){
        System.out.println("create daoimplex code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        SQLAndParam sqlAndParam = new SQLAndParam(bTableWrapper);
        context.put("sqlParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/daoimplex.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateServExCode(){
        System.out.println("create serverex code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        SQLAndParam sqlAndParam = new SQLAndParam(bTableWrapper);
        context.put("sqlParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/serverex.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateControllerCode(){
        System.out.println("create controller code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        SQLAndParam sqlAndParam = new SQLAndParam(bTableWrapper);
        context.put("sqlParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controller", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doCreateControllerExCode(){
        System.out.println("create controllerex code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/controllerex", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }



    @FXML
    private void doIndexDaoCode(){
        System.out.println("create index code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        SQLAndParam sqlAndParam = new SQLAndParam(bTableWrapper);
        context.put("sqlParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/indexdao.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    private void doIndexServiceCode(){
        System.out.println("create index code");
        initTableParameters();
        context.put("tableWrapper", bTableWrapper);
        context.put("list", bTableWrapper.getbFieldWrapperList());
        SQLAndParam sqlAndParam = new SQLAndParam(bTableWrapper);
        context.put("sqlParam",sqlAndParam);
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("src/templates/indexservice.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //�����ͻ��������
        System.out.println(sw.toString());
        sqlTextArea.setText(sw.toString());
    }

    @FXML
    public void doShowFindCodeDialog(){
        //System.out.println("create find code dialog...");
        //System.out.println("open dialog button..");
        try {
            String selectTableName = (String)tableList.getSelectionModel().getSelectedItem();
            if(selectTableName==null) {
                tableLabel.setText("请选择表格");
                return;
            }
            alertStage= new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxtest/alertdialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了
            alertController = new AlertController();
            alertController.setTablename(selectTableName);
            alertController.setTableWrapper(bTableWrapper);
            fxmlLoader.setController(alertController);
            //AlertController alertController1 = fxmlLoader.getController();
            initTableParameters();
            alertController.init(bTableWrapper);
            alertController.setController(this);
            Parent root = fxmlLoader.load();

            //TextField tablenameTextField = (TextField)root.lookup("#tablenameTextField");
            //tablenameTextField.setText("js_action1");

            alertStage.setTitle("查询Java SQL语句生成对话框");
            alertStage.setScene(new Scene(root, 500, 400));
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void doShowComplexFindDialog(){
        try {
            String selectTableName = (String)tableList.getSelectionModel().getSelectedItem();
            if(selectTableName==null) {
                tableLabel.setText("请选择表格");
                return;
            }
            alertStage= new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxtest/selectcomplexdialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了
            selectComplexController = new SelectComplexController();
            selectComplexController.setTablename(selectTableName);
            selectComplexController.setTableWrapper(bTableWrapper);
            fxmlLoader.setController(selectComplexController);
            //AlertController alertController1 = fxmlLoader.getController();
            initTableParameters();
            selectComplexController.init(bTableWrapper);
            selectComplexController.setController(this);
            Parent root = fxmlLoader.load();

            //TextField tablenameTextField = (TextField)root.lookup("#tablenameTextField");
            //tablenameTextField.setText("js_action1");

            alertStage.setTitle("复杂查询生成");
            alertStage.setScene(new Scene(root, 700, 800));
            alertStage.setX(1000);
            alertStage.setY(100);
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void doShowValidatorDialog(){
        try {
            //一定需要使用try-catch，不然编译器不会让你过的，Trust me!
            Parent anotherRoot = FXMLLoader.load(getClass().getResource("../fxtest/validatedialog.fxml"));
            Stage anotherStage = new Stage();
            anotherStage.setTitle("Another Window Triggered by Clicking");
            anotherStage.setScene(new Scene(anotherRoot, 600, 329));
            anotherStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void doShowValidateDialog(){
        try {
             validateStage= new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxtest/validatedialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了,主窗口和新开窗口需要通信的情况
            validateController = new ValidateController();
            fxmlLoader.setController(validateController);
            validateController.setController(this);
            Parent root = fxmlLoader.load();
            validateStage.setTitle("验证框架");
            validateStage.setScene(new Scene(root, 700, 800));
            validateStage.setX(1000);
            validateStage.setY(100);
            validateStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void doShowUpdateCodeDialog(){
        try {
            String selectTableName = (String)tableList.getSelectionModel().getSelectedItem();
            if(selectTableName==null) { tableLabel.setText("请选择表格");return; }
            alertStage= new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxtest/updatedialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了
            updateController = new UpdateController();
            updateController.setTablename(selectTableName);
            updateController.setTableWrapper(bTableWrapper);
            fxmlLoader.setController(updateController);
            //AlertController alertController1 = fxmlLoader.getController();
            initTableParameters();
            updateController.init(bTableWrapper);
            updateController.setController(this);
            Parent root = fxmlLoader.load();

            //TextField tablenameTextField = (TextField)root.lookup("#tablenameTextField");
            //tablenameTextField.setText("js_action1");

            alertStage.setTitle("update dialog");
            alertStage.setScene(new Scene(root, 500, 400));
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    public void doShowUpdateCodeWithKeyDialog(){
        try {
            String selectTableName = (String)tableList.getSelectionModel().getSelectedItem();
            if(selectTableName==null) { tableLabel.setText("请选择表格");return; }
            alertStage= new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxtest/updatedialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了
            updateController = new UpdateController();
            updateController.setTablename(selectTableName);
            updateController.setTableWrapper(bTableWrapper);
            fxmlLoader.setController(updateController);
            //AlertController alertController1 = fxmlLoader.getController();
            initTableParameters();
            updateController.setUseKey(true);
            updateController.init(bTableWrapper);
            updateController.setController(this);
            Parent root = fxmlLoader.load();

            //TextField tablenameTextField = (TextField)root.lookup("#tablenameTextField");
            //tablenameTextField.setText("js_action1");

            alertStage.setTitle("update dialog");
            alertStage.setScene(new Scene(root, 500, 400));
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void doShowUpdateCodeConditionDialog(){
        try {
            String selectTableName = (String)tableList.getSelectionModel().getSelectedItem();
            if(selectTableName==null) { tableLabel.setText("请选择表格");return; }
            alertStage= new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxtest/updatedialog.fxml"));
            //如果这个地方已经定义了，那么在fxml里面就不需要再定义，这样就对了
            updateController = new UpdateController();
            updateController.setTablename(selectTableName);
            updateController.setTableWrapper(bTableWrapper);
            fxmlLoader.setController(updateController);
            //AlertController alertController1 = fxmlLoader.getController();
            initTableParameters();
            updateController.setUseKey(true);
            updateController.init(bTableWrapper);
            updateController.setController(this);
            updateController.setAddCondtion(true);
            Parent root = fxmlLoader.load();

            //TextField tablenameTextField = (TextField)root.lookup("#tablenameTextField");
            //tablenameTextField.setText("js_action1");

            alertStage.setTitle("带有条件的更新语句生成update condition dialog");
            alertStage.setScene(new Scene(root, 800, 900));
            alertStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void setSqlTextArea(String content){
        sqlTextArea.setText(content);
    }

    private void makeServExCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFile(SERV,theTableWrapper.getTablename(),CODE_EX);
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {
                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/serverex.vm", "utf-8", context, sw);
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            // if(codetype==CODE_OR) theTableWrapper.setServfilename(javafilefullname);
            //else if(codetype==CODE_EX)
            theTableWrapper.setServExfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeControllerCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFile(CONTROL,theTableWrapper.getTablename(),CODE_OR);
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {

                //需要一个确认
                int result=JOptionPane.showConfirmDialog(null,javafilefullname+"文件存在，请确定需要覆盖，删除不可恢复？");
                System.out.println("result:"+result);
                if(result==0){
                    //肯定
                    System.out.println("肯定");System.out.println("覆盖");
                }else if(result==1) {
                    System.out.println("否定");System.out.println("返回");
                    return ;
                }

                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();

            if(Config.FRAMEWORKTYPE== FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/controller_spring", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/controller", "utf-8", context, sw);
            }

            //写入文件
            osw.write(sw.toString());
            osw.flush();
            // if(codetype==CODE_OR) theTableWrapper.setServfilename(javafilefullname);
            //else if(codetype==CODE_EX)
            theTableWrapper.setControlJavafilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    /**
     * 按照目录创立view html文件
     * @param theTableWrapper
     * @param suffix
     * @return
     */
    private String getViewHtmlFileName(BTableWrapper theTableWrapper,String suffix){
        String webRelativeDir = webRelativeTextField.getText();
        String webFileDir = projectDirTextField.getText()+webRelativeDir;
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
            viewFileName = theTableWrapper.getInstancename()+"new.html";
        }else if(suffix.equalsIgnoreCase("edit")){
            viewFileName = theTableWrapper.getInstancename()+"edit.html";
        }else if(suffix.equalsIgnoreCase("list")){
            viewFileName = theTableWrapper.getInstancename()+"list.html";
        }else if(suffix.equalsIgnoreCase("add")){
            viewFileName = theTableWrapper.getInstancename()+"add.html";
        }else if(suffix.equalsIgnoreCase("s")){
            viewFileName = theTableWrapper.getInstancename()+"s.html";
        }else if(suffix.equalsIgnoreCase("update")){
            viewFileName = theTableWrapper.getInstancename()+"update.html";
        }else viewFileName =theTableWrapper.getInstancename()+suffix+".html";

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

    private String getJavascriptFileName(BTableWrapper theTableWrapper){
        String webRelativeDir = webRelativeTextField.getText();
        String webFileDir = projectDirTextField.getText()+webRelativeDir;
        //F:\jfinal\jfinalseries\jfinal-3.2_demo_maven\jfinal_demo_for_maven\src\main\webapp
        System.out.println("webfiledir:"+webFileDir);
        String jsDir = webFileDir+"\\jslib\\validator-orm";
        //String webBeanDir = webFileDir+beanDir;
        //F:\jfinal\jfinalseries\jfinal-3.2_demo_maven\jfinal_demo_for_maven\src\main\webapp\brand
        System.out.println("js:"+jsDir);
        File f=new File(jsDir);
        if(!f.exists()) f.mkdirs();
        String jsName= StringTool.lowerFirstStr(theTableWrapper.getBeanname())+"AddEditValidator.js";

        String jsFileFullName = jsDir+"\\"+jsName;
        System.out.println("view File Full Name:"+jsFileFullName);

        //String viewFileFullName = getViewHtmlFileName(theTableWrapper,"new");
        File htmlFile = new File(jsFileFullName);
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
        return jsFileFullName;
    }


    private void makeValidatorJSNewCodeFile(BTableWrapper theTableWrapper){
        String jsFileName = getJavascriptFileName(theTableWrapper);
        File file = new File(jsFileName);
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
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/validator-js-orm.vm", "utf-8", context, sw);
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

    private void makeViewNewCodeFile(BTableWrapper theTableWrapper){
        String viewFileName = getViewHtmlFileName(theTableWrapper,"new");
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
            StringWriter sw = new StringWriter();

            if(Config.FRAMEWORKTYPE==FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/view_beannew_beetl", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/view_beannew_enjoy.vm", "utf-8", context, sw);
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

    private void makeViewAddCodeFile(BTableWrapper theTableWrapper){
        String viewFileName = getViewHtmlFileName(theTableWrapper,"add");
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
            StringWriter sw = new StringWriter();

            if(Config.FRAMEWORKTYPE==FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/view_beanadd_beetl.vm", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/view_beanadd_enjoy.vm", "utf-8", context, sw);
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




    private void makeViewEditCodeFile(BTableWrapper theTableWrapper){
        String viewFileName = getViewHtmlFileName(theTableWrapper,"edit");
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
            StringWriter sw = new StringWriter();
            if(Config.FRAMEWORKTYPE==FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/view_beanedit_beetl", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/view_beanedit_enjoy.vm", "utf-8", context, sw);
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


    private void makeViewUpdateCodeFile(BTableWrapper theTableWrapper){
        String viewFileName = getViewHtmlFileName(theTableWrapper,"update");
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
            StringWriter sw = new StringWriter();
            if(Config.FRAMEWORKTYPE==FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/view_beanupdate_beetl.vm", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/view_beanupdate_enjoy.vm", "utf-8", context, sw);
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

    private void makeViewPartListCodeFile(BTableWrapper theTableWrapper,String suffix){
        String viewFileName = getViewHtmlFileName(theTableWrapper,suffix);
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
            StringWriter sw = new StringWriter();
            if(Config.VIEWTEMPLATE== ViewTemplate.BEETL){
                velocityEngine.mergeTemplate("src/templates/view_s_beetl.vm", "utf-8", context, sw);
            }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
                velocityEngine.mergeTemplate("src/templates/view_part_s_enjoy.vm", "utf-8", context, sw);
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


    private void makeViewListCodeFile(BTableWrapper theTableWrapper,String suffix){
        String viewFileName = getViewHtmlFileName(theTableWrapper,suffix);
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
            StringWriter sw = new StringWriter();
            if(Config.VIEWTEMPLATE== ViewTemplate.BEETL){
                velocityEngine.mergeTemplate("src/templates/view_s_beetl.vm", "utf-8", context, sw);
            }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
                velocityEngine.mergeTemplate("src/templates/view_s_enjoy.vm", "utf-8", context, sw);
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


    private void makeViewSCodeFile(BTableWrapper theTableWrapper){
        String viewFileName = getViewHtmlFileName(theTableWrapper,"s");
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
            StringWriter sw = new StringWriter();
            if(Config.VIEWTEMPLATE== ViewTemplate.BEETL){
                velocityEngine.mergeTemplate("src/templates/view_list_beetl", "utf-8", context, sw);
            }else if(Config.VIEWTEMPLATE==ViewTemplate.ENJOY){
                velocityEngine.mergeTemplate("src/templates/view_list_enjoy.vm", "utf-8", context, sw);
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

    private void makeControllerExCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFile(CONTROL,theTableWrapper.getTablename(),CODE_EX);
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {
                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();

            if(Config.FRAMEWORKTYPE==FrameWorkType.SPRINGBOOT){
                velocityEngine.mergeTemplate("src/templates/controllerex_spring", "utf-8", context, sw);
            }else if(Config.FRAMEWORKTYPE==FrameWorkType.JFINAL){
                velocityEngine.mergeTemplate("src/templates/controllerex", "utf-8", context, sw);
            }

            //velocityEngine.mergeTemplate("src/templates/controllerex", "utf-8", context, sw);
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            // if(codetype==CODE_OR) theTableWrapper.setServfilename(javafilefullname);
            //else if(codetype==CODE_EX)
            theTableWrapper.setControlExJavafilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeDaoimplExCodeFile(BTableWrapper theTableWrapper){
        System.out.println("make dao impl code file");
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFile(DAOIMPL,theTableWrapper.getTablename(),CODE_EX);
            //创建bean文件
            File beanfile=new File(javafilefullname);
            System.out.println("daoimplexfile:"+beanfile.getAbsolutePath());
            if(!beanfile.exists()){
                System.out.println("file not exist");
                beanfile.createNewFile();
            }else {
                System.out.println("file exist");
                if(beanfile.delete()){
                    System.out.println("删除成功");
                }else {
                    System.out.println("删除失败");
                }
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");


            //生成文件
            SQLAndParam sqlAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sqlAndParam);

            System.out.println("limitsql:"+sqlAndParam.getSelect_limit_sql());

            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/daoimplex.vm", "utf-8", context, sw);
            //System.out.println("结果:\n"+sw.toString());
            //写入文件
            osw.write(sw.toString());
            osw.flush();

            //if(codetype==CODE_OR) theTableWrapper.setDaoimplfilename(javafilefullname);
            //else if(codetype==CODE_EX)
            theTableWrapper.setDaoimplExfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeDaoExCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFile(DAO,theTableWrapper.getTablename(),CODE_EX);
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {
                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件

            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/daoex.vm", "utf-8", context, sw);
            //写入文件
            osw.write(sw.toString());
            osw.flush();

            //if(codetype==CODE_OR) theTableWrapper.setDaofilename(javafilefullname);
            //else if(codetype==CODE_EX)
            theTableWrapper.setDaoExfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeBeanExCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname=getCodeFile(ORM,theTableWrapper.getTablename(),CODE_EX);
            String beanname = theTableWrapper.getBeanname();
            //String javafilefullname= "C:\\1java\\tools\\jee-mar\\workplace\\jfinal_beetl\\src\\com\\js\\syuncart\\ormex\\"+beanname+"Ex.java";

            if(javafilefullname==null){
                //JOptionPane.showMessageDialog(null, "请检查出错原因");
                tableLabel.setText("请检查出错原因");
                return;
            }
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {
                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();

            velocityEngine.mergeTemplate("src/templates/beanex.vm", "utf-8", context, sw);

            System.out.println(sw.toString());
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            //设置bean文件路径
            //theTableWrapper.setBeanfullname(javafilefullname);
            theTableWrapper.setBeanfilename(javafilefullname);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeBeanConfigExCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname=getCodeFile(CONFIG,theTableWrapper.getTablename(),CODE_EX);
            String beanname = theTableWrapper.getBeanname();
            //String javafilefullname= "C:\\1java\\tools\\jee-mar\\workplace\\jfinal_beetl\\src\\com\\js\\syuncart\\ormex\\"+beanname+"Ex.java";

            if(javafilefullname==null){
                //JOptionPane.showMessageDialog(null, "请检查出错原因");
                tableLabel.setText("请检查出错原因");
                return;
            }
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {
                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();

            velocityEngine.mergeTemplate("src/templates/configex.vm", "utf-8", context, sw);

            System.out.println(sw.toString());
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            //设置bean文件路径
            //theTableWrapper.setBeanfullname(javafilefullname);
            theTableWrapper.setBeanfilename(javafilefullname);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeServReadFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFileNew(SERV,theTableWrapper.getTablename(),"Read");
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {

                int result=JOptionPane.showConfirmDialog(null,beanfile.getAbsoluteFile()+"文件存在，需要覆盖吗？");
                System.out.println("result:"+result);
                if(result==0){
                    //肯定
                    System.out.println("肯定");System.out.println("覆盖");
                    //继续走
                }else if(result==1) {
                    System.out.println("否定");System.out.println("返回");
                    return;
                }


                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/servread.vm", "utf-8", context, sw);
            //写入文件
            osw.write(sw.toString());
            osw.flush();

            //if(codetype==CODE_OR)
            theTableWrapper.setServReadJavafilename(javafilefullname);
            //theTableWrapper.setServReadPackage();
            //else if(codetype==CODE_EX) theTableWrapper.setServExfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeServUpdateFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFileNew(SERV,theTableWrapper.getTablename(),"Update");
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {

                int result=JOptionPane.showConfirmDialog(null,beanfile.getAbsoluteFile()+"文件存在，需要覆盖吗？");
                System.out.println("result:"+result);
                if(result==0){
                    //肯定
                    System.out.println("肯定");System.out.println("覆盖");
                    //继续走
                }else if(result==1) {
                    System.out.println("否定");System.out.println("返回");
                    return;
                }
                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/servupdate.vm", "utf-8", context, sw);
            //写入文件
            osw.write(sw.toString());
            osw.flush();

            //if(codetype==CODE_OR)
            theTableWrapper.setServUpdateJavafilename(javafilefullname);
            //theTableWrapper.setServReadPackage();
            //else if(codetype==CODE_EX) theTableWrapper.setServExfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeServCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFile(SERV,theTableWrapper.getTablename(),CODE_OR);
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {

                //需要一个确认
                int result=JOptionPane.showConfirmDialog(null,javafilefullname+"文件存在，请确定需要覆盖，删除不可恢复？");
                System.out.println("result:"+result);
                if(result==0){
                    //肯定
                    System.out.println("肯定");System.out.println("覆盖");
                }else if(result==1) {
                    System.out.println("否定");System.out.println("返回");
                    return ;
                }

                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/serv.vm", "utf-8", context, sw);
            //写入文件
            osw.write(sw.toString());
            osw.flush();

            //if(codetype==CODE_OR)
            theTableWrapper.setServfilename(javafilefullname);
            //else if(codetype==CODE_EX) theTableWrapper.setServExfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeDaoimplCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFile(DAOIMPL,theTableWrapper.getTablename(),CODE_OR);
            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {

                //需要一个确认
                int result=JOptionPane.showConfirmDialog(null,javafilefullname+"文件存在，请确定需要覆盖，删除不可恢复？");
                System.out.println("result:"+result);
                if(result==0){
                    //肯定
                    System.out.println("肯定");System.out.println("覆盖");
                }else if(result==1) {
                    System.out.println("否定");System.out.println("返回");
                    return ;
                }

                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件
            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/daoimpl.vm", "utf-8", context, sw);
            //写入文件
            osw.write(sw.toString());
            osw.flush();
            System.out.println("dao code:--------------------------:"+osw.toString());
            //if(codetype==CODE_OR)
            theTableWrapper.setDaoimplfilename(javafilefullname);
            //else if(codetype==CODE_EX) theTableWrapper.setDaoimpExfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    private void makeDaoCodeFile(BTableWrapper theTableWrapper){
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        try{
            String javafilefullname= getCodeFile(DAO,theTableWrapper.getTablename(),CODE_OR);

            //创建bean文件
            File beanfile=new File(javafilefullname);
            if(!beanfile.exists()){
                beanfile.createNewFile();
            }else {

                //需要一个确认
                int result=JOptionPane.showConfirmDialog(null,javafilefullname+"文件存在，请确定需要覆盖，删除不可恢复？");
                System.out.println("result:"+result);
                if(result==0){
                    //肯定
                    System.out.println("肯定");System.out.println("覆盖");
                }else if(result==1) {
                    System.out.println("否定");System.out.println("返回");
                    return ;
                }

                beanfile.delete();
                beanfile.createNewFile();
            }
            fos = new FileOutputStream(beanfile);
            osw = new OutputStreamWriter(fos,"utf-8");

            //生成文件

            SQLAndParam sQLAndParam = new SQLAndParam(theTableWrapper);
            context.put("tableWrapper", theTableWrapper);
            context.put("list", theTableWrapper.getbFieldWrapperList());
            context.put("sqlParam",sQLAndParam);
            StringWriter sw = new StringWriter();
            velocityEngine.mergeTemplate("src/templates/dao.vm", "utf-8", context, sw);
            //写入文件
            osw.write(sw.toString());
            osw.flush();

            //if(codetype==CODE_OR)
            theTableWrapper.setDaofilename(javafilefullname);
            //else if(codetype==CODE_EX) theTableWrapper.setDaoExfilename(javafilefullname);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            FileUtil.close(fos, osw);
        }
    }

    @FXML
    private void doSetProjectDirPath(){
        String currentProjectDirPath = projectDirTextField.getText();
        JFileChooser fc = new JFileChooser(new File(currentProjectDirPath));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String dir ="";
        File file = null;
        int flag = fc.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            file=fc.getSelectedFile();
            dir = file.getPath();
            //刷新viewdir
            // = file.getPath();
            System.out.println("select file path:"+dir);
            projectDirTextField.setText(dir);
        }
    }

    private void doFillTableList(){
        List attrList = new ArrayList();
        //attrList.add("aaa");
        //attrList.add("bbb");
        String databaseName = databaseTextField.getText().trim();
        attrList = DBUtil.getTableList(databaseName);
        ObservableList<String> strList = FXCollections.observableList(attrList);
        tableList.setItems(strList);
        tableList.getSelectionModel().selectFirst();


        //codeModeList.getSelectionModel().select(0);
    }

    private void doFillModelList(){
        List<String> modeList = new ArrayList<>();
        modeList.add("market");
        modeList.add("userback");
        modeList.add("seller");
        //系统管理
        modeList.add("sysadmin");


        modeList.add("systemback");

        //后台在boot目录下，controller在market下，web在market下
        modeList.add("bootmarket");
        modeList.add("bootforum");

        ObservableList<String> strList1 = FXCollections.observableList(modeList);
        codeModeList.setItems(strList1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configLoadLastedProgram();
        ObservableList<String> strList = FXCollections.observableList(programeRecentList);
        programeRecentListView.setItems(strList);
        programeRecentListView.getSelectionModel().select(selectProgrameName);

        System.out.println("init...");
        doFillTableList();
        doFillModelList();
        tableList.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> {
                    //表明没有选，这样就可以不用执行
                    if(newValue==null){
                        System.out.println("未选");
                        return;
                    }
                    System.out.println("表格切换为:"+newValue.toString());
                    String tablename = newValue.toString();
                    int firstIndex_ = tablename.indexOf("_");
                    if(firstIndex_>0) {
                        String underlineName = tablename.substring(firstIndex_);
                        String humpName = StringTool.capitalStr(StringTool.underLineToHump(underlineName));
                        String beanName = getDynamicConfigFromMap().getBeanDefParentPackage() + "." + humpName;
                        beanNameTextField.setText(beanName);
                    }else {
                        beanNameTextField.setText(getDynamicConfigFromMap().getBeanDefParentPackage() + "." +StringTool.capitalStr(tablename));
                    }
                    //setClipbordContents(newValue.toString());
                    //label.setText(newValue);
                });


        programeRecentListView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> {
                    System.out.println("项目重新选择为:"+newValue.toString());
                    String programeName = newValue.toString();
                    DynamicConfig dynamicConfig1 = configMap.get(programeName);
                    setInitVariable(dynamicConfig1);

                    //doFillTableList();

                });


        dynamicConfig = new DynamicConfig();
        codeModeList.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> {

                    if(newValue==null){
                        System.out.println("未选");
                        return;
                    }
                    String programeName = programeNameTextField.getText();
                    dynamicConfig  = configMap.get(programeName);

                    System.out.println(newValue.toString());
                    String mode = newValue.toString();
                    if (mode.equalsIgnoreCase("market")) {
                        System.out.println("前台代码配置:");
                        dynamicConfig.setControllerPackage("com.js.iget.market");
                        dynamicConfig.setWebRelativeDir("\\src\\main\\webapp\\market");
                        dynamicConfig.setRelativePath("market");
                        setInitVariable(dynamicConfig);
                    } else if (mode.equalsIgnoreCase("userback")) {
                        System.out.println("用户后台代码配置:");
                        dynamicConfig.setControllerPackage("com.js.iget.boot");
                        dynamicConfig.setWebRelativeDir("\\src\\main\\webapp\\iget");
                        dynamicConfig.setRelativePath("iget");
                        setInitVariable(dynamicConfig);
                    } else if (mode.equalsIgnoreCase("systemback")) {
                        System.out.println("系统后台代码配置:");
                        setInitVariable(dynamicConfig);
                    } else if (mode.equalsIgnoreCase("bootmarket")) {
                        dynamicConfig.setControllerPackage("com.js.iget.market");
                        dynamicConfig.setWebRelativeDir("\\src\\main\\webapp\\market");
                        dynamicConfig.setRelativePath("market");
                        setInitVariable(dynamicConfig);
                    } else if (mode.equalsIgnoreCase("sysadmin")) {
                        System.out.println("系统后台代码配置:");
                        //dynamicConfig.setCommonPackage("com.js.iget");
                        dynamicConfig.setControllerPackage("com.js.iget.sysadmin");
                        dynamicConfig.setWebRelativeDir("\\src\\main\\webapp\\sysadmin");
                        dynamicConfig.setRelativePath("sysadmin");
                        setInitVariable(dynamicConfig);

                        //setInitVariable(dynamicConfig);
                    } else if (mode.equalsIgnoreCase("seller")) {
                        System.out.println("卖家后台代码配置:");
                        //dynamicConfig.setCommonPackage("com.js.iget");
                        dynamicConfig.setControllerPackage("com.js.iget.seller");
                        dynamicConfig.setWebRelativeDir("\\src\\main\\webapp\\seller");
                        dynamicConfig.setRelativePath("seller");
                        setInitVariable(dynamicConfig);
                    } else if (mode.equalsIgnoreCase("bootforum")) {
                        System.out.println("用户后台代码配置:");
                        //dynamicConfig.setCommonPackage("com.js.iget");
                        dynamicConfig.setControllerPackage("com.js.iforum.boot");
                        dynamicConfig.setWebRelativeDir("\\src\\main\\webapp\\boot");
                        dynamicConfig.setRelativePath("boot");
                        setInitVariable(dynamicConfig);
                    }
                    //setClipbordContents(newValue.toString());
                    //label.setText(newValue);
                });

        //set初始化变量
        setInitVariable(dynamicConfig);

        String defaultProgrameName = FileUtil.getLastDirName(projectDirTextField.getText());
        programeNameTextField.setText(defaultProgrameName);

        //测试初始化一下
        beanNameTextField.setText(com.js.code.Config.INITTABLEBEAN);
        //projectDirTextField.setText(projectDir);
        //webRelativeTextField.setText(webRelativeDir);
        //databaseTextField.setText(Config.DBNAME);
        codeModeList.getSelectionModel().select(2);


        projectDirTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("projectDir changed");
                String defaultProgrameName = FileUtil.getLastDirName(projectDirTextField.getText());
                programeNameTextField.setText(defaultProgrameName);
                //statusBarLabel.setText("状态：当前字符数为：" + textField.getText().length());
            }
        });


        databaseTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("database changed");
                doFillTableList();
                //statusBarLabel.setText("状态：当前字符数为：" + textField.getText().length());
            }
        });

    }



    private void setInitVariable(DynamicConfig dynamicConfig){
        //设定初始化变量
        projectDirTextField.setText(dynamicConfig.getProjectDir());
        webRelativeTextField.setText(dynamicConfig.getWebRelativeDir());
        databaseTextField.setText(dynamicConfig.getDbname());
        commonPackageTextField.setText(dynamicConfig.getCommonPackage());
        currentPackageNameTextField.setText(dynamicConfig.getControllerPackage());
        packageNameTextField.setText(dynamicConfig.getBasePackageName());
        relativePathTextField.setText(dynamicConfig.getRelativePath());
        beanNameTextField.setText(dynamicConfig.getInitableBean());
    }



}
