package org.brijframework.logger.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.brijframework.logger.util.LoggerUtil;

public class TrasherContainer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> trashContainer = new ConcurrentHashMap<>();

	private static TrasherContainer container = null;

	public static TrasherContainer getContainer() {
		if (container == null) {
			container = (TrasherContainer) LoggerUtil.getSingletonInstance(TrasherContainer.class);
		}
		return container;
	}

	public Object addContainer(String key, ConcurrentHashMap<String, Object> obj) {
		return this.trashContainer.put(key, obj);
	}
	
	@SuppressWarnings("unchecked")
	public Object addContainer(String key, String subKey, Object obj) {
		if (this.trashContainer.get(key) == null) {
			this.trashContainer.put(key, new ConcurrentHashMap<>());
		}
		if (this.trashContainer.get(key).get(subKey) == null) {
			this.trashContainer.get(key).put(subKey, new ArrayList<Object>());
		}
		ArrayList<Object> arrayList = (ArrayList<Object>) this.trashContainer.get(key).get(subKey);
		arrayList.add(obj);
		return this.trashContainer.get(key).get(subKey);
	}

	public Object removeContainer(String key) {
		return this.trashContainer.remove(key);
	}

	public Object removeContainer(String key, String subKey) {
		return this.trashContainer.get(key).remove(key);
	}

	public Object updateContainer(String key, ConcurrentHashMap<String, Object> map) {
		return this.trashContainer.replace(key, map);
	}

	public Object updateContainer(String key, String subKey, Object map) {
		return this.trashContainer.get(key).replace(subKey, map);
	}

	public Object getContainer(String key) {
		return this.trashContainer.get(key);
	}

	public Object getContainer(String key, String subKey) {
		return this.trashContainer.get(key).get(subKey);
	}

	public Object searchContainer(String key, String subKey) {
		return this.trashContainer.get(key).get(subKey);
	}

	public ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> getCache() {
		return this.trashContainer;
	}

	public ConcurrentHashMap<String, Object> getCache(String innerKey) {
		return this.trashContainer.get(innerKey);
	}


}
