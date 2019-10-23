Feature: Get Bookings Api

  Scenario: Verify that getBookings API is giving atleast 2 existing bookings in the response
  	Given Base URI is set for createBooking request
  	And Base URI is set for getBookings request
  	When createBooking request sent with POST method type and get 201 status code
  	And store created booking details
  	And createBooking request sent with POST method type and get 201 status code
  	And store created booking id
  	And store second created booking details
  	When Get Bookings API request is sent with method type GET and get 200 status code
  	Then Existing bookings are available in Get Bookings response
  	
 	Scenario: Verify that getBooking API is giving successful response
 		
  	Given Base URI is set for getBooking request
  	When Get Booking API request is sent with method type GET and get 200 status code
  	Then Get Booking API response is matching with the create booking response
    

 