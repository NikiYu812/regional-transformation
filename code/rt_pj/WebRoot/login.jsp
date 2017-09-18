<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<body>
	<div style="color: red;">
	<%
	 	if (request.getAttribute("errmsg") != null) {
	 		out.println(request.getAttribute("errmsg"));
	 	}
	 %> 
	</div>
	<div>登陆页面</div>
	<form action="loginServlet" method="post">
		房号： <input type="text" name="buildingNo1" />栋<input type="text" name="buildingNo2" />号 
		<input type="submit" value="查询" />
	</form>
</body>
</html>
