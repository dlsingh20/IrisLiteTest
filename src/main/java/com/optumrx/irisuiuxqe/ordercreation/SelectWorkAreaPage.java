package com.optumrx.irisuiuxqe.ordercreation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.optumrx.irisuiuxqe.util.ComponentMethods;
import com.optumrx.irisuiuxqe.util.Constants;
import com.optumrx.irisuiuxqe.util.ExcelUtils;
import com.optumrx.irisuiuxqe.util.GenericMethods;

public class SelectWorkAreaPage {
	/**
	 * Verify Work area page with Page Header
	 * 
	 * @throws Exception
	 */
	public void verifyWorkAreaPage() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			String actResult = ComponentMethods.getText("xpath_text_SelectWorkArea");
			// String expResult = ExcelUtils.getCellData(1, 2);
			String expResult = Constants.TestData.get("SelectWorkAreaHeader");
			if (!actResult.equalsIgnoreCase(expResult)) {
				GenericMethods.takeScreenshot(Constants.TestCaseName);
				Assert.assertFalse(false);
			} else {
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Will Select all work area as per test case and press Search
	 * 
	 * @throws Exception
	 */
	public void selectWorkArea() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			GenericMethods.selectValueFromDropDownByValue("id_dropdown_Queue", "1: OC");
			ComponentMethods.clickOnWebElelent("id_btn_Search");
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @throws Exception 
	 * 
	 */
	public void verifyAllElementsOnWorkAreaSelectionPage() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			WebElement queue = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_dropdown_Queue", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement business = GenericMethods.driver.findElement(By
					.id(GenericMethods.getPageObject("id_dropdown_Business", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement cell = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_dropdown_Cell", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement source = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_dropdown_Source", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement saveaspreset = GenericMethods.driver.findElement(By.id(
					GenericMethods.getPageObject("id_checkbox_SaveAsPreset", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement reset = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_btn_Reset", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement search = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_btn_Search", Constants.OBJECT_CURRENT_PROPERTIESFILE)));

			if (queue.isDisplayed() && queue.isEnabled() && business.isDisplayed() && business.isEnabled()
					&& cell.isDisplayed() && cell.isEnabled() && source.isDisplayed() && source.isEnabled()
					&& saveaspreset.isDisplayed() && saveaspreset.isEnabled() && reset.isDisplayed()
					&& reset.isEnabled() && search.isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				GenericMethods.takeScreenshot(Constants.TestCaseName);
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	//
	public void verifyDropDownValueFromDatabase() throws Exception {
		try {
			String business = GenericMethods.getPageObject("id_dropdown_Business",
					Constants.OBJECT_CURRENT_PROPERTIESFILE);
			WebElement ele = GenericMethods.driver.findElement(By.id(business));
			Select select = new Select(ele);
			List<WebElement> str = select.getOptions();
			
			ArrayList AL = new ArrayList();
			
			for (int i = 1; i < str.size(); i++) {
				String da = str.get(i).getText();
				AL.add(da);
				
			}

			String businessValues = Constants.TestData.get("BusinessData");
			
			ArrayList ALi = new ArrayList();
			ALi.add(businessValues.split(","));
			System.out.println("");
			
			/*  GenericMethods.createDBConnection(); 
			  String orQuery = "select MEANING from xxiris_lookup_values where LOOKUP_TYPE = 'BUSINESS';";
			  ResultSet rs = GenericMethods.getTestData(orQuery);
			  int i=1;
			  ArrayList ALi = new ArrayList();
			  while(rs.next())
			  {
				  ALi.add(rs.getString(i));
				  i++;
			  }
			  System.out.println("");
			  
			  String businessQuery =
			  "select MEANING from xxiris_lookup_values where LOOKUP_TYPE = 'BUSINESS';";
			  ResultSet businessdata = GenericMethods.getTestData(businessQuery);
			  
			  while(businessdata.next()) { 
				  String data = businessdata.getString(1);
			  
			  
			  }
			 */

		} catch (Exception e) {
			throw e;
		}
	}

	public void verifySearchButtonDisable() throws Exception {
		try {
			WebElement btn_search = GenericMethods.driver.findElement(
					By.id(GenericMethods.getPageObject("id_btn_Search", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			if (!btn_search.isEnabled()) {
				Assert.assertTrue(true);
			} else {
				GenericMethods.takeScreenshot(Constants.TestCaseName);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/** 
	 * Select Some vales in Drop-downs and then press Reset Button
	 * @throws Exception
	 */
	public void verifyClearCurrentSelectionUsingRestButton() throws Exception
	{
		try {
			GenericMethods.selectValueFromDropDownByIndex("id_dropdown_Queue", 1);
			GenericMethods.selectValueFromDropDownByIndex("id_dropdown_Business", 1);
			GenericMethods.selectValueFromDropDownByIndex("id_dropdown_Cell", 1);
			GenericMethods.selectValueFromDropDownByIndex("id_dropdown_Source", 1);
			//Thread.sleep(2000);
			ComponentMethods.clickOnWebElelent("id_btn_Reset");
			
			String actQueueValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Queue");
			String expQueueValue =Constants.TestData.get("QueueData");
			
			String actBusinessValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Business");
			String expBusinessValue  =Constants.TestData.get("BusinessData");
			
			String actCellValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Cell");
			String expCellValue =Constants.TestData.get("CellData");
			
			String actSourceValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Source");
			String expSourceValue =Constants.TestData.get("SourceData");
			
			if(actQueueValue.equals(expQueueValue) && actBusinessValue.equals(expBusinessValue) && actCellValue.equals(expCellValue) && actSourceValue.equals(expSourceValue))
			{
				Assert.assertTrue(true);
			}else{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
				Assert.assertTrue(false);
			}			
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Save As Preset Click Search
	 * @throws Exception
	 */
	public void verifySaveAsPresetClickSearch() throws Exception
	{
		try {
			//System.out.println("");
			//GenericMethods.driver.navigate().refresh();
			String QueueValue =Constants.TestData.get("QueueData");
			String BusinessValue  =Constants.TestData.get("BusinessData");
			String CellValue =Constants.TestData.get("CellData");
			String SourceValue =Constants.TestData.get("SourceData");
			
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue", QueueValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Business", BusinessValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Cell", CellValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Source", SourceValue);
			
			ComponentMethods.clickOnWebElelent("id_checkbox_SaveAsPreset");
			String winID1 = GenericMethods.getCurrentWindowId();
			ComponentMethods.clickOnWebElelent("id_btn_Search");
			
			//String winID = GenericMethods.getCurrentWindowId();
			//Set<String> str = GenericMethods.driver.getWindowHandles();
			//GenericMethods.switchToNewWindow(winID);
			
			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
			Thread.sleep(2500);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			
			String actQueueValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Queue");
			String actBusinessValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Business");
			String actCellValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Cell");
			String actSourceValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Source");
			
			if(QueueValue.equals(actQueueValue)&&BusinessValue.equals(actBusinessValue)&&CellValue.equals(actCellValue)&&SourceValue.equals(actSourceValue))
			{
				Assert.assertTrue(true);
			}else{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
				Assert.assertTrue(false);
			}		
				
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void verifyResetButtonClearUserPreset() throws Exception
	{
		try {
			String QueueValue =Constants.TestData.get("QueueData");
			String BusinessValue  =Constants.TestData.get("BusinessData");
			String CellValue =Constants.TestData.get("CellData");
			String SourceValue =Constants.TestData.get("SourceData");
			
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue", QueueValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Business", BusinessValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Cell", CellValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Source", SourceValue);
			
			ComponentMethods.clickOnWebElelent("id_checkbox_SaveAsPreset");
			ComponentMethods.clickOnWebElelent("id_btn_Search");
			
			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
			Thread.sleep(2500);
			
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			
			ComponentMethods.clickOnWebElelent("id_btn_Reset");
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue", QueueValue);
			ComponentMethods.clickOnWebElelent("id_btn_Search");
			
			SMP.logout();
			Thread.sleep(2500);
			LP.login();
			Thread.sleep(2500);
			
			String actQueueValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Queue");
			String actBusinessValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Business");
			String actCellValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Cell");
			String actSourceValue = GenericMethods.getSelectedTextOfDropdown("id_dropdown_Source");
			
			if(actQueueValue.contains("Select") && actBusinessValue.contains("Select") && actCellValue.contains("Select") && actSourceValue.contains("Select"))
			{
				Assert.assertTrue(true);
			}else{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 *  Method to verify that the Tab Sequence on the Work Area Selection Page  is as Desired 
	 * @throws Exception 
	 */
	public void verifyTabSequence() throws Exception
	{
		try
		{
		String QueueValue =Constants.TestData.get("QueueData");
		String BusinessValue  =Constants.TestData.get("BusinessData");
		String CellValue =Constants.TestData.get("CellData");
		String SourceValue =Constants.TestData.get("SourceData");
		boolean tabSequenceIsCorrect=true;
		
		
		// Check that cursor is peresnt on Queue drop down by default 
		
		if(!(GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_dropdown_Queue",Constants.OBJECT_CURRENT_PROPERTIESFILE))).equals(GenericMethods.driver.switchTo().activeElement())))
		{
			tabSequenceIsCorrect=false; 
		}
		//Select a value from Queue drop down 
		GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue", QueueValue);
		//Press tab and verify that the cursor moves to Business drop down 
		
		GenericMethods.driver.switchTo().activeElement().sendKeys(Keys.TAB);
		if(!(GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_dropdown_Business",Constants.OBJECT_CURRENT_PROPERTIESFILE))).equals(GenericMethods.driver.switchTo().activeElement())))
		{
			tabSequenceIsCorrect=false;
		}
		
		//Press tab and verify that the cursor moves to Cell  drop down
		GenericMethods.driver.switchTo().activeElement().sendKeys(Keys.TAB);
		if(!(GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_dropdown_Cell",Constants.OBJECT_CURRENT_PROPERTIESFILE))).equals(GenericMethods.driver.switchTo().activeElement())))
		{
			tabSequenceIsCorrect=false;
		}
		
		//Press tab and verify that the cursor moves to Source  drop down
		GenericMethods.driver.switchTo().activeElement().sendKeys(Keys.TAB);
		if(!(GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_dropdown_Source",Constants.OBJECT_CURRENT_PROPERTIESFILE))).equals(GenericMethods.driver.switchTo().activeElement())))
		{
			tabSequenceIsCorrect=false;
		}
		
		//Press tab and verify that the cursor moves to Search button
		GenericMethods.driver.switchTo().activeElement().sendKeys(Keys.TAB);
		if(!(GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_btn_Search",Constants.OBJECT_CURRENT_PROPERTIESFILE))).equals(GenericMethods.driver.switchTo().activeElement())))
		{
			tabSequenceIsCorrect=false;
		}
		
		Assert.assertTrue(tabSequenceIsCorrect);
		 }
		
		
		catch(Exception e){
			
			throw e;
		}
		
	}
	/**
	 *  Method to verify that reset button is accesible via hot key 
	 * @throws Exception 
	 */
	public void verifyResetButtonHotKey() throws Exception
	{
		try {
			String QueueValue =Constants.TestData.get("QueueData");
			String BusinessValue  =Constants.TestData.get("BusinessData");
			String CellValue =Constants.TestData.get("CellData");
			String SourceValue =Constants.TestData.get("SourceData");
			String QueueResetValue=Constants.TestData.get("QueueResetValue");
			String BusinessResetValue=Constants.TestData.get("BusinessResetValue");
			String CellResetValue=Constants.TestData.get("CellResetValue");
			String SourceResetValue=Constants.TestData.get("SourceResetValue");
			String resetHotKey=Keys.chord(Keys.ALT, "r");
			boolean isResetAccesibleViaHotKey=true;
			
			// Select some values from all the drop downs 
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue", QueueValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Business", BusinessValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Cell", CellValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Source", SourceValue);
			
			// Click on the Reset button via hot Key
			GenericMethods.driver.switchTo().activeElement().sendKeys(resetHotKey);
			
			//Verify that the values are reset 
			if(!(GenericMethods.getSelectedTextOfDropdown("id_dropdown_Queue").equals(QueueResetValue)))
			{
				isResetAccesibleViaHotKey=false;
			}
			
			if(!(GenericMethods.getSelectedTextOfDropdown("id_dropdown_Business").equals(BusinessResetValue)))
			{
				isResetAccesibleViaHotKey=false;
			}
			
			if(!(GenericMethods.getSelectedTextOfDropdown("id_dropdown_Cell").equals(CellResetValue)))
			{
				isResetAccesibleViaHotKey=false;
			}
			
			if(!(GenericMethods.getSelectedTextOfDropdown("id_dropdown_Source").equals(SourceResetValue)))
			{
				isResetAccesibleViaHotKey=false;
			}
			
			Assert.assertTrue(isResetAccesibleViaHotKey);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void verifySearchButtonHotKey() throws Exception
	{
		try {
			String QueueValue =Constants.TestData.get("QueueData");
			String searchHotKey=Keys.chord(Keys.ALT, "s");
			boolean isSearchAccesibleViaHotKey=true;
			String expectedResult=Constants.TestData.get("SearchMemberHeader");
			String actualResult;
			// Select some values from all the drop downs 
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue", QueueValue);
			
			// Click on the search button via hot Key
			GenericMethods.driver.switchTo().activeElement().sendKeys(searchHotKey);
			
			//Verify that the basic member search page is displayed
			actualResult=ComponentMethods.getText("id_searchMember_head");
			Assert.assertEquals(actualResult, expectedResult);
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	
	
	public void verifyShiftTab() throws Exception
	{
		
		try
		{
		String QueueValue =Constants.TestData.get("QueueData");
		String BusinessValue  =Constants.TestData.get("BusinessData");
		String CellValue =Constants.TestData.get("CellData");
		String SourceValue =Constants.TestData.get("SourceData");
		boolean isShiftPlusTabWorking=true;
		String shiftPlusTab=Keys.chord(Keys.SHIFT,Keys.TAB);
		
		
		
		
		//Select a value from Queue drop down 
		GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue", QueueValue);
		//Press tab  
		GenericMethods.driver.switchTo().activeElement().sendKeys(Keys.TAB);
		//Hit Shift + Tab and verify the result 
		GenericMethods.driver.switchTo().activeElement().sendKeys(shiftPlusTab);
		isShiftPlusTabWorking=GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_dropdown_Queue",Constants.OBJECT_CURRENT_PROPERTIESFILE))).equals(GenericMethods.driver.switchTo().activeElement());
		Assert.assertTrue(isShiftPlusTabWorking);
		 }		
		catch(Exception e){
			throw e;
		}
		
	}
	/**
	 * Verify Global Banner On Work AreaSelection Page
	 * @throws Exception
	 */
	public void verifyGlobalBannerOnWorkAreaSelectionPage() throws Exception
	{
		try {
			WebElement banner = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_banner", Constants.OBJECT_CURRENT_PROPERTIESFILE)));	
			if(banner.isDisplayed())
			{
				Assert.assertTrue(true);
				//System.out.println("");
			}else
			{
				Assert.assertTrue(false);
			}
			
			/*
			ComponentMethods.clickOnWebElelent("xpath_link_username");
			WebElement logout = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_btn_logout", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			if (logout.isDisplayed() && logout.isEnabled()) {
				Assert.assertTrue(true);
				ComponentMethods.clickOnWebElelent("xpath_link_username");
			}else{
				Assert.assertTrue(false);
			}*/
			
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Logout Application from WorkAreaSelection Page
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
	/** Verify Banner Functionality on Work Area Selection Page
	 * @throws Exception 
	 * 
	 */
	public void verifyFunctionalityOfBannerOnWorkAreaSelectionPage() throws Exception
	{
		try {
			WebElement logoutButton = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_btn_logout", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			//System.out.println("");
			ComponentMethods.clickOnWebElelent("xpath_link_drawerControl");
			
			String actOpenViewerText = ComponentMethods.getText("xpath_link_OpenViewer");
			//String actNextImageText = ComponentMethods.getText("id_link_OpenNextImage");
			String actCloseViewerText = ComponentMethods.getText("xpath_link_closeViewer");
			
			ComponentMethods.clickOnWebElelent("xpath_link_username");
			
			String expOpenImgViewerText = Constants.TestData.get("OpenImageViewerTest");
			//String expNextImageText = Constants.TestData.get("NextImageText");
			String expCloseImageViewerText = Constants.TestData.get("CloseImageViewerText");
						
			if(logoutButton.isDisplayed()&&logoutButton.isEnabled()&&actOpenViewerText.equalsIgnoreCase(expOpenImgViewerText)&&actCloseViewerText.equalsIgnoreCase(expCloseImageViewerText))
			{
				Assert.assertTrue(true);
				ComponentMethods.clickOnWebElelent("xpath_link_username");
			}else{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
				Assert.assertTrue(false);
			}
						
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Select Values from Drop-down and click search
	 * @throws Exception
	 */
	public void selectValuesFromDropdownAndClickSearch() throws Exception
	{
		try {
			String QueueValue =Constants.TestData.get("QueueData");
			String SourceValue =Constants.TestData.get("SourceData");
			
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue", QueueValue);
			GenericMethods.selectValueFromDropDownByText("id_dropdown_Source", SourceValue);
			
			ComponentMethods.clickOnWebElelent("id_btn_Search");
			Thread.sleep(2500);
		} catch (Exception e) {
			throw e;
		}
	}	
}
