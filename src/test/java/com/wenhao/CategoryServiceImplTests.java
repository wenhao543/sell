package com.wenhao;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenhao.form.ProductCategory;
import com.wenhao.mapper.ProductCategoryMapper;
import com.wenhao.serviceImpl.CategoryServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTests{
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	@Test
	public void selectOne() {
		ProductCategory productCategory = categoryServiceImpl.selectOne(1);
		System.out.println(productCategory.toString());
	}

	@Test
	public void selectAll() {
		List<ProductCategory> productCategoryList = categoryServiceImpl.selectAll();
		for(ProductCategory productCategory:productCategoryList){
			System.out.println(productCategory.toString());
		}
	}

	@Test
	public void selectByCategoryType() {
		List<Integer> list = Arrays.asList(3, 4);
		List<ProductCategory> productCategoryList = categoryServiceImpl.selectByCategoryType(list);
		for(ProductCategory productCategory:productCategoryList){
			System.out.println(productCategory.toString());
		}
	}
	
	@Test
	public void insert(){
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryName("肯德基");
		productCategory.setCategoryType(4);
		int index = productCategoryMapper.insert(productCategory);
		if(index!=1){
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void update(){
		ProductCategory productCategory = categoryServiceImpl.selectOne(1);
		productCategory.setCategoryName("龙甜！");
		int update = productCategoryMapper.update(productCategory);
		if(update!=1){
			System.out.println("数据库更新失败！");
		}
	}
	
}
