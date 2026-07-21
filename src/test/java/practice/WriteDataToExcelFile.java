package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class WriteDataToExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

//		FileInputStream fis = new FileInputStream("C:\\Users\\Mukilan P\\OneDrive\\Desktop\\Selenium data\\Sample.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Fruits");//old sheet --> new means createSheet()
//		
//		Row r = sh.getRow(1);	// old row --> new means createRow
//		Cell c = r.createCell(1);	// creating new row 
//		c.setCellValue("Sapota");
//		
//		FileOutputStream fos = new FileOutputStream("C:\\Users\\Mukilan P\\OneDrive\\Desktop\\Selenium data\\Sample.xlsx");
//		wb.write(fos);
		
		// when ever we write the data to excel file,  we have to close the excel file 
		// otherwise it will throw FileNotFoundException
		// FileName Also should be new not old exiting file names then we will get / IllegalArgumentException
		
		
	// using utility methods
		
		ExcelUtility eutil = new ExcelUtility();
		eutil.writeDataToExcel("fruits", 1, 4, "dragonfruits");
		eutil.writeDataToExcel("Company", 1, 1, "zoho");
		
		
	}
}
