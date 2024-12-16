<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion Produits</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background: linear-gradient(135deg, #b3cde0, #8ca6d9);
            font-family: 'Arial', sans-serif;
            font-size: 14px;
            margin-top: 30px;
        }
        .navbar {
            background: linear-gradient(90deg, #1d4b86, #6fa3d1);
        }
        .navbar a {
            color: white;
            font-weight: bold;
            margin: 0 15px;
            text-transform: uppercase;
        }
        .navbar a:hover {
            color: #ddd;
        }
        .card {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Gestion Catalogue</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="product">Produits</a> <!-- Link to product CRUD page -->
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="category">Catégories</a> <!-- Link to category CRUD page -->
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Unified Card with Search, Add Product Button, and Product Table -->
<div class="container">
    <div class="card">
        <div class="card-header">
            <h4>Gestion des Produits</h4>
        </div>
        <div class="card-body">
            <!-- Search Section -->
            <div class="form-inline d-flex justify-content-between align-items-center">
                <div class="search-container">
                    <form class="form-inline d-flex align-items-center" action="search">
                        <div class="form-group w-75 mb-2">
                            <label for="searchInput" class="sr-only">Mot Clé</label>
                            <input type="text" class="form-control form-control-sm" id="searchInput" placeholder="Rechercher par nom de produit" name="mc" value="${mc}">
                        </div>
                        <button type="submit" class="btn btn-primary">
                            <i class="fa-solid fa-magnifying-glass"></i> 
                        </button>
                    </form>
                </div>
                <div class="add-product-btn">
                    <a href="ajout">
                        <button class="btn btn-success">
                            <i class="fa-solid fa-plus-circle"></i> Ajouter un produit
                        </button>
                    </a>
                </div>
            </div>

            <!-- Table Section -->
            <div class="table-container">
                <table class="table table-sm table-hover">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nom</th>
                            <th scope="col">Prix</th>
                            <th scope="col">Quantité</th>
                            <th scope="col">Catégorie</th>
                            <th scope="col" colspan="2">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${products}" var="p">
                            <tr>
                                <td>${p.idproduit}</td>
                                <td>${p.nom}</td>
                                <td>${p.prix}</td>
                                <td>${p.quantite}</td>
                                <td>${p.category.name}</td>
                                <td class="d-flex justify-content-center">
                                    <form class="d-inline" action="modifier">
                                        <input type="hidden" name="id" value="${p.idproduit}">
                                        <button type="submit" class="btn btn-sm">
                                            <i class="fa-solid fa-pen-to-square"></i>
                                        </button>
                                    </form>
                                    <form class="d-inline ms-2" action='delete' method='post'>
                                        <button type="submit" class="btn btn-sm">
                                            <i class="fa-solid fa-trash"></i>
                                        </button>
                                        <input type="hidden" name="id" value="${p.idproduit}">
                                        <input type="hidden" name="mc" value="${mc}">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
