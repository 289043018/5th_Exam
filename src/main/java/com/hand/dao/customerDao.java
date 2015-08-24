package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.entity.customer;


public interface customerDao {
	
	public void update(Connection conn,long id,customer user)throws SQLException;
	
	public void delete(Connection conn,customer user)throws SQLException;
	
	public ResultSet get(Connection conn,customer user)throws SQLException;
}
