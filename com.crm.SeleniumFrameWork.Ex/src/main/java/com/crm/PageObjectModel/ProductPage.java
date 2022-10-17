package com.crm.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	// Initialization 
				public  ProductPage(WebDriver driver) 
				{
					PageFactory.initElements(driver, this);
				}
				
		//Declaration
				
				@FindBy(xpath="//img[@title='Create Product...']")
				private WebElement createProduct;
				
				@FindBy(name="productname")
				private WebElement productName;
				
				@FindBy(xpath="//input[@title='Save [Alt+S]']")
				private WebElement saveButton;
				
				@FindBy(className="lvtHeaderText")
				private WebElement headText;
				
				@FindBy(xpath="//input[@title='Delete [Alt+D]']")
				private WebElement deleteProduct;
				
				
				//getters method

				public WebElement getCreateProduct() {
					return createProduct;
				}

				public WebElement getProductName() {
					return productName;
				}

				public WebElement getSaveButton() {
					return saveButton;
				}

				public WebElement getHeadText() {
					return headText;
				}
				 public WebElement getDeleteProduct() {
					 return deleteProduct;
				 }
				 
				//business logic
				
				/**
				 * this method is used to click on create product
				 * @author Arun
				 */
				
				public void createProduct() {
					createProduct.click();
				}
				
				/**
				 * this method is used to create product name
				 * @param name
				 */
				
				public void productName(String name) {
					productName.sendKeys(name);
					saveButton.click();	
				}
				
				/**
				 * this method is used to get header text
				 * @return
				 * @author Arun
				 */
				public String headText() {
					String text = headText.getText();
					return text;
				}
				
				/**
				 * this methods is used to delete the product
				 * @author Arun
				 */
				public void clickOnDeleteProduct(WebDriver driver) {
					deleteProduct.click();
					driver.switchTo().alert().accept();
				}
}
