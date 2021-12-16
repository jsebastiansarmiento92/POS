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

public class Impresora1 {

//private CajaAd ad;
    void imprimirTicket(String subTotal, String total, String dineroR, String devolucion) {
        // this.ad=ad;
        try {

            PrinterMatrix printer = new PrinterMatrix();
            //Extenso e = new Extenso();
            //printer.setOutSize(1, 1);
            //  e.setNumber(5.5);
            //Definir el tamanh del papel para la impresion de dinamico y 32 columnas

            int filas = ventas.CajaAd1.tablaCaja2.getRowCount();
            System.out.println("numero de filas de la factura " + filas);
            int tamaño = filas + 21;
            printer.setOutSize(tamaño, 50);

            //Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(0, 0, 0, 50, "================================================");
            printer.printTextWrap(1, 0, 10, 50, "       SURTI FRUVER"); //Nombre establecimiento
            printer.printTextWrap(2, 0, 8, 50, "PLACITA BOYACENCE EN TAME ARAUCA"); //Barrio
            printer.printTextWrap(3, 0, 10, 50, "Carrera 13 con calle 16 esquina"); //Direccion 
            printer.printTextWrap(4, 0, 0, 50, "LOS ESPERAMOS PARA TENER EL GUSTO DE ATENDELROS");
            printer.printTextWrap(5, 0, 0, 50, "Fecha: " + ventas.CajaAd.fechaactual()); //Aqui va la fecha de recibo
            printer.printTextWrap(5, 0, 28, 50, "Hora: " + principal.MenuPrincipalAd.hora.getText()); //Aqui va la hora de recibo
            printer.printTextWrap(6, 0, 3, 50, "Numero : " + ventas.CajaAd.numFac1.getText()); //Numero del recibo - FACTURA O PEDIDO
            printer.printTextWrap(6, 0, 24, 50, "Atiende: " + principal.MenuPrincipalAd.userConect.getText()); //Nombre Cajero
            printer.printTextWrap(7, 0, 0, 50, "================================================");
            printer.printTextWrap(7, 0, 0, 50, "ID   DESCRIPCION   PRECIO     CANT      TOTAL");

            for (int i = 0; i < filas; i++) {
                int p = 8 + i; //Fila

                printer.printTextWrap(p, 1, 0, 19, ventas.CajaAd1.tablaCaja2.getValueAt(i, 0).toString());
                printer.printTextWrap(p, 1, 5, 19, ventas.CajaAd1.tablaCaja2.getValueAt(i, 2).toString());
                printer.printTextWrap(p, 1, 19, 30, ventas.CajaAd1.tablaCaja2.getValueAt(i, 3).toString());
                printer.printTextWrap(p, 1, 30, 36, ventas.CajaAd1.tablaCaja2.getValueAt(i, 4).toString());
                String pre = printer.alinharADireita(10, ventas.CajaAd1.tablaCaja2.getValueAt(i, 5).toString());
                printer.printTextWrap(p, 1, 37, 50, pre);

                //String inp= printer.alinharADireita(7,punto_Venta.jtbl_venta.getValueAt(i,6).toString());
                //printer.printTextWrap(p , 1, 25, 32, inp);
            }
            DecimalFormat formateador = new DecimalFormat("#.###");

            String sub = printer.alinharADireita(10, subTotal);
            printer.printTextWrap(filas + 9, 1, 0, 50, "Subtotal: ");
            printer.printTextWrap(filas + 9, 1, 20, 50, "$" + ventas.CajaAd1.total2.getText());

            String tot = printer.alinharADireita(10, total);
            printer.printTextWrap(filas + 10, 1, 0, 50, "Total a pagar: ");
            printer.printTextWrap(filas + 10, 1, 20, 50, "$" + ventas.CajaAd1.total2.getText());

            String efe = printer.alinharADireita(10, dineroR);
            printer.printTextWrap(filas + 11, 1, 0, 50, "Efectivo : ");
            printer.printTextWrap(filas + 11, 1, 20, 50, "$" + ventas.CajaAd1.recibi2.getText());

            String cam = printer.alinharADireita(10, devolucion);
            printer.printTextWrap(filas + 12, 1, 0, 50, "Cambio : ");
            printer.printTextWrap(filas + 12, 1, 20, 50, "$" + ventas.CajaAd1.cambio2.getText());

            printer.printTextWrap(filas + 13, 1, 0, 50, "================================================");
            printer.printTextWrap(filas + 14, 1, 8, 50, "!Gracias por su preferencia!");
             printer.printTextWrap(filas + 15, 1, 10, 50, "SOFTPOS - v2.0.0");
            printer.printTextWrap(filas + 16, 1, 10, 50, "Software a Medida");
            printer.printTextWrap(filas + 17, 1, 5, 50,   "  Telefono:3118550011          ");
            printer.printTextWrap(filas + 18, 1, 8, 50,"Contacto: WWW.BOYACAWEB.COM");
            
          
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

                    printer.setOutSize(0, 50);
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
