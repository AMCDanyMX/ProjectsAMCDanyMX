/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades;

/**
 *
 * @author darkv
 */
public class InventarioProductos {
    private String nombreProducto;
    private long codigoBarras;
    private String cfdi;  /* cfdi Es un "código" que pide hacienda para identificar que tipo de producto es.*/

    public String getNombreProducto() {
        return nombreProducto;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public String getCfdi() {
        return cfdi;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setCfdi(String cfdi) {
        this.cfdi = cfdi;
    }
    
    
    
}
