package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.customer;
import com.hand.service.CheckUserService;


public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CheckUserService cku = new CheckUserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
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
		String userName =request.getParameter("uname");
		String password = request.getParameter("pword");
		
		RequestDispatcher rd = null;
		String forward = null;
		
		if(userName == null ){
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}else{
			customer user = new customer();
			user.setFirst_name(userName);
			user.setLast_name(password);
			boolean bool = cku.check(user);
			
			if(bool){
				forward = "/success.jsp";
			}else{
				request.setAttribute("msg", "用户名或者密码输入错误，请重新登录。");
				forward = "/error.jsp";
			}
			
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
		
	}

}
