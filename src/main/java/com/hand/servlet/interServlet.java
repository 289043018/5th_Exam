package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.entity.FilmEntity;
import com.hand.util.ConnectionFactory;

/**
 * Servlet implementation class interServlet
 */
public class interServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public interServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = null;
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		long language_id = Integer.parseInt(request.getParameter("language")); 
		
		Connection conn =null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			FilmDao filmDao = new FilmDaoImpl();
			FilmEntity film = new FilmEntity();
			
			film.setTitle(title);
			film.setDescription(description);
			film.setLanguage_id(language_id);
			filmDao.save(conn, film);
			conn.commit();
			rd = request.getRequestDispatcher("/inster_success.jsp");
			rd.forward(request, response);
	
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			
		}
		
		
		
		
		
		
	}

}
