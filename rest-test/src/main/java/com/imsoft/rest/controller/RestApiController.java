/**
*
*
* author : ME
*/

package com.imsoft.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imsoft.rest.repository.RestApiRepository;

@RestController
public class RestApiController {
	
	@Autowired
	RestApiRepository restApiRepository;
	
	@CrossOrigin //跨域請求
	@RequestMapping("/emp")
	public List hello() {
		System.out.println("emp#start");
		return restApiRepository.findAll();
		
		
	}
	@RequestMapping("emp/insert")
	public void insert() {
		System.out.println("insert#start");
	}
		
}
