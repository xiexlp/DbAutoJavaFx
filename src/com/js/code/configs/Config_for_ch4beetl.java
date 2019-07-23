package com.js.code.configs;

import com.js.code.def.FrameWorkType;
import com.js.code.def.ProjectType;
import com.js.code.def.ViewTemplate;

/**
 * 基本配置，把这个类配置好就可以
 */
public class Config_for_ch4beetl {
    //数据库名
    public static String DBNAME="iforum";
    //父目录
    public static String PACKAGENAME= "com.js.iforum";
    //项目的总目录
    public static String PROJECTDIR="F:\\jfinal\\beetl series\\Spring-Boot-2.0-Samples\\4_views\\ch4.beetl";
    //public static String PROJECTDIR="F:\\jfinal\\beetl series\\Spring-Boot-2.0-Samples\\4_views\\ch4.beetl";
    //生成的html放入的目录,jfinal使用
    //public static String WEBRELATIVEDIR ="\\src\\main\\webapp\\boot";
    //生成的html放入springmvc的目录
    public static String WEBRELATIVEDIR ="\\src\\main\\resources\\templates";
    //这个是controller的包位置,实际的在这里不用 controller+package
    //public static String CONTROLLER="com.js.iforum.boot";
    public static String CONTROLLER="com.bee.sample.ch4";
    //这个是通用包的位置
    public static String COMMONPACKAGE="com.js.common";
    //是否是Maven项目，如果是则源码目录为src/main/java,否则目录为src
    //public static boolean ISMAVENPROJECT=true;

    public static int PROJECTTYPE= ProjectType.MAVEN;
    //项目框架是spring还是jfinal
    public static int FRAMEWORKTYPE= FrameWorkType.SPRINGBOOT;
    //view model
    public static int VIEWTEMPLATE= ViewTemplate.BEETL;//



}
