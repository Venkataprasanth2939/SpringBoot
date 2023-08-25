package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.models;

public interface repo extends JpaRepository<models, Integer>{

}
