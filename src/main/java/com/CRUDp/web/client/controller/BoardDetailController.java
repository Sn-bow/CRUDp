package com.CRUDp.web.client.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CRUDp.web.client.dto.BoardDto;
import com.CRUDp.web.client.service.BoardDetailService;

@WebServlet("/client/board/detail")
public class BoardDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String boardId_ = req.getParameter("board_id");
		int boardId = boardId_ != null && !boardId_.equals("") ? Integer.parseInt(boardId_) : 0;

		BoardDto boardDetail = new BoardDto();

		BoardDetailService service = new BoardDetailService();
		service.setBoardHit(boardId);
		boardDetail = service.getBoardDetailService(boardId);

		req.setAttribute("detailBoard", boardDetail);

		req.getRequestDispatcher("/WEB-INF/view/client/board/detail/detail.jsp").forward(req, resp);
	}
}
