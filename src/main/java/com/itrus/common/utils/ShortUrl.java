package com.itrus.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 长连接转短连接工具类
 * 当我们生成短链接之后，只需要在表中（数据库或者NoSql ）存储原始链接与短链接的映射关系即可。
 * 当我们访问短链接时，只需要从映射关系中找到原始链接，即可跳转到原始链接。
 
 * 注：目前第三方也有很多长转短的服务，考虑收费、服务稳定性两方面，此实现方法是不错的选择。
 * @author wgx52
 *
 */
public class ShortUrl {
	public static void main(String[] args) {  
        // 长连接  
        String longUrl = "http://topics.gmw.cn/node_133871.htm#jddtPoint";  
        // 转换成的短链接后6位码  
        String[] shortCodeArray = shortUrl(longUrl);  
          
        for (int i = 0; i < shortCodeArray.length; i++) {  
            System.out.println(shortCodeArray[i]);// 任意一个都可以作为短链接码  
        }  
    }  
	
	/**
    *
    * @api ShortUrl.shortUrl 长链接转短链接
    * @apiDescription  当我们生成短链接之后，只需要在表中（数据库或者NoSql ）存储原始链接与短链接的映射关系即可。
    * @apiVersion 2.2.0
    * @apiParam {String} url 长链接
    * @apiName shortUrl
    * @apiGroup ShortUrl工具类
    * @apiSuccess (Success) {String[]} string 短链接
    * @apiSuccessExample Success-Response:
    *     {
    *       "string":["a","K","l","S"]
    *     }
	*/
    public static String[] shortUrl(String url) {  
        // 可以自定义生成 MD5 加密字符传前的混合 KEY  
        String key = "";  
        // 要使用生成 URL 的字符  
        String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",  
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",  
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",  
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",  
                "U", "V", "W", "X", "Y", "Z" };  
  
        // 对传入网址进行 MD5 加密  
        String sMD5EncryptResult = DigestUtils.md5Hex(key + url);  
        String hex = sMD5EncryptResult;  
        String[] resUrl = new String[4];  
        for (int i = 0; i < 4; i++) {  
            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算  
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);  
            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用  
            // long ，则会越界  
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);  
            String outChars = "";  
            for (int j = 0; j < 6; j++) {  
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引  
                long index = 0x0000003D & lHexLong;  
                // 把取得的字符相加  
                outChars += chars[(int) index];  
                // 每次循环按位右移 5 位  
                lHexLong = lHexLong >> 5;  
            }  
  
            // 把字符串存入对应索引的输出数组  
            resUrl[i] = outChars;  
        }  
        return resUrl;  
    }  
}
