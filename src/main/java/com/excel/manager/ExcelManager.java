package com.excel.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelManager {
	
	public String readExcel(int rowNum, int colNum) {
		
		String path ="./src/test/resources/Login Test data.xlsx";
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fis object store all excel data
		//Apache POI start to read or write
		Workbook wb=null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Sheet sh = wb.getSheet("Login");
		
		int rowCount = sh.getPhysicalNumberOfRows();
		
		System.out.println("Total row count = "+rowCount);
		
		String celldata = null;
		
		//List<String>  excelTestDataList = new ArrayList<>();
		for(int i=1;i<rowCount;i++) {//1st loop
			Row rw = sh.getRow(rowNum);//row
			int columnCount =rw.getLastCellNum();
			//System.out.println("Total column count = "+columnCount);
			for(int j =0;j<columnCount;j++) {//2nd loop ==> Nested loop
				Cell cell = rw.getCell(colNum);//col
				String ExcelData= cell.getStringCellValue();
				//excelTestDataList.add(ExcelData);
				celldata=ExcelData;
			}//end 2nd loop
			
		}//end 1st loop
		
		System.out.println("Excel data = "+celldata);
		//all test data will destroy when loop end
	
		return celldata;
	}//java return method
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		ExcelManager obj = new ExcelManager();
		obj.readExcel(2,0);//R=2 & C=0 ==>Student2024
	}

}
