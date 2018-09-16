package org.brijframework.logger.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.brijframework.config.Configration;
import org.brijframework.logger.config.LogConfigration;
import org.brijframework.logger.util.LoggerUtil;

public class ConfigrationFactory {

	private org.brijframework.config.Configration configration;
	
	private static ConfigrationFactory factory;
	
	public static ConfigrationFactory getFactory() {
		if(factory==null) {
			synchronized (ConfigrationFactory.class) {
				factory=(ConfigrationFactory) LoggerUtil.getSingletonInstance(ConfigrationFactory.class);
			}
		}
		return factory;
	}
	
	public Configration getConfigration() {
		return configration;
	}
	
	public Configration setConfigration(File configration) {
		Properties properties=new Properties();
		try {
			properties.load(new FileInputStream(configration));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.configration;
	}
	
	public void setConfigration(Properties properties) {
		this.configration=new LogConfigration(properties);
	}
	
}
