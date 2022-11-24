<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style_nuevo.css" rel="stylesheet" type="text/css"/>
        <link href="misEstilos.css" rel="stylesheet" type="text/css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="Style_vender.css" rel="stylesheet" type="text/css"/>
        <link href="Style_inventario.css" rel="stylesheet" type="text/css"/>

        <title>Modificar</title>
    </head>
    <body>


        <form action="ArticulosController?accion=eliminar" method="POST" autocomplete="off">
            
            
            <section class="form-register3">
                <input id="id" name="id" type="hidden" value="<c:out value="${articulo.id}" />" />
                <center><h4>Caracteristicas del Articulo<hr></h4></center>     
                                <h1>Codigo: ${articulo.codigo}<br /><br /></h1>  
                                <h1>Nombre: ${articulo.nombre}<br /><br /></h1>
                                <h1>Precio: ${articulo.precio}<br /><br /></h1>
                                <h1>Existencia: ${articulo.existencia}<br /><br /></h1>
                                
                                <a href="ClientesController" class="buttonvender" type="submit">Siguiente

                                <a href="ArticulosController" class="buttonvender" type="submit" >Volver</a>
            </section>
        </form>
        
        
        
    </body>
</html>
