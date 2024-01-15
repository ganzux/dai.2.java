/*
 * PopupConChoice.java
 *
 * Created on 14 de febrero de 2007, 10:59
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author  Coralio
 * @version
 */
public class PopupConChoice extends MIDlet implements CommandListener {

    // Variables de clase
    
    private Display display;
    private Form form;
    private ChoiceGroup popup;
    
    // Comandos a utilizar en los midlets
    
    private Command salir;
    
    // Constructor
    
    public PopupConChoice() {

        // En el constructor inicializamos los componentes a utilizar
        
        salir=new Command("Salir",Command.STOP,2);
        form=new Form("Lista tipo Popup");
        
    }
    
    public void startApp() {
        
        // Almaceno el display (pantalla) del dispositivo
        
        display = Display.getDisplay(this);
        
        // Creo e inicializo el objeto de tipo choiceGroup
        
        popup=new ChoiceGroup("Seleccione una \n opción:",Choice.POPUP);
        
       popup.append("Opción 1",null);
       popup.append("Opción 2",null);
        
        // Creo y visualizo el formulario
        
        form.append(popup);
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
