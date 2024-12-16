package com.formationspring.gestioncatalogue.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class produit {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private int idproduit;
    private String nom;
    private double prix;
    private int quantite;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;



    public Category getCategory() {
    return category;
    }

    public void setCategory(Category category) {
    this.category = category;
    }
}
