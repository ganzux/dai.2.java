/*
 * Alertas.java
 *
 * Created on 9 de febrero de 2007, 12:32
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author  CoraSil
 * @version
 */
public class Alertas extends MIDlet implements CommandListener {
    // Variables de clase
    
    private Display display;
    private List menu;
    private Alert alerta;
    
    // Comandos a utilizar en los midlets
    
    private Command salir;
    private Command volver;
    
    // Constructor
    
    public Alertas() {

        // En el constructor inicializamos los componentes a utilizar
        
        salir = new Command("Salir",Command.STOP,2);
        volver = new Command("Volver",Command.BACK,0);
        
    }
    
    public void startApp() {
        
        // Almaceno el display (pantalla) del dispositivo
        
        display = Display.getDisplay(this);
        
        // Llamo al método para ver el menú
        
        verMenu();
               
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    // Método receptor de eventos
    
    public void commandAction(Command c,Displayable d) {
                    
        /* Obtenemos el título de la lista visualizada en este momento
           para saber sobre la lista que debemos operar */
            
        String titulo=display.getCurrent().getTitle();
        
        if (c==salir) {
            destroyApp(true);
            notifyDestroyed();
        }
        else if (c==volver) verMenu();
        else {
            switch(menu.getSelectedIndex()) {
                case 0:
                    alertaAlarma();
                    break;
                case 1:
                    alertaConfir();
                    break;
                case 2:
                    alertaError();
                    break;
                case 3:
                    alertaInfor();
                    break;
                case 4:
                    alertaWarn();
                    break;
            }
            
        }
        
    }
    
    // Método para visualizar el emnú
    
    public void verMenu() {
        
        menu=new List("Alertas",List.IMPLICIT);
        
        menu.append("Alarma",null);
        menu.append("Confirmación",null);
        menu.append("Error",null);
        menu.append("Información",null);
        menu.append("Warning",null);
        
        menu.addCommand(salir);
        
        menu.setCommandListener(this);
        display.setCurrent(menu);
        
    }
    
    // Visualiza la alerta de alarma
    
    public void alertaAlarma() {

        alerta=new Alert("Alarma","Prueba de alerta ALARM",null,AlertType.ALARM);
        alerta.setTimeout(2000);
        alerta.addCommand(volver);
        display.setCurrent(alerta);

    }
            
    // Visualiza la alerta de confirmación
    
    public void alertaConfir() {

        alerta=new Alert("Confirmación","Prueba de alerta CONFIRMATION",null,AlertType.CONFIRMATION);
        alerta.setTimeout(2000);
        alerta.addCommand(volver);        
        display.setCurrent(alerta);
        
    }
    
    // Visualiza la alerta de error
    
    public void alertaError() {

        alerta=new Alert("Error","Prueba de alerta ERROR",null,AlertType.ERROR);
        alerta.setTimeout(2000);
        alerta.addCommand(volver);        
        display.setCurrent(alerta);
        
    }
    
    // Visualiza la alerta de información
    
    public void alertaInfor() {

        alerta=new Alert("Información","Prueba de alerta INFO",null,AlertType.INFO);
        alerta.setTimeout(2000);
        alerta.addCommand(volver);        
        display.setCurrent(alerta);       
        
    }
    
    // Visualiza la alerta de warning
    
    public void alertaWarn() {

        alerta=new Alert("Warning","Prueba de alerta WARNING",null,AlertType.WARNING);
        alerta.setTimeout(2000);
        alerta.addCommand(volver);        
        display.setCurrent(alerta);
        
    }

}
