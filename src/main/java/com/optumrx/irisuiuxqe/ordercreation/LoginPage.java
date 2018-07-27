package com.optumrx.irisuiuxqe.ordercreation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.remote.strprotocol.GenericMessage;

import com.optumrx.irisuiuxqe.util.ComponentMethods;
import com.optumrx.irisuiuxqe.util.Constants;
import com.optumrx.irisuiuxqe.util.GenericMethods;

public class LoginPage {
	/**
	 * Login to UiUx Application using ID and Password
	 * 
	 * @throws Exception
	 */

	public void login() throws Exception {
		try {
			Thread.sleep(2000);
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			//System.out.println("");
			ComponentMethods.enterValueInTextBox("id_txt_UserName", "UserName", "id_txt_Password", "Password");
			ComponentMethods.clickOnWebElelent("id_btn_Login");
			
			/*
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			WebElement txtbx = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_txt_UserName",Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			txtbx.sendKeys("ddayal");
			
			WebElement txtpwd = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_txt_Password",Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			txtpwd.sendKeys("Sit@r@m10");
			
			ComponentMethods.clickOnWebElelent("id_btn_Login");*/
			
			/*
			 * WebElement userName =
			 * GenericMethods.driver.findElement(By.xpath(GenericMethods.
			 * getPageObject("txt__UserName"))); Thread.sleep(2500); //
			 * userName.sendKeys(OrderCreationTest.TestData.get("LoginId"));
			 * userName.sendKeys(ExcelUtils.getCellData(1, 0));
			 * 
			 * WebElement password =
			 * GenericMethods.driver.findElement(By.xpath(GenericMethods.
			 * getPageObject("txt_Password"))); //
			 * password.sendKeys(OrderCreationTest.TestData.get("LoginPassword")
			 * ); password.sendKeys(ExcelUtils.getCellData(1, 1));
			 * 
			 * WebElement login =
			 * GenericMethods.driver.findElement(By.xpath(GenericMethods.
			 * getPageObject("btn_Login"))); login.click();
			 * 
			 * // System.out.println(GMethods.alertGetText());
			 * 
			 * GenericMethods.alertAccept();
			 * 
			 * 
			 * // Multi Argument Method // String propertiesFileObj =
			 * Constants.PATH_LOCATORS_ORDERCREATION;
			 * Constants.OBJECT_CURRENT_PROPERTIESFILE =
			 * Constants.OBJECT_LOCATORS_ORDERCREATION; //
			 * ComponentMethods.enterValueInTextBox("id_txt__UserName", //
			 * "UserName", "id_txt_Password", "Password");
			 * ComponentMethods.enterValueInTextBox("id_txt__UserName",
			 * "UserName", "id_txt_Password", "Password"); //
			 * ComponentMethods.clickOnWebElelent("xpath_btn_Login");
			 * 
			 * ComponentMethods.clickOnWebElelent("id_btn_Login");
			 * 
			 * // ComponentMethods.checkErrorMessageAndReEnterValues(
			 * "xpath_msg_username", // "id_txt__UserName", "UserName"); //
			 * ComponentMethods.checkErrorMessageAndReEnterValues(
			 * "xpath_msg_password", // "id_txt_Password", "Password");
			 */
		} catch (Exception e) {
			GenericMethods.takeScreenshot(Constants.TestCaseName);
			throw e;
		}
	}

	/**
	 * Verifying all the text boxes and login button displays on login screen
	 */
	public void verifyLoginPage() {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			WebElement txtbox_username = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_txt_UserName", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement txtbox_password = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_txt_Password", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement btn_login = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_btn_Login", Constants.OBJECT_CURRENT_PROPERTIESFILE)));

			if ((txtbox_username).isDisplayed() && txtbox_password.isDisplayed() && btn_login.isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Validate Login Page Title
	 */
	public void verifyLoginTitle() {
		try {
			String actPageTitle = GenericMethods.driver.getTitle();
			String expPageTitle = Constants.TestData.get("Title");
			Assert.assertEquals(actPageTitle, expPageTitle);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verifying Password field encryption
	 */
	public void verifyPasswordEncryption() {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			WebElement password = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_txt_Password", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			String actAttributeValue = password.getAttribute(Constants.TestData.get("ElementAttribute"));
			String expAttributeValue = Constants.TestData.get("AttributeValue");
			Assert.assertEquals(actAttributeValue, expAttributeValue);

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verifying Spelling for Page Title, Username Text box, Password text box,
	 * and Login button text
	 */
	public void verifySpelling() {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;

			String actPageTitle = GenericMethods.driver.getTitle();

			WebElement username = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_txt_UserName", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			String actUsernameText = username.getAttribute("placeholder");

			WebElement password = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_txt_Password", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			String actPasswordText = password.getAttribute("placeholder");

			WebElement login = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_btn_Login", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			String actLoginText = login.getText();

			String expPageTitle = Constants.TestData.get("PageTitle");
			String expUsernameText = Constants.TestData.get("UserName");
			String expPasswordText = Constants.TestData.get("Password");

			if (actPageTitle.equals(expPageTitle) && actUsernameText.equals(expUsernameText)
					&& actPasswordText.equals(expPasswordText)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * verfiy the Validation message after entering a valid username , leaving
	 * the password blank
	 * 
	 * @throws Exception
	 */
	public void verifyValidUernameBlankPassword() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			ComponentMethods.enterValueInTextBox("id_txt_UserName", "Username");
			ComponentMethods.clickOnWebElelent("id_txt_Password");
			ComponentMethods.clickOnWebElelent("id_txt_UserName");

			String actErrormsg = ComponentMethods.getText("xpath_errormsg_Password");
			String expErrormsg = Constants.TestData.get("Errormsg");

			Assert.assertEquals(actErrormsg, expErrormsg);

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verifying Validation message when user enters invalid username and
	 * password
	 * 
	 * @throws Exception
	 */
	public void verifyInvalidUsernamePassword() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			ComponentMethods.clickOnWebElelent("id_txt_UserName");
			ComponentMethods.clickOnWebElelent("id_txt_Password");

			String actErrormsgUserName = ComponentMethods.getText("xpath_errormsg_UserName");
			String expErrormsgUserName = Constants.TestData.get("ErrormsgUserName");

			ComponentMethods.clickOnWebElelent("id_txt_UserName");

			String actErrormsgPassword = ComponentMethods.getText("xpath_errormsg_Password");
			String expErrormsgPassword = Constants.TestData.get("ErrormsgPassword");

			if (actErrormsgUserName.equals(expErrormsgUserName) && actErrormsgPassword.equals(expErrormsgPassword)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verifying Login with Valid User Name and and Valid password
	 * 
	 * @throws Exception
	 */
	public void verifyLoginWithValidUsernamePassword() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			ComponentMethods.enterValueInTextBox("id_txt_UserName", "Username", "id_txt_Password", "Password");
			ComponentMethods.clickOnWebElelent("id_btn_Login");

			String actSelectWorkAreaHeader = ComponentMethods.getText("xpath_text_SelectWorkArea");
			String expSelectWorkAreaHeader = Constants.TestData.get("SelectWorkAreaHeader");

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
			/*SWAP.selectWorkArea();

			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
*/
			Assert.assertEquals(actSelectWorkAreaHeader, expSelectWorkAreaHeader);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verifying Page elements appearance after refresh the page
	 * 
	 * @throws Exception
	 */
	public void verifyResultAfterRefresh() throws Exception {
		try {
			Thread.sleep(1000);
			GenericMethods.driver.navigate().refresh();
			verifyLoginPage();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verify with an un authorized User
	 * 
	 * @throws Exception
	 */
	public void verifyADGroupAuthorization() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			ComponentMethods.enterValueInTextBox("id_txt_UserName", "UnAuthUserName", "id_txt_Password", "Password");
			ComponentMethods.clickOnWebElelent("id_btn_Login");

			String actUnAuthErrorMessage = ComponentMethods.getText("xpath_unauthorizeduser_errormessage");
			String expUnAuthErrorMessage = Constants.TestData.get("UnAuthErrorMsg");

			Assert.assertEquals(actUnAuthErrorMessage, expUnAuthErrorMessage);

		} catch (Exception e) {
			throw e;
		}
	}
	
	public void verifyPresenceOfPlaceholders() throws Exception
	{
		try
		{
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			WebElement username = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_txt_UserName", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			
			String actUsernamePlaceholder = username.getAttribute("placeholder");
			
			WebElement password = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_txt_Password", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			String actPasswordPlaceholder = password.getAttribute("placeholder");
			
			String expUsernamePlaceholder= Constants.TestData.get("UserName");
			String expPasswordPlaceholder= Constants.TestData.get("Password");
			
			if(actUsernamePlaceholder.equals(expUsernamePlaceholder)&& actPasswordPlaceholder.equals(expPasswordPlaceholder))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		catch(Exception e){
			throw e;
		}
	}
	
	
	/**
	 * This method verifies that the copy paste option is disabled for username field
	 * @throws Exception
	 */
	public void verifyCopyPasteDisabled() throws Exception
	{
		try {
			String copy = Keys.chord(Keys.CONTROL, "c");
			String paste= Keys.chord(Keys.CONTROL,"v");
			String selectAll=Keys.chord(Keys.CONTROL,"a");
			String initialText="initialText";
			String expectedText="expected";
			
			
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			WebElement username = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_txt_UserName", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			ComponentMethods.clickOnWebElelent("id_txt_UserName");
			username.sendKeys(initialText);
			username.sendKeys(selectAll);
			username.sendKeys(copy);
			username.sendKeys(expectedText);
			username.sendKeys(paste);
			
			String actualText=username.getAttribute("value");
			
			Assert.assertEquals(actualText, expectedText);
			
		} catch (Exception e) {
			throw e;
		}
				
		
	}
	
	


}
