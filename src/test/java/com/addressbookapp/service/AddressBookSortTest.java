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
class AddressBookSortTest {

	@Autowired
	private AddressBookService service;

	@Autowired
	private AddressBookManager manager;

	@BeforeEach
	void setup() {

		manager.addAddressBook("Friends");

		Contact c1 = new Contact("Z", "A", "A", "B", "MP", "1", "1", "a");
		Contact c2 = new Contact("A", "A", "A", "B", "MP", "1", "1", "a");

		service.addContact("Friends", c1);
		service.addContact("Friends", c2);
	}

	@Test
	void testSortByName() {

		List<Contact> sorted = service.sortContactsByName("Friends");

		assertEquals("A", sorted.get(0).getFirstName());
	}
}