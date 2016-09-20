package com.love.life.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 
 * 类说明   : 文件转base64编码
 * 作者        :wgy
 * 日期        :2015-11-5下午4:43:00
 * 版本号    : V1.0
 */
public class Base64FileUtil {

	/** 
	* 编码 
	* @param bstr 
	* @return String 
	*/ 
	public static String encodeBase64(byte[] bstr){ 
		return new BASE64Encoder().encode(bstr); 
	} 
	
	/**
	 * 将文件转成base64 字符串
	 * 
	 * @param path文件路径
	 * @return *
	 * @throws Exception
	 */

	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new BASE64Encoder().encode(buffer);
	}

	/**
	 * 将base64字符解码保存文件
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws Exception
	 */

	public static void decoderBase64File(String base64Code, String targetPath)
			throws Exception {
		byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
		FileOutputStream out = new FileOutputStream(targetPath);
		out.write(buffer);
		out.close();

	}

	/**
	 * 将base64字符保存文本文件
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws Exception
	 */

	public static void toFile(String base64Code, String targetPath)
			throws Exception {

		byte[] buffer = base64Code.getBytes();
		FileOutputStream out = new FileOutputStream(targetPath);
		out.write(buffer);
		out.close();
	}

	public static void main(String[] args) {
		try {
			String base64Code = encodeBase64File("D:/yf.pdf");
//			StringBuffer sb = new StringBuffer();
//			sb.append("ddddddddddddddddddddddddddddddddddd");
//			String base64Code = encodeBase64(sb.toString().getBytes());
			System.out.println(base64Code);
//		    decoderBase64File(base64Code,"d:/yf1.pdf");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}