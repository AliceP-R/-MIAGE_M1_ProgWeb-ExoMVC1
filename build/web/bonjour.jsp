<%-- 
    Document   : bonjour
    Created on : 29 sept. 2015, 11:17:50
    Author     : alpottie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bonjour</title>
    </head>
    <body>
        <jsp:useBean id="utilisateur" scope="request" class="modeles.User"/>
        <h1> Bonjour <jsp:getProperty name="utilisateur" property="nom" /> <jsp:getProperty name="utilisateur" property="prenom" /></h1>
    </body>
</html>
