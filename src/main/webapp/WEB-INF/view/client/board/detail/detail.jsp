<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/global/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/client/board/detail/detail.css" />
<title>CRUD</title>
</head>
<body>
	<div class="contain">
		<div class="box">
			<div class="logout-link-box">
				<form class="logout-link" action="/client/logout" method="post">
					<input class="logout-link" type="submit" value="logout" />
				</form>
			</div>
			<div>
				<table>
					<tr>
						<th class="column">제목</th>
						<td class="row" colspan="3">${detailBoard.title}</td>
					</tr>
					<tr>
						<th class="column">작성일</th>
						<td class="row" colspan="3">${detailBoard.regDate}</td>
					</tr>
					<tr>
						<th class="column">작성자</th>
						<td class="row-harf">${fn:substringBefore(detailBoard.writerId, "@")}</td>
						<th class="column">조회수</th>
						<td class="row-harf">${detailBoard.hit}</td>
					</tr>
					<tr>
						<th class="column">첨부파일</th>
						<td class="row" colspan="3"><a download href="#"></a>
							${detailBoard.files}</td>
					</tr>
					<tr>
						<td class="content" colspan="3">${detailBoard.content}</td>
					</tr>
				</table>
			</div>
			<div class="turnback-list-page-box">
				<a href="/client/board/list" class="turnback-listPage-link">목록</a>
				<c:if test="${userId eq detailBoard.writerId}">
					<form class="action-form" action="/client/post/action?board_id=${detailBoard.id}" method="post">
						<input 
							type="submit" 
							name="actionState" 
							class="turnback-listPage-input"
							value="수정" 
						/> 
						<input 
							type="submit" 
							name="actionState"
							class="turnback-listPage-input" 
							value="삭제" 
						/>
					</form>
				</c:if>
			</div>
			<div>
				<table>
					<tr>
						<th class="column">다음글</th>
						<c:if test="${!empty nextPost.content}">
							<td class="row"><a href="?board_id=${nextPost.id}">${nextPost.title}</a></td>
						</c:if>
						<c:if test="${empty nextPost.content}">
							<td class="row">다음글이 존재하지 않습니다.</td>
						</c:if>
					</tr>
					<tr>
						<th class="column">이전글</th>
						<c:if test="${!empty prevPost.content}">
							<td class="row"><a href="?board_id=${prevPost.id}">${prevPost.title}</a></td>
						</c:if>
						<c:if test="${empty prevPost.content}">
							<td class="row">이전글이 존재하지 않습니다.</td>
						</c:if>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<div class="contain">
		<div class="comment-box">
			<div>
				<form class="cmt-reg-box" method="post">
					<input class="cmt-input" name="comment" value="" /> <input
						class="cmt-but" type="submit" name="cmt-action" value="등록" />
				</form>
			</div>
			<div class="comment-content-box">
				<table>
					<tr>
						<th class="comment-writer-column cmt-column">작성자</th>
						<th class="comment-content-column cmt-column">내용</th>
						<th class="comment-regDate-column cmt-column">작성일</th>
					</tr>

					<c:forEach var="cmt" items="${cmtList}">
						<tr>
							<td class="comment-writer-row cmt-row">${fn:substringBefore(cmt.writerId, "@")}</td>
							<td class="comment-content-row cmt-row"><span>${cmt.content}</span>
								<!-- if --> <c:if test="${userId eq cmt.writerId}">
									<form method="post">
										<input type="hidden" name="cmtId" value="${cmt.id}" /> <input
											class="cmt-del" type="submit" name="cmt-action" value="X" />
									</form>
								</c:if> <!-- if --></td>
							<td class="comment-regDate-row cmt-row">${cmt.regDate}</td>
						</tr>
					</c:forEach>

				</table>
			</div>

			<c:set var="page" value="${empty param.page ? 1 : param.page}" />
			<c:set var="stPage" value="${page - (page - 1) % 5}" />
			<c:set var="edPage"
				value="${fn:substringBefore(Math.ceil(cmtCount / 10), '.')}" />

			<c:if test="${cmtCount != 0}">
				<div class="page-controller">

					<c:if test="${stPage > 1}">
						<a href="?board_id=${param.board_id}&page=${stPage - 1}"
							class="prev sign"><</a>
					</c:if>
					<c:if test="${stPage <= 1}">
						<span onclick="alert('이전페이지가 존재하지 않습니다.')"><</span>
					</c:if>

					<div class="number-box">
						<c:forEach var="i" begin="0" end="4">
							<c:if test="${(stPage + i) <= edPage }">
								<a class="sign"
									href="?board_id=${param.board_id}&page=${i + stPage}">${i + stPage}</a>
							</c:if>
						</c:forEach>
					</div>

					<c:if test="${stPage + 4 < edPage}">
						<a href="?board_id=${param.board_id}&page=${stPage + 5}"
							class="prev sign">></a>
					</c:if>
					<c:if test="${stPage + 4 >= edPage}">
						<span onclick="alert('이전페이지가 존재하지 않습니다.')">></span>
					</c:if>

				</div>
			</c:if>
		</div>
	</div>
</body>
</html>
