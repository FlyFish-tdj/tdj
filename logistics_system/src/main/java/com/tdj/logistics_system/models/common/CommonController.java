package com.tdj.logistics_system.models.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {
	@RequestMapping("/dashboard")
	public String dashboardpage() {
		return "index";
	}
	
	@RequestMapping("/403")
	public String errorPage403() {
		return "index";
	}
}
