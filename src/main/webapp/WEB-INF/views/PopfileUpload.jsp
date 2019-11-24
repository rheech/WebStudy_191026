<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

	$(function fileSubmit() {
		var form = new FormData(document.getElementById('uploadForm'));
		$.ajax({
			url : "tryupload.do",
			data : form,
			dataType: 'json',
			processData: false, 
			contentType: false, 
			type: 'POST',
			
			success : function (response) {
				alert("success"); 
				console.log(response);
			}
			
		});
	});

	function processFile(elm) {
		var fn = $(elm).val();
		var filename = fn.match(/[^\\/]*$/)[0]; // remove C:\fakename

		this.document.getElementById("uploadfile").innerText = filename;
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	Data : ${data}

	<div style="display:none" id="uploadfile">
	</div>

 	<div>
 <form id="uploadForm" action="/tryupload.do" method="post" enctype="multipart/form-data">
  	파일: <input type="file" name="file" onchange="processFile(this)" multiple /> <br />
   	업로드 가능 파일: *.shp (sbx, dbf 등 포함 필요), *.7z, *.zip<br />
    <input type="submit" value="Upload" onclick="fileSubmit();" />
</form>
 	</div>
</body>
</html>