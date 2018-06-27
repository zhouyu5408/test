package com.message.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.message.annotation.EnumCodeToDic;
import com.message.enums.DeliveryWayEnum;
import com.message.enums.SubTypeEnum;

/**
 * ���Ĺ�ϵ��
 * 
 * @Date: 2017��12��28�� ����5:18:00 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
@JsonInclude(Include.NON_NULL)
public class MsgSubscribe extends MsgBaseEntity implements Serializable {
	/**
	 * ����
	 */
	private String id;
	/**
	 * �û����
	 */
	private String userId;
	/**
	 * �û�����
	 */
	private String userName;
	/**
	 * ������
	 */
	private String titleId;
	/**
	 * ��������
	 */
	private String titleName;
	/**
	 * ���ķ�ʽ
	 */
	@EnumCodeToDic(DeliveryWayEnum.class)
	private String deliveryWay;
	/**
	 * ���Ĺ�ϵ�Ƿ���Ч
	 */
	private String flag;
	/**
	 * ��������
	 */
	private String groupId;
	/**
	 * ����������
	 */
	private String groupName;
	/**
	 * ���������ͣ�ȫ��/��/��ɫ/����/�û���
	 */
	@EnumCodeToDic(SubTypeEnum.class)
	private String subType;

	private String[] deliveryWays;
	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId == null ? null : titleId.trim();
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName == null ? null : titleName.trim();
	}

	public String getDeliveryWay() {
		return deliveryWay;
	}

	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay == null ? null : deliveryWay.trim();
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId == null ? null : groupId.trim();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType == null ? null : subType.trim();
	}

	public String[] getDeliveryWays() {
		return deliveryWays;
	}

	public void setDeliveryWays(String[] deliveryWays) {
		this.deliveryWays = deliveryWays;
	}
}