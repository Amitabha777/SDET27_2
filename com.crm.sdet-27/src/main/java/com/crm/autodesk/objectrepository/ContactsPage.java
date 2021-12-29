package com.crm.autodesk.objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility{

	//Locate & Identify The Elements
	@FindBy(css="img[title='Create Contact...']")
	private WebElement createContactsImg;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveContactsBtn;
	
	@FindBy(xpath="(//img[@title='Last Viewed'])")
	private WebElement lastViewedBtn;
		
	@FindBy(xpath="(//table[@class='hdrNameBg'])[2]/tbody")
	private List<WebElement> lastViewList;
	
	@FindBy(id="bas_searchfield")
	private WebElement inChkBox;
	
	@FindBy(name="search_text")
	private WebElement searchBox;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	
	//Initialising The Elemets using Constructor
	
		public ContactsPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		}

	
		//Utilization: Getters Method
		public WebElement getCreateContactsImg() {
			return createContactsImg;
		}
		
		public WebElement getLastViewedBtn() {
			return lastViewedBtn;
		}

		public WebElement getSaveContactsBtn() {
			return saveContactsBtn;
		}
				
		public List<WebElement> getLastViewList() {
			return lastViewList;
		}
		
		public WebElement getInChkBox() {
			return inChkBox;
		}


		public WebElement getSearchBox() {
			return searchBox;
		}

		

		public WebElement getSearchBtn() {
			return searchBtn;
		}


		//Business Library
		public void clickOnCreateContacts() 
		{
			createContactsImg.click();
		}

		
		public void clickOnContactSave() 
		{
		saveContactsBtn.click();	
		}
		
		
		public void clickOnLastViewed()
		{
			lastViewedBtn.click();
		}

		
		public void showLastViewList()
		{
			
			for(WebElement wb: lastViewList)
			{
				System.out.println(wb.getText());
			}
		}
		
			public void inCheckBox()
			{
				selectFromListBox(inChkBox, "Last Name");
			}
			
			public void searchBox(String searchValue)
			{
				searchBox.sendKeys(searchValue);
			}
		
			public void searchButton()
			{
				searchBtn.click();
			}
		}


