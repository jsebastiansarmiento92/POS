/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alimentos;

import usuarios.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.GenerarCodigos;
import principal.conectar;

/**
 *
 * @author Rojeru San CL
 */
public class OpcionesAl {

    static conectar cc = new conectar();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(ProductosCod uc) {
        int rsu = 0;
        String sql = ProductosCod.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getPrimaryKey());
            ps.setString(2, uc.getTipoal());
            ps.setString(3, uc.getNombre());
            ps.setString(4, uc.getPrecio());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
        System.out.println(sql);
        return rsu;
    }
  public static String[] bucaProducto(String busca){
      // DefaultTableModel modelo = (DefaultTableModel) alimentos.Productos.tablaAlimentos.getModel();

       
        String sql = "";
      
            sql = "SELECT * FROM alimentos WHERE codigo_al='" + busca + "'";
        
        String datos[] = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
                while (rs.next()) {
                datos[0] = rs.getString("codigo_al");
                datos[1] = rs.getString("tipo_al");
                datos[2] = rs.getString("nombre_al");
                datos[3] = rs.getString("precio_al");
                
        return datos;
            }
         
                
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesAl.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NumberFormatException ex){
            System.out.println("producto no encontrado");
        }
         return null;
    }
    public static int actualizar(ProductosCod uc) {
        int rsu = 0;
        String sql = ProductosCod.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getTipoal());
            ps.setString(2, uc.getNombre());
            ps.setString(3, uc.getPrecio());
            ps.setString(4, uc.getPrimaryKey());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminar(String id) {
        int rsu = 0;
        String sql = ProductosCod.ELIMINAR;

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
        String sql = ProductosCod.ELIMINAR_TODO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static void extraerID() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(codigo_al) FROM alimentos";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                alimentos.Productos.codigo.setText("AL0001");
            } 

        } catch (SQLException ex) {
            Logger.getLogger(OpcionesAl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) alimentos.Productos.tablaAlimentos.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = ProductosCod.LISTAR;
        } else {
            sql = "SELECT * FROM alimentos WHERE (codigo_al like'" + busca + "%' or nombre_al like'" + busca + "%') "
                    + " ORDER BY nombre_al";
        }
        String datos[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("codigo_al");
                datos[1] = rs.getString("tipo_al");
                datos[2] = rs.getString("nombre_al");
                datos[3] = rs.getString("precio_al");
                datos[4] = (Double.parseDouble(rs.getString("precio_al"))/2)+"";
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesAl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listar1(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) alimentos.ListaProductosANor.tablaAlimentos.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = ProductosCod.LISTAR;
        } else {
            sql = "SELECT * FROM alimentos WHERE (codigo_al like'" + busca + "%' or nombre_al like'" + busca + "%') "
                    + "or tipo_al='" + busca + "' ORDER BY nombre_al";
        }
        String datos[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("codigo_al");
                datos[1] = rs.getString("tipo_al");
                datos[2] = rs.getString("nombre_al");
                datos[3] = rs.getString("precio_al");
                datos[4] = (Double.parseDouble(rs.getString("precio_al"))/2)+"";
             // datos[4] ="asdasd";
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesAl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public static void listar2(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) alimentos.ListaAlimentosAd.tablaProductos.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = ProductosCod.LISTAR;
        } else {
            sql = "SELECT * FROM alimentos WHERE (codigo_al like'" + busca + "%' or nombre_al like'" + busca + "%') "
                    + "or tipo_al='" + busca + "' ORDER BY nombre_al";
        }
        String datos[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("codigo_al");
                datos[1] = rs.getString("tipo_al");
                datos[2] = rs.getString("nombre_al");
                datos[3] = rs.getString("precio_al");
                datos[4] = (Double.parseDouble(rs.getString("precio_al"))/2)+"";
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesAl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void listar3(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) alimentos.ListaAlimentosAd1.tablaProductos2.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = ProductosCod.LISTAR;
        } else {
            sql = "SELECT * FROM alimentos WHERE (codigo_al like'" + busca + "%' or nombre_al like'" + busca + "%') "
                    + "or tipo_al='" + busca + "' ORDER BY nombre_al";
        }
        String datos[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("codigo_al");
                datos[1] = rs.getString("tipo_al");
                datos[2] = rs.getString("nombre_al");
                datos[3] = rs.getString("precio_al");
                datos[4] = (Double.parseDouble(rs.getString("precio_al"))/2)+"";
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpcionesAl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean isNumber(String n) {
        try {
            if (Integer.parseInt(n) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
