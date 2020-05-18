package com.itrus.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* <p>Title: FileTest.java</p>
* <p>Description: 文件复制工具类</p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: com.itrus</p>
* @author wen_guoxing
* @date 2019年8月9日
* @version 1.0
 */
public class FileUtil {

	public static void main(String[] args) throws IOException {


		copyFolder("F:\\worker\\bakup", "F:\\worker\\bakup1");

	}

	/**
	* <p>Title: copyFolder</p>
	* <p>Description: </p>
	* @param sourcePath 原来路径
	* @param targetPath 目标路径
	* @throws IOException
	 */
	public static void copyFolder(String sourcePath, String targetPath) throws IOException  { 
		// 如果文件夹不存在，则建立新文件夹 
		(new File(targetPath)).mkdirs(); 
		//读取整个文件夹的内容到file字符串数组，下面设置一个游标i，不停地向下移开始读这个数组 
		File filelist = new File(sourcePath); 
		String[] file = filelist.list(); 
		//要注意，这个temp仅仅是一个临时文件指针 
		//整个程序并没有创建临时文件 
		File temp = null; 
		for (int i = 0; i < file.length; i++) { 
			//如果oldPath以路径分隔符/或者\结尾，那么则oldPath/文件名就可以了 
			//否则要自己oldPath后面补个路径分隔符再加文件名 
			//谁知道你传递过来的参数是f:/a还是f:/a/啊？ 
			if (sourcePath.endsWith(File.separator)) { 
				temp = new File(sourcePath + file[i]); 
			} else { 
				temp = new File(sourcePath + File.separator + file[i]); 
			} 

			//如果游标遇到文件 
			if (temp.isFile()) { 
				FileInputStream input = new FileInputStream(temp); 
				FileOutputStream output = new FileOutputStream(targetPath 
						+ "/" + "rename_" + (temp.getName()).toString()); 
				byte[] bufferarray = new byte[1024 * 64]; 
				int prereadlength; 
				while ((prereadlength = input.read(bufferarray)) != -1) { 
					output.write(bufferarray, 0, prereadlength); 
				} 
				output.flush(); 
				output.close(); 
				input.close(); 
			} 
			//如果游标遇到文件夹 
			if (temp.isDirectory()) { 
				copyFolder(sourcePath + "/" + file[i], targetPath + "/" + file[i]); 
			} 
		} 
	} 
}
