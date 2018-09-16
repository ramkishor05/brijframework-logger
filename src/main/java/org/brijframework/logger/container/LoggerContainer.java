package org.brijframework.logger.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.brijframework.logger.constant.LogLevel;
import org.brijframework.logger.util.LoggerUtil;

public class LoggerContainer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> cache = new ConcurrentHashMap<>();

	private static LoggerContainer container = null;

	public static LoggerContainer getContainer() {
		if (container == null) {
			container = (LoggerContainer) LoggerUtil.getSingletonInstance(LoggerContainer.class);
		}
		return container;
	}

	public Object addContainer(String key, ConcurrentHashMap<String, Object> obj) {
		return this.cache.put(key, obj);
	}

	@SuppressWarnings("unchecked")
	public Object addContainer(String key, String subKey, Object obj) {
		if (this.cache.get(key) == null) {
			this.cache.put(key, new ConcurrentHashMap<>());
		}
		if (this.cache.get(key).get(subKey) == null) {
			this.cache.get(key).put(subKey, new ArrayList<Object>());
		}
		ArrayList<Object> arrayList = (ArrayList<Object>) this.cache.get(key).get(subKey);
		arrayList.add(obj);
		return this.cache.get(key).get(subKey);
	}

	public Object removeContainer(String key) {
		return this.cache.remove(key);
	}

	public Object removeContainer(String key, String subKey) {
		return this.cache.get(key).remove(key);
	}

	public Object updateContainer(String key, ConcurrentHashMap<String, Object> map) {
		return this.cache.replace(key, map);
	}

	public Object updateContainer(String key, String subKey, Object map) {
		return this.cache.get(key).replace(subKey, map);
	}

	public Object getContainer(String key) {
		return this.cache.get(key);
	}

	public Object getContainer(String key, String subKey) {
		return this.cache.get(key).get(subKey);
	}

	public Object searchContainer(String key, String subKey) {
		return this.cache.get(key).get(subKey);
	}

	public ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> getCache() {
		return this.cache;
	}

	public ConcurrentHashMap<String, Object> getCache(String innerKey) {
		return this.cache.get(innerKey);
	}

	public Object getTRACEException(String id) {
		if (this.cache.get(LogLevel.TRACE.toString()) == null) {
			return new ArrayList<>();
		}
		return this.cache.get(LogLevel.TRACE.toString()).get(id);
	}

	public Object getDEBUGException(String id) {
		if (this.cache.get(LogLevel.DEBUG.toString()) == null) {
			return new ArrayList<>();
		}
		return this.cache.get(LogLevel.DEBUG.toString()).get(id);
	}

	public Object getINFOException(String id) {
		if (this.cache.get(LogLevel.INFO.toString()) == null) {
			return new ArrayList<>();
		}
		return this.cache.get(LogLevel.INFO.toString()).get(id);
	}

	public Object getWARNINGException(String id) {
		if (this.cache.get(LogLevel.WARN.toString()) == null) {
			return new ArrayList<>();
		}
		return this.cache.get(LogLevel.WARN.toString()).get(id);
	}

	public Object getERRORException(String id) {
		if (this.cache.get(LogLevel.ERROR.toString()) == null) {
			return new ArrayList<>();
		}
		return this.cache.get(LogLevel.ERROR.toString()).get(id);
	}

	public void loadContainer() {
	}
}
