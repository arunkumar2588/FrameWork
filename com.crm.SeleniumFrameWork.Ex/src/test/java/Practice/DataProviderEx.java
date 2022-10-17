package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
	
		@Test(dataProvider = "dataProvider_Test")
	public void trubleTickets(String title,String dest)
	{
		String key = "webdriver.chrome.driver";
		String value = "C:\\Users\\Arun\\Selenium\\com.crm.SeleniumFrameWork.Ex\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitbutton")).click();
		
			driver.findElement(By.linkText("Trouble Tickets")).click();
			driver.findElement(By.xpath("//img[@alt='Create Ticket...']")).click();
			driver.findElement(By.name("ticket_title")).sendKeys(title);
			driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']")).sendKeys(dest);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			System.out.println("Ticket created");
			driver.quit();
	}
		@DataProvider
		public Object[][] dataProvider_Test()
		{
			Object[][] objArr=new Object[2][2];
			objArr[0][0]="ABC";
			objArr[0][1]="Product";
			
			objArr[1][0]="XYZ";
			objArr[1][1]="Price";
			
			//objArr[2][0]="OLX";
			//objArr[2][1]="Specification";
			
			
			return objArr;
		}
		
}
