package com.wenhao.service;

import java.util.List;

import com.wenhao.form.Page;
import com.wenhao.form.ProductInfo;

public interface ProductService {
	
	ProductInfo selectByProductId(String ProductId);
	/**
	 * 分页查询在售商品
	 * @return
	 */
	List<ProductInfo> selectUpAllByPage(Page page);
	/**
	 * 查询在售商品
	 * @return
	 */
	List<ProductInfo> selectUpAll();
	
	/**
	 * 查询所有商品
	 * @return
	 */
	List<ProductInfo> selectAll(Page page);
	
	/**
	 * 插入记录
	 * @param productInfo
	 * @return
	 */
	int insert(ProductInfo productInfo);
	
	/**
	 * 更新记录
	 * @param productInfo
	 * @return
	 */
	int update(ProductInfo productInfo);
	
	//加库存
	
	//减库存
}
