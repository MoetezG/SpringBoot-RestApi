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
import com.formationspring.gestioncatalogue.services.IServiceProduit;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProduitController {

    private IServiceProduit sp;
    private IServiceCategory sc;

   
    @GetMapping("/product")
    public String getAllProducts(Model m)throws SQLException {
        List<produit> l = sp.getAllProducts();
        m.addAttribute("products", l);
        return "home";
    }

   
    @GetMapping("/search")
    public String searchProducts(@RequestParam(value = "mc", defaultValue = "") String mc, Model m) throws SQLException{
        produit l = sp.getProduitByName(mc);
        m.addAttribute("products", l);
        m.addAttribute("mc", mc);
        return "home";
    }

    
    @GetMapping("/ajout")
    public String showAddProductForm(Model m)throws SQLException {
        List<Category> category = sc.getAllCategory();
        m.addAttribute("category", category);          
        return "ajout";                              
    }

    
    @PostMapping("/ajout")
    public String addProduct(@RequestParam String nom, @RequestParam double prix, @RequestParam int quantite, @RequestParam int categorieId)throws SQLException {
    	Category category = sc.getCategoryById(categorieId);
        produit p =new produit(0, nom, prix, quantite, category);
        sp.addProduit(p);
        return "redirect:/product";
    }
    
    @GetMapping("/modifier")
    public String showUpProductForm(@RequestParam int id, Model m)throws SQLException {
    	produit p = sp.getProduitById(id);
        m.addAttribute("product", p);
        List<Category> category = sc.getAllCategory();
        m.addAttribute("category", category);
        return "modifier";
    }
    
    @PostMapping("/modifier")
    public String showEditProductForm(@RequestParam String nom, @RequestParam double prix, @RequestParam int quantite, @RequestParam int idProduit,@RequestParam int categorieId)throws SQLException {
    	Category category = sc.getCategoryById(categorieId);
    	produit p= new produit(idProduit, nom, prix, quantite, category);
        sp.updateProduit(p);
        return "redirect:/product";
    }

    

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id)throws SQLException {
        sp.deleteProduct(id);
        return "redirect:/product";
    }
}
