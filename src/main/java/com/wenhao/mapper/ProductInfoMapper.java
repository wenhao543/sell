package com.wenhao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wenhao.form.BaseBean;
import com.wenhao.form.Page;
import com.wenhao.form.ProductInfo;

@Mapper
public interface ProductInfoMapper extends BaseDaoMapper{
	
	List<ProductInfo> selectByProductStatusByPage(ProductInfo productInfo);

	List<ProductInfo> selectAllByPage(BaseBean baseBean);

	List<ProductInfo> selectByProductStatus(String status);

}
