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
        <title>Cadastro</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <p>
                <label for="name">Nome:</label><br>
                <input type="text" id="name" name="name"/>
            </p>

            <p>
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email"/>
            </p>

            <input type="hidden" name="ctrl" value="Cadastro"/>
            <p>
                <input type="submit" value="Cadastrar"/>
            </p>
        </form>
        
        
    </body>
</html>
