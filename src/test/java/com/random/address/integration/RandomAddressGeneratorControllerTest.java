package com.random.address.integration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.random.addressgenerator.RandomAddressGeneratorApplication;
import com.random.addressgenerator.model.Address;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@ContextConfiguration(classes = { RandomAddressGeneratorApplication.class })
public class RandomAddressGeneratorControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testRandomAddressGeneratorControllerGetAddress() {

		Address address = restTemplate.getForObject("/randomizer/address", Address.class);
		assertNotNull(address);

	}

	@Test
	public void testRandomAddressGeneratorControllerGetInfo() {

		String response = restTemplate.getForObject("/info", String.class);
		assertNotNull(response);

	}

}