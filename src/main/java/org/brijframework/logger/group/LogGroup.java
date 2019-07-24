package org.brijframework.logger.group;

import java.util.concurrent.ConcurrentHashMap;

import org.brijframework.asm.group.DefaultGroup;
import org.brijframework.logger.model.LoggerDetail;

public class LogGroup implements DefaultGroup{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConcurrentHashMap<Object,LoggerDetail> cache=new ConcurrentHashMap<Object,LoggerDetail>();
	private Object groupKey;
	
	public LogGroup(Object groupKey) {
		this.groupKey=groupKey;
	}

	@Override
	public Object getGroupKey() {
		return groupKey;
	}
	
	public void setGroupKey(Object groupKey) {
		this.groupKey = groupKey;
	}

	@Override
	public ConcurrentHashMap<Object,LoggerDetail> getCache() {
		return cache;
	}

	@Override
	public <T> T find(String parentID, Class<?> type) {
		return null;
	}
}
