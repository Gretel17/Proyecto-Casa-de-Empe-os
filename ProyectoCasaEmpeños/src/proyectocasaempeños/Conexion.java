
package proyectocasaempeños;

import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Conexion 
{
    private static Connection con;
    private static Statement stm;
    private static ResultSet rss;
    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
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
            cs.setString(6, usuario);
            cs.setString(7, contrasenia);
            cs.setInt   (8, salario);
            cs.setString(9, telefono);
            cs.setString(10, correo);
            cs.setString(11, direccion);
            cs.setDate(12, fecha_nacimiento);
            cs.setInt (13, id_puesto);
            cs.setInt (14, id_estado);
            cs.executeUpdate();
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        }
    }
     
     public void ConsultarEmpleados(JTable tabla_empleados)
    {
        String estado = "";
        
        try
        {
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("Select a.id_empleado, a.identidad, a.nombre, a.apellido, a.fecha_nacimiento, a.telefono, a.correo_electronico, a.direccion, b.descripcion, c.descripcion, a.salario, a.fecha_contratacion, a.fecha_despido from empleados a inner join puestos b on a.id_puesto = b.id_puesto inner join estado c on a.id_estado = c.id_estado");
            DefaultTableModel modelo = (DefaultTableModel) tabla_empleados.getModel();
            
            while (rss.next())
            {
                Object [] fila = new Object[13];
                
                for (int i = 0; i<13; i++)
                {
                    fila[i] = rss.getObject(i+1);
                }

                modelo.addRow(fila);              
            }
                    
            tabla_empleados.setModel(modelo);
            
        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        }
    } 
    
}
