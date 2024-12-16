package com.formationspring.gestioncatalogue.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formationspring.gestioncatalogue.entities.produit;
import com.formationspring.gestioncatalogue.repository.ProduitRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceProduit implements IServiceProduit {
//	@Autowired in case no constructor
	
	private ProduitRepository pr;
	
	@Override
	public void addProduit(produit p) throws SQLException{
		pr.save(p);
	}

	@Override
	public List<produit> getAllProducts()throws SQLException {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public produit getProduitByName(String nom)throws SQLException {
		// TODO Auto-generated method stub
		return pr.findByNomContains(nom);
	}

	

	@Override
	public produit getProduitById(int id) throws SQLException{
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public void deleteProduct(int id)throws SQLException {
		pr.deleteById(id);
		
	}

	@Override
	public void updateProduit(produit p) throws SQLException{
		pr.save(p);
	}



}
