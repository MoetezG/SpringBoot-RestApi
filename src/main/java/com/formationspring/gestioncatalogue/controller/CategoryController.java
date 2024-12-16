package com.formationspring.gestioncatalogue.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formationspring.gestioncatalogue.entities.Category;
import com.formationspring.gestioncatalogue.entities.produit;
import com.formationspring.gestioncatalogue.services.IServiceCategory;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CategoryController {

    private final IServiceCategory categoryService;


    @GetMapping("/category")
    public String getAllCategories(Model model)throws SQLException {
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "category";
    }

   
    @PostMapping("/searchCategory")
    public String searchCategories(@RequestParam(value = "mc", defaultValue = "") String mc, Model model)throws SQLException {
       List< Category> categories = categoryService.findByNom(mc);
        model.addAttribute("categories", categories);
        model.addAttribute("mc", mc);
        return "category";
    }


    @GetMapping("/ajoutCategory")
    public String showAddCategoryForm() {
        return "ajoutCategory";
    }


    @PostMapping("/ajoutCategory")
    public String addCategory(@RequestParam String name) throws SQLException{
        Category category = new Category(0, name, null);
        categoryService.addCategory(category);
        return "redirect:/category";
    }

  
    @GetMapping("/modifierCategory")
    public String showUpdateCategoryForm(@RequestParam int id, Model model)throws SQLException {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "modifierCategory";
    }

   
    @PostMapping("/modifierCategory")
    public String updateCategory(@RequestParam int id, @RequestParam String name)throws SQLException {
        Category category = new Category(id, name, null);
        categoryService.updateCategory(category);
        return "redirect:/category";
    }

    
    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam int id) throws SQLException {
    	Category cat = categoryService.getCategoryById(id);
    	List<produit> p = cat.getProduits();
    	for (produit prod :p) {
    		prod.setCategory(null);
    		
    	}
        categoryService.deleteCategory(id);
        
        return "redirect:/category";
    }
}
