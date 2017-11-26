package com.wenhao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wenhao.form.OrderMaster;

@Mapper
public interface OrderMasterMapper extends BaseDaoMapper{

	List<OrderMaster> selectByOpenId(@Param("buyerOpenid") String buyerOpenid,@Param("rowStart") int rowStart,@Param("rowNum")int rowNum);

	List<OrderMaster> selectByOpenIdByPage(OrderMaster orderMaster);


}
