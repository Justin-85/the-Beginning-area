/**
*
*
* author : ME
*/

package exampleShopCar.com.imsoft.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/shopcar")
public class ShopCarServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		System.out.println("shopcar#start");
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/shopcar.jsp").forward(request, response);
		
	}

}
