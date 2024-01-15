/*
 * Calendario.java
 *
 * Created on 12 de febrero de 2007, 22:28
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;

/**
 *
 * @author  CoraSil
 * @version
 */
public class Calendario extends MIDlet implements CommandListener {

    // Variables de clase
    
    private Display display;
    private Form form;
    private DateField calendario;
    
    // Comandos a utilizar en los midlets
    
    private Command salir;
    
    // Constructor
    
    public Calendario() {

        // En el constructor inicializamos los componentes a utilizar
        
        salir=new Command("Salir",Command.STOP,2);
        form=new Form("Calendario");
        
        // Defino el objeto DateField para que sólo trabaje con fechas
        
        calendario=new DateField("",DateField.DATE);        
        
    }
    
    public void startApp() {
        
        // Almaceno el display (pantalla) del dispositivo
        
        display = Display.getDisplay(this);
        
        // Inicializo el objeto DateField con la fecha actual
        
        calendario.setDate(new Date());
        
        // Creo y visualizo el formulario
        
        form.append(calendario);
        form.addCommand(salir);
        form.setCommandListener(this);
        
        display.setCurrent(form);
               
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    // Método receptor de eventos del midlet
    
    public void commandAction(Command c,Displayable d) {
                    
        /* Obtenemos el título de la lista visualizada en este momento
           para saber sobre la lista que debemos operar */
            
        String titulo=display.getCurrent().getTitle();
        
        if (c==salir) {
            destroyApp(true);
            notifyDestroyed();
        }
        
    }
    
}
