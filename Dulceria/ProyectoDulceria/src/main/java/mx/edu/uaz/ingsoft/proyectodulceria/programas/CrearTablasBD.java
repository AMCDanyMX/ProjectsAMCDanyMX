/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.programas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dany_
 */
public class CrearTablasBD {
    public static void main(String args[]){
        try {

            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo cargar la clase " + ex.getMessage());
            Logger.getLogger(CrearTablasBD.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        try (Connection d = DriverManager.getConnection("jdbc:sqlite:dulceriadb.db");
             Statement stmt = d.createStatement()) {

            System.out.println("Se conectó correctamente");
            String qryCrearTabla = " CREATE TABLE CLIENTES "
                    + " (id int primary key not null, "
                    + "  nombreCliente  text  not null, "
                    + "  direccionCliente text  not null, "
                    + "  correoCliente text  not null)";
                    
            System.out.println("Qry =" + qryCrearTabla);
            stmt.executeUpdate(qryCrearTabla);
            System.out.println("Se creó la tabla CLIENTES ");
        } catch ( SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
    }
    
    
    
}
