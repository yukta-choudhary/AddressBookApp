package com.addressbookapp.service;

import com.addressbookapp.manager.AddressBookManager;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressBookSearchTest {

	@Autowired
	private AddressBookService service;

	@Autowired
	private AddressBookManager manager;

	@BeforeEach
	void setup() {

		manager.addAddressBook("Friends");

		Contact c1 = new Contact("Raj", "K", "A", "Bhopal", "MP", "1", "1", "a");
		Contact c2 = new Contact("Rahul", "S", "A", "Indore", "MP", "1", "1", "a");

		service.addContact("Friends", c1);
		service.addContact("Friends", c2);
	}

	@Test
	void testSearchByCity() {

		List<Contact> results = service.searchByCity("Bhopal");

		assertEquals(1, results.size());
	}

	@Test
	void testSearchByState() {

		List<Contact> results = service.searchByState("MP");

		assertEquals(2, results.size());
	}

	@Test
	void testGroupByCity() {

		Map<String, List<Contact>> map = service.getPersonsByCity();

		assertTrue(map.containsKey("Bhopal"));
	}

	@Test
	void testCountByCity() {

		Map<String, Long> result = service.getContactCount(Contact::getCity);

		assertEquals(1, result.get("Bhopal"));
	}
}