package com.itrus.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import lombok.extern.slf4j.Slf4j;



/**
 * 将图片转换为Base64<br>
 * 将base64编码字符串解码成img图片
 * @创建时间 2015-06-01 15:50
 *
 */
@Slf4j
public class Img2Base64Util {

    public static void main(String[] args) throws Exception {
    	 String charset = "utf-8";
         File file = new File("i:\\new1.txt");
         long fileByteLength = file.length();
         byte[] content = new byte[(int)fileByteLength];
         FileInputStream fileInputStream = null;
         try {
             fileInputStream = new FileInputStream(file);
             fileInputStream.read(content);
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 fileInputStream.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         String str = null;
 		try {
 			str = new String(content,charset);
 		} catch (UnsupportedEncodingException e) {
 			log.error("生成图片错误：{}",e.getMessage());
 		}

        String imgFilePath = "d:\\99999.jpg";//新生成的图片
        generateImage(str,imgFilePath);
    	
    }

    /**
    *
    * @api Img2Base64Util.getImgStr 图片转换Base64编码
    * @apiVersion 2.2.0
    * @apiParam {String} imgFile 文件路径
    * @apiName getImgStr
    * @apiGroup Img2Base64Util工具类
    * @apiSuccess (Success) {String} string base64
    * @apiSuccessExample Success-Response:
    *     {
    *       "string":"ADDAHLDA115533321ALWO11N..."
    *     }
	*/
    public static String getImgStr(String imgFile){
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
  
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try{
            in = new FileInputStream(imgFile);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
        	log.error("生成base64编码：{}",e.getMessage());
        }
        return new String(Base64.encodeBase64(data));
    }
    
    /**
    *
    * @api Img2Base64Util.generateImage 字节数组字符串进行Base64解码并生成图片
    * @apiVersion 2.2.0
    * @apiParam {String} imgStr 字节数组字符串
    * @apiParam {String} imgFilePath 图片路径地址
    * @apiName generateImage
    * @apiGroup Img2Base64Util工具类
    * @apiSuccess (Success) {boolean} boo 成功失败
    * @apiSuccessExample Success-Response:
    *     {
    *       "boo":true
    *     }
	*/
    public static boolean generateImage(String imgStr,String imgFilePath){
        //
        if (imgStr == null) //图像数据为空
            return false;
     
        try {
            //Base64解码
            byte[] b = Base64.decodeBase64(imgStr);
            for(int i=0;i<b.length;++i){
                if(b[i]<0){//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);    
            out.write(b);
            out.flush();
            out.close();
            return true;
        }catch (Exception e) {
        	log.error("生成图片错误：{}",e.getMessage());
            return false;
        }
    }
}