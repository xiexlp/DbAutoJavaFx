package com.js.bean.relations;


/**
 * 执行建表、修改表的操作数据库配置都在这里面
 */
public class Config {
    //下划线
    public static final int FIELD_UNDERLINE=0;
    //驼峰
    public static final int FIELD_HUMP=1;

    public static final String MYISAM="MyISAM";
    public static final String INNODB="INNODB";

    public static final String UTF8="utf8";
    //切换数据库修改这个变量就可以
    //public static final String DBNAME="iforum_index_db";
    //用户连接
    public static final String DBNAME="iplatform";
    //public static final String DBNAME="iforum";
    public static final String PORT="3306";

    public static final String INITTABLEBEAN="com.js.cms.ishop.orm.Item";


    public static final String BEAN_DEF_PARENT_PACKAGE="com.js.cms.ishop.orm";


    //public static final String INITTABLEBEAN="com.js.cms.orm.TopicStatus";




}
