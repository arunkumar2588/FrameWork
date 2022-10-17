package com.crm.Campaign;

import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.PageObjectModel.CampaignPage;
import com.crm.PageObjectModel.HomePage;

public class CreateCampaign extends BaseClass {

	//public static void main(String[] args)throws Throwable {
		@Test
		public void CreateCampaignTest() throws Throwable {
			
			
			WebDriver_Utility wlib=new WebDriver_Utility();
			wlib.waitForPageToLoad(driver);
			wlib.maximizeTheWindow(driver);
			/* driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 driver.manage().window().maximize();*/
			 
			/* File_Utility flib=new File_Utility();
			 String URL = flib.getPropertyKeyValue("url");
			 String UN = flib.getPropertyKeyValue("un");
			 String PW = flib.getPropertyKeyValue("pw");

			driver.get(URL);
			LoginPage lp=new LoginPage(driver);
			lp.setLogin(UN, PW);
			
			/*driver.findElement(By.name("user_name")).sendKeys(UN);
			driver.findElement(By.name("user_password")).sendKeys(PW);
			driver.findElement(By.id("submitButton")).click();*/
			
			HomePage hp=new HomePage(driver);
			hp.clickOnMore();
			//WebElement more1 = driver.findElement(By.xpath("//img[@style='padding-left:5px']"));
			
			
		/*	WebDriver_Utility wlib=new WebDriver_Utility();
			wlib.mouseOverOnElement(driver, more1);*/
			
			
			//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
			hp.clickOnCampaign();
			
			CampaignPage cp=new CampaignPage(driver);
			cp.clickOnCreateCampaign();
			
			
			//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			
			Java_Utility jlib=new Java_Utility();
			int ranNum = jlib.getRanDomNum();
			
			Excel_Utility elib=new Excel_Utility();
			String data1 = elib.getExcelKeyValue("Qspider",2, 0)+ranNum;
			
			
			
			cp.clickOnCampaignName(data1);
			cp.clickOnSaveButton();
			String Actdata = cp.headText();
			
			/*driver.findElement(By.name("campaignname")).sendKeys(data1);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			String Actdata = driver.findElement(By.className("dvHeaderText")).getText();*/
			
			if(Actdata.contains(data1)) {
				System.out.println("Campaign is created");
				System.out.println("open");
			}
			else
			{
				System.out.println("Campaign is not Created");
			}
			}

	}


