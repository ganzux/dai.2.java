/*
 * EjemplosListas.java
 *
 * Created on 7 de febrero de 2007, 23:15
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author  CoraSil
 * @version
 */
public class EjemplosListas extends MIDlet implements CommandListener{

    // Variables de clase
    
    private Display display;
    private List listas;
    private List listaImp, listaExc, listaMul;
    private Form form;
    
    /* Variable para saber al men� que tiene que volver.
        Puede tomar los siguientes valores:
        1: volver� al men� principal.
        2: volver� a la lista impl�cita.
        3: volver� a la lista exclusiva.
        4: volver� a la lista m�ltiple. */
    
    private int menu;
    
    // Comandos a utilizar en los midlets
    
    private Command salir;
    private Command volver;
    private Command aceptar;
    
    // Constructor
    
    public EjemplosListas() {

        // En el constructor inicializamos los componentes a utilizar
        
        salir = new Command("Salir",Command.STOP,2);
        
        volver = new Command("Volver",Command.BACK,0);
        
    }
    
    public void startApp() {
        
        // Almaceno el display (pantalla) del dispositivo
        
        display = Display.getDisplay(this);
        
        // Creo el men� de opciones.
        
        listas = new List("Ejemplos de listas",List.IMPLICIT);
        
        // A�ado los elementos del men�
        
        listas.append("Impl�cita",null);
        listas.append("Exclusiva",null);
        listas.append("M�ltiple",null);
        
        // A�ado los comandos que me interesan
        
        listas.addCommand(salir);
                        
        // Definimos el receptor de eventos
        
        listas.setCommandListener(this);
        
        // Visualizo el men�
        
        display.setCurrent(listas);
               
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    // M�todo receptor de eventos
    
    public void commandAction(Command c,Displayable d) {
                    
        /* Obtenemos el t�tulo de la lista visualizada en este momento
           para saber sobre la lista que debemos operar */
            
        String titulo=display.getCurrent().getTitle();
        
        if (c==salir) {
            destroyApp(true);
            notifyDestroyed();
        }
        else if (c==volver) {
            
                /* Hay que comprobar desde qu� ventana ha pulsado
                    el bot�n volver, para regresar a la ventana adecuada */
            
                switch(menu) {
                    case 1:
                        display.setCurrent(listas);
                        break;
                    case 2:
                        listImplic();
                        break;
                    case 3:
                        listExclu();
                        break;
                    case 4:
                        listSelMu();
                        break;                        
                }
            
        }
        
        else if (c==aceptar) {
                
            
                /* Compruebo desde qu� lista ha pulsado el bot�n aceptar
                    para visualizar los elementos de esa lista.
                    S�lo se comprueban las listas exclusiva y m�ltiple,
                    pues la lista impl�cita no tienen asociada el bot�n
                    aceptar. */
            
                if (titulo.equals("Exclusiva")) eleListExc();
                else if (titulo.equals("M�ltiple")) eleListMul();            
        }
        else {

            /* Si llega hasta aqu�, significa que no se ha pulsado ning�n
                bot�n (salir, volver o aceptar) y se ha activado el receptor
                de eventos al seleccionar un elemento de una lista impl�cita
                y pulsar el bot�n SELECT.*/
            
            /* La siguiente estructura se refiere a la selecci�n de un elemento
                en la lista principal (lista impl�cita). */
            
            if (titulo.equals("Ejemplos de listas")) {
                
                /* Pongo la variable menu a 1 para volver desde cualquier lista
                    a la lista principal */
                
                menu=1;
            
                switch(listas.getSelectedIndex()) {
                    case 0:
                        listImplic();
                        break;
                    case 1:
                        listExclu();
                        break;
                    case 2:
                        listSelMu();
                        break;
                }       
            }
            
            else {
                
                /* El siguiente if se refiere a la selecci�n de un elemento en
                    la lista impl�cita. */
                
                if (titulo.equals("Impl�cita")) eleListImp();
                
            }
        }
    }
    
    // M�todo para la lista impl�cita
    
    public void listImplic() {
        
        // Pongo la variable menu a 1 para volver a la lista principal
        
        menu=1;
        
        listaImp=new List("Impl�cita",List.IMPLICIT);
        listaImp.append("Elemento 0",null);
        listaImp.append("Elemento 1",null);
        listaImp.append("Elemento 2",null);
        listaImp.append("Elemento 3",null);
        listaImp.append("Elemento 4",null);        
        listaImp.addCommand(volver);
        listaImp.setCommandListener(this);
        display.setCurrent(listaImp);
    }
    
    // M�todo para la lista exclusiva
    
    public void listExclu() {
        
        // Pongo la variable menu a 1 para volver a la lista principal
        
        menu=1;
                
        listaExc=new List("Exclusiva",List.EXCLUSIVE);
        listaExc.append("Elemento 0",null);
        listaExc.append("Elemento 1",null);
        listaExc.append("Elemento 2",null);
        listaExc.append("Elemento 3",null);
        listaExc.append("Elemento 4",null);        
        listaExc.addCommand(volver);
        
        /* La lista exclusiva necesita un comando asociado para
            coger la selecci�n. */
        
        aceptar=new Command("Aceptar",Command.OK,1);
        listaExc.addCommand(aceptar);
        listaExc.setCommandListener(this);
        display.setCurrent(listaExc);
        
    }
    
    // M�todo para la lista de selecci�n m�ltiple
    
    public void listSelMu() {
        
        // Pongo la variable menu a 1 para volver a la lista principal
        
        menu=1;
     
        listaMul=new List("M�ltiple",List.MULTIPLE);
        listaMul.append("Elemento 0",null);
        listaMul.append("Elemento 1",null);
        listaMul.append("Elemento 2",null);
        listaMul.append("Elemento 3",null);
        listaMul.append("Elemento 4",null);
        boolean[] elementos={true, false, false, false, false};
        listaMul.setSelectedFlags(elementos);
        listaMul.addCommand(volver);
        
        /* La lista m�ltiple necesita un comando asociado para
            coger la selecci�n. */
        
        aceptar=new Command("Aceptar",Command.OK,1);
        listaMul.addCommand(aceptar);
        listaMul.setCommandListener(this);
        display.setCurrent(listaMul);
        
        
    }
    
    // M�todo para averiguar el elemento de la lista impl�cita
    
    public void eleListImp() {
        
        // Pongo la variable menu a 2 para volver a la lista impl�cita
        
        menu=2;
        
        form=new Form("Impl�cita",null);
        
        // Creo una variable con el contenido del elemento seleccionado
        
        StringBuffer s=new StringBuffer();
        s.append("Ha seleccionado ");
        s.append(listaImp.getString(listaImp.getSelectedIndex()));
        
        // Llamo al m�todo que prepara y visualiza el formulario
        
        preVisFor(s);
        
    }
      
    /* M�todo para averiguar el/los elemento/s seleccionado/s en la
        lista exclusiva */
    
    public void eleListExc() {
        
        // Pongo la variable menu a 3 para volver a la lista exclusiva
        
        menu=3;
        
        form=new Form("Exclusiva",null);
        
        // Creo una variable con el contenido del elemento seleccionado
        
        StringBuffer s=new StringBuffer();
        s.append("Ha seleccionado ");
        s.append(listaExc.getString(listaExc.getSelectedIndex()));
        
        // Llamo al m�todo que prepara y visualiza el formulario
        
        preVisFor(s);
        
    }
    
    /* M�todo para averiguar el/los elemento/s seleccionado/s en la
        lista m�ltiple */
    
    public void eleListMul() {
        
        // Pongo la variable menu a 4 para volver a la lista m�ltiple
        
        menu=4;
        
        form=new Form("M�ltiple",null);
        
        StringBuffer s=new StringBuffer();

        /* Creo un array, de tipo booleano, con el mismo tama�o
            que el n�mero de elementos de la lista m�ltiple.
            Este array es booleana porque va a almacenar si el
            elemento est� seleccionado, valor true, o no, valor false. */
        
        boolean[] elementos=new boolean[listaMul.size()];
        
        /* Se a�aden al array los valores (true o false) de la selecci�n
            de cada uno de los elementos de la lista m�ltiple */

        listaMul.getSelectedFlags(elementos);
        
        // Creo una variable para almacenar los elementos seleccionados
        
        s.append("Ha seleccionado:");
        for (int i=0; i<elementos.length; i++) {
            
            // Si el elemento tiene el valor true
            
            if (elementos[i]) {
                
                // Inserto un retorno de carro
                
                s.append("\n");                
                s.append(listaMul.getString(i)) ;
                
            }   

        }
        
        /* Si la variable no ha modificado su valor dentro del bucle,
            no se ha seleccionado ning�n elemento */
        
        if (s.toString().equals("Ha seleccionado:"))
            s.append("Ning�n elemento");
        
        // Llamo al m�todo que prepara y visualiza el formulario
        
        preVisFor(s);
        
    }
    
    // M�todo que prepara y visualiza el formulario
    
    public void preVisFor(StringBuffer s) {
        
        form.append(s.toString());
        form.addCommand(volver);
        form.setCommandListener(this);
        display.setCurrent(form);
        
    }

}
