package com.message.enums;

/**
 * ö��������Ҫʵ�ֵĽӿ� . <br/>
 * ����: 2017��11��24�� ����3:41:24 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (��������������ϵͳ���޹�˾) , All Rights Reserved.
 * @since JDK 1.7
 */
public interface BaseEnum {
	/**
	 * 
	 * ��ȡö�ٴ���. <br/>
	 *
	 * @return
	 */
	public abstract String getCode();

	/**
	 * 
	 * ����ö�ٴ���. <br/>
	 *
	 * @param s
	 */
	public abstract void setCode(String s);

	/**
	 * 
	 * ��ȡö������. <br/>
	 *
	 * @return
	 */
	public abstract String getDesc();

	/**
	 * 
	 * ����ö������. <br/>
	 *
	 * @param s
	 */
	public abstract void setDesc(String s);

}
