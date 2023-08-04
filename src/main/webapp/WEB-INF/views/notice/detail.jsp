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
</style>
</head>
<body>
 <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

<main>
	<table>
	<colgroup>
		<col width="250px"/>
		<col />
	</colgourp>
	<tbody>
	<ul>
	<tr>
				<td>
			<li style= "list-style:none">
				<label>글번호</label>
					<span>${requestScope.notice.noticeNo }</span>
			</li>
			</td>
	</tr>
		<tr>
	<td>
			<li style= "list-style:none" >
				<label>작성일</label>
				<span>${requestScope.notice.noticeDate }</span>
			</li>
				</td>
	</tr>
	<tr>
	<td>
			<li style= "list-style:none">
				<label>글쓴이</label>
					<span>${requestScope.notice.noticeWriter }</span>
				</li>
				</td>
	</tr>
	<tr>
	<td>
			
			<li style= "list-style:none" >
				<label>제목</label>
					<span>${requestScope.notice.noticeSubject }</span>
			</li>
						</td>
	</tr>
			<tr>
	<td>
				<li style= "list-style:none" >
				<label>내용</label>
				<p>${notice.noticeContent}</p>
				</li>
								</td>
	</tr>
	 <div id ="tablebtn">
	<button class="editBtn"><a href="/notice/list.do?currentPage=${noticeNo %100}">목록으로 이동하기</a></button>
	<button class="editBtn" id="eidt"><a href="/notice/modify.do?noticeNo=${notice.noticeNo }">수정하기</a></button>
	<button class="editBtn"  id="delete"><a href="javascript:void(0);" onclick="deletecheck();">삭제하기</a></button>
		 </div>
		
			</ul>
	</tbody>
	</table>

</main>
</body>
	<script>
		const deletecheck = () = > {
				const noticeNo= ${notice.noticeNo};
				if(confirm("정말 삭제하시겠습니까?")){
					location.href="/notice/delete.do?noticeNo="+noticeNo;
					
				}
		}
	</script>
</html>