/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

/**
 *
 * @author jseba
 */
public class VentaDetalle {
     public static String REGISTRARDETALLE = "INSERT INTO detalle_factura( numero, codigo_al,tipo_al,descripcion,precio,cantidad,importe,codigo_us) "
            + "VALUES(?,?,?,?,?,?,?,?)";
    
     
     
    private String numero;
    private String codigoAl;
    private String tipoAl;
    private String descripcion;
    private String precio;  
    private String cantidad;
    private String importe;
    private String codigoUs;
    
    
     public VentaDetalle(){
        
    }

    public VentaDetalle(String numero, String codigoAl, String tipoAl, String descripcion, String precio, String cantidad, String importe, String codigoUs) {
        this.numero = numero;
        this.codigoAl = codigoAl;
        this.tipoAl = tipoAl;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importe = importe;
        this.codigoUs = codigoUs;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoAl() {
        return codigoAl;
    }

    public void setCodigoAl(String codigoAl) {
        this.codigoAl = codigoAl;
    }

    public String getTipoAl() {
        return tipoAl;
    }

    public void setTipoAl(String tipoAl) {
        this.tipoAl = tipoAl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getImporte() {
        
        return importe.replaceAll("\\.","");
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getCodigoUs() {
        return codigoUs;
    }

    public void setCodigoUs(String codigoUs) {
        this.codigoUs = codigoUs;
    }


    

    
}
