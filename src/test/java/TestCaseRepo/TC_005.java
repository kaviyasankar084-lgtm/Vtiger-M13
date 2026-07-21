package TestCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactsPage;
import objectRepo.HomePage;

public class TC_005 extends BaseClass {

	@Test(groups = {"regression","sanity"})
	public void CON_002() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContactIcon();

		String lastName = eutil.getDataFromExcel("contacts", 4, 1);
		String dept = eutil.getDataFromExcel("contacts", 4, 2);
		String email = eutil.getDataFromExcel("contacts", 4, 3);
		String mobile = eutil.getDataFromExcel("contacts", 4, 4);

		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContact(lastName, dept, email, mobile);
	}

}
