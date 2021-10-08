<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col">
        <div class="card">
            <div class="card-header">
                Product List
            </div>
            <div class="row mt-3">
                <div class="col">
                    <a href="/product?action=create" class="btn btn-primary float-start">Create New Product</a>
                </div>
                <div class="col">
                    <form>
                        <div class="row">
                            <div class="col">
                            </div>
                            <div class="col">
                                <input type="text" class="form-control" placeholder="Search" name="q">
                            </div>
                            <div class="col">
                                <input type="submit" value="Search" class="btn btn-outline-success">
                            </div>
                        </div>
                    </form>
                </div>

            </div>
            <ul class="list-group list-group-flush">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Color</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Description</th>
                        <th scope="col">Category</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${productList}" var="product">
                        <tr>
                            <th scope="row">${product.id}</th>
                            <td>${product.name}</td>
                            <td>${product.prince}</td>
                            <td>${product.color}</td>
                            <td>${product.quantity}</td>
                            <td>${product.description}</td>
                            <td>${product.categoryName}</td>
                            <td><a href="/product?action=edit&id=${product.id}" class="btn btn-primary">Edit</a>
                                <a href="/product?action=delete&id=${product.id}" class="btn btn-outline-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </ul>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ"
        crossorigin="anonymous"></script>
</body>
</html>
