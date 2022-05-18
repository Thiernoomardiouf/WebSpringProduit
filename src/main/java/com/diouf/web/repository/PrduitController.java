package com.diouf.web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diouf.web.model.Produit;
import com.diouf.web.service.ProuitService;

import lombok.Data;

@Data
@Controller
public class PrduitController {
	@Autowired   
	ProuitService produitService;
	 
	@GetMapping("/")
	public String home(Model model) {
		Iterable<Produit> listeProduit = produitService.getAllProduit();
		model.addAttribute("produits", listeProduit); 
		return "index";  
		
	}
	
	@GetMapping("/createProduit")  
	public String createProduit(Model model) {
		Produit p = new Produit();
		model.addAttribute("produit", p);
		return "formNew";
	}
	
	@PostMapping("/saveProduit")
	public ModelAndView ajoutProduit(@ModelAttribute Produit produit) {
		produitService.saveProduit(produit);
		return new  ModelAndView("redirect:/");
	}
	
	@RequestMapping("/deleteProduit/{id}")
	public ModelAndView deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteproduit(id);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/updateProduit/{id}") 
	public String updateProduit(@PathVariable("id") Long id, Model model) {
		Produit p = produitService.getProduit(id);
		model.addAttribute("produit", p);
		
		return "formUpdate";
		
	}

}
