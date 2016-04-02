package com.kli.bean;

import com.kli.bean.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>TdRoleEntity<br>
 */
public class TdRolePerm extends BaseEntity<TdRolePerm> {
	
		private java.lang.Integer roleId;  
	private java.lang.Integer permId;  	private java.lang.String permType;//   

	public java.lang.Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(java.lang.Integer roleId) {
		this.roleId = roleId;
	}
	public java.lang.Integer getPermId() {
		return permId;
	}
	public void setPermId(java.lang.Integer permId) {
		this.permId = permId;
	}
	public java.lang.String getPermType() {
		return permType;
	}
	public void setPermType(java.lang.String permType) {
		this.permType = permType;
	}
}

