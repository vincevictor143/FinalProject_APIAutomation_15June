package com.spotify.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders 
{
	RequestSpecification requestspecification;
	
	public static RequestSpecification reqSpec()
	{
		return new RequestSpecBuilder()
	    .setBaseUri("https://api.spotify.com/")
	    .setBasePath("v1")
        .log(LogDetail.ALL)
	    .setAccept(ContentType.JSON)
	    .build();
	}
	
	
	public static ResponseSpecification resSpec()
	{
		return new ResponseSpecBuilder()
		.log(LogDetail.ALL)
		.build();
	}
	
	
	

}
