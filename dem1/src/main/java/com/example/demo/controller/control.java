
package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FuelStation;
import com.example.demo.service.sundar;

@RestController
public class control {

	
	@Autowired
	sundar fser;
	@PostMapping("/saveFuel")
	
	public FuelStation saveFuelStationDe(@RequestBody FuelStation pb)
	{
		return fser.saveDetails(pb);
	}
	
	@GetMapping("/getFuel")
	public List<FuelStation> getFuelStationDe()
	{
		return fser.getDetails();
	}
}