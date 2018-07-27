package com.optumrx.irisuiuxqe.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static XSSFWorkbook testCaseData_wb, loginData_wb;
	public static XSSFSheet testCaseData_sh, loginData_sh;
	public static XSSFRow testCaseData_row, loginData_row;
	public static XSSFCell cell, testCaseData_cell1, testCaseData_cell2;

	/**
	 * Set Connection with Excel Test Data
	 * 
	 * @throws Exception
	 */
	public static void testDataConnection(String SheetName) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(new File(Constants.TESTDATA));
			testCaseData_wb = new XSSFWorkbook(fis);
			testCaseData_sh = testCaseData_wb.getSheet(SheetName);

			// int dataSize = row.getLastCellNum();
			// System.out.println("Row Lenght:"+i);

			// HashMap<String, String> map = new HashMap<String, String>();
			/*
			 * for(int i=1; i<=dataSize; i=i+2) {
			 * map.put(row.getCell(i).getStringCellValue(),row.getCell(i+1).
			 * getStringCellValue()); }
			 * 
			 * String d1 = map.get("LoginId"); System.out.println(d1);
			 */

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This Method will return row number of a Test Case
	 * 
	 * @param testCaseName
	 * @return
	 */
	public static int getTestCaseRowNo(String testCaseName) {
		try {
			int testCaseRow = 0;
			int columnHeight = testCaseData_sh.getLastRowNum();
			for (int i = 1; i <= columnHeight; i++) {
				testCaseData_row = testCaseData_sh.getRow(i);
				cell = testCaseData_row.getCell(0);
				cell.setCellType(cell.CELL_TYPE_STRING);
				String cellData = cell.getStringCellValue();
				if (cellData.equalsIgnoreCase(testCaseName)) {
					testCaseRow = i;
					break;
				}
			}
			return testCaseRow;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * This method will read all Data of a Test Case and will return as HashMap
	 * 
	 * @param testCaseName
	 *            It requires Test Case Name
	 * @return
	 */
	public static HashMap getTestCaseData(String testCaseName) {
		int r = 0;
		// System.out.println(" ");
		try {
			r = getTestCaseRowNo(testCaseName);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			testCaseData_row = testCaseData_sh.getRow(r);
			int size = testCaseData_row.getLastCellNum();
			HashMap<String, String> hm = new HashMap<String, String>();
			for (int i = 1; i < size; i = i + 2) {
				testCaseData_cell1 = testCaseData_row.getCell(i);
				testCaseData_cell2 = testCaseData_row.getCell(i + 1);
				testCaseData_cell1.setCellType(testCaseData_cell1.CELL_TYPE_STRING);
				testCaseData_cell2.setCellType(testCaseData_cell2.CELL_TYPE_STRING);
				hm.put(testCaseData_cell1.getStringCellValue(), testCaseData_cell2.getStringCellValue());
			}
			return hm;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * This Excel Sheet Connection is specially for Login Sheet
	 * 
	 * @param SheetName
	 *            Pass Sheet Name of Login Data
	 * @throws Exception
	 */
	public static void loginDataConnection(String SheetName) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(new File(Constants.TESTDATA));
			loginData_wb = new XSSFWorkbook(fis);
			loginData_sh = loginData_wb.getSheet(SheetName);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Will Return Test Data from Excel Sheet
	 * 
	 * @param r
	 *            Row Number i.e. test case row
	 * @param c
	 *            Column or cell number
	 * @return String cell Data
	 * @throws Exception
	 */
	public static String getCellData(int r, int c) throws Exception {
		try {
			loginData_row = loginData_sh.getRow(r);
			cell = loginData_row.getCell(c);
			cell.setCellType(cell.CELL_TYPE_STRING);
			String data = cell.getStringCellValue();
			return data;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	

}
