package com.wenhao.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenhao.enums.ResultEnum;
import com.wenhao.exception.SellException;
import com.wenhao.form.ProductCategory;
import com.wenhao.mapper.ProductCategoryMapper;
import com.wenhao.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	@Override
	public ProductCategory selectOne(Integer categoryid) {
		return (ProductCategory) productCategoryMapper.selectByPrimaryKey(categoryid);
	}

	@Override
	public List<ProductCategory> selectAll() {
		return productCategoryMapper.selectAll();
	}

	@Override
	public List<ProductCategory> selectByCategoryType(List<Integer> categoryTypeList) {
		return productCategoryMapper.selectByCategoryType(categoryTypeList);
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		int index = productCategoryMapper.update(productCategory);
		if(index!=1){
			logger.info("数据库更新失败");
			throw new SellException(ResultEnum.DATA_UPDATE_FAIL);
		}
		return productCategory;
	}

}
