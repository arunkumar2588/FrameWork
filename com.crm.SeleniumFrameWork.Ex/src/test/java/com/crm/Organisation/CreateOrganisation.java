package com.crm.Organisation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.PageObjectModel.HomePage;
import com.crm.PageObjectModel.OrganisationPage;
import com.crm.PageObjectModel.VerificationAndValidation;

public class CreateOrganisation extends BaseClass{
//public static void main(String[] args) throws Throwable {
	//@Test(groups = "smokeTest")
		//@Test(retryAnalyzer=com.crm.Generic_Utilities.RetryAnalyser1.class)
	 	@Test
		public void CreateOrganisationTest() throws Throwable {
			
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
			hp.clickOnOrg();
			//driver.findElement(By.linkText("Organizations")).click();
			
		//Assert.assertEquals(true,false);
			
			OrganisationPage op=new OrganisationPage(driver);
			op.ClickOnCrecateOrg();
			
			//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			Java_Utility jlib=new Java_Utility();
			int ranNum = jlib.getRanDomNum();
			
			Excel_Utility elib=new Excel_Utility();
			String data1 = elib.getExcelKeyValue("Qspider",0, 0)+ranNum;
			
			OrganisationPage op1=new OrganisationPage(driver);
			op1.OrgName(data1);
			
		/*	SoftAssert soft=new SoftAssert();
			soft.assertEquals("A", "B");*/
				
			op1.clickOnSave();
			/*driver.findElement(By.name("accountname")).sendKeys(data1);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
			
			
			VerificationAndValidation verify=new VerificationAndValidation(driver);
			verify.verifyAndValidation(driver, data1);
			
			//soft.assertAll();
					
		/*	String Actdata = op1.setheadtext();
			//String Actdata = driver.findElement(By.className("dvHeaderText")).getText();
			System.out.println(Actdata);

			if(Actdata.contains(data1)) {
				System.out.println("organization is created");
			}
			else {
				System.out.println("organization is not created");
			}
			
		/*	hp.clickOnAdministrator();
			hp.clickOnSignOut();
			/*WebElement ele = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
			Actions a=new Actions(driver);
			a.moveToElement(ele).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/

				}
	
	/*	@Test
		public void modifyOrg() {
			System.out.println("organization is passed");
		}
		}*/
}

