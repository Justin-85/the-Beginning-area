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

import web_1019.demo.com.imsoft.dto.M000Dto;
@WebServlet("/m000")
public class M000Servlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet#start");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("name :"+ name);
		System.out.println("age :"+ age);
		
		
		
		List list  = new ArrayList();
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE","demo","123456");
			System.out.println("連線成功");
			
			String sql = "select * from WEB_BROADCAST order by id asc";//order by ... asc desc 
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()) {
				M000Dto dto = new M000Dto();
				dto.setId(Integer.valueOf(rs.getString("id")));
				dto.setTitle(rs.getString("TITLE"));
				list.add(dto);
			}
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			}
		}
		
		request.setAttribute("abc", list);
		request.getRequestDispatcher("/WEB-INF/jsp/m000.jsp").forward(request, response);
		
	}
	
}
