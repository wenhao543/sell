package com.wenhao.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenhao.VO.ProductInfoVO;
import com.wenhao.VO.ProductVO;
import com.wenhao.VO.ResultVO;
import com.wenhao.form.ProductCategory;
import com.wenhao.form.ProductInfo;
import com.wenhao.service.CategoryService;
import com.wenhao.service.ProductService;
import com.wenhao.util.ResultVOUtil;

@RestController
public class BuyerProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/buyer/product/list")
	public ResultVO list(){
		//1.查询所有商品
		List<ProductInfo> productInfoList = productService.selectUpAll();
		List<Integer> categoryTypeList = new ArrayList<Integer>();
		
		//2.查询所有类目
		for(ProductInfo productInfo:productInfoList){
			Integer categoryType = productInfo.getCategoryType();
			categoryTypeList.add(categoryType);
		}
		List<ProductCategory> productCategoryList = categoryService.selectByCategoryType(categoryTypeList);
		//3.数据组装
		List<ProductVO> productVOList = new ArrayList<ProductVO>();
		for(ProductCategory productCategory:productCategoryList){
			List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
			ProductVO productVO = new ProductVO();
			for(ProductInfo productInfo:productInfoList){
				if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
			}
			productVO.setCategoryType(productCategory.getCategoryType());
			productVO.setCategoryName(productCategory.getCategoryName());
			productVO.setProductInfoVO(productInfoVOList);
			productVOList.add(productVO);
		}
		return ResultVOUtil.success(productVOList);
	}
}
