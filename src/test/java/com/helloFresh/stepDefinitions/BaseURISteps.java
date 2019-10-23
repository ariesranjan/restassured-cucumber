package com.helloFresh.stepDefinitions;

import java.io.IOException;

import com.helloFresh.utils.URLBuilder;

import io.cucumber.java.en.Given;

public class BaseURISteps {
	
	URLBuilder urlBuilder = new URLBuilder();
	
	@Given("^Base URI is set for createBooking request$")
	public void base_URI_is_set_for_createBooking_request(){
		urlBuilder.getBaseURI();
	}
	
	@Given("^Base URI is set for getBookings request$")
	public void base_URI_is_set_for_getBookings_request(){
		urlBuilder.getBaseURI();
	}
	
	@Given("^Base URI is set for getBooking request$")
	public void base_URI_is_set_for_getBooking_request(){
		try {
			urlBuilder.getBaseURIGetBooking();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
