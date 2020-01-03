
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test = "${(fn:contains(fn:toUpperCase(path),'JPG')) || (fn:contains(fn:toUpperCase(path),'PNG')) || (fn:contains(fn:toUpperCase(path),'JPEG')) || (fn:contains(fn:toUpperCase(path),'GIF'))}">
<img src=${path} width="30%" height="30%" />
<br>
</c:if>
<a href="${path}">Download File</a>
</body>
</html>
