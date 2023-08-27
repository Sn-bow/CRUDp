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
import com.CRUDp.web.admin.service.BoardListService;

@WebServlet("/admin/board/list")
public class BoardListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String field_ = req.getParameter("filed");
		String query_ = req.getParameter("query");
		String page_ = req.getParameter("page");

		String field = field_ != null && !field_.equals("") ? field_ : "title";
		String query = query_ != null && !query_.equals("") ? query_ : "";
		int page = page_ != null && !page_.equals("") ? Integer.parseInt(page_) : 1;

		List<BoardDto> boardList = new ArrayList<>();
		int count = 0;

		BoardListService service = new BoardListService();
		boardList = service.getBoardList(field, query, page);
		count = service.getBoardListCount(field, query);

		req.setAttribute("list", boardList);
		req.setAttribute("count", count);

		req.getRequestDispatcher("/WEB-INF/view/admin/board/list/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		BoardListService service = new BoardListService();
		String[] chiBoardIds_ = req.getParameterValues("choice_board");
		int[] chiBoardIds = new int[chiBoardIds_.length];

		for (int i = 0; i < chiBoardIds_.length; i++) {
			chiBoardIds[i] = Integer.parseInt(chiBoardIds_[i]);
		}

		String email = (String) session.getAttribute("userId");

		int result = service.deletChoicePost(chiBoardIds, email);

		resp.sendRedirect("/admin/board/list");
	}
}
