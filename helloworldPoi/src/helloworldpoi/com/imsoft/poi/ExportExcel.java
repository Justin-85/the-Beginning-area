/**
*
*
* author : ME
*/

package helloworldpoi.com.imsoft.poi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {
	
	public static void main(String args[]) throws EncryptedDocumentException, IOException {
		//String path = "C:\\Users\\WORK\\Desktop\\20221026\\example.xlsx";
		//String export = "C:\\Users\\WORK\\Desktop\\20221026\\examplm-new.xlsx";
		//InputStream is = new FileInputStream(new File(path)); // 讀入
		
		Path path = Paths.get("C:\\Users\\WORK\\Desktop\\20221026\\example.xlsx");
		Workbook wb = new XSSFWorkbook(Files.newInputStream(path));
		//Workbook wb = new XSSFWorkbook();
		Sheet sh = wb.getSheetAt(0);
		int rows = sh.getPhysicalNumberOfRows(); // 取得所有row
	
		
	}

}
