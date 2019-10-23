package com.helloFresh.stepDefinitions;


import com.helloFresh.apiHelpers.APIHelpers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetBookingsSteps {
	APIHelpers apiHelper = new APIHelpers();
	
		@When("^Get Bookings API request is sent with method type GET and get 200 status code$")
		public void get_bookings_api_request_sent_for_get_method(){
			apiHelper.getAllBookings();
		}
		
		@When("^Get Booking API request is sent with method type GET and get 200 status code$")
		public void get_Bookings_API_request_sent_with_method_type_GET(){
			apiHelper.getBooking();
		}
		
		@Then("^Get Booking API response is matching with the create booking response$")
		public void get_Booking_API_request_is_matching_create_booking_response(){
			apiHelper.verifyGetBookingFromExpectedResponse();
		}
		
		@Then("^Existing bookings are available in Get Bookings response$")
		public void existing_bookings_available_get_booking_response(){
			apiHelper.verifyExistingBookingsInGetBookingsResponse();
		}
		
		
}
