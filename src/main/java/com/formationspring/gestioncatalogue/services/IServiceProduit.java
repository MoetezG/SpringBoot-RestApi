package com.formationspring.gestioncatalogue.services;

import java.sql.SQLException;
import java.util.List;

import com.formationspring.gestioncatalogue.entities.produit;


public interface IServiceProduit  {
	void addProduit(produit p)throws SQLException;
	List <produit> getAllProducts()throws SQLException;
	produit getProduitByName(String nom)throws SQLException;
	produit getProduitById(int id)throws SQLException;
	void deleteProduct(int id)throws SQLException;
	void updateProduit(produit p)throws SQLException;
}
