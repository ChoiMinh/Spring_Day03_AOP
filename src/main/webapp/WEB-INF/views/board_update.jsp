<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 수정 페이지</h1>
	<form action="boardUpdate" method="post">
		<input type="hidden" name="seq" value="${board.seq }">
		<table width="100%" border="1" cellpadding="5">
			<tr>
				<th width="20%">제목</th>
				<td width="80%">
					<input name="title" type="text" value="${board.title }"/></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>${board.writer }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" cols="50" rows="3">${board.content }</textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="수정하기"/>
	</form>
	<hr>

</body>
</html>