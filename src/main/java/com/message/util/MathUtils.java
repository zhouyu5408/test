package com.message.util;

public class MathUtils {
	/**
	 * ��������
	 * 
	 * @param value
	 *            �����ַ���
	 **/
	public static int parseInt(String value) {
		return Integer.parseInt(value);
	}

	public static void main(String[] value) {
		MathUtils.parseInt("97w");
	}

	/**
	 * ����˫����
	 * 
	 * @param value
	 *            �����ַ���
	 * @param dot
	 *            ����С����λ�� ȡֵ��Χ10,100,1000,10000 �ֱ��ʾ ����1,2,3,4λС��
	 **/
	public static double parseDouble(String value, int dot) {
		double dvalue = Double.parseDouble(value);
		dvalue = Math.round(dvalue * dot) / (double) dot;
		return dvalue;
	}

	/**
	 * ����˫����(������λС��)
	 * 
	 * @param value
	 *            �����ַ���
	 **/
	public static double parseDouble(String value) {
		return parseDouble(value, 100);
	}

	/**
	 * ����������
	 * 
	 * @param value
	 *            �����ַ���
	 * @param dot
	 *            ����С����λ�� ȡֵ��Χ10,100,1000,10000 �ֱ��ʾ ����1,2,3,4λС��
	 **/
	public static float parseFloat(String value, int dot) {
		float fvalue = Float.parseFloat(value);
		fvalue = Math.round(fvalue * dot) / (float) dot;
		return fvalue;
	}

	/**
	 * ����������(������λС��)
	 * 
	 * @param value
	 *            �����ַ���
	 **/
	public static float parseFloat(String value) {
		return parseFloat(value, 100);
	}

	/**
	 * �������
	 * 
	 * @param augend
	 *            ������
	 * @param addend
	 *            ����
	 **/
	public static String sum(String augend, String addend) {
		String str_augend = "";
		String str_addend = "";
		if (augend.length() >= 2)
			str_augend = augend.substring(0, 2);
		if (addend.length() >= 2)
			str_addend = addend.substring(0, 2);
		if ("--".equals(str_augend))
			augend = augend.substring(2);
		if ("--".equals(str_addend))
			addend = addend.substring(2);
		double d_augend = parseDouble(augend);
		double d_addend = parseDouble(addend);
		double sum = d_augend + d_addend;
		return parseDouble(Double.toString(sum)) + "";
	}

	/**
	 * �������
	 * 
	 * @param faciend
	 *            ������
	 * @param multiplier
	 *            ����
	 * @param dot
	 *            ����С����λ�� ȡֵ��Χ10,100,1000,10000 �ֱ��ʾ ����1,2,3,4λС��
	 **/
	public static String mul(String faciend, String multiplier, int dot) {
		double d_faciend = Double.parseDouble(faciend);
		double d_multiplier = Double.parseDouble(multiplier);
		double d_amass = d_faciend * d_multiplier;
		d_amass = Math.round(d_amass * dot) / (double) dot;
		return d_amass + "";
	}

	/**
	 * �������(������λС��)
	 * 
	 * @param faciend
	 *            ������
	 * @param multiplier
	 *            ����
	 **/
	public static String mul(String faciend, String multiplier) {
		return mul(faciend, multiplier, 100);
	}

	/**
	 * �������
	 * 
	 * @param dividend
	 *            ������
	 * @param divisor
	 *            ���� quotient ����
	 * @param dot
	 *            ����С����λ�� ȡֵ��Χ10,100,1000,10000 �ֱ��ʾ ����1,2,3,4λС��
	 **/
	public static String rate(String dividend, String divisor, int dot) {
		double d_dividend = Double.parseDouble(dividend);
		double d_divisor = Double.parseDouble(divisor);
		double d_quotient = d_dividend / d_divisor;
		d_quotient = Math.round(d_quotient * dot) / (double) dot;
		return d_quotient + "";
	}

	/**
	 * �������(������λС��)
	 * 
	 * @param dividend
	 *            ������
	 * @param divisor
	 *            ����
	 **/
	public static String rate(String dividend, String divisor) {
		return rate(dividend, divisor, 100);
	}

	/**
	 * �����İٷ�������
	 * 
	 * @param a
	 *            ���� �ַ���
	 * @param b
	 *            ��ĸ �ַ���
	 **/

	public static String percent(String a, String b) {
		double d_a = 0;
		double d_b = 0;
		double d_rate = 0;
		String rate = "";

		try {
			if (b == null || b == "0" || b.trim().length() <= 0)
				return "-";
		} catch (Exception e) {

		}

		try {
			d_a = Double.parseDouble(a);
		} catch (Exception e) {
			d_a = 0;
		}
		try {
			d_b = Double.parseDouble(b);
		} catch (Exception e) {
			d_b = 0;
		}
		try {
			d_rate = (d_a / d_b);
			rate = (Math.round(d_rate * 10000)) / 100 + "%";
		} catch (Exception e) {
			rate = "0%";
		}
		if (rate.equals("0%"))
			rate = "-";
		return rate;
	}
}
