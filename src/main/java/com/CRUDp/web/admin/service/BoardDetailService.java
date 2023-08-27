package com.CRUDp.web.admin.service;

import java.util.ArrayList;
import java.util.List;

import com.CRUDp.web.admin.dao.BoardDao;
import com.CRUDp.web.admin.dto.BoardDto;
import com.CRUDp.web.admin.dto.CmtDto;

public class BoardDetailService {

	private BoardDao boardDao = new BoardDao();

	public BoardDto getBoardDetailService(int boardId) {

		BoardDto boardDto = new BoardDto();

		boardDto = boardDao.selectBoardDetailDao(boardId);

		return boardDto;
	}

	public int setBoardHit(int boardId) {

		int result;

		result = boardDao.updateBoardHitDao(boardId);

		return result;
	}

	public BoardDto getNextPost(int boardId) {

		BoardDto nextPost = new BoardDto();

		nextPost = boardDao.selectNextPost(boardId);
		return nextPost;
	}

	public BoardDto getPrevPost(int boardId) {

		BoardDto prevPost = new BoardDto();

		prevPost = boardDao.selectPrevPost(boardId);

		return prevPost;
	}

	public List<CmtDto> getCmtList(int boardId, int page) {

		List<CmtDto> cmtList = new ArrayList<>();
		cmtList = boardDao.selectCmtList(boardId, page);

		return cmtList;
	}

	public int getCmtCount(int boardId) {
		int result = boardDao.selectCountCmt(boardId);
		return result;
	}

	public int setCmt(String content, String writerId, int boardId) {
		int result = boardDao.insertCmtContent(content, writerId, boardId);

		return result;
	}

	public int deleteCmt(int cmtId, String user) {
		int result = 0;
		boolean adminState = boardDao.selectAdminMember(user);

		if (adminState) {
			result = boardDao.deleteCmt(cmtId);
		}

		return result;
	}
}
