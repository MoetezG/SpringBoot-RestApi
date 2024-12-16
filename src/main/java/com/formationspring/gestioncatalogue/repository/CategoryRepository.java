package com.formationspring.gestioncatalogue.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formationspring.gestioncatalogue.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public List<Category> findByNameContains(String mc);

}
