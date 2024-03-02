<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.User" %>
<%@ page import="beans.Tweet" %>
<%@ page import="java.util.*" %>

<%
	User usr = (User)session.getAttribute("usr");
	String name = usr.getName();
	ArrayList<Tweet> tweets = (ArrayList<Tweet>)application.getAttribute("tweets");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>main page</title>
	</head>
	<body>
		<center>
			<h1>TUBUYAKI APP</h1>
			<hr width=400 size=10 noshade>
			<p><%=name%>さん、ログイン中。</p>
			<a href="postCtl?action=logout">ログアウト</a>
			<a href="postCtl?action=update">更新</a>
			<form action="postCtl" method="post">
				<input type="text" name="text">
				<input type="submit" value="つぶやく">
			</form>
			<%if (tweets != null) {%>
				<%for(Tweet t : tweets) {%>
					<p><%=name%>:<%=t.getTweet()%></p>
				<%}%>
			<%}%>
		</center>
	</body>
</html>
