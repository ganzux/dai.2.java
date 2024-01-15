/*
 * Vibracion.java
 *
 * Created on 21 de febrero de 2007, 20:16
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.*;

public class Vibracion extends MIDlet implements CommandListener {
    
    private Form formulario;
    private Display pantalla;
    
    private Command salir;
    
    private StringBuffer s = new StringBuffer();
  
    public Vibracion(){
        
        // Genero el valor de los botones
        salir = new Command("Salir",Command.EXIT,0);
                
        // Y del texto, s.toString() será una cadena de texto para escribir
        s.append("Prueba de Vibración del Móvil durante 3 segundos");
    }
    
    
    public void startApp() {

        // preparo la pantalla
        pantalla = Display.getDisplay(this);
        
        formulario = new Form("Título mio",null);
        
        // añadimos la cadena de texto al formulario
        formulario.append(s.toString());
        
        // Añadimos los botones
        formulario.addCommand(salir);
        
        // Y el escuchador de comandos
        formulario.setCommandListener(this);

        pantalla.setCurrent(formulario);
        
        // Vibración
        Display.getDisplay(this).vibrate(3000);
}
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public void commandAction(Command c,Displayable d){
        if (c == salir){
            destroyApp(true);
            notifyDestroyed();
        }
    }
}