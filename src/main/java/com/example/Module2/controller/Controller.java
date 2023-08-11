package com.example.Module2.controller;

import com.example.Module2.validate.Validate;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.Module2.service.ServiceStock;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stocks")
public class Controller {
	@Autowired
	private final ServiceStock service;
	@Autowired
	private Validate validate;
	@GetMapping("/getData")
	public ResponseEntity<?> callApi(@RequestParam String stock, @RequestHeader("Authorization") String authorizationHeader)  {
		System.out.println("TokenHeader : "+authorizationHeader);
		ResponseEntity<String> apiResponse=null;
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")){
			apiResponse = validate.validateToken(authorizationHeader);
		}else {
			return ResponseEntity.ok("Please! Provide Required Authorization Header with Valid Syntax");
		}
		System.out.println("Controller : "+ apiResponse.getBody());
		if (apiResponse.getBody().equals("true")){
			return ResponseEntity.ok(service.getAllData(stock));
		}
		return ResponseEntity.ok("Authorization Header OR Token Not Valid");
	}


}
