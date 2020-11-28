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
public class LlenadoTablas {
     public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo cargar la clase " + ex.getMessage());
            Logger.getLogger(LlenadoTablas.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        try (Connection d = DriverManager.getConnection("jdbc:sqlite:dulceriadb.db");
             Statement stmt = d.createStatement()) {
            System.out.println("Se conectó correctamente");
            final String qryInsert = "INSERT INTO CLIENTES "
                    + "(id, nombreCliente, direccionCliente, correoCliente) values ";
            String datosInsertar;
            datosInsertar = " ( 1 , 'Joel Salas','Las quintas,Sta Teresita #303','joellocote@gmail.com')";
            stmt.executeUpdate(qryInsert + datosInsertar);
            stmt.executeUpdate(qryInsert + " ( 2 , 'Daniel Morales','Col.Bellavista, Ferrocarril#2','danielmorales@gmail.com')");
            stmt.executeUpdate(qryInsert + " ( 3 , 'Roberto Gallegos','Col Centro, El shell #5','roberto.gallegos@gmail.com')");
            System.out.println("Se insertaron los registros ");
        } catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
    }
    
}
