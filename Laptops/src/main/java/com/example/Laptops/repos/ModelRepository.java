package com.example.Laptops.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Laptops.entities.Model; 
 
 
public interface ModelRepository extends JpaRepository<Model, Long> 
{ 
 
}
