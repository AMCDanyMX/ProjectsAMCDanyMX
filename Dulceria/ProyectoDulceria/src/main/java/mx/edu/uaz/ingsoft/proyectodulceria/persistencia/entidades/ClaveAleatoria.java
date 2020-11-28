
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades;

import java.util.Random;
/**
 *
 * @author Nekkran666
 */
public class ClaveAleatoria {
     
    public static Random numGen =new Random(); 

    public static int claveP(){ 
        int rand = Math.abs((10000)+numGen.nextInt(10000));
        return rand; 
    } 
    
      
}
    
