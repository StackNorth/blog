<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.comment.*"%>
<%@ page import="com.server.*"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'everyoneComment.jsp' starting page</title>
    
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
   <% if(session.getAttribute("admin") == null){
   
   %>
   	你无权查看,请先登录!
   <%}else{
   		contentServer cts = new contentServer();
   		ResultSet res = cts.query();
   		
   		while(res.next()){
   			out.print(res.getString("content")+"-----"+res.getString("name"));
   			out.print("<br/>");
   		}
   		cts.close();
   }%>
  </body>
  <a href="index.jsp">返回</a>
</html>
