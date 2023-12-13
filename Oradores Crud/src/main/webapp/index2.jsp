<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista de Oradores</title>
</head>
<body>
    <h1>Lista de Oradores</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Tema</th>
                <th>Fecha</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="orador" items="${listado}">
                <tr>
                    <td>${orador.id}</td>
                    <td>${orador.nombre}</td>
                    <td>${orador.apellido}</td>
                    <td>${orador.tema}</td>
                    <td>${orador.fecha}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
