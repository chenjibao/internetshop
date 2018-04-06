package cjb.shop.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.category.service.CategoryService;
import cjb.shop.product.domain.Product;
import cjb.shop.product.service.ProductService;
import cjb.shop.utils.PageBean;
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
	
	//注入当前页数
	private int page;
	
	public void setPage(int page) {
		this.page = page;
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
		//根据一级分类查询商品，带分页查询
		PageBean<Product> pageBean=productService.findByPageCid(cid,page);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

}
