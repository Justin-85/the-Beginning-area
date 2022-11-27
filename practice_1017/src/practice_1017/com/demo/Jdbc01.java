/**
*
*
* author : ME
*/

package practice_1017.com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc01 {

	public static void main(String args[]) {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE", "demo", "123456");
			System.out.println("連線成功");
			// 修改
			String updateSql = "update employee set iden='55555',username='rainrain',password='dont rain' where id=7";
			// 新增
			String insertSql = "insert into employee (id,iden,username,cname) values(7,'7777','ookook','koukou')";
			// 刪除
			String deleteSql = "delete from employee where id=7 ";
			// 查詢
			String selectSql = "select id,iden,username from employee";
			
			//SQL Injection
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery("select * from employee where username='jack' or 1=1");
			
			PreparedStatement ps = conn.prepareStatement(updateSql);
			ResultSet rs = ps.executeQuery();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}

}
