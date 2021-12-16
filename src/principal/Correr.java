/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import static java.awt.image.ImageObserver.ERROR;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Rojeru San CL
 */
public class Correr {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en en Look and Feel", "Error", ERROR);
                }
                new SplashScreen().setVisible(true);
            }
        });
    }
}
