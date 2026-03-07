package com.addressbookapp;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.addressbookapp.model.Contact;
import com.addressbookapp.services.AddressBook;

@SpringBootApplication
public class AddressBookAppApplication {

	public static void main(String[] args) {
		
		/* To stop a task on port */
		SpringApplication app = new SpringApplication(AddressBookAppApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		ConfigurableApplicationContext context = app.run(args);
		

		System.out.println("Welcome to Address Book");

		Scanner scanner = new Scanner(System.in);

		AddressBook addressBook = new AddressBook();

		System.out.println("Enter First Name:");
		String firstName = scanner.nextLine();

		System.out.println("Enter Last Name:");
		String lastName = scanner.nextLine();

		System.out.println("Enter Address:");
		String address = scanner.nextLine();

		System.out.println("Enter City:");
		String city = scanner.nextLine();

		System.out.println("Enter State:");
		String state = scanner.nextLine();

		System.out.println("Enter Zip:");
		String zip = scanner.nextLine();

		System.out.println("Enter Phone Number:");
		String phone = scanner.nextLine();

		System.out.println("Enter Email:");
		String email = scanner.nextLine();

		Contact person = new Contact(firstName, lastName, address, city, state, zip, phone, email);

		addressBook.addContact(person);

		System.out.println("\nContacts in Address Book:");
		addressBook.displayContacts();
	}

}