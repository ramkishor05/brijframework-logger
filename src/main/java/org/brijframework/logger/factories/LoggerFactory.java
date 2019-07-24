package org.brijframework.logger.factories;

import java.util.Date;
import java.util.List;

import org.brijframework.asm.factories.AbstractFactory;
import org.brijframework.logger.model.LoggerDetail;
import org.brijframework.logger.util.LoggerUtil;
import org.brijframework.support.config.Assignable;

public class LoggerFactory extends AbstractFactory<String, LoggerDetail>{

	private static LoggerFactory factory;
	
	@Assignable
	public static LoggerFactory getFactory() {
		if(factory==null) {
			synchronized (LoggerFactory.class) {
				factory=(LoggerFactory) LoggerUtil.getSingletonInstance(LoggerFactory.class);
			}
		}
		return factory;
	}
	
	public List<LoggerDetail> forLog(String date){
		return null;
	}
	
	public List<LoggerDetail> forLog(Date date){
		return null;
	}

	@Override
	public LoggerFactory loadFactory() {
		return this;
	}

	@Override
	protected void preregister(String key, LoggerDetail value) {
	}

	@Override
	protected void postregister(String key, LoggerDetail value) {
	}
	
}
