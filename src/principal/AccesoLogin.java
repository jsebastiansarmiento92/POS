/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rojeru San CL
 */
public class AccesoLogin extends javax.swing.JFrame {

    //SplashScreen inicio;
  //  private final BasculaIni basculaIni=new BasculaIni();
    /**
     * Creates new form AccesoLogin
     */
  //  public AccesoLogin() {
     // this.basculaIni =  new  BasculaIni();
     //BasculaIni basculaIni1=new BasculaIni();
     //  System.out.println("valor bascula       "+basculaIni1.getPeso());
      // System.out.println("valor bascula"+basculaIni.getPeso());
  //      initComponents();
   //     this.setSize(410, 500);
   //     this.setResizable(false);
  //      this.setLocationRelativeTo(null);
       // this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/principal/logo.png")).getImage());
 //       this.setTitle("ACCESO - SISTEMA SOFTPOS (SOFTPOS)");
      
 //   }

    public AccesoLogin( ) {
       // this.inicio = inicio;
        //this.basculaIni=new BasculaIni();
     //   setProgress(0, "Cargando Componentes del Sistema");
    //  int valor = JOptionPane.showOptionDialog(null, "mensaje", "titulo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,null, null);
       // System.out.print("valor del primero joption pane "+ valor);
        initComponents();
        this.setSize(410, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
       // this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/principal/logo.png")).getImage());
        this.setTitle("ACCESO - SISTEMA SOFTPOS SALAS (SOFTPOS)");
    //    setProgress(20, "Conectandose a la Base de Datos...");
     //   setProgress(40, "Cargando Modulos..");
      //  setProgress(60, "Carga de Modulos Terminada");
     //   setProgress(80, "Cargando Interfaces..");
     //   setProgress(90, "Interfaces Cargadas");
    //    setProgress(100, "Bienvenido al Sistema");
        this.setLocationRelativeTo(null);
    }

    void setProgress(int percent, String information) {
       // inicio.getJLabel().setText(information);
       // inicio.getJProgressBar().setValue(percent);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo ejecutar la presentaci�n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        jLabel1 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        contrasenia = new jpass.JRPasswordField();
        usuario = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panel1.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\principal\\loginImagen.jpg")); // NOI18N

        labelMetric3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric3.setText("¡¡¡ bienvenido a Softpos !!!");
        labelMetric3.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMetric3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\principal\\usuario1.png")); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 148, 193), 2));

        salir.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\principal\\salir2.png")); // NOI18N
        salir.setBorder(null);
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/salir1.png"))); // NOI18N
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        entrar.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\principal\\entrar2.png")); // NOI18N
        entrar.setBorder(null);
        entrar.setBorderPainted(false);
        entrar.setContentAreaFilled(false);
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/entrar1.png"))); // NOI18N
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contrasenia.setBackground(new java.awt.Color(34, 102, 145));
        contrasenia.setBorder(null);
        contrasenia.setForeground(new java.awt.Color(255, 255, 255));
        contrasenia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contrasenia.setOpaque(false);
        contrasenia.setPhColor(new java.awt.Color(255, 255, 255));
        contrasenia.setPlaceholder("CONTRSEÑA");
        contrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseniaActionPerformed(evt);
            }
        });
        contrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraseniaKeyPressed(evt);
            }
        });
        jPanel3.add(contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, -1));

        usuario.setBackground(new java.awt.Color(34, 102, 145));
        usuario.setBorder(null);
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.setOpaque(false);
        usuario.setPhColor(new java.awt.Color(255, 255, 255));
        usuario.setPlaceholder("USUARIO");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioKeyReleased(evt);
            }
        });
        jPanel3.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\principal\\campoLoginUs.png")); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 52));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\principal\\campoLoginPass.png")); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 52));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(entrar)
                .addGap(18, 18, 18)
                .addComponent(salir)
                .addGap(46, 46, 46))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salir)
                    .addComponent(entrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        String us = usuario.getText();
        String pas = contrasenia.getText();
     //   System.out.println("valor de bascula "+ this.basculaIni.getPeso());
        if (us.equals("") || pas.equals("")) {
            JOptionPane.showMessageDialog(this, "Los campos son obligatorios", "Acceso", 0,
                    new ImageIcon(getClass().getResource("/imagenes/usuarios/info.png")));
        } else {
            ingresa(us, pas);
        }
    }//GEN-LAST:event_entrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "Esta a punto de salir\nde la aplicaci�n.\n Desea continuar?", "Cerrar", JOptionPane.YES_NO_OPTION, 0,
                new ImageIcon(getClass().getResource("/imagenes/principal/adver1.png"))) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else{
            this.setDefaultCloseOperation(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
        usuario.setText(usuario.getText().toUpperCase());
    }//GEN-LAST:event_usuarioKeyReleased

    private void contraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseniaActionPerformed

    private void contraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseniaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String us = usuario.getText();
            String pas = contrasenia.getText();
     //   System.out.println("valor de bascula "+ this.basculaIni.getPeso());
        if (us.equals("") || pas.equals("")) {
            JOptionPane.showMessageDialog(this, "Los campos son obligatorios", "Acceso", 0,
                    new ImageIcon(getClass().getResource("/imagenes/usuarios/info.png")));
            usuario.requestFocus();
        } else {
            ingresa(us, pas);
        }
            
        }
    }//GEN-LAST:event_contraseniaKeyPressed

    private void usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
             contrasenia.requestFocus();
         }
    }//GEN-LAST:event_usuarioKeyPressed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed
    conectar cc = new conectar();
    Connection cn = cc.conexion();
    public void ingresa(String id, String pas) {
        String dato = null;
        try {
            String sql = "SELECT nombre_us FROM usuarios WHERE nombre_us = '" + id + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.first()) {
                String sql1 = "SELECT pass FROM usuarios WHERE pass = '" + pas + "'";
                Statement st1 = cn.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                if (rs1.first()) {
                    String sql2 = "SELECT tipo_us FROM usuarios WHERE nombre_us = '" + id + "'"
                            + " and pass = '" + pas + "'";
                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql2);
                    while (rs2.next()) {
                        dato = rs2.getString(1);
                    }
                    if(dato!=null){
                        if (dato.equals("ADMINISTRADOR")) {
                        MenuPrincipalAd mp = new MenuPrincipalAd();
                        mp.setRol(dato);
                        String sql3 = "SELECT nombre_us FROM usuarios WHERE nombre_us = '" + id + "'";
                        Statement st3 = cn.createStatement();
                        ResultSet rs3 = st3.executeQuery(sql3);
                        while (rs3.next()) {
                            dato = rs3.getString(1);
                        }
                        dispose();
                        
                     //   System.out.println("valor de bascula "+ this.basculaIni.getPeso());
                        
                        JOptionPane.showMessageDialog(this, "BIENVENIDO A SOFTPOS " + dato, "Administrador", 0,
                                new ImageIcon("C:\\Pos\\data\\imagenes\\principal\\adm.png"));
                        mp.userConect.setText(dato);
                        mp.setVisible(true);

                    } else {

                        String sql3 = "SELECT nombre_us FROM usuarios WHERE nombre_us = '" + id + "'";
                        Statement st3 = cn.createStatement();
                        ResultSet rs3 = st3.executeQuery(sql3);
                        while (rs3.next()) {
                            dato = rs3.getString(1);
                        }
                        dispose();
                        MenuPrincipalAd mp = new MenuPrincipalAd();
                       // MenuPrincipalNor mp = new MenuPrincipalNor();
                        JOptionPane.showMessageDialog(this, "BIENVENIDO A SOFTPOS " + dato, "Normal", 0,
                                new ImageIcon(getClass().getResource("/imagenes/principal/norm.png")));
                        mp.userConect.setText(dato);
                        mp.setVisible(true);

                    }
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(this, "contraseña incorrecta", "Acceso", 0,
                            new ImageIcon(getClass().getResource("/imagenes/principal/passLogin.png")));
                    this.contrasenia.setText("");
                    this.usuario.transferFocus();
                    this.contrasenia.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No existe usuario.", "Acceso", 0,
                        new ImageIcon(getClass().getResource("/imagenes/principal/userLogin.png")));
                this.usuario.setText("");
                this.usuario.requestFocus();
                //this.jLabel1.transferFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoLogin.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccesoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccesoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccesoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccesoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccesoLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jpass.JRPasswordField contrasenia;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JButton salir;
    private app.bolivia.swing.JCTextField usuario;
    // End of variables declaration//GEN-END:variables
}
