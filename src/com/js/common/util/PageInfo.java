package com.js.common.util;

public class PageInfo {
	
	int pageNo;
	int pageTotal;
	String actionUrl;


	public PageInfo(){

	}
	
	public PageInfo(int pageNo,int pageTotal) {
		this.pageNo = pageNo;
		this.pageTotal = pageTotal;
		// TODO Auto-generated constructor stub
	}

	public PageInfo(int pageNo,int pageTotal,String actionUrl){
		this.pageNo = pageNo;
		this.pageTotal = pageTotal;
		this.actionUrl = actionUrl;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
}
