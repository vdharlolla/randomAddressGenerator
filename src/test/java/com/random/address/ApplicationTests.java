package com.random.address;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.random.addressgenerator.RandomAddressGeneratorApplication;

@RunWith(SpringRunner.class)
class RandomAddressGeneratorApplicationTest {

	@Test
	void contextLoads() {
	}

	@Test
	public void main() {
		RandomAddressGeneratorApplication.main(new String[] {});
		assertNotNull(RandomAddressGeneratorApplication.class);
	}

}
