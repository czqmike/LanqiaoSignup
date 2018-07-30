package cn.edu.hbue.dao;

import java.sql.*;

import cn.edu.hbue.model.Submit;
import cn.edu.hbue.util.JDBCUtil;

//对应数据库中的lq_submitted表，此DAO用来操作这张表
public class Lq_submitted {
	public static boolean insert(Submit submit) {
		boolean done = false;
		Connection conn = JDBCUtil.getConn();
		 

		PreparedStatement stmt = null;
		String sql = "insert into lq_submitted value(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			stmt = conn.prepareStatement(sql);
			
			//setString()从1开始
			stmt.setString(1, submit.getName());
			stmt.setString(2, submit.getStudent_no());
			stmt.setString(3, submit.getClass_());
			stmt.setString(4, submit.getReport_type());
			stmt.setString(5, submit.getEmail());
			stmt.setString(6, submit.getPhone_number());
			stmt.setString(7, submit.getPassword());
			stmt.setString(8, submit.getCaptcha());
			
			stmt.executeUpdate();
			
			if (stmt.getUpdateCount() != -1) {
				done = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConn(stmt, conn);
		}
		
		return done;
	}
}
