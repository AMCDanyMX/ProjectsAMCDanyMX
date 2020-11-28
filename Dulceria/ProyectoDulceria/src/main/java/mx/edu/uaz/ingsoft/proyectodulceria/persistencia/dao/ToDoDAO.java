/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.dao.interfaces.IToDoDAO;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.ToDo;
/**
 *
 * @author Nekkran666
 */
public class ToDoDAO implements IToDoDAO {

    static Logger logger = Logger.getLogger(ToDoDAO.class.getName());
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ToDoDAO(){
        emf = Persistence.createEntityManagerFactory("PersistenciaDulceria");
        em=emf.createEntityManager();
    }
    
    @Override
    public ToDo add(ToDo unToDo) {
        try{
            em.getTransaction().begin();
            em.persist(unToDo);            
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            logger.fine("Error al agregar un registro en la BD");
        }
        return unToDo;
    }

    @Override
    public void delete(ToDo unToDo) {
        try{
            em.getTransaction().begin();
            em.remove(unToDo);            
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            logger.fine("Error al borrar un registro en la BD");
        }
        
    }

    @Override
    public ToDo update(ToDo unToDo) {
        ToDo salida;
        try{
            em.getTransaction().begin();
            salida = em.merge(unToDo);            
            em.getTransaction().commit();
        }catch(Exception e){
            salida = null;
            e.printStackTrace();
            em.getTransaction().rollback();
            logger.fine("Error al actualizar un registro en la BD");
        }
        return salida;
    }

    @Override
    public ToDo findById(Long id) {
        ToDo salida;
        try{
            em.getTransaction().begin();
            salida = em.find(ToDo.class,id);            
            em.getTransaction().commit();
        }catch(Exception e){
            salida = null;
            e.printStackTrace();
            em.getTransaction().rollback();
            logger.fine("Error al buscar un registro en la BD");
        }
        return salida;
    }

    @Override
    public List<ToDo> findAll() {
        List<ToDo> salida;
        try{
            Query query;
            query = em.createQuery("from ToDo t", ToDo.class);            
            salida = query.getResultList();            
        }catch(Exception e){
            salida = null;
            e.printStackTrace();
            em.getTransaction().rollback();
            logger.fine("Error al buscar todos los registro en la BD");
        }
        return salida;
    }

}
