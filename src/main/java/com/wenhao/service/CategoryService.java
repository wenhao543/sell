package com.wenhao.service;

import java.util.List;

import com.wenhao.form.ProductCategory;

public interface CategoryService {
	
	ProductCategory selectOne(Integer categoryid);
	
	List<ProductCategory> selectAll();
	
	List<ProductCategory> selectByCategoryType(List<Integer> categoryTypeList);
	
	ProductCategory save(ProductCategory productCategory);
}
