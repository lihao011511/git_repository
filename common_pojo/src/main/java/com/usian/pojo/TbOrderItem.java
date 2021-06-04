package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_order_item" )
public class TbOrderItem  implements Serializable {
	private static final long serialVersionUID =  6384329319263544568L;

   	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	/**
	 * 商品id
	 */
   	@Column(name = "item_id" )
	private String itemId;

	/**
	 * 订单id
	 */
   	@Column(name = "order_id" )
	private String orderId;

	/**
	 * 商品购买数量
	 */
   	@Column(name = "num" )
	private Integer num;

	/**
	 * 商品标题
	 */
   	@Column(name = "title" )
	private String title;

	/**
	 * 商品单价
	 */
   	@Column(name = "price" )
	private Integer price;

	/**
	 * 商品总金额
	 */
   	@Column(name = "total_fee" )
	private Integer totalFee;

	/**
	 * 商品图片地址
	 */
   	@Column(name = "pic_path" )
	private String picPath;

	public TbOrderItem(){}

	public TbOrderItem(String id,String itemId,String orderId,Integer num,String title,Integer price,Integer totalFee,String picPath){
	this.id = id;
	this.itemId = itemId;
	this.orderId = orderId;
	this.num = num;
	this.title = title;
	this.price = price;
	this.totalFee = totalFee;
	this.picPath = picPath;
}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	@Override
	public String toString() {
		return "TbOrderItem{" +
				"id='" + id + '\'' +
				"itemId='" + itemId + '\'' +
				"orderId='" + orderId + '\'' +
				"num='" + num + '\'' +
				"title='" + title + '\'' +
				"price='" + price + '\'' +
				"totalFee='" + totalFee + '\'' +
				"picPath='" + picPath + '\'' +
				'}';
	}

}
