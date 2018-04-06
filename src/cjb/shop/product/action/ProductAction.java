package cjb.shop.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.category.domain.Category;
import cjb.shop.category.service.CategoryService;
import cjb.shop.product.domain.Product;
import cjb.shop.product.service.ProductService;
/**
 * @author chenjibao
 *@date2018年4月3日下午9:07:48
 *@description:商品的Action类
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//注入ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//用于接受数据的模型
	private Product product=new Product();
	@Override
	public Product getModel() {
		return product;
	}
	//注入cid
	private Integer cid;
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	//注入一级分类的service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * 根据商品的id进行查询
	 * @return
	 */
	public String findByPid(){
		 product=productService.findByPid(product.getPid());
		return "findByPid";
	}
	
	/**
	 * 根据一级分类id查询商品
	 * @return
	 */
	public String findByCid(){
//		List<Category>  cList=categoryService.findAll();
		
		return "findByCid";
	}

}
