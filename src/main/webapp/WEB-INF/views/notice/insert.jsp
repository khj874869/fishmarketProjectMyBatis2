<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수산시장</title>
<link rel="stylesheet" href="../resource/index.css">
<script src="../resource/index.js" defer></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../resource/body.css">
<link rel="stylesheet" href="../resource/product .css">
<link rel="stylesheet" href="../resource/footer.css">
<link rel="stylesheet" href="../resource/slider.css">
<link rel="stylesheet" href="../resource/notice.css">
<style >
 a:link { color: white; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: blue; text-decoration: underline;}
 textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"],
        input[type="reset"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #0056b3;
        }
</style>
</head>
<body>
 <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

<main>
</head>
	<h1>공지사항 작성</h1>
	<form action="/notice/insert.do" method="post">
	<fieldset>
		<legend>공지사항 작성</legend>
			<ul>
			<table>
			<tr>
				<td>
			<li style= "list-style:none">
				<label >제목</label>
				<input type="text" id="" name="noticeSubject">
			</li>
				</td>
			</tr>
			<tr>
				<td>
				<li style= "list-style:none">
				<label>내용</label>
				<textarea rows="30" cols="80" name="noticeContent"></textarea>
				</li>
				</td>
				</tr>
			</ul>
			</table>
	</fieldset>
	<div>
		<input type ="submit" value="작성">
		<input type="reset"value="초기화">
	</div>
	</form>
	</main>
</body>
</html>