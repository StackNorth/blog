<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.mysql.*" %>
<%@page import="java.sql.*" %>
<%
	String type = new String(request.getParameter("articleclass").getBytes("iso-8859-1"),"utf-8");
	if(session.getAttribute("admin") == null){
		out.print("你无权访问");
	}else{
		mysqlTools mst = new mysqlTools();
		String sql = "select * from article where articleclass like '%"+type+"%'";
		ResultSet res = mst.execute_dql(sql);
		List<String> list = new ArrayList<String>();
		while(res.next()){
			list.add(res.getString("title"));
		}
		mst.close();
		for(String str:list){
			out.println("<a href='showArticle.jsp?title="+str+"'>"+str+"</a><br/>");
		}
		
	}
%>