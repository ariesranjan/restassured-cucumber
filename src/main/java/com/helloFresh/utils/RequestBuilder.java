package com.helloFresh.utils;

import org.json.simple.JSONObject;

public class RequestBuilder {
	
	JsonFileReader jsonReader = new JsonFileReader();
	RandomDataGeneration dataGenerator = new RandomDataGeneration();
	
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
