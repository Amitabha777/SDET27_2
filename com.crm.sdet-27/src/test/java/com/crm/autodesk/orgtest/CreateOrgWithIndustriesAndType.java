package com.crm.autodesk.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectrepository.CreateOrganisationPage;
import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.OrganisationInformationPage;
import com.crm.autodesk.objectrepository.OrganisationPage;

public class CreateOrgWithIndustriesAndType extends BaseClass{

	@Test(groups="RegressionSuite")
	public void createOrg() throws Throwable {
		
		//Generate Random Number
			
		int ranDomNum= jLib.getRandomNumber();
				
				
				//Objects of POM Class
				HomePage homePage= new HomePage(driver); 
				OrganisationPage organisationPage= new OrganisationPage(driver);
				CreateOrganisationPage createOrganisationPage= new CreateOrganisationPage(driver);
				OrganisationInformationPage organisationInformationPage= new OrganisationInformationPage(driver);
				
		
				//Loading TestDetails Excel File
				String orgName= eLib.getDataFromExcelSheet("org", 5, 2) + ranDomNum;				
				String industries= eLib.getDataFromExcelSheet("org", 5, 3);					
				String types= eLib.getDataFromExcelSheet("org", 5, 4);					
				
				
				
		//Click on Organizations
		homePage.clickOnOrganisationsLink();
		
		Assert.fail("My Damn Wish");
		
		//Click on Add Organization (+ Sign)
		organisationPage.clickOnAddOrganisationLink();
		
		
		//Add Organization Details
		createOrganisationPage.createAndSaveOrganisationDetails(orgName, industries, types);
	
		
		//Verify Added or Not
		String industryValue= organisationInformationPage.industry();
		
		String typeValue= organisationInformationPage.type();
		
		
		String orgNameValue= organisationInformationPage.headerText();
		
		jLib.verify(orgNameValue, orgName);
		jLib.verify(industryValue, industries);
		jLib.verify(typeValue, types);
		
		
			}
}
