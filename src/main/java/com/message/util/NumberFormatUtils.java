package com.message.util;

import java.text.*;
import java.util.*;
import java.math.*;

/**
 * �������ڵ�ͨ�ù���
 * 
 * @Date: 2017��11��27�� ����9:57:57 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
public class NumberFormatUtils {
	/**
	 * �����������ְ���������ʽ���
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String #:��ʾ��������������֣�û����գ�������λ�����ڣ���λ�����򳬳����� 0:��������������֣�û�в�0
	 *            ����С�����м���#��0���ͱ�����λ��С���� ���磺 "###.00"
	 *            -->��ʾ�������ֵ������λС����������λ�Ĳ�0��������λ���������� "###.0#"
	 *            -->��ʾ�������ֵ���Ա���һλ����λС����������ʾΪ��һλС����һλ����λС���İ�ԭ����ʾ��������λ���������룻
	 *            "###" --->��ʾΪ������С�������������� ".###" -->12.234��ʾΪ.234 "#,###.0#"
	 *            -->��ʾ����ÿ��3λ��һ��"��";
	 * @param l
	 *            Locale
	 * @return String
	 */
	public static String formatNumber(double d, String pattern, Locale locale) {
		String s = "";
		try {
			DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(locale);
			nf.applyPattern(pattern);
			s = nf.format(d);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.error(" formatNumber is error!");
		}
		return s;

	}

	/**
	 * �����������ְ���������ʽ���
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String #:��ʾ��������������֣�û����գ�������λ�����ڣ���λ�����򳬳����� 0:��������������֣�û�в�0
	 *            ����С�����м���#��0���ͱ�����λ��С���� ���磺 "###.00"
	 *            -->��ʾ�������ֵ������λС����������λ�Ĳ�0��������λ���������� "###.0#"
	 *            -->��ʾ�������ֵ���Ա���һλ����λС����������ʾΪ��һλС����һλ����λС���İ�ԭ����ʾ��������λ���������룻
	 *            "###" --->��ʾΪ������С�������������� ".###" -->12.234��ʾΪ.234 "#,###.0#"
	 *            -->��ʾ����ÿ��3λ��һ��"��";
	 * @param l
	 *            Locale
	 * @return String
	 */
	public static String formatNumber(Object d, String pattern, Locale locale) {
		String s = "";
		try {
			DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(locale);
			nf.applyPattern(pattern);
			s = nf.format(d);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.error(" formatNumber is error!");
		}
		return s;

	}

	/**
	 * ��ȱʡ���������������ʽ
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String
	 * @return String
	 */
	public static String formatNumber(Float d, String pattern) {
		return formatNumber(d, pattern, Locale.getDefault());
	}

	/**
	 * ��ȱʡ���������������ʽ
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String
	 * @return String
	 */
	public static String formatNumber(Double d, String pattern) {
		return formatNumber(d, pattern, Locale.getDefault());
	}

	/**
	 * ��ȱʡ���������������ʽ
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String
	 * @return String
	 */
	public static String formatNumber(double d, String pattern) {
		return formatNumber(d, pattern, Locale.getDefault());
	}

	/**
	 * ��ʽ������
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String "\u00A4#,###.00" :��ʾΪ ��1��234��234.10
	 * @param l
	 *            Locale
	 * @return String
	 */
	public static String formatCurrency(double d, String pattern, Locale l) {
		String s = "";
		try {
			DecimalFormat nf = (DecimalFormat) NumberFormat.getCurrencyInstance(l);
			nf.applyPattern(pattern);
			s = nf.format(d);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.error(" formatNumber is error!");
		}
		return s;

	}

	/**
	 * ʹ��Ĭ�������ָ����ʽ��ʾ����
	 * 
	 * @param d
	 *            double
	 * @param pattern
	 *            String
	 * @return String
	 */
	public static String formatCurrency(double d, String pattern) {
		return formatCurrency(d, pattern, Locale.getDefault());
	}

	/**
	 * ʹ��Ĭ�Ϸ�ʽ��ʾ���ң� ����:��12,345.46 Ĭ�ϱ���2λС������������
	 * 
	 * @param d
	 *            double
	 * @return String
	 */
	public static String formatCurrency(double d) {
		String s = "";
		try {
			DecimalFormat nf = (DecimalFormat) NumberFormat.getCurrencyInstance();
			s = nf.format(d);

		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.error(" formatNumber is error!");
		}
		return s;

	}

	/**
	 * ��ָ�������ʽ���ٷ���
	 * 
	 * @param d
	 * @param pattern
	 *            :"##,##.000%"-->��Ҫ���ǡ�%��
	 * @param l
	 * @return
	 */
	public static String formatPercent(double d, String pattern, Locale l) {
		String s = "";
		try {
			DecimalFormat df = (DecimalFormat) NumberFormat.getPercentInstance(l);
			df.applyPattern(pattern);
			s = df.format(d);
		} catch (Exception e) {
			LogUtils.error("formatPercent is error!", e);
		}
		return s;
	}

	/**
	 * ʹ��Ĭ�������ʽ���ٷ���
	 * 
	 * @param d
	 * @param pattern
	 * @return
	 */
	public static String formatPercent(double d, String pattern) {
		return formatPercent(d, pattern, Locale.getDefault());
	}

	/**
	 * ��ʽ���ٷ���
	 * 
	 * @param d
	 * @return
	 */
	public static String formatPercent(double d) {
		String s = "";
		try {
			DecimalFormat df = (DecimalFormat) NumberFormat.getPercentInstance();
			s = df.format(d);
		} catch (Exception e) {
			LogUtils.error("formatPercent is error!", e);
		}
		return s;
	}

	/**
	 * ������ֵĸ�ʽ,��:1,234,567.89
	 * 
	 * @param bd
	 *            BigDecimal Ҫ��ʽ��������
	 * @param format
	 *            String ��ʽ "###,##0"
	 * @return String
	 */
	public static String numberFormat(BigDecimal bd, String format) {

		if (bd == null || "0".equals(bd.toString())) {
			return "";
		}

		DecimalFormat bf = new DecimalFormat(format);
		return bf.format(bd);
	}

	public static void main(String[] args) {
		// String s = formatCurrency(11123.89343,"$##,##.000");
		DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
		nf.applyPattern("#.####");
		int bb = 31111;
		String s = nf.format(bb);
		System.out.println(s);
	}

}
