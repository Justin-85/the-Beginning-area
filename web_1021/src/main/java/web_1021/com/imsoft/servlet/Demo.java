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
@WebServlet("/demo")
public class Demo extends HttpServlet {
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		System.out.println("demo#start");
		List test = new ArrayList();
		M002Dao dao = new M002Dao();
		String orderNo = request.getParameter("orderNo");
		String product = request.getParameter("product");//如果換成用方法查詢，一進去頁面就會是空的，因為一開始沒有參數
		System.out.println(orderNo);
		System.out.println(product);
		dao.connect();

		test.addAll(dao.query(orderNo, product));  //把List存進List裡面，包了兩層，會500 是因為取到外面那層而已，所以找不到東西 會500
		
		//ArrayList test = (ArrayList)dao.query(orderNo, product); //可以執行
		
		request.setAttribute("query", dao.query(orderNo, product));
		request.getRequestDispatcher("/WEB-INF/jsp/m002.jsp").forward(request, response);
		
		
		
	}

}
