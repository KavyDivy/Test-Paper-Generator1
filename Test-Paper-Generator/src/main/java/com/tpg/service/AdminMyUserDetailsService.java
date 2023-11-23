//package com.tpg.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.tpg.entity.Admin;
//import com.tpg.repository.Adminrepository;
//import com.tpg.repository.CandidatesRepo;
//
//import java.util.ArrayList;
//
//@Service
//public class AdminMyUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	private Adminrepository repo;
//	
//	
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	UserDetails user = repo.loadByusername(username);
//    	if(user==null) {
//    		throw new UsernameNotFoundException("User not found");
//    	}
//        return user;
//    }
//   
//    public String register(Admin admin) {
//    	int response=repo.Register(admin);
//    	if(response>0) {
//    		return "success";
//    	}
//    	else if(response <0) {
//    		return "Account already exists with provided details";
//    	}
//    	else {
//    		return "failure";
//    	}
//    }
//    
//   
//   
//   
//    
//    
//}