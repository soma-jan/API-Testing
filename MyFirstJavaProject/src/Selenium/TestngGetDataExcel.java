package Testng;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestngGetDataExcel {
	static FileInputStream fi;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static String val;
	
@BeforeTest
//	System.out.println("LLL");
	
@Test
	
	public static ArrayList<Object[]> GetDataExcel()
	{
		System.out.print("123");
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
		fi =new FileInputStream(".\\Datafiles\\Book1.xlsx");
		workbook =new XSSFWorkbook(fi);
		sheet =workbook.getSheetAt(0);
		 val= sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.print(val);
		
		}catch (Exception e) {
			System.out.print(e);
		}
				return myData;
	}
	public static void main(String args[])
	{
		ArrayList<Object[]> myData1 = new ArrayList<Object[]>();
		myData1 =GetDataExcel();
		System.out.print(myData1);
		
	}

}
