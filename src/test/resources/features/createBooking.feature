Feature: Create Booking

	Scenario: Verify booking is created
		Given Base URI is set for createBooking request
		When createBooking request sent with POST method type and get 201 status code