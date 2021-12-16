/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.awt.Color;
import java.io.File;
import java.awt.Desktop;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author jseba
 */
public class ImpresoraZ {

//private CajaAd ad;
    void imprimirTicket(String total,String fecha) {
        // this.ad=ad;
        try {

            PrinterMatrix printer = new PrinterMatrix();
            //Extenso e = new Extenso();
            //printer.setOutSize(1, 1);
            //  e.setNumber(5.5);
            //Definir el tamanh del papel para la impresion de dinamico y 32 columnas

            //int filas = ventas.CajaAd.tablaCaja.getRowCount();
         
            //int tamaño = filas + 23;
            printer.setOutSize(22, 50);

            //Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(0, 0, 0, 50, "================================================");
            printer.printTextWrap(1, 0, 10, 50, "       SURTI FRUVER"); //Nombre establecimiento
            printer.printTextWrap(2, 0, 8, 50, "PLACITA BOYACENCE EN TAME ARAUCA"); //Barrio
            printer.printTextWrap(3, 0, 10, 50, "Carrera 13 con calle 16 esquina"); //Direccion 
            printer.printTextWrap(4, 0, 0, 50, "LOS ESPERAMOS PARA TENER EL GUSTO DE ATENDELROS");
            if(fecha!="")printer.printTextWrap(5, 0, 0, 50, "Fecha de cierre: " + fecha);else printer.printTextWrap(5, 0, 0, 50, "Fecha de cierre: " + ventas.CajaAd.fechaactual()); //Aqui va la fecha de recibo
            printer.printTextWrap(6, 0, 0, 50, "Hora de cierre: " + principal.MenuPrincipalAd.hora.getText()); //Aqui va la hora de recibo
            printer.printTextWrap(7, 0, 3, 50, "        "); //Numero del recibo - FACTURA O PEDIDO
            printer.printTextWrap(8, 0, 0, 50, "Usuario de cierre: " + principal.MenuPrincipalAd.userConect.getText()); //Nombre Cajero
            printer.printTextWrap(9, 0, 0, 50, "================================================");
            printer.printTextWrap(10, 0, 0, 50, "               TOTAL: ");
            printer.printTextWrap(11, 1, 15, 50, total);
            printer.printTextWrap(12, 1, 0, 50, "================================================");
         
           

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
                if (JOptionPane.showConfirmDialog(null, "¿Desea imprimir recibo?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                    System.err.println("se imprime");
                    desktop.print(fichero);
                } else {
                    System.err.println("NO se imprime");
                    PrinterMatrix printer2 = new PrinterMatrix();

                    printer.setOutSize(2, 50);
                    printer.toFile("C:\\tmp\\impresion2.txt");
                    FileInputStream inputStream2 = null;
                    inputStream2 = new FileInputStream("C:\\tmp\\impresion2.txt");
                    //  Desktop desktop2 = java.awt.Desktop.getDesktop();
                    File fichero2 = new java.io.File("C:\\tmp\\impresion2.txt");
                    desktop.print(fichero2);

                }
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
