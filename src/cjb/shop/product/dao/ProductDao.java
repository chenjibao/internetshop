package cjb.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.product.domain.Product;
/**
 * @author chenjibao
 *@date2018年4月3日下午9:08:21
 *@description:商品的持久层类
 */
public class ProductDao {
	//注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/**
	 * 热门商品的查询
	 * @return
	 */
	public List<Product> findHot() {
		//使用离线查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		//按日期降序排序
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list=(List<Product>) hibernateTemplate.findByCriteria(criteria, 0, 20);
		return list;
	}
	

}
