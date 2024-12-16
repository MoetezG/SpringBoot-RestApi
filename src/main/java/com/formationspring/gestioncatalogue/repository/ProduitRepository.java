package com.formationspring.gestioncatalogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formationspring.gestioncatalogue.entities.produit;

public interface ProduitRepository extends JpaRepository<produit, Integer> {
	public produit findByNomContains(String mc);
	
	@Query("select p from produit p where p.nom like %:n%")
	public List<produit> SearchByName(@Param("n") String mc);
}
