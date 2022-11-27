/**
*
*
* author : ME
*/

package ucWork.com.imsoft.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fp01")
public class ForgotPassword extends HttpServlet{

	public void doGet (HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		System.out.println("fp01#start");
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/forgotPassword.jsp").forward(request, response);
	}
		
}
