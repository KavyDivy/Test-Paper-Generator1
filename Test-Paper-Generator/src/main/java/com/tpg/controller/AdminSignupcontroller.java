//package com.tpg.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tpg.entity.Admin;
//import com.tpg.service.AdminMyUserDetailsService;
//
//
//
//@CrossOrigin("http://localhost:3000")
//@RestController
//@RequestMapping("/api")
//public class AdminSignupcontroller {
//	
//	@Autowired
//	private AdminMyUserDetailsService userDetailsService;
//	
//	@RequestMapping({"/admin/signup"})
//	public String Register(@RequestBody Admin admin) {
//		return userDetailsService.register(admin);
//		
//		
//	}
//	
//
//}
