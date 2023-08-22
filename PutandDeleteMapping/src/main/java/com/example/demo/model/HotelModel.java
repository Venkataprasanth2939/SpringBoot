package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hotelmodel")
public class HotelModel {
	@Id
private int hotelId;
private String hotelName;
private String address;
public int getHotelId() {
	return hotelId;
}
public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
