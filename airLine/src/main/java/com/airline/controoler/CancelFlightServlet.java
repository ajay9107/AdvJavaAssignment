package com.airline.controoler;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.airline.service.BookingService;





/**
 * Servlet implementation class CancelFlightServlet
 */
@WebServlet("/cancelFlight")
public class CancelFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelFlightServlet() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int bId=Integer.valueOf(request.getParameter("flightId"));
		if(new BookingService().cancelFlight(bId))
		{
        out.println("Booking Cancelled Successfully");
        RequestDispatcher dispatcher=request.getRequestDispatcher("searchFlight.jsp");
        dispatcher.include(request, response);
		}
		else
		{
			out.println("Booking Not Found!!!");
			 RequestDispatcher dispatcher=request.getRequestDispatcher("searchFlight.jsp");
		        dispatcher.include(request, response);
	}}

}
