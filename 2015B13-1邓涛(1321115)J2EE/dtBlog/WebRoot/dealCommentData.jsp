<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.comment.*"%>
<%@ page import="com.server.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dealCommentData.jsp' starting page</title>
    
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
    	comment c = new comment();
    	c.setName(request.getParameter("name"));
    	c.setTitle(new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8"));
    	c.setComment(new String(request.getParameter("comment").getBytes("iso-8859-1"),"utf-8"));
    	contentServer cts = new contentServer();
    	if(cts.insert(c.getName(), c.getComment(),c.getTitle())>0){
    		cts.insert_count(c.getName());
    		out.println("添加成功");
    		response.setHeader("refresh","2;URL=index.jsp");
    	}else{
    		out.println("添加失败");
    		response.setHeader("refresh","2;URL=comment.jsp");	
    	}
    %>
  </body>
</html>
