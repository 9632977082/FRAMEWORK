package com.crm.Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility 
{
	public String getExcelValue(String sheet1 ,int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		/*
		 * 
		 */

		//FileInputStream fis1 = new FileInputStream("./DATA1.xlsx");
		FileInputStream fis1 = new FileInputStream(ipathConstant.XL_FILE_PATH);
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Sheet1");
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String data1 = cell.getStringCellValue();
		return data1;
	}
}
