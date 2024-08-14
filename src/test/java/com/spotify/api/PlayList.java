package com.spotify.api;

import static io.restassured.RestAssured.*;

import com.spotify.pojo.Playlist;

import io.restassured.response.Response;

public class PlayList 
{
	public static Response get(String PlaylistID,String token)
	{
		 return given()
		 .auth().oauth2(token)
		 .spec(SpecBuilders.reqSpec())
		 .when()
		 .get("/playlists/"+PlaylistID)
		 .then()
		 .spec(SpecBuilders.resSpec())
		 .extract()
		 .response();
	}
	
	public static Response post(Playlist requestPlaylist,String token)
	{	 
		 return given()
//		 .auth().oauth2(token)
		 .header("Authorization","Bearer "+token)
		 .spec(SpecBuilders.reqSpec())
		 .body(requestPlaylist)
		 .when()
		 .post("users/31254eexqvsnuvededb7kopeejmy/playlists")
		 .then()
		 .spec(SpecBuilders.resSpec())
		 .extract()
		 .response();
	}
	
	
	public static Response update(String PlaylistID,String token)
	{
		  return given()
		 .auth().oauth2(token)
		 .spec(SpecBuilders.reqSpec())
		 .body("{\r\n"
		 		+ "    \"name\": \"Deshbhakti1 Songs\",\r\n"
		 		+ "    \"description\": \"Patriotism nature\",\r\n"
		 		+ "    \"public\": false\r\n"
		 		+ "}")
		 .when()
		 .put("/playlists/"+PlaylistID)
		 .then()
		 .spec(SpecBuilders.resSpec())
		 .extract()
		 .response();
	}

}
