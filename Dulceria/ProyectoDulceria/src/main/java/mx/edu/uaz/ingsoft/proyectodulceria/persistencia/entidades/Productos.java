package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades;

public class Productos{
    int id;
    String claveProducto;
    String nombreProducto;
    double precioProducto;
    String descripcionProducto;
    int stock;

    
    public Productos() {
    }

    public Productos(int id, String claveProducto, String nombreProducto, double precioProducto, String descripcionProducto, int stock) {
        this.id = id;
        this.claveProducto = claveProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.descripcionProducto = descripcionProducto;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(String claveProducto) {
        this.claveProducto = claveProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
    

    
    

   
   
    
    
   
}
