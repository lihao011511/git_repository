package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_item_param" )
public class TbItemParam  implements Serializable {
	private static final long serialVersionUID =  2045100504741682442L;

   	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 商品类目ID
	 */
   	@Column(name = "item_cat_id" )
	private Long itemCatId;

	/**
	 * 参数数据，格式为json格式
	 */
   	@Column(name = "param_data" )
	private String paramData;

   	@Column(name = "created" )
	private Date created;

   	@Column(name = "updated" )
	private Date updated;

	public TbItemParam(){}

	public TbItemParam(Integer id,Long itemCatId,String paramData,Date created,Date updated){
	this.id = id;
	this.itemCatId = itemCatId;
	this.paramData = paramData;
	this.created = created;
	this.updated = updated;
}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getItemCatId() {
		return this.itemCatId;
	}

	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
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
		return "TbItemParam{" +
				"id='" + id + '\'' +
				"itemCatId='" + itemCatId + '\'' +
				"paramData='" + paramData + '\'' +
				"created='" + created + '\'' +
				"updated='" + updated + '\'' +
				'}';
	}

}
