<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %><!doctype html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>글쓰기</h1>
<form action="submit.do" method="post">
    <label>이름:</label><input type="text" name="author" /><br />
    <label>제목:</label><input type="text" name="title" /><br />
    <textarea rows="10" cols="50" name="text"></textarea><br />
    <input type="submit" value="등록하기" /> <input type="button" value="목록보기" onclick="history.back(-1);">
</form>
</body>
</html>
