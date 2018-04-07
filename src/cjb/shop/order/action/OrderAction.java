package cjb.shop.order.action;


import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.cart.domain.Cart;
import cjb.shop.cart.domain.CartItem;
import cjb.shop.order.domain.Order;
import cjb.shop.order.domain.OrderItem;
import cjb.shop.order.service.OrderService;
import cjb.shop.user.domain.User;
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
	//生成订单的方法
	public String saveOrder(){
				// 调用Service完成数据库插入的操作:
				// Order order = new Order();
				// 设置订单的总金额:订单的总金额应该是购物车中总金额:
				// 购物车在session中,从session总获得购物车信息.
				Cart cart = (Cart) ServletActionContext.getRequest().getSession()
						.getAttribute("cart");
				if (cart == null) {
					this.addActionMessage("亲!您还没有购物!");
					return "msg";
				}
				order.setTotal(cart.getTotal());
				// 设置订单的状态
				order.setState(1); // 1:未付款.
				// 设置订单时间
				order.setOrdertime(new Date());
				// 设置订单关联的客户:
				User existUser = (User) ServletActionContext.getRequest().getSession()
						.getAttribute("existUser");
				if (existUser == null) {
					this.addActionMessage("亲!您还没有登录!");
					return "msg";
				}
				order.setUser(existUser);
				// 设置订单项集合:
				for (CartItem cartItem : cart.getCartItems()) {
					// 订单项的信息从购物项获得的.
					OrderItem orderItem = new OrderItem();
					orderItem.setCount(cartItem.getCount());
					orderItem.setSubtotal(cartItem.getSubtotal());
					orderItem.setProduct(cartItem.getProduct());
					orderItem.setOrder(order);

					order.getOrderItems().add(orderItem);
				}
				orderService.save(order);
				// 清空购物车:
				cart.clearCart();

				// 页面需要回显订单信息:
				// 使用模型驱动了 所有可以不使用值栈保存了
				// ActionContext.getContext().getValueStack().set("order", order);

				return "saveOrder";
	}
	
}
