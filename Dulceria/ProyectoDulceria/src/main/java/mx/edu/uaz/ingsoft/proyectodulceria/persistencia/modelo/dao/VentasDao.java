/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.conexion.SQLITEConnection;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.DetalleVentas;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.Ventas;

/**
 *
 * @author darkv
 */
public class VentasDao implements CRUD {
    
    SQLITEConnection cn=new SQLITEConnection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    
    
    public String IdVentas(){
    
        String idv="";
        String sql="select max(id) from ventas";
        
        try{
            con=cn.ConnecDb();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idv=rs.getString(1);
            }
        }catch(Exception e){
        }
        return idv;
    
    }
    
    public int GuardarVentas(Ventas v){
        Ventas ventas = new Ventas();
        String sql = "INSERT INTO ventas(idVendedor,serie,fecha,monto) VALUES(?,?,?,?)";
        try{
            con=cn.ConnecDb();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, v.getIdVendedor());
            ps.setString(2, v.getSerie());
            ps.setString(3, v.getFecha());
            ps.setDouble(4, v.getMonto());
            
            r=ps.executeUpdate();

        }catch(Exception e){
        }
        
        return r;
    }
    
    public int GuardarDetalleVentas(DetalleVentas dv){
        String sql="INSERT INTO detalleVentas (idVentas,claveP,cantidad,precioVenta) VALUES(?,?,?,?)";
        try{
            con=cn.ConnecDb();
            ps=con.prepareStatement(sql);
      
            ps.setInt(1,dv.getIdVentas());
            ps.setString(2,dv.getIdProducto());
            ps.setInt(3,dv.getCantidad());
            ps.setDouble(4,dv.getPrecioVenta());
            
            ps.executeUpdate();

            
        }catch(Exception e){
        }
        return r;
    }
    
    

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int add(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
