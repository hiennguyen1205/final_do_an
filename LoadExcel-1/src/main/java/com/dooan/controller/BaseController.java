package com.dooan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

	@RequestMapping("/login1")
	public String login1(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "login1";
	}

	@RequestMapping("/login2")
	public String login2(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "login2";
	}

	//them
	@RequestMapping("/login3")
	public String login3(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "login3";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/admin")
	
	public String admin1() {
		return "home";
	}

	@RequestMapping("/user")
	public String user() {
		return "home_user";
	}
	
	@RequestMapping("/staff")
	public String user1() {
		return "home_staff";
	}
	@RequestMapping("/403")
	public String accessDenied403() {
		return "403";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/userinfo")
	public String userinfo() {
		return "user";
	}
	
	@GetMapping("/admin/adminInfo")
	public String admininfo() {
		return "admin";
	}
	
	@RequestMapping("/admin/admin")
	
	public String admin() {
		return "home";
	}
	
	@RequestMapping("/taisan")
	public String taisan() {
		return "taisan";
	}
}