/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.dao;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.Clientes;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author darkv
 */
public class ClientesDao {
    Clientes[] bdClientes;
    
    public  ClientesDao(){
        bdClientes = new Clientes[5];
    }
    
    public void crear(Clientes unCliente){
        int i;
        for (i = 0; i < 5; i++) {
            if (bdClientes[i]==null) {
                unCliente.setId(i);
                bdClientes[i]=unCliente;
                return;
            }
        }
    }
    
    public void crear (int Id, long telefonoCliente){
        Clientes unCliente;
        unCliente = new Clientes();
        unCliente.setId(Id);
        unCliente.setTelefonoCliente(telefonoCliente);
        crear(unCliente);
    }
    
    public Clientes findByIdClientes(Integer idCliente){
        return bdClientes[idCliente];
    }
    
    public List<Clientes> findAll (){
        List<Clientes> listaSalida;
        listaSalida = new ArrayList<>();
        for(int i =0; i<5;i++){
            if(bdClientes[i]!=null){
                listaSalida.add(bdClientes[i]);
            }
        }
        return listaSalida;
    }
}
