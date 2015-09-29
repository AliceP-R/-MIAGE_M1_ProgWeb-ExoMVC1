<%-- 
    Document   : accueil
    Created on : 29 sept. 2015, 10:12:15
    Author     : alpottie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil : JSP Page</title>
    </head>
    <body>
        <form action="Servlet" method="POST">
            <input type="text" name="nom" placeholder="Nom"/>
            <input type="text" name="prenom" placeholder="Prenom"/>
            <input type="password" name="mdp" placeholder="Mot de passe"/>
            <input type="submit" name="envoi" value="Envoyer"/>
        </form>
    </body>
</html>
