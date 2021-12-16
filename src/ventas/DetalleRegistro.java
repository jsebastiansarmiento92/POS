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
public class DetalleRegistro {
    
    private String codigoAl;
    private int numero;
    private double precio;
    private double cantidad;
    private String codigoUs;

    public DetalleRegistro() {
    }

        
        
    public DetalleRegistro(String codigoAl, int numero, double precio, double cantidad, String codigoUs) {
        this.codigoAl = codigoAl;
        this.numero = numero;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigoUs = codigoUs;
    }

    
    
    
    
    public String getCodigoAl() {
        return codigoAl;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getCodigoUs() {
        return codigoUs;
    }
    
    
    
    
    
}
