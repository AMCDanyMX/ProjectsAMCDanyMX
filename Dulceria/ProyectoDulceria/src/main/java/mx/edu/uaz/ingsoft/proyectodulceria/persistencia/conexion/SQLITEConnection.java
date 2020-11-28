    
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class SQLITEConnection {
    Connection con = null;
    public static Connection ConnecDb(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:D:\\darkv\\Escritorio\\POO2_20_ProyectoSemestral\\Dulceria\\dulceria.db");
            //Cambiar ruta de base de datos dulceria.db local
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static void main(String args[]){
        ConnecDb();
 
    }
   
}
