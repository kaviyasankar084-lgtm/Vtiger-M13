package TestCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_002 extends BaseClass {

	@Test(groups = {"sanity"})
	public void LE_002() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		
		String lastName = eutil.getDataFromExcel("leads", 4, 1);
		String company = eutil.getDataFromExcel("leads", 4, 2);
		String title = eutil.getDataFromExcel("leads", 4, 3);
		String leadSource = eutil.getDataFromExcel("leads", 4, 4);
		String noOfEmp = eutil.getDataFromExcel("leads", 4, 5);
		
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lastName, company, title, leadSource, noOfEmp);
	}

}
