/**
*
*
* author : ME
*/

package helloworldpoi.com.imsoft.poi.test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Cell {
	
	public static void main(String args[]) {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("this is a sheet");
		sheet.setColumnWidth(0, 50*300);
		sheet.setColumnWidth(1, 100*300);
		sheet.setColumnWidth(2, 150*300);
		sheet.setColumnWidth(3, 200*300);
		CreationHelper ch = wb.getCreationHelper();
		
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("5555");
		row.createCell(1).setCellValue(ch.createRichTextString("test test"));
		row.createCell(2).setCellValue(true);
		;
		
		try {
			OutputStream os = new FileOutputStream("test.xlsx");
			wb.write(os);
			System.out.println("succeed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
