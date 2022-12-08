package testDataPB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	public static Workbook book;
	public static Sheet sheet;

	// Step 1 Create an array of Object to Read the External Data

	public static Object[][] readData(String SheetName) {
		FileInputStream file = null;

		try {
			file = new FileInputStream("D:\\QA COURSE\\JavaTest\\Para_Bank\\src\\test\\java\\testDataPB\\Details.xlsx");
		} catch (FileNotFoundException E) {
			E.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);

		} catch (IOException i) {
			i.printStackTrace();
		}
		sheet = book.getSheet(SheetName); //passing sheet no here
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int k =0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
}
