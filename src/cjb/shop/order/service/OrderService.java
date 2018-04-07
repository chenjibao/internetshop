package cjb.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.order.dao.OrderDao;
import cjb.shop.order.domain.Order;
import cjb.shop.utils.PageBean;

/**
 *@author chenjibao
 *@date2018年4月7日上午9:50:42
 *@description:订单模块的业务层
 */
@Transactional
public class OrderService {
	//注入持久层dao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	//生成订单
	public void save(Order order) {
		orderDao.save(order);
	}
	
	//我的订单业务层实现（根据用户id去查询订单）
	public PageBean<Order> findByPageUid(Integer uid, int page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<Order> list = orderDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	

}
