package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.entity.FilmEntity;

public interface FilmDao {
	public void save(Connection conn,FilmEntity film)throws SQLException;
	
	public void update(Connection conn,long id,FilmEntity film)throws SQLException;
	
	public void deleted(Connection conn,FilmEntity film)throws SQLException;
	
	public ResultSet get(Connection conn,FilmEntity film)throws SQLException;
}
