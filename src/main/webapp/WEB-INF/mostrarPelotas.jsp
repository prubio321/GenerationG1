<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>mostrarPelotas</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet">

</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Marca</th>
            <th scope="col">Material</th>
            <th scope="col">Color</th>
            <th scope="col">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="pelota" items="${listaPelotas}">
            <tr>
                <th scope="row">${pelota.id}</th>
                <td>${pelota.marca}</td>
                <td>${pelota.material}</td>
                <td>${pelota.color}</td>
                <td><a class="btn btn-warning" href="/pelota/editar/${pelota.id}" role="button">Editar</a></td>
                <td><a class="btn btn-danger" href="eliminar/${pelota.id}" role="button">Eliminar</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
></script>

</body>
</html>
