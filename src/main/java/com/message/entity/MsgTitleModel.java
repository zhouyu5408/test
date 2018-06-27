package com.message.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * ����ģ���
 * 
 * @Date: 2017��12��28�� ����5:18:59 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
@JsonInclude(Include.NON_NULL)
public class MsgTitleModel extends MsgBaseEntity implements Serializable {
	/**
	 * ����
	 */
	private String id;
	/**
	 * ������
	 */
	@NotBlank(message = "�����Ų���Ϊ��")
	private String titleId;
	/**
	 * ���ķ�ʽ
	 */
	@NotBlank(message = "���ķ�ʽ����Ϊ��")
	private String deliveryWay;
	/**
	 * ����ģ��
	 */
	private String titleModel;
	/**
	 * ��������
	 */
	private String attachGroupId;

	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId == null ? null : titleId.trim();
	}

	public String getDeliveryWay() {
		return deliveryWay;
	}

	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay == null ? null : deliveryWay.trim();
	}

	public String getTitleModel() {
		return titleModel;
	}

	public void setTitleModel(String titleModel) {
		this.titleModel = titleModel == null ? null : titleModel.trim();
	}

	public String getAttachGroupId() {
		return attachGroupId;
	}

	public void setAttachGroupId(String attachGroupId) {
		this.attachGroupId = attachGroupId == null ? null : attachGroupId.trim();
	}
}