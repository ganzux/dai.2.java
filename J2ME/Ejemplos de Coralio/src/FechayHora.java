/*
 * FechayHora.java
 *
 * Created on 12 de febrero de 2007, 23:23
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;

/**
 *
 * @author  CoraSil
 * @version
 */
public class FechayHora extends MIDlet implements CommandListener {

    // Variables de clase
    
    private Display display;
    private Form form; 
    
    // Comandos a utilizar en los midlets
    
    private Command salir;
    
    // Constructor
    
    public FechayHora() {

        // En el constructor inicializamos los componentes a utilizar
        
        salir=new Command("Salir",Command.STOP,2);
        form=new Form("Calendario");

    }
    
    public void startApp() {
        
        // Almaceno el display (pantalla) del dispositivo
        
        display = Display.getDisplay(this);
        
        // Creo un objeto de tipo Calendar para asignar la fecha y hora
        
        Calendar cal=Calendar.getInstance();
        
        // Asigno la fecha y hora
        
        cal.set(Calendar.DAY_OF_MONTH, 12);
        cal.set(Calendar.MONTH,Calendar.FEBRUARY);
        cal.set(Calendar.YEAR,2007);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,30);
        cal.set(Calendar.SECOND,32);

        // Creo un objeto de tipo Date con la fecha asignada al objeto cal        
        
        Date fechaCal=cal.getTime();
        
        // Creo un objeto de tipo DateField para visualizar la fecha y la hora en el formulario
        
        DateField fecha=new DateField(null,DateField.DATE_TIME);
        
        // Asigno la fecha y la hora creada anteriormente al objeto DateField
        
        fecha.setDate(fechaCal);
        
        // Creo y visualizo el formulario
        
        form.append(fecha);
        
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
