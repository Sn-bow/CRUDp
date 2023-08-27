package com.CRUDp.web.admin.service;

import com.CRUDp.web.admin.dao.BoardDao;
import com.CRUDp.web.admin.dto.BoardDto;

public class PostService {
	public int setBoardPost(String title, String content, String files, String writerId) {
		int result = 0;

		BoardDao boardDao = new BoardDao();
		BoardDto post = new BoardDto();
		post.setTitle(title);
		post.setContent(content);
		post.setFiles(files);
		post.setWriterId(writerId);

		boardDao.insertBoardPost(post);

		return result;
	}

	public int delBoardPost(int boardId, String writerId) {
		BoardDao boardDao = new BoardDao();
		int result = 0;
		boolean adminState = boardDao.selectAdminMember(writerId);

		if (adminState) {
			boardDao.allDeleteCmt(boardId);
			result = boardDao.deleteBoardPost(boardId, writerId);
		}

		return result;
	}

	public int updateBoardPost(int boardId, String title, String content, String files, String writerId) {

		int result = 0;

		BoardDao boardDao = new BoardDao();
		BoardDto post = new BoardDto();

		post.setTitle(title);
		post.setContent(content);
		post.setFiles(files);
		post.setWriterId(writerId);

		result = boardDao.updateBoardPost(boardId, post);

		return result;
	}
}
