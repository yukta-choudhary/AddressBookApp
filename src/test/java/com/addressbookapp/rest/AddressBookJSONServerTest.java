package com.addressbookapp.rest;

import com.addressbookapp.manager.AddressBookManager;
import com.addressbookapp.model.Contact;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookJSONServerTest {

	@Test
	void givenContactsInJSONServer_whenRetrieved_shouldMatchCount() {

		RestAssured.baseURI = "http://localhost:3000";

		Response response = RestAssured.given().when().get("/contacts");

		System.out.println(response.asString());

		List<Contact> contacts = response.jsonPath().getList("", Contact.class);

		AddressBookManager manager = new AddressBookManager();
		manager.addAddressBook("Friends");

		manager.getAddressBook("Friends").getContacts().addAll(contacts);

		assertEquals(contacts.size(), manager.getAddressBook("Friends").getContacts().size());
	}
}