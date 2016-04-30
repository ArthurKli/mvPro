package com.admin.cache;

import com.admin.tools.SpringContextHolder;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;


/**
 * Cache������
 * @author Kai
 * @version 2013-5-29
 */
public class CacheUtils {
	
	private static SpringCacheManagerWrapper  cacheManager = (SpringCacheManagerWrapper) SpringContextHolder.getBean("shiroCacheManager");

	private static final String SYS_CACHE = "sysCache";

	/**
	 * ��ȡSYS_CACHE����
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(SYS_CACHE, key);
	}
	
	/**
	 * д��SYS_CACHE����
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(SYS_CACHE, key, value);
	}
	
	/**
	 * ��SYS_CACHE�������Ƴ�
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(SYS_CACHE, key);
	}
	
	/**
	 * ��ȡ����
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object get(String cacheName, String key) {
		return getCache(cacheName).get(key);
	}

	/**
	 * д�뻺��
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, String key, Object value) {
		getCache(cacheName).put(key, value);
	}

	/**
	 * �ӻ������Ƴ�
	 * @param cacheName
	 * @param key
	 */
	public static void remove(String cacheName, String key) {
		getCache(cacheName).remove(key);
	}
	
	/**
	 * @param cacheName
	 * @return
	 */
	private static Cache getCache(String cacheName){
		return cacheManager.getCache(cacheName);
	}

	public static CacheManager getCacheManager() {
		return cacheManager;
	}
	
}
