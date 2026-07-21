package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {

	public ExcelUtility eutil = new ExcelUtility();
	public PropertiesUtility putil = new PropertiesUtility();
	public SeleniumUtility sutil = new SeleniumUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("DB connection created");
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void bcConfig(@Optional("chrome") String BROWSER) throws IOException {
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			// if the edge driver is not able to communicate means
//			System.setProperty("webdriver.edge.driver", "path of edge browser server exe file in the src/main/resources");
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else
			driver = new ChromeDriver();

		sDriver= driver;
		
		sutil.maxmizeWindow(driver);
		sutil.implicitWait(driver, 15);
		String URL = putil.getDataFromProperties("url");
		sutil.accessApplication(driver, URL);
		System.out.println("Browser launched");
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String UN = putil.getDataFromProperties("username");
		String PWD = putil.getDataFromProperties("password");
		lp.loginToApplication(UN, PWD);
		System.out.println("Login Done ");
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logoutOperation(driver);
		System.out.println("Logout done");
	}

	@AfterClass(alwaysRun = true)
	public void acConfig() {
		sutil.closeBrowser(driver);
		System.out.println("Browser closed");
	}

	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("DB connection closed ");
	}

}
