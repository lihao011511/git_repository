package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_order" )
public class TbOrder  implements Serializable {
	private static final long serialVersionUID =  265774163117241648L;

	/**
	 * 订单id
	 */
   	@Column(name = "order_id" )
	private String orderId;

	/**
	 * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
   	@Column(name = "payment" )
	private String payment;

	/**
	 * 支付类型，1、在线支付，2、货到付款
	 */
   	@Column(name = "payment_type" )
	private Integer paymentType;

	/**
	 * 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
   	@Column(name = "post_fee" )
	private String postFee;

	/**
	 * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
	 */
   	@Column(name = "status" )
	private Integer status;

	/**
	 * 订单创建时间
	 */
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 订单更新时间
	 */
   	@Column(name = "update_time" )
	private Date updateTime;

	/**
	 * 付款时间
	 */
   	@Column(name = "payment_time" )
	private Date paymentTime;

	/**
	 * 发货时间
	 */
   	@Column(name = "consign_time" )
	private Date consignTime;

	/**
	 * 交易完成时间
	 */
   	@Column(name = "end_time" )
	private Date endTime;

	/**
	 * 交易关闭时间
	 */
   	@Column(name = "close_time" )
	private Date closeTime;

	/**
	 * 物流名称
	 */
   	@Column(name = "shipping_name" )
	private String shippingName;

	/**
	 * 物流单号
	 */
   	@Column(name = "shipping_code" )
	private String shippingCode;

	/**
	 * 用户id
	 */
   	@Column(name = "user_id" )
	private Integer userId;

	/**
	 * 买家留言
	 */
   	@Column(name = "buyer_message" )
	private String buyerMessage;

	/**
	 * 买家昵称
	 */
   	@Column(name = "buyer_nick" )
	private String buyerNick;

	/**
	 * 买家是否已经评价
	 */
   	@Column(name = "buyer_rate" )
	private Integer buyerRate;

	public TbOrder(){}

	public TbOrder(String orderId,String payment,Integer paymentType,String postFee,Integer status,Date createTime,Date updateTime,Date paymentTime,Date consignTime,Date endTime,Date closeTime,String shippingName,String shippingCode,Integer userId,String buyerMessage,String buyerNick,Integer buyerRate){	
	this.orderId = orderId;
	this.payment = payment;
	this.paymentType = paymentType;
	this.postFee = postFee;
	this.status = status;
	this.createTime = createTime;
	this.updateTime = updateTime;
	this.paymentTime = paymentTime;
	this.consignTime = consignTime;
	this.endTime = endTime;
	this.closeTime = closeTime;
	this.shippingName = shippingName;
	this.shippingCode = shippingCode;
	this.userId = userId;
	this.buyerMessage = buyerMessage;
	this.buyerNick = buyerNick;
	this.buyerRate = buyerRate;
}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Integer getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getPostFee() {
		return this.postFee;
	}

	public void setPostFee(String postFee) {
		this.postFee = postFee;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getPaymentTime() {
		return this.paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getConsignTime() {
		return this.consignTime;
	}

	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getShippingName() {
		return this.shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingCode() {
		return this.shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBuyerMessage() {
		return this.buyerMessage;
	}

	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	public String getBuyerNick() {
		return this.buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public Integer getBuyerRate() {
		return this.buyerRate;
	}

	public void setBuyerRate(Integer buyerRate) {
		this.buyerRate = buyerRate;
	}

	@Override
	public String toString() {
		return "TbOrder{" +
				"orderId='" + orderId + '\'' +
				"payment='" + payment + '\'' +
				"paymentType='" + paymentType + '\'' +
				"postFee='" + postFee + '\'' +
				"status='" + status + '\'' +
				"createTime='" + createTime + '\'' +
				"updateTime='" + updateTime + '\'' +
				"paymentTime='" + paymentTime + '\'' +
				"consignTime='" + consignTime + '\'' +
				"endTime='" + endTime + '\'' +
				"closeTime='" + closeTime + '\'' +
				"shippingName='" + shippingName + '\'' +
				"shippingCode='" + shippingCode + '\'' +
				"userId='" + userId + '\'' +
				"buyerMessage='" + buyerMessage + '\'' +
				"buyerNick='" + buyerNick + '\'' +
				"buyerRate='" + buyerRate + '\'' +
				'}';
	}

}
