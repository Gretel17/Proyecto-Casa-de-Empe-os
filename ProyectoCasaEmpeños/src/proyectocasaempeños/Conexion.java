
package proyectocasaempeños;

import java.sql.Connection;
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
    
    public void llenarCmbEstadoObjetos(JComboBox estadoObjetos) {
        
        String estado = "";
        
        try{
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            Conexion.rss = stm.executeQuery("select * from estado where descripcion != 'Empeñado';");
            DefaultComboBoxModel modelo = (DefaultComboBoxModel) estadoObjetos.getModel();
            
            
            while (rss.next())
            {
                modelo.addElement(rss.getString("descripcion"));
            }
            
            estadoObjetos.setModel(modelo);

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
            Conexion.rss = stm.executeQuery("select a.id_producto, b.descripcion as estado, a.descripcion, a.cantidad_disponible, a.precio_referencial_venta from inventario a inner join estado b on a.id_estado = b.id_estado where b.descripcion != 'Empeñado'");
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

        }
        catch (SQLException e){
            estado = "Error de Conexion: " + e.toString();
            JOptionPane.showMessageDialog(null, estado);
        }
    }
    
    public void ConsultarTablaInventario (JTable inventario, String filtro, String buscar) {
        String estado = "";
        
        PreparedStatement pstm = null;
        
        try
        {
            Conexion.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(Conexion.url, Conexion.user, Conexion.pass);
            Conexion.stm = con.createStatement();
            if(filtro.equals("Estado")){
                Conexion.rss = stm.executeQuery("select a.id_producto, b.descripcion as estado, a.descripcion, a.cantidad_disponible, a.precio_referencial_venta from inventario a inner join estado b on a.id_estado = b.id_estado "
                    + "where b.descripcion != 'Empeñado' and b.descripcion like '%"+buscar+"%'");
                /*pstm = con.prepareStatement("select b.descripcion as estado, a.descripcion, a.cantidad_disponible, a.precio_referencial_venta from inventario a inner join estado b on a.id_estado = b.id_estado "
                    + "where b.descripcion != 'Empeñado' and b.descripcion like '%"+buscar+"%'");*/
            }
            
            if(filtro.equals("Nombre")){
                Conexion.rss = stm.executeQuery("select a.id_producto, b.descripcion as estado, a.descripcion, a.cantidad_disponible, a.precio_referencial_venta from inventario a inner join estado b on a.id_estado = b.id_estado "
                    + "where b.descripcion != 'Empeñado' and a.descripcion like '%"+buscar+"%'");
                    /*pstm = con.prepareStatement("select b.descripcion as estado, a.descripcion, a.cantidad_disponible, a.precio_referencial_venta from inventario a inner join estado b on a.id_estado = b.id_estado "
                    + "where b.descripcion != 'Empeñado' and a.descripcion like '%?%'");
                    pstm.setString(1, buscar);*/
            }
            
            if(filtro.equals("Precio")){
                Conexion.rss = stm.executeQuery("select a.id_producto, b.descripcion as estado, a.descripcion, a.cantidad_disponible, a.precio_referencial_venta from inventario a inner join estado b on a.id_estado = b.id_estado "
                    + "where b.descripcion != 'Empeñado' and a.precio_referencial_venta = '"+buscar+"'");
                    /*pstm = con.prepareStatement("select b.descripcion as estado, a.descripcion, a.cantidad_disponible, a.precio_referencial_venta from inventario a inner join estado b on a.id_estado = b.id_estado "
                    + "where b.descripcion != 'Empeñado' and a.precio_referencial_venta = '?'");
                    pstm.setString(1, buscar);*/
            }
            
            
            //Conexion.rss = pstm.executeQuery();
            
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
            
        }
        catch (SQLException e){
            mensaje="Error de conexion: " + e;
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
