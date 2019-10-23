package com.helloFresh.utils;

import java.io.IOException;

import com.helloFresh.dataProviders.ConfigFileReader;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

// TODO: Auto-generated Javadoc
/**
 * The Class URLBuilder.
 */
public class URLBuilder {
	
	/** The config. */
	ConfigFileReader config = new ConfigFileReader();
	
	/**
	 * Gets the base URI.
	 *
	 * @return the base URI
	 */
	public RequestSpecification getBaseURI(){
		System.out.println("Base uri: "+config.getBaseURI("BaseUrl"));
		RestAssured.baseURI = config.getBaseURI("BaseUrl");
		RequestSpecification request = RestAssured.given();
		return request;
	}
	
	/**
 * Gets the base URI get booking.
 *
 * @return the base URI get booking
 * @throws IOException Signals that an I/O exception has occurred.
 */
public RequestSpecification getBaseURIGetBooking() throws IOException{
		System.out.println("get booking: "+config.getBaseURI("BaseUrl")+config.testDataFileReader("createdBookingID"));
		RestAssured.baseURI = config.getBaseURI("BaseUrl")+config.testDataFileReader("createdBookingID");
		RequestSpecification request = RestAssured.given();
		return request;
	}

}
