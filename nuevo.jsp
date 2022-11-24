<%-- 
    Document   : nuevo
    Created on : 17/11/2022, 6:29:37 p. m.
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
        <form action="ArticulosController?accion=insertar" method="POST" autocomplete="off" value="Registrar">
              <section class="form-register">
                <h4>Ingresar Articulo</h4>
                <input class="controls" id="codigo" name="codigo" type="text" placeholder="Nombre del Articulo">
                <input class="controls" id="nombre" name="nombre" type="text" placeholder="Tipo de Articulo">
                <input class="controls" id="precio" name="precio" type="text" placeholder="Valor del Articulo">
                <input class="controls" id="existencia" name="existencia" type="text" maxlength="10" placeholder="Serial">
                <input id="guardar" name="guardar" class="button" type="submit" value="Ingresar">
                <a href="index.html" class="buttonvolver" type="submit" >Volver</a>
                
              </section>
        </form>
    </body>
</html>
