package org.brijframework.logger.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.brijframework.logger.LoggerDetail;
import org.brijframework.logger.constant.LogAccess;
import org.brijframework.logger.constant.LogLevel;
import org.brijframework.logger.container.LoggerContainer;
import org.brijframework.logger.util.LoggerUtil;
import org.brijframework.monitor.factories.SessionScopeMonitorFactroy;

public class LogException extends RuntimeException {
	/**
	 * 
	 */
	static LoggerContainer loggerContainer = LoggerContainer.getContainer();
	private static final long serialVersionUID = 1L;
	public LogException() {
	}
	public LogException(String logID, LogAccess access, Object obj, String message, LogLevel level) {
		super(message, new Throwable(message));
		switch (level) {
		case TRACE:
			trace(logID, access, obj, this, message);
			break;
		case DEBUG:
			debug(logID, access, obj, this, message);
			break;
		case INFO:
			info(logID, access, obj, this, message);
			break;
		case WARN:
			warning(logID, access, obj, this, message);
			break;
		case ERROR:
			error(logID, access, obj, this, message);
			break;
		default:
			break;
		}
	}

	//                              INFO
	public static void info(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.INFO,  access, exception);
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(exception.getMessage());
		loggerContainer.add(LogLevel.INFO.toString(), log.getLoggerId(), log);
	}

	public static void info(String logID, LogAccess access, Object obj, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(LogLevel.INFO + " :" + message);
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.INFO,  access);
		loggerContainer.add(LogLevel.INFO.toString(), log.getLoggerId(), log);
	}

	public static void info(String logID, LogAccess access, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(LogLevel.INFO + " :" + message);
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.INFO,  access);
		loggerContainer.add(LogLevel.INFO.toString(), log.getLoggerId(), log);
	}
	// WARN

	public static void warning(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG WARN-------------- x ----------------------------x--------------------------");
		System.err.println("Warning :" + message);
		LoggerUtil.writeLog(exception.getMessage());
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.WARN,  access);
		loggerContainer.add(LogLevel.WARN.toString(), log.getLoggerId(), log);
	}

	public static void warning(String logID, LogAccess access, Object obj, String message) {
		LoggerUtil.writeLog("LOG WARN-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.WARN + " :" + message);
		LoggerUtil.writeLog(LogLevel.WARN + " : " + message);
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.WARN,  access);
		loggerContainer.add(LogLevel.WARN.toString(), log.getLoggerId(), log);
	}

	public static void trace(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG TRACE-------------- x ----------------------------x--------------------------");
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		exception.printStackTrace(printWriter);
		printWriter.flush();
		System.err.println(LogLevel.TRACE + "       : | " + obj.getClass() + " | " + message + " ");
		LoggerUtil.writeLog("Stack Trace:" + stringWriter.toString());
		System.err.println("Stack Trace : " + stringWriter.toString());
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.TRACE,  access);
		loggerContainer.add(LogLevel.TRACE.toString(), log.getLoggerId(), log);
	}

	public static void trace(String logID, LogAccess access, String message, Exception exception) {
		LoggerUtil.writeLog("LOG TRACE-------------- x ----------------------------x--------------------------");
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		exception.printStackTrace(printWriter);
		printWriter.flush();
		LoggerUtil.writeLog("Stack Trace:" + stringWriter.toString());
		System.err.println("Stack Trace : " + stringWriter.toString());
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.TRACE,  access);
		loggerContainer.add(LogLevel.TRACE.toString(), log.getLoggerId(), log);
	}

	public static void debug(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG TRACE-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.DEBUG + " : " + message);
		logToScreen(logID, access, obj, message);
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println(exception.fillInStackTrace());
		printWriter.flush();
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.TRACE,  access);
		loggerContainer.add(LogLevel.TRACE.toString(), log.getLoggerId(), log);
	}

	public static void error(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG ERROR-------------- x ----------------------------x--------------------------");
		LoggerUtil.writeLog("Error :" + message);
		System.err.println("Error :" + message);
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		exception.printStackTrace(printWriter);
		printWriter.flush();
		LoggerUtil.writeLog("Stack Trace:" + stringWriter.toString());
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.TRACE,  access);
		loggerContainer.add(LogLevel.TRACE.toString(), log.getLoggerId(), log);
	}

	public static void logToScreen(String logID, LogAccess access, Object obj, String err) {
		LoggerUtil.writeLog("LOG MSG-------------- x ----------------------------x--------------------------");
		System.err.println("Log ID     :" + logID);
		System.err.println("Log Err    :" + err);
		LoggerUtil.writeLog("Log Access :" + access);
	}

}
