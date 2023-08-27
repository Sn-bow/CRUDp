package com.CRUDp.web.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CRUDp.web.admin.service.SignInService;

@WebServlet("/admin/signIn")
public class SignInController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/admin/signIn/signIn.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pwd = req.getParameter("password");

		boolean state = false;
		HttpSession session = req.getSession();

		SignInService service = new SignInService();
		state = service.setUserLogIn(email, pwd);

		if (state) {
			// session 로그인
			session.setAttribute("userId", email);
			resp.sendRedirect("/admin/index");
		} else {
			resp.sendRedirect("/admin/signIn");
		}

	}
}
