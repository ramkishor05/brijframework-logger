package org.brijframework.logger.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public class LoggerUtil {

	public static FileWriter logWriter = null;

	public static String logDirPath = System.getProperty("user.dir");

	private static String header() {
		return  "\r\n************************************************************\r\n\t\t"+new Date();
	}

	private static String footer() {
		return  "\r\n************************************************************\r\n";
	}

	public static void writeLog(String err) {
		try {
			if (logWriter == null) {
				Calendar date = LoggerUtil.currentDate(0);
				String dateString = LoggerUtil.dateString(date);
				File logFile = new File(getLogDir(), "LOG_" + dateString + ".txt");
				String fileName = logFile.getAbsolutePath();
				logWriter = new FileWriter(fileName, true);
				logWriter.write(header());
				logWriter.flush();
				logWriter.write(footer());
			}
			logWriter.write(err + System.getProperty("line.separator"));
			logWriter.flush();

		} catch (IOException e) {
			System.err.println("Error in creating log file" + e.getMessage());
		}
	}
	
	public static File getLogDir(String rootDirPath) {
		File logDir = new File(rootDirPath, "log");
		if (!logDir.exists()) {
			logDir.mkdirs();
		}
		return logDir;
	}
	
	public static File getLogDir() {
		File logDir = new File(logDirPath, "log");
		if (!logDir.exists()) {
			logDir.mkdirs();
		}
		return logDir;
	}

	@SuppressWarnings("unchecked")
	public static <T>T getSingletonInstance(Class<?> clazz) {
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getDeclaredConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		constructor.setAccessible(true);
		Object object = null;
		try {
			object = constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		return (T) object;
	}

	public static Calendar currentDate(int offSet) {
		Calendar date = Calendar.getInstance();
		date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		date.add(Calendar.MILLISECOND, -1 * date.get(Calendar.MILLISECOND));
		date.add(Calendar.DAY_OF_YEAR, -1 * offSet);
		return date;
	}

	/// Date Function
	public static String dateString(Calendar calendar) {
		String YY = (calendar.get(Calendar.YEAR) + "");
		String MM = ((calendar.get(Calendar.MONTH) + 1) + "");
		String DD = (calendar.get(Calendar.DAY_OF_MONTH) + "");

		if (MM.length() == 1) {
			MM = "0" + MM;
		}
		if (DD.length() == 1) {
			DD = "0" + DD;
		}
		return (YY + "_" + MM + "_" + DD);
	}

	public static boolean isEmpty(final Object _v) {
		// Note: do not use parameter overloading, confuses Rhino with null values.
		if (_v == null) {
			return true;
		}
		if (_v instanceof String) {
			/* we trim for convenience, should be what one usually wants */
			final String s = ((String) _v).trim();
			return s.length() == 0;
		}
		if (_v instanceof Map) {
			return ((Map<?, ?>) _v).size() == 0;
		}
		if (_v instanceof Collection) {
			return ((Collection<?>) _v).size() == 0;
		}
		if (_v.getClass().isArray()) {
			return ((Object[]) _v).length == 0;
		}
		return false;
	}

	public static File[] sortFilesByDate(File[] files) {
		Arrays.sort(files, new Comparator<Object>() {
			public int compare(Object f1, Object f2) {
				if (((File) f1).lastModified() < ((File) f2).lastModified()) {
					return 1;
				} else if (((File) f1).lastModified() > ((File) f2).lastModified()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		return files;
	}
}
