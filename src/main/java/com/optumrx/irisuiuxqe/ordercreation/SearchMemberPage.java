package com.optumrx.irisuiuxqe.ordercreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.optumrx.irisuiuxqe.util.ComponentMethods;
import com.optumrx.irisuiuxqe.util.Constants;
import com.optumrx.irisuiuxqe.util.GenericMethods;



public class SearchMemberPage {
	
	public SearchMemberPage()
	{
		try {
		GenericMethods.driver.navigate().to(Constants.URL_QA_MEMBERSEARCH);
	} catch (Exception e) {
		System.out.println("Constructor Issue");
	}
		
	}
	
	/**
	 * Logout application from Member Search Page
	 * @throws Exception
	 */
	public void logout() throws Exception
	{
		try {
			ComponentMethods.clickOnWebElelent("xpath_link_username");
						
			ComponentMethods.clickOnWebElelent("xpath_btn_logout");
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Verify First Name And Last Name Required On Member Search Page
	 * @throws Exception
	 */
	  
	public void verifyFirstNameAndLastNameRequiredOnMemberSearchPage() throws Exception
	{
		try {
			
			String expErrorMessageFirstName = Constants.TestData.get("ErrorMessageFirstName");
			String expErrorMessageLastName = Constants.TestData.get("ErrorMessageLastName");
			ComponentMethods.clickOnWebElelent("id_txtbox_FirstName");
			ComponentMethods.clickOnWebElelent("id_txtbox_LastName");
			String actErrorMessageFirstName = ComponentMethods.getText("xpath_message_FirstNameRequired");
			
			ComponentMethods.clickOnWebElelent("id_txtbox_DOB");
			String actErrorMessageLastNAme = ComponentMethods.getText("xpath_message_LastNameRequired");
			
			if(expErrorMessageFirstName.equalsIgnoreCase(actErrorMessageFirstName)&&expErrorMessageLastName.equalsIgnoreCase(actErrorMessageLastNAme))
			{
				Assert.assertTrue(true);
			}else{
				Assert.assertTrue(false);
			}			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * To verify that only numeric data is accepted as Account number
	 * @throws Exception 
	 */
	public void verifyThatOnlyNumericDataIsAcceptedAsAccountNumber() throws Exception
	{
		try {
			String textData = Constants.TestData.get("TextData");
			ComponentMethods.enterValueInTextBox("id_txtbox_AccountNumber","TextData");
			boolean isAccountNumberNumeric = false;
			
			WebElement txtAccountNumber = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_txtbox_AccountNumber", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			
			String actTextData = txtAccountNumber.getAttribute("value");
			if(!textData.equalsIgnoreCase(actTextData))
			{
				isAccountNumberNumeric = true;
			}
			
			Thread.sleep(1000);
						
			String numericData = Constants.TestData.get("NumericData");
			ComponentMethods.enterValueInTextBox("id_txtbox_AccountNumber","NumericData");
			String actNumericData = txtAccountNumber.getAttribute("value");
			
			if(numericData.equals(actNumericData))
			{
				isAccountNumberNumeric = true;
			}else{
				isAccountNumberNumeric = false;
			}
			
			Assert.assertTrue(isAccountNumberNumeric);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void verifyThatOnlyNumericDataIsAcceptedAsRxNumber()
	{
		try {
			
		} catch (Exception e) {
			throw e;
		}
	}

}
