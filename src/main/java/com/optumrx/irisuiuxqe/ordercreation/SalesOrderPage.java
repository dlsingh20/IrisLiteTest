package com.optumrx.irisuiuxqe.ordercreation;

import java.util.List;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.optumrx.irisuiuxqe.util.ComponentMethods;
import com.optumrx.irisuiuxqe.util.Constants;
import com.optumrx.irisuiuxqe.util.GenericMethods;

public class SalesOrderPage 
{
	/**
	 * Logout application from Sales Order Page
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
	 * Verify Global Banner On Work AreaSelection Page
	 * @throws Exception
	 */
	public void verifyGlobalBannerOnSalesOrderPage() throws Exception
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
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
									
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Order Summary Section availability on Sales Order Page
	 * @throws Exception
	 */
	public void verifyOrderSummarySectionavailabilityonSalesOrderPage() throws Exception
	{
		try {
			System.out.println("");
			WebElement orderSummaryPannel = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_Pannel_OrderSummary", Constants.OBJECT_CURRENT_PROPERTIESFILE)));	
			if(orderSummaryPannel.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify sequence of text to be displayed in Order Summary Section On Sales
	 * @throws Exception
	 */
	public void verifySequenceOfTextToBeDisplayedInOrderSummarySectionOnSalesOrderPage() throws Exception
	{
		try {
			boolean flag=true;
			List<WebElement> orderSummaryElements = GenericMethods.driver.findElements(By.xpath(GenericMethods.getPageObject("xpath_Pannel_AllElements_OrderSummary", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			for(int i=0; i<orderSummaryElements.size();i++)
			{
				if(i==0 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Order Number");
				}
				if(i==3 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Type");
				}
				if(i==5 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Select Business");
				}
				if(i==7 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Date Ordered");
				}
				if(i==10 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Cell");
				}
				if(i==12 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Select Cell");
				}
				if(i==14 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Source");
				}
				if(i==17 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Refill");
				}
				if(i==20 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("Status");
				}
				if(i==23 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("New Rx");
				}
				if(i==26 && flag==true)
				{
					flag = (orderSummaryElements.get(i).getText()).equalsIgnoreCase("OTC");
				}				
			}	
			if(flag==false)
			{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
			Assert.assertTrue(flag);
		} catch (Exception e) {
			GenericMethods.takeScreenshot(Constants.TestCaseName);
			throw e;
		}
	}
	
	/**
	 * Verify Patient Summary Section availability on Sales Order Page
	 * @throws Exception
	 */
	public void verifyPatientSummarySectionavailabilityonSalesOrderPage() throws Exception
	{
		try {
			
			WebElement patientSummaryPannel = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_Pannel_PatientSummary", Constants.OBJECT_CURRENT_PROPERTIESFILE)));	
			if(patientSummaryPannel.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verify sequence of text to be displayed in Patient Summary Section On Sales Order Page
	 * @throws Exception
	 */
	public void verifySequenceFfTextToBeDisplayedInPatientSummarySectionOnSalesOrderPage() throws Exception
	{
		try {
			boolean flag=true;
			List<WebElement> patientSummaryElements = GenericMethods.driver.findElements(By.xpath(GenericMethods.getPageObject("xpath_Pannel_AllElements_PatientSummary", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			for(int i=0; i<patientSummaryElements.size();i++)
			{
				//System.out.println(patientSummaryElements.get(i).getText()+" Index= "+i);
				if(i==0 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Patient");
				}
				if(i==3 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Account Number");
				}
				if(i==6 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("DOB");
				}
				if(i==9 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Phone No");
				}
				if(i==12 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Language");
				}
				if(i==15 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Ship To");
				}								
			}
			if(flag==false)
			{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
			Assert.assertTrue(flag);
		} catch (Exception e) {
			GenericMethods.takeScreenshot(Constants.TestCaseName);
			throw e;
		}
	}
	/**
	 * Verify Order Details Section availability on Sales Order Page
	 * @throws Exception 
	 * 
	 */
	public void verifyOrderDetailsSectionavailabilityonSalesOrderPage() throws Exception{
		try {
			WebElement orderDetailsPannel = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_Pannel_OrderDetails", Constants.OBJECT_CURRENT_PROPERTIESFILE)));	
			if(orderDetailsPannel.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Verify sequence of Column to be displayed in Order Details Section On Sales Order Page
	 * @throws Exception 
	 */
	public void verifysequenceofColumntobedisplayedinOrderDetailsSectionOnSalesOrderPage() throws Exception
	{
		try {
			boolean flag=true;
			List<WebElement> patientSummaryElements = GenericMethods.driver.findElements(By.xpath(GenericMethods.getPageObject("Xpath_Pannel_AllElements_OrderDetails", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			for(int i=0; i<patientSummaryElements.size();i++)
			{
				//System.out.println(patientSummaryElements.get(i).getText()+" Index= "+i);
				if(i==0 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Line No.");
				}
				if(i==1 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Line Type");
				}
				if(i==2 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Rx No.");
				}
				if(i==3 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Drug");
				}
				if(i==4 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Status");
				}
				if(i==5 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Qty");
				}
				if(i==6 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("UOM");
				}
				if(i==7 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Days");
				}
				if(i==8 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Cust Amt");
				}
				if(i==9 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Ship Set");
				}
				if(i==10 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Fill");
				}
				if(i==11 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("DOS");
				}
				if(i==12 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("Site");
				}
				if(i==13 && flag==true)
				{
					flag = (patientSummaryElements.get(i).getText()).equalsIgnoreCase("DAW");
				}								
			}
			if(flag==false)
			{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
			Assert.assertTrue(flag);
		} catch (Exception e) {
			GenericMethods.takeScreenshot(Constants.TestCaseName);
			throw e;
		}
	}
	/**
	 * Verify Notes Section availability on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyNotesSectionavailabilityonSalesOrderPage() throws Exception
	{
		try {
			WebElement notesText = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_text_notes", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement notesPannel = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_Section_Notes", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			if(notesText.isDisplayed() && notesPannel.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify My comments text box availability below notes section on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyMycommentstextboxavailabilitybelownotessectiononSalesOrderPage() throws Exception
	{
		try {
			WebElement commentTxtbx = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_txtbx_comment", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			if(commentTxtbx.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Account Summary section availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	public void verifyAccountSummarysectionavailabilityonSalesOrderPage() throws Exception{
		try {
			WebElement accountSummaryText = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_text_AccountSummary", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement accountSummaryPannel = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_Section_Account", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			if(accountSummaryText.isDisplayed() && accountSummaryPannel.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void verifyAllButtonsavailabilityatthebottomRightonSalesOrderPage() throws Exception
	{
		try {
			boolean IsButtonEnabled = true;
			WebElement BackButton = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_btn_back", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement ExceptionButton = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_btn_Exception", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement SplitImageButton = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_btn_SplitImage", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement SubmitOrderButton = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_btn_SubmitOrder", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			
			if(BackButton.isDisplayed() && BackButton.isEnabled())
			{
				IsButtonEnabled = true;
			}else{
				IsButtonEnabled = false;
			}
			
			if(ExceptionButton.isDisplayed() && ExceptionButton.isEnabled())
			{
				IsButtonEnabled = true;
			}else{
				IsButtonEnabled = false;
			}
			
			if(SplitImageButton.isDisplayed() && SplitImageButton.isEnabled())
			{
				IsButtonEnabled = true;
			}else{
				IsButtonEnabled = false;
			}
			
			if(SubmitOrderButton.isDisplayed() && SubmitOrderButton.isEnabled())
			{
				IsButtonEnabled = true;
			}else{
				IsButtonEnabled = false;
			}
			
			if(IsButtonEnabled==false)
			{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
			Assert.assertTrue(IsButtonEnabled);
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Hold section availability on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyHoldsectionavailabilityonSalesOrderPage() throws Exception
	{
		try {
			WebElement holdSection = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_section_Hold", Constants.OBJECT_CURRENT_PROPERTIESFILE)));	
			if(holdSection.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Available options under Hold section on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyAvailableoptionsunderHoldsectiononSalesOrderPage() throws Exception
	{
		try{
		boolean IsTextAvaialble = true;
		WebElement TextHold = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_text_Hold", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
		WebElement TextRelease = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_text_Release", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
		WebElement TextApply = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_text_Apply", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
		
		
		if(TextHold.isDisplayed())
		{
			IsTextAvaialble = true;
		}else{
			IsTextAvaialble = false;
		}
		
		if(TextRelease.isDisplayed())
		{
			IsTextAvaialble = true;
		}else{
			IsTextAvaialble = false;
		}
		
		if(TextApply.isDisplayed())
		{
			IsTextAvaialble = true;
		}else{
			IsTextAvaialble = false;
		}
				
		
		if(IsTextAvaialble==false)
		{
			GenericMethods.takeScreenshot(Constants.TestCaseName);
		}
		Assert.assertTrue(IsTextAvaialble);
		
	} catch (Exception e) {
		throw e;
	}
	}
	/**
	 * Verify Patient History section availability on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyPatientHistorysectionavailabilityonSalesOrderPage() throws Exception
	{
		try {
			WebElement PatientHistorySection = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_section_PatientHistory", Constants.OBJECT_CURRENT_PROPERTIESFILE)));	
			if(PatientHistorySection.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Available Options Under Patient History section on Sales Order Page
	 * @throws Exception
	 */
	public void verifyAvailableOptionsUnderPatientHistorysectiononSalesOrderPage() throws Exception
	{
		try{
			boolean IsTextAvaialble = true;
			WebElement TextPatientHistory = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_text_PatientHistory", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement TextRxHistory = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_text_RxHistory", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement TextClinicalInformation = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_text_ClinicalInformation", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			
			
			if(TextPatientHistory.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}
			
			if(TextRxHistory.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}
			
			if(TextClinicalInformation.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}					
			
			if(IsTextAvaialble==false)
			{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
			Assert.assertTrue(IsTextAvaialble);
			
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Task section availability on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyTasksectionavailabilityonSalesOrderPage() throws Exception
	{
		try {
			WebElement TaskSection = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_section_Task", Constants.OBJECT_CURRENT_PROPERTIESFILE)));	
			if(TaskSection.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Available options under Task section on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyAvailableoptionsunderTasksectiononSalesOrderPage() throws Exception
	{
		try{
			boolean IsTextAvaialble = true;
			WebElement TextTask = GenericMethods.driver.findElement(By.xpath(GenericMethods.getPageObject("xpath_text_Task", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement TextViewTask = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_text_ViewTask", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement TextCreateTask = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_text_CreateTask", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			
			
			if(TextTask.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}
			
			if(TextViewTask.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}
			
			if(TextCreateTask.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}					
			
			if(IsTextAvaialble==false)
			{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
			Assert.assertTrue(IsTextAvaialble);
			
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Available options under Payment section on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyPaymentsectionavailabilityonSalesOrderPage() throws Exception
	{
		try {
			WebElement PaymentSection = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_section_Payment", Constants.OBJECT_CURRENT_PROPERTIESFILE)));	
			if(PaymentSection.isDisplayed())
			{
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Available options under Payment section on Sales Order Page
	 * @throws Exception 
	 */
	public void verifyAvailableoptionsunderPaymentsectiononSalesOrderPage() throws Exception
	{
		try{
			boolean IsTextAvaialble = true;
			WebElement TextAccountDetails = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_text_AccountDetails", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement TextMakePayment = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_text_MakePayment", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			WebElement TextAddPaymentMethod = GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_text_AddPaymentMethods", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			
			
			if(TextAccountDetails.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}
			
			if(TextMakePayment.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}
			
			if(TextAddPaymentMethod.isDisplayed())
			{
				IsTextAvaialble = true;
			}else{
				IsTextAvaialble = false;
			}					
			
			if(IsTextAvaialble==false)
			{
				GenericMethods.takeScreenshot(Constants.TestCaseName);
			}
			Assert.assertTrue(IsTextAvaialble);
			
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * Verify Sales Order Landing Page coming from Work Area Selection Page
	 * @throws Exception 
	 */
	public void verifySalesOrderLandingPageComingFromWorkAreaSelectionPage() throws Exception
	{
		try {
			
			
			String actOrderSummaryHeaderText = ComponentMethods.getText("id_header_OrderSummary");
			String expOrderSummaryHeaderText = Constants.TestData.get("OrderSummaryHeader");
			
			Assert.assertEquals(actOrderSummaryHeaderText, expOrderSummaryHeaderText);
			
		} catch (Exception e) {
			throw e;
		}
	}
}
