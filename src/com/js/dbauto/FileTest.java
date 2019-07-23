package com.js.dbauto;

import com.alibaba.fastjson.JSON;
import com.js.code.configs.DynamicConfig;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        String propFile = new String("little.properties");
        File file = new File(propFile);

        System.out.println(file.exists());

        DynamicConfig dynamicConfig = new DynamicConfig();



        String configStr = JSON.toJSONString(dynamicConfig);
        System.out.println(configStr);

        String filename="F:\\java workplace\\DbAutoJavaFx\\src\\com\\js\\dbauto";
        String name= FileUtil.getLastDirName(filename);
        System.out.println(name);


    }



}