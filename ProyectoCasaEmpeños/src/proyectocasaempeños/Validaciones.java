
package proyectocasaempeños;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import org.apache.commons.validator.routines.EmailValidator;


public class Validaciones 
{
    
    public boolean ValidarCorreo(String correo)
    {
        boolean resultado = true;
        
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

        Matcher mather = pattern.matcher(correo);

        if (mather.find() == false) 
        {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error el correo electrónico, no es valido", "Error", JOptionPane.ERROR_MESSAGE);
	} 
    
        return resultado;
    }
    
    
     public int campoVacio(JTextField campo){
        
        int mensaje = 0;
        
        if (campo.getText().isEmpty()) 
        {
            mensaje=1;
        }else{
            if(campo.getText().matches("^\\s*$") == true){
                mensaje=2;
            }
            
        }
        return mensaje; 
    }
   
    public void validarEspacios(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if ((caracter == KeyEvent.VK_SPACE))
        {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar espacios.");
            evt.consume();
        }
         
    }
    
    public boolean validarLongitud(KeyEvent evt, Integer longitud, Integer longitudMinima, Integer longitudMaxima){
        
        boolean mensaje=false;
        
        if (longitud > longitudMaxima) 
        {
            evt.consume();
        }
        
        if(longitud < longitudMinima){
            mensaje=true;
        }
        return mensaje;
    }
    
    public void validarNumeros(KeyEvent evt){
        char caracter = evt.getKeyChar();
        
        if(!Character.isDigit(caracter)){
            evt.consume();
        }
    }
    
    public void validarLetras(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if(Character.isLetter(caracter))
        {
            JOptionPane.showMessageDialog(null, "No se pueden ingresar letras.");
            evt.consume();
        }
    }
    
    public boolean validarCampos(JTextField campo) {
        boolean validar;
        if (campo.getText().isEmpty() || campo.getText().matches("^\\s*$") == true) {
            validar = false;
        }else{
            validar = true;
        }
        return validar;
    }
     
}
