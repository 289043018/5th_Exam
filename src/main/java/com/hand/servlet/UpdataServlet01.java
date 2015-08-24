package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdataServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdataServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filmid = Integer.parseInt(request.getParameter("film_id"));
		String title= request.getParameter("title");
		String	description= request.getParameter("description");
		String language =request.getParameter("name");
		RequestDispatcher rd = null;
		request.setAttribute("film_id", filmid);
		request.setAttribute("title", title);
		request.setAttribute("description", description);
		request.setAttribute("language", language);
		rd = request.getRequestDispatcher("/updatafilm.jsp");
		rd.forward(request, response);

		
	}

}
