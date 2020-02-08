package RestAssured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post001 {
 
 @Test
 void RegistrationSuccessful()
 {
  
  //Specify base URI
  RestAssured.baseURI="https://reqres.in";
  
  //Request object
  RequestSpecification httpRequest=RestAssured.given();
  
   
  //Request paylaod sending along with post request
  JSONObject requestParams=new JSONObject();
  
  requestParams.put( "name", "test4");
  requestParams.put("job", "leader");
 
  
  httpRequest.header("Content-Type","application/json");
  
  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
  
  //Response object
  Response response=httpRequest.request(Method.POST,"/api/users");
    
  
  //print response in console window
  
  String responseBody=response.getBody().asString();
  System.out.println("Response Body is:" +responseBody);
  
 //status code validation
  int statusCode=response.getStatusCode();
  System.out.println("Status code is: "+statusCode);
  Assert.assertEquals(statusCode, 201);
  
  
 
  //success code validation
   String name =response.jsonPath().get("name");
   System.out.println(name);
  Assert.assertEquals(name, "test4"); 
  
 }
 

}

