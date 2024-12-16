package com.formationspring.gestioncatalogue.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category") 
public class Category {	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List< produit > produits = new ArrayList< >();

    public Category(String name){
    this.name=name;
    }
    public List< produit > getProduits() {
    	return produits;
    }

    public void setProduits(List< produit > produits) {
    this.produits = produits;
    }

    public void addProduit(produit produit) {
    produits.add(produit);
    produit.setCategory(this);
    }

    public void removeProduit(produit produit) {
    produits.remove(produit);
    produit.setCategory(null);
    }

   
}