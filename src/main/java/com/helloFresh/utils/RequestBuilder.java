package com.helloFresh.utils;

import org.json.simple.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBuilder.
 */
public class RequestBuilder {
	
	/** The json reader. */
	JsonFileReader jsonReader = new JsonFileReader();
	
	/** The data generator. */
	RandomDataGeneration dataGenerator = new RandomDataGeneration();
	
	/**
	 * Creates the booking request using the random data generator.
	 *
	 * @param requestType the request type
	 * @return the JSON object
	 */
	@SuppressWarnings("unchecked")
	public JSONObject createBookingRequestBuilder(String requestType){
		
		JSONObject request = (JSONObject) jsonReader.josnReader(requestType);
		request.put("roomid", dataGenerator.randomRoomID());
		request.put("firstname", dataGenerator.randomFirstName());
		request.put("lastname", dataGenerator.randomLastName());
		request.put("depositpaid",  true);
		request.put("email", "test@t.com");
		request.put("phone", dataGenerator.randomPhoneNumber());
		JSONObject requestParams= new JSONObject();
		requestParams.put("checkin",  dataGenerator.randomCheckInDate());
		requestParams.put("checkout",  dataGenerator.randomCheckOutDate());
		request.put("bookingdates", requestParams);
		return request;
	}

}
