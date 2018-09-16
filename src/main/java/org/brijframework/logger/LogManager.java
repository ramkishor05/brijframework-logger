package org.brijframework.logger;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.brijframework.logger.constant.LogConstant;
import org.brijframework.logger.util.LoggerUtil;

public class LogManager {
	static LogManager manager;
	ConcurrentHashMap<Object, Object> cache = new ConcurrentHashMap<>();

	private LogManager() {
	}

	public static LogManager getLogManager() {
		if (manager == null) {
			manager = (LogManager) LoggerUtil.getSingletonInstance(LogManager.class);
		}
		return manager;
	}

	public Object setLoggerID(Object requestID, Object sessionID, Object userID) {
		LogUser logUser = new LogUser();
		logUser.requestID = requestID;
		logUser.sessionID = sessionID;
		logUser.userID = userID;
		this.cache.put(requestID, logUser);
		return logUser;
	}

	public Object setRandomLoggerID(Object sessionID, Object userID) {
		UUID uuid = UUID.randomUUID();
		LogUser logUser = new LogUser();
		logUser.requestID = uuid.toString().replaceAll("-", "");
		logUser.sessionID = sessionID;
		logUser.userID = userID;
		this.cache.put(LogConstant.REQUESTID, logUser);
		return uuid.toString();
	}

	public Object setDefultKeyRandomID() {
		UUID uuid = UUID.randomUUID();
		LogUser logUser = new LogUser();
		logUser.requestID = uuid.toString().replaceAll("-", "");
		logUser.sessionID = System.getProperty("user.name");
		logUser.userID = System.getProperty("user.name");
		this.cache.put(LogConstant.REQUESTID, uuid.toString().replaceAll("-", ""));
		return uuid.toString();
	}

	public Object getLoggerID(Object requestID) {
		return this.cache.get(requestID);
	}

	public Object getLoggerID() {
		this.setDefultKeyRandomID();
		return this.cache.get(LogConstant.REQUESTID);
	}

	
}
