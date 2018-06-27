package com.message.cache;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.message.enums.BaseEnum;
import com.message.exception.BaseException;
import com.message.util.Maps;

/**
 * ��������� . <br/>
 * ����: 2017��11��24�� ����3:49:00 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (��������������ϵͳ���޹�˾) , All Rights Reserved.
 * @param <V>
 * @param <K>
 * @since JDK 1.7
 */
public class MessageCache<K, V> {
	private ConcurrentMap<K, V> data = Maps.newConcurrentMap();
	private BaseEnum name;
	/**
	 * Ĭ��ˢ�¼����1��Сʱ ��λ�Ǻ���
	 */
	public static final long REFRESHGAP = 60 * 60 * 1000L;
	/**
	 * Ĭ�ϲ��Զ�ˢ��
	 */
	private boolean isAutoRefresh = false;

	/**
	 * �Ƿ�����ʱ�������
	 */
	private boolean isRuntimeFill = false;

	private long refreshTime = REFRESHGAP;

	private CacheLoader<K, V> loader;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	// private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	private long lastUpdateTime = 0L;// ��ǰ����ˢ��ʱ��

	/**
	 * 
	 * Creates a new instance of MessageCache.
	 * 
	 */
	public MessageCache(BaseEnum name) {
		this.name = name;
	}

	/**
	 * . lastUpdateTime.
	 * 
	 * @return the lastUpdateTime
	 * @since JDK 1.6
	 */
	public long getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * 
	 * (������һ�仰�����������������). <br/>
	 * 
	 * @return
	 */
	public boolean isNeedResfresh() {

		return isAutoRefresh && lastUpdateTime != 0L && refreshTime <= (System.currentTimeMillis() - lastUpdateTime);

	}

	/**
	 * 
	 */
	private Thread refreshRunner = null;

	/**
	 * 
	 * (������һ�仰�����������������). <br/>
	 * 
	 * @return
	 */
	public MessageCache<K, V> build() {
		this.refresh();

		if (this.isAutoRefresh) {
			if (refreshRunner == null) {
				refreshRunner = new Thread(new CacheRefreshThread<K, V>(this));
				refreshRunner.start();
			}
		}
		return this;
	}

	/**
	 * . name.
	 * 
	 * @return the name
	 * @since JDK 1.6
	 */
	public BaseEnum getName() {
		return name;
	}

	/**
	 * . name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(BaseEnum name) {
		this.name = name;
	}

	/**
	 * . isAutoRefresh.
	 * 
	 * @return the isAutoRefresh
	 */
	public boolean isAutoRefresh() {
		return isAutoRefresh;
	}

	/**
	 * . isAutoRefresh.
	 * 
	 * @param isAutoRefresh
	 *            the isAutoRefresh to set
	 */
	public MessageCache<K, V> autoRefresh() {
		this.isAutoRefresh = true;
		return this;
	}

	public MessageCache<K, V> runtimeFill() {
		this.isRuntimeFill = true;
		return this;
	}

	/**
	 * . isAutoRefresh.
	 * 
	 * @param refresh
	 *            �Զ�ˢ��ʱ���� - ��λ ����
	 */
	public MessageCache<K, V> autoRefresh(long refresh) {
		this.isAutoRefresh = true;
		this.refreshTime = refresh;
		return this;
	}

	/**
	 * . isAutoRefresh.
	 * 
	 * @param isAutoRefresh
	 *            the isAutoRefresh to set
	 * @since JDK 1.6
	 */
	public MessageCache<K, V> noAutoRefresh() {
		this.isAutoRefresh = false;
		return this;
	}

	/**
	 * . refreshTime.
	 * 
	 * @return the refreshTime
	 */
	public long getRefreshTime() {
		return refreshTime;
	}

	/**
	 * . refreshTime.
	 * 
	 * @param refreshTime
	 *            the refreshTime to set
	 */
	public MessageCache<K, V> setRefreshTime(long refresh) {
		this.refreshTime = refresh;
		return this;
	}

	/**
	 * . loader.
	 * 
	 * @return the loader
	 */
	public CacheLoader<K, V> getLoader() {
		return loader;
	}

	/**
	 * . loader.
	 * 
	 * @param loader
	 *            the loader to set
	 */
	public MessageCache<K, V> setLoader(CacheLoader<K, V> cacheLoader) {
		this.loader = cacheLoader;
		return this;
	}

	/**
	 * . data.
	 * 
	 * @return the data
	 */
	public Map<K, V> getData() {
		return Collections.unmodifiableMap(data);
	}

	/**
	 * . data.
	 * 
	 * @param data
	 *            the data to set
	 * @since JDK 1.6
	 */
	private void setData(ConcurrentMap<K, V> data) {
		writeLock.lock();
		try {
			this.data = data;
			this.lastUpdateTime = System.currentTimeMillis();

		} finally {
			writeLock.unlock();
		}

	}

	/**
	 * 
	 * ˢ�»���. <br/>
	 * 
	 * @author zkh
	 */
	public void refresh() {
		ConcurrentMap<K, V> newData = Maps.newConcurrentMap();
		if (!this.isRuntimeFill) {// ����ʱ��䲻�ó�ʼ��
			newData = getLoader().load();
		}
		this.setData(newData);

	}

	/**
	 * 
	 * ��ȡ����. <br/>
	 * 
	 * @author zkh
	 * @param key
	 * @return
	 */
	public V get(K key) {
		return this.data.get(key);
	}

	/**
	 * ����ʱ���cache
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		if (isRuntimeFill) {
			this.data.put(key, value);
		} else {
			throw new BaseException("����ʱ���cache��֧�ִ˷���������");
		}
	}

}
