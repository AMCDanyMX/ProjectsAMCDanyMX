package mx.edu.uaz.ingsoft.proyectodulceria.programas;

import java.util.List;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.dao.ClientesDao;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.Clientes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author darkv
 */
public class PruebaClientes {
        public static void main(String[] args) {
            ClientesDao dao = new ClientesDao();
            dao.crear(1,98765419L);
            dao.crear(2, 987654321L);
            
            List<Clientes> listaClientes;
            listaClientes = dao.findAll();
            for(Clientes unCliente: listaClientes){
                System.out.println("El id es: "+unCliente.getId()+" Y el numero de telefono es: "+unCliente.getTelefonoCliente());
            }
            Clientes clienteChido;
            clienteChido = dao.findByIdClientes(1);
            System.out.println("El id es: "+clienteChido.getId()+" Y el numero de telefono es: "+clienteChido.getTelefonoCliente());
            
        }
    }

