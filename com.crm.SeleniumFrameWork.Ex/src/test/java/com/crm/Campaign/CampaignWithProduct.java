package com.crm.Campaign;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.PageObjectModel.CampaignPage;
import com.crm.PageObjectModel.HomePage;
import com.crm.PageObjectModel.ProductPage;

public class CampaignWithProduct extends BaseClass{

	//public static void main(String[] args) throws Throwable{
		@Test(groups = "regressionTest")
		
		public void createCampaignWithProduct() throws Throwable {
			/*WebDriver_Utility wlib = new WebDriver_Utility();
			wlib.waitForPageToLoad(driver);
			wlib.maximizeTheWindow(driver);

			/*
			 * driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			 * driver.manage().window().maximize();
			 */

			/*File_Utility flib = new File_Utility();
			String URL = flib.getPropertyKeyValue("url");
			String UN = flib.getPropertyKeyValue("un");
			String PW = flib.getPropertyKeyValue("pw");

			driver.get(URL);
			LoginPage lp = new LoginPage(driver);
			lp.setLogin(UN, PW);*/

			/*
			 * driver.findElement(By.name("user_name")).sendKeys(UN);
			 * driver.findElement(By.name("user_password")).sendKeys(PW);
			 * driver.findElement(By.id("submitButton")).click();
			 */

	//product data
	//driver.findElement(By.linkText("Products")).click();
			HomePage hp = new HomePage(driver);
			hp.clickOnProduct();

			ProductPage pp = new ProductPage(driver);
			pp.createProduct();

	//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRanDomNum();

			Excel_Utility elib1 = new Excel_Utility();
			String productdata = elib1.getExcelKeyValue("Qspider", 1, 0) + ranNum;

			pp.productName(productdata);

			/*
			 * driver.findElement(By.name("productname")).sendKeys(productdata);
			 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 */

	//Navigate to Campaign

			HomePage hp1 = new HomePage(driver);
			hp1.clickOnMore();
	//driver.findElement(By.linkText("More")).click();

			hp1.clickOnCampaign();
	//driver.findElement(By.linkText("Campaigns")).click();

			CampaignPage cp = new CampaignPage(driver);
			cp.clickOnCreateCampaign();

	//river.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

			Excel_Utility elib = new Excel_Utility();
			String data1 = elib.getExcelKeyValue("Qspider", 2, 0) + ranNum;

			cp.clickOnCampaignName(data1);
			cp.clickOnSelectProduct();
	//driver.findElement(By.name("campaignname")).sendKeys(data1);

	//driver.findElement(By.xpath("//img[@title='Select']")).click();
	//Window Switching
			WebDriver_Utility wlib1 = new WebDriver_Utility();
			wlib1.switchToWindow(driver, " Products&action");

			cp.clickOnSearchText(productdata);
			cp.clickOnSearchButton();

			/*
			 * driver.findElement(By.id("search_txt")).sendKeys(productdata);
			 * driver.findElement(By.name("search")).click();
			 */

	//Dynamic Xpath
			driver.findElement(By.xpath("//a[text()='" + productdata + "']")).click();

	//Switch back Window
			wlib1.switchToWindow(driver, " Campaigns&action");

			cp.clickOnSaveButton();
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			Thread.sleep(1000);

			String actData = cp.headText();

	//String actData = driver.findElement(By.className("dvHeaderText")).getText();

			if (actData.contains(data1)) {
				System.out.println("pass");
			} else {
				System.out.println("fail");
			}

		/*	hp1.clickOnAdministrator();
			hp1.clickOnSignOut();
			/*
			 * driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).
			 * click(); driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			 
			driver.close();*/

		}

	}


