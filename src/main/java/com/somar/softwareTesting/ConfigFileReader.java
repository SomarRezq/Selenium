package com.somar.softwareTesting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "C:\\Users\\Somar\\GradleProjects\\Selenium\\src\\config\\configuration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getImgPath(){
		String driverPath = properties.getProperty("imgPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("imgPath not specified in the Configuration.properties file.");		
	}
	
	public String getUserName() {		
		String url = properties.getProperty("username");
		if(url != null) return url;
		else throw new RuntimeException("username not specified in the Configuration.properties file.");
	}
	
	public String getPassWord() {
		String url = properties.getProperty("password");
		if(url != null) return url;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");
	}

    public String getWebsiteUrl() {
		String url = properties.getProperty("websiteUrl");
		if(url != null) return url;
		else throw new RuntimeException("websiteUrl not specified in the Configuration.properties file.");
	}
}