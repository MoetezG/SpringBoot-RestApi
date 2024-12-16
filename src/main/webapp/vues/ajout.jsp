<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un Produit</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h4>Ajouter un Produit</h4>
        </div>
        <div class="card-body">
            <form action="ajout" method="post">
                <!-- Product Name -->
                <div class="mb-3">
                    <label for="nom" class="form-label">Nom du Produit</label>
                    <input type="text" id="nom" name="nom" class="form-control" placeholder="Entrez le nom" required>
                </div>
                <!-- Price -->
                <div class="mb-3">
                    <label for="prix" class="form-label">Prix</label>
                    <input type="number" id="prix" name="prix" class="form-control" step="0.01" placeholder="Entrez le prix" min="0" required>
                </div>
                <!-- Quantity -->
                <div class="mb-3">
                    <label for="quantite" class="form-label">Quantité</label>
                    <input type="number" id="quantite" name="quantite" class="form-control" placeholder="Quantité" min="1" required>
                </div>
                <!-- Category -->
                <div class="mb-3">
                    <label for="category" class="form-label">Catégorie</label>
                    <select id="category" name="categorieId" class="form-control" >
                        <option value="">Sélectionnez une catégorie</option>
                        <c:forEach items="${category}"  var="c" >
                            <option  value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <!-- Submit Button -->
                <button type="submit" class="btn btn-success">Ajouter</button>
                <a href="/product" class="btn btn-secondary">Annuler</a>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

