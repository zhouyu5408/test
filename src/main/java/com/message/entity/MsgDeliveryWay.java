package com.message.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * ���ķ�ʽ��
 * 
 * @Date: 2017��12��28�� ����5:14:30 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
@JsonInclude(Include.NON_NULL)
public class MsgDeliveryWay extends MsgBaseEntity implements Serializable {
	/**
	 * ����
	 */
	private String id;
	/**
	 * ���ķ�ʽ���
	 */
	private String deliveryWay;
	/**
	 * �����ķ�ʽ��ʵ����
	 */
	private String msgObject;

	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getDeliveryWay() {
		return deliveryWay;
	}

	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay == null ? null : deliveryWay.trim();
	}

	public String getMsgObject() {
		return msgObject;
	}

	public void setMsgObject(String msgObject) {
		this.msgObject = msgObject == null ? null : msgObject.trim();
	}
}