package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.FilmDao;
import com.hand.entity.FilmEntity;

public class FilmDaoImpl implements FilmDao {
//保存用户信息
	public void save(Connection conn, FilmEntity film) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareCall("INSERT INTO film(title,description,language_id)values(?,?,?)");
		ps.setString(1, film.getTitle());
		ps.setString(2,film.getDescription());
		ps.setLong(3, film.getLanguage_id());
		ps.executeUpdate();
		
	}
//根据用户指定的ID更新用户信息
	public void update(Connection conn, long id, FilmEntity film) throws SQLException {
		String updatesql= "UPDATE film set title=?,description=?,language_id=? WHERE film_id =?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(updatesql);
		
		ps.setString(1, film.getTitle());
		ps.setString(2,film.getDescription());
		ps.setLong(3, film.getLanguage_id());
		ps.setLong(4, id);
		ps.executeUpdate();
	}
//删除指定的用户信息
	public void deleted(Connection conn, FilmEntity film) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareCall("DELETE FROM film WHERE film_id=?");
		ps.setLong(1, film.getFilm_id());
		ps.execute();

	}
	public ResultSet get(Connection conn, FilmEntity film) throws SQLException {
		PreparedStatement ps= conn.prepareStatement("select * from film left join language on film.language_id=language.language_id",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
		return ps.executeQuery();
	}

}
