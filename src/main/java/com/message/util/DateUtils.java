package com.message.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * ��������ͨ�ù�����</p>
 * @Date: 2017��11��27�� ����9:57:47 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
public class DateUtils {

	/** ������ģʽ�ַ��� */
	public static final String YEAR_MONTH_DAY_PATTERN_MIDLINE = "yyyy-MM-dd";

	public static final String YEAR_MONTH_DAY_PATTERN_DOT = "yyyy.MM.dd";

	public static final String YEAR_MONTH_DAY_PATTERN_BLANK = "yyyyMMdd";

	public static final String YEAR_MONTH_DAY_PATTERN_SOLIDUS = "yyyy/MM/dd";

	/** ʱ����ģʽ�ַ��� */
	public static final String HOUR_MINUTE_SECOND_PATTERN = "HH:mm:ss";

	/* ������ʱ����ģʽ�ַ��� */
	public static final String YMDHMS_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * ���ϵͳ��ǰʱ��YYYY-MM-DD
	 * 
	 * @return Date
	 */
	public static String getCurrentDate() {
		return format(new Date(System.currentTimeMillis()), YEAR_MONTH_DAY_PATTERN_MIDLINE);
	}

	public static String getCurrentDate(String format) {
		return format(new Date(System.currentTimeMillis()), format);
	}

	/**
	 * ��ĳ����������ָ�������������ؽ����������븺������Ϊ����
	 * 
	 * @param ammount
	 *            Ҫ���������Ŀ
	 * @return ������ڶ���
	 */
	public static String addYearFromCurrentDate(final int ammount) {
		Calendar c = Calendar.getInstance();
		c.getFirstDayOfWeek();
		c.setTime(new Date(System.currentTimeMillis()));
		c.add(Calendar.YEAR, ammount);
		return format(c.getTime(), YEAR_MONTH_DAY_PATTERN_MIDLINE);
	}

	/**
	 * ��ĳ����������ָ�������������ؽ����������븺������Ϊ����
	 * 
	 * @param ammount
	 *            Ҫ�����µ���Ŀ
	 * @return ������ڶ���
	 */
	public static String addMonthFromCurrentDate(final int ammount) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(System.currentTimeMillis()));
		c.add(Calendar.MONTH, ammount);
		return format(c.getTime(), YEAR_MONTH_DAY_PATTERN_MIDLINE);
	}

	/**
	 * ��ĳ����������ָ�������������ؽ����������븺������Ϊ����
	 * 
	 * @param ammount
	 *            Ҫ���������Ŀ
	 * @return ������ڶ���
	 */
	public static String addDayFromCurrentDate(final int ammount) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(System.currentTimeMillis()));
		c.add(Calendar.DATE, ammount);
		return format(c.getTime(), YEAR_MONTH_DAY_PATTERN_MIDLINE);
	}

	/**
	 * ���ϵͳ��ǰʱ��
	 * 
	 * @return Date
	 */
	public static Date currentDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * ���ϵͳ��ǰʱ��
	 * 
	 * @return Date
	 */
	public static Timestamp currentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * solidus �����ݿ��������ȡ��ǰʱ�䡣
	 * 
	 * @return ���ص�ǰʱ��
	 * @throws SQLException
	 *             ��ȡ���ݿ�ʱ��ʱ��������
	 */
	public static Date currentDate(Connection conn) throws SQLException {
		Date result = null;

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("select sysdate from dual");
			rs = pst.executeQuery();
			if (rs.next()) {
				Timestamp ts = rs.getTimestamp(1);
				if (ts != null) {
					result = new Date(ts.getTime());
				}
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException sqle) {
					// ignore it
				}
			}
			if (pst != null) {
				try {
					pst.close();
					pst = null;
				} catch (SQLException sqle) { // ignore it}
				}
			}
		}

		return result;
	}

	/**
	 * �����ݿ��������ȡ��ǰʱ�䲢���ݴ����patterת�����ַ�����ʽ��
	 * 
	 * @param pattern
	 *            ����pattern
	 * @return ���ص�ǰʱ����ݴ���patternת������ַ���
	 * @throws SQLException
	 *             ��ȡ���ݿ�ʱ��ʱ��������
	 */
	public static String currentDateString(Connection conn, final String pattern) throws SQLException {
		return format(currentDate(conn), pattern);
	}

	/**
	 * �����ݿ��������ȡ��ǰʱ�䲢ת����Ĭ���ַ�����ʽ��yyyy-MM-dd����
	 * 
	 * @return ���ص�ǰʱ���Ĭ���ַ�����ʽ��yyyy-MM-dd��
	 * @throws SQLException
	 *             ��ȡ���ݿ�ʱ��ʱ��������
	 */
	public static String currentDateDefaultString(Connection conn) throws SQLException {
		return format(currentDate(conn), YEAR_MONTH_DAY_PATTERN_MIDLINE);
	}

	/**
	 * ��ȡ�������ڶ������
	 * 
	 * @param date
	 *            ���ڶ���
	 * @return ��
	 */
	public static int getYear(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * ��ȡ�������ڶ������
	 * 
	 * @param date
	 *            ���ڶ���
	 * @return ��
	 */
	public static int getMonth(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * ��ȡ�������ڶ������
	 * 
	 * @param date
	 *            ���ڶ���
	 * @return ��
	 */
	public static int getDay(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DATE);
	}

	/**
	 * ��ȡ�������ڶ����ʱ
	 * 
	 * @param date
	 *            ���ڶ���
	 * @return ʱ
	 */
	public static int getHour(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR);
	}

	/**
	 * ��ȡ�������ڶ���ķ�
	 * 
	 * @param date
	 *            ���ڶ���
	 * @return ��
	 */
	public static int getMinute(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * ��ȡ�������ڶ������
	 * 
	 * @param date
	 *            ���ڶ���
	 * @return ��
	 */
	public static int getSecond(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * ��ȡ�������ڵ�����µ�Integer��ʽ��yyyyMM����
	 * 
	 * @param date
	 *            Ҫת�������ڶ���
	 * @return ת�����Integer����
	 */
	public static Integer getYearMonth(final Date date) {
		return new Integer(format(date, "yyyyMM"));
	}

	/**
	 * �����µ�������ʽ��yyyyMM��ת��Ϊ���ڶ��󷵻ء�
	 * 
	 * @param yearMonth
	 *            ���µ�������ʽ��yyyyMM��
	 * @return ��������
	 * @throws ParseException
	 */
	public static Date parseYearMonth(final Integer yearMonth) throws ParseException {
		return parse(String.valueOf(yearMonth), "yyyyMM");
	}

	/**
	 * �����µ��ַ�����yyyyMM��ת��Ϊ���ڶ��󷵻ء�
	 * 
	 * @param yearMonth
	 *            ���µ��ַ�����yyyyMM��
	 * @return ��������
	 * @throws ParseException
	 */
	public static Date parseYearMonth(final String yearMonth) throws ParseException {
		return parse(yearMonth, "yyyyMM");
	}

	/**
	 * ��ĳ����������ָ�������������ؽ����������븺������Ϊ����
	 * 
	 * @param date
	 *            Ҫ���������ڶ���
	 * @param ammount
	 *            Ҫ���������Ŀ
	 * @return ������ڶ���
	 */
	public static Date addYear(final Date date, final int ammount) {
		Calendar c = Calendar.getInstance();
		c.getFirstDayOfWeek();
		c.setTime(date);
		c.add(Calendar.YEAR, ammount);
		return c.getTime();
	}

	/**
	 * ��ĳ����������ָ�������������ؽ����������븺������Ϊ����
	 * 
	 * @param date
	 *            Ҫ���������ڶ���
	 * @param ammount
	 *            Ҫ�����µ���Ŀ
	 * @return ������ڶ���
	 */
	public static Date addMonth(final Date date, final int ammount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, ammount);
		return c.getTime();
	}

	/**
	 * ��ĳ����������ָ�������������ؽ����������븺������Ϊ����
	 * 
	 * @param date
	 *            Ҫ���������ڶ���
	 * @param ammount
	 *            Ҫ���������Ŀ
	 * @return ������ڶ���
	 */
	public static Date addDay(final Date date, final int ammount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, ammount);
		return c.getTime();
	}

	/**
	 * ������������ʽ����������ָ�������������ؽ����������븺������Ϊ����
	 * 
	 * @param yearMonth
	 *            Ҫ����������
	 * @param ammount
	 *            Ҫ���ӵ�����
	 * @return �������
	 * @throws ParseException
	 */
	public static Integer addMonth(final Integer yearMonth, final int ammount) throws ParseException {
		return getYearMonth(addMonth(parseYearMonth(yearMonth), ammount));
	}

	/**
	 * ���ظ�����beforeDate��afterDate������������beforeDate����afterDate���� ���ظ�����
	 * 
	 * @param beforeDate
	 *            Ҫ�Ƚϵ��������
	 * @param afterDate
	 *            Ҫ�Ƚϵ��������
	 * @return beforeDate��afterDate���������������ʾ��
	 */
	public static int beforeYears(final Date beforeDate, final Date afterDate) {
		Calendar beforeCalendar = Calendar.getInstance();
		beforeCalendar.setTime(beforeDate);
		beforeCalendar.set(Calendar.MONTH, 1);
		beforeCalendar.set(Calendar.DATE, 1);
		beforeCalendar.set(Calendar.HOUR, 0);
		beforeCalendar.set(Calendar.SECOND, 0);
		beforeCalendar.set(Calendar.MINUTE, 0);
		Calendar afterCalendar = Calendar.getInstance();
		afterCalendar.setTime(afterDate);
		afterCalendar.set(Calendar.MONTH, 1);
		afterCalendar.set(Calendar.DATE, 1);
		afterCalendar.set(Calendar.HOUR, 0);
		afterCalendar.set(Calendar.SECOND, 0);
		afterCalendar.set(Calendar.MINUTE, 0);
		boolean positive = true;
		if (beforeDate.after(afterDate))
			positive = false;
		int beforeYears = 0;
		while (true) {
			boolean yearEqual = beforeCalendar.get(Calendar.YEAR) == afterCalendar.get(Calendar.YEAR);
			if (yearEqual) {
				break;
			} else {
				if (positive) {
					beforeYears++;
					beforeCalendar.add(Calendar.YEAR, 1);
				} else {
					beforeYears--;
					beforeCalendar.add(Calendar.YEAR, -1);
				}
			}
		}
		return beforeYears;
	}

	/**
	 * ���ظ�����beforeDate��afterDate������������beforeDate����afterDate���� ���ظ�����
	 * 
	 * @param beforeDate
	 *            Ҫ�Ƚϵ��������
	 * @param afterDate
	 *            Ҫ�Ƚϵ��������
	 * @return beforeDate��afterDate���������������ʾ��
	 */
	public static int beforeMonths(final Date beforeDate, final Date afterDate) {
		Calendar beforeCalendar = Calendar.getInstance();
		beforeCalendar.setTime(beforeDate);
		beforeCalendar.set(Calendar.DATE, 1);
		beforeCalendar.set(Calendar.HOUR, 0);
		beforeCalendar.set(Calendar.SECOND, 0);
		beforeCalendar.set(Calendar.MINUTE, 0);
		Calendar afterCalendar = Calendar.getInstance();
		afterCalendar.setTime(afterDate);
		afterCalendar.set(Calendar.DATE, 1);
		afterCalendar.set(Calendar.HOUR, 0);
		afterCalendar.set(Calendar.SECOND, 0);
		afterCalendar.set(Calendar.MINUTE, 0);
		boolean positive = true;
		if (beforeDate.after(afterDate))
			positive = false;
		int beforeMonths = 0;
		while (true) {
			boolean yearEqual = beforeCalendar.get(Calendar.YEAR) == afterCalendar.get(Calendar.YEAR);
			boolean monthEqual = beforeCalendar.get(Calendar.MONTH) == afterCalendar.get(Calendar.MONTH);
			if (yearEqual && monthEqual) {
				break;
			} else {
				if (positive) {
					beforeMonths++;
					beforeCalendar.add(Calendar.MONTH, 1);
				} else {
					beforeMonths--;
					beforeCalendar.add(Calendar.MONTH, -1);
				}
			}
		}
		return beforeMonths;
	}

	/**
	 * ���ظ�����beforeDate��afterDate������������beforeDate����afterDate���� ���ظ�����
	 * 
	 * @param beforeDate
	 *            Ҫ�Ƚϵ��������
	 * @param afterDate
	 *            Ҫ�Ƚϵ��������
	 * @return beforeDate��afterDate���������������ʾ��
	 */
	public static int beforeDays(final Date beforeDate, final Date afterDate) {
		Calendar beforeCalendar = Calendar.getInstance();
		beforeCalendar.setTime(beforeDate);
		beforeCalendar.set(Calendar.HOUR, 0);
		beforeCalendar.set(Calendar.SECOND, 0);
		beforeCalendar.set(Calendar.MINUTE, 0);
		Calendar afterCalendar = Calendar.getInstance();
		afterCalendar.setTime(afterDate);
		afterCalendar.set(Calendar.HOUR, 0);
		afterCalendar.set(Calendar.SECOND, 0);
		afterCalendar.set(Calendar.MINUTE, 0);
		boolean positive = true;
		if (beforeDate.after(afterDate))
			positive = false;
		int beforeDays = 0;
		while (true) {
			boolean yearEqual = beforeCalendar.get(Calendar.YEAR) == afterCalendar.get(Calendar.YEAR);
			boolean monthEqual = beforeCalendar.get(Calendar.MONTH) == afterCalendar.get(Calendar.MONTH);
			boolean dayEqual = beforeCalendar.get(Calendar.DATE) == afterCalendar.get(Calendar.DATE);
			if (yearEqual && monthEqual && dayEqual) {
				break;
			} else {
				if (positive) {
					beforeDays++;
					beforeCalendar.add(Calendar.DATE, 1);
				} else {
					beforeDays--;
					beforeCalendar.add(Calendar.DATE, -1);
				}
			}
		}
		return beforeDays;
	}

	/**
	 * ��ȡbeforeDate��afterDate֮������������������ȷ���졣������ʾ��
	 * 
	 * @param beforeDate
	 *            Ҫ�Ƚϵ��������
	 * @param afterDate
	 *            Ҫ�Ƚϵ��������
	 * @return beforeDate��afterDate�������������������ʾ��
	 */
	public static int beforeRoundYears(final Date beforeDate, final Date afterDate) {
		Date bDate = beforeDate;
		Date aDate = afterDate;
		boolean positive = true;
		if (beforeDate.after(afterDate)) {
			positive = false;
			bDate = afterDate;
			aDate = beforeDate;
		}
		int beforeYears = beforeYears(bDate, aDate);

		int bMonth = getMonth(bDate);
		int aMonth = getMonth(aDate);
		if (aMonth < bMonth) {
			beforeYears--;
		} else if (aMonth == bMonth) {
			int bDay = getDay(bDate);
			int aDay = getDay(aDate);
			if (aDay < bDay) {
				beforeYears--;
			}
		}

		if (positive) {
			return beforeYears;
		} else {
			return new BigDecimal(beforeYears).negate().intValue();
		}
	}

	/**
	 * ��ȡbeforeDate��afterDate֮������������������ȷ���¡�������ʾ��
	 * 
	 * @param beforeDate
	 *            Ҫ�Ƚϵ��������
	 * @param afterDate
	 *            Ҫ�Ƚϵ��������
	 * @return beforeDate��afterDate�������������������ʾ��
	 */
	public static int beforeRoundAges(final Date beforeDate, final Date afterDate) {
		Date bDate = beforeDate;
		Date aDate = afterDate;
		boolean positive = true;
		if (beforeDate.after(afterDate)) {
			positive = false;
			bDate = afterDate;
			aDate = beforeDate;
		}
		int beforeYears = beforeYears(bDate, aDate);

		int bMonth = getMonth(bDate);
		int aMonth = getMonth(aDate);
		if (aMonth < bMonth) {
			beforeYears--;
		}

		if (positive) {
			return beforeYears;
		} else {
			return new BigDecimal(beforeYears).negate().intValue();
		}
	}

	/**
	 * ��ȡbeforeDate��afterDate֮������������������ȷ���졣������ʾ��
	 * 
	 * @param beforeDate
	 *            Ҫ�Ƚϵ��������
	 * @param afterDate
	 *            Ҫ�Ƚϵ��������
	 * @return beforeDate��afterDate�������������������ʾ��
	 */
	public static int beforeRoundMonths(final Date beforeDate, final Date afterDate) {
		Date bDate = beforeDate;
		Date aDate = afterDate;
		boolean positive = true;
		if (beforeDate.after(afterDate)) {
			positive = false;
			bDate = afterDate;
			aDate = beforeDate;
		}
		int beforeMonths = beforeMonths(bDate, aDate);

		int bDay = getDay(bDate);
		int aDay = getDay(aDate);
		if (aDay < bDay) {
			beforeMonths--;
		}

		if (positive) {
			return beforeMonths;
		} else {
			return new BigDecimal(beforeMonths).negate().intValue();
		}
	}

	/**
	 * ���ݴ�����ꡢ�¡��չ������ڶ���
	 * 
	 * @param year
	 *            ��
	 * @param month
	 *            ��
	 * @param date
	 *            ��
	 * @return ���ظ��ݴ�����ꡢ�¡��չ�������ڶ���
	 */
	public static Date getDate(final int year, final int month, final int date) {
		Calendar c = Calendar.getInstance();
		c.set(year + 1900, month, date);
		return c.getTime();
	}

	/**
	 * ���ݴ�������ڸ�ʽ��pattern����������ڸ�ʽ�����ַ�����
	 * 
	 * @param date
	 *            Ҫ��ʽ�������ڶ���
	 * @param pattern
	 *            ���ڸ�ʽ��pattern
	 * @return ��ʽ����������ַ���
	 */
	public static String format(final Date date, final String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * ����������ڰ���Ĭ������ת�����ַ�����yyyy-MM-dd��
	 * 
	 * @param date
	 *            Ҫ��ʽ�������ڶ���
	 * @return ��ʽ����������ַ���
	 */
	public static String format(final Date date) {
		return format(date, YEAR_MONTH_DAY_PATTERN_MIDLINE);
	}

	/**
	 * ���ݴ�������ڸ�ʽ��patter��������ַ���ת�������ڶ���
	 * 
	 * @param dateStr
	 *            Ҫת�����ַ���
	 * @param pattern
	 *            ���ڸ�ʽ��pattern
	 * @return ת��������ڶ���
	 * @throws ParseException
	 *             ���������ַ�����ʽ���Ϸ�
	 */
	public static Date parse(final String dateStr, final String pattern) throws ParseException {
		DateFormat df = new SimpleDateFormat(pattern);

		return df.parse(dateStr);
	}

	public static Date parse(Date date, final String pattern) throws ParseException {
		return parse(date.toString(), pattern);
	}

	/**
	 * ��������ַ�������Ĭ�ϸ�ʽת��Ϊ���ڶ���yyyy-MM-dd��
	 * 
	 * @param dateStr
	 *            Ҫת�����ַ���
	 * @return ת��������ڶ���
	 * @throws ParseException
	 *             ���������ַ�����ʽ������Ĭ�ϸ�ʽ�����������ַ�����ʽ���Ϸ���
	 */
	public static Date parse(final String dateStr) throws ParseException {
		return parse(dateStr, YEAR_MONTH_DAY_PATTERN_MIDLINE);
	}

	/**
	 * Ҫ���кϷ�����֤��������ֵ
	 * 
	 * @param yearMonth
	 *            ��֤������ֵ
	 * @return �����Ƿ�Ϸ�
	 */
	public static boolean isYearMonth(final Integer yearMonth) {
		String yearMonthStr = yearMonth.toString();
		return isYearMonth(yearMonthStr);
	}

	/**
	 * Ҫ���кϷ�����֤�������ַ���
	 * 
	 * @param yearMonthStr
	 *            ��֤�����ַ���
	 * @return �����Ƿ�Ϸ�
	 */
	public static boolean isYearMonth(final String yearMonthStr) {
		if (yearMonthStr.length() != 6)
			return false;
		else {
			String yearStr = yearMonthStr.substring(0, 4);
			String monthStr = yearMonthStr.substring(4, 6);
			try {
				int year = Integer.parseInt(yearStr);
				int month = Integer.parseInt(monthStr);
				if (year < 1800 || year > 3000) {
					return false;
				}
				if (month < 1 || month > 12) {
					return false;
				}
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * ��ȡһ���µ��������
	 * 
	 * @param date
	 *            Ҫ�����·�
	 * @return int һ���µ��������
	 */
	@SuppressWarnings("static-access")
	public static int getDayOfMonth(final Date date) {
		java.util.Calendar calendarDate = java.util.Calendar.getInstance();
		calendarDate.setTime(date);
		return calendarDate.getActualMaximum(calendarDate.DAY_OF_MONTH);
	}

	/**
	 * ��ȡ��from��to������Integer��ʽֵ���б�
	 * 
	 * @param from
	 *            ��
	 * @param to
	 *            ��
	 * @return ����Integer��ʽֵ�б�
	 * @throws ParseException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getYearMonths(Integer from, Integer to) throws ParseException {
		List yearMonths = new ArrayList();
		Date fromDate = parseYearMonth(from);
		Date toDate = parseYearMonth(to);
		if (fromDate.after(toDate))
			throw new IllegalArgumentException("'from' date should before 'to' date!");
		Date tempDate = fromDate;
		while (tempDate.before(toDate)) {
			yearMonths.add(getYearMonth(tempDate));
			tempDate = addMonth(tempDate, 1);
		}
		if (!from.equals(to)) {
			yearMonths.add(to);
		}

		return yearMonths;
	}

	/**
	 * ��õ�ǰ�꼾�� @ String date ���ʱ��Ĳ�����Ϊ�ṩ��չ����
	 * 
	 * @return String ��ǰ�꼾��
	 */
	public static String getYQ(final String ymd) throws ParseException {
		int[] dates = splitYMD(ymd);
		if (dates[1] >= 1 && dates[1] <= 3)
			return dates[0] + "-" + "1";
		if (dates[1] >= 4 && dates[1] <= 6)
			return dates[0] + "-" + "2";
		if (dates[1] >= 7 && dates[1] <= 9)
			return dates[0] + "-" + "3";
		return dates[0] + "-" + "4";

	}

	/**
	 * ���ָ�������������� @ String ymd ָ������
	 * 
	 * @return String ָ�����ڵļ���
	 */
	public static String getQ(final String dateStr) throws ParseException {
		return StringUtils.splitToIntArray(getYQ(dateStr), ".")[1] + "";
	}

	/**
	 * �ָ������ճ�����
	 * 
	 * @param ymd
	 * @return
	 * @throws ParseException
	 */
	public static int[] splitYMD(String ymd) throws ParseException {
		Date date = parse(ymd, DateUtils.YEAR_MONTH_DAY_PATTERN_MIDLINE);
		String _ymd = format(date, YEAR_MONTH_DAY_PATTERN_MIDLINE);

		int[] intArray = StringUtils.splitToIntArray(_ymd, "-");
		return intArray;
	}

	/**
	 * ���ʱ���ַ����ĸ�ʽ��Ϣ
	 * 
	 * @param ymd
	 * @return
	 */
	public static String clearFormat(String ymd) throws ParseException {
		Date date = parse(ymd, DateUtils.YEAR_MONTH_DAY_PATTERN_MIDLINE);
		String _ymd = format(date, YEAR_MONTH_DAY_PATTERN_BLANK);
		return _ymd;
	}

	/**
	 * ָ���������ڱȽϣ�Ŀ�����ڱ�Դ���ڳٷ���true����֮������false
	 * 
	 * @param ymd1
	 *            Դ����
	 * @param ymd2
	 *            Ŀ������
	 */
	public static boolean isLast(String ymd1, String ymd2) throws ParseException {
		int ymd1Int = MathUtils.parseInt(clearFormat(ymd1));
		int ymd2Int = MathUtils.parseInt(clearFormat(ymd2));
		if (ymd2Int > ymd1Int)
			return true;
		else
			return false;
	}

	/**
	 * @param symd
	 * @param eymd
	 * @return
	 * @throws ParseException
	 */
	public static int getBetweenDays(String symd, String eymd) throws ParseException {
		int[] ymdL = DateUtils.splitYMD(symd);
		GregorianCalendar gcStart = new GregorianCalendar(ymdL[0], ymdL[1], ymdL[2]);
		ymdL = DateUtils.splitYMD(eymd);
		GregorianCalendar gcEnd = new GregorianCalendar(ymdL[0], ymdL[1], ymdL[2]);

		long longStart = gcStart.getTimeInMillis();
		long longEnd = gcEnd.getTimeInMillis();

		int days = (int) ((longEnd - longStart) / (1000 * 60 * 60 * 24));
		return days;
	}

	/**
	 * ȡ�õ�ǰ�����Ƕ�����
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * �õ�ĳһ���ܵ�����
	 * 
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	/**
	 * �õ�ĳ��ĳ�ܵĵ�һ��
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime());
	}

	/**
	 * �õ�ĳ��ĳ�ܵ����һ��
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	/**
	 * ȡ�õ�ǰ���������ܵĵ�һ��
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	/**
	 * ��� ��xxx�ܵĵ�һ��
	 * 
	 * @param prevNum
	 * @return
	 */
	public static Date getFirstDayOfPrevWeek(int prevNum) {
		Date currentDate = currentDate();
		int weekNum = getWeekOfYear(currentDate);
		return getFirstDayOfWeek(getYear(currentDate), weekNum - prevNum);
	}

	/**
	 * ��� ��xxx�ܵ����һ��
	 * 
	 * @param prevNum
	 * @return
	 */
	public static Date getLastDayOfPrevWeek(int prevNum) {
		Date currentDate = currentDate();
		int weekNum = getWeekOfYear(currentDate);
		return getLastDayOfWeek(getYear(currentDate), weekNum - prevNum);
	}

	/**
	 * ��� ��xxx�ܵĵ�һ��
	 * 
	 * @param prevNum
	 * @return
	 */
	public static Date getFirstDayOfNextWeek(int nextNum) {
		Date currentDate = currentDate();
		int weekNum = getWeekOfYear(currentDate);
		return getFirstDayOfWeek(getYear(currentDate), weekNum + nextNum);
	}

	/**
	 * ��� ��xxx�ܵ����һ��
	 * 
	 * @param prevNum
	 * @return
	 */
	public static Date getLastDayOfNextWeek(int nextNum) {
		Date currentDate = currentDate();
		int weekNum = getWeekOfYear(currentDate);
		return getLastDayOfWeek(getYear(currentDate), weekNum + nextNum);
	}

	/**
	 * ȡ�õ�ǰ���������ܵ����һ��
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DATE, 1);
		return c.getTime();
	}

	public static Date getLastDayOfMonth(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DATE, 1);
		c.roll(Calendar.DATE, -1);
		return c.getTime();
	}

	public static Date getLastDayOfMonth(int year, int month) {
		Calendar c = new GregorianCalendar();
		c.set(year, month - 1, 1);
		c.set(Calendar.DATE, 1);
		c.roll(Calendar.DATE, -1);
		return c.getTime();
	}

	public static void main(String[] agrs) {
		// Calendar c = new GregorianCalendar();
		// c.setTime(new Date());
		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println(df.format(c.getTime()));
		//
		// c.set(Calendar.DATE,1);
		// c.roll(Calendar.DATE, -1);
		// DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println(df1.format(c.getTime()));
		System.out.println(System.currentTimeMillis());
		System.out.println(new Date(1339405463841l));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(DateUtils.getLastDayOfMonth(2008, 10)));
	}
}
