package com.CRUDp.web.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CRUDp.web.client.dto.BoardDto;
import com.CRUDp.web.client.service.BoardDetailService;
import com.CRUDp.web.client.service.PostService;

@WebServlet("/admin/board/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String boardId_ = req.getParameter("board_id");

		if (boardId_ != null && !boardId_.equals("")) {
			int boardId = Integer.parseInt(boardId_);

			BoardDetailService service = new BoardDetailService();
			BoardDto boardDetail = new BoardDto();

			boardDetail = service.getBoardDetailService(boardId);

			req.setAttribute("boardDetail", boardDetail);
		}

		req.getRequestDispatcher("/WEB-INF/view/admin/board/reg/reg.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String regState = req.getParameter("reg");

		HttpSession session = req.getSession();
		PostService service = new PostService();

		if (session.getAttribute("userId") != null) {

			if (regState.equals("등록")) {
				String title_ = req.getParameter("title");
				String title = title_ != null ? title_ : "";
				String content_ = req.getParameter("content");
				String content = content_ != null ? content_ : "";
				String writerId = (String) session.getAttribute("userId");

				service.setBoardPost(title, content, "", writerId);
			} else if (regState.equals("수정")) {
				String boardId_ = req.getParameter("board_id");
				int boardId = boardId_ != null && !boardId_.equals("") ? Integer.parseInt(boardId_) : 0;
				String title_ = req.getParameter("title");
				String title = title_ != null ? title_ : "";
				String content_ = req.getParameter("content");
				String content = content_ != null ? content_ : "";
				String writerId = (String) session.getAttribute("userId");

				System.out.printf("title : %s\ncontent : %s\nwriterId : %s", title, content, writerId);
				// update
				service.updateBoardPost(boardId, title, content, "", writerId);
			}

			resp.sendRedirect("/admin/board/list");
		} else {
			resp.sendRedirect("/admin/signIn");
		}

	}
}
