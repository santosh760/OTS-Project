package com.yash.onlinetrainingsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineTrainingSystemApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(OnlineTrainingSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OnlineTrainingSystemApplication.class, args);
		
		LOGGER.info("Information Data..");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error aaya re..");
	}
}