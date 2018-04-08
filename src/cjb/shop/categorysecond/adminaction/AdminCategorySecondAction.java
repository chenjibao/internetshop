package cjb.shop.categorysecond.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.categorysecond.domain.CategorySecond;
import cjb.shop.categorysecond.service.CategorySecondService;
import cjb.shop.utils.PageBean;
/**
 *@author chenjibao
 *@date2018年4月8日下午6:45:46
 *@description:后台二级分类管理的action 
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	//模型驱动使用的对象
	private CategorySecond categorySecond=new CategorySecond();
	//注入service
	private CategorySecondService categorySecondService;
	//注入page
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}
	//后台管理查询二级分类的方法
	public String findAll(){
		//获取pageBean
		PageBean<CategorySecond> pageBean=categorySecondService.findByPage(page);
		//将pageBean保存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	 
}
