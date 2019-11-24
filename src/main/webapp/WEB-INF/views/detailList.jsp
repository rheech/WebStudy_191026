<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %><!doctype html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    function fn_update() {
        alert("${detail.boardNum}");
        var form = document.getElementById("viewForm");
        form.action = "<c:url value='/updateboard.do'/>";
        form.submit();
    }

    function fn_delete() {
        alert("${detail.boardNum}");
        var deleteform = document.getElementById("viewForm");
        deleteform.action = "<c:url value='/deleteBoard.do'/>";
        deleteform.submit();
    }
    function showPopup() {

        url = "<c:url value='/fileUpload.do'/>";

        var wnd = window.open (url, "FileUpload", "top=0, left=0, width=800, height=500, scrollbars=no,resizable=no ,status=no ,toolbar=no");
        wnd.addEventListener("beforeunload", function (event) {
            var doc = wnd.document;
            var fileName = wnd.document.getElementById("uploadfile").innerHTML;
            alert(fileName);
            this.document.getElementById("sss").innerText = "파일명: " + fileName;
        });
    }
</script>
<h1>글쓰기</h1>
<div id="sss"></div>
<form id="viewForm" name="viewForm" method="post">
	<input type="hidden" value="${detail.boardNum}" name="boardNum">
    <label>이름:</label><input type="text" name="author" value="${detail.author}" readonly><br>
    <label>제목:</label><input type="text" name="title" value="${detail.title}"/><br />
    <textarea rows="10" cols="50" name="text">${detail.text}</textarea><br />
    <input type="button" value="목록보기" onclick="location.href='/'"> <br/>
    <input type="button" value="수정" onclick='fn_update()'> <br/>
    <input type="button" value="삭제" onclick='fn_delete()'> <br/>
    <input type="button" value="파일업로드하기" onclick="showPopup();" />
</form>
</body>
</html>