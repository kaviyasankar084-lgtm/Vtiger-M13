package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import objectRepo.LoginPage;

public class POM_Practice {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		SeleniumUtility sutil = new SeleniumUtility();
		PropertiesUtility putil = new PropertiesUtility();
		sutil.maxmizeWindow(driver);
		sutil.implicitWait(driver, 15);
		String URL = putil.getDataFromProperties("url");
		sutil.accessApplication(driver, URL);
		String userName = putil.getDataFromProperties("username");
		String password= putil.getDataFromProperties("password");
//		WebElement uNameTF = driver.findElement(By.xpath("//input[@type='text']"));
//		uNameTF.sendKeys(userName);
//		Thread.sleep(2000);
//		sutil.refreshWebpage(driver);
//		Thread.sleep(2000);
//		uNameTF.sendKeys(userName);

		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameTF().sendKeys(userName);
//		lp.getPasswordTF().sendKeys(password);
//		lp.getLoginButton().click();
		
		lp.loginToApplication(userName, password);
		
	}

}
