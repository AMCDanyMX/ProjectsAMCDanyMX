/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.conexion.SQLITEConnection;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.DetalleVentas;

/**
 *
 * @author darkv
 */
public class DetalleVentasDao implements CRUD {
   Connection con;
   SQLITEConnection cn= new SQLITEConnection();
   PreparedStatement ps;
   ResultSet rs;

    @Override
    public List listar() {
        List <DetalleVentas> lista = new ArrayList();
        String sql = "SELECT * FROM detalleVentas";
        try {
            con= cn.ConnecDb();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                DetalleVentas dv = new DetalleVentas();
                dv.setId(rs.getInt(1));
                dv.setIdVentas(rs.getInt(2));
                dv.setIdProducto(rs.getString(3));
                dv.setCantidad(rs.getInt(4));
                dv.setPrecioVenta(rs.getFloat(5));
                lista.add(dv);
            }
        } catch (Exception e) {
        }
        return lista;
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
