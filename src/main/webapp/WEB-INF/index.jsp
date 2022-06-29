<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Paulino Rubio</title>
</head>
<body>
<h1>Hola <c:out value="${nombres}"></c:out> <c:out value="${apellidos}"></c:out> </h1>
<p>Edad: <c:out value="${edad }"></c:out> </p>
<p>Correo: <c:out value="${correo }"></c:out> </p>
<p>Telefono: <c:out value="${telefono }"></c:out> </p>
<p>Direccion: <c:out value="${direccion }"></c:out> </p>
<br>
<p><c:out value="${usuario.nombre} ${usuario.apellido}"></c:out></p>
</body>
</html>
