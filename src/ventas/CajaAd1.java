/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import alimentos.ListaAlimentosAd;
import alimentos.ListaAlimentosAd1;
import alimentos.OpcionesAl;
import app.bolivia.swing.JCTextField;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import principal.BasculaIni;
import static principal.MenuPrincipalAd.escritorio;
import static ventas.CajaAd.buscar;
import static ventas.CajaAd.cambio;
import static ventas.CajaAd.recibi;
import static ventas.CajaAd.tablaCaja;

/**
 *
 * @author Rojeru San CL
 */
public class CajaAd1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Usuarios
     */
    BasculaIni basculaIni;
    DecimalFormat formatea;

    public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = escritorio.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
            }
            i++;
        }
        return cerrado;
    }

    public void ingresarBasculaSuma(String datos[]) {
        DefaultTableModel tabladet = (DefaultTableModel) tablaCaja2.getModel();
        String[] dato = new String[6];
        int c = 0;
        int j = 0;

        try {
            BasculaIni basculaIni = new BasculaIni();
            double valorPeso = Double.parseDouble(basculaIni.lecturaFija());
            //alerta de modificacion de datos quemados
            //double valorPeso=3.61321;
            if (valorPeso <= 0) {
                JOptionPane.showMessageDialog(null, "verificar peso no acepta valores en cero o menores que cero");
                return;
            } else {
                System.out.println("else donde el valor de peso de bascula es diferente de 0");

                for (int i = 0; i < tablaCaja2.getRowCount(); i++) {
                    Object com = tablaCaja2.getValueAt(i, 0);
                    Object cant1 = tablaCaja2.getValueAt(i, 4);
                    System.out.println("valor com " + com);
                    if (datos[0].equals(com)) {
                        System.out.println("INGRESO IF DONDE SUMA CANTIDA Y PESO DE PRODUCTO YA PESADO");
                        System.err.println("valor de cant1 " + cant1);
                        j = i;
                        double cantT = Double.parseDouble(cant1.toString()) + valorPeso;
                        tablaCaja2.setValueAt(cantT, i, 4);
                        c++;
                        calcularBascula();
                        recibi2.setText("");
                        cambio2.setText("");
                    }

                }
                System.out.println("valor de c= " + c);
                if (c == 0) {
                    System.out.println("if donde compara c==0 con abscula");
                    dato[0] = datos[0];
                    dato[1] = datos[1];
                    dato[2] = datos[2];
                    dato[3] = formatea.format(Double.parseDouble(datos[3]));
                    dato[4] = valorPeso + "";

                    tabladet.addRow(dato);

                    tablaCaja2.setModel(tabladet);
                    calcularBascula();

                    CajaAd1.recibi2.setText("");
                    CajaAd1.cambio2.setText("");
                }
            }
        } catch (Exception e) {
            buscar2.setText("");
            System.out.println("ingreso a execpcion de enter para bascula");

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public CajaAd1() {
        formatea = new DecimalFormat("###,###.##");
        this.basculaIni = new BasculaIni();
        System.out.println("peso actual " + basculaIni.getPeso());
        initComponents();
        tablaCaja2.getTableHeader().setDefaultRenderer(new principal.EstiloTablaHeader());
        tablaCaja2.setDefaultRenderer(Object.class, new principal.EstiloTablaRenderer());
        this.setFrameIcon(new ImageIcon("C:\\Pos\\data\\imagenes\\caja\\icono.png"));
        tablaCaja2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        limpiaCampos();

    }

    public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);

    }

    void limpiaCampos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaCaja2.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        recibi2.setText("");
        cambio2.setText("");
        total2.setText("0.0");
        fecha.setText("");
        fecha.setText(fechaactual());
        OpcionesVen.numeros3();

        if (ventas.CajaAd1.getTablaCaja() != null) {
            OpcionesVen.numeros();
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
        jPanel2 = new javax.swing.JPanel();
        recibi2 = new app.bolivia.swing.JCTextField();
        codigoL6 = new javax.swing.JLabel();
        cambio2 = new app.bolivia.swing.JCTextField();
        codigoL7 = new javax.swing.JLabel();
        buscar2 = new app.bolivia.swing.JCTextField();
        codigoL8 = new javax.swing.JLabel();
        fecha = new app.bolivia.swing.JCTextField();
        codigoL5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        vender = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCaja2 = new javax.swing.JTable();
        total2 = new app.bolivia.swing.JCTextField();
        codigoL3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        numFac2 = new app.bolivia.swing.JCTextField();
        codigoL4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("CAJA DE CORBO");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recibi2.setBackground(new java.awt.Color(34, 102, 145));
        recibi2.setBorder(null);
        recibi2.setForeground(new java.awt.Color(255, 255, 255));
        recibi2.setFocusCycleRoot(true);
        recibi2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        recibi2.setOpaque(false);
        recibi2.setPhColor(new java.awt.Color(255, 255, 255));
        recibi2.setPlaceholder("RECIBI");
        recibi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibi2ActionPerformed(evt);
            }
        });
        recibi2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                recibi2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                recibi2KeyReleased(evt);
            }
        });
        jPanel2.add(recibi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 190, 80));

        codigoL6.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\recibi.png")); // NOI18N
        codigoL6.setToolTipText("RECIBI");
        jPanel2.add(codigoL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 260, 110));

        cambio2.setEditable(false);
        cambio2.setBackground(new java.awt.Color(34, 102, 145));
        cambio2.setBorder(null);
        cambio2.setForeground(new java.awt.Color(255, 255, 255));
        cambio2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cambio2.setOpaque(false);
        cambio2.setPhColor(new java.awt.Color(255, 255, 255));
        cambio2.setPlaceholder("CAMBIO");
        cambio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambio2ActionPerformed(evt);
            }
        });
        jPanel2.add(cambio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 190, 70));

        codigoL7.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\cambio.png")); // NOI18N
        codigoL7.setToolTipText("CAMBIO");
        jPanel2.add(codigoL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 260, 110));

        buscar2.setBackground(new java.awt.Color(34, 102, 145));
        buscar2.setBorder(null);
        buscar2.setForeground(new java.awt.Color(255, 255, 255));
        buscar2.setFocusCycleRoot(true);
        buscar2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        buscar2.setOpaque(false);
        buscar2.setPhColor(new java.awt.Color(255, 255, 255));
        buscar2.setPlaceholder("BUSCAR");
        buscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar2ActionPerformed(evt);
            }
        });
        buscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscar2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar2KeyReleased(evt);
            }
        });
        jPanel2.add(buscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 60));

        codigoL8.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\buscar2_1.png")); // NOI18N
        codigoL8.setToolTipText("RECIBI");
        jPanel2.add(codigoL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 100));

        fecha.setEditable(false);
        fecha.setBackground(new java.awt.Color(34, 102, 145));
        fecha.setBorder(null);
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setFocusCycleRoot(true);
        fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fecha.setOpaque(false);
        fecha.setPhColor(new java.awt.Color(255, 255, 255));
        fecha.setPlaceholder("FECHA");
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });
        jPanel2.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 180, -1));

        codigoL5.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\fecha.png")); // NOI18N
        jPanel2.add(codigoL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, 52));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        vender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vender.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\venta2.png")); // NOI18N
        vender.setBorder(null);
        vender.setContentAreaFilled(false);
        vender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vender.setRolloverIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\venta1.png")); // NOI18N
        vender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderActionPerformed(evt);
            }
        });
        vender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                venderKeyPressed(evt);
            }
        });

        borrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        borrar.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\elimina2.png")); // NOI18N
        borrar.setBorder(null);
        borrar.setContentAreaFilled(false);
        borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setRolloverIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\elimina1.png")); // NOI18N
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\cancela2.png")); // NOI18N
        cancelar.setBorder(null);
        cancelar.setContentAreaFilled(false);
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setRolloverIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\cancela1.png")); // NOI18N
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("SURTIFRUVER LA PLACITA BOYACENCE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vender)
                    .addComponent(borrar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(vender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCaja2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tablaCaja2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "TIPO ALIMENTO", "DESCRIPCIÓN", "PRECIO $", "CANTIDAD", "IMPORTE $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCaja2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaCaja2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaCaja2KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCaja2);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 350));

        total2.setEditable(false);
        total2.setBackground(new java.awt.Color(34, 102, 145));
        total2.setBorder(null);
        total2.setForeground(new java.awt.Color(255, 255, 255));
        total2.setFont(new java.awt.Font("Tahoma", 1, 66)); // NOI18N
        total2.setOpaque(false);
        total2.setPhColor(new java.awt.Color(255, 255, 255));
        total2.setPlaceholder("TOTAL");
        total2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total2ActionPerformed(evt);
            }
        });
        jPanel4.add(total2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 330, 90));

        codigoL3.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\total.png")); // NOI18N
        jPanel4.add(codigoL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 590, 200));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\principal\\norm.png")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Central de abastos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TELEFONOS:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numFac2.setEditable(false);
        numFac2.setBackground(new java.awt.Color(34, 102, 145));
        numFac2.setBorder(null);
        numFac2.setForeground(new java.awt.Color(255, 255, 255));
        numFac2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numFac2.setOpaque(false);
        numFac2.setPhColor(new java.awt.Color(255, 255, 255));
        numFac2.setPlaceholder("FACTURA");
        jPanel6.add(numFac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, 30));

        codigoL4.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\numFac.png")); // NOI18N
        jPanel6.add(codigoL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("NÚMERO DE VENTA");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
alimentos.ListaAlimentosAd1 la;
    private void venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderActionPerformed
        System.out.println("antes del if " + tablaCaja2.getRowCount());
        if (tablaCaja2.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Imposible realizar venta.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            VentasCod vc = new VentasCod();
            vc.setPrimaryKey(numFac2.getText());
            System.out.println("valor total: sin convertir " + total2.getText());
            vc.setTotal(total2.getText().replaceAll("\\.", ""));
            vc.setFecha(fecha.getText());
            int opcion = OpcionesVen.registrar(vc);
            if (opcion != 0) {
                Impresora1 impresora = new Impresora1();
                System.out.println("antes de ingesar a clase de imprimir, cantidad de filas " + tablaCaja2.getRowCount());
                impresora.imprimirTicket(total2.getText(), total2.getText(), recibi2.getText(), cambio2.getText());

                JOptionPane.showMessageDialog(this, "Venta realizada.", "Caja de cobro", 0,
                        new ImageIcon("C:\\Pos\\data\\imagenes\\caja\\ralizada.png"));
                limpiaCampos();
                if (principal.MenuPrincipalAd.cerra1) {
                    OpcionesVen.listar("");
                }
            }
        }
        vender.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\venta2.png"));
    }//GEN-LAST:event_venderActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        Date sistemaHora = new Date();
        String pmAm = "hh";
        SimpleDateFormat formato = new SimpleDateFormat(pmAm);
        Calendar now = Calendar.getInstance();
        String hourActual = String.format(formato.format(sistemaHora), now);

        Date sistemaFech = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyy");
        //this.fecha.setText(formato.format(sistemaFech));
        int claveSys = Integer.parseInt(formatoFecha.format(sistemaFech) + hourActual);
        if (principal.MenuPrincipalAd.rol.equalsIgnoreCase("ADMINISTRADOR")) {
            if (tablaCaja2.getRowCount() > 0) {
                DefaultTableModel modelo = (DefaultTableModel) tablaCaja2.getModel();
                int fila = tablaCaja2.getSelectedRow();
                if (fila >= 0) {
                    modelo.removeRow(fila);
                    ListaAlimentosAd1 la = new ListaAlimentosAd1();
                    la.calcularEliminar();
                } else {
                    JOptionPane.showMessageDialog(this, "Seleccione una fila.", "Caja de cobro", 0,
                            new ImageIcon("C:\\Pos\\data\\imagenes\\usuarios\\info.png"));
                }
            } else {
                JOptionPane.showMessageDialog(this, "No hay registros\npara eliminar.", "Caja de cobro", 0,
                        new ImageIcon("C:\\Pos\\data\\imagenes\\usuarios\\info.png"));
            }
        } else {
            int clave = Integer.parseInt(JOptionPane.showInputDialog("ingrese clave para acceder a eliminar"));
            if (clave == claveSys) {
                if (tablaCaja2.getRowCount() > 0) {
                    DefaultTableModel modelo = (DefaultTableModel) tablaCaja2.getModel();
                    int fila = tablaCaja2.getSelectedRow();
                    if (fila >= 0) {
                        modelo.removeRow(fila);
                        ListaAlimentosAd1 la = new ListaAlimentosAd1();
                        la.calcularEliminar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Seleccione una fila.", "Caja de cobro", 0,
                                new ImageIcon("C:\\Pos\\data\\imagenes\\usuarios\\info.png"));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay registros\npara eliminar.", "Caja de cobro", 0,
                            new ImageIcon("C:\\Pos\\data\\imagenes\\usuarios\\info.png"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Clave erronea");
            }
        }

    }//GEN-LAST:event_borrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        Date sistemaHora = new Date();
        String pmAm = "hh";
        SimpleDateFormat formato = new SimpleDateFormat(pmAm);
        Calendar now = Calendar.getInstance();
        String hourActual = String.format(formato.format(sistemaHora), now);

        Date sistemaFech = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyy");
        //this.fecha.setText(formato.format(sistemaFech));
        int claveSys = Integer.parseInt(formatoFecha.format(sistemaFech) + hourActual);
        if (principal.MenuPrincipalAd.rol.equalsIgnoreCase("ADMINISTRADOR")) {
            limpiaCampos();
        } else {
            int clave = Integer.parseInt(JOptionPane.showInputDialog("ingrese clave para acceder a eliminar"));
            if (clave == claveSys) {
                limpiaCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Clave erronea");
            }
        }


    }//GEN-LAST:event_cancelarActionPerformed

    private void recibi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recibi2ActionPerformed

    private void buscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_buscar2ActionPerformed

    private void cambio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cambio2ActionPerformed

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void buscar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar2KeyPressed
        // TODO add your handling code here:
        double peso = 0.0;
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            System.err.println("se ha oprimido enter");
            String[] datos = OpcionesAl.bucaProducto(buscar2.getText());
            if (datos == null) {
                if (estacerrado(la)) {
                    la = new ListaAlimentosAd1();
                    principal.MenuPrincipalAd.escritorio.add(la);
                    la.toFront();
                    la.setVisible(true);
                    la.getBuscar().setText(this.buscar2.getText());
                    this.buscar2.setText("");
                    la.getBuscar().requestFocus();
                } else {
                    //  JOptionPane.showMessageDialog(this, "La ventana LISTA DE PRODUCTOS\nya esta abierta !!!", "Aviso", 0,
                    //     new ImageIcon(getClass().getResource("/imagenes/principal/adver.png")));
                    la.setVisible(true);
                    la.getBuscar().requestFocus();
                }

            } else if (datos[1].equalsIgnoreCase("BASCULA")) {
                ingresarBascula(datos);
                this.buscar2.setText("");
                this.buscar2.requestFocus();
            } else if (datos[1].equalsIgnoreCase("VALOR")) {
                ingresarValor(datos);
                this.buscar2.setText("");
                this.buscar2.requestFocus();
            } else if (datos[1].equalsIgnoreCase("CANTIDAD") || datos[1].equalsIgnoreCase("GALGUERIA")) {
                ingresarCantidad(datos);
                this.buscar2.setText("");
                this.buscar2.requestFocus();
            }

        } else if (evt.getKeyCode() == 39) {

            System.out.println("se primio tecla tabualdor");
            this.recibi2.requestFocus();

        } else if (evt.getKeyCode() == 107) {

            System.err.println("se ha oprimido suma");

            String[] datos = OpcionesAl.bucaProducto(buscar2.getText());
            //this.buscar.setText("");
            if (datos == null) {
                if (estacerrado(la)) {
                    la = new ListaAlimentosAd1();
                    principal.MenuPrincipalAd.escritorio.add(la);
                    la.toFront();
                    la.setVisible(true);
                    la.getBuscar().setText(this.buscar2.getText());
                    this.buscar2.setText("");
                    la.getBuscar().requestFocus();
                } else {
                    //  JOptionPane.showMessageDialog(this, "La ventana LISTA DE PRODUCTOS\nya esta abierta !!!", "Aviso", 0,
                    //     new ImageIcon(getClass().getResource("/imagenes/principal/adver.png")));
                    la.setVisible(true);
                    la.getBuscar().requestFocus();
                    this.buscar2.setText("");
                }

            } else if (datos[1].equalsIgnoreCase("BASCULA")) {
                ingresarBasculaSuma(datos);
                this.buscar2.requestFocus();
                this.buscar2.setText("");
                // this.buscar.setText(this.buscar.getText().replaceAll("\\+",""));

            } else if (datos[1].equalsIgnoreCase("VALOR")) {
                ingresarValor(datos);
                this.buscar2.setText("");
                this.buscar2.requestFocus();
            } else if (datos[1].equalsIgnoreCase("CANTIDAD") || datos[1].equalsIgnoreCase("GALGUERIA")) {
                ingresarCantidad(datos);
                this.buscar2.setText("");
                this.buscar2.requestFocus();
            }
        }
        // System.err.println("evento teclado es "+evt.getKeyCode() );

        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            System.out.println("se ha oprimido f10");
            AperturaCaja aperturaCaja = new AperturaCaja();
            aperturaCaja.apertura();
        }


    }//GEN-LAST:event_buscar2KeyPressed

    private void total2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total2ActionPerformed

    private void buscar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar2KeyReleased
        // TODO add your handling code here:
        buscar2.setText(buscar2.getText().toUpperCase());
    }//GEN-LAST:event_buscar2KeyReleased

    private void recibi2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recibi2KeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {

            //calculo.requestFocus();
            if (tablaCaja2.getRowCount() < 1) {
                JOptionPane.showMessageDialog(this, "Imposible realizar operación.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (recibi2.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor.", "Caja de cobro", 0,
                        new ImageIcon("C:\\Pos\\data\\imagenes\\usuarios\\info.png"));
            } else {
                double recibe = Double.parseDouble(recibi2.getText());
                String valorTotal = total2.getText().replaceAll("\\.", "");
                System.out.println("valor total es " + valorTotal + " valor anterior es " + total2.getText());
                double tota = Integer.parseInt(valorTotal);

                if (recibe < tota) {
                    JOptionPane.showMessageDialog(this, "Ingrese un valor valido.", "Caja de cobro", 0,
                            new ImageIcon("/C:\\Pos\\data\\imagenes\\usuarios\\info.png"));
                } else {

                    DecimalFormat formatea = new DecimalFormat("###,###.##");
                    this.cambio2.setText(formatea.format(recibe - tota));
                    vender.setFocusable(true);
                    vender.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\venta1.png"));

                    if (JOptionPane.showConfirmDialog(null, "¿Desea realizar venta?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {

                        vender.doClick();

                    } else {
                        buscar2.requestFocus();
                    }

                }
            }

        } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_TAB) {
            //   calculo.setIcon(new javax.swing.ImageIcon("C:\\Pos\\data\\imagenes\\caja\\calculo1.png"));
            // calculo.setFocusable(true);

        }

    }//GEN-LAST:event_recibi2KeyPressed

    private void tablaCaja2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaCaja2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaCaja2KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_formKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void venderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_venderKeyPressed
        // TODO add your handling code here:
        System.out.println("ventas.CajaAd1.venderKeyPressed()");
    }//GEN-LAST:event_venderKeyPressed

    private void recibi2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recibi2KeyReleased
        // TODO add your handling code here:
        // recibi.setText(formatea.format(recibi.getText()));
        //  System.out.println("ventas.CajaAd.recibiKeyReleased()");
    }//GEN-LAST:event_recibi2KeyReleased
    public void ingresarBascula(String datos[]) {
        DefaultTableModel tabladet = (DefaultTableModel) tablaCaja2.getModel();
        String[] dato = new String[6];
        int c = 0;
        int j = 0;

        try {
            BasculaIni basculaIni = new BasculaIni();
            double valorPeso = Double.parseDouble(basculaIni.lecturaFija());
            //alerta de modificacion de datos quemados
            // double valorPeso=5.61321;
            if (valorPeso <= 0) {
                JOptionPane.showMessageDialog(null, "verificar peso no acepta valores en cero o menores que cero");
                return;
            } else {
                System.out.println("else donde el valor de peso de bascula es diferente de 0");

                for (int i = 0; i < tablaCaja2.getRowCount(); i++) {
                    Object com = tablaCaja2.getValueAt(i, 0);
                    Object cant1 = tablaCaja2.getValueAt(i, 4);
                    System.out.println("valor com " + com);
                    if (datos[0].equals(com)) {
                        System.out.println("INGRESO IF DONDE SUMA CANTIDA Y PESO DE PRODUCTO YA PESADO");
                        j = i;
                        double cantT = valorPeso;
                        tablaCaja2.setValueAt(cantT, i, 4);
                        c++;
                        calcularBascula();
                        recibi2.setText("");
                        cambio2.setText("");
                    }

                }
                System.out.println("valor de c= " + c);
                if (c == 0) {
                    System.out.println("if donde compara c==0 con abscula");
                    dato[0] = datos[0];
                    dato[1] = datos[1];
                    dato[2] = datos[2];
                    dato[3] = formatea.format(Double.parseDouble(datos[3]));
                    dato[4] = valorPeso + "";

                    tabladet.addRow(dato);

                    tablaCaja2.setModel(tabladet);
                    calcularBascula();

                    CajaAd1.recibi2.setText("");
                    CajaAd1.cambio2.setText("");
                }
            }
        } catch (Exception e) {
            buscar2.setText("");
            System.out.println("ingreso a execpcion de enter para bascula");

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void calcularBascula() {
        String pre;
        String can;
        double total = 0;
        double precio;
        double cantidad;
        double imp = 0.0;
        System.err.println("coma encontrada en " + imp);
        for (int i = 0; i < tablaCaja2.getRowCount(); i++) {
            pre = tablaCaja2.getValueAt(i, 3).toString().replaceAll("\\.", "");
            can = tablaCaja2.getValueAt(i, 4).toString().replaceAll("\\,", "");
            precio = Double.parseDouble(pre);
            cantidad = Double.parseDouble(can);
            if (ventas.CajaAd1.tablaCaja2.getValueAt(i, 1).toString().equalsIgnoreCase("VALOR")) {
                cantidad = Integer.parseInt((can + "").replaceAll("\\.", ""));
                imp = cantidad;
            } else {
                imp = precio * cantidad;

            }
            total = total + redondear((int) imp);
            tablaCaja2.setValueAt(formatea.format(Math.rint(redondear((int) imp) * 100) / 100), i, 5);

        }
        this.total2.setText("" + formatea.format(Math.rint(total * 100) / 100));
        this.buscar2.setText("");

    }

    public int redondear(int numero) {
        String cadena = numero + "";
        String redondeado = "";
        System.out.println(cadena.substring(0, cadena.length() - 2));
        if (cadena.length() > 2) {
            int numero2 = Integer.parseInt(cadena.substring(0, cadena.length() - 2));
            int numero3 = Integer.parseInt((cadena.substring(cadena.length() - 2, cadena.length())));

            if (numero3 < 25) {
                redondeado = "00";
            } else if (numero3 >= 25 && numero3 <= 50) {
                redondeado = "50";
            } else if (numero3 < 75 && numero3 > 50) {
                redondeado = "50";
            } else if (numero3 >= 75) {
                redondeado = "00";
                numero2 += 1;
            }
            //System.err.println("numero redondeado es "+(numero2+redondeado));

            return Integer.parseInt(numero2 + redondeado);

        } else {
            return numero;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    public static app.bolivia.swing.JCTextField buscar2;
    public static app.bolivia.swing.JCTextField cambio2;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel codigoL3;
    private javax.swing.JLabel codigoL4;
    private javax.swing.JLabel codigoL5;
    private javax.swing.JLabel codigoL6;
    private javax.swing.JLabel codigoL7;
    private javax.swing.JLabel codigoL8;
    private app.bolivia.swing.JCTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static app.bolivia.swing.JCTextField numFac2;
    public static app.bolivia.swing.JCTextField recibi2;
    public static javax.swing.JTable tablaCaja2;
    public static app.bolivia.swing.JCTextField total2;
    private javax.swing.JButton vender;
    // End of variables declaration//GEN-END:variables

    private void ingresarValor(String[] datos) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String cant = null;
        String[] dato = new String[6];
        int c = 0;
        int j = 0;
        DefaultTableModel tabladet = (DefaultTableModel) ventas.CajaAd1.tablaCaja2.getModel();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cant = JOptionPane.showInputDialog(this, "VALOR:", "Productos", JOptionPane.INFORMATION_MESSAGE);

        while (!OpcionesAl.isNumber(cant) && cant != null) {
            cant = JOptionPane.showInputDialog(this, "Debe ingresar valores numericos\ny que sean mayor a 0:",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        if ((cant.equals("")) || (cant.equals("0"))) {
            JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
        } else {
            for (int i = 0; i < ventas.CajaAd1.tablaCaja2.getRowCount(); i++) {
                Object com = ventas.CajaAd1.tablaCaja2.getValueAt(i, 0);
                Object cant1 = ventas.CajaAd1.tablaCaja2.getValueAt(i, 4).toString().replaceAll("\\.", "");
                if (datos[0].equals(com)) {
                    j = i;
                    int cantT = Integer.parseInt(cant) + Integer.parseInt((String) cant1);
                    ventas.CajaAd1.tablaCaja2.setValueAt(formatea.format(cantT), i, 4);
                    c++;
                    calcular();
                    ventas.CajaAd1.recibi2.setText("");
                    ventas.CajaAd1.cambio2.setText("");
                }
            }
            if (c == 0) {

                dato[0] = datos[0];
                dato[1] = datos[1];
                dato[2] = datos[2];
                //System.out.println("datos venta"+datos[3]);
                dato[3] = formatea.format(Double.parseDouble(datos[3]));
                dato[4] = cant;

                tabladet.addRow(dato);

                ventas.CajaAd1.tablaCaja2.setModel(tabladet);
                calcular();

                ventas.CajaAd1.recibi2.setText("");
                ventas.CajaAd1.cambio2.setText("");
            }
        }
    }

    private void ingresarCantidad(String[] datos) {
        String cant = null;
        String[] dato = new String[6];
        int c = 0;
        int j = 0;
        DefaultTableModel tabladet = (DefaultTableModel) ventas.CajaAd1.tablaCaja2.getModel();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cant = JOptionPane.showInputDialog(this, "Cantidad:", "Productos", JOptionPane.INFORMATION_MESSAGE);

        while (!OpcionesAl.isNumber(cant) && cant != null) {
            cant = JOptionPane.showInputDialog(this, "Debe ingresar valores numericos\ny que sean mayor a 0:",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        if ((cant.equals("")) || (cant.equals("0"))) {
            JOptionPane.showMessageDialog(this, "Debe ingresar cantidad mayor que 0");
        } else {
            for (int i = 0; i < ventas.CajaAd1.tablaCaja2.getRowCount(); i++) {
                Object com = ventas.CajaAd1.tablaCaja2.getValueAt(i, 0);
                Object cant1 = ventas.CajaAd1.tablaCaja2.getValueAt(i, 4);
                if (datos[0].equals(com)) {
                    j = i;
                    int cantT = Integer.parseInt(cant) + Integer.parseInt((String) cant1);
                    ventas.CajaAd1.tablaCaja2.setValueAt(formatea.format(cantT), i, 4);
                    c++;
                    calcular();
                    ventas.CajaAd1.recibi2.setText("");
                    ventas.CajaAd1.cambio2.setText("");
                }
            }
            if (c == 0) {

                dato[0] = datos[0];
                dato[1] = datos[1];
                dato[2] = datos[2];
                dato[3] = formatea.format(Double.parseDouble(datos[3]));
                dato[4] = cant;

                tabladet.addRow(dato);

                ventas.CajaAd1.tablaCaja2.setModel(tabladet);
                calcular();

                ventas.CajaAd1.recibi2.setText("");
                ventas.CajaAd1.cambio2.setText("");
            }
        }
    }

    public void calcular() {
        String pre;
        String can;
        double total = 0;
        double precio;
        double cantidad = 0;
        double imp = 0.0;

        for (int i = 0; i < ventas.CajaAd1.tablaCaja2.getRowCount(); i++) {
            pre = ventas.CajaAd1.tablaCaja2.getValueAt(i, 3).toString().replaceAll("\\.", "");
            can = ventas.CajaAd1.tablaCaja2.getValueAt(i, 4).toString().replaceAll("\\,", "");
            precio = Double.parseDouble(pre);
            cantidad = Double.parseDouble(can);
            if (ventas.CajaAd1.tablaCaja2.getValueAt(i, 1).toString().equalsIgnoreCase("VALOR")) {
                cantidad = Integer.parseInt((can + "").replaceAll("\\.", ""));
                imp = cantidad;
            } else {
                imp = precio * cantidad;
            }
            total = total + redondear((int) imp);
            ventas.CajaAd1.tablaCaja2.setValueAt(formatea.format(Math.rint(redondear((int) imp) * 100) / 100), i, 5);

        }
        ventas.CajaAd1.total2.setText("" + formatea.format(Math.rint(total * 100) / 100));

    }

    public static JTable getTablaCaja() {
        return tablaCaja2;
    }

    public static void setTablaCaja(JTable tablaCaja) {
        CajaAd1.tablaCaja2 = tablaCaja;
    }

    public static JCTextField getCambio() {
        return cambio2;
    }

    public static void setCambio(JCTextField cambio) {
        CajaAd1.cambio2 = cambio;
    }

    public JCTextField getFecha() {
        return fecha;
    }

    public void setFecha(JCTextField fecha) {
        this.fecha = fecha;
    }

    public static JCTextField getNumFac() {
        return numFac2;
    }

    public static void setNumFac(JCTextField numFac) {
        CajaAd1.numFac2 = numFac;
    }

    public static JCTextField getRecibi() {
        return recibi2;
    }

    public static void setRecibi(JCTextField recibi) {
        CajaAd1.recibi2 = recibi;
    }

    public static JCTextField getTotal() {
        return total2;
    }

    public static void setTotal(JCTextField total) {
        CajaAd1.total2 = total;
    }

    public JButton getVender() {
        return vender;
    }

    public void setVender(JButton vender) {
        this.vender = vender;
    }

}
