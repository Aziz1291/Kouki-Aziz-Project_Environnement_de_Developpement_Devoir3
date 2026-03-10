package com.example.Laptops.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Laptops.entities.Laptop;
import com.example.Laptops.entities.Model;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
	
	List<Laptop> findByBrandLaptop(String brand);
	List<Laptop> findByBrandLaptopContains(String brand);
	
	@Query("select l from Laptop l where l.brandLaptop like %?1 and l.prixLaptop > ?2")
	List<Laptop> findByBrandPrix(String brand, Double prix);
	
	@Query("select l from Laptop l where l.model = ?1")
	List<Laptop> findByModel(Model model);
	
	List<Laptop> findByModelIdModel(Long id);
	
	List<Laptop> findByOrderByBrandLaptopAsc();
	
	@Query("select l from Laptop l order by l.brandLaptop ASC, l.prixLaptop DESC")
	List<Laptop> trierLaptopsBrandPrix();

}
