package TestCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactsPage;
import objectRepo.HomePage;

public class TC_006 extends BaseClass {

	@Test(groups = {"sanity"})
	public void CON_003() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContactIcon();

		String lastName = eutil.getDataFromExcel("contacts", 7, 1);
		String title = eutil.getDataFromExcel("contacts", 7, 2);
		String email = eutil.getDataFromExcel("contacts", 7, 3);
		String mCity = eutil.getDataFromExcel("contacts", 7, 4);
		String mState = eutil.getDataFromExcel("contacts", 7, 5);
		String mCountry = eutil.getDataFromExcel("contacts", 7, 6);

		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContact(lastName, title, email, mCity, mState, mCountry);

	}

}
