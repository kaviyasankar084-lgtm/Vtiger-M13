package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;
import objectRepo.LoginPage;

public class TC001_Practice extends BaseClass{

	@Test
	public void sample() throws IOException {
//		
//		SeleniumUtility sutil = new SeleniumUtility();
//		WebDriver driver = new ChromeDriver();
//		PropertiesUtility putil = new PropertiesUtility();
//		sutil.implicitWait(driver, 15);
//		sutil.maxmizeWindow(driver);
//		String URL = putil.getDataFromProperties("url");
//		sutil.accessApplication(driver, URL);
//		LoginPage logpage = new LoginPage(driver);
//		String UN = putil.getDataFromProperties("username");
//		String PWD = putil.getDataFromProperties("password");
//		logpage.loginToApplication(UN, PWD);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		
		LeadsPage lp= new LeadsPage(driver);
		lp.clickOnCreateNewLeadIcon();
		CreatingNewLeadPage CLP = new CreatingNewLeadPage(driver);
		ExcelUtility eutil = new ExcelUtility();
		String fname = eutil.getDataFromExcel("leads", 1, 1);
		String lname = eutil.getDataFromExcel("leads", 1, 2);
		String company = eutil.getDataFromExcel("leads", 1, 3);

		CLP.createNewLead(fname, lname, company);
		
//		hp.logoutOperation(driver);
		
	}
}
