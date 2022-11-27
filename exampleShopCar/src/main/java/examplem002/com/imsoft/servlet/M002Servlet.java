/**
*
*
* author : ME
*/

package examplem002.com.imsoft.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/m002")
public class M002Servlet extends HttpServlet {
	
	Connection conn = null;
	List list = new ArrayList<>();
	
	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("m002#start");
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn  =DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE","demo","123456");
			String sql = "select * from WEB_ORDERS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//String order = rs.getString("ORDER_NO");
//				String product = rs.getString("PRODUCT");
//				String amt = rs.getString("UNIT_AMT");
//				String qty = rs.getString("QTY");
//				String total = rs.getString("TOTAL_AMT");
//				String time = rs.getString("BUY_TIME");
				list.add(0,rs.getString("ORDER_NO"));
				list.add(1,rs.getString("PRODUCT"));
				list.add(2,rs.getString("UNIT_AMT"));
				list.add(3,rs.getString("QTY"));
				list.add(4,rs.getString("TOTAL_AMT"));
				list.add(5,rs.getString("BUY_TIME"));
				System.out.println(list);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list",list);
		request.getRequestDispatcher("/WEB-INF/jsp/m002.jsp").forward(request, response);
		
	}

}
