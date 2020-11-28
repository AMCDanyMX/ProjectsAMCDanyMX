/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.conexion.SQLITEConnection;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.Usuario;


/**
 *
 * @author darkv
 */
public class UsuarioDao {
    PreparedStatement ps;
    ResultSet rs;
    
    SQLITEConnection con = new SQLITEConnection();
    Connection acceso;
    
    public Usuario ValidarUsuario(String dni, String usuario){
        Usuario user = new Usuario();
        String sql = "select * from TablaUsuario where Dni=? and User =?";
        try {
            acceso = con.ConnecDb();
            ps=acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, usuario);
            rs=ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setDni(rs.getString(2));
                user.setNombreUsuario(rs.getString(3));
                user.setTelefonoUsuario(rs.getString(4));
                user.setEdad(rs.getString(5));
                user.setUsuario(rs.getString(6));
                
            }
        } catch (Exception e) {
        }
        return user;  
    }
}
