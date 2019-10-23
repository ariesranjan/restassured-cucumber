package com.helloFresh.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.helloFresh.dataProviders.ConfigFileReader;


public class JsonFileReader {
	private String jsonFileName = "request.json";

	static ConfigFileReader config = new ConfigFileReader();
	private String dataFilePath = config.getTestDataFilePath("testDataPath");

	// JSON parser object to parse read file
	JSONParser jsonParser = new JSONParser();

	public Object josnReader(String reqType) {
		System.out.println("File name: "+ dataFilePath);
		try (FileReader reader = new FileReader(dataFilePath+jsonFileName)) {
			// Read JSON file
			JSONObject obj = (JSONObject) jsonParser.parse(reader);
			
			Object arr =  obj.get(reqType);
//			System.out.println("request is: "+arr);
			return arr;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public void main(String args[]){
////		JsonFileReader read = new JsonFileReader();
//		josnReader("createBooking");
//	}

}
