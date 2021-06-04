package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_order_shipping" )
public class TbOrderShipping  implements Serializable {
	private static final long serialVersionUID =  3754212998712011903L;

	/**
	 * 订单ID
	 */
   	@Column(name = "order_id" )
	private String orderId;

	/**
	 * 收货人全名
	 */
   	@Column(name = "receiver_name" )
	private String receiverName;

	/**
	 * 固定电话
	 */
   	@Column(name = "receiver_phone" )
	private String receiverPhone;

	/**
	 * 移动电话
	 */
   	@Column(name = "receiver_mobile" )
	private String receiverMobile;

	/**
	 * 省份
	 */
   	@Column(name = "receiver_state" )
	private String receiverState;

	/**
	 * 城市
	 */
   	@Column(name = "receiver_city" )
	private String receiverCity;

	/**
	 * 区/县
	 */
   	@Column(name = "receiver_district" )
	private String receiverDistrict;

	/**
	 * 收货地址，如：xx路xx号
	 */
   	@Column(name = "receiver_address" )
	private String receiverAddress;

	/**
	 * 邮政编码,如：310001
	 */
   	@Column(name = "receiver_zip" )
	private String receiverZip;

   	@Column(name = "created" )
	private Date created;

   	@Column(name = "updated" )
	private Date updated;

	public TbOrderShipping(){}

	public TbOrderShipping(String orderId,String receiverName,String receiverPhone,String receiverMobile,String receiverState,String receiverCity,String receiverDistrict,String receiverAddress,String receiverZip,Date created,Date updated){
	this.orderId = orderId;
	this.receiverName = receiverName;
	this.receiverPhone = receiverPhone;
	this.receiverMobile = receiverMobile;
	this.receiverState = receiverState;
	this.receiverCity = receiverCity;
	this.receiverDistrict = receiverDistrict;
	this.receiverAddress = receiverAddress;
	this.receiverZip = receiverZip;
	this.created = created;
	this.updated = updated;
}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return this.receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverMobile() {
		return this.receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverState() {
		return this.receiverState;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public String getReceiverCity() {
		return this.receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverDistrict() {
		return this.receiverDistrict;
	}

	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverZip() {
		return this.receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "TbOrderShipping{" +
				"orderId='" + orderId + '\'' +
				"receiverName='" + receiverName + '\'' +
				"receiverPhone='" + receiverPhone + '\'' +
				"receiverMobile='" + receiverMobile + '\'' +
				"receiverState='" + receiverState + '\'' +
				"receiverCity='" + receiverCity + '\'' +
				"receiverDistrict='" + receiverDistrict + '\'' +
				"receiverAddress='" + receiverAddress + '\'' +
				"receiverZip='" + receiverZip + '\'' +
				"created='" + created + '\'' +
				"updated='" + updated + '\'' +
				'}';
	}

}
