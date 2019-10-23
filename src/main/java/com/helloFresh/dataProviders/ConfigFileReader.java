package com.helloFresh.dataProviders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigFileReader.
 */
public class ConfigFileReader {
	
	/** The properties. */
	private Properties properties;
	
	/** The file path. */
	private final String filePath = "configs/configurations.properties";
	
	/** The response file path. */
	private final String responseFilePath = "src/test/resources/testData/response.properties";
	
	/**
	 * Instantiates a new config file reader.
	 */
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
	
	/**
	 * Test data file writer.
	 *
	 * @param key the key
	 * @param value the value
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
	
	/**
	 * Test data file reader.
	 *
	 * @param key the key
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String testDataFileReader(String key) throws IOException{
		FileInputStream in = new FileInputStream(responseFilePath);
		Properties props = new Properties();
		props.load(in);
		in.close();
		return props.getProperty(key);
	}
	
	/**
	 * Gets the base URI.
	 *
	 * @param baseUri the base uri
	 * @return the base URI
	 */
	public String getBaseURI(String baseUri){
		String baseURI = properties.getProperty(baseUri);
		return baseURI;
	}
	
	/**
	 * Gets the test data file path.
	 *
	 * @param data the data
	 * @return the test data file path
	 */
	public String getTestDataFilePath(String data){
		String testDataFilePath = properties.getProperty(data);
		return testDataFilePath;
	}
}

