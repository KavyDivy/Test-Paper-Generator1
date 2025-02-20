//package com.tpg.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tpg.entity.AuthenticationRequest;
//import com.tpg.entity.AuthenticationResponse;
//import com.tpg.security.JwtUtil;
//import com.tpg.service.AdminMyUserDetailsService;
//
//
//
//@CrossOrigin("http://localhost:3000")
//@RestController
//class AdminLoginController {
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private JwtUtil jwtTokenUtil;
//
//	@Autowired
//	private AdminMyUserDetailsService userDetailsService;
//
//
//
//	@GetMapping("/admin/loginuser/{token}")
//    public String getLoginUser(@PathVariable("token") String token){
//        return jwtTokenUtil.extractUsername(token);
//   }
//	
//
//	@RequestMapping(value = "/admin/authenticateeee", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
//			);
//		}
//		catch (BadCredentialsException e) {
//			throw new Exception("Incorrect username or password", e);
//		}
//
//
//		final UserDetails userDetails = userDetailsService
//				.loadUserByUsername(authenticationRequest.getUsername());
//
//		final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//		return ResponseEntity.ok(new AuthenticationResponse(jwt));
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////@RequestMapping({ "/hello" })
////public String firstPage() {
////	return "Hello World";
////}
////
//
//
////@RequestMapping({"/login" })
////public UserDetails findByUsername(@RequestBody Member member) {
////	return userDetailsService.loadUserByUsername(member.getUsername());
////}
////
////@RequestMapping({"/signup"})
////public String Register(@RequestBody Member member) {
////	return userDetailsService.register(member);
////	
////	
////}