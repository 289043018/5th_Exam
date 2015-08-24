package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Locale.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.ActorDao;
import com.hand.dao.CategoryDao;
import com.hand.dao.FilmDao;
import com.hand.dao.impl.ActorDaoImpl;
import com.hand.dao.impl.CategoryDaoImpl;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.entity.FilmEntity;
import com.hand.entity.actorE;
import com.hand.entity.categoryE;
import com.hand.util.ConnectionFactory;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		long filmid = Integer.parseInt(request.getParameter("film_id"));
		RequestDispatcher rd = null;
		
		Connection conn =null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			FilmDao filmDao = new FilmDaoImpl();
			FilmEntity film = new FilmEntity();
			
			ActorDao actorDao = new ActorDaoImpl();
			actorE actor = new actorE();
			
			CategoryDao categoryDao = new CategoryDaoImpl();
			categoryE category = new categoryE();
			
			actor.setFilm_id(filmid);
			actorDao.deleted(conn, actor);
			
			category.setFilm_id(filmid);
			categoryDao.deleted(conn, category);
			
			
			film.setFilm_id(filmid);
			System.out.println("5");
			filmDao.deleted(conn, film);
			System.out.println("3");
			conn.commit();
			System.out.println("4");
			rd = request.getRequestDispatcher("/checkfilm.jsp");
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
