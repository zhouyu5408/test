package com.message.enums;

/**
 * ����������ö��
 * 
 * @Date: 2017��12��29�� ����9:13:31 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
public enum SubTypeEnum implements BaseEnum {
	ALL("all","ȫ���û�"),
	GROUP("group","��"),
	ROLE("role","��ɫ"),
	ORG("org","����"),
	USER("user","�û�");

	private SubTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private String code;
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static String getCodeByDesc(String desc) {
		for (SubTypeEnum jobType : SubTypeEnum.values()) {
			if (jobType.desc.equals(desc)) {
				return jobType.code;
			}
		}
		return "";
	}

	public static String getDescByCode(String code) {
		for (SubTypeEnum jobType : SubTypeEnum.values()) {
			if (jobType.code.equals(code)) {
				return jobType.desc;
			}
		}
		return "";
	}

	/**
	 * ö��ת��
	 */
	public static SubTypeEnum parseOf(String value) {
		for (SubTypeEnum item : values())
			if (item.getCode().equals(value))
				return item;
		throw new IllegalArgumentException("ö��ֵ[" + value + "]��ƥ��!");
	}
}