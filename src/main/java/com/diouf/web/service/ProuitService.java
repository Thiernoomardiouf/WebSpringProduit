package com.diouf.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diouf.web.controller.ProduitProxy;
import com.diouf.web.model.Produit;

import lombok.Data;

@Data
@Service 
public class ProuitService {
	
	@Autowired
	ProduitProxy produitProxy;
	
	public Produit getProduit(Long id) {
		return produitProxy.getProduit(id);
	}
	
	public Iterable<Produit> getAllProduit(){
		return produitProxy.getProduits();
	}
	
	public void deleteproduit(Long id) {
		produitProxy.deleteProduit(id);
	}
	
	public Produit saveProduit(Produit p) {
		Produit saveProduit;
		if(p.getId()==null) {
			saveProduit=produitProxy.createProduit(p);
		}else {
			saveProduit=produitProxy.updateProdui(p);
		}
		
		return saveProduit;
	}

}
