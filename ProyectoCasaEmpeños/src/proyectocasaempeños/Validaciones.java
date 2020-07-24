
package proyectocasaempeños;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
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
    
       
    public char s;
    public char space='a';
    
    public void ValidarLetras(KeyEvent evt){
        s = evt.getKeyChar();
        if(Character.isLetter(s));
        if(Character.isWhitespace(s));
        
        if(Character.isLetter(s) || Character.isWhitespace(s) && !Character.isWhitespace(space)){
            if(Character.isWhitespace(s)) space = s; else space = 'a';
        }else{
            evt.consume();     
        }
       }
    
     public void ValidarLetrasNumeros(KeyEvent evt){
        s = evt.getKeyChar();
        if(Character.isLetter(s));
        if(Character.isWhitespace(s));
        if(Character.isDigit(s));
         if(Character.isLetter(s) || Character.isWhitespace(s) && !Character.isWhitespace(space) || Character.isDigit(s)){
            if(Character.isWhitespace(s)) space = s; else space = 'a';
        }else{
            evt.consume();     
        }
     }
    
     public void ValidarNumeros(KeyEvent evt){
        s = evt.getKeyChar();
        if(Character.isLetter(s));
        if(Character.isWhitespace(s));
        if(Character.isDigit(s));
         if(Character.isDigit(s) ){
            if(Character.isWhitespace(s)) space = s; else space = 'a';
        }else{
            evt.consume();     
        }
     }
     
     public void ValidarCamposVacios()
     {
         
     }
     
     
     
    // "^\p{L}+(?: \p{L}+)*$"
     
}
