package com.sds.icto.mysitedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysitevo.guestvo;

public class guestdao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2 디비 콘 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");

		return conn;
	}

	public void insert(guestvo vo) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		String sql = "insert into guestbook values (guestbook_seq.nextval, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getMessage());

		pstmt.executeUpdate();

		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	public List<guestvo> fetchList() throws ClassNotFoundException,
			SQLException {
		List<guestvo> list = new ArrayList<guestvo>();

		// 1 connection 생성
		Connection conn = getConnection();

		Statement stmt = conn.createStatement();

		String sql = "select * from guestbook";
		ResultSet rs = stmt.executeQuery(sql);

		// 4 결과처리
		while (rs.next()) {
			int no = rs.getInt(1);
			String Name = rs.getString(2);
			String Password = rs.getString(3);
			String Message = rs.getString(4);

			guestvo vo = new guestvo();
			vo.setNo(no);
			vo.setName(Name);
			vo.setPassword(Password);
			vo.setMessage(Message);
			list.add(vo);
		}
		// 5 자원정리
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}

		return list;

	}

}
