package com.crm.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//initialization
	
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		
		@FindBy(linkText="Organizations")
		private WebElement orgButton;
		
		@FindBy(linkText="Products")
		private WebElement productButton;
		
		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement contactButton;
		
		@FindBy(linkText="More")
		private WebElement MoreButton;
		
		@FindBy(linkText="Campaigns")
		private WebElement campaignButton;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratorButton;
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signOutButton;
		
		
		//getter Method
		
		public WebElement getOrgButton() {
			return orgButton;
		}

		public WebElement getProductButton() {
			return productButton;
		}

		public WebElement getContactButton() {
			return contactButton;
		}

		public WebElement getMoreButton() {
			return MoreButton;
		}

		public WebElement getCampaignButton() {
			return campaignButton;
		}

		public WebElement getAdministratorButton() {
			return administratorButton;
		}

		public WebElement getSignOutButton() {
			return signOutButton;
		}
		
		//Business Logic
		
		/** this method is used to click on organization 
		 * @author Arun
		 * 
		 */
		public void clickOnOrg()
		{
			orgButton.click();
		}
		
		/**
		 * this method is used to click on product
		 * @author Arun
		 */
		public void clickOnProduct() {
			productButton.click();
		}
		
		/**
		 * this method is used to click on contact
		 * @author Arun
		 */
		public void clickOnContact() {
			contactButton.click();
		}
		
		/**
		 * this method is used to click on More
		 * @author Arun
		 */
		public void clickOnMore() {
			MoreButton.click();
		}
		
		/**
		 * this method is used to click on Campaign
		 * @author Arun
		 */
		public void clickOnCampaign() {
			campaignButton.click();
			
		}
		
		/**
		 * this method is used to click on Administrator
		 * @author Arun
		 */
		
		public void clickOnAdministrator() {
			administratorButton.click();
		}
		
		/**
		 * this method is used to click on signout 
		 * @author Arun
		 */
		public void clickOnSignOut() {
			signOutButton.click();
		}
}
