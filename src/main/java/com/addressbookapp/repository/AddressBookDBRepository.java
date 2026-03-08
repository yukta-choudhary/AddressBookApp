package com.addressbookapp.repository;

import com.addressbookapp.model.Contact;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressBookDBRepository {

	private final DataSource dataSource;

	public AddressBookDBRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Contact> getAllContacts() {

		List<Contact> contacts = new ArrayList<>();

		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {

			String query = "SELECT * FROM contacts";

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				Contact contact = new Contact(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getString("zip"),
						rs.getString("phone"), rs.getString("email"));

				contacts.add(contact);
			}

		} catch (Exception e) {
			System.out.println("Database error");
		}

		return contacts;
	}
}