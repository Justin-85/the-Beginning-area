/**
*
*
* author : ME
*/

package wedDemo.com.tw.imsoft;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/d01")
public class Demo extends HttpServlet{
	//實現分頁功能 
	Connection conn = null ;
		
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		System.out.println("d01#start");
		String username = request.getParameter("username");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE", "demo", "123456");
			System.out.println("連線成功");
			String sql = "select";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rs.getString("total");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("user", username);
		request.getRequestDispatcher("WEB-INF/m002.jsp").forward(request, response);
			
	}
	
	
}
