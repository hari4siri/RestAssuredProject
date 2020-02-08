package RestAssured.RestAssured;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void getWeatherdetails() {
		
		
		//specify base URI
		RestAssured.baseURI = "https://reqres.in";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response Object
		Response response = httprequest.request(Method.GET, "/api/users?page=2 ");
		
		//printing in console
		String resbody = response.getBody().asString();
		System.out.println(resbody);
		
		int code=response.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		
		String line = response.statusLine();
		System.out.println(line);
		
		Headers allheaders =response.getHeaders();
		
		for(Header header: allheaders) {
			System.out.println(header.getName() + "   " + header.getValue());
		}
	}

}
