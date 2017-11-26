package com.wenhao.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.wenhao.enums.OrderStatusEnum;
import com.wenhao.enums.PayStatusEnum;

public class OrderMaster extends BaseBean{
	private static final long serialVersionUID = 1L;
	/**
	 * 订单号
	 */
    private String orderId;
	/**
	 *买家名称 
	 */
    private String buyerName;
    /**
     * 买家联系方式
     */
    private String buyerPhone;
    /**
     * 买家收货地址
     */
    private String buyerAddress;
    /**
     * 买家openid
     */
    private String buyerOpenid;
    /**
     * 交易金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认“已下单”
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态，默认“待支付”
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
	/**
	 *创建时间 
	 */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 订单详情列表
     */
    private List<OrderDetail> orderDetailList;

    public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "OrderMaster [orderId=" + orderId + ", buyerName=" + buyerName + ", buyerPhone=" + buyerPhone
				+ ", buyerAddress=" + buyerAddress + ", buyerOpenid=" + buyerOpenid + ", orderAmount=" + orderAmount
				+ ", orderStatus=" + orderStatus + ", payStatus=" + payStatus + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
    
}