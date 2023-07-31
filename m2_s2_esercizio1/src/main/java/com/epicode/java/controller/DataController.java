package com.epicode.java.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {
	@GetMapping("/homepage")
	public @ResponseBody String getHomePage() {
		
		return "<h1>Esercizio primo giorno by nicostaffo</h1>";
	}
	@GetMapping("/profile")
	public @ResponseBody String getProfile(@RequestParam String name ) {
		
		return "Ciao " + name;
	}
	@GetMapping("/profile/{name}")
	public @ResponseBody String getHomePagePathParam(@PathVariable String name ) {
		
		return "Ciao " + name;
	}
	@GetMapping("/home/profile/{name}/{age}")
	public String getHomePageTymeleafParam1(
									Map<String, String> model, 
									@PathVariable String name, 
									@PathVariable String age) {
	
		model.put("fullname", name);
		model.put("myAge", age);
		return "template";
	}
}
