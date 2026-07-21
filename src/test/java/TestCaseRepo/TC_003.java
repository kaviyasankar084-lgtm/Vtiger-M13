package TestCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_003 extends BaseClass {

	@Test(groups = {"smoke"})
	public void LE_003() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		
		String lastName = eutil.getDataFromExcel("leads", 7, 1);
		String company = eutil.getDataFromExcel("leads", 7, 2);
		String mobile = eutil.getDataFromExcel("leads", 7, 3);
		String email = eutil.getDataFromExcel("leads", 7, 4);
		String city = eutil.getDataFromExcel("leads", 7, 5);
		String state = eutil.getDataFromExcel("leads", 7, 6);
		String country = eutil.getDataFromExcel("leads", 7, 7);
		
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lastName, company, mobile, email, city, state, country);
	}


@Test
public void Sample() {
	String value=System.getProperty("user");
	System.out.println(value);
}
}