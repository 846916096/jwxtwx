package cn.edu.hbmy.utils;

import java.io.Serializable;

/**
 * 封装分页属性
 * @author zhaoqx
 *
 */
public class PageBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int page;//当前页码
	private int rows;//每页显示的记录数
	private int totalCount;//总记录数
	private int totalPages; //总页数
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
