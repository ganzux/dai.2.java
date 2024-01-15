/*
 * Imagen.java
 *
 * Created on 15 de febrero de 2007, 13:47
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author  coralio
 * @version
 */
public class Imagen extends MIDlet {
    // Variables de clase
    
    private Display display;
    private Form form;
    private Image imagen;
    
    // Comandos a utilizar en los midlets
    
    private Command salir;
    private Command volver;
    
    // Constructor
    
    public Imagen() {

        // En el constructor inicializamos los componentes a utilizar
        
        salir = new Command("Salir",Command.STOP,2);
        volver = new Command("Volver",Command.BACK,0);
        form=new Form("Imágenes");
        try {
            imagen=Image.createImage("/imagenes/logo.png");
        }catch (Exception e) {
            
        }
        
    }
    
    public void startApp() {
        
        // Almaceno el display (pantalla) del dispositivo
        
        display = Display.getDisplay(this);
        
        form.append(imagen);
        display.setCurrent(form);
        
               
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
