package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CheckInOutDates;
import pojo.CreateBooking;
import pojo.CreateBookingResponse;
import pojo.LoginRequest;
import pojo.LoginResponse;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StepDefination extends Utils{
	
	RequestSpecification createBookingReq;
	RequestSpecification reqCreateBooking;
	CreateBookingResponse respCreateBooking;
	RequestSpecification reqGetBooking;
	RequestSpecification reqDeleteBooking;
	RequestSpecification DeleteBookingReq;
	
	RequestSpecification req;
	String bookingId;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add CreateBooking Payload with {string} {string}")
	public void add_palce_payload(String fn, String ln) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
			
		reqCreateBooking = given()
				.spec(requestSpecification())
				.body(data.createBookingPayLoad(fn,ln));
		
		respCreateBooking = reqCreateBooking.when().post("/booking").then().extract().response()
				.as(CreateBookingResponse.class);
		
		bookingId = respCreateBooking.getBookingid();
		System.out.println(bookingId);

	}
	
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String api, String reqType) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		if(api.equals("CreateBookingAPI")) 
		{
			response = reqCreateBooking.when().post("/booking").then().log().all().extract().response();
		}
		else if(api.equals("GetBookingAPI"))
		{
			System.out.println("BookingID Is: " + bookingId);
			reqGetBooking = given().spec(requestSpecification()).pathParam("bookingId", bookingId);
			response = reqGetBooking.when().get("/booking/{bookingId}").then().log().all().extract().response();
		}
		else if(api.equals("DeleteBookingAPI"))
		{
			reqDeleteBooking = given().spec(DeleteBookingReq).pathParam("bookingId", bookingId);
			response = reqDeleteBooking.when().delete("/booking/{bookingId}").then().log().all().extract().response();
		}
		
		
	}
	
	@Given("Get Token and authorize access to DeleteAPI")
	public void authenticateApi() {
		// Write code here that turns the phrase above into concrete actions
		
		DeleteBookingReq = new RequestSpecBuilder()
				.setBaseUri("https://restful-booker.herokuapp.com")
				.setContentType(ContentType.JSON)
				.addHeader("Cookie", getToken())
				.build();
	}
	
	
	@Then("the api calls got success with status code {int}")
	public void the_api_calls_got_success_with_status_code(Integer statuscode) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),(int)statuscode);
	}
		
	@Then("{string} is response body should be {string} for {string} http request")
	public void is_response_body_should_be(String keyValue, String expectedValue, String reqType) {
	    // Write code here that turns the phrase above into concrete actions
	    
		String resp = response.asString();
	    JsonPath js = new JsonPath(resp);
	    if(reqType.equals("Get"))
	    {
	    	assertEquals(js.get(keyValue).toString(),expectedValue);
	    }
	    else
	    {
	    	assertEquals(js.get("booking."+keyValue).toString(),expectedValue);
	    }
	    
	    
	}

}
