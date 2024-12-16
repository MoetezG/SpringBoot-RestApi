<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une Catégorie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="card">
        <div class="card-header bg-success text-white">
            <h4>Ajouter une Catégorie</h4>
        </div>
        <div class="card-body">
            <form action="ajoutCategory" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Nom de la Catégorie</label>
                    <input type="text" id="name" name="name" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-success">Ajouter</button>
                <a href="category" class="btn btn-secondary">Annuler</a>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
