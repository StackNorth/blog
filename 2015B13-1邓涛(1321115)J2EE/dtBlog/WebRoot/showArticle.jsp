<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.mysql.*" %>
<%@page import="java.sql.*" %>

<%
String title = new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
mysqlTools mst = new mysqlTools();
String sql = "select * from article where title='"+title+"'";
ResultSet res = mst.execute_dql(sql);
List<String> list = new ArrayList<String>();
if(res.next()){
	list.add(res.getString("article"));
}
mst.close();
for(String str:list){
	out.println(str);
	out.println("<a href='comment.jsp?title="+title+"'>留言</a>");
}

%>
