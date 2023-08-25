package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.models;
import com.example.demo.service.service;

@RestController
public class control {
	@Autowired
	public service hserv;
	@PostMapping("/postmodel")
	public String postmodel(@RequestBody models p) {
		hserv.savemodel(p);
		return"datasaved";
	}
	@GetMapping("/getmodel")
	public List<models>getmodelInfo(){
		return hserv.getsundar();
	}
	@PutMapping("/putmodel")
	public models updatemodelInfo(@RequestBody models ve) {
		return hserv.updatesundar(ve);
	}
	@DeleteMapping("/deletemodel/{id}")
	public String removemodel(@PathVariable("id") int hid)
	{
		hserv.deletesundar(hid);
		return"Hotel Id"+hid+"is deleted";
	}
	@DeleteMapping("/byReqParm")
	public String removeByRequestPam(@RequestParam("id") int id)
	{
		hserv.deletesundar(id);
		return"Hotel with Id"+id+ "is deleted";
	}
	@DeleteMapping("/deletemsundarif/{id}")
	public ResponseEntity<String> deleteMatrix(@PathVariable int id){
		boolean deleted = hserv.deletesundar(id);
		if(deleted) {
			return ResponseEntity.ok("model with ID "+id+" deleted successfully");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("model with ID "+id+" not found");
		}
	}
	//getUserById
		@GetMapping("users/{userId}")
		public ResponseEntity<?> getUserById(@PathVariable int userId)
		{
	      Optional<models> model = hserv.getuserById(userId);
			if(model != null) {
				return ResponseEntity.ok(model);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
		}
	
		//sorting
		@GetMapping("/sortAsc/{name}")
		public List<models> sortAsc(@PathVariable("name") String name)
		{
			return hserv.sortByAsc(name);
		}
		@GetMapping("/sortDesc/{name}")
		public List<models> sortDesc(@PathVariable("name") String name)
		{
			return hserv.sortByDesc(name);
		}
		//pagination
		@GetMapping("/pagination/{number}/{size}")
		public List<models> pagination(@PathVariable("number") int number,@PathVariable("size") int size)
		{
			return hserv.pagination(number, size);
		}
//paginationAndSorting
		@GetMapping("/paginationAndSorting/{number}/{size}/{name}")
		public List<models> paginationAndSorting(@PathVariable("number")int number,@PathVariable("size")int size,@PathVariable("name") String name )
		{
			return hserv.paginationAndSorting(number, size, name);
		}
}
