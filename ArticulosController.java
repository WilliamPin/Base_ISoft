package Controlador;

import Modelo.Articulos;
import Modelo.ArticulosDAO;
import Modelo.Clientes;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ArticulosController", urlPatterns = {"/ArticulosController"})
public class ArticulosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArticulosDAO articulosDAO = new ArticulosDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("index.jsp");
            List<Articulos> listaArticulos = articulosDAO.listarArticulos();
            request.setAttribute("lista", listaArticulos);
        }else if("nuevo".equals(accion)){
            dispatcher = request.getRequestDispatcher("index.html");
        } else if("insertar".equals(accion)){
            
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));
            
            Articulos articulo = new Articulos(0, codigo, nombre, precio, existencia);
            
            articulosDAO.insertar(articulo);
            
            dispatcher = request.getRequestDispatcher("index.jsp");
            List<Articulos> listaArticulos = articulosDAO.listarArticulos();
            request.setAttribute("lista", listaArticulos);
        } else if("modificar".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Articulos articulo = articulosDAO.mostrarArticulo(id);
            request.setAttribute("articulo", articulo);
            
        } else if("actualizar".equals(accion)){
            int id = Integer.parseInt(request.getParameter("id"));
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));
            
            Articulos articulo = new Articulos(id, codigo, nombre, precio, existencia);
            
            articulosDAO.actualizar(articulo);
            
            dispatcher = request.getRequestDispatcher("index.jsp");
            List<Articulos> listaArticulos = articulosDAO.listarArticulos();
            request.setAttribute("lista", listaArticulos);
        }else if("eliminar".equals(accion)){
            int id = Integer.parseInt(request.getParameter("id"));
            
            articulosDAO.eliminar(id);
            
            dispatcher = request.getRequestDispatcher("index.jsp");
            List<Articulos> listaArticulos = articulosDAO.listarArticulos();
            request.setAttribute("lista", listaArticulos);
        } else if("vender".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("vender.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Articulos articulo = articulosDAO.mostrarArticulo(id);
            request.setAttribute("articulo", articulo);
        } else{
            dispatcher = request.getRequestDispatcher("index.jsp");
            List<Articulos> listaArticulos = articulosDAO.listarArticulos();
            request.setAttribute("lista", listaArticulos);
        }

        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
