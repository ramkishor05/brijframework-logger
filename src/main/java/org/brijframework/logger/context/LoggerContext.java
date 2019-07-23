package org.brijframework.logger.context;

import org.brijframework.asm.context.AbstractModuleContext;
import org.brijframework.logger.container.LoggerContainer;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.ReflectionUtils;

public class LoggerContext extends AbstractModuleContext{

	@Override
	@SuppressWarnings("unchecked")
	public void init() {
		try {
			ReflectionUtils.getClassListFromExternal().forEach(cls->{
				if(LoggerContainer.class.isAssignableFrom(cls) && InstanceUtil.isAssignable(cls)) {
					register((Class<? extends LoggerContainer>) cls);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ReflectionUtils.getClassListFromInternal().forEach(cls->{
				if(LoggerContainer.class.isAssignableFrom(cls) && InstanceUtil.isAssignable(cls)) {
					register((Class<? extends LoggerContainer>) cls);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start() {
		System.err.println("DataContext register start.");
		super.start();
		System.err.println("DataContext register done.");
	}

	@Override
	public void stop() {
		System.err.println("DataContext destory start.");
		super.stop();
		System.err.println("DataContext destory done.");
	}
	
}
