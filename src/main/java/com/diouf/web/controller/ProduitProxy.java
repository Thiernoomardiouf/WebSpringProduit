package com.diouf.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.diouf.web.CustumProperties;
import com.diouf.web.model.Produit;

import lombok.extern.slf4j.Slf4j;

@Component
public class ProduitProxy {
	
	@Autowired
	private CustumProperties props;
	
	public Iterable<Produit> getProduits(){
		
		String baseApiurl=props.getApiUrl();
		String getProduitUrl= baseApiurl + "/produit";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Produit>> reponse = restTemplate.exchange(
				getProduitUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Iterable<Produit>>() {}
				);
		
		return reponse.getBody();
		
	}
	
    public Produit getProduit(Long id) {
    	String baseApiUrl = props.getApiUrl();
    	String getProduitUrl = baseApiUrl + "/produit/" + id;
    	
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<Produit> reponse = restTemplate.exchange(
    			getProduitUrl,
    			HttpMethod.GET,
    			null,
    			Produit.class);
    	
    	return reponse.getBody();
    }
    
    public Produit createProduit(Produit p) {
    	String baseApiUrl = props.getApiUrl();
    	String createProduitUrl = baseApiUrl + "/produit";
    	
    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<Produit> request = new HttpEntity<Produit>(p);
    	ResponseEntity<Produit> reponse = restTemplate.exchange(
    			createProduitUrl, 
    			HttpMethod.POST,
    			request, 
    			Produit.class);
    	
    	return reponse.getBody();
    }
    
    public Produit updateProdui(Produit p) {
    	String baseurl = props.getApiUrl();
    	String updateUrl = baseurl + "/produit/" + p.getId();
    	
    	RestTemplate restTemplate = new RestTemplate();
    	HttpEntity<Produit> request = new HttpEntity<Produit>(p);
    	ResponseEntity<Produit> reponse = restTemplate.exchange(
    			updateUrl, 
    			HttpMethod.PUT,
    			request,
    			Produit.class);
    	
    	return reponse.getBody();
    }
    
    public void deleteProduit(Long id) {
    	String baseurl = props.getApiUrl();
    	String updateUrl = baseurl + "/produit/" + id ;
    	
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<Void> reponse = restTemplate.exchange(
    			updateUrl, 
    			HttpMethod.DELETE,
    			null,
    			void.class);
    }

}
