package com.mashensoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mashensoft.model.Data;

public class DataDaoImpl {
	private Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mashen18?useSSL=false", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	private void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Data> getDataList(int beginIndex, int length) {
		List<Data> dataList = new ArrayList<>();
		Connection conn = this.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from data limit ?,?");
			ps.setInt(1, beginIndex);
			ps.setInt(2, length);
			rs = ps.executeQuery();
			while (rs.next()) {
				String address = rs.getString("address");
				String age = rs.getString("age");
				String date = rs.getString("date");
				String name = rs.getString("name");
				String office = rs.getString("office");
				String salary = rs.getString("salary");
				Data news = new Data( address,  age,  date,  name,  office,  salary);
				dataList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, ps, rs);
		}
		return dataList;
	}

	public int getTotalCount() {
		int count = 0;
		Connection conn = this.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) as count from data");
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn,ps,rs);
		}

		return count;
	}

}
