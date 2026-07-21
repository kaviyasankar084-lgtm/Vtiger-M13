package TestCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

@Listeners(genericUtility.ListernersImplementation.class)


public class TC_001Test extends BaseClass {
    int i=0;
	@Test(groups = {"regression","smoke"} ,retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class)
	public void LE_001() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		if(i<3) {
			i++;
		Assert.fail();
		}
		String firstName = eutil.getDataFromExcel("leads", 1, 1);
		String lastName = eutil.getDataFromExcel("leads", 1, 2);
		String company = eutil.getDataFromExcel("leads", 1, 3);
		
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(firstName, lastName, company);

	}

}
