package com.practise.session1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHandling {
	String file = "D:\\java\\Neon\\LearnFramework5\\src\\com\\data\\Data.xlsx";

	public int getExcelRowCount(String sheetName) {
		int row_count = 0;
		try {
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			row_count = sh.getLastRowNum();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row_count;
	}

	public String readExcelData(String sheetName, int rowNo, int cellNo) {
		String excel_data = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNo);
			Cell cell = row.getCell(cellNo);
			excel_data = cell.getStringCellValue();
			// System.out.println(cell.getStringCellValue());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excel_data;
	}

	public void writeExcel(String sheetName, int rowNo, int cellNo, String val) {
		try {
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNo);
			CellStyle style = wb.createCellStyle();
			if(val.equalsIgnoreCase("fail")){
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
			}else{
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			}
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			Cell cell = row.createCell(cellNo);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(val);
			cell.setCellStyle(style);
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
