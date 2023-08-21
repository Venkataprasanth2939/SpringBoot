
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.FuelStation;


public interface rep extends JpaRepository<FuelStation, Integer> {

}