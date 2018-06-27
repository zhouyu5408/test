package com.message.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * �������Ա��
 * 
 * @Date: 2017��12��28�� ����5:16:56 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
@JsonInclude(Include.NON_NULL)
public class MsgSubGroupMember extends MsgBaseEntity implements Serializable {
	/**
	 * ����
	 */
	private String id;
	/**
	 * ��Ա���
	 */
	private String memberId;
	/**
	 * ��Ա����
	 */
	private String memberName;
	/**
	 * ��������
	 */
	private String subGroupId;
	/**
	 * ��Ա���ͣ���ɫ/����/�û�/...��
	 */
	private String memberType;

	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId == null ? null : memberId.trim();
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSubGroupId() {
		return subGroupId;
	}

	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId == null ? null : subGroupId.trim();
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType == null ? null : memberType.trim();
	}
}