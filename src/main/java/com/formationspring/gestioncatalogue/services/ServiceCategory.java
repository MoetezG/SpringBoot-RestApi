package com.formationspring.gestioncatalogue.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formationspring.gestioncatalogue.entities.Category;
import com.formationspring.gestioncatalogue.repository.CategoryRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceCategory implements IServiceCategory{
	
	private CategoryRepository cr;
	
	@Override
	public void addCategory(Category c)throws SQLException {
		cr.save(c);
		
	}

	@Override
	public List<Category> getAllCategory() throws SQLException{
		return cr.findAll();
	}



	@Override
	public Category getCategoryById(int id) throws SQLException{
		return cr.findById(id).get();
	}

	@Override
	public void deleteCategory(int id)throws SQLException{
		
		cr.deleteById(id);
		}

	@Override
	public void updateCategory(Category c)throws SQLException {
		cr.save(c);
		
	}
	

	public List<Category> findByNom(String mc)throws SQLException {
		return cr.findByNameContains(mc);
	}

}
