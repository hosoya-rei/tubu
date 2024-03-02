<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.*" %>

<%
	User usr = (User)session.getAttribute("usr");
	String name = usr.getName();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login result</title>
	</head>
	<body>
		<center>
			<h3>LOGIN SUCCESS!!</h3>
			<p><%= name %>さんおかえりなさい。</p>
			<a href="postCtl?action=go">go to main page</a>
		</center>
	</body>
</html>
