# Getting Started

# How To Run

java -jar target/randomeAddressGenerator-0.0.1-SNAPSHOT.jar
in target folder
mvn spring-boot:run

# Verify Test Coverage

mvn clean verify

jcoco file in below location
/target/site/jacoco/index.html

Current coverage 100%

## To Generate Random Addresses for USA, Mexico, Canada, Netherlands

This project will help to generate Randome address with city name country, etc randomally using a java Faker api.
The address generated is a fake address, may not be validate with USPS address.

http://localhost:8080/randomizer/address will generate a randome address in json format with below details.

{
	"house": "98118",
	"street": "Hauck Valleys",
	"postalCode": "83626",
	"city": "Baumbachstad",
	"county": null,
	"state": "South Carolina",
	"stateCode": "CO",
	"country": "Norway",
	"countryCode": "US"
}


