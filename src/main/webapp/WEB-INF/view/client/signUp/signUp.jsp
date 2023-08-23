<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/global/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/client/signUp/signUp.css" />
<title>CRUD</title>

</head>
<body>
	<div class="contain">
		<div class="box">
			<div class="link-box">
				<span class="home-link-span"> <a class="link"
					href="/client/signIn">LOGIN</a>
				</span> <span class="admin-link-span"> <a class="link"
					href="/admin/signIn">ADMIN LOGIN</a>
				</span>
			</div>
			<form class="form-box" action="" method="post">
				<div class="form-item-box">
					<div class="input-box">
						<input type="email" name="email" class="input email"
							placeholder="이메일을 작성해주세요" autofocus value="" />
					</div>
					<div class="err-box emailErr"></div>
				</div>
				<div class="form-item-box">
					<div class="input-box">
						<input type="password" name="pwd" class="input pwd"
							placeholder="비밀번호를 작성해주세요" />
					</div>
					<div class="err-box pwdErr"></div>
				</div>
				<div class="form-item-box">
					<div class="input-box">
						<input type="password" name="pwd-ch" class="input pwd-ch"
							placeholder="비밀번호를 다시 작성해주세요" />
					</div>
					<div class="err-box pwdChErr"></div>
				</div>
				<div class="form-item-box">
					<div class="input-box">
						<input type="text" name="name" class="input name"
							placeholder="닉네임을 작성해주세요" />
					</div>
					<div class="err-box nameErr"></div>
				</div>
				<div class="form-item-box">
					<div class="input-box">
						<select class="input phone1" name="phone1">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="016">016</option>
						</select> <span class="desh">-</span> <input type="number" name="phone2"
							maxlength="4" oninput="maxLengthCheck(this)" class="input phone2"
							placeholder="전화번호" /> <span class="desh">-</span> <input
							type="number" name="phone3" maxlength="4"
							oninput="maxLengthCheck(this)" class="input phone3"
							placeholder="전화번호" />
					</div>
					<div class="err-box phoneErr"></div>
				</div>
				<div class="form-item-box">
					<div class="input-box">
						<input type="date" name="birth" class="input date" />
					</div>
					<div class="err-box dateErr"></div>
				</div>
				<div class="form-submit-box">
					<div class="submit-box">
						<input type="submit" class="input signUpSubmit" value="회원가입"
							disabled />
					</div>
				</div>
			</form>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/client/signUp/signUp.js"
		type="text/javascript">
		
	</script>
</body>
</html>
