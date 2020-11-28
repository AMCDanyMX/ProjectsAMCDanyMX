/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.terminaldulceria;

import java.util.List;
import java.util.Scanner;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.dao.ToDoDAO;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.dao.interfaces.IToDoDAO;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.ToDo;

/**
 *
 * @author darkv
 */
public class ProgramaPrincipal {
    static Scanner teclado;
    static IToDoDAO dao;
    
    static final int OPCION_INVALIDA = -1;
    static final int OPCION_AGREGAR = 1;
    static final int OPCION_LISTAR = 2;
    static final int OPCION_SALIR = 0;
    
    static{
        dao = new ToDoDAO();
        teclado = new Scanner(System.in);
    }
    
    public static void main(String args[]){
        int accion;
        do{
            accion = pedirOpcion();
            switch(accion){
                case 1:
                    listarRegistros();
                    break;
                case 2:
                    agregarRegistro();
                    break;
            }
        }while(accion != OPCION_SALIR);
        
    }
    
    static void listarRegistros(){
        List<ToDo> listadoPendientes = dao.findAll();
        for(ToDo unPendiente:listadoPendientes){
            System.out.println(unPendiente.toString());
        }
    }
    
    static void agregarRegistro(){
        ToDo unPendiente = new ToDo();
        unPendiente.setPrioridad("ALTA");
        String descripcion;
        do{
            System.out.println("Ingresa la descripción del ToDo:");
            unPendiente.setDescripcion(teclado.nextLine());
                    
        }while(unPendiente.getDescripcion().trim().isEmpty());
        dao.add(unPendiente);
    }
   
    static int pedirOpcion(){
        int respuesta=OPCION_INVALIDA;
        while(respuesta == OPCION_INVALIDA){
            mostrar_opciones_menu();
            try{
                respuesta = teclado.nextInt();
                if(respuesta < OPCION_SALIR || respuesta > OPCION_LISTAR){
                    System.out.println("Opción inválida");
                    respuesta = OPCION_INVALIDA;
                }
            }catch(Exception e){
                System.out.println("Error al ingresar la opción");
                respuesta = OPCION_INVALIDA;
            }
        }
        return respuesta;
    }
    
    static void mostrar_opciones_menu(){
        System.out.println(OPCION_AGREGAR+"-Listar registros");
        System.out.println(OPCION_LISTAR+"-Ingresar nuevo registro");
        System.out.println(OPCION_SALIR+"-Salir");
    }
}
