<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    This is my JSP page. <br>
    <body>  
        <!--这段代码可以自动进行跳转，实现get方法传递  
        <script type="text/javascript">  
        window.location.href = "registera?username=sa&password=123"  
        </script>  
        -->  
        <form action="registera" method="post">  
            用户名：  
            <input type="text" name="username" />  
            <br />  
            密码：  
            <input type="password" name="password" />  
            <br />  
            <input type="submit" value="登陆" />  
        </form>  
    </body>  
  </body>
</html>
