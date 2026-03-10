package com.example.Laptops.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Laptop {
	@Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private Long idLaptop;
	@NotNull 
	 @Size (min = 4,max = 15)
	 private String brandLaptop;
	@Min(value = 10) 
    @Max(value = 10000)
	 private Double prixLaptop;
	@NotNull 
	 @Size (min = 6,max = 255)
	 private String caracteristiquesLaptop;
	 @Temporal(TemporalType.DATE) 
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	 @PastOrPresent
	 private Date dateCreation;
	 
	 @ManyToOne
	 private Model model;
	 public Laptop() {
		super();
	 }
	 public Laptop(String brandLaptop, Double prixLaptop, String caracteristiquesLaptop, Date dateCreation) {
		super();
		this.brandLaptop = brandLaptop;
		this.prixLaptop = prixLaptop;
		this.caracteristiquesLaptop = caracteristiquesLaptop;
		this.dateCreation = dateCreation;
	 }
	 public Long getIdLaptop() {
		 return idLaptop;
	 }
	 public void setIdLaptop(Long idLaptop) {
		 this.idLaptop = idLaptop;
	 }
	 public String getBrandLaptop() {
		 return brandLaptop;
	 }
	 public void setBrandLaptop(String brandLaptop) {
		 this.brandLaptop = brandLaptop;
	 }
	 public Double getPrixLaptop() {
		 return prixLaptop;
	 }
	 public void setPrixLaptop(Double prixLaptop) {
		 this.prixLaptop = prixLaptop;
	 }
	 public String getCaracteristiquesLaptop() {
		 return caracteristiquesLaptop;
	 }
	 public void setCaracteristiquesLaptop(String caracteristiquesLaptop) {
		 this.caracteristiquesLaptop = caracteristiquesLaptop;
	 }
	 public Date getDateCreation() {
		 return dateCreation;
	 }
	 public void setDateCreation(Date dateCreation) {
		 this.dateCreation = dateCreation;
	 }
	 public Model getModel() {
		 return model;
	 }
	 public void setModel(Model model) {
		 this.model = model;
	 }
	 @Override
	 public String toString() {
		return "Laptop [idLaptop=" + idLaptop + ", brandLaptop=" + brandLaptop + ", prixLaptop=" + prixLaptop
				+ ", caracteristiquesLaptop=" + caracteristiquesLaptop + ", dateCreation=" + dateCreation + "]";
	 }
	 
	 
}
