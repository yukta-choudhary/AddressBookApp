package com.addressbookapp.rest;

import com.addressbookapp.manager.AddressBookManager;
import com.addressbookapp.model.Contact;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookJSONServerDeleteTest {

	@Test
	void givenContact_whenDeleted_shouldSyncWithAddressBook() {

		RestAssured.baseURI = "http://localhost:3000";

		int contactId = 1;

		Response deleteResponse = RestAssured.given().when().delete("/contacts/" + contactId);

		assertEquals(200, deleteResponse.getStatusCode());

		Response getResponse = RestAssured.given().when().get("/contacts");

		List<Contact> serverContacts = getResponse.jsonPath().getList("", Contact.class);

		AddressBookManager manager = new AddressBookManager();
		manager.addAddressBook("Friends");

		manager.getAddressBook("Friends").getContacts().addAll(serverContacts);

		assertEquals(serverContacts.size(), manager.getAddressBook("Friends").getContacts().size());
	}
}