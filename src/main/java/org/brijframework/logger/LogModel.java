package org.brijframework.logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.brijframework.logger.constant.LogAccess;
import org.brijframework.logger.constant.LogLevel;

public class LogModel {

	public Object logID;
	public Object userID;
	public LogLevel level;
	public LogAccess access = LogAccess.DEVELOPER;
	public Date date;
	public List<LogDetail> details = new ArrayList<LogDetail>();

	public LogModel(String logID, Object userID, LogLevel level, LogAccess access, Exception exception) {
		this.logID = logID;
		this.userID = userID;
		this.level = level;
		this.access = access;
		this.addDetail(exception);
	}

	public LogModel(String logID, Object userID, LogLevel level, LogAccess access, Exception exception,
			Object instance) {
		this(logID, userID, level, access, exception);
		this.addDetail(exception);
	}

	public LogModel(String logID, String userID, LogLevel info, LogAccess access, String message) {
		// TODO Auto-generated constructor stub
	}

	public void addDetail(Exception exception) {
		switch (this.getLevel()) {
		case INFO:
			this.addDetail(exception.getMessage());
			break;
		case WARN:
			this.addDetail(exception.getMessage());
			break;
		case ERROR:
			StringBuilder builder = new StringBuilder();
			builder.append(exception.getClass().getName() + ":" + exception.getMessage());
			for (StackTraceElement element : exception.getStackTrace()) {
				builder.append("\n" + element);
			}
			this.addDetail(builder.toString());
			break;
		default:
			break;
		}
	}

	public void addDetail(String message) {
		LogDetail detail = new LogDetail(this, message);
		this.getDetails().add(detail);
	}

	public List<LogDetail> getDetails() {
		return details;
	}

	public void setDetails(List<LogDetail> details) {
		this.details = details;
	}

	public LogLevel getLevel() {
		return level;
	}

	public static void main(String[] args) {
		try {
		  throw new NullPointerException("Excs");
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("===============================");
		for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
			System.out.println(element);
		}
	}

}