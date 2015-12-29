package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.admin;
import com.server.adminServer;

public class regServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public regServlet() {
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
		deal_register_info(out,request,response);
		out.flush();
		out.close();
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
	
	public void deal_register_info(PrintWriter out,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{

  		admin user = new admin();
   		user.setStuName(new String(request.getParameter("StuName").getBytes("iso-8859-1"),"utf-8"));
   		user.setPassword(request.getParameter("password"));
   		user.setStuNum(request.getParameter("StuNum"));
   		user.setZhuanye(new String(request.getParameter("zhuanye").getBytes("iso-8859-1"),"utf-8"));
   		user.setBanji(request.getParameter("banji"));
   		user.setSex(new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8"));
   		user.setEmail(request.getParameter("email"));
   		user.setPhone(request.getParameter("phone"));
   		user.setQq(request.getParameter("qq"));
   		user.setZyxxcj(new String(request.getParameter("zyxxcj").getBytes("iso-8859-1"),"utf-8"));
   		user.setHjqk(new String(request.getParameter("hjqk").getBytes("iso-8859-1"),"utf-8"));
   		user.setShsj(new String(request.getParameter("shsj").getBytes("iso-8859-1"),"utf-8"));
   		adminServer ads = new adminServer();
   		int a = ads.admin_register(user);
   		if(a>0){
   			String name=user.getStuNum();
   			String password= user.getPassword();
   			if(ads.insert(name,password)>0){
   				out.println(" ע��ɹ������������¼���� ��������������");
   				response.setHeader("refresh","3;URL=../rLogin.jsp?name="+name+"&password="+password);
   				
   			}
   		}else{
   			out.println(" ע��ʧ�ܣ�������ע�ᡣ����������");
   			response.setHeader("refresh","3;URL=../Register.jsp");
   		}
   		ads.close();
	}

}
