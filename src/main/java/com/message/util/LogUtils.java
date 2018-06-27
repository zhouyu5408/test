package com.message.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * ��־������<br/>
 * 
 * @Date: 2017��11��27�� ����9:54:41 <br/>
 *
 * @author zhouyu
 * @version 1.0 Copyright (YLINK) , All Rights Reserved.
 * @since JDK 1.7
 */
public class LogUtils {

	private static final Level INFO = Level.INFO;

	private static final Level DEBUG = Level.DEBUG;

	private static final Level WARN = Level.WARN;

	private static final Level ERROR = Level.ERROR;

	private static final Level ALARM = Level.FATAL;

	public static Logger logger = Logger.getLogger("com.simpro.core.util");

	// public static Logger logger =
	// Logger.getLogger(sun.reflect.Reflection.getCallerClass(2));
	// static
	// {
	// logger = Logger.getLogger(LogUtils.class);
	// InputStream is = null;
	// try {
	// is = new FileInputStream(System.getProperty("log4jFile"));
	// Properties logProps = new Properties();
	// logProps.load(is);
	// PropertyConfigurator.configure(logProps);
	// }
	// catch (Exception e) {
	// System.err.println("��ʼ����־������Ϣʱ�������´���" + e.getMessage());
	// }finally{
	// try{
	// is.close();
	// }catch(Exception e){
	// System.err.println("��־���ر�ʧ�ܣ�" + e.getMessage());
	// }
	// }
	// }

	/**
	 * ������־������Ϣд��־
	 *
	 * @param logMessage
	 *            ��־��Ϣ
	 * @param errorLevel
	 *            ��־����
	 * @param e
	 *            ����
	 */
	private static void printLog(String logMessage, Level errorLevel, Throwable e) {
		try {
			StringBuffer sbLog = new StringBuffer();

			sbLog.append("���̱߳�ţ�");
			sbLog.append(Thread.currentThread().getName());
			sbLog.append("��");
			if (errorLevel == null || errorLevel == INFO) {
				errorLevel = INFO;
				sbLog.append("����Ϣ��");
			} else if (errorLevel == DEBUG) {
				sbLog.append("�����ԡ�");
			} else if (errorLevel == WARN) {
				sbLog.append("�����桿");
			} else if (errorLevel == ERROR) {
				sbLog.append("������");
			} else if (errorLevel == ALARM) {
				sbLog.append("�����ش���");
			}
			sbLog.append(logMessage);
			logger.log(errorLevel, sbLog.toString(), e);
		} catch (Exception ex) {
			logger.error("��¼��־ʱ�������´���" + ex.getMessage());
		}
	}

	/**
	 * ������־������Ϣд��־
	 * 
	 * @param logMessage
	 *            ��־��Ϣ
	 * @param errorLevel
	 *            ��־����
	 */
	private static void printLog(String logMessage, Level errorLevel) {
		printLog(logMessage, errorLevel, null);
	}

	/**
	 * ������־
	 * 
	 * @param object
	 */
	public static void error(Object object) {
		printLog(object.toString(), ERROR);
	}

	/**
	 * ������־
	 * 
	 * @param object
	 * @param t
	 */
	public static void error(Object object, Throwable t) {
		printLog(object.toString(), ERROR, t);
	}

	/**
	 * ���Դ�����־
	 * 
	 * @param object
	 */
	public static void debug(Object object) {
		printLog(object.toString(), DEBUG);
	}

	/**
	 * ���Դ�����־
	 * 
	 * @param object
	 * @param t
	 */
	public static void debug(Object object, Throwable t) {
		printLog(object.toString(), DEBUG, t);
	}

	/**
	 * ��Ϣ��־
	 * 
	 * @param object
	 */
	public static void info(Object object) {
		printLog(object.toString(), INFO);
	}

	/**
	 * ��Ϣ��־
	 * 
	 * @param object
	 * @param t
	 */
	public static void info(Object object, Throwable t) {
		printLog(object.toString(), INFO, t);
	}

	/**
	 * ������־
	 * 
	 * @param object
	 */
	public static void warn(Object object) {
		printLog(object.toString(), WARN);
	}

	/**
	 * ������־
	 * 
	 * @param object
	 * @param t
	 */
	public static void warn(Object object, Throwable t) {
		printLog(object.toString(), WARN, t);
	}

	/**
	 * ������־
	 * 
	 * @param object
	 */
	public static void alerm(Object object) {
		printLog(object.toString(), ALARM);
	}

	/**
	 * ������־
	 * 
	 * @param object
	 * @param t
	 */
	public static void alerm(Object object, Throwable t) {
		printLog(object.toString(), ALARM, t);
	}

	/**
	 * isInfoEnabled
	 * 
	 * @param object
	 */
	public static boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	/**
	 * isDebugEnabled
	 * 
	 * @param object
	 */
	public static boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	/**
	 * print StackTrace
	 * 
	 * @return
	 */
	// public static String stackTraceToString(Exception ex) {
	// StringBuffer buffOut = new StringBuffer();
	// StackTraceElement[] trace = ex.getStackTrace();
	//
	// for (int i = 0; i < trace.length; i++)
	// buffOut.append("\tat " + trace[i]+ "\n ");
	// Throwable ourCause = ex.getCause();
	// if (ourCause != null) {
	// buffOut.append("Caused by: " + ourCause);
	// StringWriter sw = new StringWriter();
	// try {
	// ourCause.printStackTrace(new PrintWriter(sw));
	// buffOut.append("\n ");
	// buffOut.append(sw.getBuffer());
	// sw.flush();
	// } finally {
	// try {
	// sw.close();
	// } catch (IOException e) {
	// }
	// }
	// }
	// return buffOut.toString();
	// }
	public static String stackTraceToString(Exception e) {
		StringBuffer buffOut = new StringBuffer();
		buffOut.append("\n").append(e.getMessage()).append("\n");
		StackTraceElement[] trace = e.getStackTrace();
		for (int i = 0; i < trace.length; i++)
			buffOut.append("\tat ").append(trace[i]).append("\n");
		Throwable ourCause = e.getCause();
		if (ourCause != null) {
			logStackTraceAsCause(trace, ourCause, buffOut);
		}
		return buffOut.toString();
	}

	private static void logStackTraceAsCause(StackTraceElement[] causedTrace, Throwable e, StringBuffer buffOut) {
		StackTraceElement[] trace = e.getStackTrace();
		buffOut.append("\nCaused by: ").append(e.getMessage()).append("\n");
		int m = trace.length - 1, n = causedTrace.length - 1;
		while (m >= 0 && n >= 0 && trace[m].equals(causedTrace[n])) {
			m--;
			n--;
		}
		int framesInCommon = trace.length - 1 - m;

		for (int i = 0; i <= m; i++)
			buffOut.append("\tat ").append(trace[i]).append("\n");
		if (framesInCommon != 0)
			buffOut.append("\t... ").append(framesInCommon).append(" more \n");
		// Recurse if we have a cause
		Throwable ourCause = e.getCause();
		if (ourCause != null)
			logStackTraceAsCause(trace, ourCause, buffOut);
	}

}
