package com.spotify.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.api.PlayList;
import com.spotify.authManager.TokenCreator;
import com.spotify.pojo.Playlist;
import com.spotify.util.ConfigReader;

import io.restassured.response.Response;

public class CreateGetAndUpdatePlaylistClass 
{
	
	@Test(priority=1)
	public void createPlayListMethod() throws IOException
	{
		Playlist reqPlaylist=new Playlist();
		reqPlaylist.setName(ConfigReader.readConfig());
		reqPlaylist.setDescription("Sharukhan is host of this song");
		reqPlaylist.setPublic(false);
		Response response = PlayList.post(reqPlaylist, TokenCreator.renewToken());
		Playlist responsePlaylist = response.as(Playlist.class);
		String nameValue = responsePlaylist.getName();
		String nameResponse = responsePlaylist.getDescription();
		String playlistID = responsePlaylist.getId();
		
		Assert.assertEquals(ConfigReader.readConfig(), nameValue);
		
	}
	
	@Test(priority=2)
	public void getPlayListMethod()
	{
		
	}
	
	@Test(priority=3)
	public void updatePlayListMethod()
	{
		
	}

}
