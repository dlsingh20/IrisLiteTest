package com.optumrx.irisuiuxqe.util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComponentMethods {

	/**
	 * This methods will be used to enter values in two text box(es)
	 * 
	 * @param arg
	 *            Need to Pass arguments in pare of two(two, four, six etc) One
	 *            should be Xpath(Locator) Name as per Properties file and
	 *            second should be Test Data Key Name as per Test Data Sheet
	 * @throws Exception
	 */
	public static void enterValueInTextBox(String... arg) throws Exception {
		try {
			// Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(GenericMethods.driver, 45);
			WebElement textBox = null;
			for (int i = 0; i < arg.length; i = i + 2) {
				if (arg[i].contains("xpath")) {
					//textBox = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE)));
					textBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE))));
				} else if (arg[i].contains("id")) {
					//textBox = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE)));
					textBox = wait.until(ExpectedConditions.elementToBeClickable(By.id(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE))));
				} else if (arg[i].contains("name")) {
					//textBox = GenericMethods.driver.findElement(By.name(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE)));
					textBox = wait.until(ExpectedConditions.elementToBeClickable(By.name(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE))));
					
				} else {
					Assert.assertTrue(false);
				}
				
				String data = Constants.TestData.get(arg[i + 1]);
				
				if(!data.isEmpty()){
					textBox.sendKeys(data);
					//System.out.println("Data: "+data);
				}else{
					Assert.assertTrue("Test Data Not Found", false);
				}
				//textBox.sendKeys(Constants.TestData.get(arg[i + 1]));
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method will be used to click on web elements like Button, Links
	 * 
	 * @param arg
	 *            Need to pass Xpath(Locator)
	 * @throws Exception
	 */
	public static void clickOnWebElelent(String... arg) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(GenericMethods.driver, 15);
			WebElement search = null;
			for (int i = 0; i < arg.length; i++) {
				if (arg[i].contains("xpath")) {
					//search = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE)));
					search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE))));
				} else if (arg[i].contains("id")) {
					//search = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE)));
					search = wait.until(ExpectedConditions.elementToBeClickable(By.id(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE))));
				} else if (arg[i].contains("name")) {
					//search = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE)));
					search = wait.until(ExpectedConditions.elementToBeClickable(By.name(GenericMethods.getPageObject(arg[i], Constants.OBJECT_CURRENT_PROPERTIESFILE))));
				} else {
					Assert.assertTrue(false);
				}

				search.click();
			}

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This methods will be used to get Text of any panel, link or any web
	 * element
	 * 
	 * @param locator Name as per Properties file
	 * @return Text displaying on UI
	 */
	public static String getText(String locator) {
		try {
			WebElement stringValue = null;
			if (locator.contains("xpath")) {
				stringValue = GenericMethods.driver.findElement(
						By.xpath(GenericMethods.getPageObject(locator, Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			} else if (locator.contains("id")) {
				stringValue = GenericMethods.driver.findElement(
						By.id(GenericMethods.getPageObject(locator, Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			} else if (locator.contains("name")) {
				stringValue = GenericMethods.driver.findElement(
						By.id(GenericMethods.getPageObject(locator, Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			} else {
				Assert.assertTrue(false);
			}

			return stringValue.getText();
		} catch (Exception e) {
			return null;
		}
	}

	public static void checkErrorMessageAndReEnterValues(String errorLocatorName, String txtBoxLocator, String testData) throws Exception{
		try {
			WebElement ErrorMessage = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject(errorLocatorName, Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			if(ErrorMessage.isDisplayed())
			{
				enterValueInTextBox(txtBoxLocator, testData);
			}
		} catch (NoSuchElementException e) {
			e.getMessage();
		}catch(Exception e)
		{
			e.getMessage();
		}				
	}
	
	public static void selectValueFromDropDowns(String... arg)
	{
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
