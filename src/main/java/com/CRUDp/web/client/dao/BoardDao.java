package com.CRUDp.web.client.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CRUDp.web.client.dto.BoardDto;

public class BoardDao {

	public int selectBoardCountDao(String field, String query) {
		String url = "jdbc:oracle:thin:@211.58.105.31:1521/xepdb1";
		// Board 의 내용을 가지고오는
		String sql = "select COUNT(ID) COUNT from ( select rownum num, b.* from ( select * from board where " + field
				+ " like ? order by regdate desc ) b )";

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "CRUD", "9074");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, "%" + query + "%");

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				result = rs.getInt("count");
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int updateBoardHitDao(int boardId) {

		String url = "jdbc:oracle:thin:@211.58.105.31:1521/xepdb1";
		// Board 의 내용을 가지고오는
		String sql = "update board set hit = hit + 1 where id = ?";

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "CRUD", "9074");
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, boardId);

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

	public BoardDto selectBoardDetailDao(int boardId) {

		String url = "jdbc:oracle:thin:@211.58.105.31:1521/xepdb1";
		// Board 의 내용을 가지고오는
		String sql = "select * from board where id = ?";

		BoardDto boardDetail = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "CRUD", "9074");
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, boardId);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				String writerId = rs.getString("writer_id");

				boardDetail = new BoardDto(id, title, content, regDate, hit, files, writerId);
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boardDetail;
	}

	public List<BoardDto> selectBoardListDao() {

		return selectBoardListDao("title", "", 1, 5);

	}

	public List<BoardDto> selectBoardListDao(int start, int end) {

		return selectBoardListDao("title", "", start, end);
	}

	public List<BoardDto> selectBoardListDao(String field, String query, int start, int end) {
		String url = "jdbc:oracle:thin:@211.58.105.31:1521/xepdb1";
		// Board 의 내용을 가지고오는
		String sql = "select * from ( " + "select rownum num, b.* from ( " + "select * from board where " + field
				+ " like ? order by regdate desc ) b " + ") where num between ? and ?";

		List<BoardDto> boardList = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "CRUD", "9074");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, "%" + query + "%");
			st.setInt(2, start);
			st.setInt(3, end);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String writerId = rs.getString("writer_id");
				Date regDate = rs.getDate("regdate");
				int hit = rs.getInt("hit");

				BoardDto board = new BoardDto();
				board.setId(id);
				board.setTitle(title);
				board.setWriterId(writerId);
				board.setRegDate(regDate);
				board.setHit(hit);

				boardList.add(board);
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return boardList;
	}
}
