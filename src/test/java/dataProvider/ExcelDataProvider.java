package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public  ExcelDataProvider()
	{
		File src = new File("./ApplicationTestData/AppData.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public String getData(int SheetIndex, int row, int col)
	{
		String data = wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	public String getData(String SheetName, int row, int col)
	{
		String data = wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
