package cn.edu.hbmy.vo;

import java.util.List;

import cn.edu.hbmy.utils.BaseVo;

import com.github.pagehelper.Page;

public class PageVo extends BaseVo{

	private static final long serialVersionUID = 1L;
	/** 当前页码 */
	private Integer pageIndex;
	/** 每页显示条数 */
	private Integer pageSize;
	/** 总记录条数 */
	private Long totalCount;
	/** 总页数 */
	private Integer totalPages;
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	public <T> void setData(List<T> list){
		if(list instanceof Page){
			Page<T> page = (Page<T>)list;
			this.setPageIndex(page.getPageNum());
			this.setPageSize(page.getPageSize());
			this.setTotalCount(page.getTotal());
			this.setTotalPages(page.getPages());
		}
	}
	@Override
	public String toString() {
		return "PageVo [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPages=" + totalPages + "]";
	}
}
  
