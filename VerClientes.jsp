<%-- 
    Document   : VerClientes
    Created on : 18/11/2022, 11:17:08 a. m.
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
                    <center><h1>Tabla de Cliente<hr></h1></center>
                    <br />
                    <table border="2" width="100%">
            <thead>
                <tr>
                    <th><h1>Nombre</h1></th>
                    <th><h1>Telefono</h1></th>
                    <th><h1>Correo</h1></th>
                    <th><h1>Dirección</h1></th>
                    <th><h1>Modificar</h1></th>
                    <th><h1>Eliminar</h1></th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="cliente" items="${lista}" >
                    
                    <tr>
                        <td><c:out value="${cliente.nombre}" /></td>
                        <td><c:out value="${cliente.telefono}" /></td>
                        <td><c:out value="${cliente.correo}" /></td>
                        <td><c:out value="${cliente.direccion}" /></td>
                        <td><a href="ClientesController?accion=modificar&id=<c:out value="${cliente.id}" />">Modificar</td>
                        <td><a href="ClientesController?accion=eliminar&id=<c:out value="${cliente.id}" />">Eliminar</td>
                        <td><a href="ClientesController?accion=seleccionar&id=<c:out value="${cliente.id}" />">Selecionar</td>
                        
                       
                    </tr>
                    
                </c:forEach>
                    
            </tbody>
        </table>
                    <br />
                   <a href="index.html" class="buttonvolverinven" type="submit" >Volver</a> 
                </section>
    </body>
</html>
