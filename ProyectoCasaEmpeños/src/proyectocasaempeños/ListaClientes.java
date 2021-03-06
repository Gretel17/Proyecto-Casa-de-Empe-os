/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocasaempeños;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author grete
 */
public class ListaClientes extends javax.swing.JFrame {
    
    Conexion con = new Conexion ();
    private static Connection conn;
    private static java.sql.Statement stm;
    private static ResultSet rss;
    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/bdd_poo";
    
    

    /**
     * Creates new form ListaClientes
     */
    public ListaClientes() {
        initComponents();
        this.buscar(this.txtbuscar.getText(),cbfiltro.getSelectedItem().toString(),this.listabuscarcliente);
        this.setLocationRelativeTo(null);
        Conexion con = new Conexion();
       /* con.AjustarAutomaticamenteAnchoColumna(listabuscarcliente);
        this.listabuscarcliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.OcultarColumnas();
        this.setTransferHandler(null);
        */
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listabuscarcliente = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        cbfiltro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Listado de clientes");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Buscar:");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        listabuscarcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identidad", "Nombre", "Apellido", "Telefono", "Correo Electronico", "Direccion"
            }
        ));
        listabuscarcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listabuscarclienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listabuscarcliente);

        jButton6.setText("Regresar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        cbfiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Identidad", "Nombre", "Apellido", " " }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(cbfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(145, 145, 145))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(cbfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        IngresoEmpeños empeñito= new IngresoEmpeños ();
        this.setVisible(false);
        empeñito.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
       /* Conexion con = new Conexion();
        con.BarraBusqueda("clientes",this.txtbuscar.getText(),this.listabuscarcliente,6,null);
        this.txtbuscar.setEnabled(true);
       */
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        //ConsultaBuscar(this.txtbuscar.getText());
        buscar(this.txtbuscar.getText(),cbfiltro.getSelectedItem().toString(),this.listabuscarcliente);
        this.RefreshTable();
        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void listabuscarclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listabuscarclienteMouseClicked
        
        // TODO add your handling code here:
        compartirdatoscliente compartir = new compartirdatoscliente();
        int seleccion = this.listabuscarcliente.rowAtPoint(evt.getPoint()); 

        compartirdatoscliente.id =(String.valueOf(listabuscarcliente.getModel().getValueAt(seleccion, 0))); 
        compartirdatoscliente.nombre = (String.valueOf(listabuscarcliente.getModel().getValueAt(seleccion, 1)));
        compartirdatoscliente.apellido = (String.valueOf(listabuscarcliente.getModel().getValueAt(seleccion, 2)));
        compartirdatoscliente.telefono = (String.valueOf(listabuscarcliente.getModel().getValueAt(seleccion, 3)));
        compartirdatoscliente.correo = (String.valueOf(listabuscarcliente.getModel().getValueAt(seleccion, 4)));
        compartirdatoscliente.direccion = (String.valueOf(listabuscarcliente.getModel().getValueAt(seleccion, 5)));
        compartirdatoscliente.datos_llenos=true;
        //
    }//GEN-LAST:event_listabuscarclienteMouseClicked

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
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbfiltro;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable listabuscarcliente;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    
    
    
    
   /* public void Consulta()
    {
  
        try
        {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            DefaultTableModel model = new DefaultTableModel();
            stm = conn.createStatement();
            
            rss=stm.executeQuery("Select a.identidad, a.nombre , a.apellido,a.telefono , a.correo_electronico , a.direccion from clientes as a");
           
            model.addColumn("Identidad");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Telefono");
            model.addColumn("Correo Electronico");
            model.addColumn("Direccion");
            
            
            while(rss.next())
            {
              Object fila[] = new Object[6];
              
            for(int i =0;i<6;i++){
                fila[i]=rss.getObject(i+1);
            }
              model.addRow(fila);
            }
            this.listabuscarcliente.setModel(model);
        }        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }   
     }
    
    */
    /*
    public void ConsultaBuscar(String buscar)
    {
        
        try
        {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            DefaultTableModel model = new DefaultTableModel();
            stm = conn.createStatement();
            rss=stm.executeQuery("Select  a.identidad , a.nombre,a.apellido, a.telefono, a.correo_electronico, a.direccion From clientes as a inner join contratos as b on a.id_cliente=b.id_cliente inner join estado as c on b.id_estado =c.id_estado "+ "where a.nombre like '%"+buscar+"%'");
            
            model.addColumn("Identidad");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Telefono");
            model.addColumn("Correo Electronico");
            model.addColumn("Direccion");
            
            
            while(rss.next())
            {
              Object fila[] = new Object[6];
              
            for(int i =0;i<6;i++){
                fila[i]=rss.getObject(i+1);
            }
              model.addRow(fila);
            }
            this.listabuscarcliente.setModel(model);
        }        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }   
     }
        */
    
  /*   public void Empeñados()
    {
        
        try
        {
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            DefaultTableModel model = new DefaultTableModel();
            stm = conn.createStatement();
            rss=stm.executeQuery("");
            
            model.addColumn("Identidad");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Telefono");
            model.addColumn("Correo Electronico");
            model.addColumn("Direccion");
            
            
            while(rss.next())
            {
              Object fila[] = new Object[6];
              
            for(int i =0;i<6;i++){
                fila[i]=rss.getObject(i+1);
            }
              model.addRow(fila);
            }
            this.listabuscarcliente.setModel(model);
        }        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }   
     }
    */
     
    
      
    private void buscar(String valor,String filtro,JTable tabla) {
       
        try {
             String [] columnas={"identidad","nombre","apellido","telefono","correo_electronico","direccion"};
             String [] registro=new String[6];
             Conexion con = new Conexion ();
             conn = (Connection) DriverManager.getConnection(url, user, pass);
             DefaultTableModel model = new DefaultTableModel();
             model=new DefaultTableModel(null,columnas);
             stm = conn.createStatement();
             Connection conect = null;
             
             if(filtro.equals("Nombre")){
                 rss=stm.executeQuery("Select identidad,nombre,apellido,telefono,correo_electronico,direccion FROM clientes"+" WHERE nombre LIKE '%"+valor+"%'");
             }
             else if(filtro.equals("Apellido")){
             rss=stm.executeQuery("Select identidad,nombre,apellido,telefono,correo_electronico,direccion FROM clientes"+" WHERE apellido LIKE '%"+valor+"%'");
                 
             }
             else if(filtro.equals("Identidad"))
             {
                 rss=stm.executeQuery("Select identidad,nombre,apellido,telefono,correo_electronico,direccion FROM clientes"+" WHERE identidad LIKE '%"+valor+"%'");
                 
             }
             while(rss.next()){
                 
                 registro[0]=rss.getString("identidad");
                 registro[1]=rss.getString("nombre");
                 registro[2]=rss.getString("apellido");
                 registro[3]=rss.getString("telefono");
                 registro[4]=rss.getString("correo_electronico");
                 registro[5]=rss.getString("direccion");
                 
                model.addRow(registro);
             }
             
                
            
            
             tabla.setModel(model);
             
             
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }  
         
         
    }

    public void RefreshTable(){
         this.listabuscarcliente.setModel(new DefaultTableModel());
         this.buscar(this.txtbuscar.getText(),cbfiltro.getSelectedItem().toString(),this.listabuscarcliente);
     }


         
         
         
       



}
