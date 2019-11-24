<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
<h1>게시판</h1>
<table border="1">
	<tbody>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="item" items="${items}">
	<tr>
		<td>${item.boardNum}</td>
		<td><a href='<c:url value='detailList.do?pkNumber=${item.boardNum}&viewCount=${item.viewCount}'/>' class="text-dark">${item.title}</a></td>   
		<td>${item.author}</td>
		<td>${item.regDate}</td>
		<td>${item.viewCount}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<br />
<input type="button" value="작성하기" onclick="location.href='./write.do'" />

<p>The time on the server is ${serverTime}.</p>
</body>
</html>
