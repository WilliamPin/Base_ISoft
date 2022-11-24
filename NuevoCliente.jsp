<%-- 
    Document   : NuevoCliente
    Created on : 18/11/2022, 11:17:36 a. m.
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="Style_nuevo.css" rel="stylesheet" type="text/css"/>
        <link href="misEstilos.css" rel="stylesheet" type="text/css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>

        <title>Almacen</title>
    </head>
    <body>
        <form action="ClientesController?accion=insertar" method="POST" autocomplete="off" value="Registrar">
              <section class="form-register">
                <h4>Ingresar Cliente</h4>
                <input class="controls" id="nombre" name="nombre" type="text" placeholder="Nombre del Cliente">
                <input class="controls" id="telefono" name="telefono" type="text" maxlength="10" placeholder="Telefono">
                <input class="controls" id="correo" name="correo" type="email" placeholder="Correo">
                <input class="controls" id="direccion" name="direccion" type="" placeholder="Direccion">
                <input id="guardar" name="guardar" class="button" type="submit" value="Ingresar">
                <a href="index.html" class="buttonvolver" type="submit" >Volver</a>
              </section>
        </form>
    </body>
</html>
