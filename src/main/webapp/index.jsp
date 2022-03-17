<%@page contentType = "text/html" pageEncoding="UTF-8" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hola Mundo EJB</title>
</head>
<body>
    <h2>Hola Mundo EJB</h2>
    <h3>${saludoUno}</h3>
    <h3>${saludoDos}</h3>

    <h3>Listado de productos:</h3>
    <ul>
        <c:forEach items="${listado}" var = "p">
            <li>${p.nombre}</li>
        </c:forEach>
    </ul>


</body>
</html>