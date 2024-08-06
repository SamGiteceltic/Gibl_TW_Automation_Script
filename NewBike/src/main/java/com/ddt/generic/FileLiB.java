package com.ddt.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLiB {
//	read from excel
	public static String readDataFromExcel(String sheet,int row,int cell) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Bikee.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		//return data;
		return data;
		
		
	}
}
