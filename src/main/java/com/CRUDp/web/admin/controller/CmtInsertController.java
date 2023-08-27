package com.CRUDp.web.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CRUDp.web.client.service.BoardDetailService;

@WebServlet("/admin/comment")
public class CmtInsertController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String temp = req.getParameter("board_id");
		System.out.println("temp" + temp);

		BoardDetailService service = new BoardDetailService();
		service.setCmt(getServletName(), getServletInfo(), 0);

		resp.sendRedirect("/admin/board/detail?board_id=" + "");
	}
}
