package com.addressbookapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.addressbookapp.model.Contact;

@SpringBootApplication
public class AddressBookAppApplication {

	public static void main(String[] args) {
		
		/* To stop a task on port */
		SpringApplication app = new SpringApplication(AddressBookAppApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		ConfigurableApplicationContext context = app.run(args);

		System.out.println("Welcome to Address Book");
		
		Contact contact = new Contact("John", "Doe", "Indrapuri", "Bhopal", "Madhya Pradesh", "462022",
				"9876543210", "johndoe@email.com");

		System.out.println(contact);

	}
}