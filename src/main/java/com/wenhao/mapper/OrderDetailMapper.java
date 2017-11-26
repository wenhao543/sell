package com.wenhao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wenhao.form.OrderDetail;

@Mapper
public interface OrderDetailMapper extends BaseDaoMapper {

	List<OrderDetail> selectByOrderId(String string);

}
