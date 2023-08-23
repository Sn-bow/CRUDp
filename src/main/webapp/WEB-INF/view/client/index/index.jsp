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
          <a class="logout-link" href="/client/signIn">logout</a>
        </div>
        <h1 class="title">CRUD</h1>
        <div class="board-list-box">
          <a href="/client/board/list/list.html" class="board-list-link"
            >게시판 리스트</a
          >
        </div>
      </div>
    </div>
  </body>
</html>
