package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hand.dao.CategoryDao;
import com.hand.entity.categoryE;

public class CategoryDaoImpl implements CategoryDao{
	public void deleted(Connection conn, categoryE category) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareCall("DELETE FROM film_category WHERE film_id=?");
		ps.setLong(1, category.getFilm_id());
		ps.execute();

	}

}
