<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>//capturar y pasar un objeto entero
<html>
<head>
    <title>Registro</title>
</head>
<body>
<div>
    <c:if test="${msgError!=null}">
        <c:out value="${msgError}"></c:out>
    </c:if>
    <%--@elvariable id="usuario" type="java"--%>
    <form:form action="/registro/usuario" method="post" modelAttribute="usuario">

        <form:label path="nombre">Nombre:</form:label>
        <form:input path="nombre"/>
        <br>
        <form:label path="apellido">Apellido:</form:label>
        <form:input path="apellido"/>
        <br>
        <form:label path="edad">Edad:</form:label>
        <form:input type="number" path="edad"/>
        <br>
        <form:label path="password">Password:</form:label>
        <form:input type="password" path="password"/>
        <input type="submit" value="Registrar">

    </form:form>
    
</div>
</body>
</html>
