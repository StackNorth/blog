package com.util.page;

import java.sql.ResultSet;

public class page {
	private int pageNow=1;//��ǰҳ��Ĭ�ϵ�ǰҳΪ1
	private int pageCount;//��ҳ��
	private int pageSize=10;//��ǰҳ��ʾ������Ĭ�ϵ�ǰ����Ϊ10
	private int rowCount;//������
	//private String gotoUrl;//��תҳ
	//private int pageWhole;//һ�η�����ҳ
	private ResultSet res=null;
	public ResultSet getRes() {
		return res;
	}
	public void setRes(ResultSet res) {
		this.res = res;
	}
	
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	/**
	 * ��һҳ
	 */
	public int upPage(){
		int pageUp=1;
		if(this.pageNow>1 )
			pageUp =this.pageNow-1;
		
		return pageUp;
	}
	/**
	 * ��һҳ
	 */
	public int downPage(){
		int pageDown=this.pageNow;
		if(this.pageNow<this.pageCount){
			pageDown=this.pageNow+1;
		}
		return pageDown;
			
	}

}
