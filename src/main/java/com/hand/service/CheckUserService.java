package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.hand.dao.customerDao;
import com.hand.dao.impl.customerDaoImpl;
import com.hand.entity.customer;
import com.hand.util.ConnectionFactory;

public class CheckUserService {

	private customerDao userDao = new customerDaoImpl();
	
	public boolean check(customer user){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs = userDao.get(conn, user);
			
			while (rs.next()) {
				return true;
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}finally{
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return false;
	}
	
}
