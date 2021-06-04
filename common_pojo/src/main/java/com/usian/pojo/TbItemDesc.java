package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_item_desc" )
public class TbItemDesc  {

	/**
	 * 商品ID
	 */
	@Id
   	@Column(name = "item_id" )
	private Long itemId;

	/**
	 * 商品描述
	 */
   	@Column(name = "item_desc" )
	private String itemDesc;

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

	public TbItemDesc(){}

	public TbItemDesc(Integer Long,String itemDesc,Date created,Date updated){
	this.itemId = itemId;
	this.itemDesc = itemDesc;
	this.created = created;
	this.updated = updated;
}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
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
		return "TbItemDesc{" +
				"itemId='" + itemId + '\'' +
				"itemDesc='" + itemDesc + '\'' +
				"created='" + created + '\'' +
				"updated='" + updated + '\'' +
				'}';
	}

}
