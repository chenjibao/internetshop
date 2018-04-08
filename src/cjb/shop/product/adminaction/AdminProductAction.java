package cjb.shop.product.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.product.domain.Product;
import cjb.shop.product.service.ProductService;
import cjb.shop.utils.PageBean;
/**
 *@author chenjibao
 *@date2018年4月8日下午10:23:27
 *@description:后台商品管理的Action
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	//模型驱动
	private Product product=new Product();
	//注入商品的service
	private ProductService productService;
	//注入page
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public Product getModel() {
		return product;
	}
	//查询所有商品的方法
//	adminProduct_findAll
	public String findAll(){
		//获取pageBean
		PageBean<Product> pageBean=productService.findByPage(page);
		//将数据保存到值栈中，然后在页面中显示
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//页面跳转
		return "findAll";
	}

}
