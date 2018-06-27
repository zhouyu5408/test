package com.message.enums;

/**
 * ��������ö���� . <br/>
 * 
 * @Date: 2017��11��27�� ����9:26:57 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
public enum LanguageTypeEnum implements BaseEnum {
	zh_CN("zh-CN", "����(����)"), en("en", "English");

	private LanguageTypeEnum(String code, String desc) {
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
		for (LanguageTypeEnum jobType : LanguageTypeEnum.values()) {
			if (jobType.desc.equals(desc)) {
				return jobType.code;
			}
		}
		return "";
	}

	public static String getDescByCode(String code) {
		for (LanguageTypeEnum jobType : LanguageTypeEnum.values()) {
			if (jobType.code.equals(code)) {
				return jobType.desc;
			}
		}
		return "";
	}

	/**
	 * ö��ת��
	 */
	public static LanguageTypeEnum parseOf(String value) {
		for (LanguageTypeEnum item : values())
			if (item.getCode().equals(value))
				return item;
		throw new IllegalArgumentException("ö��ֵ[" + value + "]��ƥ��!");
	}
}