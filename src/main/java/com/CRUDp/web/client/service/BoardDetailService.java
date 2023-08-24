package com.CRUDp.web.client.service;

import com.CRUDp.web.client.dao.BoardDao;
import com.CRUDp.web.client.dto.BoardDto;

public class BoardDetailService {
	public BoardDto getBoardDetailService(int boardId) {

		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();

		boardDto = boardDao.selectBoardDetailDao(boardId);

		return boardDto;
	}

	public int setBoardHit(int boardId) {

		BoardDao boardDao = new BoardDao();

		int result;

		result = boardDao.updateBoardHitDao(boardId);

		return result;
	}
}
