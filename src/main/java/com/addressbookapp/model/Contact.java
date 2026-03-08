package com.addressbookapp.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	@Override
	public String toString() {
		return firstName + " " + lastName + " | " + address + " | " + city + " | " + state + " | " + zip + " | "
				+ phoneNumber + " | " + email;
	}
}