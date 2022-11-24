<%-- 
    Document   : ModificarClientes
    Created on : 18/11/2022, 11:17:23 a. m.
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
        
      
        <form action="ClientesController?accion=actualizar" method="POST" autocomplete="off">
            
            <section class="form-register">
                <input id="id" name="id" type="hidden" value="<c:out value="${cliente.id}" />" />
                <h4>Modificar Cliente</h4>
                <h5>Codigo:</h5><input class="controls" id="nombre" name="nombre" type="text" value="<c:out value="${cliente.nombre}" />" />
                <h5>Telefono:</h5><input class="controls" id="telefono" name="telefono" type="text" value="<c:out value="${cliente.telefono}" />" />
                <h5>Correo:</h5><input class="controls" id="correo" name="correo" type="email" value="<c:out value="${cliente.correo}" />" />
                <h5>Direccion:</h5><input class="controls" id="direccion" name="direccion" type="" value="<c:out value="${cliente.direccion}" />" />
                <input id="guardar" name="guardar" class="button" type="submit" value="Modificar">
                <a href="ClientesController" class="buttonvolver" type="submit" >Volver</a>
                
            </section>

        </form>
    </body>
</html>
