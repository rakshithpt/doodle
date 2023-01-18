package com.jsp.jspwfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication

public class JspWfmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspWfmApplication.class, args);
	}

}
