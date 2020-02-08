package RestAssured.RestAssured;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get002 {

	
	  @Test
	  void getweatherDetails()
	  {
	   //Specify base URI
	   RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	   
	   //Request object
	   RequestSpecification httpRequest=RestAssured.given();
	   
	   //Response object
	   Response response=httpRequest.request(Method.GET,"/Hyderabad");
	   
	   //print response in console window
	   
	   String responseBody=response.getBody().asString();
	   System.out.println("Response Body is:" +responseBody);
	   
	   JsonPath jpath = response.jsonPath();
	 
	   
	 }

}
