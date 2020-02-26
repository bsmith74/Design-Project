/*
 * Class to contain all persons files, contains subclasses for expert and junior brokers
*/
package com.tbf;


public abstract class Customer {
	private String personCode;
	private String firstName;
	private String lastName;
	private Address address;
	private String[] email;

	public String getPersonCode() {
		return personCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	public String[] getEmail() {
		return email;
	}
	//returns a string formatted for JSON of all the emails in email array
	public String getEmailString() {
		if(email == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<email.length; i++) {
			if(i == email.length - 1) {
				sb.append("\n      \"" + email[i] + "\"\n");
				break;
			}
			sb.append("\n      \"" + email[i] + "\",");
		}
		return sb.toString();
	}

	public Customer(String personCode, String firstName, String lastName, Address address, String[] email) {
		super();
		this.personCode = personCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}
	//function returns string formatted to JSON specifications
	public abstract String toString();
}

class Person extends Customer {

	public Person(String personCode, String firstName, String lastName, Address address, String[] email) {
		super(personCode, firstName, lastName, address, email);
	}

	public String toString() {
		return "\"Person Code\":\"" + getPersonCode() + "\",\n    \"First Name\": \"" + getFirstName() + "\",\n    \"Last Name\": \"" + getLastName() + "\",\n    \"address\": {\n" + this.getAddress() + "\n    },\n"
				+ "    \"emails\": [" + getEmailString() + "    ]";
	}

}

abstract class Broker extends Customer {
	private String sec;

	public String getSec() {
		return sec;
	}

	public Broker(String personCode, String firstName, String lastName, Address address, String[] email, String sec) {
		super(personCode, firstName, lastName, address, email);
		this.sec = sec;
	}

}

class Expert extends Broker {
	public String getType() {
		return "E";
	}

	public Expert(String personCode, String firstName, String lastName, Address address, String[] email, String sec) {
		super(personCode, firstName, lastName, address, email, sec);
	}

	public String toString() {
		return "\"Person Code\":\"" + getPersonCode() + "\",\n    \"secIdentifier\": \"" + getSec() + "\",\n    \"type\": \"" + getType() + "\",\n    \"First Name\": \"" + getFirstName() + "\",\n    \"Last Name\": \"" + getLastName() + "\",\n    \"address\": {\n" + this.getAddress() + "\n    },\n"
				+ "    \"emails\": [" + getEmailString() + "    ]";
	}

}

class Junior extends Broker {
	public String getType() {
		return "J";
	}

	public Junior(String personCode, String firstName, String lastName, Address address, String[] email, String sec) {
		super(personCode, firstName, lastName, address, email, sec);
	}

	public String toString() {
		return "\"Person Code\":\"" + getPersonCode() + "\",\n    \"secIdentifier\": \"" + getSec() + "\",\n    \"type\": \"" + getType() + "\",\n    \"First Name\": \"" + getFirstName() + "\",\n    \"Last Name\": \"" + getLastName() + "\",\n    \"address\": {\n" + this.getAddress() + "\n    },\n"
				+ "    \"emails\": [" + getEmailString() + "    ]";
	}

}
