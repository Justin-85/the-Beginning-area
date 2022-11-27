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
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exampleShopCar.com.imsoft.dto.IndexDto;
@WebServlet("/addshopcar")
public class AddShopCarServlet extends HttpServlet {
	
	Connection conn = null;
	List car = new ArrayList() ;
	PreparedStatement ps ;
	ResultSet rs ;
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("addshopcar#start");
		String prodCode = request.getParameter("prodCode");//接收產品的code
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE","demo","123456");
			System.out.println("連線成功");
			//利用get到的產品code 再從db取得產品資訊
			//把SHOPCAR需要的資訊從DB撈出來，再帶過去shopcar.jsp呈現
			//這個servlet只做加入購物車的動作
			String sql = "SELECT * FROM SHOP_PRODUCTS WHERE PROD_CODE='"+prodCode+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//將資料取出 放進list裡
			while(rs.next()) {
				IndexDto indexDto = new IndexDto();
				 indexDto.setProdName(rs.getString("PROD_NAME"));
				 indexDto.setPrice(rs.getString("PROD_AMT"));
				 car.add(indexDto);
			}
			System.out.println("成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		//不用跳轉到shopcar.jsp 按完之後要留在該頁面 可以用彈出視窗 或 導去空的頁面再導回index頁面
		request.setAttribute("addshopcar", car);//有了getSession可以在其他jsp也取得該變數
		request.getRequestDispatcher("/WEB-INF/jsp/shopcar.jsp").forward(request, response);//這行把以上的request帶去shopcar.jsp，但是多了getSession變得其他地方也找得到

		System.out.println(prodCode);
		
	}

}
