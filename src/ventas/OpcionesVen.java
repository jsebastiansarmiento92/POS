/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.GenerarNumero;
import principal.conectar;

/**
 *
 * @author Rojeru San CL
 */
public class OpcionesVen {

    static conectar cc = new conectar();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static int registrar(VentasCod uc) {
        int rsu = 0;
        String sql = VentasCod.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
           // ps.setString(1, uc.getPrimaryKey());
            ps.setString(1, uc.getTotal());
            ps.setString(2, uc.getFecha());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
public static int registrarDetalle(VentaDetalle vd) {
        int rsu = 0;
        String sql = VentaDetalle.REGISTRARDETALLE;
        try {
            ps = cn.prepareStatement(sql);
           // ps.setString(1, uc.getPrimaryKey());
            ps.setString(1, vd.getNumero());
            ps.setString(2, vd.getCodigoAl());
            ps.setString(3, vd.getTipoAl());
            ps.setString(4, vd.getDescripcion());
            ps.setString(5, vd.getPrecio());
            ps.setString(6, vd.getCantidad());
            ps.setString(7, vd.getImporte());
            ps.setString(8, vd.getCodigoUs());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    public static int eliminar(String id) {
        int rsu = 0;
        String sql = VentasCod.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminaTodos() {
        int rsu = 0;
        String sql = VentasCod.ELIMINAR_TODO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static String listar(String busca) {
        DecimalFormat formatea;
               formatea = new DecimalFormat("###,###.##");
               
        DefaultTableModel modelo = (DefaultTableModel) ventas.RegistroVentas.tablaVentas.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = VentasCod.LISTAR;
        } else {
            sql = "SELECT * FROM registro_venta WHERE (numero like'" + busca + "%' or fecha='" + busca + "')"
                    + " ORDER BY fecha";
        }
        String datos[] = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int total=0;
            while (rs.next()) {
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("total");
                datos[2] = rs.getString("fecha");
                modelo.addRow(datos);
                System.out.println("numeros a sumar "+ datos[2]);
                int convert=(int)Double.parseDouble(datos[1]);
                total+=convert;
            }
             // DecimalFormat format= new DecimalFormat();
              // format = new DecimalFormat("###,###.##");
             
             if (busca==""||busca==null) {
                
            }else {JOptionPane.showMessageDialog(null,"Total ventas: "+formatea.format(total));
            
             return "$"+formatea.format(total);
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesVen.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return "$"+0+"";
    }
    public static String listarDetalle(String busca) {
        
        DecimalFormat formatea;
               formatea = new DecimalFormat("###,###.##");
               
        DefaultTableModel modelo = (DefaultTableModel) ventas.CajaDetalle.tablaCajaDetalle.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if(!busca.equals("0")){
            
            sql = "SELECT * FROM detalle_factura WHERE numero=" + busca;
                    
        }
        String datos[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int total=0;
            while (rs.next()) {
                datos[0] = rs.getString("codigo_al");
                datos[1] = rs.getString("tipo_al");
                datos[2] = rs.getString("descripcion");
                datos[3] = formatea.format(Double.parseDouble(rs.getString("precio")));
                datos[4] = rs.getString("cantidad");
                datos[5] = formatea.format(Math.rint(Integer.parseInt(rs.getString("importe"))* 100) / 100);
                
                
                modelo.addRow(datos);
                System.err.println("detalle que ingresa codigo_al: "+ datos[0]+
                "  tipo_al: "+datos[1]+
                         "  descripcion: "+datos[2]+
                         "  precio:  "+datos[3]+
                         "  cantidad:  "+datos[4]+
                         "  importe:  "+datos[5]);
                //int convert=(int)Double.parseDouble(datos[1]);
                //total+=convert;
            }
             // DecimalFormat format= new DecimalFormat();
              // format = new DecimalFormat("###,###.##");
             
             if (busca==""||busca==null) {
                
            }else {
             //    JOptionPane.showMessageDialog(null,"Total ventas hoy: "+formatea.format(total));
            
             return "$"+formatea.format(total);
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesVen.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return "$"+0+"";
    }
public static void numeros3() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(numero) FROM registro_venta";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                ventas.CajaAd1.numFac2.setText("1");
            } else {
                j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                ventas.CajaAd1.numFac2.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(OpcionesVen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void numeros() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(numero) FROM registro_venta";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                ventas.CajaAd.numFac1.setText("1");
            } else {
                j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                ventas.CajaAd.numFac1.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(OpcionesVen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void numeros1() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(numero) FROM registro_venta";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
               // ventas.CajaAd.numFac.setText("00000001");
            } else {
                j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
               // ventas.CajaAd.numFac.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(OpcionesVen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
