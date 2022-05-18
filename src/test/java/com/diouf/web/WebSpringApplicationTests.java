package com.diouf.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.diouf.web.controller.ProduitProxy;
import com.diouf.web.model.Produit;

@SpringBootTest
class WebSpringApplicationTests {
	
	@Autowired
	ProduitProxy produitProxy;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testProduitsApi() {
		Iterable<Produit> listProduits = produitProxy.getProduits();
		for (Produit produit : listProduits) {
			System.out.println(produit);
		}
	}
	
	@Test
	void testProduitAi(){
		Produit produit = produitProxy.getProduit(1L);
		System.out.println(produit);
	}
	
	@Test
	void testCreateProduit() {
		Produit p = new Produit();
		p.setLibele("Portable P");
		p.setQuantite(78);
		Produit prod = produitProxy.createProduit(p);
		System.out.println(prod);
	}
	
	@Test
	void testUpdateProduit() {
		Produit pr = produitProxy.getProduit(3L);
		pr.setLibele("HP Faye");
		produitProxy.updateProdui(pr);
	}
	
	@Test
	void testDeleteProduit() {
		produitProxy.deleteProduit(25L);
	}

}
