package com.util;

import org.apache.log4j.Logger;


public class Log {

	private static final Logger logger = Logger.getRootLogger();

	private Log(){}
	
	public static Logger getLogger() {
		return logger;
	}
	
	
}
