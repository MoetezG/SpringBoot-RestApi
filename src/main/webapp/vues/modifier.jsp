<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Modify Product</title>
</head>
<body>
    <div class='container m-3'>
        <form action="modifier" method="post">
            <input type="hidden" name="idProduit" value=${product.idproduit}>
            <div class="form-group">
                <label for="nom">Product Name</label>
                <input type="text" class="form-control" id="nom" name="nom" value=${product.nom} required>
            </div>
            <div class="form-group">
                <label for="prix">Price</label>
                <input type="number" step="0.01" class="form-control" id="prix" name="prix" value=${product.prix} required>
            </div>
            <div class="form-group">
                <label for="quantite">Quantité</label>
                <input type="number" class="form-control" id="quantite" name="quantite" value=${product.quantite} required>
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
            <button type="submit" class="btn btn-primary">Update Product</button>
            
        </form>
    </div>
</body>
</html>
