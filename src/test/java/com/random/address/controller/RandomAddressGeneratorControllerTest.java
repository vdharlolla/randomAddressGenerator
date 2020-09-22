package com.random.address.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.github.javafaker.Faker;
import com.random.addressgenerator.controller.RandomAddressGeneratorController;
import com.random.addressgenerator.model.Address;
import com.random.addressgenerator.service.RandomAddressGeneratorServiceImpl;

public class RandomAddressGeneratorControllerTest {

	@InjectMocks
	RandomAddressGeneratorController randomAddressGeneratorController;
	
	@Mock
	RandomAddressGeneratorServiceImpl randomAddressGeneratorService ;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRandomAddressGeneratorServiceGetInfo() {
		String response = randomAddressGeneratorController.info();
		assertNotNull(response);
	}

	@Test
	public void testRandomAddressGeneratorServiceGetAddress() {
		List<String> countries = new ArrayList<>();
		countries.add("en-MX");
		countries.add("en-US");
		countries.add("en-CA");
		countries.add("en-NL");
		Random rand = new Random();
		Faker faker = new Faker(new Locale(countries.get(rand.nextInt(countries.size()))));
		Address address = new Address();
		address.setCity(faker.address().city());
		address.setCountry(faker.address().country());
		address.setCountryCode(faker.address().countryCode());
		address.setHouse(faker.address().buildingNumber());
		address.setPostalCode(faker.address().zipCode());
		address.setState(faker.address().state());
		address.setStateCode(faker.address().stateAbbr());
		address.setStreet(faker.address().streetName());
		when(randomAddressGeneratorService.generateAddress()).thenReturn(address);
		Address response = randomAddressGeneratorController.generateAddress();
		assertNotNull(response);
	}

}
