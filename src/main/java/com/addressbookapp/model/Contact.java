package com.addressbookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Contact contact = (Contact) obj;

		return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public String toString() {

		return firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zip + " | "
				+ phoneNumber + " | " + email;
	}
}