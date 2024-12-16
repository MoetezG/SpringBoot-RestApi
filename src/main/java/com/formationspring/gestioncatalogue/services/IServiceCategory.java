package com.formationspring.gestioncatalogue.services;

import java.sql.SQLException;
import java.util.List;

import com.formationspring.gestioncatalogue.entities.Category;

public interface IServiceCategory {
	void addCategory(Category c) throws SQLException;
	List <Category > getAllCategory()throws SQLException;
	Category getCategoryById(int id)throws SQLException;
	void deleteCategory(int id)throws SQLException;
	void updateCategory(Category c)throws SQLException;
	List<Category> findByNom(String mc) throws SQLException;
}
