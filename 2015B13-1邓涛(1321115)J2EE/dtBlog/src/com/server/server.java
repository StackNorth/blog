package com.server;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.serverDao;
import com.util.mysql.mysqlTools;
import com.util.page.page;
/**
 * ʵ��serverdao�ķ���
 * @author Administrator
 *
 */
public  class server implements serverDao{
	public mysqlTools mt=null;
	private int rs;
	private ResultSet res=null;
	public server(){
		mt = new mysqlTools();
	}
	/**
	 * �ر�����
	 */
	public void close(){
		mt.close();
	}
	/**
	 * ��ѯ���
	 */
	public ResultSet query(String sql){
		return res = this.mt.execute_dql(sql);
	}
	/**
	 * �������
	 *@param sql �������
	 *@return ����һ��int���͵���ֵ  0����ʧ�� ������ֵ����ɹ� 
	*/
	public int upDate(String sql) {
		return rs = this.mt.execute_dml(sql);
	}
	/**
	 * �����ҳ��Ϣ
	 * @param sql1  ��ѯ���ص�ǰҳ��ʾ�Ķ�����Ϣ
	 * @param sql2   ��ѯ��ҳ��
	 * @param page �����page����
	 */
	public void dealPageInfo(String sql1,String sql2,page page){
		int rowCount=0;
		this.res = this.mt.execute_dql(sql1); 
		page.setRes(res);
		this.res = this.mt.execute_dql(sql2);
		try {
			while(res.next()){
				rowCount= Integer.parseInt(res.getString("C"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setRowCount(rowCount);
		page.setPageCount((int)Math.ceil(page.getRowCount()/page.getPageSize()));
		
	}
	
}
