package com.example.Laptops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.Laptops.entities.Laptop;
import com.example.Laptops.entities.Model;
import com.example.Laptops.repos.LaptopRepository;
import com.example.Laptops.repos.ModelRepository;
@Service
public class LaptopServiceImpl implements LaptopService{
	@Autowired
	LaptopRepository laptopRepository;
	
	@Autowired 
	 ModelRepository modelRepository;

	@Override
	public Laptop saveLaptop(Laptop l) {
		return laptopRepository.save(l);
	}

	@Override
	public Laptop updateLaptop(Laptop l) {
		return laptopRepository.save(l);
	}

	@Override
	public void deleteLaptop(Laptop l) {
		laptopRepository.delete(l);
		
	}

	@Override
	public void deleteLaptopById(Long id) {
		laptopRepository.deleteById(id);
		
	}

	@Override
	public Laptop getLaptop(Long id) {
		return laptopRepository.findById(id).get();
	}

	@Override
	public List<Laptop> getAllLaptops() {
		return laptopRepository.findAll();
	}
	@Override 
	public Page<Laptop> getAllLaptopsParPage(int page, int size) { 
	return laptopRepository.findAll(PageRequest.of(page, size)); 
	}

	@Override
	public List<Laptop> findByBrandLaptop(String brand) {
		return laptopRepository.findByBrandLaptop(brand);
	}

	@Override
	public List<Laptop> findByBrandLaptopContains(String brand) {
		return laptopRepository.findByBrandLaptopContains(brand);
	}

	@Override
	public List<Laptop> findByBrandPrix(String brand, Double prix) {
		return laptopRepository.findByBrandPrix(brand, prix);
	}

	@Override
	public List<Laptop> findByModel(Model model) {
		return laptopRepository.findByModel(model);
	}

	@Override
	public List<Laptop> findByModelIdModel(Long id) {
		return laptopRepository.findByModelIdModel(id);
	}

	@Override
	public List<Laptop> findByOrderByBrandLaptopAsc() {
		return laptopRepository.findByOrderByBrandLaptopAsc();
	}

	@Override
	public List<Laptop> trierLaptopsBrandPrix() {
		return laptopRepository.trierLaptopsBrandPrix();
	}
	 
	@Override 
	 public List<Model> getAllModels() { 
	  return modelRepository.findAll(); 
	 }

}
