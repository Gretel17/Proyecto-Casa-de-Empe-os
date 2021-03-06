/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocasaempeños;

import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author luisf
 */
public class BusquedaContratos extends javax.swing.JFrame {

    /**
     * Creates new form BusquedaContratos
     */
    public BusquedaContratos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.txtBuscar.setTransferHandler(null);
        con.llenarTablaContratos(tblEmpleños);
        OcultarColumnas();
    }

    Conexion con = new Conexion();
    
    private void OcultarColumnas()
    {
        TableColumnModel tcm = this.tblEmpleños.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
    }
    
    private void Clear_Table(){
        DefaultTableModel modelo = (DefaultTableModel) this.tblEmpleños.getModel();
        for (int i = 0; i < this.tblEmpleños.getRowCount(); i++) {
            modelo.removeRow(i);
            i-=1;
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
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnConsultar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleños = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar empeño");
        setPreferredSize(new java.awt.Dimension(830, 478));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(825, 420));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBuscar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblBuscar.setText("Buscar: ");
        jPanel1.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 95, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 290, -1));

        btnConsultar1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnConsultar1.setText("Consultar todo");
        btnConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 30));

        tblEmpleños.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblEmpleños.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código contrato", "Identidad cliente", "Nombre cliente", "Apellido cliente", "Fecha inicial", "Fecha final", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleños.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEmpleños.getTableHeader().setReorderingAllowed(false);
        tblEmpleños.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleñosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleños);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 760, 240));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnVolver.setText("Regresar");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setText("Buscar empeño");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        btnCargar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, -1, 30));

        btnDeseleccionar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeseleccionar.setText("Deseleccionar");
        btnDeseleccionar.setEnabled(false);
        btnDeseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeseleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeseleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        Clear_Table();
        con.BarraBusqueda("contratos", this.txtBuscar.getText(), this.tblEmpleños, 7, null);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar1ActionPerformed
        Clear_Table();
        this.txtBuscar.setText(null);
        con.llenarTablaContratos(tblEmpleños);
    }//GEN-LAST:event_btnConsultar1ActionPerformed

    private void tblEmpleñosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleñosMouseClicked

        Integer fila = this.tblEmpleños.getSelectedRow();
        if(fila>=0){
            this.btnDeseleccionar.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun contrato");
        }
    }//GEN-LAST:event_tblEmpleñosMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        CompartirDatosEmpeño datos = new CompartirDatosEmpeño();
        datos.id_contrato = null;
        datos.identidad = null;
        datos.nombre = null;
        datos.apellido = null;
        datos.fecha_inicio = null;
        datos.fecha_final = null;
        datos.monto = null;
        datos.datos_llenos = false;
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        CompartirDatosEmpeño datos = new CompartirDatosEmpeño();
        Integer fila = this.tblEmpleños.getSelectedRow();
        if(fila>=0){
            datos.id_contrato = Integer.parseInt(this.tblEmpleños.getModel().getValueAt(fila, 0).toString());
            datos.identidad = this.tblEmpleños.getModel().getValueAt(fila, 1).toString();
            datos.nombre = this.tblEmpleños.getModel().getValueAt(fila, 2).toString();
            datos.apellido = this.tblEmpleños.getModel().getValueAt(fila, 3).toString();           
            datos.fecha_inicio = ( this.tblEmpleños.getModel().getValueAt(fila, 4).toString() );
            datos.fecha_final = ( this.tblEmpleños.getModel().getValueAt(fila, 5).toString() );
            datos.monto = Integer.parseInt(this.tblEmpleños.getModel().getValueAt(fila, 6).toString());
            datos.datos_llenos = true;
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun contrato");
        }
        
    }//GEN-LAST:event_btnCargarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        PagarObjeto pagar = new PagarObjeto();
        pagar.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        this.tblEmpleños.clearSelection();
        this.btnDeseleccionar.setEnabled(false);
    }//GEN-LAST:event_btnDeseleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(BusquedaContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaContratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaContratos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnConsultar1;
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblEmpleños;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
