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
 * Servlet implementation class UpdataServlet
 */
public class UpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataServlet() {
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
		int language_id = Integer.parseInt(request.getParameter("language"));
		
		RequestDispatcher rd = null;
		
		Connection conn =null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			FilmDao filmDao = new FilmDaoImpl();
			FilmEntity film = new FilmEntity();

			film.setFilm_id(filmid);
			film.setDescription(description);
			film.setLanguage_id(language_id);
			film.setTitle(title);
			filmDao.update(conn, filmid, film);
			conn.commit();
			
			response.sendRedirect(request.getContextPath()+"/checkfilm.jsp");
//			rd = request.getRequestDispatcher("/18/checkfilm.jsp");
//			rd.forward(request, response);
	
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			
		}
		
	}

}
