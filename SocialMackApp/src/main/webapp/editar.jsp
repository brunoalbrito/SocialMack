<%-- 
    Document   : newjspindex
    Created on : 09/03/2017, 10:56:10
    Author     : 1147106
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <p>
                <label for="name">Nome:</label><br>
                <input type="text" id="name" name="name" value="${participante.nome}"/>
            </p>

            <p>
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" value="${participante.email}"/>
            </p>

            <input type="hidden" name="ctrl" value="Alterar"/>
            <p>
                <input type="submit" value="Alterar"/>
            </p>
        </form>
    </body>
</html>
