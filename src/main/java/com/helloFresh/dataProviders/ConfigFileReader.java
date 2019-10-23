package com.helloFresh.dataProviders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String filePath = "configs/configurations.properties";
	private final String responseFilePath = "src/test/resources/testData/response.properties";
	
	public ConfigFileReader(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			try{
			properties.load(reader);
			reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties file not found at "+ filePath);
		}
	}
	
	public void testDataFileWriter(String key, String value) throws IOException{
		FileInputStream in = new FileInputStream(responseFilePath);
		Properties props = new Properties();
		props.load(in);
		in.close();

		FileOutputStream out = new FileOutputStream(responseFilePath);
		props.setProperty(key, value);
		props.store(out, null);
		out.close();
	}
	
	public String testDataFileReader(String key) throws IOException{
		FileInputStream in = new FileInputStream(responseFilePath);
		Properties props = new Properties();
		props.load(in);
		in.close();
		return props.getProperty(key);
	}
	
	public String getBaseURI(String baseUri){
		String baseURI = properties.getProperty(baseUri);
		return baseURI;
	}
	
	public String getTestDataFilePath(String data){
		String testDataFilePath = properties.getProperty(data);
		return testDataFilePath;
	}
}

