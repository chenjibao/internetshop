package cjb.shop.order.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.order.domain.Order;
import cjb.shop.order.service.OrderService;
/**
 * @author chenjibao
 *@date2018年4月7日上午9:50:06
 *@description:订单模块的Action
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	//模型
	private Order order=new Order();
	//注入业务层service
	private OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public Order getModel() {
		return order;
	}
	
}
