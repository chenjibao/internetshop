package cjb.shop.categorysecond.domain;

import cjb.shop.category.domain.Category;

public class CategorySecond {
	private Integer csid;//二级分类id
	private String csname;//二级分类名称
	private Category category;//二级分裂所属的一级分类
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
