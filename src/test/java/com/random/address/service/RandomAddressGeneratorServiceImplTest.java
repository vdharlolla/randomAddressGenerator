package com.random.address.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.random.addressgenerator.model.Address;
import com.random.addressgenerator.service.RandomAddressGeneratorServiceImpl;

public class RandomAddressGeneratorServiceImplTest {

	@InjectMocks
	RandomAddressGeneratorServiceImpl randomAddressGeneratorService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnAddressWhenRequestedWithValidRequest() {

		Address address = randomAddressGeneratorService.generateAddress();

		assertNotNull(address);
	}
}
