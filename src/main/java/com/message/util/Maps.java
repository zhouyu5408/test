package com.message.util;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * ����: 2017��11��24�� ����3:47:03 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (��������������ϵͳ���޹�˾) , All Rights Reserved.
 * @since JDK 1.7
 */
public class Maps {

	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
		return new ConcurrentHashMap<K, V>();
	}

}