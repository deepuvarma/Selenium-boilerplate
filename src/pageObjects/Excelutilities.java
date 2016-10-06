package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilities {

	private static XSSFSheet ExcelWsheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static String Value;

	public void getExcelFile(String Path, String Sheetname) throws Exception {
		try {
			// open the Excel file
			FileInputStream Excelfile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(Excelfile);
			ExcelWsheet = ExcelWBook.getSheet(Sheetname);
		} catch (Exception e) {
			throw (e);
		}
	}

	public String getCellData(String typeOfPlace) throws Exception {
		try {
			// TO get cell data
			for (int i = 1; i <= ExcelWsheet.getLastRowNum(); i++) {
				String cellValue = ExcelWsheet.getRow(i).getCell(0).getStringCellValue();

				if ((cellValue.equalsIgnoreCase(typeOfPlace))) {
					XSSFCell cell = ExcelWsheet.getRow(i).getCell(1);
					Value = cell.getStringCellValue();
					System.out.println(Value);
					return Value;
				} else {
					System.out.println("Correct value is not found");
				}
			}

		} catch (Exception e) {
			throw (e);
		}
		return "";
	}
}
