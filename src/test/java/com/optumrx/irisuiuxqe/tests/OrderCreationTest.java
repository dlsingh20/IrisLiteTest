package com.optumrx.irisuiuxqe.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.optumrx.irisuiuxqe.ordercreation.LoginPage;
import com.optumrx.irisuiuxqe.ordercreation.SalesOrderPage;
import com.optumrx.irisuiuxqe.ordercreation.SearchMemberPage;
import com.optumrx.irisuiuxqe.ordercreation.SelectWorkAreaPage;
import com.optumrx.irisuiuxqe.util.ComponentMethods;

import com.optumrx.irisuiuxqe.util.Constants;
import com.optumrx.irisuiuxqe.util.ExcelUtils;
import com.optumrx.irisuiuxqe.util.GenericMethods;

public class OrderCreationTest {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	// public static String TestCaseName;
	// public static HashMap<String, String> TestData;

	/*
	 * ExtentHtmlReporter htmlReporter; ExtentReports extent; ExtentTest test;
	 */

	@BeforeTest(alwaysRun = true)
	public void createConnections() throws Exception {
		try {
			htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/test-output/UiUxTestCasesReport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			extent.setSystemInfo("OS", "Windows 7");
			extent.setSystemInfo("Host Name", "Din Dayal");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Din Dayal");

			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("Extent Report Demo");
			htmlReporter.config().setReportName("Example Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Constants.OBJECT_LOCATORS_ORDERCREATION = GenericMethods
					.pageObjectConnection(Constants.PATH_LOCATORS_ORDERCREATION);
			Constants.OBJECT_LOCATORS_REPORTS = GenericMethods.pageObjectConnection(Constants.PATH_LOCATORS_REPORTS);

			ExcelUtils.testDataConnection(Constants.SHEET1); // For Test Data
																// required for
																// Test Cases
			ExcelUtils.loginDataConnection(Constants.SHEET2); // For Test Data
																// required for
																// Login
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest(alwaysRun = true)
	public void closeConnections() throws IOException {
		extent.flush();
		GenericMethods.shootEmail();
	}

	@BeforeMethod(alwaysRun = true)
	public void oc_login_00() throws Exception {
		try {

			/*
			 * Constants.TestCaseName = new Object() {
			 * }.getClass().getEnclosingMethod().getName(); // test =
			 * extent.createTest(Constants.TestCaseName, "This test willddayal
			 * // Login into Application"); // Get entire Test Data for current
			 * test case Constants.TestData =
			 * ExcelUtils.getTestCaseData(Constants.TestCaseName);
			 * 
			 * GenericMethods.openApp(Constants.BROWSER, Constants.URL);
			 * LoginPage LP = new LoginPage(); LP.login();
			 * 
			 * SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			 * SWAP.verifyWorkAreaPage(); SWAP.selectWorkArea();
			 */
			// System.out.println("/");
		} catch (Exception e) {
			// GenericMethods.takeScreenshot(Constants.TestCaseName);
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void logout(ITestResult result) throws Exception {
		// Code for Logout
		// test = extent.createTest("Logout", "This test will Logout from
		// Application");

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		GenericMethods.driver.quit();
	}

	// To verify the result after entering the 'IRISLite' url and hitting go

	// To verify the result after entering the 'IRISLite' url and hitting go
	@Test(priority = 1, groups = { "Regression", "LoginPage","Smoke" })
	@Parameters("browser")
	public void TC448493_verifyLoginScreen(String browser) throws Exception {

		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify Login Screen after Hitting URL");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.verifyLoginPage();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	// To verify the title of the Login screen
	@Test(priority = 2, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448499_verifyLoginScreenTitle(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify Login Screen Title");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.verifyLoginTitle();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	// To verify that the password is displayed in encrypted format
	@Test(priority = 3, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448500_verifyPasswordEncyptedFormat(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify Password Encypted Format");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();

			LP.verifyPasswordEncryption();
		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	// To verify the spelling and grammar of the text on the Login Screen
	@Test(priority = 4, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448501_verifySpellingGrammar(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "verify the spelling and grammar of the text");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);

			LoginPage LP = new LoginPage();
			LP.verifySpelling();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	// To verfiy the result after entering a valid username , leaving the
	// password blank and clicking Login button
	@Test(priority = 5, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448556_verifyValidUsernameBlankPassword(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"verfiy the result after entering a valid username , leaving the password blank");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.verifyValidUernameBlankPassword();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	// To verify the validation message when the user enters invalid username /
	// password
	@Test(priority = 6, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448557_verifyInvalidUsernamePassword(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"verify the validation message when the user enters invalid username / password");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();

			LP.verifyInvalidUsernamePassword();
		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify that the user is able to login after entering valid username
	 * and password
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 7, groups = { "Regression", "LoginPage","Smoke" })
	@Parameters("browser")
	public void TC448558_verifyLoginWithValidUsernamePassword(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"verify that the user is able to login after entering valid username and password");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.verifyLoginWithValidUsernamePassword(); // Calling logout method
														// at the end

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	// To verify the result after refreshing the page
	@Test(priority = 8, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448560_verifyResultAfterRefresh(String browser) throws Exception {

		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "verify the result after refreshing the page");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.verifyResultAfterRefresh();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	/**
	 * To verify the AD group authorization
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 9, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448562_verifyADGroupAuthorization(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "verify the AD group authorization");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.verifyADGroupAuthorization();

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verify Presence Of Place holders on Login Page
	 * 
	 * @param browser
	 * @throws Exception
	 */

	@Test(priority = 10, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448511_verifyPresenceOfPlaceholders(String browser) throws Exception {

		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify Presence of Placeholders on Fields");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();

			LP.verifyPresenceOfPlaceholders();
		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}

	}

	/**
	 * Verify Copy Paste Disabled On Login Page
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 11, groups = { "Regression", "LoginPage" })
	@Parameters("browser")
	public void TC448517_verifyCopyPasteDisabled(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify Copy Paste Disabled");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();

			LP.verifyCopyPasteDisabled();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Work Area Selection Page Test Cases Verify Work Area selection Page after
	 * login
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 12, groups = { "Regression", "WorkAreaSelectionPage","Smoke" })
	@Parameters("browser")
	public void TC462442_verifyWorkAreaSelectionPage(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify Work Area selection Page after login");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();

			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyWorkAreaPage();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
		}
	}

	/**
	 * Verify all dropdowns, buttons and check box availability
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 13, groups = { "Regression", "WorkAreaSelectionPage" })
	@Parameters("browser")
	public void TC462538_verifyAllElementsOnWorkAreaSelectionPage(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify all dropdowns, buttons and check box availability");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();

			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyAllElementsOnWorkAreaSelectionPage();
		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
		}
	}

	// Verify the values in every drop-downs as per Database tables
	// @Test(priority =14,
	// groups={"Regression","WorkAreaSelectionPage","debug"})
	@Parameters("browser")
	public void TC462541_verifyDropDownValueFromDatabase(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify the values in every drop-downs as per Database tables");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();

			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyDropDownValueFromDatabase();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Search button should be disabled until any option is selected in Queue
	 * drop-down
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 15, groups = { "Regression", "WorkAreaSelectionPage" })
	@Parameters("browser")
	public void TC462564_verifySearchButtonDisable(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify the Search button should be disabled");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();

			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifySearchButtonDisable();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
		}
	}

	/**
	 * Clear current selection using RESET button
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 16, groups = { "Regression", "WorkAreaSelectionPage" })
	@Parameters("browser")
	public void TC462557_verifyClearCurrentSelectionUsingRestButton(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify the Search button should be disabled");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyClearCurrentSelectionUsingRestButton();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
		}
	}

	// Save as preset and click search button
	@Test(priority = 17, groups = { "Regression", "WorkAreaSelectionPage","Smoke"})
	@Parameters("browser")
	public void TC462561_verifySaveAsPresetClickSearch(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify the Search button should be disabled");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifySaveAsPresetClickSearch();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			// ComponentMethods.clickOnWebElelent("id_checkbox_SaveAsPreset");
			ComponentMethods.clickOnWebElelent("id_btn_Reset");
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
			// SearchMemberPage SMP = new SearchMemberPage();
			// SMP.logout();
		}
	}

	// Reset button will Clear user preference/preset(all drop-downs selection)
	// and "Save as Preset" check box
	@Test(priority = 18, groups = { "Regression", "WorkAreaSelectionPage" })
	@Parameters("browser")
	public void TC462572_verifyResetButtonClearUserPreset(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify the Search button should be disabled");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyResetButtonClearUserPreset();

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
			// SearchMemberPage SMP = new SearchMemberPage();
			// SMP.logout();
		}
	}

	/**
	 * Test case to verify that the tab sequence is as desired i.e Queue >>
	 * Business >> Cell >> Source >> Search
	 * 
	 * @throws Exception
	 */
	@Test(priority = 19, groups = { "Regression", "WorkAreaSelectionPage" })
	@Parameters("browser")
	public void TC467679_verifyTabSequence(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify that the tab sequence is correct");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyTabSequence();
		}

		catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.selectWorkArea();
			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
		}
	}

	/**
	 * Test case to verify that the Reset button is accesible via hot Key
	 * 
	 * @throws Exception
	 */
	@Test(priority = 20, groups = { "Regression", "WorkAreaSelectionPage","Smoke"})
	@Parameters("browser")
	public void TC467681_verifyResetButtonHotKey(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify that the Reset button is accesible via Hot Key");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyResetButtonHotKey();
		}

		catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.selectWorkArea();
			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
		}

	}

	/**
	 * Test case to verify that the Search button is accesible via hot Key
	 * 
	 * @throws Exception
	 */
	@Test(priority = 21, groups = { "Regression", "WorkAreaSelectionPage" })
	@Parameters("browser")
	public void TC467691_verifySearchButtonHotKey(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify that the Search button is accesible via hot Key");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifySearchButtonHotKey();
		}

		catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {

			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
		}

	}

	/*
	 * Test case to verify that Shift + Tab takes the user to the previous
	 * member in the Tab Sequence
	 * 
	 * @throws Exception
	 */
	@Test(priority = 22, groups = { "Regression", "WorkAreaSelectionPage" })
	@Parameters("browser")
	public void TC467694_verifyShiftTab(String browser) throws Exception {

		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify that Shift + Tab takes the cursor to previous member in the TAB Sequence");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyShiftTab();
		}

		catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.selectWorkArea();
			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
		}

	}

	/**
	 * Verify Global Banner On WorkAreaSelection Page
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 23, groups = { "Regression", "WorkAreaSelectionPage","Smoke"})
	@Parameters("browser")
	public void TC480151_verifyGlobalBannerOnWorkAreaSelectionPage(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify Global Banner On WorkAreaSelection Page");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyGlobalBannerOnWorkAreaSelectionPage();

		} catch (Exception e) {
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
		}
	}

	/**
	 * Verify Functionality Of Banner On WorkAreaSelection Page
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 24, groups = { "Regression", "WorkAreaSelectionPage" })
	@Parameters("browser")
	public void TC484954_verifyFunctionalityOfBannerOnWorkAreaSelectionPage(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify Functionality Of Banner On Work Area Selection Page");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.verifyFunctionalityOfBannerOnWorkAreaSelectionPage();
		} catch (Exception e) {
			throw e;
		} finally {
			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.logout();
		}
	}

	/**
	 * Verify First Name And Last Name Required On MemberSearch Page
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@Test(priority = 25, groups = { "Regression", "MemberSearch","Smoke"})
	@Parameters("browser")
	public void TC471380_verifyFirstNameAndLastNameRequiredOnMemberSearchPage(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify First Name And Last Name Required On Member Search Page");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			// GenericMethods.driver.navigate().to(Constants.TestData.get("MemberSearchURL"));

			SearchMemberPage SMP = new SearchMemberPage();
			SMP.verifyFirstNameAndLastNameRequiredOnMemberSearchPage();

		} catch (Exception e) {
			throw e;
		} finally {
			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
		}
	}

	/**
	 * To verify that only numeric data is accepted as Account number
	 * 
	 * @throws Exception
	 */
	@Test(priority = 26, groups = { "Regression", "MemberSearch" })
	@Parameters("browser")
	public void TC471483_verifyThatOnlyNumericDataIsAcceptedAsAccountNumber(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"To verify that only numeric data is accepted as Account number");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);

			SearchMemberPage SMP = new SearchMemberPage();
			SMP.verifyThatOnlyNumericDataIsAcceptedAsAccountNumber();

		} catch (Exception e) {
			throw e;
		} finally {
			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();
		}

	}

	/**
	 * To verify that only numeric data is accepted as Rx number
	 * 
	 * @param browser
	 *            Browser Type
	 * @throws Exception
	 */
	// @Test(priority=27,groups={"Regression","MemberSearch","debug"})
	@Parameters("browser")
	public void TC471485_verifyThatOnlyNumericDataIsAcceptedAsRxNumber(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"To verify that only numeric data is accepted as Rx number");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);
			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();

			SearchMemberPage SMP = new SearchMemberPage();
			SMP.verifyThatOnlyNumericDataIsAcceptedAsRxNumber();

		} catch (Exception e) {
			throw e;
		} finally {
			SearchMemberPage SMP = new SearchMemberPage();
			SMP.logout();

		}
	}
	public void TC471486_verifyTheSearchButtonWhenAccountNumberOrderNumberRxNumberOrMemberIdIsEntered() {

	}

	public void TC471488_verifyTheSearchButtonIfFirstNameAndLastNameAreEntered() {

	}

	public void TC471489_verifyTheResultIfAcNumberOrderNumberRxNumberMemberIdIsNotEnteredAndEitherFirstNameLastNameMissing() {

	}

	public void TC471490_verifyResultAfterEnteringAnyDateFromFutureInDOBField() {

	}

	// =====================================Sales
	// Order=========================================
	/**
	 * Verify Benner Availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 28, groups = { "Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494162_verifyBennerAvailabilityonSalesOrderPage(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName, "Verify Benner Availability on Sales Order Page");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			/*
			 * String QueueValue =Constants.TestData.get("QueueData"); String
			 * SourceData =Constants.TestData.get("SourceData");
			 * System.out.println("");
			 * GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue",
			 * QueueValue); GenericMethods.selectValueFromDropDownByText(
			 * "id_dropdown_Source", SourceData);
			 * 
			 * ComponentMethods.clickOnWebElelent("id_btn_Search");
			 */
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyGlobalBannerOnSalesOrderPage();

		} catch (Exception e) {
			throw e;
		} finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * Verify Order Summary Section availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 29, groups = { "Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494163_verifyOrderSummarySectionavailabilityonSalesOrderPage(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify Order Summary Section availability on Sales Order Page");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			/*
			 * String QueueValue =Constants.TestData.get("QueueData"); String
			 * SourceData =Constants.TestData.get("SourceData");
			 * System.out.println("");
			 * GenericMethods.selectValueFromDropDownByText("id_dropdown_Queue",
			 * QueueValue); GenericMethods.selectValueFromDropDownByText(
			 * "id_dropdown_Source", SourceData);
			 * 
			 * ComponentMethods.clickOnWebElelent("id_btn_Search");
			 */
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyOrderSummarySectionavailabilityonSalesOrderPage();

		} catch (Exception e) {
			throw e;
		} finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}

	/**
	 * Verify sequence of text to be displayed in Order Summary Section On Sales
	 * Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 30, groups = { "Regression", "SalesOrder","Smoke"})
	@Parameters("browser")
	public void TC494165_verifySequenceOfTextToBeDisplayedInOrderSummarySectionOnSalesOrderPage(String browser)
			throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Order Summary Section On Sales");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifySequenceOfTextToBeDisplayedInOrderSummarySectionOnSalesOrderPage();

		} catch (Exception e) {
			throw e;
		} finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}

	/**
	 * Verify Patient Summary Section availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 31, groups = { "Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494166_verifyPatientSummarySectionavailabilityonSalesOrderPage(String browser) throws Exception {
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify Patient Summary Section availability on Sales Order Page");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyPatientSummarySectionavailabilityonSalesOrderPage();

		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}

	/**
	 * TC494168 Verify sequence of text to be displayed in Patient Summary
	 * Section On Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 32, groups = {"Regression", "SalesOrder","Smoke"})
	@Parameters("browser")
	public void TC494168_verifySequenceFfTextToBeDisplayedInPatientSummarySectionOnSalesOrderPage(String browser) throws Exception 
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifySequenceFfTextToBeDisplayedInPatientSummarySectionOnSalesOrderPage();			
		} catch (Exception e) {
			
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494169 Verify Order Details Section availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 33, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494169_verifyOrderDetailsSectionavailabilityonSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyOrderDetailsSectionavailabilityonSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494172 Verify sequence of Column to be displayed in Order Details Section On Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 34, groups = {"Regression", "SalesOrder","Smoke"})
	@Parameters("browser")
	public void TC494172_verifysequenceofColumntobedisplayedinOrderDetailsSectionOnSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifysequenceofColumntobedisplayedinOrderDetailsSectionOnSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494173 Verify cross icon availability in Order Details Section On Sales Order Page
	 * 
	 * @throws Exception
	 */
	//@Test(priority = 35, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494173_verifycrossiconavailabilityinOrderDetailsSectionOnSalesOrderPage(String browser)
	{
		
	}
	/**
	 * TC494174 Verify Notes Section availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 36, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494174_verifyNotesSectionavailabilityonSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyNotesSectionavailabilityonSalesOrderPage();
			
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494176 Verify My comments text box availability below notes section on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 37, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494176_verifyMycommentstextboxavailabilitybelownotessectiononSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyMycommentstextboxavailabilitybelownotessectiononSalesOrderPage();
			
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494177 Verify Account Summary section availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 38, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494177_verifyAccountSummarysectionavailabilityonSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyAccountSummarysectionavailabilityonSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494179 Verify All Buttons availability at the bottom-right on sales order page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 39, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494179_verifyAllButtonsavailabilityatthebottomRightonSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyAllButtonsavailabilityatthebottomRightonSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494181 Verify Hold section availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 40, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494181_verifyHoldsectionavailabilityonSalesOrderPage(String browser) throws Exception{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify Hold section availability on Sales Order Page");
			System.out.println("");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyHoldsectionavailabilityonSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494183 Verify Available options under Hold section on Sales Order Page
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 41, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494183_verifyAvailableoptionsunderHoldsectiononSalesOrderPage(String browser) throws Exception{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyAvailableoptionsunderHoldsectiononSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494184 Verify Patient History section availability on Sales Order Page
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 42, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494184_verifyPatientHistorysectionavailabilityonSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyPatientHistorysectionavailabilityonSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494186 Verify Available Options Under Patient History section on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 43, groups = {"Regression", "SalesOrder","Smoke"})
	@Parameters("browser")
	public void TC494186_verifyAvailableOptionsUnderPatientHistorysectiononSalesOrderPage(String browser) throws Exception{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyAvailableOptionsUnderPatientHistorysectiononSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494187 Verify Task section availability on Sales Order Page
	 * 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 44, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494187_verifyTasksectionavailabilityonSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyTasksectionavailabilityonSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494189 Verify Available options under Task section on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 45, groups = {"Regression", "SalesOrder","Smoke"})
	@Parameters("browser")
	public void TC494189_verifyAvailableoptionsunderTasksectiononSalesOrderPage(String browser) throws Exception{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyAvailableoptionsunderTasksectiononSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494190 Verify Payment section availability on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 46, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494190_verifyPaymentsectionavailabilityonSalesOrderPage(String browser) throws Exception{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyPaymentsectionavailabilityonSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	/**
	 * TC494192 Verify Available options under Payment section on Sales Order Page
	 * 
	 * @throws Exception
	 */
	@Test(priority = 47, groups = {"Regression", "SalesOrder"})
	@Parameters("browser")
	public void TC494192_verifyAvailableoptionsunderPaymentsectiononSalesOrderPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifyAvailableoptionsunderPaymentsectiononSalesOrderPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	
	/**
	 * Verify Sales Order Landing Page coming from Work Area Selection Page
	 * @throws Exception 
	 */
	//@Test(priority = 48, groups = {"Regression", "SalesOrder","debug"})
	@Parameters("browser")
	public void TC512828_verifySalesOrderLandingPageComingFromWorkAreaSelectionPage(String browser) throws Exception
	{
		try {
			Constants.TestCaseName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			test = extent.createTest(Constants.TestCaseName,
					"Verify sequence of text to be displayed in Patient Summary");
			Constants.TestData = ExcelUtils.getTestCaseData(Constants.TestCaseName);

			GenericMethods.openApp(browser, Constants.URL);
			LoginPage LP = new LoginPage();
			LP.login();
			Thread.sleep(2500);
			//GenericMethods.driver.navigate().to(Constants.URL_QA_SALESORDER);

			SelectWorkAreaPage SWAP = new SelectWorkAreaPage();
			SWAP.selectValuesFromDropdownAndClickSearch();
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.verifySalesOrderLandingPageComingFromWorkAreaSelectionPage();
		} catch (Exception e) {
			throw e;
		}finally {
			SalesOrderPage SOP = new SalesOrderPage();
			SOP.logout();
		}
	}
	
	/**
	 * Verify Sales Order Landing Page coming from Member Search Page 
	 */
	public void TC512830_verifySalesOrderLandingPageComingFromMemberSearchPage()
	{
		
	}
	/**
	 * Verify Patient Summary details when coming from Member search
	 */
	public void TC512831_verifyPatientSummaryDetailsWhenComingFromMemberSearch()
	{
		
	}
	/**
	 * Verify notification After hitting Submit Order
	 */
	public void TC512832_verifyNotificationAfterHittingSubmitOrder()
	{
		
	}
	/**
	 * Verify Order Summary details After hitting Submit Order if Order Number found in backend
	 */
	public void TC512838_verifyOrderSummaryDetailsAfterHittingSubmitOrderIfOrderNumberFoundInBackend()
	{
		
	}
	/**
	 * Verify Patient Summary details After hitting Submit Order if Order Number found in backend
	 */
	public void TC512840_verifyPatientSummaryDetailsAfterHittingSubmitOrderIfOrderNumberFoundInBackend()
	{
		
	}
	/**
	 * Verify landing Page after hitting Submit Order if DocSet ID found in backend
	 */
	public void TC512843_verifyLandingPageAfterHittingSubmitOrderIfDocSetIDFoundInBackend()
	{
		
	}
	/**
	 * Verify Back Button functionality when coming from Member search Page
	 */
	public void TC512845_verifyBackButtonFunctionalityWhenComingFromMemberSearchPage()
	{
		
	}
	/**
	 * Verify Back Button functionality when coming from Work Area Selection Page
	 */
	public void TC512847_verifyBackButtonFunctionalityWhenComingFromWorkAreaSelectionPage()
	{
		
	}	
}
