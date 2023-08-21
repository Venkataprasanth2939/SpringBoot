package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FuelStation;
import com.example.demo.repository.rep;

@Service
public class sundar {
	@Autowired
	rep frepo;
	
	public FuelStation saveDetails(FuelStation f)
	{
		return frepo.save(f);
	}
	
	public List<FuelStation> getDetails()
	{
		return frepo.findAll();
	}
}