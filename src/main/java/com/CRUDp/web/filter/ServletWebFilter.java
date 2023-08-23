package com.CRUDp.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter
public class ServletWebFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

//		String pwd_ = req.getParameter("pwd");
//		String pwdCh_ = req.getParameter("pwd-ch");
//
//		Sha256 sha256 = new Sha256();
//
//		String pwd = null;
//		String pwdCh = null;
//
//		try {
//			pwd = sha256.encrypt(pwd_);
//			pwdCh = sha256.encrypt(pwdCh_);
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		req.setAttribute("pwd", pwd);
//		req.setAttribute("pwd-ch", pwdCh);

		req.setCharacterEncoding("UTF-8");
		chain.doFilter(req, resp);
	}
}
