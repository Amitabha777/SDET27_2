package com.crm.autodesk.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class OrganisationInformationPage extends WebDriverUtility{

	//Locate & Identify The Elements
	
	@FindBy(className="dvHeaderText")
	private WebElement headerName;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryName;
	
	@FindBy(id="mouseArea_Type")
	private WebElement typeName;
	
	//Initialize The Elements using Constructor
	public OrganisationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization : Get Getters Method
	
	public WebElement getHeaderName() {
		return headerName;
	}
	
	
	
	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getTypeName() {
		return typeName;
	}

	
	
	//Business Library
	public void headerTextVisibility(WebDriver driver, String condition) 
	{
		invokeExplicitWait(driver, headerName, condition);
	}
	
	
	public String headerText()
	{
		String headerText= headerName.getText();
		return headerText;
	}
	
	public String industry()
	{
		String indName= industryName.getText();
		return indName;
	}
	
	public String type()
	{
		String tName= typeName.getText();
		return tName;
	}
	
}
