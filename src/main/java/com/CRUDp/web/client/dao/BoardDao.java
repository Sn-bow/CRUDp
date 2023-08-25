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
import com.CRUDp.web.client.dto.CmtDto;

public class BoardDao {

	private String url = "jdbc:oracle:thin:@211.58.105.31:1521/xepdb1";
	private String dbName = "crud";
	private String dbPwd = "9074";

//	comment ======================================================================================================

	public int deleteCmt(int cmtId) {
		String sql = "delete from cmt where id = ?";

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, cmtId);

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

	public int insertCmtContent(String content, String writerId, int boardId) {
		String sql = "insert into cmt(content, writer_id, board_id) values( ?, ?, ?)";

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, content);
			st.setString(2, writerId);
			st.setInt(3, boardId);

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

	public int selectCountCmt(int boardId) {

		String sql = "select COUNT(id) count from cmt where board_id = ?";

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, boardId);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				result = rs.getInt("count");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<CmtDto> selectCmtList(int boardId, int page) {

		String sql = "select * from ( " + "select rownum num, c.* from ( "
				+ "select * from cmt where board_id = ? order by regdate desc ) c ) " + "where num between ? and ?";

		int start = 1 + (page - 1) * 10;
		int end = page * 10;

		List<CmtDto> commentList = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, boardId);
			st.setInt(2, start);
			st.setInt(3, end);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regdate");
				String writerId = rs.getString("writer_id");
				int boardId_ = rs.getInt("board_id");

				CmtDto cmt = new CmtDto(id, content, regDate, writerId, boardId_);

				commentList.add(cmt);

			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}

//	comment ======================================================================================================
//	post ======================================================================================================

	public BoardDto selectPrevPost(int boardId) {
		// Board 의 내용을 가지고오는
		String sql = "select * from board where id < ? order by regdate desc";

		BoardDto prevPost = new BoardDto();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
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

				prevPost = new BoardDto(id, title, content, regDate, hit, files, writerId);
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prevPost;
	}

	public BoardDto selectNextPost(int boardId) {
		// Board 의 내용을 가지고오는
		String sql = "select * from board where id > ? order by regdate";

		BoardDto nextPost = new BoardDto();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
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

				nextPost = new BoardDto(id, title, content, regDate, hit, files, writerId);
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nextPost;
	}

//	post ======================================================================================================
//	Board ======================================================================================================

	public int selectBoardCountDao(String field, String query) {
		// Board 의 내용을 가지고오는
		String sql = "select COUNT(ID) COUNT from ( select rownum num, b.* from ( select * from board where " + field
				+ " like ? order by regdate desc ) b )";

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
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

		// Board 의 내용을 가지고오는
		String sql = "update board set hit = hit + 1 where id = ?";

		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
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

		// Board 의 내용을 가지고오는
		String sql = "select * from board where id = ?";

		BoardDto boardDetail = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
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
		// Board 의 내용을 가지고오는
		String sql = "select * from ( " + "select rownum num, b.* from ( " + "select * from board where " + field
				+ " like ? order by regdate desc ) b " + ") where num between ? and ?";

		List<BoardDto> boardList = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
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

	public int insertBoardPost(BoardDto post) {
		int result = 0;

		String sql = "insert into board( title, content, files, writer_id ) " + "values( ? , ? , ? , ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, post.getTitle());
			st.setString(2, post.getContent());
			st.setString(3, post.getFiles());
			st.setString(4, post.getWriterId());

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

//	board ======================================================================================================
//	comment ======================================================================================================

	public int allDeleteCmt(int boardId) {
		int result = 0;

		String sql = "delete from cmt where board_id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
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

		System.out.println("삭제되는 상태 : " + result);
		return result;
	}

//	comment ======================================================================================================
//	post ======================================================================================================
	public int deleteBoardPost(int boardId, String writerId) {
		int result = 0;
		String sql = "delete from board where id = ? and writer_id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, boardId);
			// 프론트에서 사용자가 아니면 삭제버튼이 생성되지 않지만 다시한번 Dao 에서 사용자가 맞는지 확인
			st.setString(2, writerId);

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

	public int updateBoardPost(int boardId, BoardDto board) {
		int result = 0;
		String sql = "update board set title = ?, content = ?, files = ? where id = ? and writer_id = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, dbName, dbPwd);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, board.getTitle());
			st.setString(2, board.getContent());
			st.setString(3, board.getFiles());
			st.setInt(4, boardId);
			st.setString(5, board.getWriterId());

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

}
