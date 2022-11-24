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
        <link href="Dialogo.css" rel="stylesheet" type="text/css"/>
        <title>Modificar</title>
    </head>
    <body>
        
      
        <form action="ClientesController?accion=eliminar" method="POST" autocomplete="off">
            
            
            <section class="form-register3">
                <input id="id" name="id" type="hidden" value="<c:out value="${cliente.id}" />" />
                <center><h4>Caracteristicas del Clientes<hr></h4></center>     
                                <h1>Nombre: ${cliente.nombre}<br /><br /></h1>  
                                <h1>Telefono: ${cliente.telefono}<br /><br /></h1>
                                <h1>Correo: ${cliente.correo}<br /><br /></h1>
                                <h1>Direccion: ${cliente.direccion}<br /><br /></h1>
                                <div class="opcion">
                                <a href="#IrVentanaFlotante" class="button" type="submit">Vender</a>
                                <a href="ArticulosController" class="button" type="submit" >Volver</a>
                                </div>
                                    <div id="IrVentanaFlotante" class="modal">
                                        <div class="ventana">
                                          <a href="#" style='text-decoration:none;'>
                                          X
                                          </a>
                                          <h2>Venta</h2>
                                          <p>Articulo Vendido con exito al cliente selecionado</p>
                                        </div>  
                                </div>

                                
            </section>
                                <div class="opcion"> 


        </form>
        
    </body>
</html>
