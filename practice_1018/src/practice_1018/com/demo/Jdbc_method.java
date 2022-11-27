/**
*
*
* author : ME
*/

package practice_1018.com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jdbc_method {
	// 新,修,查,刪 的方法 寫在這裡 直接取用
	Connection conn = null;

	// 連結資料庫
	public void connection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE", "demo", "123456");
			System.out.println("這裡連線成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 新增 (id 從20 以後開始 變亂數)

	public void insert(String userName, String password) {
		// 從17開始 一新增 id 就會增加1 可以輸入名字和密碼
		Random randomId = new Random();
		String cnameChange = "";
	   
		int id = randomId.nextInt(100)+20 ;
		// iden 亂數產生 預設五碼 1~10000
		int iden = (int) (Math.random() * 10000) + 1;
		
		// cname 亂數產生 char a~z=97~122 , A~Z=65~90 先宣告為數字再轉成英文字母
		Random r = new Random();
		StringBuilder stringBuilder = new StringBuilder(); // 將字串加入
		for (int i = 0; i < 5; i++) {
			
			int cname = r.nextInt(26) + 65;// 亂數產生 nextInt(int n ) n代表範圍 但不包含
			// 轉成英文字母
			cnameChange = String.valueOf((char) cname);
			stringBuilder.append(cnameChange);
		} // FOR 可以跑出5個英文亂數  要如何把跑出來的5個字母存進去同一個裡面 讓它顯示有5個字母??  用StringBuilder
		
		String insertSql = "insert into employee (id,iden,username,password,cname) values(" + id + ",'" + iden + "','"
				+ userName + "','" + password + "','" + stringBuilder + "')";// 使用者輸入username和password 其他隨機產生
		try {
			PreparedStatement ps = conn.prepareStatement(insertSql);
			int test = ps.executeUpdate();
			if (test == 1) {
				System.out.println("新增成功");
			} else {
				System.out.println("沒成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	//刪除

}
