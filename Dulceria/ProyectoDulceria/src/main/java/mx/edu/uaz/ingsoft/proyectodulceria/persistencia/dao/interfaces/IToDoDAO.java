/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.dao.interfaces;

/**
 *
 * @author Nekkran666
 */
import java.util.List;
import mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades.ToDo;

public interface IToDoDAO {
    ToDo add(ToDo unTodo);
    void delete(ToDo unTodo);
    ToDo update(ToDo unTodo);
    ToDo findById(Long id);
    List<ToDo> findAll();
}
