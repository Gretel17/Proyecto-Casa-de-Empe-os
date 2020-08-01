package proyectocasaempeños;

import javax.swing.table.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.text.*;
import java.awt.print.*;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class IngresarCompras extends javax.swing.JFrame {
    
    public IngresarCompras() {
        
        initComponents();
        
        DateTimeFormatter fechaHoy = DateTimeFormatter.ofPattern( "dd/MM/yyyy" ); 
        LocalDateTime actual = LocalDateTime.now();
        
        this.txtFecha.setText( fechaHoy.format( actual ) );
        
        DeshabilitarCopiarPegar();
    }
    
    //public static Integer idEmpleado;
    Conexion conexion = new Conexion();
    int totalCompra=0;
    boolean indicadorIngresarNuevoCliente = false,
            validarAgregarCliente         = true,
            validarAgregarProducto        = false;
    
    private void DeshabilitarCopiarPegar(){
        
        this.txtNumeroIdentidadCliente.setTransferHandler(null);
        this.txtNombreCliente.setTransferHandler(null);
        this.txtApellidoCliente.setTransferHandler(null);
        this.txtNombreProducto.setTransferHandler(null);
        this.txtCantidadProducto.setTransferHandler(null);
        this.txtPrecioProducto.setTransferHandler(null);
    }
    
    private void ImprimirFactura(){
        
        JTextArea paginaImprimir = new JTextArea();
        
        paginaImprimir.setText( "\n\t\tCASA DE EMPEÑOS GÓMEZ \n" );
        paginaImprimir.setText( paginaImprimir.getText() + "\nNúmero de identidad: " + this.txtNumeroIdentidadCliente.getText() );
        paginaImprimir.setText( paginaImprimir.getText() + "\nNombre completo: " + this.txtNombreCliente.getText() + " " + this.txtApellidoCliente.getText() );
        paginaImprimir.setText( paginaImprimir.getText() + "\nFecha de la compra: " + this.txtFecha.getText() );
        paginaImprimir.setText( paginaImprimir.getText() + "\n\nArtículos comprados:" );
        paginaImprimir.setText( paginaImprimir.getText() + "\nNombre \tCantidad \t Precio" );
        
        for( int indiceTablaCompras=0; indiceTablaCompras<this.tblComprasIngresar.getRowCount(); indiceTablaCompras++ ){
            
            paginaImprimir.setText( paginaImprimir.getText() + "\n" + this.tblComprasIngresar.getValueAt(indiceTablaCompras, 0) + "\t" + this.tblComprasIngresar.getValueAt(indiceTablaCompras, 1) + "\t" + this.tblComprasIngresar.getValueAt(indiceTablaCompras, 2) );
        }
        
        paginaImprimir.setText( paginaImprimir.getText() + "\n\t\t-------------------- \n\t\tTotal: " + this.txtTotal.getText() );
        paginaImprimir.setText( paginaImprimir.getText() + "\n\nFecha: " + this.txtFecha.getText() );
        
        try{
            
            paginaImprimir.print();
        }
        catch( Exception e ){}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        grpDatosCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroIdentidadCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSeleccionarCliente = new javax.swing.JButton();
        btnIngresarNuevoCliente = new javax.swing.JButton();
        grpDetallesCompra = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarProducto1 = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComprasIngresar = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnIngresarCompra = new javax.swing.JButton();
        chkGerarFactura = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingresar Compra");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Ingresar Compra");

        grpDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel2.setText("Número de identidad:");

        txtNumeroIdentidadCliente.setEditable(false);
        txtNumeroIdentidadCliente.setEnabled(false);
        txtNumeroIdentidadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroIdentidadClienteActionPerformed(evt);
            }
        });
        txtNumeroIdentidadCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroIdentidadClienteKeyTyped(evt);
            }
        });

        txtNombreCliente.setEditable(false);
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

        jLabel3.setText("Nombre:");

        txtApellidoCliente.setEditable(false);
        txtApellidoCliente.setEnabled(false);
        txtApellidoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoClienteKeyTyped(evt);
            }
        });

        jLabel4.setText("Apellido");

        btnSeleccionarCliente.setText("Seleccionar cliente");
        btnSeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarClienteActionPerformed(evt);
            }
        });

        btnIngresarNuevoCliente.setText("Ingresar nuevo cliente");
        btnIngresarNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout grpDatosClienteLayout = new javax.swing.GroupLayout(grpDatosCliente);
        grpDatosCliente.setLayout(grpDatosClienteLayout);
        grpDatosClienteLayout.setHorizontalGroup(
            grpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grpDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroIdentidadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoCliente))
                    .addGroup(grpDatosClienteLayout.createSequentialGroup()
                        .addComponent(btnSeleccionarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIngresarNuevoCliente)))
                .addContainerGap())
        );
        grpDatosClienteLayout.setVerticalGroup(
            grpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroIdentidadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarCliente)
                    .addComponent(btnIngresarNuevoCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        grpDetallesCompra.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la Compra"));

        jLabel5.setText("Nombre del producto:");

        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });
        txtPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoKeyTyped(evt);
            }
        });

        jLabel6.setText("Precio:");

        btnAgregarProducto1.setText("Agregar producto");
        btnAgregarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProducto1ActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        tblComprasIngresar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComprasIngresar);
        if (tblComprasIngresar.getColumnModel().getColumnCount() > 0) {
            tblComprasIngresar.getColumnModel().getColumn(0).setResizable(false);
            tblComprasIngresar.getColumnModel().getColumn(1).setResizable(false);
            tblComprasIngresar.getColumnModel().getColumn(2).setResizable(false);
        }

        txtTotal.setEditable(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel8.setText("Total:");

        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });

        jLabel7.setText("Cantidad:");

        javax.swing.GroupLayout grpDetallesCompraLayout = new javax.swing.GroupLayout(grpDetallesCompra);
        grpDetallesCompra.setLayout(grpDetallesCompraLayout);
        grpDetallesCompraLayout.setHorizontalGroup(
            grpDetallesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpDetallesCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpDetallesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grpDetallesCompraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grpDetallesCompraLayout.createSequentialGroup()
                        .addGroup(grpDetallesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(grpDetallesCompraLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreProducto))
                            .addGroup(grpDetallesCompraLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(grpDetallesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarProducto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        grpDetallesCompraLayout.setVerticalGroup(
            grpDetallesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpDetallesCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpDetallesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto1))
                .addGap(2, 2, 2)
                .addGroup(grpDetallesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnEliminarProducto)
                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grpDetallesCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jLabel9.setText("Fecha:");

        txtFecha.setEditable(false);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnIngresarCompra.setText("Ingresar compra");
        btnIngresarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarCompraActionPerformed(evt);
            }
        });

        chkGerarFactura.setText("Generar factura");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIngresarCompra)
                        .addGap(139, 139, 139)
                        .addComponent(chkGerarFactura))
                    .addComponent(grpDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grpDetallesCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grpDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grpDetallesCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnIngresarCompra)
                    .addComponent(chkGerarFactura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void txtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioProductoActionPerformed

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnIngresarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarCompraActionPerformed
        
        if( indicadorIngresarNuevoCliente == true ){
            
            if( conexion.validarIdentidadRepetidaCliente( this.txtNumeroIdentidadCliente.getText() ) == false ){
                
                if( this.txtNumeroIdentidadCliente.getText().trim().isEmpty() || this.txtNombreCliente.getText().trim().isEmpty() || this.txtApellidoCliente.getText().trim().isEmpty() ){
                    
                    validarAgregarCliente = false;
                }
                else{
                    
                    if( validarAgregarProducto ){
                        
                        conexion.ingresarCliente( this.txtNumeroIdentidadCliente.getText(), this.txtNombreCliente.getText(), this.txtApellidoCliente.getText(), "2" );
                        conexion.ingresarCompraInventario( this.tblComprasIngresar );
                        conexion.ingresarCompra( conexion.obtenerCodigoClienteIngresar( this.txtNumeroIdentidadCliente.getText() ), conexion.idEmpleado.toString() );
                        conexion.ingresarDetallesCompra( this.tblComprasIngresar );
                        
                        if( this.chkGerarFactura.isSelected() ){

                            ImprimirFactura();
                        }
                        
                        DefaultTableModel modeloTabla = ( DefaultTableModel ) this.tblComprasIngresar.getModel(); // Crea un modelo para poder eliminar todos los elementos.
                        modeloTabla.getDataVector().removeAllElements(); // Borra todos los elementos del modelo.
                        modeloTabla.fireTableDataChanged(); // Actualiza la tabla del modelo a mostrar.

                        totalCompra = 0; // Reinicia el acumulador de comras.

                        this.txtNumeroIdentidadCliente.setText("");
                        this.txtNombreCliente.setText("");
                        this.txtApellidoCliente.setText("");
                        this.txtNumeroIdentidadCliente.setEnabled(false);
                        this.txtNombreCliente.setEnabled(false);
                        this.txtApellidoCliente.setEnabled(false);
                        this.txtTotal.setText(null);
                        
                        validarAgregarCliente = true;
                    }
                }
            }
        }
        else if( this.txtNumeroIdentidadCliente.getText().trim().isEmpty() || this.txtNombreCliente.getText().trim().isEmpty() || this.txtApellidoCliente.getText().trim().isEmpty() ){
            
            validarAgregarCliente = false;
        }
        else{
            
            if( validarAgregarProducto ){
                
                conexion.ingresarCompraInventario( this.tblComprasIngresar );
                conexion.ingresarCompra( conexion.obtenerCodigoClienteIngresar( this.txtNumeroIdentidadCliente.getText() ), conexion.idEmpleado.toString() );
                conexion.ingresarDetallesCompra( this.tblComprasIngresar );
                
                if( this.chkGerarFactura.isSelected() ){
                    
                    ImprimirFactura();
                }
                
                DefaultTableModel modeloTabla = ( DefaultTableModel ) this.tblComprasIngresar.getModel(); // Crea un modelo para poder eliminar todos los elementos.
                modeloTabla.getDataVector().removeAllElements(); // Borra todos los elementos del modelo.
                modeloTabla.fireTableDataChanged(); // Actualiza la tabla del modelo a mostrar.

                totalCompra = 0; // Reinicia el acumulador de comras.

                this.txtNumeroIdentidadCliente.setText("");
                this.txtNombreCliente.setText("");
                this.txtApellidoCliente.setText("");
                this.txtNumeroIdentidadCliente.setEnabled(false);
                this.txtNombreCliente.setEnabled(false);
                this.txtApellidoCliente.setEnabled(false);
                this.txtTotal.setText(null);
                
                validarAgregarCliente = true;
            }
        }
        
        if( !validarAgregarCliente ){
            
            JOptionPane.showMessageDialog( null, "Ingrese todos los datos solicitados del cliente.", "¡Error!", JOptionPane.ERROR_MESSAGE );
        }
        else if( !validarAgregarProducto ){
            
            JOptionPane.showMessageDialog( null, "Tiene que ingresar por lo menos un producto para hacer la compra.", "¡Error!", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_btnIngresarCompraActionPerformed

    private void btnAgregarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProducto1ActionPerformed
        
        if( this.txtNombreProducto.getText().trim().isEmpty() || this.txtCantidadProducto.getText().trim().isEmpty() || this.txtPrecioProducto.getText().trim().isEmpty() ){
            
            JOptionPane.showMessageDialog( null, "Datos para ingresar compra incompletos.", "¡Error!", JOptionPane.ERROR_MESSAGE );
        }
        else{
            
            DefaultTableModel modeloTabla = ( DefaultTableModel ) this.tblComprasIngresar.getModel();
            modeloTabla.addRow( new Object[]{ this.txtNombreProducto.getText(), this.txtCantidadProducto.getText(), this.txtPrecioProducto.getText() } );

            totalCompra += Integer.parseInt( this.txtCantidadProducto.getText() ) * Integer.parseInt( this.txtPrecioProducto.getText() );
            validarAgregarProducto = true;

            this.txtNombreProducto.setText("");
            this.txtCantidadProducto.setText("");
            this.txtPrecioProducto.setText("");
            this.txtTotal.setText( "L." + Integer.toString( totalCompra ) );
        }
    }//GEN-LAST:event_btnAgregarProducto1ActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        
        int fila = this.tblComprasIngresar.getSelectedRow();
        
        DefaultTableModel modeloTabla = ( DefaultTableModel ) this.tblComprasIngresar.getModel();
        
        if( this.tblComprasIngresar.getSelectedRow() != -1 ){
            
            totalCompra -= Integer.parseInt( this.tblComprasIngresar.getModel().getValueAt(fila, 1).toString() ) * Integer.parseInt( this.tblComprasIngresar.getModel().getValueAt(fila, 2).toString() );
            
            this.txtTotal.setText( "L." + Integer.toString( totalCompra ) );
            
            modeloTabla.removeRow(this.tblComprasIngresar.getSelectedRow());
        }
        
        if( this.tblComprasIngresar.getRowCount() == 0 ){
            
            validarAgregarProducto = false;
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void txtNumeroIdentidadClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroIdentidadClienteKeyTyped
        
        if( this.txtNumeroIdentidadCliente.getText().length() >= 13 ){
            
            evt.consume();
        }
        else if( !Character.isDigit( evt.getKeyChar() ) ){
            
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroIdentidadClienteKeyTyped

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        
        if( this.txtNombreCliente.getText().length() >= 50 ){
            
            evt.consume();
        }
        else if( Character.isDigit( evt.getKeyChar() ) ){
            
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void txtApellidoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoClienteKeyTyped
        
        if( this.txtApellidoCliente.getText().length() >= 50 ){
            
            evt.consume();
        }
        else if( Character.isDigit( evt.getKeyChar() ) ){
            
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoClienteKeyTyped

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
        
        if( this.txtNombreProducto.getText().length() >= 100 ){
            
            evt.consume();
        }
        else if( this.txtNombreProducto.getText().length() >= 100 ){
            
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        
        if( !Character.isDigit( evt.getKeyChar() ) ){
            
            evt.consume();
        }
        else if( this.txtCantidadProducto.getText().length() >= 11 ){
            
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void txtPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoKeyTyped
        
        if( !Character.isDigit( evt.getKeyChar() ) ){
            
            evt.consume();
        }
        
        if( this.txtPrecioProducto.getText().length() >= 11 ){
            
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioProductoKeyTyped

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarClienteActionPerformed
        
        BuscarCliente buscarCliente = new BuscarCliente();
        
        buscarCliente.setVisible(true);
        indicadorIngresarNuevoCliente = false;
        
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarClienteActionPerformed

    private void txtNumeroIdentidadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroIdentidadClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroIdentidadClienteActionPerformed

    private void btnIngresarNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarNuevoClienteActionPerformed
        
        indicadorIngresarNuevoCliente = true;
        
        this.txtNumeroIdentidadCliente.setText(null);
        this.txtNumeroIdentidadCliente.setEditable(true);
        this.txtNumeroIdentidadCliente.setEnabled(true);
        this.txtNombreCliente.setText(null);
        this.txtNombreCliente.setEditable(true);
        this.txtNombreCliente.setEnabled(true);
        this.txtApellidoCliente.setText(null);
        this.txtApellidoCliente.setEditable(true);
        this.txtApellidoCliente.setEnabled(true);
    }//GEN-LAST:event_btnIngresarNuevoClienteActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
        Menu menu = new Menu();
        
        menu.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    
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
            java.util.logging.Logger.getLogger(IngresarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto1;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnIngresarCompra;
    public static javax.swing.JButton btnIngresarNuevoCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeleccionarCliente;
    private javax.swing.JCheckBox chkGerarFactura;
    private javax.swing.JPanel grpDatosCliente;
    private javax.swing.JPanel grpDetallesCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblComprasIngresar;
    public static javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProducto;
    public static javax.swing.JTextField txtNumeroIdentidadCliente;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}