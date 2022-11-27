/**
*
*
* author : ME
*/

package wedDemo.com.tw.imsoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/demoo")
public class DemoTest extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		System.out.println("demoo#start");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		System.out.println("帳號 :"+account+"密碼:"+password);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"1\">");
		out.println("<tr>"+"<br>321"+"<td>"+account);
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
