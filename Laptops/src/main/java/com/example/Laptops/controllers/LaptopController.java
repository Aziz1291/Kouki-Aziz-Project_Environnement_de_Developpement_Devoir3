package com.example.Laptops.controllers;

import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Laptops.service.LaptopService;

import jakarta.validation.Valid;

import com.example.Laptops.entities.Laptop;
import com.example.Laptops.entities.Model;  

@Controller
public class LaptopController { 
 @Autowired 
 LaptopService laptopService; 
 
  @RequestMapping("/listeLaptops") 
 public String listeLaptops(ModelMap modelMap,
		 @RequestParam (name="page",defaultValue = "0") int page, 
		 @RequestParam (name="size", defaultValue = "8") int size) 
 { 
	   Page<Laptop> laps = laptopService.getAllLaptopsParPage(page, size); 
	   modelMap.addAttribute("laptops", laps); 
	   modelMap.addAttribute("pages", new int[laps.getTotalPages()]);  
	   modelMap.addAttribute("currentPage", page);
	   modelMap.addAttribute("size", size);
  return "listeLaptops";  
 } 
   @RequestMapping("/supprimerLaptop") 
   public String supprimerLaptop(@RequestParam("id") Long id, 
   ModelMap modelMap, 
   @RequestParam (name="page",defaultValue = "0") int page, 
   @RequestParam (name="size", defaultValue = "8") int size) 
   { 
   laptopService.deleteLaptopById(id);
   Page<Laptop> laps = laptopService.getAllLaptopsParPage(page, size); 
		    
		   modelMap.addAttribute("laptops", laps);   
		   modelMap.addAttribute("pages", new int[laps.getTotalPages()]);  
		   modelMap.addAttribute("currentPage", page);  
		   modelMap.addAttribute("size", size);  
		   return "listeLaptops"; 
   }
   
   @RequestMapping("/showCreate") 
   public String showCreate(ModelMap modelMap) 
   { 
	List<Model> mods = laptopService.getAllModels();
    modelMap.addAttribute("laptop", new Laptop()); 
    modelMap.addAttribute("mode", "new");
    modelMap.addAttribute("models", mods);
    return "formLaptop"; 
    } 
  
   @RequestMapping("/saveLaptop") 
   public String saveLaptop(@Valid Laptop laptop, 
   BindingResult bindingResult,
   @RequestParam (name="page",defaultValue = "0") int page, 
   @RequestParam (name="size", defaultValue = "8") int size)
   { 
	   int currentPage;
	   boolean isNew=false;
   if (bindingResult.hasErrors()) return "formLaptop";   
   if (laptop.getIdLaptop()==null) isNew=true;
   laptopService.saveLaptop(laptop);
   
   if(isNew)
   {
	   Page<Laptop> laps = laptopService.getAllLaptopsParPage(page, size); 
	   currentPage = laps.getTotalPages()-1; 
	  } 
	  else //modif 
	  currentPage=page;
   
   //return "formLaptop";
   return ("redirect:/listeLaptops?page="+currentPage+"&size="+size);
   }
   @RequestMapping("/formLaptop") 
   public String editerLaptop(@RequestParam("id") Long id,ModelMap modelMap,
		   
		   @RequestParam (name="page",defaultValue = "0") int page, 
		   @RequestParam (name="size", defaultValue = "8") int size)
   { 
	   List<Model> mods = laptopService.getAllModels();
    Laptop l=   laptopService.getLaptop(id); 
    modelMap.addAttribute("laptop", l); 
    modelMap.addAttribute("mode", "edit");
    modelMap.addAttribute("models", mods);
    modelMap.addAttribute("page", page);  
	modelMap.addAttribute("size", size);
    return "formLaptop";  
   }
}
