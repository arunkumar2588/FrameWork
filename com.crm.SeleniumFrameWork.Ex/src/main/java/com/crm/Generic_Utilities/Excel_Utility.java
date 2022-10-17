package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * This method is used to fetch the data from the Excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Arun
	 */
	
	public String getExcelKeyValue(String sheetname,int rownum,int cellnum ) throws EncryptedDocumentException, IOException {
		FileInputStream fis1= new FileInputStream("./Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
}
