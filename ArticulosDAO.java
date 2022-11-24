package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticulosDAO {
    
    Connection conexion;
    
    public ArticulosDAO(){
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Articulos> listarArticulos(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Articulos> lista = new ArrayList<>();
        
        try {
            
            ps = conexion.prepareStatement("SELECT * FROM articulos;");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                Articulos articulo = new Articulos(id, codigo, nombre, precio, existencia);
                
                lista.add(articulo);
            }
            
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    public Articulos mostrarArticulo(int _id){
        
        PreparedStatement ps;
        ResultSet rs;
        
        Articulos articulo = null;
        
        try {
            
            ps = conexion.prepareStatement("SELECT * FROM articulos WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                articulo = new Articulos(id, codigo, nombre, precio, existencia);
            }
            
            return articulo;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    public boolean insertar(Articulos articulo){
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO articulos (codigo, nombre, precio, existencia) VALUES (?,?,?,?)");
            ps.setString(1, articulo.getCodigo());
            ps.setString(2, articulo.getNombre());
            ps.setDouble(3, articulo.getPrecio());
            ps.setInt(4, articulo.getExistencia());
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    public boolean actualizar(Articulos articulo){
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("UPDATE articulos SET codigo=?, nombre=?, precio=?, existencia=? WHERE id=?");
            ps.setString(1, articulo.getCodigo());
            ps.setString(2, articulo.getNombre());
            ps.setDouble(3, articulo.getPrecio());
            ps.setInt(4, articulo.getExistencia());
            ps.setInt(5, articulo.getId());
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
            
            ps = conexion.prepareStatement("DELETE FROM articulos WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
}
