package com.crm.Product;

import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.PageObjectModel.HomePage;
import com.crm.PageObjectModel.ProductPage;

public class CreateAndDeleteProduct extends BaseClass{

	//public static void main(String[] args) throws Throwable{
		@Test
		public void CreateAndDeleteProductTest() throws Throwable {
			
			WebDriver_Utility wlib=new WebDriver_Utility();
			wlib.waitForPageToLoad(driver);
			wlib.maximizeTheWindow(driver);
			/* driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 driver.manage().window().maximize();*/
			 
		/*	 File_Utility flib=new File_Utility();
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
			hp.clickOnProduct();
			//driver.findElement(By.linkText("Products")).click();
			
			ProductPage pp=new ProductPage(driver);
			pp.createProduct();
			
			//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			
			
			Java_Utility jlib=new Java_Utility();
			int ranNum = jlib.getRanDomNum();
			
			Excel_Utility elib=new Excel_Utility();
			String data1 = elib.getExcelKeyValue("Qspider",0, 0)+ranNum;
			
			
			pp.productName(data1);
			/*driver.findElement(By.name("productname")).sendKeys(data1);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			String Actdata = driver.findElement(By.className("lvtHeaderText")).getText();*/
			
			String Actdata = pp.headText();
			
			if(Actdata.contains(data1)) {
				System.out.println("Product is created ");
			}
			else {
				System.out.println("Product is not created");
			}
			
			pp.clickOnDeleteProduct(driver);
			//driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
			//driver.switchTo().alert().accept();
			
		}

	}

	