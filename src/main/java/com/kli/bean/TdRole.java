package com.kli.bean;/** *  * <br> * <b>功能：</b>TdRoleEntity<br> */public class TdRole extends BaseEntity<TdRole> {			private java.lang.Integer id;//   	private java.lang.String roleName;//   	private java.lang.String roleDesc;//   	private java.lang.String permissions;//   	private java.util.Date createTime;//   	private java.util.Date updateTime;//   	private java.lang.Integer status;//   	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getRoleName() {	    return this.roleName;	}	public void setRoleName(java.lang.String roleName) {	    this.roleName=roleName;	}	public java.lang.String getRoleDesc() {	    return this.roleDesc;	}	public void setRoleDesc(java.lang.String roleDesc) {	    this.roleDesc=roleDesc;	}	public java.lang.String getPermissions() {	    return this.permissions;	}	public void setPermissions(java.lang.String permissions) {	    this.permissions=permissions;	}	public java.util.Date getCreateTime() {	    return this.createTime;	}	public void setCreateTime(java.util.Date createTime) {	    this.createTime=createTime;	}	public java.util.Date getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(java.util.Date updateTime) {	    this.updateTime=updateTime;	}	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}}