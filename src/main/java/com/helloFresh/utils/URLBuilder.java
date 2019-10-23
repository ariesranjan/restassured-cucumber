package com.helloFresh.utils;

import java.io.IOException;

import com.helloFresh.dataProviders.ConfigFileReader;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class URLBuilder {
	
	ConfigFileReader config = new ConfigFileReader();
	
	public RequestSpecification getBaseURI(){
		System.out.println("Base uri: "+config.getBaseURI("BaseUrl"));
		RestAssured.baseURI = config.getBaseURI("BaseUrl");
		RequestSpecification request = RestAssured.given();
		return request;
	}
	
//	public RequestSpecification getBaseURIForGetBookingsRequest(){
//		System.out.println("Base uri: "+config.getBaseURI("BaseUrl"));
//		RestAssured.baseURI = config.getBaseURI("GetBookingsBaseUrl");
//		RequestSpecification request = RestAssured.given();
//		return request;
//	}
	
	public RequestSpecification getBaseURIGetBooking() throws IOException{
		System.out.println("get booking: "+config.getBaseURI("BaseUrl")+config.testDataFileReader("createdBookingID"));
		RestAssured.baseURI = config.getBaseURI("BaseUrl")+config.testDataFileReader("createdBookingID");
		RequestSpecification request = RestAssured.given();
		return request;
	}

}
