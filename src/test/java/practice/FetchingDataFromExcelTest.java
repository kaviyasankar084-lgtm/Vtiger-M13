package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingDataFromExcelTest {

	public static void main(String[] args) throws  IOException {
//		
//		FileInputStream fis = new FileInputStream("C:\\Users\\hi\\OneDrive\\Desktop\\Selenium data\\Sample.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Fruits");	// sheet name is case in-sensitive
//		Row r = sh.getRow(1);		// when is value is empty we will get NullPointerException
//		Cell c = r.getCell(2);		// for this also
		
		// we have to change every time according the value present
		
//		String value = c.getStringCellValue();		// when value is string in the cell
//		double value = c.getNumericCellValue(); 		//  when value is Numeric in the cell
		// when we don't follow the cell value type we will get IllegalStateException
//		System.out.println(value);
		
		// formatting to string type every time
		
//		DataFormatter df = new DataFormatter();
//		String value = df.formatCellValue(c);
//		System.out.println(value);
		
		// here if we have any null value in cell that time we get empty string 
		// because we not calling with reference we just formatting 
		
		
		
	// using utility class 
		ExcelUtility eutil = new ExcelUtility();
		String value = eutil.getDataFromExcel("Fruits", 1, 2);
		System.out.println(value);
		
		
		
		
		
		
		
	}
}
