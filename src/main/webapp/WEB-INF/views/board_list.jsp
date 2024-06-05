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

	<h1>게시판 목록</h1>
	<c:forEach var="board" items="${boardList }">
		<p>
			<c:out value="${board.seq }"></c:out> |
			<a href="boardDetail?seq=${board.seq }">
				<c:out value="${board.title }"></c:out>
			</a> |
			<c:out value="${board.writer }"></c:out> |
			<c:out value="${board.regdate }"></c:out> |
			<c:out value="${board.cnt }"></c:out> |
			<a href="boardDelete?seq=${board.seq }">글삭제</a>
		</p>
	</c:forEach>

<hr>
<a href="boardWriteForm">게시글쓰기</a>
</body>
</html>