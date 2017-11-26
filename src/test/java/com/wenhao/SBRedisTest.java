package com.wenhao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.form.OrderMaster;
import com.wenhao.mapper.OrderMasterMapper;
import com.wenhao.service.RedisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SBRedisTest {
	Logger logger = LoggerFactory.getLogger(SBRedisTest.class);
	@Autowired
	private RedisService redisService;
	@Before
	public void init(){
		/*OrderMaster orderMaster = (OrderMaster) orderMasterMapper.selectByPrimaryKey("201710041933232345");*/
	}
	@Test
	public void get(){
		//logger.info(string);
	}
	
	@Test
	public void add(){
		redisService.set("springboot", "springboot4redis");
	}
	
	@Test
	public void del(){
		redisService.del("springboot");
	}
}
