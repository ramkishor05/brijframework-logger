package org.brijframework.logger.exception;

import org.brijframework.logger.Logger;
import org.brijframework.logger.constant.LogAccess;
import org.brijframework.logger.constant.LogLevel;
import org.brijframework.logger.container.LoggerContainer;

public class LogException extends RuntimeException {
	/**
	 * 
	 */
	static LoggerContainer loggerContainer = LoggerContainer.getContainer();
	private static final long serialVersionUID = 1L;
	public LogException() {
	}
	public LogException(String logID, LogAccess access, Object obj, String message, LogLevel level) {
		super(message, new Throwable(message));
		switch (level) {
		case TRACE:
			Logger.trace(logID, access, obj, this, message);
			break;
		case DEBUG:
			Logger.debug(logID, access, obj, this, message);
			break;
		case INFO:
			Logger.info(logID, access, obj, this, message);
			break;
		case WARN:
			Logger.warning(logID, access, obj, this, message);
			break;
		case ERROR:
			Logger.error(logID, access, obj, this, message);
			break;
		default:
			break;
		}
	}

}
