/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.programas;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.Clientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dany_
 */
public class ConsultaTablas {
     public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo cargar la clase " + ex.getMessage());
            Logger.getLogger(ConsultaTablas.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        final String qrySelect;
        qrySelect = " SELECT * from CLIENTES ";
       //
        try (Connection d = DriverManager.getConnection("jdbc:sqlite:dulceriadb.db");
             Statement stmt = d.createStatement();
             ResultSet rs = stmt.executeQuery(qrySelect)) {
            System.out.println("Se conectó correctamente");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreCliente = rs.getString("nombreCliente");
                String direccionCliente = rs.getString("direccionCliente");
                String correoCliente = rs.getString("correoCliente");

                String salida = String.format("id  = %d  nombreCliente= %s  direccionCliente=%s correoCliente=%s",
                        id, nombreCliente, direccionCliente, correoCliente);
                System.out.println(salida);
                Clientes unCliente = new Clientes();
                unCliente.setId(id);
                unCliente.setNombreCliente(nombreCliente);
                unCliente.setDireccionCliente(direccionCliente);
                unCliente.setCorreoCliente(correoCliente);

                // return unaPersona, añade a una lista de salida
            }

        } catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
    }
    
}
