<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/global/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/client/board/detail/detail.css" />
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
              <td class="row" colspan="3">
                <a download href="#"></a>
                ${detailBoard.files}
              </td>
            </tr>
            <tr>
              <td class="content" colspan="3">
                ${detailBoard.content}
              </td>
            </tr>
          </table>
        </div>
        <div class="turnback-list-page-box">
          <a href="/client/board/list" class="turnback-listPage-link"
            >목록</a
          >
          <a href="/client/board/list" class="turnback-listPage-link"
            >수정</a
          >
          <a href="/client/board/list" class="turnback-listPage-link"
            >삭제</a
          >
        </div>
        <div>
          <table>
            <tr>
              <th class="column">다음글</th>
              <td class="row">내용</td>
            </tr>
            <tr>
              <th class="column">이전글</th>
              <td class="row">내용</td>
            </tr>
          </table>
        </div>
      </div>
    </div>

    <div class="contain">
      <div class="comment-box">
        <div>
          <form class="cmt-reg-box">
            <input class="cmt-input" name="comment" value="" />
            <input
              class="cmt-but"
              type="submit"
              name="comment-reg"
              value="등록"
            />
          </form>
        </div>
        <div class="comment-content-box">
          <table>
            <tr>
              <th class="comment-writer-column cmt-column">작성자</th>
              <th class="comment-content-column cmt-column">내용</th>
              <th class="comment-regDate-column cmt-column">작성일</th>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
            <tr>
              <td class="comment-writer-row cmt-row">dragon</td>
              <td class="comment-content-row cmt-row">
                <span> hihifdssdfdsajf hihifdssdfdsajf hihifdssdfdsajf </span>
                <!-- if -->
                <form>
                  <input
                    class="cmt-del"
                    type="submit"
                    name="cmt-del"
                    value="X"
                  />
                </form>
                <!-- if -->
              </td>
              <td class="comment-regDate-row cmt-row">2023-08-22</td>
            </tr>
          </table>
        </div>
        <div class="page-controller">
          <a href="#" class="prev sign"><</a>
          <div class="number-box">
            <a class="sign" href="#">1</a>
            <a class="sign" href="#">2</a>
            <a class="sign" href="#">3</a>
            <a class="sign" href="#">4</a>
            <a class="sign" href="#">5</a>
          </div>
          <a href="#" class="next sign">></a>
        </div>
      </div>
    </div>
  </body>
</html>
