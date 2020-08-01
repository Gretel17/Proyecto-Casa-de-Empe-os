/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocasaempeños;


import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JCalendar; 
import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author danie
 */
public class FrmEmpleados extends javax.swing.JFrame {

    
    
    public FrmEmpleados() {
        initComponents();
        this.setLocationRelativeTo(null);
        Conexion con = new Conexion();
        con.LlenarComboboxPuestos(this.cmbPuesto);
        con.LlenarComboboxEstados(this.cmbEstado);
        con.ConsultarEmpleados(tableEmpleados);
        this.tableEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        con.AjustarAutomaticamenteAnchoColumna(tableEmpleados);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) this.fecha_nacimiento_datechooser.getDateEditor();
        editor.setEditable(false);
        this.DeshabilitarCopyPaste();
        this.OcultarColumnas();
        this.CompartirDatos();
    }
    
    Integer Id_empleado; 
    Integer correo;
    boolean mostrar = false;
    boolean validar_identidad = true;
    boolean validar_nombre = true;
    boolean validar_apellido = true;
    boolean validar_nacimiento = true;
    boolean validar_telefono = true;
    boolean validar_correo = true;
    boolean validar_direccion = true;
    boolean validar_usuario = true;
    boolean validar_contrasenia = true;
    boolean validar_salario = true;
    Validaciones validar = new Validaciones();
    
    public boolean ValidarAgregarEmpleado(JTextField txtIdentidad, JTextField txtNombre, JTextField txtApellido, JTextField txtUsuario, JTextField txtContrasenia, JTextField txtSalario, JDateChooser fecha_nacimiento, JComboBox Puestos, JTextField Correo)
    {
        boolean verificar = true;
        
        txtIdentidad.setText(txtIdentidad.getText().trim());
        txtNombre.setText(txtNombre.getText().trim());
        txtApellido.setText(txtApellido.getText().trim());
        txtUsuario.setText(txtUsuario.getText().trim());
        txtContrasenia.setText(txtContrasenia.getText().trim());
        txtSalario.setText(txtSalario.getText().trim());
        Correo.setText(Correo.getText().trim());
        
        if (txtIdentidad.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContrasenia.getText().isEmpty() || txtSalario.getText().isEmpty() || fecha_nacimiento.getDate() == null || Puestos.getSelectedIndex() == 0 || Correo.getText().isEmpty())
        {
            if (txtIdentidad.getText().isEmpty())
            {
                this.lblAvisoIdentidad1.setForeground(Color.RED);
                this.lblAvisoIdentidad1.setText("*Este campo es requerido*");    
            }
            
            if (txtNombre.getText().isEmpty())
            {
                this.lblAvisoNombre.setForeground(Color.RED);
                this.lblAvisoNombre.setText("*Este campo es requerido*");
            }
            
            if (txtApellido.getText().isEmpty())
            {
                this.lblAvisoApellido.setForeground(Color.RED);
                this.lblAvisoApellido.setText("*Este campo es requerido*");
            }
            
            if (txtUsuario.getText().isEmpty())
            {
                this.lblAvisoUsuario.setForeground(Color.RED);
                this.lblAvisoUsuario.setText("*Este campo es requerido*");
            }
            
            if(txtContrasenia.getText().isEmpty())
            {
                this.lblAvisoContrseña.setForeground(Color.RED);
                this.lblAvisoContrseña.setText("*Este campo es requerido");
            }
            
            if (txtSalario.getText().isEmpty())
            {
                this.lblAvisoSalario.setForeground(Color.RED);
                this.lblAvisoSalario.setText("*Este campo es requerido*");
            }
            
            if (Puestos.getSelectedIndex() == 0)
            {
                this.lblAvisoPuesto.setForeground(Color.RED);
                this.lblAvisoPuesto.setText("*Selecciona otra opción*");
            }
            
            if (Correo.getText().isEmpty())
            {
                this.lblAvisoCorreo.setForeground(Color.RED);
                this.lblAvisoCorreo.setText("*Este campo es requerido*");
            }
            
            if (this.fecha_nacimiento_datechooser.getDate()== null)
            {
                JOptionPane.showMessageDialog(null, "El campo de la fecha de nacimiento es requerido", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Debe llenar los campos necesarios para completar esta operación", "Error", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        
        return verificar;
    }
    
    
    public boolean ValidarEditarEmpleado(JTextField txtIdentidad, JTextField txtNombre, JTextField txtApellido, JTextField txtSalario, JDateChooser fecha_nacimiento, JComboBox Puestos, JTextField Correo, JComboBox Estados)
    {
        boolean verificar = true;
        
        txtIdentidad.setText(txtIdentidad.getText().trim());
        txtNombre.setText(txtNombre.getText().trim());
        txtApellido.setText(txtApellido.getText().trim());
        txtSalario.setText(txtSalario.getText().trim());
        Correo.setText(Correo.getText().trim());
        
        if (txtIdentidad.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtSalario.getText().isEmpty() || fecha_nacimiento.getDate() == null || Puestos.getSelectedIndex() == 0 || Correo.getText().isEmpty() || Estados.getSelectedIndex() == 0)
        {
            if (txtIdentidad.getText().isEmpty())
            {
                this.lblAvisoIdentidad1.setForeground(Color.RED);
                this.lblAvisoIdentidad1.setText("*Este campo es requerido*");    
            }
            
            if (txtNombre.getText().isEmpty())
            {
                this.lblAvisoNombre.setForeground(Color.RED);
                this.lblAvisoNombre.setText("*Este campo es requerido*");
            }
            
            if (txtApellido.getText().isEmpty())
            {
                this.lblAvisoApellido.setForeground(Color.RED);
                this.lblAvisoApellido.setText("*Este campo es requerido*");
            }
            
            if (txtSalario.getText().isEmpty())
            {
                this.lblAvisoSalario.setForeground(Color.RED);
                this.lblAvisoSalario.setText("*Este campo es requerido*");
            }
            
            if (Puestos.getSelectedIndex() == 0)
            {
                this.lblAvisoPuesto.setForeground(Color.RED);
                this.lblAvisoPuesto.setText("*Selecciona otra opción*");
            }
            
            if (Estados.getSelectedIndex() == 0)
            {
                this.lblAvisoEstado.setForeground(Color.RED);
                this.lblAvisoEstado.setText("*Selecciona otra opción*");
            }
            
            if (Correo.getText().isEmpty())
            {
                this.lblAvisoCorreo.setForeground(Color.RED);
                this.lblAvisoCorreo.setText("*Este campo es requerido*");
            }
            
            if (this.fecha_nacimiento_datechooser.getDate()== null)
            {
                JOptionPane.showMessageDialog(null, "El campo de la fecha de nacimiento es requerido", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Debe llenar los campos necesarios para completar esta operación", "Error", JOptionPane.ERROR_MESSAGE);
            verificar = false;
        }
        
        return verificar;
    }
    
    public void LimpiarTxtFields()
    {
        this.txtIdentidad.setText(null);
        this.txtNombre.setText(null);
        this.txtApellido.setText(null);
        this.fecha_nacimiento_datechooser.setCalendar(null);
        this.txtTelefono.setText(null);
        this.txtCorreo_electronico.setText(null);
        this.txtDireccion.setText(null);
        this.txtUsuario.setText(null);
        this.txtContraseña.setText(null);
        this.cmbPuesto.setSelectedIndex(0);
        this.cmbEstado.setSelectedIndex(0);
        this.txtSalario.setText(null);
        
    }
    
    public void LimpiarLabels()
    {
        this.lblAvisoIdentidad1.setText(null);
        this.lblAvisoNombre.setText(null);
        this.lblAvisoApellido.setText(null);
        this.lblAvisoTelefono.setText(null);
        this.lblAvisoCorreo.setText(null);
        this.lblAvisoDireccion.setText(null);
        this.lblAvisoUsuario.setText(null);
        this.lblAvisoContrseña.setText(null);
        this.lblAvisoPuesto.setText(null);
        this.lblAvisoSalario.setText(null);
        this.lblAvisoEstado.setText(null);
    }
    
    
    private void DeshabilitarCopyPaste()
    {
        this.txtIdentidad.setTransferHandler(null);
        this.txtNombre.setTransferHandler(null);
        this.txtApellido.setTransferHandler(null);
        this.txtUsuario.setTransferHandler(null);
        this.txtContraseña.setTransferHandler(null);
        this.txtCorreo_electronico.setTransferHandler(null);
        this.txtDireccion.setTransferHandler(null);
        this.txtTelefono.setTransferHandler(null);
        this.txtSalario.setTransferHandler(null);
    }
    
    private void RefrescarTable()
    {
        DefaultTableModel model = (DefaultTableModel) this.tableEmpleados.getModel();
        model.setRowCount(0);
        Conexion con = new Conexion();
        con.ConsultarEmpleados(this.tableEmpleados);
    }
    
    private void OcultarColumnas()
    {
        TableColumnModel tcm = this.tableEmpleados.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
    }
    
    public void CompartirDatos()
    {      
        CompartirDatosEmpleado compartir = new CompartirDatosEmpleado();
        
        this.Id_empleado = CompartirDatosEmpleado.id_empleado;
        this.txtIdentidad.setText(CompartirDatosEmpleado.identidad); 
        this.txtNombre.setText(CompartirDatosEmpleado.nombre);
        this.txtApellido.setText(CompartirDatosEmpleado.apellido);
        this.fecha_nacimiento_datechooser.setDate(CompartirDatosEmpleado.fecha_nacimiento);
        this.txtCorreo_electronico.setText(CompartirDatosEmpleado.correo);
        this.txtDireccion.setText(CompartirDatosEmpleado.direccion);
        this.txtTelefono.setText(CompartirDatosEmpleado.telefono);
        this.txtSalario.setText(CompartirDatosEmpleado.salario);
        this.cmbEstado.setSelectedItem(CompartirDatosEmpleado.estado);
        this.cmbPuesto.setSelectedItem(CompartirDatosEmpleado.puesto);
        
        if (CompartirDatosEmpleado.datos_llenos == true)
        {
             this.btnEditar.setEnabled(true);
            this.btnAgregar.setEnabled(false);
            this.cmbEstado.setEnabled(true);
            this.txtUsuario.setEnabled(false);
            this.txtContraseña.setEnabled(false);
            this.chkMostrar.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        pnlInformacionPersonalEmpleado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtIdentidad = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo_electronico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        txtNombre = new javax.swing.JTextField();
        lblAvisoApellido = new javax.swing.JLabel();
        lblAvisoDireccion = new javax.swing.JLabel();
        lblAvisoNombre = new javax.swing.JLabel();
        lblAvisoTelefono = new javax.swing.JLabel();
        lblAvisoCorreo = new javax.swing.JLabel();
        lblAvisoIdentidad1 = new javax.swing.JLabel();
        fecha_nacimiento_datechooser = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEmpleados = new javax.swing.JTable();
        pnlInformacionUsuarioEmpleado = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbPuesto = new javax.swing.JComboBox<>();
        txtContraseña = new javax.swing.JPasswordField();
        chkMostrar = new javax.swing.JCheckBox();
        lblAvisoEstado = new javax.swing.JLabel();
        lblAvisoUsuario = new javax.swing.JLabel();
        lblAvisoContrseña = new javax.swing.JLabel();
        lblAvisoSalario = new javax.swing.JLabel();
        lblAvisoPuesto = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Ingresar/Editar/Consultar Empleados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        pnlInformacionPersonalEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información personal del empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        pnlInformacionPersonalEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Identidad:");
        pnlInformacionPersonalEmpleado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre: ");
        pnlInformacionPersonalEmpleado.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Apellido:");
        pnlInformacionPersonalEmpleado.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha de nacimiento: ");
        pnlInformacionPersonalEmpleado.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Teléfono: ");
        pnlInformacionPersonalEmpleado.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Correo electrónico: ");
        pnlInformacionPersonalEmpleado.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Dirección: ");
        pnlInformacionPersonalEmpleado.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        pnlInformacionPersonalEmpleado.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 150, -1));

        txtIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentidadActionPerformed(evt);
            }
        });
        txtIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentidadKeyTyped(evt);
            }
        });
        pnlInformacionPersonalEmpleado.add(txtIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 170, -1));

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        pnlInformacionPersonalEmpleado.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 170, -1));

        txtCorreo_electronico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCorreo_electronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreo_electronicoKeyTyped(evt);
            }
        });
        pnlInformacionPersonalEmpleado.add(txtCorreo_electronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 190, -1));

        txtDireccion.setColumns(20);
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setRows(5);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDireccion);

        pnlInformacionPersonalEmpleado.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 240, 100));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        pnlInformacionPersonalEmpleado.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 170, -1));

        lblAvisoApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoApellido.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionPersonalEmpleado.add(lblAvisoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 126, 230, 20));

        lblAvisoDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoDireccion.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionPersonalEmpleado.add(lblAvisoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 446, 390, 20));

        lblAvisoNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionPersonalEmpleado.add(lblAvisoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 126, 230, 20));

        lblAvisoTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoTelefono.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionPersonalEmpleado.add(lblAvisoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 246, 220, 20));

        lblAvisoCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoCorreo.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionPersonalEmpleado.add(lblAvisoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 306, 340, 20));

        lblAvisoIdentidad1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoIdentidad1.setForeground(new java.awt.Color(255, 0, 0));
        lblAvisoIdentidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblAvisoIdentidad1KeyTyped(evt);
            }
        });
        pnlInformacionPersonalEmpleado.add(lblAvisoIdentidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 66, 240, 20));

        fecha_nacimiento_datechooser.setMaxSelectableDate(new java.util.Date(1009868514000L));
        fecha_nacimiento_datechooser.setMinSelectableDate(new java.util.Date(-631123086000L));
        fecha_nacimiento_datechooser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fecha_nacimiento_datechooserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fecha_nacimiento_datechooserFocusLost(evt);
            }
        });
        fecha_nacimiento_datechooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecha_nacimiento_datechooserMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fecha_nacimiento_datechooserMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fecha_nacimiento_datechooserMouseReleased(evt);
            }
        });
        fecha_nacimiento_datechooser.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                fecha_nacimiento_datechooserInputMethodTextChanged(evt);
            }
        });
        pnlInformacionPersonalEmpleado.add(fecha_nacimiento_datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 160, -1));

        jPanel1.add(pnlInformacionPersonalEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 520, 480));

        tableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Empleado", "Identidad", "Nombre", "Apellido", "Fecha de Nacimiento", "Teléfono", "Correo electrónico", "Dirección", "Puesto", "Estado", "Salario", "Fecha de Contratación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableEmpleados);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 1040, 150));

        pnlInformacionUsuarioEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de usuario para el empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        pnlInformacionUsuarioEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Usuario:");
        pnlInformacionUsuarioEmpleado.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Contraseña: ");
        pnlInformacionUsuarioEmpleado.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Puesto: ");
        pnlInformacionUsuarioEmpleado.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Salario: ");
        pnlInformacionUsuarioEmpleado.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        pnlInformacionUsuarioEmpleado.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 148, -1));

        txtSalario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalarioKeyTyped(evt);
            }
        });
        pnlInformacionUsuarioEmpleado.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 100, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Estado: ");
        pnlInformacionUsuarioEmpleado.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        cmbEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un estado" }));
        cmbEstado.setEnabled(false);
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });
        pnlInformacionUsuarioEmpleado.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 150, 20));

        cmbPuesto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un puesto" }));
        cmbPuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPuestoItemStateChanged(evt);
            }
        });
        pnlInformacionUsuarioEmpleado.add(cmbPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 150, -1));

        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyTyped(evt);
            }
        });
        pnlInformacionUsuarioEmpleado.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 150, -1));

        chkMostrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkMostrar.setText("Mostrar contraseña");
        chkMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActionPerformed(evt);
            }
        });
        pnlInformacionUsuarioEmpleado.add(chkMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 98, -1, -1));

        lblAvisoEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoEstado.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionUsuarioEmpleado.add(lblAvisoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 210, 20));

        lblAvisoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoUsuario.setForeground(new java.awt.Color(255, 0, 0));
        lblAvisoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblAvisoUsuarioKeyTyped(evt);
            }
        });
        pnlInformacionUsuarioEmpleado.add(lblAvisoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 66, 230, 20));

        lblAvisoContrseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoContrseña.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionUsuarioEmpleado.add(lblAvisoContrseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 126, 230, 20));

        lblAvisoSalario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoSalario.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionUsuarioEmpleado.add(lblAvisoSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 246, 280, 20));

        lblAvisoPuesto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAvisoPuesto.setForeground(new java.awt.Color(255, 0, 0));
        pnlInformacionUsuarioEmpleado.add(lblAvisoPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 210, 20));

        jPanel1.add(pnlInformacionUsuarioEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 510, 290));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, -1, -1));

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, -1, -1));

        btnConsultar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 380, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, -1, -1));
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnVolver.setText("Regresar");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        Validaciones val = new Validaciones();

        
        if ((this.ValidarAgregarEmpleado(this.txtIdentidad, this.txtNombre, this.txtApellido, this.txtUsuario, this.txtContraseña, this.txtSalario, this.fecha_nacimiento_datechooser, cmbPuesto, this.txtCorreo_electronico) == true) && (this.validar_identidad == true) && (this.validar_nombre == true) && (this.validar_apellido == true) && (this.validar_usuario == true) && (this.validar_contrasenia == true) && (this.validar_correo == true) && (this.validar_direccion == true) && (this.validar_telefono == true) && (this.validar_salario == true))
        {
            Conexion con = new Conexion();
        
            if (con.ValidarIngresarCamposRepetidosEmpleado(this.txtIdentidad.getText(), this.txtNombre.getText(), this.txtApellido.getText(), this.txtUsuario.getText(), this.txtContraseña.getText(), this.txtCorreo_electronico.getText()) == false)    
            {
                if (val.ValidarCorreo(this.txtCorreo_electronico.getText()) == true)
                {   
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    con.Mantenimiento_Empleados("insertar", 0, this.txtIdentidad.getText(), this.txtNombre.getText(), this.txtApellido.getText(), this.txtUsuario.getText(), this.txtContraseña.getText(), 
                    Integer.parseInt(this.txtSalario.getText()), this.txtTelefono.getText(), this.txtCorreo_electronico.getText(), this.txtDireccion.getText(), Date.valueOf(df.format(this.fecha_nacimiento_datechooser.getDate())) , this.cmbPuesto.getSelectedIndex(), this.cmbEstado.getSelectedIndex(), con.numeroIdentidadEmpleado); 
                    this.RefrescarTable();
                    this.LimpiarTxtFields();
                    this.LimpiarLabels();
                }      
            }    
        }
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpleadosMouseClicked
        this.btnEditar.setEnabled(true);
        this.btnAgregar.setEnabled(false);
        this.cmbEstado.setEnabled(true);
        this.txtUsuario.setEnabled(false);
        this.txtContraseña.setEnabled(false);
        this.chkMostrar.setEnabled(false);
        int seleccion = this.tableEmpleados.rowAtPoint(evt.getPoint()); 
        this.Id_empleado = Integer.parseInt((String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 0)))); 
        this.txtIdentidad.setText(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 1)));
        this.txtNombre.setText(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 2)));
        this.txtApellido.setText(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 3)));
        this.fecha_nacimiento_datechooser.setDate(Date.valueOf(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 4))));
        this.txtTelefono.setText(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 5)));
        this.txtCorreo_electronico.setText(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 6)));
        this.txtDireccion.setText(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 7)));
        this.cmbPuesto.setSelectedItem(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 8)));
        this.cmbEstado.setSelectedItem(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion,9)));
        this.txtSalario.setText(String.valueOf(tableEmpleados.getModel().getValueAt(seleccion, 10)));
        this.LimpiarLabels();
        
    }//GEN-LAST:event_tableEmpleadosMouseClicked

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        FrmBusquedaEmpleados busquedaEmpleados = new FrmBusquedaEmpleados();
        busquedaEmpleados.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.btnEditar.setEnabled(false);
        this.cmbEstado.setEnabled(false);
        this.txtUsuario.setEnabled(true);
        this.txtContraseña.setEnabled(true);
        this.LimpiarTxtFields();
        this.tableEmpleados.clearSelection();
        this.btnAgregar.setEnabled(true);
        this.chkMostrar.setEnabled(true);
        this.LimpiarLabels();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Validaciones val = new Validaciones();
        
        if((this.ValidarEditarEmpleado(this.txtIdentidad, this.txtNombre, this.txtApellido, this.txtSalario, this.fecha_nacimiento_datechooser, this.cmbPuesto, this.txtCorreo_electronico, this.cmbEstado) == true) && (this.validar_identidad == true) && (this.validar_nombre == true) && (this.validar_apellido == true) && (this.validar_correo == true) && (this.validar_direccion == true) && (this.validar_telefono == true) && (this.validar_salario == true) )
        {
            Conexion con = new Conexion();
            if (con.ValidarEditarCamposRepetidosEmpleado(this.Id_empleado, this.txtIdentidad.getText(), this.txtNombre.getText(), this.txtApellido.getText(), this.txtUsuario.getText(), this.txtContraseña.getText(), this.txtCorreo_electronico.getText()) == false)    
            {
                if (val.ValidarCorreo(this.txtCorreo_electronico.getText()) == true)
                {   
                    con.Mantenimiento_Empleados("editar", this.Id_empleado, this.txtIdentidad.getText(), this.txtNombre.getText(), this.txtApellido.getText(), null, null, Integer.parseInt(this.txtSalario.getText()), this.txtTelefono.getText(), this.txtCorreo_electronico.getText(), this.txtDireccion.getText(), Date.valueOf(df.format(this.fecha_nacimiento_datechooser.getDate())), this.cmbPuesto.getSelectedIndex(), this.cmbEstado.getSelectedIndex(), con.numeroIdentidadEmpleado);
                    this.RefrescarTable();
                    this.LimpiarTxtFields();
                    this.btnEditar.setEnabled(false);
                    this.btnAgregar.setEnabled(true);
                    this.txtUsuario.setEnabled(true);
                    this.txtContraseña.setEnabled(true);
                    this.chkMostrar.setEnabled(true);
                }
            }
            this.LimpiarLabels();
        } 
    }//GEN-LAST:event_btnEditarActionPerformed

    private void chkMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActionPerformed
        if (this.chkMostrar.isSelected())
        {
            this.txtContraseña.setEchoChar((char) 0);          
        }
        else
        {
            this.txtContraseña.setEchoChar('•');
        }
    }//GEN-LAST:event_chkMostrarActionPerformed

    private void txtIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentidadKeyTyped
        validar.validarNumeros(evt);
        if(validar.validarLongitud(evt, this.txtIdentidad.getText().length(), 12, 12)==true)
        {
            this.lblAvisoIdentidad1.setForeground(Color.RED);
            this.lblAvisoIdentidad1.setText("Debe contener 13 digitos");
            this.validar_identidad = false;
        }
        else
        {
            this.lblAvisoIdentidad1.setForeground(Color.green);
            this.lblAvisoIdentidad1.setText("Correcto");
            this.validar_identidad = true;
        }
    }//GEN-LAST:event_txtIdentidadKeyTyped

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

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        validar.validarNumeros(evt); 
        if(validar.validarLongitud(evt, this.txtTelefono.getText().length(), 7, 7)==true)
        {
            if (!this.txtTelefono.getText().isEmpty())
            {
                this.lblAvisoTelefono.setForeground(Color.RED);
                this.lblAvisoTelefono.setText("Debe contener 8 digitos"); 
                this.validar_telefono = false;
            }
            else
            {
                this.lblAvisoTelefono.setText(null);
                this.validar_telefono = true;
            }
        }
        else
        {
            this.lblAvisoTelefono.setForeground(Color.green);
            this.lblAvisoTelefono.setText("Correcto");
            this.validar_telefono = true;
        }
       
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyTyped
        validar.validarNumeros(evt);
        if(validar.validarLongitud(evt, this.txtSalario.getText().length(), 3, 4)==true)
        {
            this.lblAvisoSalario.setForeground(Color.RED);
            this.lblAvisoSalario.setText("Debe contener al menos 4 digitos");
            this.validar_salario = false;
        }
        else
        {
            this.lblAvisoSalario.setForeground(Color.green);
            this.lblAvisoSalario.setText("Correcto");
            this.validar_salario = true;
        }
        
    }//GEN-LAST:event_txtSalarioKeyTyped

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

    private void txtIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentidadActionPerformed

    private void txtCorreo_electronicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreo_electronicoKeyTyped
        validar.validarEspacios(evt);
        char c=evt.getKeyChar();
        String s=this.txtCorreo_electronico.getText();
        if(c!=8)
        {
            s+=c;
        }
        this.correo=0;
        for(int i=0;i<s.length();i++)
        {          
            if(this.correo==0 && s.charAt(i)=='@')
            {
                this.correo++;
            }
            if(s.length()>4)
            {
             if(this.correo==1 && s.charAt(s.length()-4)=='.' && s.charAt(s.length()-3)=='c' && s.charAt(s.length()-2)=='o' && s.charAt(s.length()-1)=='m')
             {
                 this.correo++;
             }
            }
        }
        String su=this.txtCorreo_electronico.getText();
         if(c!=8)
         {
             su+=((char)c);
         }
        if(correo!=2)
        {
            this.lblAvisoCorreo.setText("El formato es incorrecto ejemplo@gmail.com");
            this.lblAvisoCorreo.setForeground(Color.red);
            this.lblAvisoCorreo.setVisible(true);
            this.validar_correo = false;
        }
        else
        {
            this.lblAvisoCorreo.setText("Correcto");
            this.lblAvisoCorreo.setForeground(Color.green);
            this.lblAvisoCorreo.setVisible(true);
            this.validar_correo = true;
        }
    }//GEN-LAST:event_txtCorreo_electronicoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        validar.validarLetrasconEspacios(evt);
        
        if(validar.validarLongitud(evt, this.txtDireccion.getText().length(), 10, 30)==true)
        {
            if (!this.txtDireccion.getText().isEmpty())
            {
                this.lblAvisoDireccion.setForeground(Color.RED);
                this.lblAvisoDireccion.setText("Porfavor especifique una dirección más precisa");
                this.validar_direccion = false;
            }
            else
            {
                this.lblAvisoDireccion.setText(null);
                this.validar_direccion = true;
            }
        }
        else
        {
            this.lblAvisoDireccion.setForeground(Color.green);
            this.lblAvisoDireccion.setText("Correcto");
            this.validar_direccion = true;
        }
        
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        int c=evt.getKeyChar();
       
        
        if(this.txtUsuario.getText().length()>14 )
        {
            evt.consume();
            c=8;
        }
        else
        {
            if(c!=241 && c!=209)
            {
            
                if(c>47 && c<=122 )
                {
                    if(c>57  && c<65)
                    {
                        evt.consume();
                        c=8;
                    }
                    else
                    {
                        if(c>90  && c<97)
                        {
                            evt.consume();
                            c=8;
                        }
                    }
                }
                else
                {
                    evt.consume();
                    c=8;
                }
            }
        }
        int n=this.txtUsuario.getText().length();
        String s=this.txtUsuario.getText();
        if(c==8)
        {
            n--;
        }
        else
        {
            s+=((char)c);
        }
        
        if(n<3)
        {
            
            this.lblAvisoUsuario.setText("Debe contener más de cuatro caracteres");
            this.lblAvisoUsuario.setForeground(Color.red);
            this.lblAvisoUsuario.setVisible(true);
            this.validar_usuario = false;
        }
        else
        {
            this.lblAvisoUsuario.setText("Correcto");
            this.lblAvisoUsuario.setForeground(Color.green);
            this.lblAvisoUsuario.setVisible(true);
            this.validar_usuario = true;
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyTyped
        int c=evt.getKeyChar();
         
       
        
        if(this.txtContraseña.getText().length()>14)
        {
            evt.consume();
            
        }
        else
        {
           if(c!=241 && c!=209)
            {
            
                if(c>47 && c<=122 )
                {
                    if(c>57  && c<65)
                    {
                        evt.consume();
                        
                    }
                    else
                    {
                        if(c>90  && c<97)
                        {
                            evt.consume();
                            
                        }
                    }
                }
                else
                {
                    evt.consume();
                    
                }
            }
        }
        int n=this.txtContraseña.getText().length();
        
        if(c==8)
        {
            n--;
        }
        
        
        if(n<7)
        {
            
            this.lblAvisoContrseña.setText("Tiene que tener minimo ocho caracteres");
            this.lblAvisoContrseña.setForeground(Color.red);
            this.lblAvisoContrseña.setVisible(true);
            this.validar_contrasenia = false;
        }
        else
        {
            
            this.lblAvisoContrseña.setText("Correcto");
            this.lblAvisoContrseña.setForeground(Color.green);
            this.lblAvisoContrseña.setVisible(true);
            this.validar_contrasenia = true;
            
        }
    }//GEN-LAST:event_txtContraseñaKeyTyped

    private void lblAvisoIdentidad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblAvisoIdentidad1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAvisoIdentidad1KeyTyped

    private void lblAvisoUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblAvisoUsuarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAvisoUsuarioKeyTyped

    private void fecha_nacimiento_datechooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecha_nacimiento_datechooserMouseClicked
        
    }//GEN-LAST:event_fecha_nacimiento_datechooserMouseClicked

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked

    
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void cmbPuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPuestoItemStateChanged
        if (this.cmbPuesto.getSelectedIndex() == 0)
        {
            this.lblAvisoPuesto.setForeground(Color.RED);
            this.lblAvisoPuesto.setText("*Seleccione otra opción*");
        }
        else
        {
            this.lblAvisoPuesto.setForeground(Color.GREEN);
            this.lblAvisoPuesto.setText("Correcto");
        }
    }//GEN-LAST:event_cmbPuestoItemStateChanged
 
    private void fecha_nacimiento_datechooserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecha_nacimiento_datechooserMouseReleased

    }//GEN-LAST:event_fecha_nacimiento_datechooserMouseReleased

    private void fecha_nacimiento_datechooserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecha_nacimiento_datechooserMouseExited

    }//GEN-LAST:event_fecha_nacimiento_datechooserMouseExited

    private void fecha_nacimiento_datechooserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fecha_nacimiento_datechooserFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_nacimiento_datechooserFocusGained

    private void fecha_nacimiento_datechooserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fecha_nacimiento_datechooserFocusLost

    }//GEN-LAST:event_fecha_nacimiento_datechooserFocusLost

    private void fecha_nacimiento_datechooserInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_fecha_nacimiento_datechooserInputMethodTextChanged
        
    }//GEN-LAST:event_fecha_nacimiento_datechooserInputMethodTextChanged

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        
        if (this.cmbEstado.isEnabled())
        {   
            if (this.cmbEstado.getSelectedIndex() == 0)
            {
                this.lblAvisoEstado.setForeground(Color.RED);
                this.lblAvisoEstado.setText("*Seleccione otra opción*");
            }
            else
            {
                this.lblAvisoEstado.setForeground(Color.GREEN);
                this.lblAvisoEstado.setText("Correcto");
            }
        }
      
    }//GEN-LAST:event_cmbEstadoItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkMostrar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbPuesto;
    private com.toedter.calendar.JDateChooser fecha_nacimiento_datechooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAvisoApellido;
    private javax.swing.JLabel lblAvisoContrseña;
    private javax.swing.JLabel lblAvisoCorreo;
    private javax.swing.JLabel lblAvisoDireccion;
    private javax.swing.JLabel lblAvisoEstado;
    private javax.swing.JLabel lblAvisoIdentidad1;
    private javax.swing.JLabel lblAvisoNombre;
    private javax.swing.JLabel lblAvisoPuesto;
    private javax.swing.JLabel lblAvisoSalario;
    private javax.swing.JLabel lblAvisoTelefono;
    private javax.swing.JLabel lblAvisoUsuario;
    private javax.swing.JPanel pnlInformacionPersonalEmpleado;
    private javax.swing.JPanel pnlInformacionUsuarioEmpleado;
    private javax.swing.JTable tableEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo_electronico;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtIdentidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
