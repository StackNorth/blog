package com.server;

import java.sql.ResultSet;

import com.dao.serverDao;
import com.util.mysql.mysqlTools;

public class contentServer extends server{
	/**
	 * ��content����в�ѯ
	 * @return
	 */
	public ResultSet query(){
		String sql = "select * from content";
		return this.query(sql);
		 
	}
	
	/**
	 * ��content����в���
	 * @param name �����˵�����
	 * @param content ��������
	 * @return
	 */
	public int insert(String name,String content,String title){
		String sql = "insert into content(name,content,title) values('"+name+"','"+content+"','"+title+"')";
		return this.upDate(sql);
	}
	/**
	 * ���������˵����ָ������������ԵĴ���
	 * @param name ����������
	 * @return
	 */
	
	public int insert_count(String name){
		return this.upDate("update content set count=count+1 where name='"+name+"'");
	}
	/**
	 * ��content����и��²���
	 * @param name 
	 * @param content
	 * �޸Ķ�Ӧ�û�������
	 * @return
	 */
	public int upDate(String name,String content){
		String sql = "update content set content='"+content+"'where name='"+name+"'";
		return this.upDate(sql);
	}
	/**
	 * ��content�����ɾ������
	 * @param name ��������������ɾ����Ӧ����
	 * @return
	 */
	public int delete(String name){
		String sql = "delete from  content where name='"+name+"'";
		return this.upDate(sql);
	}
}
