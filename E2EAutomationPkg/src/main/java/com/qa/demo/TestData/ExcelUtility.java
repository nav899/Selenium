package com.qa.demo.TestData;



	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	
	public class ExcelUtility {
		FileInputStream fis= null;	// to read data from a file in the form of sequence of bytes
		XSSFWorkbook workbook= null; // first object most users will construct whether they are reading or writing a workbook.
		XSSFSheet sheet=null;
		XSSFCell cellvalue;
		//creating constructor with handling exceptions
		public ExcelUtility(String path) {
			try {
				fis = new FileInputStream(path);//FNF EXCEPTION
				workbook = new XSSFWorkbook(fis); //IO EXCEPTION -whenever an input or output operation is failed or interpreted. For example, if you are trying to read in a file that does not exist, Java would throw an I/O exception. I
				sheet = workbook.getSheetAt(0); 
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public String readExceldata() {
			sheet = workbook.getSheetAt(0);//get first sheet
			XSSFRow row = sheet.getRow(0);//get 0th row
			int firstrowofsheet= sheet.getFirstRowNum();
			int lastrowofsheet=sheet.getLastRowNum();
			for(int i=firstrowofsheet;i<=lastrowofsheet;i++) {
				row = sheet.getRow(i);
				int lastcolumnofrow=row.getLastCellNum();
				for(int j=firstrowofsheet;j<lastcolumnofrow;j++) {
					cellvalue=row.getCell(j);
				}
			}
			return cellvalue.toString();
		
		}
	}


