package com.tpg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tpg.entity.AuthenticationRequest;
import com.tpg.entity.AuthenticationResponse;
import com.tpg.security.JwtUtil;
import com.tpg.service.CandidateMyuserDetailsService;


@CrossOrigin("http://localhost:3001")
@RestController
@RequestMapping
public class CandidateLoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private CandidateMyuserDetailsService userDetailsService;
	



	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest) {
	    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

	    if (userDetails == null) {
	        // User not found, return an error response
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Details");
	    }

	    // Authentication successful, return a success response
	    return ResponseEntity.ok("Login successful");
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}








