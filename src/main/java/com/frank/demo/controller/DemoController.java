package com.frank.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frank.shiro.token.ShiroToken;

@Controller
public class DemoController {
	
	protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(String userName,String password) {
		System.out.println(userName);
		ShiroToken token=new ShiroToken(userName,password);
		token.setRememberMe(false);			
		try {
			SecurityUtils.getSubject().login(token);
			resultMap.put("status", 200);
			resultMap.put("message", "锟斤拷录锟缴癸拷");
			resultMap.put("back_url", "home");
		}catch (AccountException e) {
			resultMap.put("status", 500);
			resultMap.put("message", "锟绞号伙拷锟斤拷锟斤拷锟斤拷锟�");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		return resultMap;
	}
	
	@RequestMapping(value="/unauthorized",method=RequestMethod.GET)
	public String Unauthoriaed() {
		System.out.println("unauthorized");
		return "unauthorized";
	}
	
	@RequestMapping(value="/home")
	@RequiresAuthentication
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/user/list")
	@RequiresPermissions("user:list")
	public String UserList(Model model) {
		System.out.println("UserList");
		return "UserList";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:login";
	}
}
