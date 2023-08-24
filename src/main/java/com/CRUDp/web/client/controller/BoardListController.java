package com.CRUDp.web.client.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CRUDp.web.client.dto.BoardDto;
import com.CRUDp.web.client.service.BoardListService;

@WebServlet("/client/board/list")
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

		req.getRequestDispatcher("/WEB-INF/view/client/board/list/list.jsp").forward(req, resp);
	}
}
