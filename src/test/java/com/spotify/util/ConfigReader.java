package com.spotify.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	public static String readConfig() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
	    
	    File file=new File(path); // Java will be able to understand that we are going to handle file
	    
	    FileInputStream fis=new FileInputStream(file); // To inform java to read the data from file 
	    
	    Properties prop=new Properties();
	    
	    prop.load(fis);
	    
	    String nameValue=prop.getProperty("Name");
	    
	   return nameValue;
	}
	    
}
