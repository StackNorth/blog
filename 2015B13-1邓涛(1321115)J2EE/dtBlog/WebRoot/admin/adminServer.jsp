<%@page import="com.server.adminServer"%>
<%@page import="com.util.page.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.sql.*" %>
<%@ page import="com.util.mysql.*" %>
<%@ page import="com.server.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminServer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	String judge = request.getParameter("message");
  	page p = new page();
 	//p.setPageSize(2);
	adminServer ads = new adminServer();
  if(judge.equals("query")){//查询
	 String pageNow = request.getParameter("pageNow");
	 if(pageNow != null){
	    p.setPageNow(Integer.parseInt(pageNow));
	  }
	  ads.dealPageInfo(p);
	  ResultSet res = p.getRes();
 	 out.print("<table border=1px><tr><td>id</td><td>name</td><td>password</td><td>level</td></tr>");
  	while(res.next()){
  		out.print("<tr><td>"+res.getString("id")+"</td><td>"+
  		res.getString("name")+"</td><td>"+res.getString("password")+"</td><td>"+res.getString("level")+"</td></tr>");	
  	}
  		ads.close();
	  out.print("</table>");
	  %>
	  <a href="/dtBlog/admin/adminServer.jsp?message=query&pageNow=<%=p.upPage()%>">上一页</a>
	  <a href="/dtBlog/admin/adminServer.jsp?message=query&pageNow=<%=p.downPage()%>">下一页</a>
	  <% 
  }else if(judge.equals("insert")){//插入
	%>
	插入信息<br/>
	<form action="/dtBlog/admin/user/insertAdmin.jsp" method="get" target="frame3">
	用户名:<input type="text" name="name"><br/>
	密&nbsp;码:<input type="password" name="password"><br/>
	<input type="submit" value="确定">
	</form>
	<%   
  }else if(judge.equals("update")){//更新
	  %>
	 更新信息<br/>
	  请输入要更新的用户名
	<form action="/dtBlog/admin/user/upDateAdmin.jsp" method="get" target="frame3">
	用户名:<input type="text" name="name"><br/>
	<input type="submit" value="确定">
	</form>
	  
	  
	  <% 
  }else if(judge.equals("delete")){//删除
	 
	%>
	删除信息<br/>
	<form action="/dtBlog/admin/user/deleteAdmin.jsp" method="get" target="frame3">
	请输入需要删除的用户名:<input type="text" name="name">
	<input type="submit" value="确定">
	</form>
<%}%>
  <body>
    
  </body>
</html>
