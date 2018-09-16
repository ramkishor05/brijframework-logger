package org.brijframework.logger.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.brijframework.config.Configration;
import org.brijframework.logger.constant.LogLevel;

public class LogConfigration implements Configration {
    
	private String dateformat="";
	private LogLevel level=LogLevel.INFO;
	private static final String CONFIG_FILE="log_configration.properties";
	
	
	public LogConfigration() {
		Properties properties=new Properties();
		try {
			properties.load(new FileInputStream(CONFIG_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
        load(properties);
	}

	public LogConfigration(Properties properties) {
		load(properties);
	}
	
	private void load(Properties properties) {
		if(properties.containsKey("dateformat")){
			this.setDateformat(properties.getProperty("dateformat"));
		}
		if(properties.containsKey("level")){
			this.setLevel(LogLevel.valueOf(properties.getProperty("level")));
		}
	}

	public String getDateformat() {
		return dateformat;
	}

	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	public LogLevel getLevel() {
		return level;
	}

	public void setLevel(LogLevel level) {
		this.level = level;
	}
     
}
