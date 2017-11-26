package com.wenhao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wenhao.form.ProductCategory;

@Mapper
public interface ProductCategoryMapper extends BaseDaoMapper{

	List<ProductCategory> selectByCategoryType(@Param("categoryType")List<Integer> list);

	List<ProductCategory> selectAll();

}
