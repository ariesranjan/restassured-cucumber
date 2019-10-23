package com.helloFresh.stepDefinitions;

import java.io.IOException;

import com.helloFresh.apiHelpers.APIHelpers;
import io.cucumber.java.en.When;

public class CreateBookingSteps {
	
	APIHelpers createBookingHelper = new APIHelpers();
	
	@When("^createBooking request sent with POST method type and get 201 status code$")
	public void createbooking_request_sent_with_POST_method_type() throws IOException{
		createBookingHelper.createBooking("createBooking");
	}
	
	@When("^store created booking id$")
	public void store_created_booking_id() throws IOException{
		createBookingHelper.storeBookingID();
	}
	
	@When("^store created booking details$")
	public void store_created_booking_details() throws IOException{
		createBookingHelper.storeCreatedBookingResponse();
	}
	
	@When("^store second created booking details$")
	public void store_second_created_booking_details() throws IOException{
		createBookingHelper.storeSecondCreatedBookingResponse();
	}

}
