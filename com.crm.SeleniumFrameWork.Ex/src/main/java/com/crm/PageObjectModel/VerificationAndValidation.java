package com.crm.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationAndValidation {
	public  VerificationAndValidation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="dvHeaderText")
	private WebElement verifyorgName;

	public WebElement getVerifyorgName() {
		return verifyorgName;
	}

	public void verifyAndValidation(WebDriver driver,String data) {
		String actualData = verifyorgName.getText();
		if(actualData.contains(data)) {
			System.out.println("organisation is created");
		}
		else {
			System.out.println("organisation is not created");
		}
	}
}
