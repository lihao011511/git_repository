package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_content" )
public class TbContent  implements Serializable {
	private static final long serialVersionUID =  7580231791023580529L;

   	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 内容类目ID
	 */
   	@Column(name = "category_id" )
	private Integer categoryId;

	/**
	 * 内容标题
	 */
   	@Column(name = "title" )
	private String title;

	/**
	 * 子标题
	 */
   	@Column(name = "sub_title" )
	private String subTitle;

	/**
	 * 标题描述
	 */
   	@Column(name = "title_desc" )
	private String titleDesc;

	/**
	 * 链接
	 */
   	@Column(name = "url" )
	private String url;

	/**
	 * 图片绝对路径
	 */
   	@Column(name = "pic" )
	private String pic;

	/**
	 * 图片2
	 */
   	@Column(name = "pic2" )
	private String pic2;

	/**
	 * 内容
	 */
   	@Column(name = "content" )
	private String content;

   	@Column(name = "created" )
	private Date created;

   	@Column(name = "updated" )
	private Date updated;

	public TbContent(){}

	public TbContent(Integer id,Integer categoryId,String title,String subTitle,String titleDesc,String url,String pic,String pic2,String content,Date created,Date updated){
	this.id = id;
	this.categoryId = categoryId;
	this.title = title;
	this.subTitle = subTitle;
	this.titleDesc = titleDesc;
	this.url = url;
	this.pic = pic;
	this.pic2 = pic2;
	this.content = content;
	this.created = created;
	this.updated = updated;
}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return this.subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getTitleDesc() {
		return this.titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic2() {
		return this.pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "TbContent{" +
				"id='" + id + '\'' +
				"categoryId='" + categoryId + '\'' +
				"title='" + title + '\'' +
				"subTitle='" + subTitle + '\'' +
				"titleDesc='" + titleDesc + '\'' +
				"url='" + url + '\'' +
				"pic='" + pic + '\'' +
				"pic2='" + pic2 + '\'' +
				"content='" + content + '\'' +
				"created='" + created + '\'' +
				"updated='" + updated + '\'' +
				'}';
	}

}
