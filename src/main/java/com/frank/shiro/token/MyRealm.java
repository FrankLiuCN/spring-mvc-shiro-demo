package com.frank.shiro.token;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service
public class MyRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String userName = (String) principalCollection.fromRealm(getName()).iterator().next();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> set = new HashSet<String>();
		if ("admin".equals(userName)) {
			set.add("admin");
			info.setRoles(set);
			Set<String> adminPerms = new HashSet<String>();
			adminPerms.add("/user/list");
			adminPerms.add("/user/details");
			info.addStringPermission("user:list");
		} else if ("frank".equals(userName)) {
			set.add("user");
			info.setRoles(set);
			Set<String> userPerms = new HashSet<String>();
			userPerms.add("user:list2");
			info.setStringPermissions(userPerms);
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		ShiroToken token = (ShiroToken) authenticationToken;
		Map<String, String> users = new HashMap<String, String>();
		users.put("admin", "admin");
		users.put("frank", "frank");
		String userName = token.getUsername();
		String password= token.getPswd();
		if (users.containsKey(userName)) {
			if (users.get(userName).equals(password)) {
				return new SimpleAuthenticationInfo(userName, users.get(userName), getName());
			}
		}	
		throw new AccountException("�ʺŻ����벻��ȷ��");	
	}

}