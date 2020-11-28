
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades;

/**
 *
 * @author dany_
 */
public class DetalleVentas {
    int id;
    int idVentas;
    String idProducto;
    int cantidad;
    double precioVenta;

    public DetalleVentas() {
    }

    public DetalleVentas(int id, int idVentas, String idProducto, int cantidad, double precioVenta) {
        this.id = id;
        this.idVentas = idVentas;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "DetalleVentas{" + "id=" + id + ", idVentas=" + idVentas + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", preVenta=" + precioVenta + '}';
    }
    
    
    
    
}
