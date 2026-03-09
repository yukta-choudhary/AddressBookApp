package com.addressbookapp.rest;

import com.addressbookapp.manager.AddressBookManager;
import com.addressbookapp.model.Contact;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookJSONServerAddTest {

	@Test
	void givenMultipleContacts_whenAdded_shouldSyncWithAddressBook() {

		RestAssured.baseURI = "http://localhost:3000";

		List<Contact> contactsToAdd = new ArrayList<>();

		contactsToAdd.add(
				new Contact("Rahul", "Sharma", "Delhi", "Delhi", "Delhi", "110001", "9876543210", "rahul@gmail.com"));

		contactsToAdd.add(
				new Contact("Priya", "Verma", "Indore", "Indore", "MP", "452001", "9876543211", "priya@gmail.com"));

		contactsToAdd.add(new Contact("Amit", "Patel", "Ahmedabad", "Ahmedabad", "Gujarat", "380001", "9876543212",
				"amit@gmail.com"));

		for (Contact contact : contactsToAdd) {

			Response response = RestAssured.given().contentType("application/json").body(contact).when()
					.post("/contacts");

			assertEquals(201, response.getStatusCode());
		}

		Response getResponse = RestAssured.given().when().get("/contacts");

		List<Contact> serverContacts = getResponse.jsonPath().getList("", Contact.class);

		AddressBookManager manager = new AddressBookManager();
		manager.addAddressBook("Friends");

		manager.getAddressBook("Friends").getContacts().addAll(serverContacts);

		assertEquals(serverContacts.size(), manager.getAddressBook("Friends").getContacts().size());
	}
}