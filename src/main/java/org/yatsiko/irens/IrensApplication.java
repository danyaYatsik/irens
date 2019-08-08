package org.yatsiko.irens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.yatsiko.irens.utils.PalindromesHelper;

import java.util.List;

@SpringBootApplication
public class IrensApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrensApplication.class, args);
    }

}
