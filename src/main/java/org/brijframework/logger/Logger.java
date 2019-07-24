package org.brijframework.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;

import org.brijframework.logger.constant.LogAccess;
import org.brijframework.logger.constant.LogLevel;
import org.brijframework.logger.container.LoggerContainer;
import org.brijframework.logger.model.LoggerDetail;
import org.brijframework.logger.util.LoggerUtil;
import org.brijframework.monitor.factories.SessionScopeMonitorFactroy;

public class Logger {

	//                              INFO
	public static void info(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.INFO,  access, exception);
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(exception.getMessage());
		LoggerContainer.getContainer().add(LogLevel.INFO.toString(), log.getLoggerId(), log);
	}

	public static void info(String logID, LogAccess access, Object obj, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(LogLevel.INFO + " :" + message);
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.INFO,  access);
		LoggerContainer.getContainer().add(LogLevel.INFO.toString(), log.getLoggerId(), log);
	}

	public static void info(String logID, LogAccess access, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(LogLevel.INFO + " :" + message);
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.INFO,  access);
		LoggerContainer.getContainer().add(LogLevel.INFO.toString(), log.getLoggerId(), log);
	}
	// WARN

	public static void warning(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG WARN-------------- x ----------------------------x--------------------------");
		System.err.println("Warning :" + message);
		LoggerUtil.writeLog(exception.getMessage());
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.WARN,  access);
		LoggerContainer.getContainer().add(LogLevel.WARN.toString(), log.getLoggerId(), log);
	}

	public static void warning(String logID, LogAccess access, Object obj, String message) {
		LoggerUtil.writeLog("LOG WARN-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.WARN + " :" + message);
		LoggerUtil.writeLog(LogLevel.WARN + " : " + message);
		LoggerDetail log = new LoggerDetail(logID, SessionScopeMonitorFactroy.factory().currentService().getId(),LogLevel.WARN,  access);
		LoggerContainer.getContainer().add(LogLevel.WARN.toString(), log.getLoggerId(), log);
	}
	
	public static void warning(String message) {
		warning(UUID.randomUUID().toString(), LogAccess.DEVELOPER, null, message);
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
		LoggerContainer.getContainer().add(LogLevel.TRACE.toString(), log.getLoggerId(), log);
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
		LoggerContainer.getContainer().add(LogLevel.TRACE.toString(), log.getLoggerId(), log);
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
		LoggerContainer.getContainer().add(LogLevel.TRACE.toString(), log.getLoggerId(), log);
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
		LoggerContainer.getContainer().add(LogLevel.TRACE.toString(), log.getLoggerId(), log);
	}
	
	public static void logToScreen(String logID, LogAccess access, Object obj, String err) {
		LoggerUtil.writeLog("LOG MSG-------------- x ----------------------------x--------------------------");
		System.err.println("Log ID     :" + logID);
		System.err.println("Log Err    :" + err);
		LoggerUtil.writeLog("Log Access :" + access);
	}

	

}
