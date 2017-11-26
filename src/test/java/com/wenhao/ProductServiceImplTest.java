package com.wenhao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.form.Page;
import com.wenhao.form.ProductInfo;
import com.wenhao.serviceImpl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Test
	public void selectByProductId() {
		ProductInfo selectByProductId = productService.selectByProductId("111111");
		System.out.println(selectByProductId.toString());
	}

	@Test
	public void selectUpAllByPage() {
		Page page = new Page();
		page.setCurrentPage(1);
		page.setPageNumber(2);
		List<ProductInfo> selectUpAllByPage = productService.selectUpAllByPage(page);
		for(ProductInfo productInfo:selectUpAllByPage){
			System.out.println(productInfo.getProductId());
		}
	}

	@Test
	public void selectAll() {
		Page page = new Page();
		page.setCurrentPage(1);
		page.setPageNumber(2);
		List<ProductInfo> selectUpAllByPage = productService.selectAll(page);
		for(ProductInfo productInfo:selectUpAllByPage){
			System.out.println(productInfo.getProductId());
		}
	}
	
	@Test
	public void insert(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("44444");
		productInfo.setProductName("花生面");
		productInfo.setProductPrice(new BigDecimal(4.6));
		productInfo.setCategoryType(2);
		productInfo.setProductStock(100);
		productInfo.setProductStatus(0);
		productInfo.setProductIcon("http://sdgawegaga/dag.img");
		productInfo.setProductDescription("我吃过九亭各种花生面");
		productService.insert(productInfo);
	}
	
	@Test
	public void update(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("44444");
		productInfo.setProductName("小花生面");
		productInfo.setProductPrice(new BigDecimal(4.8));
		productInfo.setCategoryType(2);
		productInfo.setProductStock(100);
		productInfo.setProductStatus(0);
		productInfo.setProductIcon("http://sdgawegaga/dag.img");
		productInfo.setProductDescription("我吃过九亭各种小花生面");
		productService.update(productInfo);
	}

}
