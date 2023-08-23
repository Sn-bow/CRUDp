package com.CRUDp.web.client.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import com.CRUDp.web.client.dao.UserDao;
import com.CRUDp.web.client.dto.UserDto;
import com.CRUDp.web.security.Sha256;

public class SignUpService {

	public String setUserSignUp(String email_, String pwd_, String pwdCh_, String name_, String phone1_, String phone2_,
			String phone3_, String birth_) {
		System.out.printf("email : %s\n", email_);
		System.out.printf("pwd : %s\n", pwd_);
		System.out.printf("pwdCh : %s\n", pwdCh_);
		System.out.printf("name : %s\n", name_);
		System.out.printf("phone1 : %s\n", phone1_);
		System.out.printf("phone2 : %s\n", phone2_);
		System.out.printf("phone3 : %s\n", phone3_);
		System.out.printf("birth : %s\n", birth_);

		String email = null;
		String pwd = null;
		String name = null;
		String phoneNumber = null;
		Date birth = null;

		// 1. email 검증
		// DB 에서 email 데이터를 조회하여 같은 Email이 존재하는경우 err 메세지를 띄워줘야함
		boolean emailState = false;
		UserDao userDao = new UserDao();

		if (email_ != null && !email_.equals("")) {
			emailState = userDao.selectEmailCheckDao(email_);
		}
		if (emailState) {
			email = email_;
		} else {
			return "이미 존재하는 Email 입니다";
		}

		// 2. pwd 검증
		// 패스워드의 경우 대문자 소문자 특수문자 숫자 의 조합이 8자이상 15자이하 인지 정규식을 통해서 검증
		// 또한 해싱 작업을 통해서 해당 비밀번호를 암호화 해야함

		Sha256 sha256 = new Sha256();

		if (pwd_ != null && pwd_.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,15}$")) {
			try {
				pwd = sha256.encrypt(pwd_);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return "패스워드 형식이 올바르지 않습니다";
		}

		// 3. pwdCh 검증
		// 앞서 하였던 password 검증을 통과한 pwd 와 일치하는지에 대하여 검증
		try {
			if (!pwd.equals(sha256.encrypt(pwdCh_))) {
				return "패스워드가 일치하지 않습니다";
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4. phone number
		// phone1, phone2, phone3 에 대해서 xxx-yyyy-zzzz 와 같은 형식으로 포멧팅
		// phoneNumber 정규식 사용하여 검증 과정 필요
		if (phone1_ != null && phone2_ != null && phone3_ != null && !phone1_.equals("") && !phone2_.equals("")
				&& !phone3_.equals("")) {
			phoneNumber = phone1_ + "-" + phone2_ + "-" + phone3_;
		} else {
			return "전화번호를 등록하지 않았습니다.";
		}

		// 5. birth
		// String 타입에서 Date 타입으로 형 변환
		if (birth_ != null && !birth_.equals("")) {
			birth = Date.valueOf(birth_);
		} else {
			return "생일을 등록하지 않으셨습니다.";
		}

		// + name
		if (name_ != null && !name_.equals("")) {
			name = name_;
		} else {
			return "닉네임을 등록하지 않았습니다.";
		}

		// 6. user dto에 데이터 집어넣은후 dao에 데이터 전달
		UserDto user = new UserDto(email, pwd, name, birth, phoneNumber);

		UserDao insertUser = new UserDao();
		int state = insertUser.insertUserDao(user);

		if (state != 0) {
			return "성공적으로 회원가입이 완료되었습니다";
		}

		return "회원가입에 실패하였습니다";
	}

}
