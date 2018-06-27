package com.message.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * ��ɫ�м��࣬���ڻ�ȡָ����ɫ��Ϣ
 * 
 * @Date: 2017��12��28�� ����5:23:52 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
@JsonInclude(Include.NON_NULL)
public class Role {
	/**
	 * ��ɫ���
	 */
	private String roleId;
	/**
	 * ��ɫ��
	 */
	private String roleName;
	private String id;// ����ǰ��ȡ����֮��
	private String text;// ����ǰ��ȡ����֮��

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
		this.id = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
		this.text = roleName;
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

}
