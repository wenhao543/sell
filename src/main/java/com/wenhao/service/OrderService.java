package com.wenhao.service;

import java.util.List;

import com.wenhao.form.OrderMaster;

public interface OrderService {
	/**
	 * 创建订单
	 * @param orderMaster
	 * @return
	 */
	OrderMaster createOrder(OrderMaster orderMaster);
	
	/**
	 * 查询单个订单
	 * @param orderId
	 * @return
	 */
	OrderMaster searchOneOrder(String  orderId);
	/**
	 * 查询订单列表（分页）
	 * @param orderMaster
	 * @return
	 */
	List<OrderMaster> searchOrderList(OrderMaster orderMaster);
	/**
	 * 取消订单
	 * @param orderMaster
	 * @return
	 */
	OrderMaster cancelOrder(OrderMaster orderMaster);
	/**
	 * 支付订单
	 * @param orderMaster
	 * @return
	 */
	OrderMaster payOrder(OrderMaster orderMaster);
	/**
	 * 完成订单
	 * @param orderMaster
	 * @return
	 */
	OrderMaster finshOrder(OrderMaster orderMaster);
}
