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
    
    /* Variable para saber al menú que tiene que volver.
        Puede tomar los siguientes valores:
        1: volverá al menú principal.
        2: volverá a la lista implícita.
        3: volverá a la lista exclusiva.
        4: volverá a la lista múltiple. */
    
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
        
        // Creo el menú de opciones.
        
        listas = new List("Ejemplos de listas",List.IMPLICIT);
        
        // Añado los elementos del menú
        
        listas.append("Implícita",null);
        listas.append("Exclusiva",null);
        listas.append("Múltiple",null);
        
        // Añado los comandos que me interesan
        
        listas.addCommand(salir);
                        
        // Definimos el receptor de eventos
        
        listas.setCommandListener(this);
        
        // Visualizo el menú
        
        display.setCurrent(listas);
               
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
        else if (c==volver) {
            
                /* Hay que comprobar desde qué ventana ha pulsado
                    el botón volver, para regresar a la ventana adecuada */
            
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
                
            
                /* Compruebo desde qué lista ha pulsado el botón aceptar
                    para visualizar los elementos de esa lista.
                    Sólo se comprueban las listas exclusiva y múltiple,
                    pues la lista implícita no tienen asociada el botón
                    aceptar. */
            
                if (titulo.equals("Exclusiva")) eleListExc();
                else if (titulo.equals("Múltiple")) eleListMul();            
        }
        else {

            /* Si llega hasta aquí, significa que no se ha pulsado ningún
                botón (salir, volver o aceptar) y se ha activado el receptor
                de eventos al seleccionar un elemento de una lista implícita
                y pulsar el botón SELECT.*/
            
            /* La siguiente estructura se refiere a la selección de un elemento
                en la lista principal (lista implícita). */
            
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
                
                /* El siguiente if se refiere a la selección de un elemento en
                    la lista implícita. */
                
                if (titulo.equals("Implícita")) eleListImp();
                
            }
        }
    }
    
    // Método para la lista implícita
    
    public void listImplic() {
        
        // Pongo la variable menu a 1 para volver a la lista principal
        
        menu=1;
        
        listaImp=new List("Implícita",List.IMPLICIT);
        listaImp.append("Elemento 0",null);
        listaImp.append("Elemento 1",null);
        listaImp.append("Elemento 2",null);
        listaImp.append("Elemento 3",null);
        listaImp.append("Elemento 4",null);        
        listaImp.addCommand(volver);
        listaImp.setCommandListener(this);
        display.setCurrent(listaImp);
    }
    
    // Método para la lista exclusiva
    
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
            coger la selección. */
        
        aceptar=new Command("Aceptar",Command.OK,1);
        listaExc.addCommand(aceptar);
        listaExc.setCommandListener(this);
        display.setCurrent(listaExc);
        
    }
    
    // Método para la lista de selección múltiple
    
    public void listSelMu() {
        
        // Pongo la variable menu a 1 para volver a la lista principal
        
        menu=1;
     
        listaMul=new List("Múltiple",List.MULTIPLE);
        listaMul.append("Elemento 0",null);
        listaMul.append("Elemento 1",null);
        listaMul.append("Elemento 2",null);
        listaMul.append("Elemento 3",null);
        listaMul.append("Elemento 4",null);
        boolean[] elementos={true, false, false, false, false};
        listaMul.setSelectedFlags(elementos);
        listaMul.addCommand(volver);
        
        /* La lista múltiple necesita un comando asociado para
            coger la selección. */
        
        aceptar=new Command("Aceptar",Command.OK,1);
        listaMul.addCommand(aceptar);
        listaMul.setCommandListener(this);
        display.setCurrent(listaMul);
        
        
    }
    
    // Método para averiguar el elemento de la lista implícita
    
    public void eleListImp() {
        
        // Pongo la variable menu a 2 para volver a la lista implícita
        
        menu=2;
        
        form=new Form("Implícita",null);
        
        // Creo una variable con el contenido del elemento seleccionado
        
        StringBuffer s=new StringBuffer();
        s.append("Ha seleccionado ");
        s.append(listaImp.getString(listaImp.getSelectedIndex()));
        
        // Llamo al método que prepara y visualiza el formulario
        
        preVisFor(s);
        
    }
      
    /* Método para averiguar el/los elemento/s seleccionado/s en la
        lista exclusiva */
    
    public void eleListExc() {
        
        // Pongo la variable menu a 3 para volver a la lista exclusiva
        
        menu=3;
        
        form=new Form("Exclusiva",null);
        
        // Creo una variable con el contenido del elemento seleccionado
        
        StringBuffer s=new StringBuffer();
        s.append("Ha seleccionado ");
        s.append(listaExc.getString(listaExc.getSelectedIndex()));
        
        // Llamo al método que prepara y visualiza el formulario
        
        preVisFor(s);
        
    }
    
    /* Método para averiguar el/los elemento/s seleccionado/s en la
        lista múltiple */
    
    public void eleListMul() {
        
        // Pongo la variable menu a 4 para volver a la lista múltiple
        
        menu=4;
        
        form=new Form("Múltiple",null);
        
        StringBuffer s=new StringBuffer();

        /* Creo un array, de tipo booleano, con el mismo tamaño
            que el número de elementos de la lista múltiple.
            Este array es booleana porque va a almacenar si el
            elemento está seleccionado, valor true, o no, valor false. */
        
        boolean[] elementos=new boolean[listaMul.size()];
        
        /* Se añaden al array los valores (true o false) de la selección
            de cada uno de los elementos de la lista múltiple */

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
            no se ha seleccionado ningún elemento */
        
        if (s.toString().equals("Ha seleccionado:"))
            s.append("Ningún elemento");
        
        // Llamo al método que prepara y visualiza el formulario
        
        preVisFor(s);
        
    }
    
    // Método que prepara y visualiza el formulario
    
    public void preVisFor(StringBuffer s) {
        
        form.append(s.toString());
        form.addCommand(volver);
        form.setCommandListener(this);
        display.setCurrent(form);
        
    }

}
