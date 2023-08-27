package com.CRUDp.web.admin.service;

import java.util.ArrayList;
import java.util.List;

import com.CRUDp.web.admin.dao.BoardDao;
import com.CRUDp.web.admin.dto.BoardDto;

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

	public int deletChoicePost(int[] chiBoardIds, String email) {
		int result = 0;

		BoardDao boardDao = new BoardDao();

		boolean state = boardDao.selectAdminMember(email);

		System.out.println("state : " + state);

		if (state) {
			boardDao.deleteChiPostCmtDao(chiBoardIds);
			result = boardDao.deleteChoicePostDao(chiBoardIds);
		}

		return result;
	}

}
