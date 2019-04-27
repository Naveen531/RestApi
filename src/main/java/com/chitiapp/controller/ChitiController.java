package com.chitiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chitiapp.model.ChitiDetails;
import com.chitiapp.service.UserService;

@RestController
public class ChitiController {
	
	@Autowired
	UserService us;
	
	
	@GetMapping("/getChitiMembers")
	public  ResponseEntity<?> getChitiMembers(){
		
		
		return null;
		
	}
	
	@PostMapping("/addChiti")
	public  ResponseEntity<?> addChiti(@RequestBody ChitiDetails chitiDetails){
		System.out.println(chitiDetails.toString());
		//System.out.println(chitiDetails.get.size());
		us.save(chitiDetails);
		return new ResponseEntity<ChitiDetails>(chitiDetails, 
	    		HttpStatus.OK);
		
	}

}
