package com.love.life.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.Logger;

/**
 * 
 * 〈功能简述〉
 * @author wugy08
 * @version [版本号，默认V1.0.0]
 * @Credited 2016年3月31日 下午6:41:38
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class HttpPoster {
	private static final Logger logger = Logger.getLogger(HttpPoster.class);

	/**
	 * http get 请求
	 * @param strURL http地址
	 * @return
	 */
	public static String get(String strURL) {
		return get(strURL, "application/x-www-form-urlencoded", "UTF-8", true,
				null);
	}
	
	/**
	 * http get 请求
	 * @param strURL http地址
	 * @param headers 头文信息
	 * @return
	 */
	public static String get(String strURL, Map<String, String> headers) {
		return get(strURL, "application/x-www-form-urlencoded", "UTF-8", true,
				headers);
	}

	/**
	 * http get 请求
	 * @param strURL http地址
	 * @param contentType Content-Type
	 * @param encode 编码
	 * @param response 请求返回
	 * @param headers 头文信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static String get(String strURL, String contentType, String encode,
			boolean response, Map<String, String> headers) {
		StopWatch watch = new StopWatch();
		watch.start();

		String result = null;
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		try {
            logger.info("http 请求 url = "+strURL);
			URL url = new URL(strURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", contentType);
			con.setRequestProperty("Comp-Control", "dsmp/sms-mt");
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setConnectTimeout(30000);
			con.setReadTimeout(30000);

			if ((headers != null) && (headers.size() > 0)) {
				Set keys = headers.keySet();
				Iterator ir = keys.iterator();

				while (ir.hasNext()) {
					String key = (String) ir.next();
					con.setRequestProperty(key, (String) headers.get(key));
				}
			}

			if (response) {
				in = new BufferedInputStream(con.getInputStream());
				result = readByteStream(in, encode);
			} else {
				con.getInputStream();
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
			}
		}
		
		logger.info("HttpPoster:[total time=" + watch.getTime() + ", url="
				+ strURL + ", contentType=" + contentType + ",ecode=" + encode
				+ ",response=" + result + "]");

		return result;
	}

	/**
	 * http post请求
	 * @param strURL
	 * @param req
	 */
	public static String postWithRes(String strURL, String req) {
		return post(strURL, req, "application/x-www-form-urlencoded", "UTF-8",
				true, null);
	}

	/**
	 * 带header
	 * @param strURL
	 * @param req
	 * @param headers
	 * @return
	 */
	public static String postWithRes(String strURL, String req,
			Map<String, String> headers) {
		return post(strURL, req, "application/x-www-form-urlencoded", "UTF-8",
				true, headers);
	}

	
	/**
	 * 传文�?	 * @param strURL
	 * @param req
	 * @param headers
	 * @return
	 */
	public static String postWithPath(String strURL, String path,
			Map<String, String> headers) {
		return postPath(strURL, path, "application/x-www-form-urlencoded",
				"UTF-8", true, headers);
	}

	public static String postJSONWithRes(String strURL, String json) {
		return post(strURL, json, "application/json", "UTF-8", true, null);
	}

	/**
	 * http post请求
	 * @param strURL
	 * @param req
	 * @param contentType
	 * @param encode
	 * @param response
	 * @param headers
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static String post(String strURL, String req, String contentType,
			String encode, boolean response, Map<String, String> headers) {
		StopWatch watch = new StopWatch();
		watch.start();

		String result = null;
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		try {
			URL url = new URL(strURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", contentType);
			con.setRequestProperty("Comp-Control", "dsmp/sms-mt");
			if ((headers != null) && (headers.size() > 0)) {
				Set keys = headers.keySet();
				Iterator ir = keys.iterator();

				while (ir.hasNext()) {
					String key = (String) ir.next();
					con.setRequestProperty(key, (String) headers.get(key));
				}
			}
            logger.info("http 请求 url = "+strURL);
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setConnectTimeout(30000);
			con.setReadTimeout(30000);

			out = new BufferedOutputStream(con.getOutputStream());
			byte[] outBuf = req.getBytes(encode);
			out.write(outBuf);
			out.flush();
			if (response) {
				in = new BufferedInputStream(con.getInputStream());
				result = readByteStream(in, encode);
			} else {
				con.getInputStream();
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}

		logger.info("HttpPoster:[total time=" + watch.getTime() + ", url="
				+ strURL + ", contentType=" + contentType + ",ecode=" + encode
				+ ",response=" + result + "]");

		return result;
	}

/**
 * http post请求
 * @param strURL
 * @param path
 * @param contentType
 * @param encode
 * @param response
 * @param headers
 * @return
 */
	@SuppressWarnings("unchecked")
	private static String postPath(String strURL, String path,
			String contentType, String encode, boolean response,
			Map<String, String> headers) {
		StopWatch watch = new StopWatch();
		watch.start();

		String result = null;
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		FileInputStream is = null;
		try {
			URL url = new URL(strURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", contentType);
			con.setRequestProperty("Comp-Control", "dsmp/sms-mt");
			if ((headers != null) && (headers.size() > 0)) {
				Set keys = headers.keySet();
				Iterator ir = keys.iterator();

				while (ir.hasNext()) {
					String key = (String) ir.next();
					con.setRequestProperty(key, (String) headers.get(key));
				}
			}
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setConnectTimeout(30000);
			con.setReadTimeout(30000);

			out = new BufferedOutputStream(con.getOutputStream());

			File file = new File(path);
			is = new FileInputStream(file.getPath());

			byte[] inc = new byte[1024];
			int insize = 0;
			while ((insize = is.read(inc)) != -1)
				out.write(inc, 0, insize);

			out.flush();
			
			if (response) {
				in = new BufferedInputStream(con.getInputStream());
				result = readByteStream(in, encode);
			} else {
				con.getInputStream();
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}

		logger.info("HttpPoster:[total time=" + watch.getTime() + ", url="
				+ strURL + ", contentType=" + contentType + ",ecode=" + encode
				+ ",response=" + result + "]");

		return result;
	}

	
	/**
	 * 读取字节流转换成字符�?	 * @param in
	 * @param encode编码
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private static String readByteStream(BufferedInputStream in, String encode)
			throws IOException {
		LinkedList bufList = new LinkedList();
		int size = 0;
		while (true) {
			byte[] buf = new byte[128];
			int num = in.read(buf);
			if (num == -1)
				break;
			size += num;
			bufList.add(new mybuf(buf, num));
		}
		byte[] buf = new byte[size];
		int pos = 0;
		for (ListIterator p = bufList.listIterator(); p.hasNext();) {
			mybuf b = (mybuf) p.next();
			int i = 0;
			while (i < b.size) {
				buf[pos] = b.buf[i];
				++i;
				++pos;
			}
		}
		return new String(buf, encode);
	}

	private static class mybuf {
		public byte[] buf;
		public int size;

		public mybuf(byte[] b, int s) {
			this.buf = b;
			this.size = s;
		}
	}
}
