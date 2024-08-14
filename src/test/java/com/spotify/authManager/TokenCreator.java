package com.spotify.authManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
public class TokenCreator 
{
	
	public static String renewToken()
	{
		HashMap<String,String> param=new HashMap<String,String>();
		param.put("grant_type","refresh_token");
		param.put("refresh_token","AQAFnw1b77gEm0-SGpsckHIIF59wzKOJqqMBrmEYTAX0r-bm1gKZelCp1RsL9A-egrA2Vod9bBtc5O9yj8lFqGHPWGmBw2wIV0akbTDfUlA_kTtogLIr9DPOcrTuyy1uNsI");
		param.put("client_id","7f322cf25694422499e682fbdc4c57a7");
		param.put("client_secret","20735740f3904477bc14df2295fad720");
		
		
		RestAssured.baseURI="https://accounts.spotify.com/";
		    Response response = given()
		   .contentType(ContentType.URLENC)     
		   .formParams(param)
		   .when()
		   .post("api/token")
		   .then()
		   .extract()
		   .response();
		    
		    if(response.getStatusCode()!=200)
		    {
		    	// throw new RunTimeException("Failed to generate the Access Token");
		    	
		    	System.out.println("Token Code is not generated");
		    }
		    
		    String token = response.path("access_token");
		    return token;

	}

}
