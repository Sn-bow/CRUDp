package com.CRUDp.web.client.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CRUDp.web.client.service.SignUpService;

@WebServlet("/client/signUp")
public class SignUpController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/client/signUp/signUp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String pwdCh = req.getParameter("pwd-ch");
		String name = req.getParameter("name");
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		String birth_ = req.getParameter("birth");

		SignUpService service = new SignUpService();
		String result = service.setUserSignUp(email, pwd, pwdCh, name, phone1, phone2, phone3, birth_);

		System.out.println(result);

		if (result.equals("성공적으로 회원가입이 완료되었습니다")) {
			resp.sendRedirect("signIn");
		} else {
			resp.sendRedirect("signUp");
		}

	}
}
