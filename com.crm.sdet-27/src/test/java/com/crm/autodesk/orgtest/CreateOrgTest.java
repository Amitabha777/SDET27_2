package com.crm.autodesk.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectrepository.CreateOrganisationPage;
import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.OrganisationInformationPage;
import com.crm.autodesk.objectrepository.OrganisationPage;

public class CreateOrgTest extends BaseClass{

	@Test(groups="smokeSuite")
	public void createOrg() throws Throwable
	{
	
		//Objects Of POM Class
				HomePage homePage= new HomePage(driver);
				OrganisationPage organisationPage= new OrganisationPage(driver);
				CreateOrganisationPage createOrganisationPage= new CreateOrganisationPage(driver);
				OrganisationInformationPage organisationInformationPage= new OrganisationInformationPage(driver);
	
				int randomNumber=jLib.getRandomNumber();
	
			String orgName=eLib.getDataFromExcelSheet("org", 5, 2)+randomNumber;
			
			
	//Go Into Organization	
	homePage.clickOnOrganisationsLink();
	
	//Click on Create Organization Button/Image
	organisationPage.clickOnAddOrganisationLink();
	
	//Add Organization Details
	createOrganisationPage.createAndSaveOrganisationDetails(orgName);
	
	//Verify Organisation Added or Not
	String headerText=organisationInformationPage.headerText();
	jLib.verify(headerText, orgName);
	
	//Assert.fail();
	}

}
