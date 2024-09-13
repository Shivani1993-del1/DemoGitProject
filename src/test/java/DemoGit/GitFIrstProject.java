package DemoGit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitFIrstProject {
	@Test
	public void logs()
	{
		
		RequestSpecification requspc = RestAssured.given().baseUri("https://dummyjson.com").contentType("application/json");
		//RestAssured.basePath="/auth/login";
		
		Response response=requspc.body("{ \"username\": \"emilys\", \"password\": \"emilyspass\" , \"expiresInMins\": \"30\"}").
		when().post("/auth/login").then().log().status().statusCode(200).extract().response();
		
		//Extract the token
		String token = response.jsonPath().getString("token");
		System.out.println("Our Token is " + token);
		
	}

	
	

}
