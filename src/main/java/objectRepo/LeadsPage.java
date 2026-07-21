package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a Leads Page POM class
 * 
 * @author Mukilan P
 * @version 26-06-27
 */
public class LeadsPage {

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createNewLeadIcon;

	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewLeadIcon() {
		return createNewLeadIcon;
	}

	/**
	 * This is a business library to click on create new lead icon
	 */
	public void clickOnCreateNewLeadIcon() {
		getCreateNewLeadIcon().click();
	}

}
