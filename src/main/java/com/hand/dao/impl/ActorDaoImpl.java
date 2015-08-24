package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hand.dao.ActorDao;
import com.hand.entity.actorE;

public class ActorDaoImpl implements ActorDao {
	
	public void deleted(Connection conn, actorE actor) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareCall("DELETE FROM film_actor WHERE film_id=?");
		ps.setLong(1, actor.getFilm_id());
		ps.execute();

	}
}
