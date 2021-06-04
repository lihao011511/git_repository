package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_item_param_item" )
public class TbItemParamItem  implements Serializable {
	private static final long serialVersionUID =  1402099957560375229L;

   	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 商品ID
	 */
   	@Column(name = "item_id" )
	private Integer itemId;

	/**
	 * 参数数据，格式为json格式
	 */
   	@Column(name = "param_data" )
	private String paramData;

   	@Column(name = "created" )
	private Date created;

   	@Column(name = "updated" )
	private Date updated;

	public TbItemParamItem(){}

	public TbItemParamItem(Long id,Integer itemId,String paramData,Date created,Date updated){
	this.id = id;
	this.itemId = itemId;
	this.paramData = paramData;
	this.created = created;
	this.updated = updated;
}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getParamData() {
		return this.paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
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
		return "TbItemParamItem{" +
				"id='" + id + '\'' +
				"itemId='" + itemId + '\'' +
				"paramData='" + paramData + '\'' +
				"created='" + created + '\'' +
				"updated='" + updated + '\'' +
				'}';
	}

}
