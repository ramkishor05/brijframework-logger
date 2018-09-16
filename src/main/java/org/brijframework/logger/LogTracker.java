package org.brijframework.logger;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.brijframework.logger.constant.LogAccess;
import org.brijframework.logger.constant.LogLevel;
import org.brijframework.logger.container.LoggerContainer;
import org.brijframework.logger.util.LoggerUtil;

public class LogTracker extends RuntimeException {
	/**
	 * 
	 */
	static LoggerContainer loggerContainer = LoggerContainer.getContainer();
	private static final long serialVersionUID = 1L;
	public LogTracker() {
	}
	public LogTracker(String logID, LogAccess access, Object obj, String message, LogLevel level) {
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
		case ADD:
			break;
		case CUSTOM:
			break;
		case DELETE:
			break;
		case LOAD:
			break;
		case NOTIFIY:
			break;
		case PROCESS:
			break;
		case SAVE:
			break;
		case SEARCH:
			break;
		case SUCCESS:
			break;
		case UPDATE:
			break;
		default:
			break;
		}
	}

	//                              INFO
	public static void info(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		LogModel log = new LogModel(logID, "",LogLevel.INFO,  access, exception);
		log.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		log.level = LogLevel.INFO;
		log.getDetails().add(new LogDetail(log, message));
		loggerContainer.addContainer(LogLevel.INFO.toString(), log.logID.toString(), log);
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(exception.getMessage());
	}

	public static void info(String logID, LogAccess access, Object obj, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(LogLevel.INFO + " :" + message);
		LogModel log = new LogModel(logID, "",LogLevel.INFO,  access,message);
		log.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		log.level = LogLevel.INFO;
		log.getDetails().add(new LogDetail(log, message));
		loggerContainer.addContainer(LogLevel.INFO.toString(), log.logID.toString(), log);
	}

	public static void info(String logID, LogAccess access, String message) {
		LoggerUtil.writeLog("LOG INFO-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.INFO + " : " + message);
		LoggerUtil.writeLog(LogLevel.INFO + " :" + message);
		LogModel logBuilder =  new LogModel(logID, "",LogLevel.INFO,  access,message);
		logBuilder.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		logBuilder.level = LogLevel.INFO;
		logBuilder.access = access;
		loggerContainer.addContainer(LogLevel.INFO.toString(), logBuilder.logID.toString(), logBuilder);
	}
	// WARN

	public static void warning(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG WARN-------------- x ----------------------------x--------------------------");
		System.err.println("Warning :" + message);
		LoggerUtil.writeLog(exception.getMessage());
		LogModel logBuilder = new LogModel(logID, "",LogLevel.INFO,  access,message);
		logBuilder.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		logBuilder.level = LogLevel.WARN;
		logBuilder.access = access;
		loggerContainer.addContainer(LogLevel.WARN.toString(), logBuilder.logID.toString(), logBuilder);
	}

	public static void warning(String logID, LogAccess access, Object obj, String message) {
		LoggerUtil.writeLog("LOG WARN-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.WARN + " :" + message);
		LoggerUtil.writeLog(LogLevel.WARN + " : " + message);
		LogModel logBuilder =  new LogModel(logID, "",LogLevel.INFO,  access,message);
		logBuilder.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		logBuilder.level = LogLevel.WARN;
		logBuilder.access = access;
		loggerContainer.addContainer(LogLevel.WARN.toString(), logBuilder.logID.toString(), logBuilder);
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
		LogModel logBuilder =  new LogModel(logID, "",LogLevel.INFO,  access,message);
		logBuilder.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		logBuilder.level = LogLevel.TRACE;
		logBuilder.access = access;
		loggerContainer.addContainer(LogLevel.TRACE.toString(), logBuilder.logID.toString(), logBuilder);
	}

	public static void trace(String logID, LogAccess access, String message, Exception exception) {
		LoggerUtil.writeLog("LOG TRACE-------------- x ----------------------------x--------------------------");
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		exception.printStackTrace(printWriter);
		printWriter.flush();
		LoggerUtil.writeLog("Stack Trace:" + stringWriter.toString());
		System.err.println("Stack Trace : " + stringWriter.toString());
		LogModel logBuilder =  new LogModel(logID, "",LogLevel.INFO,  access,message);
		logBuilder.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		logBuilder.level = LogLevel.TRACE;
		logBuilder.access = access;
		loggerContainer.addContainer(LogLevel.TRACE.toString(), logBuilder.logID.toString(), logBuilder);
	}

	public static void debug(String logID, LogAccess access, Object obj, Exception exception, String message) {
		LoggerUtil.writeLog("LOG TRACE-------------- x ----------------------------x--------------------------");
		System.err.println(LogLevel.DEBUG + " : " + message);
		logToScreen(logID, access, obj, message);
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println(exception.fillInStackTrace());
		printWriter.flush();
		LogModel logBuilder =  new LogModel(logID, "",LogLevel.INFO,  access,message);
		logBuilder.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		logBuilder.level = LogLevel.DEBUG;
		logBuilder.access = access;
		loggerContainer.addContainer(LogLevel.DEBUG.toString(), logBuilder.logID.toString(), logBuilder);
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
		LogModel logBuilder =  new LogModel(logID, "",LogLevel.INFO,  access,message);
		logBuilder.logID = LogManager.getLogManager().getLoggerID("requestID") == null ? LogManager.getLogManager().getLoggerID() : LogManager.getLogManager().getLoggerID("requestID");
		logBuilder.level = LogLevel.ERROR;
		logBuilder.access = access;
		loggerContainer.addContainer(LogLevel.ERROR.toString(), logBuilder.logID.toString(), logBuilder);
	}

	public static void logToScreen(String logID, LogAccess access, Object obj, String err) {
		LoggerUtil.writeLog("LOG MSG-------------- x ----------------------------x--------------------------");
		System.err.println("Log ID     :" + logID);
		System.err.println("Log Err    :" + err);
		LoggerUtil.writeLog("Log Access :" + access);
	}

}
