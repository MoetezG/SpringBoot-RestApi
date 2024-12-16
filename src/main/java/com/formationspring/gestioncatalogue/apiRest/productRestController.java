package com.formationspring.gestioncatalogue.apiRest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formationspring.gestioncatalogue.entities.Category;
import com.formationspring.gestioncatalogue.entities.produit;
import com.formationspring.gestioncatalogue.services.IServiceCategory;
import com.formationspring.gestioncatalogue.services.IServiceProduit;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@CrossOrigin
//@RequestMapping("api/controller")
public class productRestController 
{
	private IServiceProduit sp;
	private IServiceCategory sc;
	@GetMapping("/produits")
	public List<produit> getAllProducts()throws SQLException {
        return sp.getAllProducts();
    }
	
	@GetMapping("/produits/{id}")
	public produit getProductById(@PathVariable int id )throws SQLException{
		return sp.getProduitById(id);
	}
	
	@GetMapping("/produit/{mc}")
	public produit searchProducts(@PathVariable String mc )throws SQLException {
		return sp.getProduitByName(mc);
        
    }	
	
	@DeleteMapping("/produit/{id}")
	public void deleteById(@PathVariable int id) throws SQLException{
		sp.deleteProduct(id);
	}
	@PostMapping("/produit")
	public void addProduit (@RequestBody produit produit  ) throws SQLException {
		
        sp.addProduit(produit);
        		
		
	}
    
	
	
}
