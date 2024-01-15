/*
 * CajasDeTexto.java
 *
 * Created on 8 de febrero de 2007, 23:13
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author  CoraSil
 * @version
 */
public class CajasDeTexto extends MIDlet implements CommandListener{

    // Variables de clase
    
    private Display display;
    private Form form;
    private TextField txtNum, txtPas, txtUrl, txtEma, txtPho;
    private Ticker ticker;
    
    // Comandos a utilizar en los midlets
    
    private Command salir;
    private Command volver;
    private Command aceptar;
    
    // Constructor
    
    public CajasDeTexto() {

        // En el constructor inicializamos los componentes a utilizar
        
        salir = new Command("Salir",Command.STOP,2);
        
        volver = new Command("Volver",Command.BACK,0);
        
        aceptar = new Command("Aceptar",Command.OK,0);
        
    }
    
    public void startApp() {
        
        // Almaceno el display (pantalla) del dispositivo
        
        display = Display.getDisplay(this);
        
        // Llamo al método para mostrar las cajas de texto
        
        mostrarCajas();
               
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
        
        else if (c==aceptar) verDatos();
        
        else if (c==volver) mostrarCajas();
    }
    
    // Método para mostrar las cajas de texto
    
    public void mostrarCajas() {
                
        // Creo las cajas de texto, preparo el formulario y lo visualizo
        
        txtNum=new TextField("Numérica","",5,TextField.NUMERIC);
        txtPas=new TextField("Password","",5,TextField.PASSWORD);
        txtUrl=new TextField("URL","http://localhost",20,TextField.URL);
        txtEma=new TextField("e-mail","",20,TextField.EMAILADDR);
        txtEma.setString("coralioc@yahoo.es");
        txtPho=new TextField("Teléfono","",9,TextField.PHONENUMBER);

        // Creo el texto desplazable
        
        ticker=new Ticker("Introduzca los siguientes datos");
        
        form=new Form("Cajas de texto",null);
        
        form.append(txtNum);
        form.append(txtPas);
        form.append(txtUrl);
        form.append(txtEma);
        form.append(txtPho);
        
        // Inserto el texto desplazable en el formulario
        
        form.setTicker(ticker);
        
        form.addCommand(salir);
        form.addCommand(aceptar);
        
        // Definimos el receptor de eventos
        
        form.setCommandListener(this);
        
        // Visualizo el formulario
        
        display.setCurrent(form);

    }
    
    // Método para ver los datos introducidos en las cajas de texto
    
    public void verDatos() {

        // Creo el texto desplazable
        
        ticker=new Ticker("Estos son los datos que ha introducido");
        
        form=new Form("Datos introducidos",null);
        
        // Creo una variable para insertar el retorno de carro
        
        String intro="\n";
        
        form.append(txtNum.getString());
        form.append(intro);
        form.append(txtPas.getString());
        form.append(intro);        
        form.append(txtUrl.getString());
        form.append(intro);
        form.append(txtEma.getString());
        form.append(intro);        
        form.append(txtPho.getString());
        
        // Inserto el texto desplazable en el formulario
        
        form.setTicker(ticker);
        
        form.addCommand(volver);
        
        // Definimos el receptor de eventos
        
        form.setCommandListener(this);
        
        // Visualizo el formulario
        
        display.setCurrent(form);
        
        
    }
}
