package com.addressbookapp.service;

import com.addressbookapp.manager.AddressBookManager;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressBookServiceTest {

	@Autowired
	private AddressBookService service;

	@Autowired
	private AddressBookManager manager;

	@BeforeEach
	void setup() {
		manager.addAddressBook("Friends");
	}

	@Test
	void testAddContact() {

		Contact contact = new Contact("Rahul", "Singh", "MP Nagar", "Bhopal", "MP", "462001", "9876543210",
				"aryaman@email.com");

		service.addContact("Friends", contact);

		List<Contact> contacts = service.getAllContacts("Friends");

		assertEquals(1, contacts.size());
	}

	@Test
	void testEditContact() {

		Contact contact = new Contact("Rahul", "K", "A", "Bhopal", "MP", "1", "1", "a");

		service.addContact("Friends", contact);

		Contact updated = new Contact();
		updated.setCity("Indore");

		service.editContact("Friends", "Rahul", updated);

		Contact result = service.findContact("Friends", "Rahul");

		assertEquals("Indore", result.getCity());
	}

	@Test
	void testDeleteContact() {

		Contact contact = new Contact("Rahul", "K", "A", "B", "MP", "1", "1", "a");

		service.addContact("Friends", contact);

		service.deleteContact("Friends", "Rahul");

		List<Contact> contacts = service.getAllContacts("Friends");

		assertTrue(contacts.isEmpty());
	}
}