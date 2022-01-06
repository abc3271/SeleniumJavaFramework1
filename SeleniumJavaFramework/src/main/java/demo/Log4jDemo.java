package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	public static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {

		System.out.println("Hello World...");
		
		logger.trace("Trace message here");
		logger.info("This is information message");
		logger.error("This is an error message");
		logger.warn("Warning");
		logger.fatal("Fatal Error");
		
		System.out.println("Completed!");
	}

}
