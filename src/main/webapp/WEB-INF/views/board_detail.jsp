<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>글 상세보기</h1>
	
	<table width="100%" border="1">
		<tr>
			<th width="20%">제목</th>
			<td width="80%">
				[<c:out value="${board.seq }"/>] <c:out value="${board.title }"/></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><c:out value="${board.writer }"></c:out></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><c:out value="${board.regdate }"></c:out></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><c:out value="${board.cnt }"></c:out></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><c:out value="${board.content }"></c:out></td>
		</tr>
	</table>
	<hr>
	<a href="boardList">글목록</a>
	<a href="boardUpdate?seq=${board.seq }">글수정</a>
	<a href="boardDelete?seq=${board.seq }">글삭제</a>
</body>
</html>