package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_item" )
public class TbItem {

	/**
	 * 商品id，同时也是商品编号
	 */
   	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 商品标题
	 */
   	@Column(name = "title" )
	private String title;

	/**
	 * 商品卖点
	 */
   	@Column(name = "sell_point" )
		private String sellPoint;

	/**
	 * 商品价格，单位为：分
	 */
   	@Column(name = "price" )
	private Integer price;

	/**
	 * 库存数量
	 */
   	@Column(name = "num" )
	private String num;

	/**
	 * 商品条形码
	 */
   	@Column(name = "barcode" )
	private String barcode;

	/**
	 * 商品图片
	 */
   	@Column(name = "image" )
	private String image;

	/**
	 * 所属类目，叶子类目
	 */
   	@Column(name = "cid" )
	private Integer cid;

	/**
	 * 商品状态，1-正常，2-下架，3-删除
	 */
   	@Column(name = "status" )
	private Integer status;

	/**
	 * 创建时间
	 */
   	@Column(name = "created" )
	private Date created;

	/**
	 * 更新时间
	 */
   	@Column(name = "updated" )
	private Date updated;

	public TbItem(){}

	public TbItem(Long id, String title, String sellPoint, Integer price, String num, String barcode, String image, Integer cid, Integer status, Date created, Date updated){
	this.id = id;
	this.title = title;
	this.sellPoint = sellPoint;
	this.price = price;
	this.num = num;
	this.barcode = barcode;
	this.image = image;
	this.cid = cid;
	this.status = status;
	this.created = created;
	this.updated = updated;
}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return this.sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		return "TbItem{" +
				"id='" + id + '\'' +
				"title='" + title + '\'' +
				"sellPoint='" + sellPoint + '\'' +
				"price='" + price + '\'' +
				"num='" + num + '\'' +
				"barcode='" + barcode + '\'' +
				"image='" + image + '\'' +
				"cid='" + cid + '\'' +
				"status='" + status + '\'' +
				"created='" + created + '\'' +
				"updated='" + updated + '\'' +
				'}';
	}

}
