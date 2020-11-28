
package mx.edu.uaz.ingsoft.proyectodulceria.persistencia.entidades;





public class Ventas{
    int id;
    int idVendedor;
    String fecha;
    double monto;
    String serie;

    public Ventas() {
    }

    public Ventas(int id, int idVendedor, String serie, String fecha, double monto) {
        this.id = id;
        this.idVendedor = idVendedor;
        this.serie= serie;
        this.fecha = fecha;
        this.monto = monto;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    
    
    
    
}
      

    
  
     
    
    
    
