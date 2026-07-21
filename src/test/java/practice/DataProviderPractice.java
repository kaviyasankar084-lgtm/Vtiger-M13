package practice;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import objectRepo.LoginPage;


public class DataProviderPractice {

//	@Test(dataProvider="getData")
//	public void demo(String UN,String PWD)throws IOException {
	
	@Test(dataProvider ="loginData",dataProviderClass = genericUtility.DataProviderUtility.class)
	
public void demo(HashMap<String,String >h) throws IOException {
		
		SeleniumUtility sutil= new SeleniumUtility();
		PropertiesUtility putil= new PropertiesUtility();
		WebDriver driver = new ChromeDriver();
		sutil.maxmizeWindow(driver);
		sutil.implicitWait(driver, 15);
		String URL= putil.getDataFromProperties("url");
		sutil.accessApplication(driver, URL);
		LoginPage lp = new LoginPage (driver);
		lp.loginToApplication(h.get("username"), h.get("password"));
	//	lp.loginToApplication(UN, PWD);

	}

	@DataProvider(name="getData")
	public Object[][] data() {
		Object obj[][]= {{"admin","admin"},{"admin123","admin123"},{"akmk","rkmk"}};
		return obj;
	}
}
