package com.quickpharma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) //exclude security added extra
public class QuickPharmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickPharmaApplication.class, args);
	}

}
