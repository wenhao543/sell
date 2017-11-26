package com.wenhao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhao.enums.OrderStatusEnum;
import com.wenhao.enums.PayStatusEnum;
import com.wenhao.form.OrderMaster;
import com.wenhao.mapper.OrderMasterMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterCRUDTests {
	@Autowired
	private OrderMasterMapper orderMasterMapper;
	
	@Test
	public void createOrder(){
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("201710041933232347");
		orderMaster.setBuyerAddress("上饶市广丰县");
		orderMaster.setBuyerName("刘文豪");
		orderMaster.setBuyerOpenid("oUFZVwkJstrNba__f8_otOnEszTY");
		orderMaster.setBuyerPhone("18679118427");
		orderMaster.setCreateTime(new Date());
		orderMaster.setOrderAmount(new BigDecimal(12));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		int index = orderMasterMapper.insert(orderMaster);
		if(index!=1){
			System.out.println("下单失败！");
		}
	}
	
	@Test
	public void selectOne(){
		OrderMaster orderMaster = (OrderMaster) orderMasterMapper.selectByPrimaryKey("201710041933232345");
		System.out.println(orderMaster.toString());
	}
	
	@Test
	public void selectByOpenId(){
		//limit,第一个参数表示起始下标，第二参数表示页面最大记录数
		/*List<OrderMaster> orderMasterList = orderMasterMapper.selectByOpenId("oUFZVwkJstrNba__f8_otOnEszTY",2,2);
		for(OrderMaster orderMaster:orderMasterList){
			System.out.println(orderMaster.toString());
		}*/
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setBuyerOpenid("oUFZVwkJstrNba__f8_otOnEszTY");
		orderMaster.getPage().setCurrentPage(2);
		orderMaster.getPage().setPageNumber(2);
		List<OrderMaster> orderMasterList = orderMasterMapper.selectByOpenIdByPage(orderMaster);
		for(OrderMaster item:orderMasterList){
			System.out.println(item.toString());
		}
	}
}
