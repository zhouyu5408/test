package com.message.enums;

/**
 * ��������ö��
 * 
 * @Date: 2018��1��3�� ����2:43:29 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
public enum YesNoEnum implements BaseEnum {
	YES("yes", "��"), NO("no", "��");

	private YesNoEnum(String code, String desc) {
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
		for (YesNoEnum jobType : YesNoEnum.values()) {
			if (jobType.desc.equals(desc)) {
				return jobType.code;
			}
		}
		return "";
	}

	public static String getDescByCode(String code) {
		for (YesNoEnum jobType : YesNoEnum.values()) {
			if (jobType.code.equals(code)) {
				return jobType.desc;
			}
		}
		return "";
	}

	/**
	 * ö��ת��
	 */
	public static YesNoEnum parseOf(String value) {
		for (YesNoEnum item : values())
			if (item.getCode().equals(value))
				return item;
		throw new IllegalArgumentException("ö��ֵ[" + value + "]��ƥ��!");
	}

	public static YesNoEnum getCode(String desc) {
		for (YesNoEnum item : values())
			if (item.getDesc().equals(desc))
				return item;
		throw new IllegalArgumentException("����[" + desc + "]��ƥ��!");
	}
}
