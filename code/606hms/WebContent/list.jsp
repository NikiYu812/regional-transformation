<%@ page language="java" import="java.util.*,com.rt.domain.*" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
    This is my JSP page. <br>
    <table>
    <%
		List<OldHouse> list = (List<OldHouse>)request.getAttribute("list");
		for(OldHouse oh :list){
		
	%>
    	<tr>
    		<td><%=oh.getId() %></td>
    		<td><%=oh.getHouse_no() %></td>
    		<td><%=oh.getP0_name() %></td>
    		<td><%=oh.getLocation() %></td>
    		<td><%=oh.getArea() %></td>
    		<td><%=oh.getSign_state() %></td>
    		<td><%=oh.getMove_seq() %></td>
    	<tr>
    <%} %>
    
    </table>
  </body>
</html>
