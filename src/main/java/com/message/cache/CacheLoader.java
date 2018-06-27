package com.message.cache;

import java.util.concurrent.ConcurrentMap;

/**
 * ����ת���� . <br/>
 * ����: 2017��11��24�� ����3:52:27 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (��������������ϵͳ���޹�˾) , All Rights Reserved.
 * @since JDK 1.7
 */
public abstract class CacheLoader<K, V> {
	/**
	 * 
	 * װ������. <br/>
	 *
	 * @return
	 */
	public abstract ConcurrentMap<K, V> load();

}
