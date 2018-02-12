package com.zilker.restapp.Authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		ViewDelegate view=new ViewDelegate();
		boolean check=false;
		RequestDispatcher requestDispatcher=null;
		if(request.getSession().getAttribute("token")==null)
		{
			requestDispatcher = request.getRequestDispatcher("home.jsp");
			requestDispatcher.include(request, response);
		}
		else {
			check=view.viewData(request,response);
			requestDispatcher = request.getRequestDispatcher("view.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
