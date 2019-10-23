package com.helloFresh.apiHelpers;


import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.helloFresh.dataProviders.ConfigFileReader;
import com.helloFresh.utils.RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelpers {
	
	/** The req builder. */
	RequestBuilder reqBuilder = new RequestBuilder();
	
	/** The get booking response. */
	Response createBookingResponse, getBookingsResponse, getBookingResponse;
	
	/** The json path evaluator. */
	JsonPath jsonPathEvaluator;
	
	/** The get booking. */
	String createBookingRes, getBookingsRes, getBooking;
	
	/** The created booking ID. */
	String createdBookingID;
	
	/** The config. */
	ConfigFileReader config = new ConfigFileReader();
	
	/**
	 * Creates the booking.
	 *
	 * @param reqType the req type
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
	
	/**
	 * Store booking ID.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void storeBookingID() throws IOException{
		config.testDataFileWriter("createdBookingID", createdBookingID);
	}
	
	/**
	 * Store created booking response.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void storeCreatedBookingResponse() throws IOException{
		config.testDataFileWriter("existingBookingDetails", createBookingRes);
	}
	
	/**
	 * Store second created booking response.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void storeSecondCreatedBookingResponse() throws IOException{
		config.testDataFileWriter("newlyCreatedBooking", createBookingRes);
	}
	
	/**
	 * Gets the all bookings.
	 *
	 * @return the all bookings
	 */
	public void getAllBookings(){
		RequestSpecification httpRequest = RestAssured.given();
		getBookingsResponse = httpRequest.request(Method.GET);
		Assert.assertEquals(getBookingsResponse.getStatusCode(), 200);
		jsonPathEvaluator = getBookingsResponse.jsonPath();
		getBookingsRes = jsonPathEvaluator.get("bookings").toString();
	}
	
	/**
	 * Gets the booking.
	 *
	 * @return the booking
	 */
	public void getBooking(){
		RequestSpecification httpRequest = RestAssured.given();
		getBookingResponse = httpRequest.request(Method.GET);
		Assert.assertEquals(getBookingResponse.getStatusCode(), 200);
		jsonPathEvaluator = getBookingResponse.jsonPath();
		getBooking = jsonPathEvaluator.get().toString();
	}
	
	/**
	 * Verify get booking from expected response.
	 */
	public void verifyGetBookingFromExpectedResponse(){
		try {
			Assert.assertTrue(getBooking.contains(config.testDataFileReader("newlyCreatedBooking")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verify existing bookings in get bookings response.
	 */
	public void verifyExistingBookingsInGetBookingsResponse(){
		try {
			Assert.assertTrue(getBookingsRes.contains(config.testDataFileReader("existingBookingDetails")));
			Assert.assertTrue(getBookingsRes.contains(config.testDataFileReader("newlyCreatedBooking")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
