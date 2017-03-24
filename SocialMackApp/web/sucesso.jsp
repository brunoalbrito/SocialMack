<%-- 
    Document   : sucesso
    Created on : 09/03/2017, 10:56:50
    Author     : 1147106
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
    </head>
    <body>
        <h1><a href="index.jsp">SUCESSO!</a></h1>
        <c:out value="${user}"></c:out></br>
        <a style="text-decoration: none;" href="editar.jsp"><button type="hidden" name="ctrl" value="Listar"/>Alterar</a>
        <a style="text-decoration: none;" href="FrontController?ctrl=ListarPalestra"><button type="hidden" name="ctrl" value="Listar Palestras"/>Listar Palestras</a>
    </body>
</html>
