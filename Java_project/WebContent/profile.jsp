<%@page import="com.entities.*"%>
<%@page errorPage="Error_Page.jsp" %>
<% 
	user u = (user) session.getAttribute("currentUser");
	if (u == null) {
    response.sendRedirect("login_page.jsp");
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%=u.getEmail() %>
	<br>
	<%=u.getName() %>
	<br>
	<%=u.getAbout() %>
</body>
</html>