package com.example.demo.service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.HotelModel;
import com.example.demo.repository.HotelRepo;

@Service
public class HotelService {
@Autowired
public HotelRepo hrepo;
public String saveHotel(HotelModel h) {
	hrepo.save(h);
	return"Data saved";
}
public List<HotelModel>getHotel(){
	return hrepo.findAll();
}

public HotelModel updateHotel(HotelModel hm) {
	return hrepo.saveAndFlush(hm);
}
public boolean deleteHotelif(int hotelId) {
	if(hrepo.existsById(hotelId)) {
		hrepo.deleteById(hotelId);
		return true;
	}
	return false;
}
public void deleteHotel(int hotel_id) {
	System.out.println("deleted");
	hrepo.deleteById(hotel_id);
}
//getUserId
@GetMapping("/users/userId")

public Optional<HotelModel> getuserById(int userId)
{
	Optional<HotelModel> hotel = hrepo.findById(userId);
	if(hotel.isPresent()) {
		return hotel;
	}
	else
	{
		return null;
	}
}
}
