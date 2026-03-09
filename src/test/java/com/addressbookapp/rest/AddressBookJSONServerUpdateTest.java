package com.addressbookapp.rest;

import com.addressbookapp.manager.AddressBookManager;
import com.addressbookapp.model.Contact;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookJSONServerUpdateTest {

	@Test
	void givenContact_whenUpdated_shouldSyncWithAddressBook() {

		RestAssured.baseURI = "http://localhost:3000";

		Contact updatedContact = new Contact("Aryaman", "Kushwaha", "Arera Colony", "Bhopal", "MP", "462016",
				"9999999999", "aryaman_new@gmail.com");

		int contactId = 1;

		Response updateResponse = RestAssured.given().contentType("application/json").body(updatedContact).when()
				.put("/contacts/" + contactId);

		assertEquals(200, updateResponse.getStatusCode());

		Response getResponse = RestAssured.given().when().get("/contacts");

		List<Contact> serverContacts = getResponse.jsonPath().getList("", Contact.class);

		AddressBookManager manager = new AddressBookManager();
		manager.addAddressBook("Friends");

		manager.getAddressBook("Friends").getContacts().addAll(serverContacts);

		assertEquals(serverContacts.size(), manager.getAddressBook("Friends").getContacts().size());
	}
}