package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    
    Connection conexion;
    
    public ClientesDAO(){
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Clientes> listarClientes(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Clientes> lista = new ArrayList<>();
        
        try {
            
            ps = conexion.prepareStatement("SELECT * FROM clientes;");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int telefono = rs.getInt("telefono");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                
                Clientes cliente = new Clientes(id, nombre, telefono, correo, direccion);
                
                lista.add(cliente);
            }
            
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    public Clientes mostrarCliente(int _id){
        
        PreparedStatement ps;
        ResultSet rs;
        
        Clientes cliente = null;
        
        try {
            
            ps = conexion.prepareStatement("SELECT * FROM clientes WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int telefono = rs.getInt("telefono");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                
                cliente = new Clientes(id, nombre, telefono, correo, direccion);
            }
            
            return cliente;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    public boolean insertar(Clientes cliente){
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO clientes (nombre, telefono, correo, direccion) VALUES (?,?,?,?)");
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getTelefono());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    public boolean actualizar(Clientes cliente){
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("UPDATE clientes SET nombre=?, telefono=?, correo=?, direccion=? WHERE id=?");
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getTelefono());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getId());
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    public boolean eliminar(int _id){
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("DELETE FROM clientes WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
}
