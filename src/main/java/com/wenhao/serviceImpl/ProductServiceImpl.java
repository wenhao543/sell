package com.wenhao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenhao.form.BaseBean;
import com.wenhao.form.Page;
import com.wenhao.form.ProductInfo;
import com.wenhao.mapper.ProductInfoMapper;
import com.wenhao.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductInfoMapper productInfoMapper;

	@Override
	public ProductInfo selectByProductId(String ProductId) {
		return (ProductInfo) productInfoMapper.selectByPrimaryKey(ProductId);
	}

	@Override
	public List<ProductInfo> selectUpAllByPage(Page page) {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductStatus(0);
		productInfo.setPage(page);
		return productInfoMapper.selectByProductStatusByPage(productInfo);
	}

	@Override
	public List<ProductInfo> selectAll(Page page) {
		BaseBean baseBean = new BaseBean();
		baseBean.setPage(page);
		return productInfoMapper.selectAllByPage(baseBean);
	}

	@Override
	public int insert(ProductInfo productInfo) {
		return productInfoMapper.insert(productInfo);
	}

	@Override
	public int update(ProductInfo productInfo) {
		return productInfoMapper.update(productInfo);
	}

	@Override
	public List<ProductInfo> selectUpAll() {
		return productInfoMapper.selectByProductStatus("0");
	}
	
	
	

}
