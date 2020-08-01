package proyectocasaempeños;

import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class RecuperarContrasena extends javax.swing.JFrame {
    
    static Integer codigoConfirmacion = (int) ( Math.random() * 8999 + 1000 );
    
    public RecuperarContrasena() {
        
        initComponents();
        
        DeshabilitarCopiarPegar();
    }
    
    public static void enviarCorreoRecuperacion( String correo ) throws Exception{
        
        Properties propiedades = new Properties();
        
        propiedades.put( "mail.smtp.auth", "true" );
        propiedades.put( "mail.smtp.starttls.enable", "true" );
        propiedades.put( "mail.smtp.host", "smtp.gmail.com" );
        propiedades.put( "mail.smtp.port", "587" );
        
        String miCuentaCorreo="osegueraluis436@gmail.com";
        String contrasenaCuentaCorreo="4L2u1i4s";
        
        Session sesion = Session.getInstance( propiedades, new Authenticator() {
            
            @Override
            
            protected PasswordAuthentication getPasswordAuthentication(){
                
                return new PasswordAuthentication( miCuentaCorreo, contrasenaCuentaCorreo );
            }
            
        });
        
        Message mensaje = prepareMessage( sesion, miCuentaCorreo, correo );
        
        Transport.send( mensaje );
    }
    
    private static Message prepareMessage( Session sesion, String miCuentaCorreo, String correo ){
        
        try{
            
            Message mensaje = new MimeMessage( sesion );
            
            mensaje.setFrom( new InternetAddress( miCuentaCorreo ) );
            
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress( correo ) );
            mensaje.setSubject( "Código de recuperación" );
            mensaje.setText( "Tu código de confirmación es: " + codigoConfirmacion );
            
            return mensaje;
        }
        catch( Exception ex ){
            
            Logger.getLogger(RecuperarContrasena.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private void DeshabilitarCopiarPegar(){
        
        this.txtNombreUsuario.setTransferHandler(null);
        this.txtCodigoAcceso.setTransferHandler(null);
        this.pswContrasenaNueva.setTransferHandler(null);
        this.pswRepetirContrasena.setTransferHandler(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoAcceso = new javax.swing.JTextField();
        btnVerificarCodigo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pswContrasenaNueva = new javax.swing.JPasswordField();
        pswRepetirContrasena = new javax.swing.JPasswordField();
        btnCambiarContrasena = new javax.swing.JButton();
        chkMostrarContrasenas = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recuperar Contraseña");
        setResizable(false);

        jLabel1.setText("Ingrese su nombre de usuario:");

        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyTyped(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar código acceso"));

        jLabel2.setText("Ingrese el código de acceso que recibió:");

        txtCodigoAcceso.setEnabled(false);
        txtCodigoAcceso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoAccesoKeyTyped(evt);
            }
        });

        btnVerificarCodigo.setText("Verificar");
        btnVerificarCodigo.setEnabled(false);
        btnVerificarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarCodigoActionPerformed(evt);
            }
        });

        jLabel3.setText("Contraseña nueva:");

        jLabel4.setText("Repetir contraseña:");

        pswContrasenaNueva.setEchoChar('\u25cf');
        pswContrasenaNueva.setEnabled(false);
        pswContrasenaNueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pswContrasenaNuevaKeyTyped(evt);
            }
        });

        pswRepetirContrasena.setEchoChar('\u25cf');
        pswRepetirContrasena.setEnabled(false);

        btnCambiarContrasena.setText("Cambiar contraseña");
        btnCambiarContrasena.setEnabled(false);
        btnCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContrasenaActionPerformed(evt);
            }
        });

        chkMostrarContrasenas.setToolTipText("");
        chkMostrarContrasenas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocasaempeños/Imágenes/ojo.png"))); // NOI18N
        chkMostrarContrasenas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkMostrarContrasenasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pswContrasenaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(pswRepetirContrasena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkMostrarContrasenas))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnCambiarContrasena))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigoAcceso)
                                    .addComponent(btnVerificarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                .addGap(71, 71, 71))
                            .addComponent(jLabel2))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerificarCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(pswContrasenaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkMostrarContrasenas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pswRepetirContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarContrasena)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel1)))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        InicioSesion inicioSesion = new InicioSesion();
        
        inicioSesion.setVisible( true );
        
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVerificarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarCodigoActionPerformed
        
        if( this.txtCodigoAcceso.getText().isEmpty() ){
            
            JOptionPane.showMessageDialog( null, "Ingrese el código.", "¡Error!", JOptionPane.ERROR_MESSAGE );
        }
        else{
            
            if( Integer.parseInt( this.txtCodigoAcceso.getText() ) == codigoConfirmacion ){

                this.txtCodigoAcceso.setEditable(false);
                this.pswContrasenaNueva.setEnabled(true);
                this.pswRepetirContrasena.setEnabled(true);
                this.btnCambiarContrasena.setEnabled(true);
                this.btnVerificarCodigo.setEnabled(false);
            }
            else{

                JOptionPane.showMessageDialog( null, "El código que ingresó no es correcto, intente de nuevo.", "Código incorrecto", JOptionPane.ERROR_MESSAGE );

                this.txtCodigoAcceso.setText(null);
            }
        }
    }//GEN-LAST:event_btnVerificarCodigoActionPerformed

    private void btnCambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContrasenaActionPerformed
        
        if( this.pswContrasenaNueva.getPassword().length == 0 || this.pswRepetirContrasena.getPassword().length == 0 ){
            
            JOptionPane.showMessageDialog( null, "Rellene todos los campos correspondientes.", "¡Error!", JOptionPane.ERROR_MESSAGE );
        }
        else{
            
            Conexion conexion = new Conexion();
            conexion.ocuparContrasena = false;
            conexion.ingresarInicioSesion( this.txtNombreUsuario.getText(), null );

            if( Arrays.equals( this.pswContrasenaNueva.getPassword(), this.pswRepetirContrasena.getPassword() ) ){
                
                conexion.cambiarContrasena( this.pswRepetirContrasena.getText().toString() );
                
                JOptionPane.showMessageDialog( null, "La contraseña fue cambiada con éxito.", "Contraseña cambiada", JOptionPane.INFORMATION_MESSAGE );
                
                InicioSesion inicioSesion = new InicioSesion();
                inicioSesion.setVisible(true);
                this.dispose();
            }
            else{
                
                JOptionPane.showMessageDialog( null, "Las contraseñas no coinciden.", "¡Error!", JOptionPane.ERROR_MESSAGE );
            }           
        }
    }//GEN-LAST:event_btnCambiarContrasenaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        Conexion conexion = new Conexion();
        
        conexion.ocuparContrasena = false;
        conexion.ingresarInicioSesion( this.txtNombreUsuario.getText(), null );
        
        if( conexion.usuarioCoincideRecuperarContrasena ){
            
            try{

                enviarCorreoRecuperacion( conexion.correoRecuperacion );
            }
            catch( Exception ex ){

                Logger.getLogger(RecuperarContrasena.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.txtNombreUsuario.setEditable(false);
            this.btnAceptar.setEnabled(false);
            this.txtCodigoAcceso.setEnabled(true);
            this.btnVerificarCodigo.setEnabled(true);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCodigoAccesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoAccesoKeyTyped
        
        if( !Character.isDigit( evt.getKeyChar() ) ){
            
            evt.consume();
        }
        else if( this.txtCodigoAcceso.getText().length() >= 4 ){
            
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoAccesoKeyTyped

    private void pswContrasenaNuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswContrasenaNuevaKeyTyped
        
        if( this.txtCodigoAcceso.getText().length() >= 50 ){
            
            evt.consume();
        }
    }//GEN-LAST:event_pswContrasenaNuevaKeyTyped

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void txtNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyTyped
        
        if( this.txtCodigoAcceso.getText().length() >= 15 ){
            
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreUsuarioKeyTyped

    private void chkMostrarContrasenasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkMostrarContrasenasMouseClicked
        
        if( this.chkMostrarContrasenas.isSelected() ){
            
            this.pswContrasenaNueva.setEchoChar((char)0);
            this.pswRepetirContrasena.setEchoChar((char)0);
        }
        else{

            this.pswContrasenaNueva.setEchoChar('\u25cf');
            this.pswRepetirContrasena.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_chkMostrarContrasenasMouseClicked

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
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecuperarContrasena().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCambiarContrasena;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVerificarCodigo;
    private javax.swing.JCheckBox chkMostrarContrasenas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pswContrasenaNueva;
    private javax.swing.JPasswordField pswRepetirContrasena;
    private javax.swing.JTextField txtCodigoAcceso;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}