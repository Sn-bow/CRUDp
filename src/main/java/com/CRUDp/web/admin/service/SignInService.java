package com.CRUDp.web.admin.service;

import java.security.NoSuchAlgorithmException;

import com.CRUDp.web.admin.dao.UserDao;
import com.CRUDp.web.admin.dto.UserDto;
import com.CRUDp.web.security.Sha256;

public class SignInService {
	public boolean setUserLogIn(String email, String password) {
		System.out.printf("email : %s\n", email);
		System.out.printf("password : %s\n", password);

		UserDto user = new UserDto();
		UserDao userDao = new UserDao();
		Sha256 sha256 = new Sha256();

		String hashingPwd = null;
		boolean state = false;

		try {
			hashingPwd = sha256.encrypt(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.setEmail(email);
		user.setPassword(hashingPwd);

		state = userDao.selectUserCheckDao(user);

		return state;
	}
}
