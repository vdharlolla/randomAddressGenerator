package com.random.address.model;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.github.javafaker.Faker;
import com.random.addressgenerator.model.Address;

public class AddressTest {

	Address address;

	@Before
	public void setup() {

		List<String> countries = new ArrayList<>();
		countries.add("en-MX");
		countries.add("en-US");
		countries.add("en-CA");
		countries.add("en-NL");
		Random rand = new Random();
		Faker faker = new Faker(new Locale(countries.get(rand.nextInt(countries.size()))));
		address = new Address();
		address.setCity(faker.address().city());
		address.setCountry(faker.address().country());
		address.setCountryCode(faker.address().countryCode());
		address.setHouse(faker.address().buildingNumber());
		address.setPostalCode(faker.address().zipCode());
		address.setState(faker.address().state());
		address.setStateCode(faker.address().stateAbbr());
		address.setStreet(faker.address().streetName());
		
	}

	@Test
	public void testAddress() {
		assertNotNull(address.getCity());
		assertNotNull(address.getCountry());
		assertNotNull(address.getCountryCode());
		assertNotNull(address.getHouse());
		assertNotNull(address.getPostalCode());
		assertNotNull(address.getState());
		assertNotNull(address.getStateCode());
		assertNotNull(address.getStreet());
	}

}
