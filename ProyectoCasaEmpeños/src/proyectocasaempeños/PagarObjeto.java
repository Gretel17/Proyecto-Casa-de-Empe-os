/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocasaempeños;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisf
 */
public class PagarObjeto extends javax.swing.JFrame {

    /**
     * Creates new form PagarObjeto
     */
    public PagarObjeto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.txtFecha.setText( fechaHoy.format( actual ) );
        CompartirDatos();
    }

    DateTimeFormatter fechaHoy = DateTimeFormatter.ofPattern( "dd/MM/yyyy H:mm:ss" ); 
    LocalDateTime actual = LocalDateTime.now();
        
    Conexion con = new Conexion();
    Integer NumContrato = null;
    
    public void CompartirDatos()
    {      
        CompartirDatosEmpeño datos = new CompartirDatosEmpeño();
        
        this.NumContrato = datos.id_contrato;
        this.txtIdentidadCliente.setText( datos.identidad ); 
        this.txtNombreCliente.setText( datos.nombre );
        this.txtApellidoCliente.setText( datos.apellido );
        this.txtFechaInicial.setText( datos.fecha_inicio );
        this.txtFechaFinal.setText( datos.fecha_final );
        this.txtMonto.setText( String.valueOf(datos.monto) );
        if( this.txtMonto.getText().equals("null") ){
            this.txtMonto.setText(null);
        }else{
            this.txtMonto.setText( String.valueOf(datos.monto) );
        }
        
        if (datos.datos_llenos == true)
        {
            this.chkGerarFactura.setEnabled(true);
            this.btnPagar.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            con.llenarTablaDetalleContratos(tblDetalleEmpleños, NumContrato);
        }
    }
    
    private void Limpiar() {
        this.NumContrato = 0;
        this.txtIdentidadCliente.setText( null ); 
        this.txtNombreCliente.setText( null );
        this.txtApellidoCliente.setText( null );
        this.txtFechaInicial.setText( null );
        this.txtFechaFinal.setText( null );
        this.txtMonto.setText( null );
        
        CompartirDatosEmpeño datos = new CompartirDatosEmpeño();
        
        datos.datos_llenos = false; 
        datos.id_contrato = null;
        datos.identidad = null;
        datos.nombre = null;
        datos.apellido = null;
        datos.fecha_inicio = "";
        datos.fecha_final = "";
        datos.monto = null;
    }
    
    private void Clear_Table(){
        DefaultTableModel modelo = (DefaultTableModel) this.tblDetalleEmpleños.getModel();
        for (int i = 0; i < this.tblDetalleEmpleños.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }
    }
    
    private void mostrarArticulosDialog() {
        for( int indiceTblDetalleEmpeños=0; indiceTblDetalleEmpeños < this.tblDetalleEmpleños.getRowCount(); indiceTblDetalleEmpeños++ ){
            this.tblDetalleEmpleños.getValueAt(indiceTblDetalleEmpeños, 1);
            this.tblDetalleEmpleños.getValueAt(indiceTblDetalleEmpeños, 2);
        }
    }
    
    private void ImprimirFactura(){
        
        JTextArea paginaImprimir = new JTextArea();
        
        paginaImprimir.setText( "\n\t\tCASA DE EMPEÑOS GÓMEZ \n" );
        paginaImprimir.setText( paginaImprimir.getText() + "\nNúmero de identidad: " + this.txtIdentidadCliente.getText() );
        paginaImprimir.setText( paginaImprimir.getText() + "\nNombre: " + this.txtNombreCliente.getText() + " " + this.txtApellidoCliente.getText() );
        paginaImprimir.setText( paginaImprimir.getText() + "\nFecha del pago: " + this.txtFecha.getText() );
        paginaImprimir.setText( paginaImprimir.getText() + "\n\nArtículos: \n" );
        paginaImprimir.setText( paginaImprimir.getText() + "--------------------------------------------------------------\n" );
        paginaImprimir.setText( paginaImprimir.getText() + "Nombre \t\tCantidad\n" );
        paginaImprimir.setText( paginaImprimir.getText() + "--------------------------------------------------------------" );
        
        for( int indiceTblDetalleEmpeños=0; indiceTblDetalleEmpeños < this.tblDetalleEmpleños.getRowCount(); indiceTblDetalleEmpeños++ ){
            
            paginaImprimir.setText( paginaImprimir.getText() + "\n" + this.tblDetalleEmpleños.getValueAt(indiceTblDetalleEmpeños, 1) + "\t\t" + this.tblDetalleEmpleños.getValueAt(indiceTblDetalleEmpeños, 2)  );
        }
        
        paginaImprimir.setText( paginaImprimir.getText() + "\n--------------------------------------------------------------" );
        paginaImprimir.setText( paginaImprimir.getText() + "\nMonto acordado: L." + this.txtMonto.getText() );
        
        try{
            
            paginaImprimir.print();
        }
        catch( Exception e ){}
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
        btnVolver = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleEmpleños = new javax.swing.JTable();
        btnBuscarEmpeño = new javax.swing.JButton();
        lblIdentidad = new javax.swing.JLabel();
        txtIdentidadCliente = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JTextField();
        lblFechaInicial = new javax.swing.JLabel();
        lblFechaFinal = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtFechaFinal = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtFechaInicial = new javax.swing.JTextField();
        chkGerarFactura = new javax.swing.JCheckBox();
        txtFecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagar Objeto Empeñado");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(770, 440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnVolver.setText("Regresar");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Pagar objeto empeñado");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        btnPagar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setEnabled(false);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, 30));

        tblDetalleEmpleños.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblDetalleEmpleños.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código producto", "Producto", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleEmpleños.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalleEmpleños.getTableHeader().setReorderingAllowed(false);
        tblDetalleEmpleños.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleEmpleñosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalleEmpleños);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 730, 160));

        btnBuscarEmpeño.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnBuscarEmpeño.setText("Buscar empeño");
        btnBuscarEmpeño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpeñoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarEmpeño, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, 40));

        lblIdentidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblIdentidad.setText("Número de identidad: ");
        jPanel1.add(lblIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 85, -1, -1));

        txtIdentidadCliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtIdentidadCliente.setEnabled(false);
        txtIdentidadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentidadClienteActionPerformed(evt);
            }
        });
        txtIdentidadCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentidadClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtIdentidadCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 80, 160, -1));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblNombre.setText("Nombre: ");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 85, -1, -1));

        txtNombreCliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombreCliente.setEnabled(false);
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 120, -1));

        lblApellido.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblApellido.setText("Apellido: ");
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 85, -1, -1));

        txtApellidoCliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtApellidoCliente.setEnabled(false);
        txtApellidoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 120, -1));

        lblFechaInicial.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblFechaInicial.setText("Fecha inicial: ");
        jPanel1.add(lblFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 125, -1, -1));

        lblFechaFinal.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblFechaFinal.setText("Fecha final: ");
        jPanel1.add(lblFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 125, -1, -1));

        lblMonto.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblMonto.setText("Monto: ");
        jPanel1.add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 165, -1, -1));

        txtFechaFinal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFechaFinal.setEnabled(false);
        txtFechaFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaFinalKeyTyped(evt);
            }
        });
        jPanel1.add(txtFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 120, -1));

        txtMonto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtMonto.setEnabled(false);
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 160, 120, -1));

        txtFechaInicial.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFechaInicial.setEnabled(false);
        txtFechaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaInicialKeyTyped(evt);
            }
        });
        jPanel1.add(txtFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 120, 120, -1));

        chkGerarFactura.setText("Generar factura");
        chkGerarFactura.setEnabled(false);
        jPanel1.add(chkGerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 405, -1, -1));

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFecha.setEnabled(false);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 150, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Fecha:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 25, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        
        if( this.chkGerarFactura.isSelected() ){
            ImprimirFactura();
            con.PagarEmpeño(NumContrato);
            this.chkGerarFactura.setSelected(false);
            Limpiar();
            Clear_Table();
            this.btnCancelar.setEnabled(false);
            this.btnPagar.setEnabled(false);
            this.chkGerarFactura.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "\t\tCASA DE EMPEÑOS GÓMEZ \n"
                    + "\nNúmero de identidad: "+ this.txtIdentidadCliente.getText() + "\nNombre: " + this.txtNombreCliente.getText() + " " + this.txtApellidoCliente.getText() 
                    + "\nFecha inicial: " + this.txtFechaFinal.getText() + "\nFecha final: " + this.txtFechaFinal.getText()
                    + "\nFecha del pago: " + this.txtFecha.getText() + "\nCantidad de articulos: " + this.tblDetalleEmpleños.getRowCount()
                    + "\nMonto acordado: L." + this.txtMonto.getText() );
            con.PagarEmpeño(NumContrato);
            Limpiar();
            Clear_Table();
            this.btnCancelar.setEnabled(false);
            this.btnPagar.setEnabled(false);
            this.chkGerarFactura.setEnabled(false);
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void tblDetalleEmpleñosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleEmpleñosMouseClicked
        
    }//GEN-LAST:event_tblDetalleEmpleñosMouseClicked

    private void btnBuscarEmpeñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpeñoActionPerformed
        BusquedaContratos contratos = new BusquedaContratos();
        contratos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarEmpeñoActionPerformed

    private void txtIdentidadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentidadClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentidadClienteActionPerformed

    private void txtIdentidadClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentidadClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentidadClienteKeyTyped

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void txtApellidoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoClienteKeyTyped

    private void txtFechaFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaFinalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinalKeyTyped

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoKeyTyped

    private void txtFechaInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaInicialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicialKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
        Clear_Table();
        this.btnCancelar.setEnabled(false);
        this.btnPagar.setEnabled(false);
        this.chkGerarFactura.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(PagarObjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagarObjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagarObjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagarObjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagarObjeto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEmpeño;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkGerarFactura;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblFechaFinal;
    private javax.swing.JLabel lblFechaInicial;
    private javax.swing.JLabel lblIdentidad;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblDetalleEmpleños;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtFechaInicial;
    private javax.swing.JTextField txtIdentidadCliente;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
