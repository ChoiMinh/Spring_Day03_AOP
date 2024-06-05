<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Hello world!  </h1>

<P>The time on the server is ${serverTime}.</P>
<hr>
<ul>
	<li><a href="boardList">게시판 목록</a></li>
	<li><a href="boardWriteForm">게시글쓰기</a></li>
</ul>
</body>
</html>