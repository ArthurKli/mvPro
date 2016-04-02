package com.kli.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kli.bean.TdPermissions;
import com.kli.bean.TdUser;
import com.kli.service.TdPermissionsService;
import com.kli.service.TdUserService;
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private TdUserService tdUserService; 
	
	@Resource
	private TdPermissionsService tdPermissionsService; 

	/**
	 * 授权操作
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String username = (String) getAvailablePrincipal(principals);
		String username = (String) principals.getPrimaryPrincipal();
		
//		Set<Role> roleSet =  userService.findUserByUsername(username).getRoleSet();
//		//角色名的集合
//		Set<String> roles = new HashSet<String>();
//		//权限名的集合
//		Set<String> permissions = new HashSet<String>();
//		
//		Iterator<Role> it = roleSet.iterator();
//		while(it.hasNext()){
//			roles.add(it.next().getName());
//			for(Permission per:it.next().getPermissionSet()){
//				permissions.add(per.getName());
//			}
//		}
		TdUser user = new TdUser();
		user.setLoginName(username);
		List<TdUser> uList = tdUserService.findList(user);
		logger.info("授权用户："+ username);
		List<TdPermissions> hasPermList = tdPermissionsService.findListByRoleId(uList.get(0).getRoleId());
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		for(TdPermissions p : hasPermList){
			authorizationInfo.addStringPermission(p.getPermType());
		}
		
		authorizationInfo.addRole("admin");
		logger.info("管理员权限：" + authorizationInfo.getStringPermissions().toString());
		return authorizationInfo;
	}

	/**
	 * 身份验证操作
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken; 
		
		 String userName = token.getUsername(); 
	        if( userName != null && !"".equals(userName) ){  
	            TdUser user = new TdUser();
	            user.setLoginName(userName);
	            List<TdUser> list = tdUserService.findList(user);
	            if(list != null && list.size() > 0){
	            	user = list.get(0);
	            }
	  
	            if( user != null )  
	                return new SimpleAuthenticationInfo(  
	                            user.getLoginName(),user.getPassword(), getName());  
	        }  
	        return null;  
	}
	
	@Override
	public String getName() {
		return getClass().getName();
	}
}
