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
	href="${pageContext.request.contextPath}/client/board/list/list.css" />
<title>CRUD</title>
</head>
<body>
	<div class="contain">
		<div class="box">
			<div class="logout-link-box">
				<a class="logout-link" href="/client/index">home</a>
				<form class="logout-link" action="/client/logout" method="post">
					<input type="submit" class="logout-link" name="logout"
						value="logout" />
				</form>
			</div>
			<div class="search-bar-box">
				<form>
					<select name="field">
						<option ${param.field == "title" ? "selected" : "" } value="title">제목</option>
						<option ${param.field == "writer_id" ? "selected" : "" } value="writer_id">작성자</option>
					</select> <input type="text" name="query" value="${param.query}" placeholder="검색" /> <input
						type="submit" value="찾기" />
				</form>
			</div>
			<div class="board-list-box">
				<table class="board-list-table">
					<tr class="table-title-box">
						<th class="num">번호</th>
						<th class="title">제목</th>
						<th class="writer">작성자</th>
						<th class="reg-date">등록일자</th>
						<th class="hit">조회수</th>
					</tr>

				<c:forEach var="n" items="${list}">
					<tr>
						<td class="num">${n.id}</td>
						<td class="title"><a href="/client/board/detail?board_id=${n.id}"
							class="detail-link">${n.title}</a></td>
						<td class="writer">${fn:substringBefore(n.writerId, "@")}</td>
						<td class="reg-date"><fmt:formatDate value="${n.regDate}" pattern="yy-MM-dd"/></td>
						<td class="hit">${n.hit}</td>
					</tr>
				</c:forEach>
				
				</table>
			</div>
			
			<c:set var="page" value="${empty param.page ? 1 : param.page }" />
			<c:set var="stPage" value="${page - (page - 1) % 5}" />
			<!-- substringBefore(Math.ceil(count / 10), '.') 은 전체 게시물의 개수를 10로 나눈후 소숫점을 바깥을 제거한 것이다 -->
			<!-- 10으로 나눈 이유는 한페이지당 나타내는 게시물은 10개씩이기 때문이다. -->
			<c:set var="edPage" value="${fn:substringBefore(Math.ceil(count / 10),  '.')}" />
			
			
			<div class="page-controller">
				<c:if test="${stPage > 1}">
					<a href="?page=${stPage}&field=${param.field}&query=${param.query}" class="prev sign"><</a>
				</c:if>
				<c:if test="${stPage <= 1}">
					<span onclick="alert('이전 페이지가 존재하지 않습니다.')" class="prev sign"><</span>
				</c:if>

					<div class="number-box">
						<c:forEach var="i" begin="0" end="4">
							<c:if test="${(stPage + i) <= edPage}">
								<a class="sign" href="?page=${i + stPage}&field=${param.field}&query=${param.query}">${i + stPage}</a>
							</c:if>
						</c:forEach>
					</div>
				
				<c:if test="${stPage + 4 < lastNum}">
					<a href="?page=${stPage + 5}&field=${param.field}&query=${param.query}" class="next sign">></a>
				</c:if>
				<c:if test="${stPage + 4 >= edPage}">
					<span onclick="alert('다음 페이지가 없습니다')" class="next sign">></span>
				</c:if>
			</div>
			
			
			
			<div class="reg-box">
				<form>
					<a class="border-reg" href="/client/board/reg">게시물
						작성하기</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
