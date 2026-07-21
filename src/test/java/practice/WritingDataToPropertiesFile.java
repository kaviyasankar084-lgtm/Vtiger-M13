package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import genericUtility.PropertiesUtility;

public class WritingDataToPropertiesFile {

	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream("C:\\Users\\Mukilan P\\OneDrive\\Desktop\\Selenium data\\TestData.properties");
//		// connect to the external file
//		Properties prop = new Properties();	// create an empty object 
//		prop.load(fis);	// load the data to empty object
//		prop.setProperty("age","20");
//		System.out.println(prop);
//		FileOutputStream fos = new FileOutputStream("C:\\Users\\Mukilan P\\OneDrive\\Desktop\\Selenium data\\TestData.properties");
//		// to write the data in file we create fos
//		prop.store(fos, "age updated");	// we use store to update the file
		
	
		
		// this is used to reduce the code by creating separate class and methods 
		PropertiesUtility putil = new PropertiesUtility();
		putil.writeDataToPropeties("name", "ram", "name updated");
	}
}
