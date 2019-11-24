<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<!doctype html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>글쓰기</h1>
<form action="submit.do" method="post">
    <label for="author">이름:</label><input type="text" id="author" name="author" /><br />
    <label for="title">제목:</label><input type="text" id="title" name="title" /><br />
    <label for="text">본문</label>
    <textarea rows="10" cols="50" id="text" name="text"></textarea><br />
    <input type="submit" value="등록하기" /> <input type="button" value="목록보기" onclick="history.back(-1);">
</form>
</body>
</html>
