package com.usian.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * @Description  
 * @Author  baodan_Fan 
 * @Date 2021-05-10 
 */

@Table ( name ="tb_user" )
public class TbUser  implements Serializable {
	private static final long serialVersionUID =  1874153329915516792L;

   	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 用户名
	 */
   	@Column(name = "username" )
	private String username;

	/**
	 * 密码，加密存储
	 */
   	@Column(name = "password" )
	private String password;

	/**
	 * 注册手机号
	 */
   	@Column(name = "phone" )
	private String phone;

	/**
	 * 注册邮箱
	 */
   	@Column(name = "email" )
	private String email;

   	@Column(name = "created" )
	private Date created;

   	@Column(name = "updated" )
	private Date updated;

	public TbUser(){}

	public TbUser(Integer id,String username,String password,String phone,String email,Date created,Date updated){
	this.id = id;
	this.username = username;
	this.password = password;
	this.phone = phone;
	this.email = email;
	this.created = created;
	this.updated = updated;
}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "TbUser{" +
				"id='" + id + '\'' +
				"username='" + username + '\'' +
				"password='" + password + '\'' +
				"phone='" + phone + '\'' +
				"email='" + email + '\'' +
				"created='" + created + '\'' +
				"updated='" + updated + '\'' +
				'}';
	}

}
