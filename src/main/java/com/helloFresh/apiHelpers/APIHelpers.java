package com.helloFresh.apiHelpers;


import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.helloFresh.dataProviders.ConfigFileReader;
import com.helloFresh.utils.RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class APIHelpers {
	
	RequestBuilder reqBuilder = new RequestBuilder();
	Response createBookingResponse, getBookingsResponse, getBookingResponse;
	JsonPath jsonPathEvaluator;
	String createBookingRes, getBookingsRes, getBooking;
	String createdBookingID;
	ConfigFileReader config = new ConfigFileReader();
	
	public void createBooking(String reqType) throws IOException{
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject createRequest = reqBuilder.createBookingRequestBuilder(reqType);

		httpRequest.body(createRequest.toString());
		httpRequest.contentType(ContentType.JSON);
		createBookingResponse = httpRequest.request(Method.POST);
		Assert.assertEquals(createBookingResponse.getStatusCode(), 201);
		jsonPathEvaluator = createBookingResponse.jsonPath();
		createBookingRes = jsonPathEvaluator.get("booking").toString();
		createdBookingID = jsonPathEvaluator.get("bookingid").toString();
		
		try (FileWriter file = new FileWriter("src/test/resources/testData/response.json")) {
            file.write(createBookingResponse.getBody().asString());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void storeBookingID() throws IOException{
		config.testDataFileWriter("createdBookingID", createdBookingID);
	}
	
	public void storeCreatedBookingResponse() throws IOException{
		config.testDataFileWriter("existingBookingDetails", createBookingRes);
	}
	
	public void storeSecondCreatedBookingResponse() throws IOException{
		config.testDataFileWriter("newlyCreatedBooking", createBookingRes);
	}
	
	public void getAllBookings(){
		RequestSpecification httpRequest = RestAssured.given();
		getBookingsResponse = httpRequest.request(Method.GET);
		Assert.assertEquals(getBookingsResponse.getStatusCode(), 200);
		jsonPathEvaluator = getBookingsResponse.jsonPath();
		getBookingsRes = jsonPathEvaluator.get("bookings").toString();
	}
	
	public void getBooking(){
		RequestSpecification httpRequest = RestAssured.given();
		getBookingResponse = httpRequest.request(Method.GET);
		Assert.assertEquals(getBookingResponse.getStatusCode(), 200);
		jsonPathEvaluator = getBookingResponse.jsonPath();
		getBooking = jsonPathEvaluator.get().toString();
	}
	
	public void verifyGetBookingFromExpectedResponse(){
		try {
			Assert.assertTrue(getBooking.contains(config.testDataFileReader("newlyCreatedBooking")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyExistingBookingsInGetBookingsResponse(){
		try {
			Assert.assertTrue(getBookingsRes.contains(config.testDataFileReader("existingBookingDetails")));
			Assert.assertTrue(getBookingsRes.contains(config.testDataFileReader("newlyCreatedBooking")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
