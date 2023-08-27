<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/global/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/signIn/signIn.css" />
    <title>CRUD</title>
  </head>
  <body>
    <div class="contain">
      <div class="box">
        <div class="link-box">
          <span class="admin-link-span">
            <a class="link" href="/client/signIn">CLIENT LOGIN</a>
          </span>
        </div>
        <div class="client-signIn-box">
          <form
            class="client-signIn-form"
            method="post"
          >
            <input
              class="signIn-id"
              type="text"
              name="email"
              value=""
              placeholder="이메일을 입력해주세요"
              autofocus
            />
            <input
              class="signIn-paw"
              type="password"
              name="password"
              value=""
              placeholder="비밀번호를 입력해주세요"
            />
            <input
              class="signIn-submit"
              type="submit"
              name="sign-in"
              value="로그인"
            />
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
