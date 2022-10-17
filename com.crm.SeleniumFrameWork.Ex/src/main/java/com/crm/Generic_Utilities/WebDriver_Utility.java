package com.crm.Generic_Utilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.Duration;

public class WebDriver_Utility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM
	 * 
	 * @author Arun
	 *
	 */

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * After every action it will wait for next action to perform
	 * 
	 * @author Arun
	 */
	public void scriptTimeOut(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * used to wait for element to be click able in GUI and check for specific
	 * element for every 500milliSeconds
	 * 
	 * @param driver
	 * @param Element
	 * @author Arun
	 */

	public void waitTillElementToBeClickable(WebDriver driver, WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Element));

	}

	/**
	 * used to wait for element to be click able in GUI and check for specific
	 * element for every 500milliSeconds
	 * 
	 * @param driver
	 * @param Element
	 * @param pollingTime
	 * @author Arun
	 */

	public void waitForElementWithCustomWait(WebDriver driver, WebElement Element, int pollingTime) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(java.time.Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	/**
	 * used to Switch ti any window based on window title
	 * 
	 * @param driver
	 * @param PartialWindiowTitle
	 */

	public void switchToWindow(WebDriver driver, String PartialWindiowTitle) {
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			if (driver.getTitle().contains(PartialWindiowTitle)) {
				break;
			}

		}

	}

	/**
	 * used to accept the alert popup
	 * 
	 * @param driver
	 * @author Arun
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	/**
	 * used to dismiss the alert pop up
	 * 
	 * @param driver
	 * @author Arun
	 */
	public void dismissAlert(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to switchTo frames based on the given index
	 * 
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to switchTo frames based on ID name Attribute
	 * 
	 * @param driver
	 * @param id_name_Attribute
	 * @author Arun
	 */
	public void SwitchToFrame(WebDriver driver, String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}

	/**
	 * used to select the value based on index
	 * 
	 * @param Element
	 * @param index
	 */

	public void select(WebElement Element, int index) {
		Select s = new Select(Element);
		s.selectByIndex(index);
	}

	/**
	 * used to select the value based on visible text
	 * 
	 * @param Element
	 * @param text
	 */
	public void select(WebElement Element, String text) {
		Select s = new Select(Element);
		s.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param Element
	 */

	public void mouseOverOnElement(WebDriver driver, WebElement Element) {
		Actions a = new Actions(driver);
		a.moveToElement(Element).perform();
	}

	/**
	 * used to right click on specific element
	 * 
	 * @param driver
	 * @param Element
	 */
	public void rightClickonElement(WebDriver driver, WebElement Element) {
		Actions a = new Actions(driver);
		a.contextClick(Element);
	}

	public void moveByOffest(WebDriver driver, int x, int y) {
		Actions a = new Actions(driver);
		a.moveByOffset(x, y);
	}

	/**
	 * used to wait for element to be click able in GUI and check for specific
	 * element for every 500milliSeconds
	 * 
	 * @param driver
	 * @param title
	 * @author Arun
	 */

	public void explicitlyWait(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs(title));
	}

	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
}
