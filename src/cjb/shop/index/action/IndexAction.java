package cjb.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cjb.shop.category.domain.Category;
import cjb.shop.category.service.CategoryService;

public class IndexAction extends ActionSupport {
	//注入一级分类的Service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	

	@Override
	public String execute() throws Exception {
		//查询所有以及分类的集合
		List<Category> cList=categoryService.findAll();
		ActionContext.getContext().getSession().put("cList", cList);
		return "index";
	}
}
