package com.crm.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

		// Initialization 
			public  OrganisationPage(WebDriver driver) 
			{
				PageFactory.initElements(driver, this);
			}

		//Declaration 

			@FindBy(xpath="//img[@title='Create Organization...']")
			private WebElement createOrg;

			@FindBy(xpath="//input[@name='accountname']")
			private WebElement orgNam;

			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement saveButton;
			
			
		// getter method
			public WebElement getCreateOrg() {
				return createOrg;
			}

			public WebElement getOrgNam() {
				return orgNam;
			}

			public WebElement getSaveButton() {
				return saveButton;
			}
			
			//Business logic 
			/**
			 * this method is used to create organization
			 * @author Arun
			 */
			public void ClickOnCrecateOrg()
			{
				createOrg.click();
			}

			/**
			 * this method is used to send data for organization name
			 * @param name
			 */
			public void OrgName(String name)

			{
				orgNam.sendKeys(name);
				
			}
			public void clickOnSave() {
				saveButton.click();
			}
}
