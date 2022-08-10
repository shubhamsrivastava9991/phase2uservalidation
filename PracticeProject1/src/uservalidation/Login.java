package uservalidation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Servlet implementation class Login
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("uname");
		String password = request.getParameter("pass");

		if (uname != null && uname.equals("admin") && password.equals("admin123")) {
			
			session.setAttribute("uname", uname);
			response.sendRedirect("Dashboard");
		}else {
			out.println("<h3>Username or Password is Incorrect</h3>");
			out.println("<a href=login.html><Button>Login</Button></a>");	
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}