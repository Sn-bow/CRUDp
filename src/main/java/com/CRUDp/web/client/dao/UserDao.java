package com.CRUDp.web.client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.CRUDp.web.client.dto.UserDto;

public class UserDao {

	private String url = "jdbc:oracle:thin:@211.58.105.31:1521/xepdb1";

	// email 부분 dto 생성하여 User로 변경해야함
	public boolean selectEmailCheckDao(String email_) {
		boolean emailState = false;
		String email = "";

		String sql = "select * from member where email = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "crud", "9074");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, email_);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				email = rs.getString("email");
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (email.equals("")) {
			emailState = true;
		}

		return emailState;
	}

	public int insertUserDao(UserDto user) {

		int result = 0;

		String sql = "insert into member(email, password, nickname, birth, phone_number) values(?,?,?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "crud", "9074");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());
			st.setString(3, user.getNickname());
			st.setDate(4, user.getBirth());
			st.setString(5, user.getPhoneNumber());

			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean selectUserCheckDao(UserDto user) {

		String sql = "select email, password from member where email = ? and password = ?";

		boolean state = false;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "crud", "9074");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				if (!rs.getString("email").equals("")) {
					state = true;
				}
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return state;
	}
}
