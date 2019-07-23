package org.brijframework.logger.container;

import org.brijframework.asm.container.AbstractContainer;
import org.brijframework.group.Group;
import org.brijframework.logger.factories.LoggerFactory;
import org.brijframework.logger.group.LogGroup;
import org.brijframework.logger.util.LoggerUtil;
import org.brijframework.support.config.Assignable;
import org.brijframework.util.reflect.InstanceUtil;
import org.brijframework.util.reflect.ReflectionUtils;


public class LoggerContainer extends AbstractContainer {
	
	private static LoggerContainer container = null;

	@Assignable
	public static LoggerContainer getContainer() {
		if (container == null) {
			container = (LoggerContainer) LoggerUtil.getSingletonInstance(LoggerContainer.class);
		}
		return container;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		try {
			ReflectionUtils.getClassListFromExternal().forEach(cls -> {
				if (LoggerFactory.class.isAssignableFrom(cls) && InstanceUtil.isAssignable(cls)) {
					register((Class<? extends LoggerFactory>) cls);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ReflectionUtils.getClassListFromInternal().forEach(cls -> {
				if (LoggerFactory.class.isAssignableFrom(cls) && InstanceUtil.isAssignable(cls)) {
					register((Class<? extends LoggerFactory>) cls);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Group load(Object groupKey) {
		Group group=get(groupKey);
		if(group==null) {
			group=new LogGroup(groupKey);
			this.add(groupKey, group);
		}
		return group;
	}
}
