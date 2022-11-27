/**
*
*
* author : ME
*/

package web_1019.demo.com.imsoft.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_1019.demo.com.imsoft.dto.M002Dto;

@WebServlet("/m002")
public class M002Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("m002#start");

		Connection conn = null;
		List list = new ArrayList();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE", "demo", "123456");
			Statement st = conn.createStatement();
			String sql = "select * from WEB_ORDERS ";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				M002Dto dto = new M002Dto();
				dto.setOrder_no(rs.getString("ORDER_NO"));
				dto.setProduct(rs.getString("PRODUCT"));
				dto.setUnit_amt(rs.getString("UNIT_AMT"));
				dto.setQty(rs.getString("QTY"));
				dto.setTotal_amt(rs.getString("TOTAL_AMT"));
				dto.setBuy_time(rs.getString("BUY_TIME"));
				list.add(dto);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		request.setAttribute("abc", list);
		request.getRequestDispatcher("/WEB-INF/jsp/m002.jsp").forward(request, response);

	}

}
