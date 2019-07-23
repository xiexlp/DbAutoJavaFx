/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Administrator
 */
public class BTableWrapper {
    
    public static final String DATEFORMAT="\"yy-MM-dd HH:mm:ss\"";
    
    private Date now=new Date();
    private String author="pku";
    private String databasename;
    private String Cdatabasename;
    private String packagename;

    private String packagenameCurrent;
    
    private String relativepath;
    
    private String beanpackagename;
    
    private String beanpackageforimport;
    private String beanexpackageforimport;
    private String beanfileforimport;
    private String beanexfileforimport;
    
    
    private String beanExpackagename;
    private String beanExjavaname;
    private String beanExJavafilename;
    
    
    private String daopackageforimport;
    private String daoexpackageforimport;
    private String daofileforimport;
    private String daoexfileforimport;
    
    private String daopackname;
    private String servpackname;
    private String daoimplpackname;
    private String controlpackagename;
    
    private String daoExpackname;
    private String servExpackname;
    private String daoimplExpackname;
    private String controlExpackagename;
    
     private String beanfilename;
     
     private String daoimplpackageforimport;
    private String daoimplexpackageforimport;
    private String daoimplfileforimport;
    private String daoimplexfileforimport;
    
     private String servpackageforimport;
    private String servexpackageforimport;
    
    private String servfileforimport;
    private String servexfileforimport;
    
     private String controlpackageforimport;
    private String controlexpackageforimport;
    
    private String controlfileforimport;
    private String controlexfileforimport;
    
    private String daofilename;
    private String daoimplfilename;
    private String servfilename;
    private String controlfilename;
    
    private String daoExfilename;
    private String daoimplExfilename;
    private String servExfilename;
    private String controlExfilename;
    
    private String beanname;
    private String tablename;
    private String instancename;
    private BTable bTable;
    private List<BFieldWrapper> bFieldWrapperList;
    private List<BFieldWrapper> bKeyFieldWrapperList;
    private List<BFieldWrapper> noKeyFieldWrapperList;
    private List<BFieldWrapper> indexFieldWrapperList;
    private String keytype;
    private String keyname;
    private String keynameHump;
    private String keynameHumpCapital;

    private int keySize;
    private int noKeySize;
    private int fieldSize;
    private int indexSize;
    
   private String beanJavafilename;
    private String daoJavafilename;
    private String daoimplJavafilename;
    private String servJavafilename;
    private String controlJavafilename;
    private String servReadJavafilename;
    private String servReadPackage;

    private String servUpdateJavafilename;
    private String servUpdatePackage;

    
//    private String beanfullname;
    private String daoExJavafilename;
    private String daoimplExJavafilename;
    private String servExJavafilename;
    private String controlExJavafilename;
    
    private String beanjavaname;
    private String daojavaname;
    private String daoimpljavaname;
    private String servjavaname;
    private String controljavaname;
    
    private String beanfullname;
    
    private String daoExjavaname;
    private String daoimplExjavaname;
    private String servExjavaname;
    private String controlExjavaname;
    
    private String viewAddname;
    private String viewEditname;
    private String viewListname;
    
    private String cnname;
    private String commonPackage;
    private String relativePath;
    private String projectDir;

    Map<String,BFieldWrapper> bFieldWrapperMap = new HashMap();
    Map<String,BFieldWrapper> keyBFieldWrapperMap = new HashMap();
    Map<String,BFieldWrapper> indexBFieldWrapperMap = new HashMap<>();

    
    public BTableWrapper(BTable bTable){
        this.databasename = bTable.getDatabasename();
        this.Cdatabasename = StringUtil.capital(this.databasename);
        this.bTable = bTable;
        
         this.tablename = bTable.getName();
        //处理前缀表格中的下划线
        String tablename_org=StringUtil.getTablenameOrg(tablename);
        
        //this.beanname = StringUtils.capitalize(tablename_org);
       
        this.instancename = MyStringUtils.lowFirstString(StringUtil.getTableNameHump(tablename));
        this.beanname = MyStringUtils.UpperFirstString(instancename);
        this.packagename=bTable.getPackageName();
        this.packagenameCurrent = bTable.getPackageNameCurrent();
        this.setPackagenameCurrent(bTable.getPackageNameCurrent());
        this.commonPackage = bTable.getCommonPackage();

        this.relativePath= bTable.getRelativePath();
        this.projectDir = bTable.getProjectDir();

        int keySize = bTable.getKeyFieldList().size();
        this.keySize = keySize;
        if(keySize==1) {
            BField keyField = bTable.getKeyFieldList().get(0);
            String mysqltype = keyField.getType();
            if (mysqltype != null) {
                if (mysqltype.equalsIgnoreCase("varchar"))
                    this.keytype = "String";
                else if (mysqltype.equalsIgnoreCase("int")||mysqltype.equalsIgnoreCase("tinyint")||mysqltype.equalsIgnoreCase("bigint"))
                    this.keytype = "Integer";
            }
            this.keyname =keyField.getField();
        }else {
            this.keytype="compKey";
            this.keyname="compKeyName";
        }

        List<BField> bFieldList = bTable.getFieldList();
        fieldSize = bFieldList.size();
        System.out.println("size:"+bFieldList.size());
        this.bFieldWrapperList = new ArrayList<>();
        
        bKeyFieldWrapperList = new ArrayList<>();
        noKeyFieldWrapperList = new ArrayList<>();
        indexFieldWrapperList = new ArrayList<>();
        for (int i = 0; i < fieldSize; i++) {
            BField bField=(BField)bFieldList.get(i);
            BFieldWrapper bFieldWrapper = new BFieldWrapper(bField);
            bFieldWrapperList.add(bFieldWrapper);

            System.out.println("inited field name:"+bFieldWrapper.getFieldname());
            bFieldWrapperMap.put(bFieldWrapper.getFieldname(),bFieldWrapper);
            
            System.out.println("is key 1111:"+ bField.getIsKey());
            if(bField.getIsKey().trim().equalsIgnoreCase("PRI")){
                bKeyFieldWrapperList.add(bFieldWrapper);
                keyBFieldWrapperMap.put(bFieldWrapper.getFieldname(),bFieldWrapper);
            }else{
                noKeyFieldWrapperList.add(bFieldWrapper);
            }

            if(bField.isIndex()){
                indexFieldWrapperList.add(bFieldWrapper);
                indexBFieldWrapperMap.put(bFieldWrapper.getFieldname(),bFieldWrapper);
            }
        }
        indexSize = indexFieldWrapperList.size();
        keySize = bKeyFieldWrapperList.size();
        System.out.println("key size:"+keySize);
        
        noKeySize = fieldSize-keySize;
        System.out.println("wraplist size:"+bFieldWrapperList.size());
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getBeanname() {
        return beanname;
    }

    public void setBeanname(String beanname) {
        this.beanname = beanname;
    }

    public List<BFieldWrapper> getbFieldWrapperList() {
        return bFieldWrapperList;
    }

    public void setbFieldWrapperList(List<BFieldWrapper> bFieldWrapperList) {
        this.bFieldWrapperList = bFieldWrapperList;
    }

    public BTable getbTable() {
        return bTable;
    }

    public void setbTable(BTable bTable) {
        this.bTable = bTable;
    }

    public String getInstancename() {
        return instancename;
    }

    public void setInstancename(String instancename) {
        this.instancename = instancename;
    }

    public String getKeytype() {
        return keytype;
    }

    public void setKeytype(String keytype) {
        this.keytype = keytype;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public List<BFieldWrapper> getbKeyFieldWrapperList() {
        return bKeyFieldWrapperList;
    }

    public void setbKeyFieldWrapperList(List<BFieldWrapper> bKeyFieldWrapperList) {
        this.bKeyFieldWrapperList = bKeyFieldWrapperList;
    }

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public int getNoKeySize() {
        return noKeySize;
    }

    public void setNoKeySize(int noKeySize) {
        this.noKeySize = noKeySize;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getDatabasename() {
        return databasename;
    }

    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }

    public String getBeanjavaname() {
        return beanjavaname;
    }

    public void setBeanjavaname(String beanjavaname) {
        this.beanjavaname = beanjavaname;
    }

    public String getDaojavaname() {
        return daojavaname;
    }

    public void setDaojavaname(String daojavaname) {
        this.daojavaname = daojavaname;
    }

    public String getDaoimpljavaname() {
        return daoimpljavaname;
    }

    public void setDaoimpljavaname(String daoimpljavaname) {
        this.daoimpljavaname = daoimpljavaname;
    }

    public String getServjavaname() {
        return servjavaname;
    }

    public void setServjavaname(String servjavaname) {
        this.servjavaname = servjavaname;
    }

    public String getControljavaname() {
        return controljavaname;
    }

    public void setControljavaname(String controljavaname) {
        this.controljavaname = controljavaname;
    }

    public String getDaoExjavaname() {
        return daoExjavaname;
    }

    public void setDaoExjavaname(String daoExjavaname) {
        this.daoExjavaname = daoExjavaname;
    }

    public String getDaoimplExjavaname() {
        return daoimplExjavaname;
    }

    public void setDaoimplExjavaname(String daoimplExjavaname) {
        this.daoimplExjavaname = daoimplExjavaname;
    }

   

    public String getServExjavaname() {
        return servExjavaname;
    }

    public void setServExjavaname(String servExjavaname) {
        this.servExjavaname = servExjavaname;
    }

    public String getControlExjavaname() {
        return controlExjavaname;
    }

    public void setControlExjavaname(String controlExjavaname) {
        this.controlExjavaname = controlExjavaname;
    }
   

    public String getCdatabasename() {
        return Cdatabasename;
    }

    public void setCdatabasename(String Cdatabasename) {
        this.Cdatabasename = Cdatabasename;
    }

    public Date getNow() {
        return now;
    }
    
    public String getNows(){
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        String ss = sdf.format(now);
        return ss;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDaoExpackname() {
        return daoExpackname;
    }

    public void setDaoExpackname(String daoExpackname) {
        this.daoExpackname = daoExpackname;
    }

    public String getServExpackname() {
        return servExpackname;
    }

    public void setServExpackname(String servExpackname) {
        this.servExpackname = servExpackname;
    }

    public String getDaoimplExpackname() {
        return daoimplExpackname;
    }

    public void setDaoimplExpackname(String daoimplExpackname) {
        this.daoimplExpackname = daoimplExpackname;
    }

    public String getControlExpackagename() {
        return controlExpackagename;
    }

    public void setControlExpackagename(String controlExpackagename) {
        this.controlExpackagename = controlExpackagename;
    }

    public String getDaofilename() {
        return daofilename;
    }

    public void setDaofilename(String daofilename) {
        this.daofilename = daofilename;
    }

    public String getDaoimplfilename() {
        return daoimplfilename;
    }

    public void setDaoimplfilename(String daoimplfilename) {
        this.daoimplfilename = daoimplfilename;
    }

    public String getServfilename() {
        return servfilename;
    }

    public void setServfilename(String servfilename) {
        this.servfilename = servfilename;
    }

    public String getControlfilename() {
        return controlfilename;
    }

    public void setControlfilename(String controlfilename) {
        this.controlfilename = controlfilename;
    }

    public String getDaoExfilename() {
        return daoExfilename;
    }

    public void setDaoExfilename(String daoExfilename) {
        this.daoExfilename = daoExfilename;
    }

    public String getDaoimplExfilename() {
        return daoimplExfilename;
    }

    public void setDaoimplExfilename(String daoimplExfilename) {
        this.daoimplExfilename = daoimplExfilename;
    }

    

    public String getServExfilename() {
        return servExfilename;
    }

    public void setServExfilename(String servExfilename) {
        this.servExfilename = servExfilename;
    }

   

   

    public String getControlExfilename() {
        return controlExfilename;
    }

    public void setControlExfilename(String controlExfilename) {
        this.controlExfilename = controlExfilename;
    }

    public String getBeanpackagename() {
        return beanpackagename;
    }

    public void setBeanpackagename(String beanpackagename) {
        this.beanpackagename = beanpackagename;
    }

    public String getDaopackname() {
        return daopackname;
    }

    public void setDaopackname(String daopackname) {
        this.daopackname = daopackname;
    }

    public String getServpackname() {
        return servpackname;
    }

    public void setServpackname(String servpackname) {
        this.servpackname = servpackname;
    }

    public String getDaoimplpackname() {
        return daoimplpackname;
    }

    public void setDaoimplpackname(String daoimplpackname) {
        this.daoimplpackname = daoimplpackname;
    }

    public String getControlpackagename() {
        return controlpackagename;
    }

    public void setControlpackagename(String controlpackagename) {
        this.controlpackagename = controlpackagename;
    }

    public String getBeanfilename() {
        return beanfilename;
    }

    public void setBeanfilename(String beanfilename) {
        this.beanfilename = beanfilename;
    }

    public String getBeanJavafilename() {
        return beanJavafilename;
    }

    public void setBeanJavafilename(String beanJavafilename) {
        this.beanJavafilename = beanJavafilename;
    }

    public String getDaoJavafilename() {
        return daoJavafilename;
    }

    public void setDaoJavafilename(String daoJavafilename) {
        this.daoJavafilename = daoJavafilename;
    }

    public String getDaoimplJavafilename() {
        return daoimplJavafilename;
    }

    public void setDaoimplJavafilename(String daoimplJavafilename) {
        this.daoimplJavafilename = daoimplJavafilename;
    }

    public String getServJavafilename() {
        return servJavafilename;
    }

    public void setServJavafilename(String servJavafilename) {
        this.servJavafilename = servJavafilename;
    }

    public String getControlJavafilename() {
        return controlJavafilename;
    }

    public void setControlJavafilename(String controlJavafilename) {
        this.controlJavafilename = controlJavafilename;
    }

    public String getDaoExJavafilename() {
        return daoExJavafilename;
    }

    public void setDaoExJavafilename(String daoExJavafilename) {
        this.daoExJavafilename = daoExJavafilename;
    }

    public String getDaoimplExJavafilename() {
        return daoimplExJavafilename;
    }

    public void setDaoimplExJavafilename(String daoimplExJavafilename) {
        this.daoimplExJavafilename = daoimplExJavafilename;
    }

    public String getServExJavafilename() {
        return servExJavafilename;
    }

    public void setServExJavafilename(String servExJavafilename) {
        this.servExJavafilename = servExJavafilename;
    }

    public String getControlExJavafilename() {
        return controlExJavafilename;
    }

    public void setControlExJavafilename(String controlExJavafilename) {
        this.controlExJavafilename = controlExJavafilename;
    }

    public String getBeanfullname() {
        return beanfullname;
    }

    public void setBeanfullname(String beanfullname) {
        this.beanfullname = beanfullname;
    }

    public String getViewAddname() {
        return viewAddname;
    }

    public void setViewAddname(String viewAddname) {
        this.viewAddname = viewAddname;
    }

    public String getViewEditname() {
        return viewEditname;
    }

    public void setViewEditname(String viewEditname) {
        this.viewEditname = viewEditname;
    }

    public String getViewListname() {
        return viewListname;
    }

    public void setViewListname(String viewListname) {
        this.viewListname = viewListname;
    }

    public List<BFieldWrapper> getNoKeyFieldWrapperList() {
        return noKeyFieldWrapperList;
    }

    public void setNoKeyFieldWrapperList(List<BFieldWrapper> noKeyFieldWrapperList) {
        this.noKeyFieldWrapperList = noKeyFieldWrapperList;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getBeanExpackagename() {
        return beanExpackagename;
    }

    public void setBeanExpackagename(String beanExpackagename) {
        this.beanExpackagename = beanExpackagename;
    }

    public String getBeanExjavaname() {
        return beanExjavaname;
    }

    public void setBeanExjavaname(String beanExjavaname) {
        this.beanExjavaname = beanExjavaname;
    }

    public String getBeanExJavafilename() {
        return beanExJavafilename;
    }

    public void setBeanExJavafilename(String beanExJavafilename) {
        this.beanExJavafilename = beanExJavafilename;
    }

    public String getBeanpackageforimport() {
        return beanpackageforimport;
    }

    public void setBeanpackageforimport(String beanpackageforimport) {
        this.beanpackageforimport = beanpackageforimport;
    }

    public String getBeanexpackageforimport() {
        return beanexpackageforimport;
    }

    public void setBeanexpackageforimport(String beanexpackageforimport) {
        this.beanexpackageforimport = beanexpackageforimport;
    }

    public String getBeanfileforimport() {
        return beanfileforimport;
    }

    public void setBeanfileforimport(String beanfileforimport) {
        this.beanfileforimport = beanfileforimport;
    }

    public String getBeanexfileforimport() {
        return beanexfileforimport;
    }

    public void setBeanexfileforimport(String beanexfileforimport) {
        this.beanexfileforimport = beanexfileforimport;
    }

    public String getDaopackageforimport() {
        return daopackageforimport;
    }

    public void setDaopackageforimport(String daopackageforimport) {
        this.daopackageforimport = daopackageforimport;
    }

    public String getDaoexpackageforimport() {
        return daoexpackageforimport;
    }

    public void setDaoexpackageforimport(String daoexpackageforimport) {
        this.daoexpackageforimport = daoexpackageforimport;
    }

    public String getDaofileforimport() {
        return daofileforimport;
    }

    public void setDaofileforimport(String daofileforimport) {
        this.daofileforimport = daofileforimport;
    }

    public String getDaoexfileforimport() {
        return daoexfileforimport;
    }

    public void setDaoexfileforimport(String daoexfileforimport) {
        this.daoexfileforimport = daoexfileforimport;
    }

    public String getDaoimplpackageforimport() {
        return daoimplpackageforimport;
    }

    public void setDaoimplpackageforimport(String daoimplpackageforimport) {
        this.daoimplpackageforimport = daoimplpackageforimport;
    }

    public String getDaoimplexpackageforimport() {
        return daoimplexpackageforimport;
    }

    public void setDaoimplexpackageforimport(String daoimplexpackageforimport) {
        this.daoimplexpackageforimport = daoimplexpackageforimport;
    }

    public String getDaoimplfileforimport() {
        return daoimplfileforimport;
    }

    public void setDaoimplfileforimport(String daoimplfileforimport) {
        this.daoimplfileforimport = daoimplfileforimport;
    }

    public String getDaoimplexfileforimport() {
        return daoimplexfileforimport;
    }

    public void setDaoimplexfileforimport(String daoimplexfileforimport) {
        this.daoimplexfileforimport = daoimplexfileforimport;
    }

    public String getServpackageforimport() {
        return servpackageforimport;
    }

    public void setServpackageforimport(String servpackageforimport) {
        this.servpackageforimport = servpackageforimport;
    }

   

    public String getServexpackageforimport() {
        return servexpackageforimport;
    }

    public void setServexpackageforimport(String servexpackageforimport) {
        this.servexpackageforimport = servexpackageforimport;
    }

    public String getServfileforimport() {
        return servfileforimport;
    }

    public void setServfileforimport(String servfileforimport) {
        this.servfileforimport = servfileforimport;
    }

    public String getServexfileforimport() {
        return servexfileforimport;
    }

    public void setServexfileforimport(String servexfileforimport) {
        this.servexfileforimport = servexfileforimport;
    }

    public String getControlpackageforimport() {
        return controlpackageforimport;
    }

    public void setControlpackageforimport(String controlpackageforimport) {
        this.controlpackageforimport = controlpackageforimport;
    }

    public String getControlexpackageforimport() {
        return controlexpackageforimport;
    }

    public void setControlexpackageforimport(String controlexpackageforimport) {
        this.controlexpackageforimport = controlexpackageforimport;
    }

    public String getControlfileforimport() {
        return controlfileforimport;
    }

    public void setControlfileforimport(String controlfileforimport) {
        this.controlfileforimport = controlfileforimport;
    }

    public String getControlexfileforimport() {
        return controlexfileforimport;
    }

    public void setControlexfileforimport(String controlexfileforimport) {
        this.controlexfileforimport = controlexfileforimport;
    }

    public String getRelativepath() {
        return relativepath;
    }

    public void setRelativepath(String relativepath) {
        this.relativepath = relativepath;
    }


    public String getCommonPackage() {
        return commonPackage;
    }

    public void setCommonPackage(String commonPackage) {
        this.commonPackage = commonPackage;
    }

    public Map<String, BFieldWrapper> getbFieldWrapperMap() {
        return bFieldWrapperMap;
    }

    public void setbFieldWrapperMap(Map<String, BFieldWrapper> bFieldWrapperMap) {
        this.bFieldWrapperMap = bFieldWrapperMap;
    }


    public List<BFieldWrapper> getIndexFieldWrapperList() {
        return indexFieldWrapperList;
    }

    public void setIndexFieldWrapperList(List<BFieldWrapper> indexFieldWrapperList) {
        this.indexFieldWrapperList = indexFieldWrapperList;
    }

    public Map<String, BFieldWrapper> getIndexBFieldWrapperMap() {
        return indexBFieldWrapperMap;
    }

    public void setIndexBFieldWrapperMap(Map<String, BFieldWrapper> indexBFieldWrapperMap) {
        this.indexBFieldWrapperMap = indexBFieldWrapperMap;
    }

    public Map<String, BFieldWrapper> getKeyBFieldWrapperMap() {
        return keyBFieldWrapperMap;
    }

    public void setKeyBFieldWrapperMap(Map<String, BFieldWrapper> keyBFieldWrapperMap) {
        this.keyBFieldWrapperMap = keyBFieldWrapperMap;
    }

    public String getKeynameHump() {
        return StringTool.underLineToHump(keyname);
    }

    public void setKeynameHump(String keynameHump) {
        this.keynameHump = keynameHump;
    }

    public String getPackagenameCurrent() {
        return packagenameCurrent;
    }

    public void setPackagenameCurrent(String packagenameCurrent) {
        this.packagenameCurrent = packagenameCurrent;
    }


    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getProjectDir() {
        return projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }

    public String getServReadJavafilename() {
        return servReadJavafilename;
    }

    public void setServReadJavafilename(String servReadJavafilename) {
        this.servReadJavafilename = servReadJavafilename;
    }

    public String getServReadPackage() {
        return servReadPackage;
    }

    public void setServReadPackage(String servReadPackage) {
        this.servReadPackage = servReadPackage;
    }


    public String getServUpdateJavafilename() {
        return servUpdateJavafilename;
    }

    public void setServUpdateJavafilename(String servUpdateJavafilename) {
        this.servUpdateJavafilename = servUpdateJavafilename;
    }

    public String getServUpdatePackage() {
        return servUpdatePackage;
    }

    public void setServUpdatePackage(String servUpdatePackage) {
        this.servUpdatePackage = servUpdatePackage;
    }

    public String getKeynameHumpCapital() {
        return StringUtil.capital(getKeynameHump());
    }

    public void setKeynameHumpCapital(String keynameHumpCapital) {
        this.keynameHumpCapital = keynameHumpCapital;
    }


    public int getIndexSize() {
        return indexSize;
    }

    public void setIndexSize(int indexSize) {
        this.indexSize = indexSize;
    }
}
