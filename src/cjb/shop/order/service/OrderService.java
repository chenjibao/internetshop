package cjb.shop.order.service;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.order.dao.OrderDao;
import cjb.shop.order.domain.Order;

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
	

}
