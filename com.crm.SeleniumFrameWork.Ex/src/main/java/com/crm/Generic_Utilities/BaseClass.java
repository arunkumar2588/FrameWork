
package com.crm.Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.PageObjectModel.HomePage;
import com.crm.PageObjectModel.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void beforeSuiteTest() {
		System.out.println("Database Connection");
	}

	@BeforeTest(groups = { "smokeTest", "regressionTest" })
	public void beforeTest() {
		System.out.println("Execute in Parallel mode");
	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
//	public void beforeClass(String BROWSER) throws Throwable
	public void beforeClass() throws Throwable {
		File_Utility flib1 = new File_Utility();
		String BROWSER = flib1.getPropertyKeyValue("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver=driver;
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.waitForPageToLoad(driver);
		wlib.maximizeTheWindow(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void beforeMethod() throws Throwable {
		File_Utility flib = new File_Utility();
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("un");
		String PW = flib.getPropertyKeyValue("pw");

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.setLogin(UN, PW);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void afterMethod() {
		System.out.println("Logout the Application");
		HomePage hp2 = new HomePage(driver);
		hp2.clickOnAdministrator();
		hp2.clickOnSignOut();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void afterClass() {
		System.out.println("close the browser");
		driver.close();
		
	}

	@AfterTest(groups = { "smokeTest", "regressionTest" })
	public void afterTest() {
		System.out.println("Executed sucessfully");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void afterSuite() {
		System.out.println("Close Database");
	}
}
