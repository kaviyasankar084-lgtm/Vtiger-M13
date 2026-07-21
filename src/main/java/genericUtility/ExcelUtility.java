package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This is a utility class which deals excel file
 * @author Mukilan P
 * @version 26-06-23
 */
public class ExcelUtility {

	/**
	 * this is a generic method to fetch data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);	
		Row r = sh.getRow(rowIndex);		
		Cell c = r.getCell(cellIndex);	
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(c);
				
		return value;	
	}
	
	/**
	 * this is a generic method to write data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataToExcel(String sheetName, int rowIndex, int cellIndex,String value) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);//old sheet --> new means createSheet()
		
		Row r = sh.getRow(rowIndex);	// old row --> new means createRow
		Cell c = r.createCell(cellIndex);	// creating new row 
		c.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IPathUtility.excelPath);
		wb.write(fos);
		
		
		
	}
}
