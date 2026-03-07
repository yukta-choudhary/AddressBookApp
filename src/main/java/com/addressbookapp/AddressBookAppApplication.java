package com.addressbookapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AddressBookAppApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(AddressBookAppApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);

		ConfigurableApplicationContext context = app.run(args);

		System.out.println("Welcome to Address Book");

	}
}