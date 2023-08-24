package com.CRUDp.web.client.service;

import java.util.ArrayList;
import java.util.List;

import com.CRUDp.web.client.dao.BoardDao;
import com.CRUDp.web.client.dto.BoardDto;

public class BoardListService {
	public List<BoardDto> getBoardList(String field, String query, int page) {

		List<BoardDto> boardList = new ArrayList<>();

		BoardDao boardDao = new BoardDao();

		int start = 1 + (page - 1) * 10;
		int end = page * 10;

		boardList = boardDao.selectBoardListDao(field, query, start, end);

		return boardList;
	}

	public int getBoardListCount(String field, String query) {
		BoardDao boardDao = new BoardDao();
		int result = 0;
		result = boardDao.selectBoardCountDao(field, query);

		return result;
	}

}
