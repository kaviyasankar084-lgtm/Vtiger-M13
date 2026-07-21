package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is a utility class which deals properties file
 */
public class PropertiesUtility {

	/**
	 * this is a generic method to fetch data from Properties file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathUtility.propertiesPath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	/**
	 * This is a generic method to write data to Properties file
	 * @param key
	 * @param value
	 * @param comment
	 * @throws IOException
	 */
	public void writeDataToPropeties(String key, String value,String comment) throws IOException {
		FileInputStream fis = new FileInputStream(IPathUtility.propertiesPath);
		Properties prop = new Properties();	 
		prop.load(fis);	
		prop.setProperty(key,value);
		FileOutputStream fos = new FileOutputStream(IPathUtility.propertiesPath);
		prop.store(fos, comment);	
		
	}
}
