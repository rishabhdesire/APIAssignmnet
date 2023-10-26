Feature: Validating Create Booking API

Background: 
	Given Add CreateBooking Payload with "TestFirst1" "TestLast1"
	When user calls "CreateBookingAPI" with "Post" http request

@CreateBooking
Scenario: Verify CreateBooking Api if user is able to succeefully place booking using create booking api.
	
	Then the api calls got success with status code 200
	And "firstname" is response body should be "<firstname>" for "Create" http request
	And "lastname" is response body should be "<lastname>" for "Create" http request
	
	Examples: 
	|firstname|lastname|
	|TestFirst1|TestLast1|
	
@GetBooking
Scenario: Verify GetBooking Api if user is able to succeessfully get booking using create booking api.
	When user calls "GetBookingAPI" with "Get" http request
	Then the api calls got success with status code 200
	And "firstname" is response body should be "<firstname>" for "Get" http request
	And "lastname" is response body should be "<lastname>" for "Get" http request
	
	Examples: 
	|firstname|lastname|
	|TestFirst1|TestLast1|
	
@DeleteBooking	
Scenario: Verify DeleteBooking Api if user is able to succeefully Delete booking using create booking api.
	Given Get Token and authorize access to DeleteAPI
	When user calls "DeleteBookingAPI" with "Delete" http request
	Then the api calls got success with status code 201

	