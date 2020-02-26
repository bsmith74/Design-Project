/*
 * Class to store address of a person
 */
package com.tbf;

public class Address {
	private String Street;
	private String City;
	private String State;
	private String Zip;
	private String Country;

	public String getStreet() {
		return Street;
	}

	public String getCity() {
		return City;
	}

	public String getState() {
		return State;
	}

	public String getZip() {
		return Zip;
	}

	public String getCountry() {
		return Country;
	}

	public Address(String street, String city, String state, String zip, String country) {
		super();
		Street = street;
		City = city;
		State = state;
		Zip = zip;
		Country = country;
	}

	//returns string in JSON format
	public String toString() {
		return "      \"street\": \"" + Street + "\",\n      \"city\": \"" + City + "\",\n      \"state\": \"" + State + "\",\n      \"country\": \"" + Country + "\",\n      \"zipcode\": \""
				+ Zip + "\"";
	}
	

}
