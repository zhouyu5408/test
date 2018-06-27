package com.message.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * �����м��ֻ࣬���ڻ�ȡָ������Ϣ
 * 
 * @Date: 2017��12��28�� ����5:22:52 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
@JsonInclude(Include.NON_NULL)
public class Organization {
	/**
	 * �������
	 */
	private String orgId;
	/**
	 * ��������
	 */
	private String orgName;
	private String id;// ����ǰ��ȡ����֮��
	private String text;// ����ǰ��ȡ����֮��
	private List<Organization> children;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
		this.id = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
		this.text = orgName;
	}

	public List<Organization> getChildren() {
		if (null == children) {
			return new ArrayList<Organization>();
		}
		return children;
	}

	public void setChildren(List<Organization> children) {
		this.children = children;
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
