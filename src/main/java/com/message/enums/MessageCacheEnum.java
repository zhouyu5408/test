package com.message.enums;

/**
 * ��Ϣģ�黺��ö���� . <br/>
 * ����: 2017��11��24�� ����3:42:12 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (��������������ϵͳ���޹�˾) , All Rights Reserved.
 * @since JDK 1.7
 */
public enum MessageCacheEnum implements BaseEnum {
	SystemParam("SystemParam", "ϵͳ����"), RespCode("RespCode", "ϵͳ��Ӧ��");

	private MessageCacheEnum(String code, String desc) {
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
		for (MessageCacheEnum jobType : MessageCacheEnum.values()) {
			if (jobType.desc.equals(desc)) {
				return jobType.code;
			}
		}
		return "";
	}

	public static String getDescByCode(String code) {
		for (MessageCacheEnum jobType : MessageCacheEnum.values()) {
			if (jobType.code.equals(code)) {
				return jobType.desc;
			}
		}
		return "";
	}

	/**
	 * ö��ת��
	 */
	public static MessageCacheEnum parseOf(String value) {
		for (MessageCacheEnum item : values())
			if (item.getCode().equals(value))
				return item;
		throw new IllegalArgumentException("ö��ֵ[" + value + "]��ƥ��!");
	}
}
