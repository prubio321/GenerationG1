<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registro</title>
</head>
<body>
    <div>
        <!--pasar informacion desde la vista a una url(action) -->
        <!--method "get" es por default, los parametros se ven en la ruta -->
        <!--method "post" los parametros no se ven en la ruta, van ocultos -->
        <form action="/registro/usuario" method="post">
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="gato">
            <br> <!--salto de linea -->
            <label for="apellido">Apellido: </label>
            <input type="text" id="apellido" name="apellido">
            <br> <!--salto de linea -->
            <label for="edad">Edad: </label>
            <input type="text" id="edad" name="edad">
            <br> <!--salto de linea -->
            <!--submit para el envio de informacion -->
            <input type="submit" value="Registrar">
            <input type="button" value="Enviar">

        </form>
    </div>
</body>
</html>
