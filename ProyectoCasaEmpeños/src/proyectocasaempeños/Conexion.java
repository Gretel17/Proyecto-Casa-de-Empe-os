
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    private static final String pass = "Daniel100";
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
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verificador;
    }
}
