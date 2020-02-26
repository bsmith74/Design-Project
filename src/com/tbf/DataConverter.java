/*
* Authors: Brady Smith and Sam Briggs
* Class: CSCE 156
* Purpose: A program to read a DAT file and convert it into a JSON file.
*/
package com.tbf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataConverter {
	public static void main(String args[]) {

		File personsInput = new File("data/Persons.dat");
		File assetsInput = new File("data/Assets.dat");
		File personsOutput = new File("data/Persons.json");
		File assetsOutput = new File("data/Assets.json");

		Scanner s = null;
		ArrayList<Customer> persons = new ArrayList<Customer>();
		// scan persons input file
		try {
			s = new Scanner(personsInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// stored number of persons
		int personsSize = Integer.parseInt(s.nextLine());
		// scan file line by line by tokenizing elements
		while (s.hasNextLine()) {
			String line = s.nextLine();
			// check if line contains data
			if (!line.trim().isEmpty()) {
				Customer p = null;
				String[] tokens = new String[5];
				tokens = line.split(";", 5);
				String[] nameTokens = tokens[2].split(",");
				String[] email = null;
				// check to see if email exists
				if (!tokens[4].trim().isEmpty()) {
					email = tokens[4].split(",");
				}
				Address a = null;
				// check to see if address exists
				if (!tokens[3].trim().isEmpty()) {
					String[] addressTokens = tokens[3].split(",");
					a = new Address(addressTokens[0], addressTokens[1], addressTokens[2], addressTokens[3],
							addressTokens[4]);
				}
				// check if broker field contains any values
				if (!tokens[1].trim().isEmpty()) {
					String[] brokerTokens = tokens[1].split(",");
					// broker is stored in expert or junior subclass depending on type
					if (brokerTokens[0].equals("E")) {
						p = new Expert(tokens[0], nameTokens[1], nameTokens[0], a, email, brokerTokens[1]);
					} else if (brokerTokens[0].equals("J")) {
						p = new Junior(tokens[0], nameTokens[1], nameTokens[0], a, email, brokerTokens[1]);
					}
				} else {
					// if broker field is empty, then store as person
					p = new Person(tokens[0], nameTokens[1], nameTokens[0], a, email);
				}
				persons.add(p);
			}
		}
		// scan assets input
		try {
			s = new Scanner(assetsInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Asset> assets = new ArrayList<Asset>();
		// store number of assets
		int assetsSize = Integer.parseInt(s.nextLine());
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (!line.trim().isEmpty()) {
				Asset a = null;
				String[] tokens = line.split(";");
				// check type of asset and store into subclass depending on type
				if (tokens[1].equals("D")) {
					double apr = 0.000000;
					// error checking and creating deposit
					if (!tokens[3].trim().isEmpty()) {
						apr = Double.parseDouble(tokens[3])/100;
						if (apr < 0 || apr > 100) {
							System.out.println("Invalid apr");
							System.exit(0);
						}
						a = new Deposit(tokens[0], tokens[2], apr);
					} else {
						System.out.println("No apr found");
						System.exit(0);
					}
				} else if (tokens[1].equals("S")) {
					double quarterlyDividend = 0.0, baseRateOfReturn = 0.0, betaMeasure = 0.0, sharePrice = 0.0;
					// check if tokens contain values
					if (tokens[3].trim().isEmpty() || tokens[4].trim().isEmpty() || tokens[5].trim().isEmpty()
							|| tokens[7].trim().isEmpty()) {
						System.out.println("Missing Value(s) Stock");
						System.exit(0);
					} else {
						quarterlyDividend = Double.parseDouble(tokens[3]);
						baseRateOfReturn = Double.parseDouble(tokens[4])/100;
						betaMeasure = Double.parseDouble(tokens[5]);
						sharePrice = Double.parseDouble(tokens[7]);
						// error checking
						if (baseRateOfReturn < 0 || baseRateOfReturn > 100 || betaMeasure < -100 || betaMeasure > 100
								|| quarterlyDividend < 0 || sharePrice < 0) {
							System.out.println("Invalid values");
							System.exit(0);
						}
						a = new Stock(tokens[0], tokens[2], quarterlyDividend, baseRateOfReturn, betaMeasure, tokens[6],
								sharePrice);
					}
				} else if (tokens[1].equals("P")) {
					double quarterlyDividend = 0.0, baseRateOfReturn = 0.0, baseOmegaMeasure = 0.0, totalValue = 0.0;
					//check if tokens contain values
					if (tokens[3].trim().isEmpty() || tokens[4].trim().isEmpty() || tokens[5].trim().isEmpty()
							|| tokens[6].trim().isEmpty()) {
						System.out.println("Missing Value(s)");
						System.exit(0);
					} else {
						quarterlyDividend = Double.parseDouble(tokens[3]);
						baseRateOfReturn = Double.parseDouble(tokens[4])/100;
						baseOmegaMeasure = Double.parseDouble(tokens[5]);
						totalValue = Double.parseDouble(tokens[6]);
						//error checking
						if (baseRateOfReturn < 0 || baseRateOfReturn > 100 || baseOmegaMeasure < -100
								|| baseOmegaMeasure > 100 || quarterlyDividend < 0 || totalValue < 0) {
							System.out.println("Invalid values");
							System.exit(0);
						}
						a = new Investment(tokens[0], tokens[2], quarterlyDividend, baseRateOfReturn, baseOmegaMeasure,
								totalValue);
					}
				}
				assets.add(a);
			}
		}
		PrintWriter p = null;
		//printing JSON formatting
		try {
			p = new PrintWriter(personsOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.printf("{\n\"persons\": [\n");
		for (int i = 0; i < personsSize; i++) {
			if (i == personsSize - 1) {
				p.printf("  {\n    %s\n  }\n]}", persons.get(i).toString());
				break;
			}
			p.printf("  {\n    %s\n  },\n", persons.get(i).toString());
		}
		p.close();
		try {
			p = new PrintWriter(assetsOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.printf("{\n\"assets\": [\n");
		for (int i = 0; i < assetsSize; i++) {
			if (i == assetsSize - 1) {
				p.printf("  {\n    %s\n  }\n]}", assets.get(i).toString());
				break;
			}
			p.printf("  {\n    %s\n  },\n", assets.get(i).toString());
		}
		p.close();
	}
}
