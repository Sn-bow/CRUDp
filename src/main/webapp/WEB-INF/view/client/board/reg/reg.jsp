<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/global/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/client/board/reg/reg.css" />
<title>CRUD</title>
</head>
<body>
	<div class="contain">
		<div class="box">
			<div class="logout-link-box">
				<a class="logout-link" href="/client/logout">logout</a>
			</div>
			<div class="reg-box">
				<form method="post">
					<table class="reg-table">
						<tr>
							<th class="column">제목</th>
							<td class="row"><input autofocus type="text" name="title"
								value="${empty boardDetail ? '' : boardDetail.title}" /></td>
						</tr>
						<tr>
							<th class="column">파일첨부</th>
							<td class="row"><input type="file" name="file"
								value="${empty boardDetail ? '' : boardDetail.files}" /></td>
						</tr>
						<tr>
							<td class="content" colspan="2"><textarea name="content">${empty boardDetail ? '' : boardDetail.content}</textarea>
							</td>
						</tr>
					</table>
					<div class="conf-box">
						<c:if test="${empty boardDetail}">
							<input class="conf reg" type="submit" name="reg" value="등록" />
						</c:if>
						<c:if test="${!empty boardDetail}">
							<input class="conf reg" type="submit" name="reg" value="수정" />
						</c:if>
						<a class="conf cancle" href="/client/board/list">취소</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
