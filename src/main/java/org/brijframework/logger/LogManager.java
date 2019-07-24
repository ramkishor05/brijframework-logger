package org.brijframework.logger;

import java.util.UUID;

import org.brijframework.logger.user.LogUser;

public class LogManager {

	public Object setLoggerID(Object requestID, Object sessionID, Object userID) {
		LogUser logUser = new LogUser();
		logUser.requestID = requestID;
		logUser.sessionID = sessionID;
		logUser.userID = userID;
		return logUser;
	}

	public Object setRandomLoggerID(Object sessionID, Object userID) {
		UUID uuid = UUID.randomUUID();
		LogUser logUser = new LogUser();
		logUser.requestID = uuid.toString().replaceAll("-", "");
		logUser.sessionID = sessionID;
		logUser.userID = userID;
		return uuid.toString();
	}

	public Object setDefultKeyRandomID() {
		UUID uuid = UUID.randomUUID();
		LogUser logUser = new LogUser();
		logUser.requestID = uuid.toString().replaceAll("-", "");
		logUser.sessionID = System.getProperty("user.name");
		logUser.userID = System.getProperty("user.name");
		return uuid.toString();
	}
}
