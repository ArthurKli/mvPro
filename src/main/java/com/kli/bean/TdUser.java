package com.kli.bean;

import com.kli.bean.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>TdUserEntity<br>
 */
public class TdUser extends BaseEntity<TdUser> {
	
		private java.lang.Integer id;//   	private java.lang.String password;//   	private java.lang.String loginName;//   	private java.lang.String trueName;//   	private java.lang.String mobile;//   	private java.lang.String email;//   	private java.util.Date createTime;//   	private java.util.Date updateTime;//   	private java.util.Date lastLoginTime;//   	private java.lang.Integer roleId;//
	private String roleName;	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getPassword() {	    return this.password;	}	public void setPassword(java.lang.String password) {	    this.password=password;	}	public java.lang.String getLoginName() {	    return this.loginName;	}	public void setLoginName(java.lang.String loginName) {	    this.loginName=loginName;	}	public java.lang.String getTrueName() {	    return this.trueName;	}	public void setTrueName(java.lang.String trueName) {	    this.trueName=trueName;	}	public java.lang.String getMobile() {	    return this.mobile;	}	public void setMobile(java.lang.String mobile) {	    this.mobile=mobile;	}	public java.lang.String getEmail() {	    return this.email;	}	public void setEmail(java.lang.String email) {	    this.email=email;	}	public java.util.Date getCreateTime() {	    return this.createTime;	}	public void setCreateTime(java.util.Date createTime) {	    this.createTime=createTime;	}	public java.util.Date getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(java.util.Date updateTime) {	    this.updateTime=updateTime;	}	public java.util.Date getLastLoginTime() {	    return this.lastLoginTime;	}	public void setLastLoginTime(java.util.Date lastLoginTime) {	    this.lastLoginTime=lastLoginTime;	}	public java.lang.Integer getRoleId() {	    return this.roleId;	}	public void setRoleId(java.lang.Integer roleId) {	    this.roleId=roleId;	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

