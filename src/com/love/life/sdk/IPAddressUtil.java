
package com.love.life.sdk;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
/**
 * IP工具类
 * @author wugy08
 *
 */
public class IPAddressUtil {
	
	private static final String HEADER_X_FORWARDED_FOR = "X-FORWARDED-FOR";
	
	/**
	 * 获取本机IP地址
	 * @return
	 */
	public static String getLocalIPAddress() {
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		/*try {
			Enumeration<?> e1 = (Enumeration<?>) NetworkInterface.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				if (!ni.getName().equals("eth0")) {
					continue;
				} else {
					Enumeration<?> e2 = ni.getInetAddresses();
					while (e2.hasMoreElements()) {
						InetAddress ia = (InetAddress) e2.nextElement();
						if (ia instanceof Inet6Address) {
							continue;
						}
						ip = ia.getHostAddress();
					}
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}*/
		return ip;
	}
	/**
	 * 获取客户端源地址
	 * @param request
	 * @return
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String x;
		if ((x = request.getHeader(HEADER_X_FORWARDED_FOR)) != null) {
			remoteAddr = x;
			int idx = remoteAddr.indexOf(',');
			if (idx > -1) {
				remoteAddr = remoteAddr.substring(0, idx);
			} 
		}
		return remoteAddr; 
	}
	/**
	 * 获取客服端路由全路径
	 * @param request
	 * @return
	 */
	public static String getX_Forwarded_For(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String x;
		if ((x = request.getHeader(HEADER_X_FORWARDED_FOR)) != null) {
			remoteAddr = x;
		} else if((x = request.getHeader("x-forwarded-for")) != null) {
			remoteAddr = x;
		} else if((x = request.getHeader("Proxy-Client-IP")) != null) {
			remoteAddr = x;
		} else if((x = request.getHeader("WL-Proxy-Client-IP")) != null) {
			remoteAddr = x;
		}
		return remoteAddr; 
	}
	
	public static String getIpAddr(HttpServletRequest request) {
       String ip = request.getHeader("x-forwarded-for");
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("HEADER_X_FORWARDED_FOR");
       }
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("Proxy-Client-IP");
       }
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("WL-Proxy-Client-IP");
       }
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getRemoteAddr();
       }
       return ip;
   }
	
	public  static void main(String[] args){
		String ip ="";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(ip);
		System.out.println("ip___----"+ip);
	}
}