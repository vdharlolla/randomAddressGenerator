package com.random.addressgenerator.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.random.addressgenerator.exception.RandomAddressGeneratorException;
import com.random.addressgenerator.model.Address;
import com.random.addressgenerator.service.RandomAddressGeneratorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
@ComponentScan("com.random.addressgenerator")
public class RandomAddressGeneratorController {

	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	RandomAddressGeneratorService addressGeneratorService;

	@GetMapping(value = "/info", produces = "text/plain")
	public String info() {
		logger.debug("in info method");
		return "Welcome to Randome Address Generator App / Helps to Generate Any Address in " + "US\n" + "Canada\n"
				+ "Mexico\n" + "Netherlands  ";
	}

	@ApiOperation(value = "Generate Address", notes = "Generates Random Address ", response = Address.class)
	@ApiResponses({
			@ApiResponse(code = 400, message = " Error while generating address", response = RandomAddressGeneratorException.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Exception.class) })
	@GetMapping(value = "/randomizer/address", produces = MediaType.APPLICATION_JSON_VALUE)
	public Address generateAddress() {
		return addressGeneratorService.generateAddress();
	}
}