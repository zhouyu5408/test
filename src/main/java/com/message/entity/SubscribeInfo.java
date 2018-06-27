package com.message.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * �������м��࣬���ڷ�װ��������Ҫ����Ϣ
 * 
 * @Date: 2017��12��28�� ����5:25:10 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
@JsonInclude(Include.NON_NULL)
public class SubscribeInfo {
	/**
	 * �û����
	 */
	private String userId;
	/**
	 * �û�����
	 */
	private String userName;
	/**
	 * ��¼��
	 */
	private String loginName;
	/**
	 * ����
	 */
	private String email;
	/**
	 * �绰����
	 */
	private String phoneNum;
	/**
	 * ���ķ�ʽ���ʼ�/����/������
	 */
	private String deliveryWay;
	/**
	 * ���ĵĴ�����
	 */
	private String msgObject;

	private String id;// ����ǰ��ȡ����֮��
	private String text;// ����ǰ��ȡ����֮��

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
		this.id = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		this.text = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDeliveryWay() {
		return deliveryWay;
	}

	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}

	public String getMsgObject() {
		return msgObject;
	}

	public void setMsgObject(String msgObject) {
		this.msgObject = msgObject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscribeInfo other = (SubscribeInfo) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
