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
<title>第一轮抽签显示页面</title>
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
  <%
  	String buildingNo=(String)session.getAttribute("buildingNo");  
    String originalTenant=(String)session.getAttribute("originalTenant"); 
    String presentTenant=(String)session.getAttribute("presentTenant"); 
    String idCardNo=(String)session.getAttribute("idCardNo"); 
    String tel=(String)session.getAttribute("tel"); 
    String state=(String)session.getAttribute("state"); 
    String seqId=(String)session.getAttribute("seqId");
   %>
	<div>第一轮抽签</div>
	<!-- 信息显示部分 -->
	<div>
		<div>
			<span>房号</span><span><%=buildingNo %></span>
		</div>
		<div>
			<span>原承租人</span><span><%=originalTenant %></span>
		</div>
		<div>
			<span>现承租人</span><span><%=presentTenant %></span>
		</div>
		<div>
			<span>现承租人身份证号</span><span><%=idCardNo %></span>
		</div>
		<div>
			<span>联系电话</span><span><%=tel %></span>
		</div>
		<div>
			<span>顺序号</span><span><%=seqId %></span>
		</div>		
		<div>
			<span>状态</span><span><%=state %></span>
		</div>	
	</div>
	<!-- 抽签部分 -->
	<div class="">
		<div class="lot_state"></div>
		<div class="">
			<a href="">第一轮抽签</a>
		</div>
	</div>
	
	
</body>
</html>
