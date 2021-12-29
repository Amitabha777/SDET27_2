package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {

	//Locate & Identify The Elements
	@FindBy(name="lastname")
	private WebElement lastNameBox;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement organisationAddImg;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveContactsBtn;
	
	//Initialising The Elemets using Constructor
	
			public CreateContactsPage(WebDriver driver) {
			 PageFactory.initElements(driver, this);
			}

			
			//Utilization
			
			public WebElement getLastNameBx() {
				return lastNameBox;
			}

			public WebElement getOrganisationAddImg() {
				return organisationAddImg;
			}
			
			
			public WebElement getSaveContactsBtn() {
				return saveContactsBtn;
			}


			//Business Libraries
			public void addContactsDetails(String lastName) 
			{
				lastNameBox.sendKeys(lastName);
				organisationAddImg.click();
			}
			
			public void addLastName(String lastName) 
			{
				lastNameBox.sendKeys(lastName);
				
			}
			
			public void clickOnContactSave() 
			{
			saveContactsBtn.click();	
			}
			
			
}
