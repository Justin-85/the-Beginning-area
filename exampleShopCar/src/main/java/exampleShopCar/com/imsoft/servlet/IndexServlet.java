/**
*
*
* author : ME
*/

package exampleShopCar.com.imsoft.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exampleShopCar.com.imsoft.dto.IndexDto;
@WebServlet("/index01")
public class IndexServlet extends HttpServlet {
	
	Connection conn = null;
	List list = new ArrayList();
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		System.out.println("index01#start");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE","demo","123456");
			System.out.println("連線成功");
			//index頁面 要顯示SHOP_PRODUCTS內容
			String sql = "select * from SHOP_PRODUCTS";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				IndexDto indexDto = new IndexDto();
				indexDto.setProdCode(rs.getString("PROD_CODE"));
				indexDto.setProdName(rs.getString("PROD_NAME"));
				indexDto.setProdDesc(rs.getString("PROD_DESC"));
				indexDto.setPrice(rs.getString("PROD_AMT"));
				indexDto.setImg(rs.getString("IMG_LINK"));
				list.add(indexDto);	
				//System.out.println(indexDto.getPrice());
			}
			

			System.out.println("成功");
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		request.setAttribute("index", list);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		// 11/4- shop購物車 金額加總 problem重新整理會再加入一次
	}
}
