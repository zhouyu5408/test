package com.message.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * ģ�渽��������
 * 
 * @Date: 2017��12��28�� ����5:21:35 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
@JsonInclude(Include.NON_NULL)
public class MsgTitleModelAttach extends MsgBaseEntity implements Serializable {
	/**
	 * ����
	 */
    private String id;
    /**
	 * ������
	 */
    private String attachName;
    /**
	 * ����λ��
	 */
    private String attachAddress;
    /**
	 * ������
	 */
    private String attachGroupId;
    /**
	 * �����Ƿ���Ч
	 */
    private String flag;
    /**
     * ������Ӧ��key 
     */
    private String fileKey;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName == null ? null : attachName.trim();
    }

    public String getAttachAddress() {
        return attachAddress;
    }

    public void setAttachAddress(String attachAddress) {
        this.attachAddress = attachAddress == null ? null : attachAddress.trim();
    }

	public String getAttachGroupId() {
		return attachGroupId;
	}

	public void setAttachGroupId(String attachGroupId) {
		this.attachGroupId = attachGroupId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}
}