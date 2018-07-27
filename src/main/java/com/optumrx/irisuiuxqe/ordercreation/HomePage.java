package com.optumrx.irisuiuxqe.ordercreation;

import com.optumrx.irisuiuxqe.util.ComponentMethods;
import com.optumrx.irisuiuxqe.util.Constants;

public class HomePage {
	//ExtentReports extent;
	/**
	 * Search patient History based on Name and Order
	 * 
	 * @throws Exception
	 */
	public void searchPatient() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			ComponentMethods.enterValueInTextBox("xpath_txtbox_LastName", "LastName", "xpath_txtbox_FirstName", "FirstName", "xpath_txtbox_AccountNumber", "AccountNumber");
			ComponentMethods.clickOnWebElelent("xpath_btn_SearchPatient");
			
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Click Rx History Link
	 * @throws Exception 
	 */
	public void clickRxHistory() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			ComponentMethods.clickOnWebElelent("xpath_lnk_RxHistory");
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Select Rx and Click Refil
	 * @throws Exception 
	 */
	public void refil() throws Exception {
		try {
			Constants.OBJECT_CURRENT_PROPERTIESFILE = Constants.OBJECT_LOCATORS_ORDERCREATION;
			ComponentMethods.clickOnWebElelent("xpath_chkbox_Rx","xpath_btn_Refil");
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
public void logout() throws Exception
{
	try {
		Thread.sleep(4000);
		ComponentMethods.clickOnWebElelent("xpath_btn_logout");
	} catch (Exception e) {
		throw e;
	}
}
}
