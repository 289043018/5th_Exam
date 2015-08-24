package com.hand.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.entity.FilmEntity;
import com.hand.entity.categoryE;

public interface CategoryDao {
	public void deleted(Connection conn,categoryE category)throws SQLException;
}
