package com.sds.icto.mysitedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sds.icto.mysitevo.membervo;

public class memberdao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2 디비 콘 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");

		return conn;
	}

	public void insert(membervo vo) throws ClassNotFoundException, SQLException {

		// connection 생성
		Connection conn = getConnection();

		// statement sql 준비
		String sql = "insert into member values( member_no_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 바인딩
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getEmail());
		pstmt.setString(3, vo.getPassword());
		pstmt.setString(4, vo.getGender());

		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public membervo getMember(membervo vo) throws ClassNotFoundException,
			SQLException {
		// connection 생성
		Connection conn = getConnection();

		// statement sql 준비
		String sql = "select *  from member where email = ? and password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 바인딩
		pstmt.setString(1, vo.getEmail());
		pstmt.setString(2, vo.getPassword());

		ResultSet rs = pstmt.executeQuery();
		membervo membervo = null;

		if (rs.next()) {
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			String password = rs.getString(4);
			String gender = rs.getString(5);
			membervo = new membervo();
			membervo.setNo(no);
			membervo.setName(name);
			membervo.setEmail(email);
			membervo.setPassword(password);
			membervo.setGender(gender);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return membervo;
	}
}
