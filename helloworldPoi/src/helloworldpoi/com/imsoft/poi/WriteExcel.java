/**
*
*
* author : ME
*/

package helloworldpoi.com.imsoft.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String args[]) throws IOException {
		// 建立工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 建立工作表
		Sheet sheet = workbook.createSheet("這是sheet的名字");
		sheet.setColumnWidth(0, 30 * 256);
		sheet.setColumnWidth(1, 30 * 256);
		sheet.setColumnWidth(2, 50 * 256);
		sheet.setColumnWidth(3, 100 * 256);
		sheet.setColumnWidth(4, 100 * 256);
		//sheet.setDefaultRowHeight((short) 200);
		// 建立橫列
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("這是第1格");
		row.createCell(1).setCellValue("這是第2格");
		row.createCell(2).setCellValue("這是第3格");
		row.createCell(3).setCellValue("這是第4格");
		row.createCell(4).setCellValue("這是第5格");

		for (int i = 1; i <= 6; i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue("aaaaa");
			row.createCell(1).setCellValue("bbbbb");
			row.createCell(2).setCellValue("ccccc");
			row.createCell(3).setCellValue("ddddd");
			row.createCell(4).setCellValue("fffff");

		}

		try {
			OutputStream outFile = new FileOutputStream("example.xlsx");
			workbook.write(outFile);	
			System.out.println("成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		workbook.close();
	}

	class jdbc {

		Connection conn = null;

		public void connect() {
			try {
				Class.forName("jdbc.oracle.OracleDiver");
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE", "demo", "123456");
				System.out.println("連線成功");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
