package Controlador;

import Modelo.Clientes;
import Modelo.ClientesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClientesController", urlPatterns = {"/ClientesController"})
public class ClientesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ClientesDAO clientesDAO = new ClientesDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("VerClientes.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
        }else if("nuevo".equals(accion)){
            dispatcher = request.getRequestDispatcher("index.html");
        } else if("insertar".equals(accion)){
            
            String nombre = request.getParameter("nombre");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            
            Clientes cliente = new Clientes(0, nombre, telefono, correo, direccion);
            
            clientesDAO.insertar(cliente);
            
            dispatcher = request.getRequestDispatcher("VerClientes.jsp");
            List<Clientes> listaArticulos = clientesDAO.listarClientes();
            request.setAttribute("lista", listaArticulos);
        } else if("modificar".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("ModificarClientes.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Clientes cliente = clientesDAO.mostrarCliente(id);
            request.setAttribute("cliente", cliente);
            
        } else if("actualizar".equals(accion)){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            
            
            Clientes cliente = new Clientes(id, nombre, telefono, correo, direccion);
            
            clientesDAO.actualizar(cliente);
            
            dispatcher = request.getRequestDispatcher("VerClientes.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
        }else if("eliminar".equals(accion)){
            int id = Integer.parseInt(request.getParameter("id"));
            
            clientesDAO.eliminar(id);
            
            dispatcher = request.getRequestDispatcher("VerClientes.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
        } else if("seleccionar".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("SeleCliente.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Clientes cliente = clientesDAO.mostrarCliente(id);
            request.setAttribute("cliente", cliente);
        } else{
            dispatcher = request.getRequestDispatcher("VerClientes.jsp");
            List<Clientes> listaClientes = clientesDAO.listarClientes();
            request.setAttribute("lista", listaClientes);
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
