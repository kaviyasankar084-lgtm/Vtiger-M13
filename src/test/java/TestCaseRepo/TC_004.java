package TestCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactsPage;
import objectRepo.HomePage;

public class TC_004 extends BaseClass {

	@Test(groups = {"regression"})
	public void CON_001() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContactIcon();

		String firstName = eutil.getDataFromExcel("contacts", 1, 1);
		String lastName = eutil.getDataFromExcel("contacts", 1, 2);
		String title = eutil.getDataFromExcel("contacts", 1, 3);

		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContacts(firstName, lastName, title);
	}
}
