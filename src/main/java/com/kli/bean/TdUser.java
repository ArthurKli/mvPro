package com.kli.bean;

import com.kli.bean.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>TdUserEntity<br>
 */
public class TdUser extends BaseEntity<TdUser> {
	
	
	private String roleName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
