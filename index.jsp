<%-- 
    Document   : index
    Created on : 17/11/2022, 6:29:22 p. m.
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Style_nuevo.css" rel="stylesheet" type="text/css"/>
        <link href="Style_inventario.css" rel="stylesheet" type="text/css"/>
        <title>Almacen</title>
    </head>
    <body>
                <section class="form-register2">
                    <center><h1>Tabla de Articulos<hr></h1></center>
                    <br />
                    <table border="5" width="100%">
            <thead>
                <tr>
                    <th><h1>Codigo</h1></th>
                    <th><h1>Nombre</h1></th>
                    <th><h1>Precio</h1></th>
                    <th><h1>Existencia</h1></th>
                    <th><h1>Modificar</h1></th>
                    <th><h1>Eliminar</h1></th>
                    <th><h1>Vender</h1></th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="articulo" items="${lista}" >
                    
                    <tr>
                        <td><c:out value="${articulo.codigo}" /></td>
                        <td><c:out value="${articulo.nombre}" /></td>
                        <td><c:out value="${articulo.precio}" /></td>
                        <td><c:out value="${articulo.existencia}" /></td>
                        <td><a href="ArticulosController?accion=modificar&id=<c:out value="${articulo.id}" />">Modificar</td>
                        <td><a href="ArticulosController?accion=eliminar&id=<c:out value="${articulo.id}" />">Eliminar</td>
                        <td><a href="ArticulosController?accion=vender&id=<c:out value="${articulo.id}" />">Vender</td>
                    </tr>
                    
                </c:forEach>
                    
            </tbody>
        </table>
                    <br />
                   <a href="index.html" class="buttonvolverinven" type="submit" >Volver</a> 
                </section>
        
        
    </body>
</html>
