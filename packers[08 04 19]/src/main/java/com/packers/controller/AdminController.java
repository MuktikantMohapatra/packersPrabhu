package com.packers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/admin/dashBoard")
	public String showAdminDashBoard() {
		return "adminDashBoard";
	}
}
