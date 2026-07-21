package practice;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;

public class FetchingDataFromPropertiesFIle {

	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream("C:\\Users\\Mukilan P\\OneDrive\\Desktop\\Selenium data\\TestData.properties");
//		// connect to the external file
//		Properties prop = new Properties();	// create an empty object 
//		prop.load(fis);	// load the data to empty object
//		String URL = prop.getProperty("url");	// fetch the data 
//		String UN = prop.getProperty("username");
//		String pwd = prop.getProperty("password");
//		System.out.println(URL);
//		System.out.println(UN);
//		System.out.println(pwd);
		
		
	//accessing from utility file 
		
		PropertiesUtility putil = new PropertiesUtility();// we use this way to reduce codes
//		String url = putil.getDataFromProperties("url");
		System.out.println(putil.getDataFromProperties("url"));
		System.out.println(putil.getDataFromProperties("username"));
		System.out.println(putil.getDataFromProperties("password"));
		
		
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get(url);

	}
}
