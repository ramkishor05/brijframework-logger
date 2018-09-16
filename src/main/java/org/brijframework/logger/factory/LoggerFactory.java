package org.brijframework.logger.factory;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.brijframework.logger.util.LoggerUtil;

public class LoggerFactory {

	private static LoggerFactory factory;
	
	public static LoggerFactory getFactory() {
		if(factory==null) {
			synchronized (LoggerFactory.class) {
				factory=(LoggerFactory) LoggerUtil.getSingletonInstance(LoggerFactory.class);
			}
		}
		return factory;
	}
	
	
	public List<Logger> forLog(String date){
		return null;
	}
	
	public List<Logger> forLog(Date date){
		return null;
	}
	
}
