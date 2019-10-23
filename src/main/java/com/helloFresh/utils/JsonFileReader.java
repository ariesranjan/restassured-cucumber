package com.helloFresh.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.helloFresh.dataProviders.ConfigFileReader;


// TODO: Auto-generated Javadoc
/**
 * The Class JsonFileReader.
 */
public class JsonFileReader {
	
	/** The json file name. */
	private String jsonFileName = "request.json";

	/** The config. */
	static ConfigFileReader config = new ConfigFileReader();
	
	/** The data file path. */
	private String dataFilePath = config.getTestDataFilePath("testDataPath");

	/** The json parser. */
	// JSON parser object to parse read file
	JSONParser jsonParser = new JSONParser();

	/**
	 * Josn reader to read the request parameters from request.json file
	 *
	 * @param reqType the req type
	 * @return the object
	 */
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
