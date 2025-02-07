package com.lao.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	FileInputStream file;
	XSSFWorkbook workbook;
	static XSSFSheet sheet;
	XSSFCell cell;
    public static String LocatorColumnValue;
    public static String locatorname;
    public static String locatorvalue;
    public static String KeyWordColumnvalue;
    public static String dataColumnvalue;
    public static int totalRows;

	public void readExcelfile(String location) throws IOException {
		
		file = new FileInputStream(location);

		workbook = new XSSFWorkbook(file);

		sheet = workbook.getSheet("Sheet1");
		
		totalRows = sheet.getLastRowNum();
	}

	public static void  getlocatorsKeywordsAndData(int row,int locatorColumn,int KeyWordColumn, int dataColumn) {
		//cell = sheet.getRow(row).getCell(column);

		//String cellvalue = cell.getStringCellValue();
		
		LocatorColumnValue = sheet.getRow(row).getCell(locatorColumn).toString().trim();

		//System.out.println(LocatorColumnValue);
		
		if(!LocatorColumnValue.contains("NA")) {
		
		locatorname = LocatorColumnValue.split("=")[0].toString().trim();
		
		locatorvalue = LocatorColumnValue.split("=")[1].toString().trim();
		}
		else {
			locatorname="NA";
			locatorvalue="NA";
		}
		
		
		KeyWordColumnvalue = sheet.getRow(row).getCell(KeyWordColumn).toString().trim();
		dataColumnvalue = sheet.getRow(row).getCell(dataColumn).toString().trim();
		
		System.out.println(locatorname+"  :  "+locatorvalue+ " Keyword: "+ KeyWordColumnvalue + " Data : "+ dataColumnvalue );
	}


}
