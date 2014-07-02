package com.adcc.skyfml.util;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: GuoXY
 * Date: 2014/7/1
 * Time: 8:54
 * To change this template use File | Settings | File Templates.
 */
public class FileUtil {
    // 通过内容判断文件类型是否为XML
    public static boolean IsXmlDocByContext(String fileName) {
        try {
//            System.out.println(fileName);
            FileReader read = new FileReader(fileName);
            BufferedReader br = new BufferedReader(read);

            String row;
            if (!ObjectUtil.isBlank( row = br.readLine() )) {
//                System.out.println(row);
                if(row.substring(0, 5).equals("<?xml") && row.substring(row.length() - 2, row.length()).equals("?>")) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 通过文件扩展名判断文件是不是txt
    public static boolean IsTxtDocByFileName(File file) {
        String name = file.getName();
        if(!name.trim().toLowerCase().endsWith(".txt")) {
//            System.out.println("非.txt文件");
            return false;
        } else {
            return true;
        }
    }

    public static boolean MoveFile (File oldFile, String strNewPath) {
        //new一个新文件夹
        File fnewpath = new File(strNewPath);
        //判断文件夹是否存在
        if(!fnewpath.exists())
            fnewpath.mkdirs();
        if ('/' != strNewPath.charAt(strNewPath.length() - 1) || '\\' != strNewPath.charAt(strNewPath.length() - 1) ) {
            strNewPath = strNewPath + '/';
        }

        //将文件移到新文件里
        File fnew = new File(strNewPath + oldFile.getName());
        oldFile.renameTo(fnew);
        return  true;
    }

    public static boolean MoveFile (String strOldFilePath, String strNewPath) {
        //文件原地址
        File oldFile = new File(strOldFilePath);
        //new一个新文件夹
        File fnewpath = new File(strNewPath);
        //判断文件夹是否存在
        if(!fnewpath.exists())
            fnewpath.mkdirs();
        if ('/' != strNewPath.charAt(strNewPath.length() - 1) || '\\' != strNewPath.charAt(strNewPath.length() - 1) ) {
            strNewPath = strNewPath + '/';
        }

        //将文件移到新文件里
        File fnew = new File(strNewPath + oldFile.getName());
        oldFile.renameTo(fnew);
        return true;
    }
}
