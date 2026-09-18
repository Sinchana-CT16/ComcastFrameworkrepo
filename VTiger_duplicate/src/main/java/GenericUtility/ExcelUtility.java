package GenericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	FileInputStream fis;

	public String readDataFromExcel(String sheet, int row, int cell) throws Exception {
		fis = new FileInputStream("./src/main/resources/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	}
	public void writeDataToExcel(String sheet,int row,int cell,String value)  throws Exception{
		fis = new FileInputStream("./src/main/resources/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
	}
	public void writeDataToExistingCell(String sheet,int row,int cell,String value)  throws Exception{
		fis = new FileInputStream("./src/main/resources/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
	}
	public int getRowCount(String sheet) throws Exception{
		fis = new FileInputStream("./src/main/resources/ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getLastRowNum();
	}
}
