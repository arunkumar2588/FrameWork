package com.crm.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//declaration
	
		@FindBy(name="user_name")
		private WebElement usernameTextField;
		
		@FindBy(name="user_password")
		private WebElement passwordTextField;
		
		@FindBy(id="submitButton")
		private WebElement submitButton;
		
	//initialization
		
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}

		//getters
		
		public WebElement getUsernameTextField() {
			return usernameTextField;
		}

		public WebElement getPasswordTextField() {
			return passwordTextField;
		}

		public WebElement getSubmitButton() {
			return submitButton;
		}
		
		
		public void setLogin(String username,String password) {
			usernameTextField.sendKeys(username);
			passwordTextField.sendKeys(password);
			submitButton.click();
			
		}
}
