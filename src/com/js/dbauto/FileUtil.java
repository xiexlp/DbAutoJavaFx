/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.dbauto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

/**
 *
 * @author Administrator
 */
public class FileUtil {

    public static void close(FileOutputStream fos, OutputStreamWriter osw) {
        try {
            if (fos != null) {
                fos.close();
            }
            if (osw != null) {
                osw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String readFileAllContent(String path) throws Exception {
        File f=null;
        FileReader fr=null;
        BufferedReader br=null;
        try {
            f = new File(path);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer("");
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            System.out.println(sb.toString());
            String a = sb.toString().trim();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(f!=null){
                
            }
            if(fr!=null){
                fr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return "";
    }

    public static String readFileContent(String path) throws FileNotFoundException {
        try {
            File f = new File(path);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer("");
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            System.out.println(sb.toString());
            String a = sb.toString().trim();
            int l = a.length();
            return a.substring(0, l - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void writeFileContent(String path, String content) throws Exception {
        File f = new File(path);
        FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        osw.write(content);
        osw.flush();
        osw.close();
        fos.close();
    }

    public static void randowAppend(String path, String appendContent) {
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.seek(raf.length() - 1);
            raf.write(appendContent.getBytes());
            raf.write("\n}".getBytes());
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void javaCodeAppend(String path, String appendContent) {
        try {
            File file = new File(path);
            String content = readFileAllContent(path);
            int lastParentIndex = content.lastIndexOf("}");
            System.out.println(lastParentIndex);
            String preContent =content.substring(0,lastParentIndex-1);
            String nextContent= content.substring(lastParentIndex+1,content.length());

            String newContent = preContent+appendContent+"}"+nextContent;

            writeFileContent(path,newContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getInstanceTablename(String tablename){
        int index= tablename.indexOf("_");
        String tablename_org="";
        if(index>0){
            tablename_org= tablename.substring(index+1);
            int ind = tablename_org.indexOf("_");
            if(ind>0){
                tablename_org = tablename_org.replace("_", "");
            }
        }
        else tablename_org = tablename;
        return  tablename_org;
    }


    public static void main(String[] args) {

        String toContent= "aaaaa";
        String path = "F:\\java workplace\\DbAutoJavaFx\\src\\com\\js\\dbauto\\FileTest.java";
        javaCodeAppend(path,toContent);



    }

    public static String getLastDirName(String filename){
        int index = filename.lastIndexOf("\\");
        String name = filename.substring(index+1,filename.length());
        return name;
    }

}
