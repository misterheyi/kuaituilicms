package com.yzq.katl.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageUtil {
	
	public static String download(String url , String savePath){
		byte[] btImg = getImageFromNetByUrl(url);
		if(null != btImg && btImg.length > 0){
			url = url.indexOf("?")==-1?url:url.subSequence(0 , url.indexOf("?")).toString();
			String fileType = url.substring(url.lastIndexOf("."),url.length());
			String fileName = UUIDGenerator.getUUID()+fileType;
			Date date = new Date();
			String basePath = "/poster_image/"+new SimpleDateFormat("yyyyMMdd").format(date)+"/";
			String filePath = savePath + basePath;
			File f = new File(filePath);
			if(!f.exists()){
				f.mkdirs();
			}
			writeImageToDisk(filePath , btImg, fileName);
			return basePath + fileName;
		}else{
			//没有读取到图片信息
		}
		return null;
	}
	
	/**
	 * 将图片写入到磁盘
	 * @param img 图片数据流
	 * @param fileName 文件保存时的名称
	 */
	public static void writeImageToDisk(String filePath , byte[] img, String fileName){
		try {
			File file = new File(filePath + fileName);
			FileOutputStream fops = new FileOutputStream(file);
			fops.write(img);
			fops.flush();
			fops.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据地址获得数据的字节流
	 * @param strUrl 网络连接地址
	 * @return
	 */
	public static byte[] getImageFromNetByUrl(String strUrl){
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
			byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
			return btImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 从输入流中获取数据
	 * @param inStream 输入流
	 * @return
	 * @throws Exception
	 */
	public static byte[] readInputStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while( (len=inStream.read(buffer)) != -1 ){
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}
