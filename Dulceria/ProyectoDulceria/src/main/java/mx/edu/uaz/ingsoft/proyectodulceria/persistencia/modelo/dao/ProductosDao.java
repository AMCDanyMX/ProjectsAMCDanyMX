
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.conexion.SQLITEConnection;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.Productos;


public class ProductosDao implements CRUD {
   Connection con;
   SQLITEConnection cn= new SQLITEConnection();
   PreparedStatement ps;
   ResultSet rs;
   
    
  
    public Productos listarId(String clave){
        Productos p = new Productos();
        String sql = "SELECT * FROM TablaProductos WHERE clave=?";
        try {
            con = cn.ConnecDb();
            ps=con.prepareStatement(sql);
            ps.setString(1, clave);
            rs=ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setClaveProducto(rs.getString(2));
                p.setNombreProducto(rs.getString(3));
                p.setDescripcionProducto(rs.getString(4));
                p.setPrecioProducto(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public List listar() {
        List <Productos> lista = new ArrayList();
        String sql = "SELECT * FROM TablaProductos";
        try{
            con= cn.ConnecDb();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Productos p = new Productos();
                p.setId(rs.getInt(1));
                p.setClaveProducto(rs.getString(2));
                p.setNombreProducto(rs.getString(3));
                p.setDescripcionProducto(rs.getString(4));
                p.setPrecioProducto(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                lista.add(p);
            }
            
        }catch(Exception e){
        }
        return lista;
    }
    

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="INSERT INTO TablaProductos(clave,nombre,descripcion,precio,stock) VALUES(?,?,?,?,?)";
        try{
            con=cn.ConnecDb();
            ps=con.prepareStatement(sql);
            ps.setObject(1,o[0]);
            ps.setObject(2,o[1]);
            ps.setObject(3,o[2]);
            ps.setObject(4,o[3]);
            ps.setObject(5,o[4]);
    
            r=ps.executeUpdate();
            
            
        }catch(Exception e){
        }
        return r;
       
    }

    @Override
    public int actualizar(Object[] o) {
        int r=0;
        String sql="UPDATE TablaProductos SET clave=?,nombre=?,descripcion=?,precio=?,stock=? WHERE id=?";
        try{
            con=cn.ConnecDb();
            ps=con.prepareStatement(sql);
            ps.setObject(1,o[0]);
            ps.setObject(2,o[1]);
            ps.setObject(3,o[2]);
            ps.setObject(4,o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);

            r=ps.executeUpdate();
            
        }catch(Exception e){
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM TablaProductos WHERE id=?";
        try{
            con=cn.ConnecDb();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            
        }catch(Exception e){
        }
    }

   
        
    }

