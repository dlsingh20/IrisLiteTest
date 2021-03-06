package com.optumrx.irisuiuxqe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class GenericMethods {

	public static WebDriver driver;
	public static Properties pro;

	public static Statement st;
	public static Connection conn;
	
	public static final String SUBJECT="Test Execution Report";
	public static final String MESSAGE_BODY="Hi Team, \nTest run succesfully.\nPlease find the attached Test Execution Report.\nThis is an automated mail Generated By System.Please do not reply.\n\nRegards,\nOGS_IRIS_UIUX";
	public static final String FILE_PATH="./test-output/UiUxTestCasesReport.html";
	public static final String FILE_NAME="UiUxTestCasesReport.html";
	public static final String FROM = "no-reply@optum.com";
    public static final String HOST = "ctc-smtp-relay-ose.optum.com";
    public static final String TO1="yogesh_bhatt2@optum.com";
    public static final String TO2="din_dayal@optum.com";
    public static final String CC1="krishnamohan_j@optum.com";
    public static final String CC2="sandeep_jain_2@optum.com";
    

	/**
	 * It will open Browser as per browser parameter and will launch Application
	 * URL as provided in url parameter
	 * 
	 * @param browser
	 *            Browser Name ie. IE
	 * @param url
	 *            Application URL
	 * @throws Exception
	 */
	public static void openApp(String browser, String url) throws Exception {
		try {
			if (browser.equalsIgnoreCase("IE")) {
				DesiredCapabilities IEcaps = DesiredCapabilities.internetExplorer();
				IEcaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				IEcaps.setCapability("requireWindowFocus", true);

				System.setProperty(Constants.IEDRIVERNAME, Constants.IEDRIVEREXE);
				driver = new InternetExplorerDriver(IEcaps);

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(Constants.URL);
				driver.manage().window().maximize();

				/* driver = new ChromeDriver(); */
			} else if (browser.equalsIgnoreCase("FF")) {
				DesiredCapabilities FFCaps = new DesiredCapabilities();
				FFCaps.setCapability("marionette", "false");
				System.setProperty(Constants.FIREFOXDRIVERNAME, Constants.GECKODRIVEREXE);
				driver = new FirefoxDriver(FFCaps);
				// driver.manage().window().setSize(new Dimension(1600, 900));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(Constants.URL);
				//

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	/**
	 * Create Connection with Page Objects(Properties File).
	 * 
	 * @return Property file object
	 * @throws Exception
	 */
	public static Properties pageObjectConnection(String locatorsPath) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(new File(locatorsPath));
			pro = new Properties();
			pro.load(fis);

			return pro;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Need WebElement Name and will return Xpath for the same
	 * 
	 * @param ObjName
	 *            Name of WebElement mentioned in Property File
	 * @return Xpath
	 */
	public static String getPageObject(String elementName, Properties pro) {
		try {
			return pro.getProperty(elementName);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static void takeScreenshot(String screenshotName) throws Exception {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,
					new File(".\\FailedTestCase_Screenshots\\"
							+ screenshotName + ".png"));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Will Accept Alert
	 */
	public static void alertAccept() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Dismiss Alert
	 */
	public static void alertDismiss() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Will capture Text Message present in alert
	 * 
	 * @return Message present in alert
	 */
	public static String alertGetText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Will enter input in alert box
	 * 
	 * @param input
	 */
	public static void alertEnterInput(String input) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(input);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Will return a unique String--(Combination of
	 * UiUx+Year+Month+Date+Hour+Minutes+Seconds)
	 * 
	 * @return Unique String
	 */

	public static String getUniqueString() {
		try {
			LocalDateTime now = LocalDateTime.now();
			int year = now.getYear();
			String y = Integer.toString(year);
			int month = now.getMonthValue();
			String m = Integer.toString(month);
			int day = now.getDayOfMonth();
			String d = Integer.toString(day);
			int hour = now.getHour();
			String h = Integer.toString(hour);
			int minute = now.getMinute();
			String mi = Integer.toString(minute);
			int second = now.getSecond();
			String s = Integer.toString(second);

			String uniqueString = "UiUx" + y + m + d + h + mi + s;
			return uniqueString;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Will return a unique number--(Addition of
	 * Year+Month+Date+Hour+Minutes+Seconds)
	 * 
	 * @return four digit number
	 */
	public static int getUniqueNumber() {
		try {
			LocalDateTime now = LocalDateTime.now();
			int year = now.getYear();
			int month = now.getMonthValue();
			int day = now.getDayOfMonth();
			int hour = now.getHour();
			int minute = now.getMinute();
			int second = now.getSecond();
			int uniqueNumber = year + month + day + hour + minute + second;

			return uniqueNumber;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Will get Current Window ID
	 * 
	 * @return window id
	 */
	public static String getCurrentWindowId() {
		try {
			return driver.getWindowHandle();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * While working with two windows, we can switch to new window
	 * 
	 * @param parentWindowId
	 *            We need to pass Old window id
	 * @throws Exception
	 */
	public static void switchToNewWindow(String parentWindowId) throws Exception {
		try {
			// Set<String> parentWindowId = driver.getWindowHandles();
			for (String windowId : driver.getWindowHandles()) {
				if (!windowId.equals(parentWindowId)) {
					driver.switchTo().window(windowId);
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Will switch into the frame
	 * 
	 * @param frameIdName
	 *            Pass Frame ID or Name
	 * @throws Exception
	 */
	public static void switchToFrameByIdOrName(String frameIdName) throws Exception {
		try {
			driver.switchTo().frame(frameIdName);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Will switch into frame based on frame index
	 * 
	 * @param index
	 * @throws Exception
	 */
	public static void switchToFrameByIndex(int index) throws Exception {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Will Select a option from drop down depending on index
	 * 
	 * @param element
	 *            Xpath of Drop down
	 * @param index
	 *            index value to be selected
	 * @throws Exception
	 */
	public static void selectValueFromDropDownByIndex(String elementName, int index) throws Exception {
		try {
			WebElement element = null;
			String ele = GenericMethods.getPageObject(elementName, Constants.OBJECT_CURRENT_PROPERTIESFILE);
			if (elementName.contains("id")) {
				element = GenericMethods.driver.findElement(By.id(ele));
			} else if (elementName.contains("name")) {
				element = GenericMethods.driver.findElement(By.name(ele));
			} else if (elementName.contains("xpath")) {
				element = GenericMethods.driver.findElement(By.xpath(ele));
			} else {
				Assert.assertTrue(false);
			}

			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Will Select a option from drop down depending on value
	 * 
	 * @param element
	 *            Element Name of Drop-down as per property file of Drop down
	 * @param index
	 *            index of value to be selected
	 * @throws Exception
	 */
	public static void selectValueFromDropDownByValue(String elementName, String value) throws Exception {
		try {
			WebElement element = null;
			String ele = GenericMethods.getPageObject(elementName, Constants.OBJECT_CURRENT_PROPERTIESFILE);
			if (elementName.contains("id")) {
				element = GenericMethods.driver.findElement(By.id(ele));
			} else if (elementName.contains("name")) {
				element = GenericMethods.driver.findElement(By.name(ele));
			} else if (elementName.contains("xpath")) {
				element = GenericMethods.driver.findElement(By.xpath(ele));
			} else {
				Assert.assertTrue(false);
			}

			// Select select = new Select(element);
			Select select = new Select(element);

			select.selectByValue(value);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Will Select a option from drop down
	 * 
	 * @param element
	 *            Xpath of Drop down
	 * @param text
	 *            Text to be selected from drop down
	 * @throws Exception
	 */
	public static void selectValueFromDropDownByText(String elementName, String text) throws Exception {
		try {
			WebElement element = null;
			String ele = GenericMethods.getPageObject(elementName, Constants.OBJECT_CURRENT_PROPERTIESFILE);
			if (elementName.contains("id")) {
				element = GenericMethods.driver.findElement(By.id(ele));
			} else if (elementName.contains("name")) {
				element = GenericMethods.driver.findElement(By.name(ele));
			} else if (elementName.contains("xpath")) {
				element = GenericMethods.driver.findElement(By.xpath(ele));
			} else {
				Assert.assertTrue(false);
			}
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method shoots email after test execution with report as attachment
	 * 
	 * @throws IOException
	 */
	public static void shootEmail() throws IOException {

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", HOST);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(FROM));

	         // Set To and CC: header field of the header.
	        String hostName = GenericMethods.getHostName();
	        String Machine_Din = "LH7U05CG6375FW6";
	        String Machine_Yogesh = "LH7U05CG73811H0";
	        
	        if((hostName.equalsIgnoreCase(Machine_Din)) || (hostName.equalsIgnoreCase(Machine_Yogesh))){
	        	message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO1));
		        message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO2));
	        }
	        else{
	        	message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO1));
		        message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO2));
		        message.addRecipient(Message.RecipientType.CC,new InternetAddress(CC1));
		        message.addRecipient(Message.RecipientType.CC, new InternetAddress(CC2));
	        }
	        

	         // Set Subject: header field
	         message.setSubject(SUBJECT);
	         
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText(MESSAGE_BODY);

	         // Create a multipart message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         DataSource source = new FileDataSource(FILE_PATH);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(FILE_NAME);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);
	         // Send message
	         Transport.send(message);
  
	      } 
	      catch (MessagingException mex) {
	         mex.printStackTrace();
	      }	
	      
	
	

		/*try {
			String[] command = { "cmd.exe", "/C", "Start", Constants.PATH_SHOOT_EMAIL_SCRIPT_BATCHFILE };
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			throw e;
		}*/
	}


	/**
	 * Create Data base Connection
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void createDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName(Constants.DATABASE_DRIVER);
		conn = DriverManager.getConnection(Constants.DATABASE_URL, "iuxd_own", "ae4B93Eb");
	}

	/**
	 * Get Data in String format
	 * 
	 * @param query
	 *            Pass SQL query for a specific data
	 * @return String Data
	 * @throws SQLException
	 */
	public static ResultSet getTestData(String query) throws SQLException {
		String data = null;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);

		/*
		 * while(rs.next()) { data = rs.getString(1); } return data;
		 */
		return rs;
	}

	/**
	 * Break a String by a RegEx
	 * 
	 * @param str
	 *            String
	 * @param parameter
	 *            Pass RegEx
	 * @return Will Return String[]
	 */
	public String[] breakString(String str, String parameter) {
		try {
			String[] st = str.split(",");
			return st;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getSelectedTextOfDropdown(String elementName)
	{
		try {
			WebElement element = null;
			String ele = GenericMethods.getPageObject(elementName, Constants.OBJECT_CURRENT_PROPERTIESFILE);
			if (elementName.contains("id")) {
				element = GenericMethods.driver.findElement(By.id(ele));
			} else if (elementName.contains("name")) {
				element = GenericMethods.driver.findElement(By.name(ele));
			} else if (elementName.contains("xpath")) {
				element = GenericMethods.driver.findElement(By.xpath(ele));
			} else {
				Assert.assertTrue(false);
			}
			//WebElement ele=GenericMethods.driver.findElement(By.id(GenericMethods.getPageObject("id_dropdown_Queue", Constants.OBJECT_CURRENT_PROPERTIESFILE)));
			
			Select select = new Select(element);
			WebElement dropdownElement = select.getFirstSelectedOption();
			String selectedValue = dropdownElement.getText();
			return selectedValue;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * Get Machine Name where we run Test Cases
	 * @return
	 */
	public static String getHostName()
	{
		String hostname = "Unknown";
		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    return hostname;
		}
		catch (UnknownHostException ex)
		{
		    System.out.println("Hostname can not be resolved");
		    return null;
		}

	}
	
	
}