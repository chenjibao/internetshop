package cjb.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.product.dao.ProductDao;
import cjb.shop.product.domain.Product;
/**
 * @author chenjibao
 *@date2018年4月3日下午9:08:49
 *@description:商品的业务层类
 */
@Transactional
public class ProductService {
	//注入ProductDao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	/**
	 * 首页上热门商品的查询
	 * @return
	 */
	public List<Product> findHot() {
		return productDao.findHot();
	}
	/**
	 * 首页最新商品查询
	 * @return
	 */
	public List<Product> findNew() {
		return productDao.findNew();
	}
	/**
	 * 根据id查询商品
	 * @param pid
	 * @return
	 */
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}
	

}
