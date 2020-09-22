package com.random.addressgenerator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.random.addressgenerator.model.Address;

@Service
public class RandomAddressGeneratorServiceImpl implements RandomAddressGeneratorService {

	public Address generateAddress() {

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
		return address;
	}

}
