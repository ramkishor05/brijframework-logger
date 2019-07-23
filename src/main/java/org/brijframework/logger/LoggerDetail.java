package org.brijframework.logger;

import java.io.Serializable;
import java.util.Date;

import org.brijframework.logger.constant.LogAccess;
import org.brijframework.logger.constant.LogLevel;

public class LoggerDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object loggerId;
	private Object sessionId;
	private LogLevel level;
	private Date date;
	private Object object;
	private String message;
	private LogAccess access = LogAccess.DEVELOPER;
	private Exception exception;
	
	public LoggerDetail() {
		this.setDate( new Date());
	}

	public LoggerDetail(String message) {
	    this();
		this.setMessage(message);
	}
	
	public LoggerDetail(String message,Object instance){
	     this(message);
	     this.setObject(instance);
	}
	
	public LoggerDetail(String loggerId, String sessionId, LogLevel level, LogAccess access, Exception exception) {
		this.loggerId=loggerId;
		this.sessionId=sessionId;
		this.level=level;
		this.access=access;
		this.exception=exception;
		if(this.exception!=null) {
			this.message=this.exception.getMessage();
		}
	}

	public LoggerDetail(String loggerId, String sessionId, LogLevel level, LogAccess access) {
		this.loggerId=loggerId;
		this.sessionId=sessionId;
		this.level=level;
		this.access=access;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date logDate) {
		this.date = logDate;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getLoggerId() {
		return loggerId;
	}

	public void setLoggerId(Object loggerId) {
		this.loggerId = loggerId;
	}
	
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public void setSessionId(Object sessionId) {
		this.sessionId = sessionId;
	}
	
	public Exception getException() {
		return exception;
	}
	
	public Object getSessionId() {
		return sessionId;
	}

	public LogLevel getLevel() {
		return level;
	}

	public void setLevel(LogLevel level) {
		this.level = level;
	}

	public LogAccess getAccess() {
		return access;
	}

	public void setAccess(LogAccess access) {
		this.access = access;
	}

	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		builder.append(this.getLevel());
		builder.append("|");
		builder.append(this.getSessionId());
		builder.append("|");
		builder.append(this.getDate());
		builder.append("|");
		builder.append(this.getMessage());
		return builder.toString();
	}
}
