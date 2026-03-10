package com.example.Laptops.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.Laptops.entities.Laptop;
import com.example.Laptops.entities.Model;

public interface LaptopService {
	 Laptop saveLaptop(Laptop l); 
	 Laptop updateLaptop(Laptop l); 
	 void deleteLaptop(Laptop l); 
	 void deleteLaptopById(Long id); 
	 Laptop getLaptop(Long id); 
	 List<Laptop> getAllLaptops();
	 Page<Laptop> getAllLaptopsParPage(int page, int size);
	 
	 List<Laptop> findByBrandLaptop(String brand);
	 List<Laptop> findByBrandLaptopContains(String brand);
	 List<Laptop> findByBrandPrix(String brand, Double prix);
	 List<Laptop> findByModel(Model model);
	 List<Laptop> findByModelIdModel(Long id);
	 List<Laptop> findByOrderByBrandLaptopAsc();
	 List<Laptop> trierLaptopsBrandPrix();
	 List<Model> getAllModels();
}