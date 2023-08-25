package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.models;
import com.example.demo.repository.repo;

@Service
public class service {
@Autowired
public repo hrepo;
public String savemodel(models m) {
	hrepo.save(m);
	return"datasaved";
}
//get mapping
public List<models>getsundar(){
	return hrepo.findAll();
}
//update mapping
public models updatesundar(models n) {
	return hrepo.saveAndFlush(n);
}
//delete mapping
public boolean deletesundar(int id) {
	hrepo.deleteById(id);
	return false;
}
@GetMapping("/users/userId")

public Optional<models> getuserById(int userId)
{
	Optional<models> model = hrepo.findById(userId);
	if(model.isPresent()) {
		return model;
	}
	else
	{
		return null;
	}
}
//sorting
public List<models> sortByAsc(String name)
{
	return hrepo.findAll(Sort.by(name).ascending());
}
//sorting
public List<models> sortByDesc(String name)
{
	return hrepo.findAll(Sort.by(name).descending());
}
//pagination
public List<models> pagination(int pageNu,int pageSize)
{
	Page<models> cont=hrepo.findAll(PageRequest.of(pageNu, pageSize));
	return cont.getContent();
}
//pagination and sorting
public List<models> paginationAndSorting(int pageNu,int pageSize,String name)
{
	Page<models> cont1=hrepo.findAll(PageRequest.of(pageNu, pageSize,Sort.by(name)));
	return cont1.getContent();
}
}

