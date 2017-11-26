package com.wenhao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.enums.ResultEnum;
import com.wenhao.exception.SellException;
import com.wenhao.form.OrderDetail;
import com.wenhao.mapper.OrderDetailMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailCRUDTests {
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Test
	public void save(){
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCreateTime(new Date());
		orderDetail.setDetailId("124");
		orderDetail.setOrderId("201710041933232345");
		orderDetail.setProductIcon("http://www.nicecoder.cn/pic/214.pic");
		orderDetail.setProductId("001");
		orderDetail.setProductName("中秋月饼");
		orderDetail.setProductPrice(new BigDecimal(18.5));
		orderDetail.setProductQuantity(2);
		int insert = orderDetailMapper.insert(orderDetail);
		if(insert==1){
			System.out.println("插入数据成功！");
		}
	}
	@Test
	public void selectByDetailId(){
		OrderDetail orderDetail =  (OrderDetail) orderDetailMapper.selectByPrimaryKey("124");
		System.out.println(orderDetail.toString());
	}
	@Test
	public void selectByOrderId(){
		List<OrderDetail> orderDetailList =  (List<OrderDetail>) orderDetailMapper.selectByOrderId("201710041933232345");
		for(OrderDetail orderDetail:orderDetailList){
			System.out.println(orderDetail.toString());
		}
	}
	
	/*@Test
	public void OrderException(){
		throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
	}*/
}
