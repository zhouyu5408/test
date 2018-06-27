package com.message.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * ���������
 * 
 * @Date: 2017��12��28�� ����5:18:30 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
public class MsgTitle extends MsgBaseEntity implements Serializable {
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
	 * ��������
	 */
	@NotBlank(message = "�������Ʋ���Ϊ��")
	private String titleName;
	/**
	 * ���ͱ��
	 */
	private String titleType;
	/**
	 * ��������
	 */
	private String typeName;
	/**
	 * ��������
	 */
	private String titleContent;
	/**
	 * ������ʼ�ģ��
	 */
	@NotBlank(message = "�ʼ�ģ�治��Ϊ��")
	private String emailModel;
	/**
	 * ����Ķ���ģ��
	 */
	@NotBlank(message = "����ģ�治��Ϊ��")
	private String phoneModel;
	/**
	 * ����ĵ���ģ��
	 */
	@NotBlank(message = "����ģ�治��Ϊ��")
	private String popupModel;
	/**
	 * �����ĸ���
	 */
	private String[] addKeys;
	/**
	 * ɾ���ĸ���
	 */
	private String[] delKeys;
	/**
	 * �����Ѿ�ӵ�еĸ���
	 */
	private List<String> allKeys;

	private String[] deliveryWays;

	private List<SubscribeInfo> users;
	private List<Organization> orgs;
	private List<Role> roles;
	private String[] userIds;
	private String[] orgIds;
	private String[] roleIds;

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

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName == null ? null : titleName.trim();
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTitleContent() {
		return titleContent;
	}

	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent == null ? null : titleContent.trim();
	}

	public String getEmailModel() {
		if (null == emailModel || "".equals(emailModel.trim())) {
			return this.titleContent;
		}
		return emailModel;
	}

	public void setEmailModel(String emailModel) {
		this.emailModel = emailModel;
	}

	public String getPhoneModel() {
		if (null == phoneModel || "".equals(phoneModel.trim())) {
			return this.titleContent;
		}
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	public String getPopupModel() {
		if (null == popupModel || "".equals(popupModel.trim())) {
			return this.titleContent;
		}
		return popupModel;
	}

	public void setPopupModel(String popupModel) {
		this.popupModel = popupModel;
	}

	public String[] getAddKeys() {
		return addKeys;
	}

	public void setAddKeys(String[] addKeys) {
		this.addKeys = addKeys;
	}

	public String[] getDelKeys() {
		return delKeys;
	}

	public void setDelKeys(String[] delKeys) {
		this.delKeys = delKeys;
	}

	public List<String> getAllKeys() {
		return allKeys;
	}

	public void setAllKeys(List<String> allKeys) {
		this.allKeys = allKeys;
	}

	public String[] getDeliveryWays() {
		return deliveryWays;
	}

	public void setDeliveryWays(String[] deliveryWays) {
		this.deliveryWays = deliveryWays;
	}

	public List<SubscribeInfo> getUsers() {
		return users;
	}

	public void setUsers(List<SubscribeInfo> users) {
		this.users = users;
	}

	public List<Organization> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<Organization> orgs) {
		this.orgs = orgs;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String[] getUserIds() {
		return userIds;
	}

	public void setUserIds(String[] userIds) {
		this.userIds = userIds;
	}

	public String[] getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(String[] orgIds) {
		this.orgIds = orgIds;
	}

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

}