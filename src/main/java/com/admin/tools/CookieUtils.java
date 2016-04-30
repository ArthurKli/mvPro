/**

 */
package com.admin.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie������
 * @author ThinkGem
 * @version 2013-01-15
 */
public class CookieUtils {

	/**
	 * ���� Cookie�����ʱ��Ϊ1�죩
	 * @param name ���
	 * @param value ֵ
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 60*60*24);
	}
	
	/**
	 * ���� Cookie
	 * @param name ���
	 * @param value ֵ
	 * @param maxAge ���ʱ�䣨��λ�룩
	 * @param uri ·��
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path) {
		setCookie(response, name, value, path, 60*60*24);
	}
	
	/**
	 * ���� Cookie
	 * @param name ���
	 * @param value ֵ
	 * @param maxAge ���ʱ�䣨��λ�룩
	 * @param uri ·��
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		setCookie(response, name, value, "/", maxAge);
	}
	
	/**
	 * ���� Cookie
	 * @param name ���
	 * @param value ֵ
	 * @param maxAge ���ʱ�䣨��λ�룩
	 * @param uri ·��
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path, int maxAge) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		try {
			cookie.setValue(URLEncoder.encode(value, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.addCookie(cookie);
	}
	
	/**
	 * ���ָ��Cookie��ֵ
	 * @param name ���
	 * @return ֵ
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		return getCookie(request, null, name, false);
	}
	/**
	 * ���ָ��Cookie��ֵ����ɾ��
	 * @param name ���
	 * @return ֵ
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		return getCookie(request, response, name, true);
	}
	/**
	 * ���ָ��Cookie��ֵ
	 * @param request �������
	 * @param response ��Ӧ����
	 * @param name ����
	 * @param isRemove �Ƿ��Ƴ�
	 * @return ֵ
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove) {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					try {
						value = URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (isRemove) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return value;
	}
}