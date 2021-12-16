/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import br.com.adilson.util.PrinterMatrix;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author jseba
 */
public class AperturaCaja {
    void apertura() {
        // this.ad=ad;
        try {

            PrinterMatrix printer = new PrinterMatrix();
            //Extenso e = new Extenso();
            //printer.setOutSize(1, 1);
          //  e.setNumber(5.5);
            //Definir el tamanh del papel para la impresion de dinamico y 32 columnas

            int filas = ventas.CajaAd.tablaCaja.getRowCount();
            System.out.println("numero de filas de la factura " + filas);
         //   int tamaño = filas + 23;
            printer.setOutSize(1, 1);

            //Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(0, 0, 0, 50, "");
            
           
            
           
            

            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            printer.toFile("C:\\tmp\\impresion.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("C:\\tmp\\impresion.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar" + ex.getMessage());
            }
            if (inputStream == null) {
                return;
            }
            Desktop desktop = java.awt.Desktop.getDesktop();
            File fichero = new java.io.File("C:\\tmp\\impresion.txt");
            if (desktop.isSupported(Desktop.Action.PRINT)) {
               System.err.println("se imprime");
                    desktop.print(fichero);
            } else {
                System.out.print("El sistema no permite imprimir usando la clase Desktop");
            }

            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al imprimir " + e);
        }
    }
    
}
