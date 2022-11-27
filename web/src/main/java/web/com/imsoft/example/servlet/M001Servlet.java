/**
*
*
* author : ME
*/

package web.com.imsoft.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/m001")
public class M001Servlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet#start");
		String name = request.getParameter("name");
		System.out.println("name :"+name);
		request.getRequestDispatcher("m001.jsp").forward(request, response);
	}
	

	
}
