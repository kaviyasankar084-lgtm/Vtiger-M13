package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a Login webpage POM class
 * @author Mukilan P
 * @version 26-26-25
 */
public class LoginPage {

	// locating the webelements
	
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	// initializing the webelements
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// getter methods 

	
	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	// utilizing the webelements 
	
	/** This is a business library to perform login to the web application
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username,String password) {
		getUsernameTF().sendKeys(username);
		getPasswordTF().sendKeys(password);
		getLoginButton().click();
	}
}
