<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
        <html>

        <head>
            <title>Product Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: black">
                    <div>
                        <a href="#" class="navbar-brand"> Stock Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Products</a></li>
                    </ul>
                </nav>
            </header>
            <br>     
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${produit != null}">
                            <form action="update" method="post">
                           
                        </c:if>
                        
                        <c:if test="${produit == null}">
                            <form action="insert" method="post">
                            
                        </c:if>
                      

                        <caption>
                            <h2>
                                <c:if test="${produit != null}">
                                    Edit product
                                </c:if>
                                <c:if test="${produit == null}">
                                    Add New product
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${produit != null}">
                            <input type="hidden" name="id" value="<c:out value='${produit.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>product Name</label> <input type="text" value="<c:out value='${produit.name}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Product Descreption</label> <input type="text" value="<c:out value='${produit.descreption}' />" class="form-control" name="descreption">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Product Quantity</label> <input type="text" value="<c:out value='${produit.quantity}' />" class="form-control" name="quantity">
                        </fieldset>
                 <fieldset class="form-group">
    <label for="category">Product Category</label>
  <!--<input type="text" value="<c:out value='${product.category}' />" class="form-control" name="category" id="category">-->

   <select class="form-select mt-2" aria-label="Select category" name="category" id="category">
    <option value="" ${empty produit.category ? 'selected' : ''}>Choose a category</option>
    <option value="1" ${produit.category == '1' ? 'selected' : ''}>Maison</option>
    <option value="2" ${produit.category == '2' ? 'selected' : ''}>Electronique</option>
    <option value="3" ${produit.category == '3' ? 'selected' : ''}>Beauté</option>
    <option value="4" ${produit.category == '4' ? 'selected' : ''}>Vêtements</option>
    <option value="5" ${produit.category == '5' ? 'selected' : ''}>Alimentation</option>
</select>
</fieldset>
                    <fieldset class="form-group">
                            <label>Product Price</label> <input type="text" value="<c:out value='${produit.price}' />" class="form-control" name="price">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>