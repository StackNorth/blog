package com.server;
import java.sql.ResultSet;

import com.admin.*;
import com.dao.serverDao;
import com.util.fenyepage.page;
import com.util.mysql.mysqlTools;
public class adminServer extends server{

	/**
	 * ��user����в�ѯ
	 * @return ����һ��ResultSet���͵Ľ����
	 */
	public ResultSet query(){
		String sql = "select * from User";
		return this.query(sql);
		 
	}
	/**
	 * ����name��user����в�ѯ
	 * @param name
	 * @return
	 */
	public ResultSet query_name(String name){
		String sql = "select * from User where name = '"+name+"'";
		return this.query(sql);
	}
	/**
	 * ��uesr����в���
	 * @param name
	 * @param password
	 * @return
	 */
	public int insert(String name,String password){
		return this.upDate("insert into user(name,password) values('"+name+"','"+password+"');");
	}
	/**
	 * ��user����и��²���
	 * @param name �û��ĵ�¼��
	 * @param password �û�������
	 * �޸Ķ�Ӧ�û�������
	 * @return
	 */
	public int upDate(String name,String password){
		return this.upDate("update User set password='"+password+"'where name='"+name+"'");
	}
	/**
	 * ��������ĺ���
	 * @param name �û��ĵ�¼��
	 * @param password�û�������
	 * @param level �û��Ĳ����ȼ�
	 * @return
	 */
	public int upDate(String name,String password,String level){
		return this.upDate("update User set password='"+password+"', level='"+level+"' where name='"+name+"'");
	}
	/**
	 * ��user�����ɾ������
	 * @param value ��Ӧ�����������ֵ
	 * @return
	 */
	public int delete(String value){
		return super.upDate( "delete from  User where name='"+value+"'");
	}
	
	/**
	 * ��blogregister��ע�����
	 * @param admin ע���û�
	 * @return
	 */
	public int admin_register(admin admin){
		String sql = "insert into blogregister values('"+admin.getStuNum()+"','"+admin.getPassword()+"','"+admin.getStuName()+"','"+admin.getZhuanye()
				+"','"+admin.getBanji()+"','"+admin.getSex()+"','"+admin.getEmail()+"','"+admin.getPhone()+"','"+admin.getQq()+"','"+admin.getZyxxcj()
				+"','"+admin.getHjqk()+"','"+admin.getShsj()+"')";
		return this.upDate(sql);
	}
	/**
	 * ����uers���ҳ��Ϣ
	 */
	public void dealPageInfo(page page){
		int pageStat = (page.getPageNow()-1)*page.getPageSize();
		String sql1 ="select * from user limit "+pageStat+","+page.getPageSize();
		String sql2 = "select count(id) C from user";
		this.dealPageInfo(sql1, sql2, page);
	}
	
	
	
}
