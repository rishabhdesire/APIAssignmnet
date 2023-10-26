package resources;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import io.restassured.http.ContentType;

public class Utils {

	RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder()
				.setBaseUri(getGlobalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON) 
				.build();
		
		return req;
	}
	
	public String getToken()
	{
		req = new RequestSpecBuilder()
				.setBaseUri("https://restful-booker.herokuapp.com")
				.setContentType(ContentType.JSON).build();
		
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("admin");
		loginRequest.setPassword("password123");
		
		RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);
		LoginResponse loginResponse = reqLogin.when().post("/auth").then().log().all().extract().response()
				.as(LoginResponse.class);
		
		System.out.print(loginResponse.getToken());
		
		String token = loginResponse.getToken();
		String tokenValue = "token="+token;
		System.out.println("before");
		System.out.println(tokenValue);
		return tokenValue;
		
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		String currentDir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(currentDir+"\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
}
