package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws Throwable {
		String Key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		
		FileInputStream fis=new FileInputStream("./Common_DataMakeMyTrip.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		//from
		String srccity = "Bengaluru, India";
		WebElement src = driver.findElement(By.id("fromCity"));
		src.sendKeys("'"+srccity+"'");
		driver.findElement(By.xpath("//p[text()='"+srccity+"']")).click();

		//to
		String srcdestination = "Mumbai, India";
		WebElement dest = driver.findElement(By.id("toCity"));
		dest.sendKeys("'"+srcdestination+"'");
		driver.findElement(By.xpath("//p[text()='"+srcdestination+"']")).click();

		
		/*FileInputStream fis1=new FileInputStream("./MakemyTrip.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		
		String from = cel.getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		
		Workbook book1=WorkbookFactory.create(fis1);
		Sheet sh1 = book1.getSheet("Sheet1");
		Row row1 = sh1.getRow(1);
		Cell cel1 = row1.getCell(0);
		
		String to = cel.getStringCellValue();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(to);*/
		
		driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[1]")).click();
		driver.findElement(By.xpath("(//div[p='29'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[2]")).click();
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		driver.findElement(By.xpath("(//div[@class='dateInnerCell'])[10]")).click();
		driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
		
		String adult = "adults-5";
		driver.findElement(By.xpath("//li[@data-cy='"+adult+"']")).click();
		
		String children = "children-1";
		driver.findElement(By.xpath("//li[@data-cy='"+children+"']")).click();
		
		String infants = "infants-1";
		driver.findElement(By.xpath("//li[@data-cy='"+infants+"']")).click();
		
		String businessclass = "travelClass-2";
		driver.findElement(By.xpath("//li[@data-cy='"+businessclass+"']")).click();
		
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
	}
	}


