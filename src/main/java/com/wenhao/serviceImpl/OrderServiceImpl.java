package com.wenhao.serviceImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenhao.enums.OrderStatusEnum;
import com.wenhao.enums.PayStatusEnum;
import com.wenhao.enums.ResultEnum;
import com.wenhao.exception.SellException;
import com.wenhao.form.OrderDetail;
import com.wenhao.form.OrderMaster;
import com.wenhao.form.ProductInfo;
import com.wenhao.mapper.OrderDetailMapper;
import com.wenhao.mapper.OrderMasterMapper;
import com.wenhao.service.OrderService;
import com.wenhao.service.ProductService;
import com.wenhao.util.KeyUtil;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private  OrderMasterMapper orderMasterMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Override
	@Transactional
	public OrderMaster createOrder(OrderMaster orderMaster) {
		String orderId = KeyUtil.getUniqueKey();
		//查询商品
		List<OrderDetail> orderDetailList = orderMaster.getOrderDetailList();
		BigDecimal totalMoney = new BigDecimal(BigInteger.ZERO);
		for(OrderDetail orderDetail:orderDetailList){
			String productId = orderDetail.getProductId();
			Integer productQuantity = orderDetail.getProductQuantity();
			ProductInfo productInfo = productService.selectByProductId(productId);
			if(productInfo==null){
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			BigDecimal productPrice = productInfo.getProductPrice();
			//计算总价
			totalMoney = productPrice.multiply(new BigDecimal(productQuantity)).add(totalMoney);
			//订单入库
			BeanUtils.copyProperties(productInfo, orderDetail);
			orderDetail.setOrderId(orderId);
			orderDetail.setDetailId(KeyUtil.getUniqueKey());
			int index = orderDetailMapper.insert(orderDetail);
			if(index!=1){
				throw new SellException(ResultEnum.DATA_UPDATE_FAIL);
			}
		}
		orderMaster.setOrderId(orderId);
		orderMaster.setOrderAmount(totalMoney);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		int index = orderMasterMapper.insert(orderMaster);
		if(index!=1){
			throw new SellException(ResultEnum.DATA_UPDATE_FAIL);
		}
		//减库存
		return orderMaster;
	}

	@Override
	public OrderMaster searchOneOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderMaster> searchOrderList(OrderMaster orderMaster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderMaster cancelOrder(OrderMaster orderMaster) {
		// TODO Auto-generated method stub
		return orderMaster;
	}

	@Override
	public OrderMaster payOrder(OrderMaster orderMaster) {
		// TODO Auto-generated method stub
		return orderMaster;
	}

	@Override
	public OrderMaster finshOrder(OrderMaster orderMaster) {
		// TODO Auto-generated method stub
		return orderMaster;
	}

}
