package proyectocasaempeños;

import java.awt.Component;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class Conexion 
{
    private static Connection con;
    private static Statement stm;
    private static ResultSet rss;
    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "123456";
    private static final String url = "jdbc:mysql://localhost:3306/bdd_poo";
    
     public void conector() {

        con = null;
        
        String estado = "";
        
        try
        {
            Class.forName(driver);

            con = (Connection) DriverManager.getConnection(url, user, pass);

            if (con!=null){
                estado = "Conexion establecida";
            }
        }
        catch (ClassNotFoundException | SQLException e){
            estado = "Error de conexion: " + e;
        }
        
        JOptionPane.showMessageDialog(null, estado);
    }
     
     public void Mantenimiento_Empleados(String accion, Integer id_empleado, String identidad, String nombre, String apellido, String usuario, String contrasenia, Integer salario, String telefono, String correo, String direccion, Date fecha_nacimiento, Integer id_puesto, Integer id_estado)
     {
        String estado = "";
        
        try
        {
            String query;
            Conexion.con = (Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            query = "{CALL mantenimiento_empleados(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            CallableStatement cs = con.prepareCall(query);
            cs.setString(1, accion);
            cs.setInt   (2, id_empleado);
            cs.setString(3, identidad);
            cs.setString(4, nombre);
            cs.setString(5, apellido);
            cs.setString(6, Conexion.Encriptar(usuario));
            cs.setString(7, Conexion.Encriptar(contrasenia));
            cs.setInt   (8, salario);
            cs.setString(9, telefono);
            cs.setString(10, correo);
            cs.setString(11, direccion);
            cs.setDate(12, fecha_nacimiento);
            cs.setInt (13, id_puesto);
            cs.setInt (14, id_estado+3);
            cs.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public static String Encriptar(String campo) throws Exception 
    {
        String md5 = null;
        if (null == campo)
            return null;
        try {
            // Crea el objeto MessageDigest para MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            // Actualiza el input string en el objeto message digest
            digest.update(campo.getBytes(), 0, campo.length());
            // Convierte el valor en el objeto message digest en base hexadecimals
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) 
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return md5;
    }
    
    public void ConsultarEmpleados(JTable tabla_empleados) 
    { 
        String estado = ""; 
         
        try 
        { 
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass); 
            Conexion.stm = con.createStatement(); 
            Conexion.rss = stm.executeQuery("Select a.id_empleado, a.identidad, a.nombre, a.apellido, a.fecha_nacimiento, a.telefono, a.correo_electronico, a.direccion, b.descripcion, c.descripcion, a.salario, a.fecha_contratacion from empleados a inner join puestos b on a.id_puesto = b.id_puesto inner join estado c on a.id_estado = c.id_estado where a.id_estado = 4"); 
            DefaultTableModel modelo = (DefaultTableModel) tabla_empleados.getModel(); 
             
            while (rss.next()) 
            { 
                Object [] fila = new Object[12]; 
                 
                for (int i = 0; i<12; i++) 
                { 
                    fila[i] = rss.getObject(i+1); 
                } 
 
                modelo.addRow(fila);               
            } 
                     
            tabla_empleados.setModel(modelo); 
            con.close();
        } 
        catch (SQLException e){ 
            estado = "Error de Conexion: " + e.toString(); 
            JOptionPane.showMessageDialog(null, estado); 
        } 
    }  
    
    
    public void LlenarComboboxEstados(JComboBox estados) 
    { 
        String query = "select * from estado where id_estado in (4,5,6)"; 
 
        String estado = ""; 
         
        try 
        { 
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass); 
            Conexion.stm = con.createStatement(); 
            Conexion.rss = stm.executeQuery(query); 
             
            while (rss.next()) 
            { 
                String dato = rss.getString("descripcion"); 
                estados.addItem(dato);
            } 
            con.close();
        } 
        catch (SQLException e) 
        { 
            estado = "Error de Conexion: " + e.toString(); 
            JOptionPane.showMessageDialog(null, estado); 
        } 
    } 
    
    public void LlenarComboboxPuestos(JComboBox puestos) 
    { 
        String query = "select * from puestos"; 
 
        String estado = ""; 
         
        try 
        { 
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass); 
            Conexion.stm = con.createStatement(); 
            Conexion.rss = stm.executeQuery(query); 
             
            while (rss.next()) 
            { 
                String dato = rss.getString("descripcion"); 
                puestos.addItem(dato); 
            } 
            con.close();
        } 
        catch (SQLException e) 
        { 
            estado = "Error de Conexion: " + e.toString(); 
            JOptionPane.showMessageDialog(null, estado); 
        } 
    } 
    
    public void AjustarAutomaticamenteAnchoColumna(JTable tabla)  
    { 
        final TableColumnModel columnModel = tabla.getColumnModel(); 
        for (int columna = 0; columna < tabla.getColumnCount(); columna++) { 
            int ancho = 100; //ancho minimo  
            for (int fila = 0; fila < tabla.getRowCount(); fila++) { 
                TableCellRenderer renderer = tabla.getCellRenderer(fila, columna); 
                Component comp = tabla.prepareRenderer(renderer, fila, columna); 
                ancho = Math.max(comp.getPreferredSize().width +1 , ancho); 
            } 
            if(ancho > 300) 
                ancho=300; 
            columnModel.getColumn(columna).setPreferredWidth(ancho); 
        } 
    } 
     
    public void BarraBusqueda(String nombre_tabla, String texto, JTable tabla, int columnas, String filtro_adicional) 
    { 
        String estado = ""; 
         
        try 
        { 
            String query; 
            Conexion.con = (Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass); 
            query = "{CALL Busqueda(?, ?, ?)}"; 
            CallableStatement cs = con.prepareCall(query); 
            cs.setString(1, nombre_tabla); 
            cs.setString(2, filtro_adicional); 
            cs.setString(3, texto); 
            Conexion.rss = cs.executeQuery(); 
             
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); 
            modelo.setRowCount(0); 
             
            while (rss.next()) 
            { 
                Object [] fila = new Object[columnas]; 
                 
                for (int i = 0; i<columnas; i++) 
                { 
                    fila[i] = rss.getObject(i+1); 
                } 
 
                modelo.addRow(fila);               
            } 
             
            tabla.setModel(modelo); 
            con.close();
 
        } 
        catch (SQLException e){ 
            estado = "Error de Conexion: " + e.toString(); 
            JOptionPane.showMessageDialog(null, estado); 
        } 
    } 
    
    
    public boolean ValidarIngresarCamposRepetidosEmpleado(String identidad, String nombre, String apellido, String usuario, String contrasenia, String correo)
    {
        String estado = "";
        boolean verificador = false;
        
        try
        {
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select * from empleados");
            
            while (rss.next())
            {
                if (identidad.equals(rss.getString("identidad")))
                {
                    JOptionPane.showMessageDialog(null, "El numero de indentidad ingresado ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                if (nombre.toUpperCase().equals(rss.getString("nombre").toUpperCase()) && apellido.toUpperCase().equals(rss.getString("apellido").toUpperCase()))
                {
                    JOptionPane.showMessageDialog(null, "El nombre completo ingresado ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                if ((Conexion.Encriptar(usuario).equals(rss.getString("usuario"))) && (Conexion.Encriptar(contrasenia).equals(rss.getString("contrasenia"))))
                {
                    JOptionPane.showMessageDialog(null, "El usuario y contraseña ingresados ya se encuentran registrados", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                
                if (correo.equals(rss.getString("correo_electronico")))
                {
                    JOptionPane.showMessageDialog(null, "El correo electrónico ingresado ya se encuentran registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
            }
            
            con.close();
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verificador;
    }
    
    
    public boolean ValidarEditarCamposRepetidosEmpleado(Integer id, String identidad, String nombre, String apellido, String usuario, String contrasenia, String correo)
    {
        String estado = "";
        boolean verificador = false;
        
        try
        {
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select * from empleados where id_empleado != "+id);
            
            while (rss.next())
            {
                if (identidad.equals(rss.getString("identidad")))
                {
                    JOptionPane.showMessageDialog(null, "El numero de indentidad ingresado ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                if (nombre.toUpperCase().equals(rss.getString("nombre").toUpperCase()) && apellido.toUpperCase().equals(rss.getString("apellido").toUpperCase()))
                {
                    JOptionPane.showMessageDialog(null, "El nombre completo ingresado ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                if ((Conexion.Encriptar(usuario).equals(rss.getString("usuario"))) && (Conexion.Encriptar(contrasenia).equals(rss.getString("contrasenia"))))
                {
                    JOptionPane.showMessageDialog(null, "El usuario y contraseña ingresados ya se encuentran registrados", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                
                if (correo.equals(rss.getString("correo_electronico")))
                {
                    JOptionPane.showMessageDialog(null, "El correo electrónico ingresado ya se encuentran registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
            }
            
            con.close();
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verificador;
    }
    
    public void llenarCmbEstadoObjetos(JComboBox estadoObjetos) {
        
        String estado = "";
        
        try{
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select * from estado where id_estado = 2 or id_estado = 3;");
            DefaultComboBoxModel modelo = (DefaultComboBoxModel) estadoObjetos.getModel();
            
            
            while (rss.next())
            {
                modelo.addElement(rss.getString("descripcion"));
            }
            
            estadoObjetos.setModel(modelo);

            con.close();
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        }
    }
     
    public void llenarTablaInventario (JTable inventario) {
        String estado = "";
        
        try
        {
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select a.id_producto, b.descripcion as estado, a.descripcion, a.cantidad_disponible, a.precio_referencial_venta from inventario a inner join estado b on a.id_estado = b.id_estado where a.id_estado = 2 or a.id_estado = 3;");
            DefaultTableModel modelo = (DefaultTableModel) inventario.getModel();
            
            while (rss.next())
            {
                // Se crea un array que será una de las filas de la tabla.
                Object [] fila = new Object[5]; // Hay dos columnas en la tabla
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.

                fila[0] = rss.getObject(1);
                fila[1] = rss.getObject(2);
                fila[2] = rss.getObject(3);
                fila[3] = rss.getObject(4);
                fila[4] = rss.getObject(5);
                
                // El primer indice en rs es el 1, no el cero, por eso se suma 1.

                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
            
            inventario.setModel(modelo);

            DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
            centrado.setHorizontalAlignment(JLabel.CENTER);
            
            for (int i = 0; i<5; i++)
            {
                inventario.getColumnModel().getColumn(i).setCellRenderer(centrado);
            }
            
            con.close();

        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        }
    }
    
    public int obtenerCodigoCmbEstadoObjetos(String estadoObjeto) {
        
        String estado = "";
        
        Integer valor=0;
        
        try{
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select * from estado where descripcion = '"+estadoObjeto+"';");
                       
            
            while (rss.next())
            {
                valor=Integer.parseInt(rss.getString("id_estado"));
            }

            con.close();
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        }
        
        return valor;
    }
    
    public void modificar(String nomProducto, Integer cantidad, Integer precio, Integer estado, String usuario, String fecha, Integer id){
                
        String mensaje = "";
        
        PreparedStatement pstm = null;
        
        try
        {
            
            //JOptionPane.showMessageDialog(null, fecha + " codigo: "+id);
            this.con = (Connection) DriverManager.getConnection(this.url, this.user, this.pass); //DriverManager.getConnection("jdbc:mysql://localhost:3306/bdalumnos?useServerPrepStmts=true",this.user, this.pass);
                     //(Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            pstm = con.prepareStatement("UPDATE inventario SET descripcion = ?, cantidad_disponible = ?, precio_referencial_venta = ?, id_estado = ?, usuario_modifico = ?, fecha_modifico = ? WHERE id_producto = ?");
            
            pstm.setString(1, nomProducto);
            pstm.setInt(2, cantidad);
            pstm.setInt(3, precio);
            pstm.setInt(4, estado);
            pstm.setString(5, usuario);
            pstm.setString(6, fecha);
            pstm.setInt(7, id);

            
            //pstm.executeQuery();
            Integer retorno = pstm.executeUpdate();
            //JOptionPane.showMessageDialog(null, retorno);
            if(retorno>0)
                mensaje="Datos modificados exitosamente";            
            
            con.close();
        }
        catch (SQLException e){
            mensaje="Error de conexion: " + e;
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void ingresarCliente( String identidadCliente, String nombreCliente, String apellidoCliente, String usuarioActual ){
        
        // Fecha.
        Calendar calendario = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date( calendario.getTime().getTime() );

        try{
            
            this.con = ( Connection ) DriverManager.getConnection( this.url, this.user, this.pass );
            
            String query = "INSERT INTO clientes (identidad, nombre, apellido, id_estado_logico, usuario_ingreso, fecha_ingreso) VALUES (?, ?, ?, '1', ?, ?);";
            
            PreparedStatement preparedStmt = con.prepareStatement( query );
            
            preparedStmt.setString ( 1, identidadCliente );
            preparedStmt.setString ( 2, nombreCliente );
            preparedStmt.setString ( 3, apellidoCliente );
            preparedStmt.setString ( 4, usuarioActual );
            preparedStmt.setDate   ( 5, startDate );
            
            preparedStmt.execute();
            
            con.close();
          }
          catch (Exception e){
              
              System.err.println("¡Hubo un error!");
              System.err.println(e.getMessage());
          }
    }
    
    public void ingresarCompraInventario( JTable tabla ){
        
        try{
            
            this.con = ( Connection ) DriverManager.getConnection( this.url, this.user, this.pass );
            
            int filas = tabla.getRowCount();
            
            for( Integer fila=0; fila<filas; fila++ ){
                
                String query = "INSERT INTO inventario (descripcion, cantidad_disponible, id_estado) VALUES (?, ?, '3');";

                PreparedStatement preparedStmt = con.prepareStatement( query );
                
                preparedStmt.setString ( 1, ( String ) tabla.getValueAt( fila, 0 ).toString() );
                preparedStmt.setInt    ( 2, ( Integer ) Integer.parseInt( tabla.getValueAt( fila, 2 ).toString() ) );

                preparedStmt.execute();
            }
            
            con.close();
          }
          catch (Exception e){
              
              System.err.println("¡Hubo un error!");
              System.err.println(e.getMessage());
          }
    }
    
    public void ingresarCompra( String idCliente, String usuarioActual ){
        
        // Fecha.
        Calendar calendario = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date( calendario.getTime().getTime() );

        try{
            
            this.con = ( Connection ) DriverManager.getConnection( this.url, this.user, this.pass );
            
            String query = "INSERT INTO compras (fecha_compra, id_cliente, id_empleado) VALUES (?, ?, ?);";
            
            PreparedStatement preparedStmt = con.prepareStatement( query );
            
            preparedStmt.setDate   ( 1, startDate );
            preparedStmt.setString ( 2, idCliente );
            preparedStmt.setString ( 3, usuarioActual );
            
            preparedStmt.execute();
            
            con.close();
          }
          catch (Exception e){
              
              System.err.println("¡Hubo un error!");
              System.err.println(e.getMessage());
          }
    }
    
    public String obtenerCodigoClienteIngresar( String identidad ) {
        
        String estado="", valor="";
        
        try{
            
            Conexion.con = ( com.mysql.jdbc.Connection ) DriverManager.getConnection( Conexion.url, Conexion.user, Conexion.pass );
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery( "SELECT * FROM clientes WHERE identidad = '" + identidad + "';" );
            
            while (rss.next())
            {
                valor = rss.getString( "id_cliente" );
            }

            con.close();
        }
        catch( SQLException e ){
            
            estado = "Error de conexión: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        }
        
        return valor;
    }
    
    public void ingresarDetallesCompra( JTable tabla ){
        
        try{
            
            this.con = ( Connection ) DriverManager.getConnection( this.url, this.user, this.pass );
            
            int filas=tabla.getRowCount(), idCompra=0, i=0;
            Integer[] idProductos = new Integer[filas];
            
            Conexion.stm = con.createStatement();
            
            Conexion.rss = stm.executeQuery("SELECT * FROM inventario ORDER BY id_producto DESC LIMIT " + filas);
            
            while( rss.next() ){
                
                idProductos[i] = rss.getInt( "id_producto" );
                
                i++;
            }
            
            Conexion.stm = con.createStatement();
            
            Conexion.rss = stm.executeQuery( "SELECT * FROM compras" );
            
            while( rss.next() ){
                
                idCompra = rss.getInt( "id_compra" );
            }
            
            for( Integer fila=0; fila<filas; fila++ ){
                
                String query = "INSERT INTO detalle_compras (id_producto, id_compra, precio_compra, cantidad) VALUES (?, ?, ?, ?);";

                PreparedStatement preparedStmt = con.prepareStatement( query );
                
                preparedStmt.setInt( 1, idProductos[fila]);
                preparedStmt.setInt( 2, idCompra );
                preparedStmt.setInt( 3, Integer.parseInt( tabla.getValueAt( fila, 2 ).toString() ) );
                preparedStmt.setInt( 4, Integer.parseInt( tabla.getValueAt( fila, 1 ).toString() ) );                
                preparedStmt.execute();
            }
            
            con.close();
          }
          catch (Exception e){
              
              System.err.println("¡Hubo un error!");
              System.err.println(e.getMessage());
          }
    }
    
    public boolean validarIdentidadRepetidaCliente( String identidad )
    {
        String estado = "";
        boolean verificador = false;
        
        try
        {
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select * from clientes");
            
            while (rss.next())
            {
                if (identidad.equals(rss.getString("identidad")))
                {
                    JOptionPane.showMessageDialog( null, "El número de indentidad ingresado ya se encuentra registrado.", "¡Error!", JOptionPane.ERROR_MESSAGE );
                    verificador = true;
                }
            }
            
            con.close();
        }
        catch (SQLException e){
            estado = "Error de conexión: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verificador;
    }
    
    
    
    ///////////////////////////////////
     ///CLIENTES
     
     public void Mantenimiento_Clientes(String accion, Integer id_cliente, String identidad, String nombre, String apellido, String telefono, String correo, String direccion)
     {
        String estado = "";
        
        try
        {
            String query;
            Conexion.con = (Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            query = "{CALL Mantenimiento_clientes(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cs = con.prepareCall(query);
            cs.setString(1, accion);
            cs.setInt   (2, id_cliente);
            cs.setString(3, identidad);
            cs.setString(4, nombre);
            cs.setString(5, apellido);
            cs.setString(6, telefono);
            cs.setString(7, correo);
            cs.setString(8, direccion);
            cs.executeUpdate();
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        }
    }
     
     public void ConsultarClientes(JTable tabla_clientes)
    {
         String estado = ""; 
         
        try 
        { 
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass); 
            Conexion.stm = con.createStatement(); 
            Conexion.rss = stm.executeQuery("Select id_cliente, identidad, nombre, apellido, telefono, correo_electronico, direccion from clientes where id_estado_logico = 1"); 
            DefaultTableModel modelo = (DefaultTableModel) tabla_clientes.getModel(); 
             
            while (rss.next()) 
            { 
                Object [] fila = new Object[7]; 
                 
                for (int i = 0; i<7; i++) 
                { 
                    fila[i] = rss.getObject(i+1); 
                } 
 
                modelo.addRow(fila);               
            } 
                     
            tabla_clientes.setModel(modelo); 
            con.close();
        } 
        catch (SQLException e){ 
            estado = "Error de Conexion: " + e.toString(); 
            JOptionPane.showMessageDialog(null, estado); 
        } 
    }
     
     
     
      public boolean ValidarIngresarCamposRepetidosClientes(String identidad, String nombre, String apellido, String correo)
    {
        String estado = "";
        boolean verificador = false;
        
        try
        {
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select * from clientes");
            
            while (rss.next())
            {
                if (identidad.equals(rss.getString("identidad")))
                {
                    JOptionPane.showMessageDialog(null, "El numero de indentidad ingresado ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                if (nombre.toUpperCase().equals(rss.getString("nombre").toUpperCase()) && apellido.toUpperCase().equals(rss.getString("apellido").toUpperCase()))
                {
                    JOptionPane.showMessageDialog(null, "El nombre completo ingresado ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                
                if (correo.equals(rss.getString("correo_electronico")))
                {
                    JOptionPane.showMessageDialog(null, "El correo electrónico ingresado ya se encuentran registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
            }
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verificador;
    }
      
    public boolean ValidarEditarCamposRepetidosClientes(Integer id, String identidad, String nombre, String apellido, String correo)
    {
        String estado = "";
        boolean verificador = false;
        
        try
        {
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select * from clientes where id_cliente != "+id);
            
            while (rss.next())
            {
                if (identidad.equals(rss.getString("identidad")))
                {
                    JOptionPane.showMessageDialog(null, "El numero de indentidad ingresado ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                if (nombre.toUpperCase().equals(rss.getString("nombre").toUpperCase()) && apellido.toUpperCase().equals(rss.getString("apellido").toUpperCase()))
                {
                    JOptionPane.showMessageDialog(null, "El nombre completo ingresado ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
                
                
                if (correo.equals(rss.getString("correo_electronico")))
                {
                    JOptionPane.showMessageDialog(null, "El correo electrónico ingresado ya se encuentran registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    verificador = true;
                }
            }
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verificador;
    }
    
    public void ingresarcliente(String Identidad,String Nombre,String Apellido,String Telefono,String Correo,String Direccion)
     {
        

        try 
        {
            //
            Conexion.con = (Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            String SQL = "INSERT INTO `bdd_poo`.`clientes`(`identidad`,`nombre`,`apellido`,`telefono`,`correo_electronico`,`direccion`) values(?,?,?,?,?,?)";
            JOptionPane.showMessageDialog(null,"Los datos del cliente fueron insertados correctamente");
            
            PreparedStatement stm = con.prepareStatement(SQL);
            
            stm.setString(1, Identidad);
            stm.setString(2, Nombre);
            stm.setString(3, Apellido);
            stm.setString(4, Telefono);
            stm.setString(5, Correo);
            stm.setString(6, Direccion);
            
            stm.executeUpdate();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ocurrio un problema en la base de datos"+e);
            e.printStackTrace();
        }
    }
     
    public void ingresararticulo(String NombreArticulo,int Cantidad,int MontoAcordado , int estado)
    {
        try 
        {
            Conexion.con = (Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            String SQL = "INSERT INTO `bdd_poo`.`inventario` (`descripcion`,`cantidad_disponible`,`precio_referencial_venta`,`id_estado`) values(?,?,?,?)";
           
            
            PreparedStatement stm = con.prepareStatement(SQL);
            
            stm.setString(1, NombreArticulo);
            stm.setInt(2, Cantidad);
            stm.setInt(3, MontoAcordado);
            stm.setInt(4, estado);
            stm.executeUpdate();
             JOptionPane.showMessageDialog(null,"Los datos del articulo fueron insertados correctamente");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ocurrio un problema en la base de datos"+e);
            e.printStackTrace();
        }
    }
    public void ingresarcontrato(int id_cliente,int id_estado,int monto_acordado)
    {
        try 
        {
            Conexion.con = (Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            String SQL = "INSERT INTO `bdd_poo`.`contratos` (`id_cliente`,`id_estado`,`monto_acordado`) values(?,?,?)";
           
            
            PreparedStatement stm = con.prepareStatement(SQL);
            
            stm.setInt(1, id_cliente);
            stm.setInt(2, id_estado);
            stm.setInt(3, monto_acordado);
            
            stm.executeUpdate();
             JOptionPane.showMessageDialog(null,"Los datos fueron insertados correctamente");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ocurrio un problema en la base de datos"+e);
            e.printStackTrace();
        }
    }
    
     public ArrayList <String> comboestado(JComboBox roles)
     {
         
         ArrayList<String> lista = new ArrayList<>();
         try
         {
             Conexion.con = (Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
             Conexion.stm = con.createStatement();
             Conexion.rss = stm.executeQuery("Select*from estado");
             
             while(rss.next())
             {
                 lista.add(rss.getString("descripcion"));
                 
                 
             }    
             roles.removeAllItems();
             roles.addItem("Seleccione uno");
             for (int i = 0; i < lista.size(); i++) {
               roles.addItem(lista.get(i));    
             }
             
             
         }
         catch (Exception ex) {
             JOptionPane.showMessageDialog(null, ex);
         }
        
         return lista;
     }
     
    
    


}