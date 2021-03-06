package com.server;

import java.sql.ResultSet;

import com.dao.serverDao;
import com.util.mysql.mysqlTools;

public class contentServer extends server{
	/**
	 * 对content表进行查询
	 * @return
	 */
	public ResultSet query(){
		String sql = "select * from content";
		return this.query(sql);
		 
	}
	
	/**
	 * 对content表进行插入
	 * @param name 留言人的名字
	 * @param content 留言内容
	 * @return
	 */
	public int insert(String name,String content,String title){
		String sql = "insert into content(name,content,title) values('"+name+"','"+content+"','"+title+"')";
		return this.upDate(sql);
	}
	/**
	 * 根据留言人的名字更新留言人留言的次数
	 * @param name 留言人名字
	 * @return
	 */
	
	public int insert_count(String name){
		return this.upDate("update content set count=count+1 where name='"+name+"'");
	}
	/**
	 * 对content表进行更新操作
	 * @param name 
	 * @param content
	 * 修改对应用户的密码
	 * @return
	 */
	public int upDate(String name,String content){
		String sql = "update content set content='"+content+"'where name='"+name+"'";
		return this.upDate(sql);
	}
	/**
	 * 对content表进行删除操作
	 * @param name 查找留言人名字删除对应留言
	 * @return
	 */
	public int delete(String name){
		String sql = "delete from  content where name='"+name+"'";
		return this.upDate(sql);
	}
}
