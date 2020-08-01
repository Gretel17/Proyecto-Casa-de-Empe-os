
package proyectocasaempeños;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CompartirDatosProducto 
{
    public static boolean datos_llenos = false;  
    public static Integer id_producto = null;
    public static String nombre_producto = null;
    public static String precio_producto = null;
    public static Integer cantidad_disponible = null;
    public static JTable tabla_productos_disponibles;
}
