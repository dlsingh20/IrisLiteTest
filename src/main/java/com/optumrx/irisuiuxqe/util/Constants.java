package com.optumrx.irisuiuxqe.util;

import java.util.HashMap;
import java.util.Properties;

public class Constants {
	//IE: Internet Explorer Browser
	public static final String BROWSER = "IE";
	public static final int FAILEDTESTCASERETRYCOUNT = 2; 
	//IE Driver executable file 
	//public static String IEDRIVEREXE = "C:\\DD\\Automation\\AutomationFramework\\irisuiuxqe\\other-files\\IEDriverServer.exe";
	public static String IEDRIVEREXE = ".\\other-files\\IEDriverServer.exe";
	public static String GECKODRIVEREXE = ".\\other-files\\geckodriver.exe";
	//IE Driver name
	public static String IEDRIVERNAME = "webdriver.ie.driver";
	public static String FIREFOXDRIVERNAME = "webdriver.gecko.driver";
	// Application URL
	//public static final String URL = "http://qrcode-iris-ui-enhancement.ose-elr-core.optum.com/IrisApp/";
	//public static final String URL = "http://irisuiux-iris-ui-enhancement.ose-elr-core.optum.com/IrisApp/";
	//public static final String URL ="http://app-qa-irislite.ocp-ctc-core-nonprod.optum.com/";
	
	//QA Inatance
	public static final String URL ="https://irislite-qa.optum.com/";
	//Dev Instance
	//public static final String URL ="https://irislite-dev.optum.com/";
	//UAT URL
	//public static final String URL = "https://irislite-uat.optum.com/";
	
	public static final String URL_QA_MEMBERSEARCH ="https://irislite-qa.optum.com/#/member-search";
	public static final String URL_QA_SALESORDER ="https://irislite-qa.optum.com/#/sales-order";
										  
	//public static final String URL =   "http://irislite-ui-dev-irislite.ocp-ctc-core-nonprod.optum.com";
	// Properties File Path
	public static final String PATH_LOCATORS_ORDERCREATION = ".\\locators_ordercreation.properties";
	public static Properties OBJECT_LOCATORS_ORDERCREATION;
	
	public static final String PATH_LOCATORS_REPORTS = ".\\locators_reports.properties";
	public static Properties OBJECT_LOCATORS_REPORTS;
	
	public static Properties OBJECT_CURRENT_PROPERTIESFILE;
	// TestData Path
	public static final String TESTDATA = ".\\TestData.xlsx";
	public static final String SHEET1 = "DataSheet1";
	public static final String SHEET2 = "Login";
	public static HashMap<String, String> TestData;
	public static String TestCaseName;
	/**
	 * This File triggers powershell command file
	 */
	public static final String PATH_SHOOT_EMAIL_SCRIPT_BATCHFILE = ".\\other-files\\ShootEmailScript.bat";
	
	//Will be used for Data Base Connection
	public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	//public static final String DATABASE_URL = "jdbc:mysql://dbsrd3596/iuxd01?useSSL=false";
	public static final String DATABASE_URL = "jdbc:mysql://10.87.53.80:3306/iuxd01?useSSL=false";
}
