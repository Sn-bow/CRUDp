package com.CRUDp.web.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CRUDp.web.admin.dto.BoardDto;
import com.CRUDp.web.admin.dto.CmtDto;
import com.CRUDp.web.admin.service.BoardDetailService;

@WebServlet("/admin/board/detail")
public class BoardDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cmt = req.getParameter("comment");

		String boardId_ = req.getParameter("board_id");
		int boardId = boardId_ != null && !boardId_.equals("") ? Integer.parseInt(boardId_) : 0;

		String page_ = req.getParameter("page");
		int page = page_ != null && !page_.equals("") ? Integer.parseInt(page_) : 1;

		BoardDto boardDetail = new BoardDto();
		BoardDto nextPost = new BoardDto();
		BoardDto prevPost = new BoardDto();
		int cmtCount = 0;

		BoardDetailService service = new BoardDetailService();
		List<CmtDto> cmtList = new ArrayList<>();

		service.setBoardHit(boardId);
		nextPost = service.getNextPost(boardId);
		prevPost = service.getPrevPost(boardId);
		boardDetail = service.getBoardDetailService(boardId);
		cmtList = service.getCmtList(boardId, page);
		cmtCount = service.getCmtCount(boardId);

		req.setAttribute("detailBoard", boardDetail);
		req.setAttribute("nextPost", nextPost);
		req.setAttribute("prevPost", prevPost);
		req.setAttribute("cmtList", cmtList);
		req.setAttribute("cmtCount", cmtCount);

		req.getRequestDispatcher("/WEB-INF/view/admin/board/detail/detail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		HttpSession session = req.getSession();

		String user = (String) session.getAttribute("userId");

		String cmtAction = req.getParameter("cmt-action");
		String boardId_ = req.getParameter("board_id");
		int boardId = boardId_ != null && !boardId_.equals("") ? Integer.parseInt(boardId_) : 0;
		BoardDetailService service = new BoardDetailService();
		// 사용자 인지 확인 &

		if (cmtAction.equals("등록")) {
			if (user != null) {
				String cmt = req.getParameter("comment");
				String writerId = (String) session.getAttribute("userId");

				service.setCmt(cmt, writerId, boardId);

				resp.sendRedirect("/admin/board/detail?board_id=" + boardId);

			} else {
				resp.sendRedirect("/admin/signIn");
			}
		} else if (cmtAction.equals("X")) {
			if (user != null) {

				String cmtId_ = req.getParameter("cmtId");
				int cmtId = cmtId_ != null && !cmtId_.equals("") ? Integer.parseInt(cmtId_) : 0;
				service.deleteCmt(cmtId, user);

				resp.sendRedirect("/admin/board/detail?board_id=" + boardId);
			}
		}

	}

}
