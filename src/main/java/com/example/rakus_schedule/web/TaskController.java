package com.example.rakus_schedule.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TaskController {

	@RequestMapping
	public String index() {
		return "top";
	}
		
	
}
