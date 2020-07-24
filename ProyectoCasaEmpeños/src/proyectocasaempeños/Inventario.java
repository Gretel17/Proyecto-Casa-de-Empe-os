/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocasaempeños;


//inventarioo
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisf
 */
public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    public Inventario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.txtNombreProducto.setTransferHandler(null);
        this.txtPrecioVenta.setTransferHandler(null);
        this.txtCantidad.setTransferHandler(null);
        this.txtBuscar.setTransferHandler(null);
        con.llenarCmbEstadoObjetos(cmbEstado);
        con.llenarTablaInventario(tblInventario);
        //this.tblInventario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //con.AjustarAutomaticamenteAnchoColumna(this.tblInventario);
        this.tblInventario.getColumn(tblInventario.getColumnName(0)).setWidth(0);
        //this.tblInventario.getColumn(0).setWidth(0);
    }

    Conexion con = new Conexion();
    java.util.Date d = new java.util.Date();  
    SimpleDateFormat plantilla = new SimpleDateFormat("yyyy/MM/dd H:mm:ss");
    //java.sql.Date fechaActual = new java.sql.Date(d.getTime());
    String fechaActual = plantilla.format(d.getTime());
    
    Integer codigo;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblAvisoPrecio = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        lblNombreProducto1 = new javax.swing.JLabel();
        lblAvisoNombre = new javax.swing.JLabel();
        lblAvisoCantidad = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar/modificar objetos");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Consultar/Modificar objetos");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblCantidad.setText("Cantidad: ");
        jPanel1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 125, -1, -1));

        lblEstado.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblEstado.setText("Estado: ");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 85, -1, -1));

        lblPrecio.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblPrecio.setText("Precio venta: ");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 125, -1, -1));

        lblAvisoPrecio.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        lblAvisoPrecio.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblAvisoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 120, 20));

        cmbEstado.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cmbEstado.setEnabled(false);
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, -1));

        txtNombreProducto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombreProducto.setEnabled(false);
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 180, -1));

        txtPrecioVenta.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPrecioVenta.setEnabled(false);
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 100, -1));

        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCantidad.setEnabled(false);
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 100, -1));

        lblBuscar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblBuscar.setText("Buscar: ");
        jPanel1.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 290, -1));

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 167, -1, 30));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        btnModificar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.setMinimumSize(new java.awt.Dimension(957, 27));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 167, -1, 30));

        tblInventario.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Estado", "Nombre", "Cantidad disponible", "Precio venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInventario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventario);
        if (tblInventario.getColumnModel().getColumnCount() > 0) {
            tblInventario.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblInventario.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblInventario.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 730, 210));

        lblNombreProducto1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblNombreProducto1.setText("Nombre producto: ");
        jPanel1.add(lblNombreProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 85, -1, -1));

        lblAvisoNombre.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        lblAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblAvisoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 100, 20));

        lblAvisoCantidad.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        lblAvisoCantidad.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblAvisoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 120, 20));

        btnConsultar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnConsultar.setText("Consultar todo");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 167, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Clear_Table(){
        DefaultTableModel modelo = (DefaultTableModel) tblInventario.getModel();
        for (int i = 0; i < tblInventario.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
        }
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.txtNombreProducto.setText(null);
        this.txtPrecioVenta.setText(null);
        this.txtCantidad.setText(null);
        this.cmbEstado.setEnabled(false);
        this.txtNombreProducto.setEnabled(false);
        this.txtPrecioVenta.setEnabled(false);
        this.txtCantidad.setEnabled(false);
        this.btnModificar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.tblInventario.clearSelection();
        this.lblAvisoNombre.setText(null);
        this.lblAvisoPrecio.setText(null);
        this.lblAvisoCantidad.setText(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Clear_Table();
        con.llenarTablaInventario(tblInventario);
       
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Validaciones val = new Validaciones();
          
        if(val.validarCampos(this.txtNombreProducto) == false){
            JOptionPane.showMessageDialog(null, "Hay campos vacios que son requeridos.");
            this.txtNombreProducto.requestFocus();
        }else{
            if(val.validarCampos(this.txtPrecioVenta) == false){
                JOptionPane.showMessageDialog(null, "Hay campos vacios que son requeridos.");
                this.txtPrecioVenta.requestFocus();
            }else{
                if(val.validarCampos(this.txtCantidad) == false){
                    JOptionPane.showMessageDialog(null, "Hay campos vacios que son requeridos.");
                    this.txtCantidad.requestFocus();
                }else{
                    Clear_Table();
                    con.modificar(this.txtNombreProducto.getText(), Integer.parseInt(this.txtCantidad.getText()), Integer.parseInt(this.txtPrecioVenta.getText()), con.obtenerCodigoCmbEstadoObjetos(this.cmbEstado.getSelectedItem().toString())/*this.cmbEstado.getSelectedIndex()+6*/, "luis", this.fechaActual, this.codigo);
                    con.llenarTablaInventario(tblInventario);
                    this.txtNombreProducto.setText(null);
                    this.txtPrecioVenta.setText(null);
                    this.txtCantidad.setText(null);
                    this.cmbEstado.setEnabled(false);
                    this.txtNombreProducto.setEnabled(false);
                    this.txtPrecioVenta.setEnabled(false);
                    this.txtCantidad.setEnabled(false);
                    this.btnModificar.setEnabled(false);
                    this.btnCancelar.setEnabled(false);
                }
            }
            
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked
        Integer fila = tblInventario.getSelectedRow();
        if(fila>=0){
            this.codigo= Integer.parseInt(tblInventario.getValueAt(fila, 0).toString());
            this.cmbEstado.setSelectedItem(tblInventario.getValueAt(fila, 1).toString());
            this.txtNombreProducto.setText(tblInventario.getValueAt(fila, 2).toString());
            this.txtCantidad.setText(tblInventario.getValueAt(fila, 3).toString());           
            this.txtPrecioVenta.setText(tblInventario.getValueAt(fila, 4).toString());
        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila para modificar");
        }
        this.cmbEstado.setEnabled(true);
        this.txtNombreProducto.setEnabled(true);
        this.txtCantidad.setEnabled(true);
        this.btnModificar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        
        if(this.cmbEstado.getSelectedItem().toString().equals("Disponible para venta")){
            this.txtPrecioVenta.setEnabled(true);
            Validaciones val = new Validaciones();
            if(val.campoVacio(this.txtPrecioVenta)==1){
                this.lblAvisoPrecio.setText("*Campo requerido.");
            }
        }else{
            this.txtPrecioVenta.setEnabled(false);
        }
    }//GEN-LAST:event_tblInventarioMouseClicked

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        Validaciones val = new Validaciones();
        val.validarEspacios(evt);
        val.validarNumeros(evt);
        
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        
        Validaciones val = new Validaciones();
        val.validarEspacios(evt);
        val.validarNumeros(evt);
        
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
        
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        if(this.cmbEstado.getSelectedItem().toString().equals("Disponible para venta")){
            this.txtPrecioVenta.setEnabled(true);
        }else{
            //this.txtPrecioVenta.setText("0");
            this.txtPrecioVenta.setEnabled(false);
            this.lblAvisoPrecio.setText(null);
        }
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void txtNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyReleased
        Validaciones val = new Validaciones();
        if(val.campoVacio(this.txtNombreProducto)==1){
            this.lblAvisoNombre.setText("*Campo requerido.");
        }else{
            if(val.campoVacio(this.txtNombreProducto)==2){
                this.lblAvisoNombre.setText("Nombre invalido.");
            }else{
                if(val.validarLongitud(evt, txtNombreProducto.getText().length(), 5, 100)==true){
                    this.lblAvisoNombre.setText("Datos no validos");
                }else{
                    this.lblAvisoNombre.setText(null);
                }
            }
        }
        
    }//GEN-LAST:event_txtNombreProductoKeyReleased

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        Validaciones val = new Validaciones();
        if(val.campoVacio(this.txtCantidad)==1){
            this.lblAvisoCantidad.setText("*Campo requerido.");
        }else{
            if(val.campoVacio(this.txtCantidad)==2){
                this.lblAvisoCantidad.setText("Cantidad invalida.");
            }else{
                if(val.validarLongitud(evt, txtCantidad.getText().length(), 0, 11)==true){
                    this.lblAvisoCantidad.setText("Dato no valido");
                }else{
                    this.lblAvisoCantidad.setText(null);
                }
            }
        }
        
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtPrecioVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyReleased
        Validaciones val = new Validaciones();
        if(val.campoVacio(this.txtPrecioVenta)==1){
            this.lblAvisoPrecio.setText("*Campo requerido.");
        }else{
            if(val.campoVacio(this.txtPrecioVenta)==2){
                this.lblAvisoPrecio.setText("Precio invalido.");
            }else{
                if(val.validarLongitud(evt, txtPrecioVenta.getText().length(), 2, 11)==true){
                    this.lblAvisoPrecio.setText("Dato no valido");
                }else{
                    this.lblAvisoPrecio.setText(null);
                }
            }
        }
        
    }//GEN-LAST:event_txtPrecioVentaKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        Clear_Table();
        con.BarraBusqueda("inventario", this.txtBuscar.getText(), tblInventario, 5, null);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarActionPerformed

    
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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvisoCantidad;
    private javax.swing.JLabel lblAvisoNombre;
    private javax.swing.JLabel lblAvisoPrecio;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombreProducto1;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
