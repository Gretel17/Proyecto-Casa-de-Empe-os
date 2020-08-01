package proyectocasaempeños;

public class Menu extends javax.swing.JFrame {
    
    public Menu() {
        
        initComponents();
        
        
    }
    
    public static Integer idEmpleado, idPuestoEmpleado;
    public static String nombreCompletoEmpleado, numeroIdentidadEmpleado;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuarioLinea = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JPanel();
        btnIngresarEmpeño = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnIngresarCompra = new javax.swing.JButton();
        btnIngresarVenta = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnPagarEmpeño = new javax.swing.JButton();
        btnGenerarReporte = new javax.swing.JButton();
        btnCerrarSesión = new javax.swing.JButton();
        btnIngresarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Casa de Empeños Gómez");
        setResizable(false);

        jLabel1.setText("Usuario en línea:");

        lblUsuarioLinea.setText("   ");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/empleado-mini.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuarioLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuarioLinea))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrincipal.setMinimumSize(new java.awt.Dimension(768, 384));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(768, 384));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresarEmpeño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/empeno.png"))); // NOI18N
        btnIngresarEmpeño.setText("Ingresar empeño");
        pnlPrincipal.add(btnIngresarEmpeño, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 248, -1));

        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/empleado.png"))); // NOI18N
        btnUsuario.setText("Usuario");
        pnlPrincipal.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 128, 248, -1));

        btnIngresarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/compra.png"))); // NOI18N
        btnIngresarCompra.setText("Ingresar compra");
        btnIngresarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarCompraActionPerformed(evt);
            }
        });
        pnlPrincipal.add(btnIngresarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 250, 248, -1));

        btnIngresarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/venta.png"))); // NOI18N
        btnIngresarVenta.setText("Ingresar venta");
        pnlPrincipal.add(btnIngresarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, 248, -1));

        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/inventario.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        pnlPrincipal.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 248, -1));

        btnPagarEmpeño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/pagar.png"))); // NOI18N
        btnPagarEmpeño.setText("Pagar empeño");
        btnPagarEmpeño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarEmpeñoActionPerformed(evt);
            }
        });
        pnlPrincipal.add(btnPagarEmpeño, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 128, 248, -1));

        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/reporte.png"))); // NOI18N
        btnGenerarReporte.setText("Generar reporte");
        pnlPrincipal.add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 6, 248, -1));

        btnCerrarSesión.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/salir.png"))); // NOI18N
        btnCerrarSesión.setText("Cerrar sesión");
        btnCerrarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesiónActionPerformed(evt);
            }
        });
        pnlPrincipal.add(btnCerrarSesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 250, 248, -1));

        btnIngresarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/nuevo-usuario.png"))); // NOI18N
        btnIngresarCliente.setText("Ingresar cliente");
        pnlPrincipal.add(btnIngresarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 6, 248, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnCerrarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesiónActionPerformed
        
        InicioSesion inicioSesion = new InicioSesion();
        
        inicioSesion.setVisible( true );
        
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesiónActionPerformed

    private void btnIngresarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarCompraActionPerformed
        
        IngresarCompras ingresarCompras = new IngresarCompras();
        
        ingresarCompras.idEmpleado = idEmpleado;
        ingresarCompras.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnIngresarCompraActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        
        System.out.println(numeroIdentidadEmpleado);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnPagarEmpeñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarEmpeñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarEmpeñoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesión;
    public static javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnIngresarCliente;
    private javax.swing.JButton btnIngresarCompra;
    private javax.swing.JButton btnIngresarEmpeño;
    private javax.swing.JButton btnIngresarVenta;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnPagarEmpeño;
    public static javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblUsuarioLinea;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}