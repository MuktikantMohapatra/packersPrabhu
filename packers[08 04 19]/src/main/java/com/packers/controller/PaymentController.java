package com.packers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PaymentController {
	@RequestMapping(value="pgRedirect",method=RequestMethod.POST)
	public String redirect() {
		return "pgRedirect";
	}
	
	@RequestMapping(value="pgResponse",method=RequestMethod.GET)
	public String response() {
		return "pgResponse";
}
}
