package com.CRUDp.web.client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDao {

	public void getBoardListDao() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@211.58.105.31:1521/xepdb1";
		// Board 의 내용을 가지고오는
		String sql = "select * from ( select rownum num, b.* from ( select * from board order by regdate desc ) b )";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "CRUD", "9074");
		PreparedStatement st = con.prepareStatement(sql);

	}
}
