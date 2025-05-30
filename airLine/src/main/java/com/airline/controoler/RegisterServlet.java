package com.airline.controoler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.airline.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String email =request.getParameter("email");
		String password =request.getParameter("password");
	    PrintWriter out = response.getWriter();
		
		try {
			boolean isRegister =new UserService().register(name, email, password);
			if(isRegister) {
		     out.println("User Registered !");
		     response.sendRedirect("login.jsp");
			}else {
				out.println("Failed.");
			}
			
		} catch (Exception e) {
		   out.println("<h3>" +e.getMessage()+"</h3>" );
		}
	
	}

}
