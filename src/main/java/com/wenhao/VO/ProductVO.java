package com.wenhao.VO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductVO {
	@JsonProperty("type")
	private Integer categoryType;
	
	@JsonProperty("name")
	private String categoryName;
	
	@JsonProperty("foods")
	private List<ProductInfoVO> productInfoVO;

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProductInfoVO> getProductInfoVO() {
		return productInfoVO;
	}

	public void setProductInfoVO(List<ProductInfoVO> productInfoVO) {
		this.productInfoVO = productInfoVO;
	}
	
	
}
