package com.wenhao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhao.form.ProductCategory;
import com.wenhao.mapper.ProductCategoryMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class productCategoryCRUDTests {
	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	@Test
	public void findOneTest() {
		ProductCategory productCategory = (ProductCategory) productCategoryMapper.selectByPrimaryKey(1);
		System.out.println(productCategory.toString());
	}

	@Test
	public void findAll() {
		List<ProductCategory> productCategoryList = productCategoryMapper.selectAll();
		for (ProductCategory productCategory : productCategoryList) {
			String productCategoryMsg = productCategory.toString();
			System.out.println(productCategoryMsg);
		}
	}

	@Test
	public void saveTest() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(2);
		productCategory.setCategoryName("可口可乐");
		productCategory.setCategoryType(3);
		productCategory.setCreateTime(new Date());
		int insert = productCategoryMapper.insert(productCategory);
		System.out.println("------------" + insert);
	}

	@Test
	// @Transactional //这个注解起到回滚作用（与service的事务不同，无论是否出错都回滚）
	public void updateTest() {
		ProductCategory productCategory = (ProductCategory) productCategoryMapper.selectByPrimaryKey(2);
		productCategory.setCategoryName("可口可乐1");
		productCategory.setUpdateTime(new Date());
		int insert = productCategoryMapper.update(productCategory);
		System.out.println("------------" + insert);
	}

	@Test
	public void selectByCategoryType() {
		List<Integer> list = Arrays.asList(2, 3, 4);
		List<ProductCategory> productCategoryList = productCategoryMapper.selectByCategoryType(list);
		Assert.assertNotEquals(0, productCategoryList.size());
		/*
		 * for(ProductCategory productCategory:productCategoryList){ String
		 * productCategoryMsg = productCategory.toString();
		 * System.out.println(productCategoryMsg); }
		 */
	}
}
