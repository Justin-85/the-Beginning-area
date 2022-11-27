/**
*
*
* author : ME
*/

package web_1021.com.imsoft.servlet;

import java.io.IOException;
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

import web_1021.com.imsoft.dao.M002Dao;
import web_1021.com.imsoft.dto.M002Dto;


@WebServlet("/m02")
public class M002Servlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("m002#start");
		String orderNo = request.getParameter("orderNo");
		String product = request.getParameter("product");
		System.out.println("orderNo :" + orderNo);
		System.out.println("product : " + product);

		M002Dao dao = new M002Dao();
		dao.connect(); // 連結資料庫
		ResultSet rs = null;
		Statement st = null;
		List list = new ArrayList();

		try {
			String sql = "select * from WEB_ORDERS where 1 = 1 "; // 放1 = 1 後面就算有其中一個為空，也不會報錯
			if (orderNo != null && !orderNo.isEmpty()) {
				sql += "and ORDER_NO like '%" + orderNo + "'";
			}
			if (product != null && !product.isEmpty()) {
				sql += " and PRODUCT like '%" + product + "'"; // %任意，%product代表前面任意都可以但後面要是product
			}

			st = dao.connect().createStatement();
			rs = st.executeQuery(sql);
			// 將東西放進dto
			while (rs.next()) {
				M002Dto dto = new M002Dto();
				dto.setOrderNo(rs.getString("ORDER_NO"));
				dto.setProduct(rs.getString("PRODUCT"));
				dto.setUnitAmt(rs.getString("UNIT_AMT"));
				dto.setQty(rs.getString("QTY"));
				dto.setTotalAmt(rs.getString("TOTAL_AMT"));
				dto.setBuyTime(rs.getString("BUY_TIME"));
				list.add(dto);// 再放進list裡面
			}
			System.out.println("成功");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.closed(rs);
			dao.closed(st);
			dao.closed(dao.connect());
		}

		request.setAttribute("order", list);
		request.getRequestDispatcher("/WEB-INF/jsp/m002.jsp").forward(request, response);

	}

	}


