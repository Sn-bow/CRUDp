<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/global/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/client/index/index.css" />
    <title>CRUD</title>
  </head>
  <body>
    <div class="contain">
      <div class="box">
        <div class="logout-link-box">
        <form action="/client/logout" method="post">
          <input type="submit" class="logout-link" name="logout" value="logout"/>
        </form>
        </div>
        <h1 class="title">CRUD</h1>
        <h3>${userId}님 환영합니다.</h3>
        <div class="board-list-box">
          <a href="/client/board/list" class="board-list-link">
          	게시판 리스트
          </a>
        </div>
      </div>
    </div>
  </body>
</html>
