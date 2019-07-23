/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class BTable {
    
    private String databasename;
    private String name;
    private List<BField> fieldList;
    private List<BField> keyFieldList;
    private List<BField> indexFieldList;
    private String key;
    private BField keybField;
    private String packageName;
    private String packageNameCurrent;

    public String commonPackage;

    private String relativePath;
    private String projectDir;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<BField> fieldList) {
        this.fieldList = fieldList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BField getKeybField() {
        return keybField;
    }

    public void setKeybField(BField keybField) {
        this.keybField = keybField;
    }

    public List<BField> getKeyFieldList() {
        return keyFieldList;
    }

    public void setKeyFieldList(List<BField> keyFieldList) {
        this.keyFieldList = keyFieldList;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDatabasename() {
        return databasename;
    }

    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }


    public String getCommonPackage() {
        return commonPackage;
    }

    public void setCommonPackage(String commonPackage) {
        this.commonPackage = commonPackage;
    }


    public String getPackageNameCurrent() {
        return packageNameCurrent;
    }

    public void setPackageNameCurrent(String packageNameCurrent) {
        this.packageNameCurrent = packageNameCurrent;
    }


    public List<BField> getIndexFieldList() {
        return indexFieldList;
    }

    public void setIndexFieldList(List<BField> indexFieldList) {
        this.indexFieldList = indexFieldList;
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
}
