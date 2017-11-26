package com.wenhao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.enums.ResultEnum;
import com.wenhao.exception.SellException;
import com.wenhao.form.ProductInfo;
import com.wenhao.mapper.ProductInfoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoCRUDTest {
	
	@Autowired
	private ProductInfoMapper productInfoMapper;
	
	@Test
	public void saveTest(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("33333");
		productInfo.setProductName("细化面");
		productInfo.setProductPrice(new BigDecimal(4.2));
		productInfo.setCategoryType(3);
		productInfo.setProductStock(100);
		productInfo.setProductStatus(0);
		productInfo.setProductIcon("http://sdgawegaga/dag.img");
		productInfo.setProductDescription("我吃过九亭各种细化面");
		
		int index = productInfoMapper.insert(productInfo);
		if(index!=1){
			throw new SellException(ResultEnum.DATA_UPDATE_FAIL);
		}
		
		 ProductInfo productInfo1 = (ProductInfo) productInfoMapper.selectByPrimaryKey("33333");
		 System.out.println(productInfo1.toString());
	}
	
	@Test
	public void findByProductStatus(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductStatus(0);
		productInfo.getPage().setPageNumber(1);
		productInfo.getPage().setCurrentPage(2);
		List<ProductInfo> productInfoList = productInfoMapper.selectByProductStatusByPage(productInfo);
		for(ProductInfo item:productInfoList){
			System.out.println(item.toString());
			
		}
	}

}
