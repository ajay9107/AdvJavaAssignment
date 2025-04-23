package com.airline.controoler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.airline.entity.User;
import com.airline.service.UserService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		
		User loogedInUser = new UserService().login(email, password);
		
		if(loogedInUser != null) {
			out.println("<h3> Welcome " +loogedInUser.getName()+"</h3>");
			HttpSession session= request.getSession();
			session.setAttribute("userId", loogedInUser.getId());
			response.sendRedirect("search.jsp");
		}else {
			out.println("<h3> Invalid Credentials !!! try again !! </h3>");
			request.getRequestDispatcher("login.jsp").include(request, response);
			
		}
	}

}
