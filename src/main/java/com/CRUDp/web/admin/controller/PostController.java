package com.CRUDp.web.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CRUDp.web.admin.service.PostService;

@WebServlet("/admin/post/action")
public class PostController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String actionState = req.getParameter("actionState");
		HttpSession session = req.getSession();
		PostService service = new PostService();
		String boardId_ = req.getParameter("board_id");
		int boardId = boardId_ != null && !boardId_.equals("") ? Integer.parseInt(boardId_) : 0;

		if (actionState.equals("삭제")) {
			String userId = (String) session.getAttribute("userId");

			// result 변수를 만들어 삭제에 실패하는경우도 산정하면 좋을것 같음
			service.delBoardPost(boardId, userId);
			resp.sendRedirect("/admin/board/list");

		} else if (actionState.equals("수정")) {

			resp.sendRedirect("/admin/board/reg?board_id=" + boardId);
		} else if (actionState.equals("선택삭제")) {
			// admin의 경우 게시물 전체를 삭제할 수 있는 권한이 있기 때문에 해당 기능을 구현
		}

	}
}
