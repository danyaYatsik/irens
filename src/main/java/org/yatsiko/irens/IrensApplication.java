package org.yatsiko.irens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class IrensApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrensApplication.class, args);
	}

}
