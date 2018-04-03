package cjb.shop.product.action;

import com.opensymphony.xwork2.ActionSupport;

import cjb.shop.product.service.ProductService;
/**
 * @author chenjibao
 *@date2018年4月3日下午9:07:48
 *@description:商品的Action类
 */
public class ProductAction extends ActionSupport {
	//注入ProductService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	

}
