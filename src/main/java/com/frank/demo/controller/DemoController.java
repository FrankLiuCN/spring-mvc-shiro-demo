package com.frank.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
			resultMap.put("message", "��¼�ɹ�");
			resultMap.put("back_url", "home");
		}catch (AccountException e) {
			resultMap.put("status", 500);
			resultMap.put("message", "�ʺŻ��������");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		return resultMap;
	}
	
	@RequestMapping(value="/unauthoriaed")
	public String Unauthoriaed() {
		return "unauthorized";
	}
	
	@RequestMapping(value="/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/user/list")
	public String UserList(Model model) {
		return "UserList";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:login";
	}
}
