/*
 * Ejemplos.java
 *
 * Created on 7 de febrero de 2007, 9:35
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author  CoraSil
 * @version
 */
public class Ejemplos extends MIDlet implements CommandListener {
    
    // Variables de clase
    
    private Display display;
    private Form form;
    private List menu;
    
    // Comandos a utilizar en los midlets
    
    private Command salir;
    private Command volver;
    
    // Constructor
    
    public Ejemplos() {

        // En el constructor inicializamos los componentes a utilizar
        
        salir = new Command("Salir",Command.STOP,2);
        
        volver = new Command("Volver",Command.BACK,0);
        
    }
    
    public void startApp() {
        
        // Almaceno el display (pantalla) del dispositivo
        
        display = Display.getDisplay(this);
        
        // Creo el men� de opciones.
        
        menu = new List("Ejemplos",List.IMPLICIT);
        
        // A�ado los elementos del men�
        
        menu.append("Configuraci�n",null);
        menu.append("Prueba de comandos",null);
        
        // A�ado los comandos que me interesan
        
        menu.addCommand(salir);
        
        // Definimos el receptor de eventos
        
        menu.setCommandListener(this);
        
        // Visualizo el men�
        
        display.setCurrent(menu);
        
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    // M�todo receptor de eventos
    
    public void commandAction(Command c,Displayable d) {
        if (c==salir) {
            destroyApp(true);
            notifyDestroyed();
        }
        else if (c==volver) {
            
            display.setCurrent(menu);
            
        }
        else {
            switch(menu.getSelectedIndex()) {
                case 0:
                    verConfig();
                    break;
                case 1:
                    pruebaCom();
                    break;
            }
        }
    }
    
    // M�todo para visualizar la configuraci�n del dispositivo
    
    public void verConfig() {
        
        // Creo el objeto form para borrar el contenido previo del formulario
        
        form = new Form("Configuraci�n");
        Integer i=new Integer(display.numColors());
        String s="Color: " + i.toString();
        form.append(s);
        Boolean b=new Boolean(display.isColor());
        s="Pantalla en color: " + b.toString();
        form.append(s);
        i=new Integer(display.numAlphaLevels());
        s="NIveles de transparencia: " + i.toString();
        form.append(s);
        form.addCommand(volver);
        form.setCommandListener(this);
        display.setCurrent(form);
        
    }
    
    // M�todo para probar la ubicaci�n autom�tica de comandos
    
    public void pruebaCom() {
        
        // Creo el objeto form para borrar el contenido previo del formulario
        
        form = new Form("Prueba de comandos");
        Command cancel=new Command("Cancelar",Command.CANCEL,1);
        Command ok=new Command("OK",Command.OK,1);
        Command help=new Command("Help",Command.HELP,1);
        Command stop=new Command("Stop",Command.STOP,1);
        form.addCommand(volver);
        form.addCommand(cancel);
        form.addCommand(ok);
        form.addCommand(help);
        form.addCommand(stop); 
        form.setCommandListener(this);
        display.setCurrent(form);        
        
    }
    
}
