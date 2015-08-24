package com.hand.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.entity.actorE;

public interface ActorDao {
	public void deleted(Connection conn,actorE actor)throws SQLException;
	
}
