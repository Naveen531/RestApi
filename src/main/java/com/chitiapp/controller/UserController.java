package com.chitiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.chitiapp.model.CustomMessage;
import com.chitiapp.model.Users;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.chitiapp.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UserService us;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

@RequestMapping(value="/test",method=RequestMethod.GET)
public ResponseEntity<?> testing() {
	
	System.out.println("==============Came===========");
	//us.findUser("nave@gmail.com");
	
	 return new ResponseEntity<Users>(us.findUser("seshi@gmail.com"), 
	    		HttpStatus.OK);
	 //return ResponseEntity.ok("ok");

}
@RequestMapping(value = "/username", method = RequestMethod.GET)
@ResponseBody
public String currentUserName(Authentication authentication) {
    return authentication.getName();
}
@GetMapping("/validToken")
public ResponseEntity<?> validToken() {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentUserName = "";
	if (!(authentication instanceof AnonymousAuthenticationToken)) {
	     currentUserName = authentication.getName();
	}
	System.out.println("currentUserName:"+currentUserName);
    return new ResponseEntity<CustomMessage>(new CustomMessage("Valid Token",currentUserName), 
    		HttpStatus.OK);
    
}
@PostMapping("/sign-up")
public ResponseEntity<?> signUp(@RequestBody Users user) {
	System.out.println("======================");
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return new ResponseEntity<Users>(us.save(user), 
    		HttpStatus.OK);
    
}
}