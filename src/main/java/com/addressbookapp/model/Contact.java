package com.addressbookapp.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	@CsvBindByName
	private String firstName;

	@CsvBindByName
	private String lastName;

	@CsvBindByName
	private String address;

	@CsvBindByName
	private String city;

	@CsvBindByName
	private String state;

	@CsvBindByName
	private String zip;

	@CsvBindByName
	private String phoneNumber;

	@CsvBindByName
	private String email;

	// UC18 field
	private LocalDate dateAdded;

	// NEW constructor for old code compatibility
	public Contact(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {

		this(firstName, lastName, address, city, state, zip, phoneNumber, email, null);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zip + " | "
				+ phoneNumber + " | " + email + " | Added: " + dateAdded;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Contact contact = (Contact) obj;

		return firstName.equals(contact.firstName) && lastName.equals(contact.lastName)
				&& address.equals(contact.address) && city.equals(contact.city) && state.equals(contact.state)
				&& zip.equals(contact.zip) && phoneNumber.equals(contact.phoneNumber) && email.equals(contact.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}
}