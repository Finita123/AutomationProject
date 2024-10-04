package utilitiespkg;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilities {

	//Get the row count in the excel file loaded
	public static int getRowCount(String xl, String sheet)
	{
		try
		{
			FileInputStream fi = new FileInputStream(xl);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			
			return wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	
	//Get the cell value from the excel file
	public static String getCellValue(String xl, String Sheet, int r,int c)
	{
		try
		{
			FileInputStream fi = new FileInputStream(xl);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			
			XSSFCell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else
			{
				return cell.getRawValue();
			}
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
}
