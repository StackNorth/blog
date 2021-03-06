package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.adminServer;

public class loginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=GBK"); 
		PrintWriter out = response.getWriter();
		deal_login_info(out,request,response);
		out.flush();
		out.close();
	}
	/**
	 * 处理登录信息
	 * @param out
	 * @param request
	 * @param response
	 */
	private void deal_login_info(PrintWriter out, HttpServletRequest request,
			HttpServletResponse response) {
		String psw= request.getParameter("password");
	  	String name= request.getParameter("name");
	  	try {
			name =new String(name.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	  	adminServer ads = new adminServer();
	 	String sql="select name,password,level from User where name='"+name+"'"; 
	 	ResultSet rs=ads.query(sql);
	 	String str=null;
	 
	 	try {
			while(rs.next()) 
			 { 
				
				if(rs.getString("password").equals(psw)){
					if(rs.getString("level").equals("1")){
						request.getSession().setAttribute("admin",name);
				  		out.print("欢迎回来"+request.getSession().getAttribute("admin")+"正在连接管理员页面.......");
				  		response.setHeader("refresh","3;URL=../admin/MyFrameset.jsp");
				  		
					}else{
						request.getSession().setAttribute("admin",name);
				  		out.print("欢迎回来"+request.getSession().getAttribute("admin"));
				  		response.setHeader("refresh","3;URL=../index.jsp");
					}
					ads.close();
					return ;
				}
			 }
		} catch (SQLException e) {
			e.getMessage();
		}  
	 		ads.close();
	  		out.print("请先注册");
	  		response.setHeader("refresh","3;URL=../Register.jsp");
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
