package com.server;

import java.sql.ResultSet;

import com.dao.serverDao;

public class articleServer extends server{

	/**
	 * ��article����в�ѯ
	 * @return
	 */
	public ResultSet query(){
		String sql = "select * from article";
		return this.query(sql);
		 
	}
	
	/**
	 * ��article����в���
	 * @param name�����˵�����
	 * @param article��������
	 * @return
	 */
	public int insert(String name,String article){
		String sql = "insert into article(name,article) values('"+name+"','"+article+"')";
		return this.upDate(sql);
	}
	/**
	 * ��article����и��²���
	 * @param name 
	 * @param article
	 * �޸Ķ�Ӧ�û�������
	 * @return
	 */
	public int upDate(String name,String article){
		String sql = "update article set article='"+article+"'where name='"+name+"'";
		return this.upDate(sql);
	}
	/**
	 * ��article�����ɾ������
	 * @param name ����������ɾ����Ӧ����
	 * @return
	 */
	public int delete(String name){
		String sql = "delete from  article where name='"+name+"'";
		return this.mt.execute_dml(sql);
	}
}
