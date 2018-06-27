package com.message.enums;

public enum MsgTypeEnum implements BaseEnum {
	NORMAL("0", "һ����Ϣ"), 
	ANNOUNCEMENT("1", "����");

	private MsgTypeEnum(String code, String desc) {
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
		for (MsgTypeEnum jobType : MsgTypeEnum.values()) {
			if (jobType.desc.equals(desc)) {
				return jobType.code;
			}
		}
		return "";
	}

	public static String getDescByCode(String code) {
		for (MsgTypeEnum jobType : MsgTypeEnum.values()) {
			if (jobType.code.equals(code)) {
				return jobType.desc;
			}
		}
		return "";
	}
	
	/**
	 * ö��ת��
	 */
	public static MsgTypeEnum parseOf(String value) {
		for (MsgTypeEnum item : values())
			if (item.getCode().equals(value))
				return item;
		throw new IllegalArgumentException("ö��ֵ[" + value + "]��ƥ��!");
	}
}
