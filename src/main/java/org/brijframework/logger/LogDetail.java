package org.brijframework.logger;

import java.util.Date;

public class LogDetail {
	private Date date;
	private Object object;
	private String message;
	private LogModel model;

	public LogDetail(LogModel model) {
	    this.model=model;
		this.setDate( new Date());
	}

	public LogDetail(LogModel model,String message) {
	    this(model);
		this.setMessage(message);
	}
	
	public LogDetail(LogModel model,String message,Object instance){
	     this(model,message);
	     this.setObject(instance);
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
	
	public LogModel getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		builder.append(getModel().logID);
		builder.append("|");
		builder.append(getModel().userID);
		builder.append("|");
		builder.append(this.getDate());
		builder.append("|");
		builder.append(this.getMessage());
		return builder.toString();
	}
}
