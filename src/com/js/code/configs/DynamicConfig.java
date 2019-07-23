package com.js.code.configs;

import com.js.code.Config;

import java.sql.Connection;

public class DynamicConfig {


    public DynamicConfig(){
        this.dbname = Config.DBNAME;
        this.basePackageName = Config.PACKAGENAME;
        this.projectDir = Config.PROJECTDIR;
        this.webRelativeDir = Config.WEBRELATIVEDIR;
        this.controllerPackage= Config.CONTROLLER;
        this.commonPackage = Config.COMMONPACKAGE;
        this.relativePath = Config.RELATIVEPATH;
        this.projectType = Config.PROJECTTYPE;
        this.frameworkType = Config.FRAMEWORKTYPE;
        this.encode = Config.ENCODEUTF8;
        this.port = Config.PORT;
        this.initableBean = Config.INITTABLEBEAN;
        this.beanDefParentPackage = Config.BEAN_DEF_PARENT_PACKAGE;
    }

   public String dbname;
    public String port;
    //存放 orm ,service,dao,daoim的包和目录;
   public String basePackageName;

    public String initableBean;

    public String beanDefParentPackage;

    //项目的根目录，绝对路径
   public String projectDir;

    //网页存放的相对目录
   public String webRelativeDir;

    //controller 存放的包,因为有面向用户的，面向管理的，面向用户管理的，所以不一样
   public String controllerPackage;

    //通用包
    public String commonPackage;

    //相对路径
    public String relativePath;

    //maven 类型
    public int projectType;

    //jfinal 还是 springboot
    public int frameworkType;

    //一般是这个不用变
    public String encode="utf-8";

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getBeanDefParentPackage() {
        return beanDefParentPackage;
    }

    public void setBeanDefParentPackage(String beanDefParentPackage) {
        this.beanDefParentPackage = beanDefParentPackage;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getBasePackageName() {
        return basePackageName;
    }

    public void setBasePackageName(String basePackageName) {
        this.basePackageName = basePackageName;
    }

    public String getProjectDir() {
        return projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }

    public String getWebRelativeDir() {
        return webRelativeDir;
    }

    public void setWebRelativeDir(String webRelativeDir) {
        this.webRelativeDir = webRelativeDir;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getCommonPackage() {
        return commonPackage;
    }

    public void setCommonPackage(String commonPackage) {
        this.commonPackage = commonPackage;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public int getProjectType() {
        return projectType;
    }

    public void setProjectType(int projectType) {
        this.projectType = projectType;
    }

    public int getFrameworkType() {
        return frameworkType;
    }

    public void setFrameworkType(int frameworkType) {
        this.frameworkType = frameworkType;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getInitableBean() {
        return initableBean;
    }

    public void setInitableBean(String initableBean) {
        this.initableBean = initableBean;
    }
}
