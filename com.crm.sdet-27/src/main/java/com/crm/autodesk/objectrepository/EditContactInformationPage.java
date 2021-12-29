package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactInformationPage {

	
	//Locate & Identify the Elements
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement organisation;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveContactsBtn;
	
	//Initialize using Constructors
	public EditContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization: Getters Method
	public WebElement getLastName() {
		return lastName;
	}


	public WebElement getOrganisation() {
		return organisation;
	}
	

	public WebElement getSaveContactsBtn() {
		return saveContactsBtn;
	}


	//Business Libraries
	public WebElement lastNameEdit()
	{
		lastName.clear();
		return lastName;
	}

	public void organisationChange()
	{
		organisation.click();
	}
	
	public void clickOnContactSave() 
	{
	saveContactsBtn.click();	
	}
	
	
}
