
package proyectocasaempeños;

import java.awt.Color;
import java.io.File;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author danie
 */
public class FrmVentas extends javax.swing.JFrame {

    /**
     * Creates new form FrmVentas
     */
    public FrmVentas() {
        initComponents();
        this.setLocationRelativeTo(null);
        DateTimeFormatter fechaHoy = DateTimeFormatter.ofPattern( "dd/MM/yyyy" ); 
        LocalDateTime actual = LocalDateTime.now();
        this.txtFecha.setText( fechaHoy.format( actual ) );
        this.OcultarColumnas();
    }
    
    boolean verificar_salir = true;
    boolean verficar_venta = false;
    boolean validar_identidad = true;
    boolean validar_nombre = true;
    boolean validar_apellido = true;
    boolean validar_cantidad = true;
            
    Validaciones validar = new Validaciones();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNuevaVenta = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtISV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        pnlDatosCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdentidad = new javax.swing.JTextField();
        lblAvisoIdentidad = new javax.swing.JLabel();
        lblAvisoApellido = new javax.swing.JLabel();
        lblAvisoNombre = new javax.swing.JLabel();
        pnlDetalleVenta = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        btnSeleccionarProducto = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        chkGerarFactura = new javax.swing.JCheckBox();
        btnRegresar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNuevaVenta.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNuevaVenta.setText("Ingresar Venta");
        jPanel1.add(lblNuevaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Subtotal: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, -1, -1));

        txtSubtotal.setEditable(false);
        txtSubtotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 98, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("ISV:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 590, -1, -1));

        txtISV.setEditable(false);
        txtISV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtISV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISVActionPerformed(evt);
            }
        });
        jPanel1.add(txtISV, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, 98, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Total: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 630, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 630, 98, -1));

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnIngresar.setText("Ingresar Venta");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 140, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Fecha:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 100, -1));

        pnlDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Identidad: ");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Apellido: ");

        txtIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdentidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentidadKeyTyped(evt);
            }
        });

        lblAvisoIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoIdentidad.setForeground(new java.awt.Color(255, 0, 0));
        lblAvisoIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblAvisoIdentidadKeyTyped(evt);
            }
        });

        lblAvisoApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoApellido.setForeground(new java.awt.Color(255, 0, 0));

        lblAvisoNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pnlDatosClienteLayout = new javax.swing.GroupLayout(pnlDatosCliente);
        pnlDatosCliente.setLayout(pnlDatosClienteLayout);
        pnlDatosClienteLayout.setHorizontalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvisoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblAvisoIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAvisoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlDatosClienteLayout.setVerticalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvisoIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAvisoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAvisoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel1.add(pnlDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 630, 140));

        pnlDetalleVenta.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de la Venta"));
        pnlDetalleVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre del producto: ");
        pnlDetalleVenta.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtProducto.setEditable(false);
        txtProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });
        pnlDetalleVenta.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 200, -1));

        btnSeleccionarProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSeleccionarProducto.setText("Seleccionar producto");
        btnSeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoActionPerformed(evt);
            }
        });
        pnlDetalleVenta.add(btnSeleccionarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 180, 20));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        pnlDetalleVenta.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Precio:");
        pnlDetalleVenta.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        btnAgregarProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        pnlDetalleVenta.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 140, -1));

        btnEliminarProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarProductoMouseClicked(evt);
            }
        });
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        pnlDetalleVenta.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Cantidad: ");
        pnlDetalleVenta.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        pnlDetalleVenta.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 80, -1));

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableVentas);

        pnlDetalleVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 580, 150));

        jPanel1.add(pnlDetalleVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 630, 330));

        chkGerarFactura.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkGerarFactura.setSelected(true);
        chkGerarFactura.setText("Generar factura");
        jPanel1.add(chkGerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnVolver.setText("Regresar");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
        Integer opcion = JOptionPane.showConfirmDialog(null, "Esta seguro que desea regresar al menú principal, Si desea proseguir perderá los datos de la venta actual", "Aviso", JOptionPane.YES_NO_OPTION); 
            
        if (opcion == JOptionPane.YES_OPTION)
        {
            Conexion con = new Conexion();
            con.RestaurarInventarioProducto(this.tableVentas);
            this.dispose();
            verificar_salir = true;
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private static Integer id_venta;
    
    private JFrame getFrame()
    {
        return this;
    }
    
    public boolean ValidarAgregarVenta(JTextField txtIdentidad, JTextField txtNombre, JTextField txtApellido, JTextField txtSubtotal, JTextField txtISV, JTextField txtTotal)
    {
        txtIdentidad.setText(txtIdentidad.getText().trim());
        txtNombre.setText(txtNombre.getText().trim());
        txtApellido.setText(txtApellido.getText().trim());

        boolean verificar = true;
        
        if (txtIdentidad.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtSubtotal.getText().isEmpty() || txtTotal.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Debe llenar los campos necesarios para completar esta operación", "Error", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        
        return verificar;
    }
    
 public Boolean ValidarAgregarProducto(JTextField txtNombre, JTextField txtPrecio, JTextField txtCantidad)
    {
        Boolean verificar = true;
        
        if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtCantidad.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Debe llenar los campos necesarios para completar esta operación", "Error", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        else
        {
            Integer cantidad = Integer.valueOf(txtCantidad.getText());
            
            if (cantidad == 0)
            {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);
                verificar = false;
            }
        }

        return verificar;
    }
    
    
    private void DeshabilitarCopyPaste()
    {
        this.txtApellido.setTransferHandler(null);
        this.txtNombre.setTransferHandler(null);
        this.txtIdentidad.setTransferHandler(null);
        this.txtCantidad.setTransferHandler(null);
    }
    
    private void Limpiar()
    {

        this.txtIdentidad.setText(null);
        this.txtNombre.setText(null);
        this.txtApellido.setText(null);
        this.txtSubtotal.setText(null);
        this.txtISV.setText(null);
        this.txtTotal.setText(null);
        DefaultTableModel model = (DefaultTableModel) this.tableVentas.getModel();
        model.setRowCount(0);
    }
            
    private void CompartirDatos()
    {
        CompartirDatosProducto comunicacion = new CompartirDatosProducto();
        this.txtProducto.setText(CompartirDatosProducto.nombre_producto);
        this.txtPrecio.setText(CompartirDatosProducto.precio_producto);
    }
    
    private void OcultarColumnas()
    {
        TableColumnModel tcm = this.tableVentas.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
    }
    
    private void LimpiarLabels()
    {
        this.lblAvisoIdentidad.setText(null);
        this.lblAvisoNombre.setText(null);
        this.lblAvisoApellido.setText(null);
    }

    private boolean ImprimirFactura(){
        
        JTextArea paginaImprimir = new JTextArea();
        boolean impresion_exitosa = true;
        
        Conexion con = new Conexion();
        con.IngresarVenta(con.idEmpleado, this.txtIdentidad.getText(), this.txtNombre.getText(), this.txtApellido.getText(), Double.parseDouble(this.txtISV.getText()));
        id_venta = con.ConsultarIdVenta();
        
        paginaImprimir.setText( "\n\t\tCASA DE EMPEÑOS GÓMEZ \n" );
        paginaImprimir.setText(paginaImprimir.getText() + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        paginaImprimir.setText(paginaImprimir.getText() + "\nDirección: Col. Santa Eduviges, calle principal a Villa de los Laureles");
        paginaImprimir.setText(paginaImprimir.getText() + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        paginaImprimir.setText(paginaImprimir.getText() + "\nCódigo de factura: " + this.id_venta);
        paginaImprimir.setText( paginaImprimir.getText() + "\nFecha de la venta: " + this.txtFecha.getText() );
        paginaImprimir.setText( paginaImprimir.getText() + "\nNúmero de identidad: " + this.txtIdentidad.getText());
        paginaImprimir.setText( paginaImprimir.getText() + "\nNombre completo: " + this.txtNombre.getText() + " " + this.txtApellido.getText());
        paginaImprimir.setText(paginaImprimir.getText() + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        paginaImprimir.setText( paginaImprimir.getText() + "\nNombre \t\t\t\tPrecio" );
        paginaImprimir.setText(paginaImprimir.getText() + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       
        for( int i=0; i<this.tableVentas.getRowCount(); i++ )
        {   
            Integer precio = Integer.valueOf(String.valueOf(this.tableVentas.getModel().getValueAt(i, 2))) * Integer.valueOf(String.valueOf(this.tableVentas.getModel().getValueAt(i, 3)));
            paginaImprimir.setText(paginaImprimir.getText() + "\n" + this.tableVentas.getModel().getValueAt(i, 1) + "\n\t" + this.tableVentas.getModel().getValueAt(i, 3) + " * " + this.tableVentas.getModel().getValueAt(i, 2) + "\t\t\t  " + precio);
        }

        paginaImprimir.setText(paginaImprimir.getText() + "\n\t\t\t\t-------------------- \n\t\t\t\tSubtotal: " + this.txtSubtotal.getText());
        paginaImprimir.setText(paginaImprimir.getText() + "\n\t\t\t\t-------------------- \n\t\t\t\tISV: " + this.txtISV.getText());
        paginaImprimir.setText(paginaImprimir.getText() + "\n\t\t\t\t-------------------- \n\t\t\t\tTotal: " + this.txtTotal.getText() );
        paginaImprimir.setText(paginaImprimir.getText() + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        paginaImprimir.setText(paginaImprimir.getText() + "\n\t\t¡GRACIAS POR PREFERIRNOS!");  
        
        try
        {   
            paginaImprimir.print();
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog(null, "La venta no se ha podido registrar, ha ocurrido un error al imprimir la factura: "+e.toString(), "¡Error!", JOptionPane.ERROR_MESSAGE);      
            impresion_exitosa = false;
        }
        
        return impresion_exitosa;
    }
    
    
    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void btnSeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoActionPerformed
        
        verificar_salir = false;
        ListaProductosVenta productos = new ListaProductosVenta()
        {
            @Override
            public void dispose()
            {
                CompartirDatos();
                getFrame().setVisible(true);
                super.dispose();
            }
        };
        
        productos.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnSeleccionarProductoActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        
        if (this.ValidarAgregarProducto(this.txtProducto, this.txtPrecio, this.txtCantidad) == true)
        {
            Conexion con = new Conexion();
            CompartirDatosProducto comunicacion = new CompartirDatosProducto();
            if (con.AgregarProductoVenta(this.tableVentas,CompartirDatosProducto.id_producto, CompartirDatosProducto.nombre_producto, Integer.valueOf(CompartirDatosProducto.precio_producto), Integer.valueOf(this.txtCantidad.getText()), CompartirDatosProducto.cantidad_disponible) == true)
            {
                this.txtProducto.setText(null);
                this.txtPrecio.setText(null);
                this.txtCantidad.setText(null);  
                this.txtSubtotal.setText(String.valueOf(con.SumarSubtotal(tableVentas)));  
                this.txtISV.setText(String.valueOf(Double.parseDouble(this.txtSubtotal.getText())* 0.15));
                this.txtTotal.setText(String.valueOf(Double.parseDouble(this.txtSubtotal.getText()) + Double.parseDouble(this.txtISV.getText())));
                this.txtProducto.setText(null);
                this.txtPrecio.setText(null);
                this.txtCantidad.setText(null);
            }
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        Conexion con = new Conexion();
        con.EliminarProductoVenta(tableVentas);
        con.SumarSubtotal(tableVentas);
        this.txtSubtotal.setText(String.valueOf(con.SumarSubtotal(tableVentas)));
        this.txtISV.setText(String.valueOf(Double.parseDouble(this.txtSubtotal.getText())* 0.15));
        this.txtTotal.setText(String.valueOf(Double.parseDouble(this.txtSubtotal.getText()) + Double.parseDouble(this.txtISV.getText())));
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
    
        if ((this.ValidarAgregarVenta(this.txtIdentidad, this.txtNombre, this.txtApellido, this.txtSubtotal, this.txtISV, this.txtTotal) == true) && (this.validar_identidad == true) && (this.validar_nombre == true) && (this.validar_apellido == true))
        {             
            if(this.chkGerarFactura.isSelected())
            {
                if (ImprimirFactura() == true)
                {
                    Conexion con = new Conexion();
            
                    for (int i = 0; i < this.tableVentas.getRowCount(); i++)
                    {
                        int id_produc = (int) (this.tableVentas.getModel().getValueAt(i, 0));
                        int precio = (int) (this.tableVentas.getModel().getValueAt(i, 2));
                        int cantidad = (int) (this.tableVentas.getModel().getValueAt(i, 3));
                        con.IngresarDetalleVenta(id_venta, id_produc, precio, cantidad);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Operacion Realizada con éxito");
           
                    this.Limpiar();
                    this.LimpiarLabels();
                }
                else
                {
                    Conexion con = new Conexion();
                    con.RestaurarInventarioProducto(tableVentas);
                    this.Limpiar();
                    this.LimpiarLabels();
                }
            }
            else
            {
                Conexion con = new Conexion();
                con.IngresarVenta(con.idEmpleado, this.txtIdentidad.getText(), this.txtNombre.getText(), this.txtApellido.getText(), Double.parseDouble(this.txtISV.getText()));
                id_venta = con.ConsultarIdVenta();
            
                for (int i = 0; i < this.tableVentas.getRowCount(); i++)
                {
                    int id_produc = (int) (this.tableVentas.getModel().getValueAt(i, 0));
                    int precio = (int) (this.tableVentas.getModel().getValueAt(i, 2));
                    int cantidad = (int) (this.tableVentas.getModel().getValueAt(i, 3));
                    con.IngresarDetalleVenta(id_venta, id_produc, precio, cantidad);
                }
                
                JOptionPane.showMessageDialog(null, "Operacion Realizada con éxito");
           
                this.Limpiar();
                this.LimpiarLabels();
            }
        }    
    }//GEN-LAST:event_btnIngresarActionPerformed
       
    private void btnEliminarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProductoMouseClicked
        Conexion con = new Conexion();
        con.EliminarProductoVenta(this.tableVentas);
    }//GEN-LAST:event_btnEliminarProductoMouseClicked

    private void txtIdentidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentidadKeyPressed

    }//GEN-LAST:event_txtIdentidadKeyPressed

    private void txtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyPressed


    }//GEN-LAST:event_txtApellidoKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed


    }//GEN-LAST:event_txtNombreKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (verificar_salir == true)
        {
            Menu menu = new Menu();
            menu.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    private void txtIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentidadKeyTyped
        validar.validarNumeros(evt);
        validar.validarEspacios(evt);
        
        if(validar.validarLongitud(evt, this.txtIdentidad.getText().length(), 12, 12)== true)
        {
            this.lblAvisoIdentidad.setForeground(Color.RED);
            this.lblAvisoIdentidad.setText("Debe contener 13 digitos");
            this.validar_identidad = false;
        }
        else
        {
            this.lblAvisoIdentidad.setForeground(Color.green);
            this.lblAvisoIdentidad.setText("Correcto");
            this.validar_identidad = true;
        }
        
        
    }//GEN-LAST:event_txtIdentidadKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        validar.validarLetrasconEspacios(evt);
        
        if(validar.validarLongitud(evt, this.txtApellido.getText().length(), 4, 30)==true)
        {
            this.lblAvisoApellido.setForeground(Color.RED);
            this.lblAvisoApellido.setText("Debe contener al menos 5 caracteres");
            this.validar_apellido = false;
        }
        else
        {
            this.lblAvisoApellido.setForeground(Color.green);
            this.lblAvisoApellido.setText("Correcto");
            this.validar_apellido = true;
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        validar.validarLetrasconEspacios(evt);
        
        if(validar.validarLongitud(evt, this.txtNombre.getText().length(), 4, 30)==true)
        {
            this.lblAvisoNombre.setForeground(Color.RED);
            this.lblAvisoNombre.setText("Debe contener al menos 5 caracteres");
            this.validar_nombre = false;
        }
        else
        {
            this.lblAvisoNombre.setForeground(Color.green);
            this.lblAvisoNombre.setText("Correcto");
            this.validar_nombre = true;
        }
       
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        validar.validarNumeros(evt);
        validar.validarEspacios(evt);
        
  
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void lblAvisoIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblAvisoIdentidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAvisoIdentidadKeyTyped

    private void txtISVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISVActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeleccionarProducto;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkGerarFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel lblAvisoApellido;
    private javax.swing.JLabel lblAvisoIdentidad;
    private javax.swing.JLabel lblAvisoNombre;
    private javax.swing.JLabel lblNuevaVenta;
    private javax.swing.JPanel pnlDatosCliente;
    private javax.swing.JPanel pnlDetalleVenta;
    private javax.swing.JTable tableVentas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtISV;
    private javax.swing.JTextField txtIdentidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
