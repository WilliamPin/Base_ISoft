<%-- 
    Document   : modificar
    Created on : 17/11/2022, 6:29:44 p. m.
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style_nuevo.css" rel="stylesheet" type="text/css"/>
        <link href="misEstilos.css" rel="stylesheet" type="text/css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <title>Modificar</title>
    </head>
    <body>
        
      
        <form action="ArticulosController?accion=actualizar" method="POST" autocomplete="off">
            
            <section class="form-register">
                <input id="id" name="id" type="hidden" value="<c:out value="${articulo.id}" />" />
                <h4>Modificar Articulo</h4>
                <h5>Codigo:</h5><input class="controls" id="codigo" name="codigo" type="text" value="<c:out value="${articulo.codigo}" />" />
                <h5>Nombre:</h5><input class="controls" id="nombre" name="nombre" type="text" value="<c:out value="${articulo.nombre}" />" />
                <h5>Precio:</h5><input class="controls" id="precio" name="precio" type="text" value="<c:out value="${articulo.precio}" />" />
                <h5>Existencia:</h5><input class="controls" id="existencia" name="existencia" type="text" value="<c:out value="${articulo.existencia}" />" />
                <input id="guardar" name="guardar" class="button" type="submit" value="Modificar">
                <a href="ArticulosController" class="buttonvolver" type="submit" >Volver</a>
                
            </section>

        </form>
    </body>
</html>
