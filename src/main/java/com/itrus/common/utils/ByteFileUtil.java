package com.itrus.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 
 * @author han_yanhui
 *
 * 2020-5-1 17:16:48
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ByteFileUtil {
	
	/**
    *
    * @api  ByteFileUtil.copyFile2Byte File转化Byte[]
    * @apiVersion 2.2.0
    * @apiParam {File} file file文件 
    * @apiName copyFile2Byte
    * @apiGroup ByteFileUtil工具类
    * @apiSuccess (Success) {byte[]} byte byte[]数组
    * @apiSuccessExample Success-Response:
    *     {byte[] = {1,1,1,1,1,1,1,1,1,1,1,1,1}}
	*/
	public static byte [] copyFile2Byte(File file){
        InputStream in = null;

        try {
            in = new FileInputStream(file);
            //文件长度
            int len = in.available();

            //定义数组
            byte [] bytes = new byte[len];

            //读取到数组里面
            in.read(bytes);
            return bytes;
        } catch (Exception e) {
        	log.error(e.getMessage());
            return null;
        }finally{
            try {
                if(in != null){
                    in.close();
                }
            } catch (Exception e) {
            	log.error(e.getMessage());
            }
        }
    }

	/**
    *
    * @api ByteFileUtil.copyByteToFile Byte[]写入File
    * @apiVersion 2.2.0
    * @apiParam {byte[]} bytes byte[]数组
    * @apiParam {File} file file文件 
    * @apiName copyByteToFile
    * @apiGroup ByteFileUtil工具类
    * @apiSuccess (Success) {File} file file数组
    * @apiSuccessExample Success-Response:
    *     {file = {file文件}}
	*/
    public static boolean copyByteToFile(byte [] bytes,File file){
        FileOutputStream  out = null;
        try {
            //转化为输入流
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);

            //写出文件
            byte[] buffer = new byte[1024];

            out = new FileOutputStream(file);

            //写文件
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len); // 文件写入操作
            }
            return true;
        } catch (Exception e) {
        	log.error(e.getMessage());
        }finally{
            try {
                if(out != null){
                    out.close();//关闭流
                }
            } catch (IOException e) {
            	log.error(e.getMessage());
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
		
    	File file = new File("E:\\ceshi.png");
    	byte[] bytes = copyFile2Byte(file);
    	File files = new File("ceshi.md");//创建一个初始化file，ceshi.md 是文件流的 pathName，必填项
    	System.out.println(JSON.toJSONString(file));
    	boolean copyByteToFile = copyByteToFile(bytes, files);
    	System.out.println(copyByteToFile);
    	
	}
}
