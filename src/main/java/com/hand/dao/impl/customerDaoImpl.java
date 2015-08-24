package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.customerDao;
import com.hand.entity.customer;

public class customerDaoImpl implements customerDao {
	//根据用户指定的ID更新用户信息
		public void update(Connection conn, long id, customer user) throws SQLException {
			String updatesql= "UPDATE customer set first_name=?,last_name=?,email=? WHERE id =?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(updatesql);
			
			ps.setString(1, user.getFirst_name());
			ps.setString(2,user.getLast_name());
			ps.setString(3, user.getEmail());
			ps.setLong(4, id);
			ps.execute();
		}
	//删除指定的用户信息
		public void delete(Connection conn, customer user) throws SQLException {
			PreparedStatement ps = (PreparedStatement) conn.prepareCall("DELETE FROM customer WHERE first_name=?");
//			ps.setLong(1, user.getId());
			ps.setString(1, user.getFirst_name());
			ps.execute();

		}
		public ResultSet get(Connection conn, customer user) throws SQLException {
			PreparedStatement ps= conn.prepareStatement("select * from customer left join address on customer.address_id = address.address_id",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			return ps.executeQuery();
		}



}
