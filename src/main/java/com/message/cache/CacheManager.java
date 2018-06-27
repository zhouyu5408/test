package com.message.cache;

import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;

import com.message.enums.BaseEnum;
import com.message.util.Maps;

/**
 * message���湤�� . <br/>
 * ����: 2017��11��24�� ����3:44:46 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (��������������ϵͳ���޹�˾) , All Rights Reserved.
 * @since JDK 1.7
 */
public final class CacheManager {
	private static Logger logger = Logger.getLogger(CacheManager.class);
	/**
	 * ϵͳ���л���.<BR>
	 */
	@SuppressWarnings("rawtypes")
	public static ConcurrentMap<String, MessageCache> caches = Maps.newConcurrentMap();

	/**
	 * 
	 * (������һ�仰�����������������). <br/>
	 *
	 * @author zkh
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> MessageCache<K, V> getCache(BaseEnum cacheName) {
		MessageCache<K, V> cache = null;
		if (caches.containsKey(CacheManager.getKeyByEnum(cacheName))) {
			cache = CacheManager.caches.get(CacheManager.getKeyByEnum(cacheName));
		}
		return cache;

	}

	/**
	 * 
	 * ����cache������CacheManager. <br/>
	 *
	 * @author zkh
	 * @return
	 */
	public static <K, V> MessageCache<K, V> createCache(BaseEnum name) {
		MessageCache<K, V> cache = new MessageCache<K, V>(name);
		if (caches.containsKey(CacheManager.getKeyByEnum(name))) {
			// throw new BaseException("���ܴ����ظ��Ļ��棡����");
			logger.warn("�ظ���������" + CacheManager.getKeyByEnum(name));
		}
		CacheManager.caches.put(CacheManager.getKeyByEnum(name), cache);
		return cache;
	}

	/**
	 * 
	 * ��ȡkey . <br/>
	 *
	 * @author kevin
	 * @param name
	 * @return
	 */
	public static String getKeyByEnum(BaseEnum name) {
		return name.getClass().getName() + "." + name.getCode();
	}

}
