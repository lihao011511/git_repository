package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_item_cat" )
public class TbItemCat {

	/**
	 * 类目ID
	 */
   	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 父类目ID=0时，代表的是一级的类目
	 */
   	@Column(name = "parent_id")
	private Long parentId;

	/**
	 * 类目名称
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 状态。可选值:1(正常),2(删除)
	 */
   	@Column(name = "status" )
	private Integer status;

	/**
	 * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
	 */
   	@Column(name = "sort_order" )
	private Integer sortOrder;

	/**
	 * 该类目是否为父类目，1为true，0为false
	 */
   	@Column(name = "is_parent" )
	private Integer isParent;

	/**
	 * 创建时间
	 */
   	@Column(name = "created" )
	private Date created;

	/**
	 * 创建时间
	 */
   	@Column(name = "updated" )
	private Date updated;

	public TbItemCat(){}

	public TbItemCat(Integer id,Long parentId,String name,Integer status,Integer sortOrder,Integer isParent,Date created,Date updated){
	this.id = id;
	this.parentId = parentId;
	this.name = name;
	this.status = status;
	this.sortOrder = sortOrder;
	this.isParent = isParent;
	this.created = created;
	this.updated = updated;
}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getIsParent() {
		return this.isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
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
		return "TbItemCat{" +
				"id='" + id + '\'' +
				"parentId='" + parentId + '\'' +
				"name='" + name + '\'' +
				"status='" + status + '\'' +
				"sortOrder='" + sortOrder + '\'' +
				"isParent='" + isParent + '\'' +
				"created='" + created + '\'' +
				"updated='" + updated + '\'' +
				'}';
	}

}
