/*
 * Sonido.java
 *
 * Created on 21 de febrero de 2007, 21:07
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import java.io.*;

// Generamos la clase ppal, que implementa el CommandListener
public class Sonido extends MIDlet implements CommandListener {
    // Objetos de clase, que estarán presentes en todo el middlet; uno para la
    // pantalla, otro para el formulario y el resto para los botones.
    private Display display;
    private Form formulario;
    private Command exit,wav, nota, secuencia,mp3,mid,video,lista;
    
    
    // Método que se encarga de construir un formulario sólo con los botones
    public Form creaFormularioVacio(){
        //  Agregamos todos los comandos al middlet
        exit = new Command("Salir", Command.EXIT, 1);
        wav = new Command("WAV", Command.SCREEN, 2);
        mp3 = new Command("MP3", Command.SCREEN, 2);
        mid = new Command("MID", Command.SCREEN, 2);
        lista = new Command("Lista", Command.SCREEN, 1);
        video  = new Command("Video", Command.SCREEN, 2);
        nota = new Command("Nota", Command.SCREEN, 2);
        secuencia = new Command("Secuencia", Command.SCREEN, 2);
        
        // Damos los valores al formulario
        formulario = new Form("Pruebas de Sonido");
        
        // Agregamos los comandos al formulario
        formulario.addCommand(exit);
        formulario.addCommand(lista);
        formulario.addCommand(video);
        formulario.addCommand(wav);
        formulario.addCommand(mp3);
        formulario.addCommand(mid);
        formulario.addCommand(nota);
        formulario.addCommand(secuencia);
        formulario.setCommandListener(this);
        
        return formulario;
    }

    // Constructor
    public Sonido() {
        // Le pasamos a display la pantalla del móvil.
        display = Display.getDisplay(this);
    }// constructor

    // Inicio de la aplicación 
    public void startApp() {
        // A la pantalla del móvil le pasamos el formulario creado
        display.setCurrent(creaFormularioVacio());
    }

    public void pauseApp() {}

    public void destroyApp(boolean unconditional) {}

    // Acciones de los botones del menú
    public void commandAction(Command c, Displayable s) {

        if (c == exit) {
            destroyApp(false);
            notifyDestroyed();
        } 
        
        else {
            if (c == lista)
                Lista();
            if (c == wav)
                playSonido("sonidos/xp.wav","audio/x-wav");
            if (c == mp3)
                playSonido("sonidos/mama.mp3","audio/mpeg");
            if (c == mid)
                playSonido("sonidos/onestop.mid","audio/midi");
            if (c == video)
                playVideo();
            if (c == nota)
                playNota();
            if (c == secuencia)
                playSecuencia();
        }
    }

    public void playSonido(String direccion, String tipo) {
        try {
            /* Lo primero que necesitamos es la dirección donde se ubica el archivo
             a reproducir, que se lo indicaremos de manera relativa, habiendo guar-
             dado los archivos en " proyecto\build\obfuscated ".
             Todo el contenido de la carpeta será empaquetado en el archivo JAR */
            InputStream sonido = getClass().getResourceAsStream(direccion);
            
            /* Creamos un objeto de tipo Player, al cual le pasamos el sonido y su tipo*/
            Player player = Manager.createPlayer(sonido,tipo);
            
            // comenzar reproducción
            player.start();
            
        } catch (Exception e) {
            Alert alr = new Alert("Error", "No se pudo reproducir el archivo."+tipo,null, AlertType.ERROR);
            alr.setTimeout(Alert.FOREVER);
            display.setCurrent(alr, formulario);
        }
    }
    
    public void playVideo(){
      try{
          // Cojo el archivo de Video mediante el InputStream
          InputStream video = getClass().getResourceAsStream("ito.3gp");
          // Objeto Player, al que le asigno el video y su tipo
          Player player = Manager.createPlayer(video, "video/3gpp");
          // El objeto player es ahora cuando asigna los recursos para reproducir
          // y mira el objeto video que le hemos pasado.
          player.realize();
          // Creamos un objeto VC, al cual le pasamos el control del Player
          VideoControl vc = (VideoControl) player.getControl("VideoControl");
          // Si el objeto vc ha cogido el control
          if (vc != null)
            {
            // Cast de vc a un objeto Item, para poderlo agregar al formulario
            Item item =  (Item)vc.initDisplayMode(VideoControl.USE_GUI_PRIMITIVE,null);
            // lo agregamos
            formulario.append(item);
            // displayamos el formulario
            display.setCurrent(formulario);
            // y Start!
            player.start();

            }
          }
      catch (Exception e){
            Alert alr = new Alert("Error", "No se pudo reproducir el video.",null, AlertType.ERROR);
            alr.setTimeout(Alert.FOREVER);
            display.setCurrent(alr, formulario);
        }
    }



    public void playNota() {
        try {
            // reproducir nota
            Manager.playTone(ToneControl.C4, 2000, 100);
        } catch (Exception e){}
    }

    public void playSecuencia() {
        byte tempo = 30;
        byte d = 8;

        // Creamos las notas a partir del Do central
        byte C4 = ToneControl.C4;;
        byte D4 = (byte)(C4 + 2);
        byte E4 = (byte)(C4 + 4);
        byte F4 = (byte)(C4 + 5);
        byte G4 = (byte)(C4 + 7);
        byte silencio = ToneControl.SILENCE;

        byte[] secuencia = {
            ToneControl.VERSION, 1,
            ToneControl.TEMPO, tempo,
            // comienzo del bloque 0
            ToneControl.BLOCK_START, 0,
            // notas del bloque 0
            C4,d, F4,d, F4,d, C4,d, F4,d, F4,d, C4,d, F4,d,
            // fin del bloque 0
            ToneControl.BLOCK_END, 0,
            // inicio del bloque 1
            ToneControl.BLOCK_START, 1,
            // notas del bloque 1
            C4,d, E4,d, E4,d, C4,d, E4,d, E4,d, C4,d, E4,d,
            // fin del bloque 1
            ToneControl.BLOCK_END, 1,
            // reproducir bloque 0
            ToneControl.PLAY_BLOCK, 0,
            // reproducir bloque 1
            ToneControl.PLAY_BLOCK, 1,
            // reproducir bloque 0
            ToneControl.PLAY_BLOCK, 0,
        };

        try{
            Player p = Manager.createPlayer(Manager.TONE_DEVICE_LOCATOR);
            p.realize();
            ToneControl c = (ToneControl)p.getControl("ToneControl");
            c.setSequence(secuencia);
            p.start();
        } catch (Exception e) {}
    }
    
    public void Lista(){
        
        // Vamos a crear un Vector de Strings donde almacenaremos todos los 
        // protocolos que puede utilizar el móvil. Mediante un simple bucle
        // que mire la longitud de nuestro contenedor, podremos recorrerlo y
        // agregarlo al formulario.
        String[] contenedorDeProtocolos = Manager.getSupportedProtocols(null);
        if (contenedorDeProtocolos != null)
        {
            formulario.append("\nProtocolos soportados por el aparato:\n");
            for (int i=0;i<contenedorDeProtocolos.length;i++)
            {
                formulario.append(i+1+". " +contenedorDeProtocolos[i]+ "\n");
            }
        }
        
        // De igual manera procederemos con con los distintos MIME TYPES que 
        // puede reproducir el móvil.
        String[] contenedorDeTipos = Manager.getSupportedContentTypes(null);
        if (contenedorDeTipos != null)
        {
            formulario.append("\n\nTodos los tipos soportados por el aparato:\n");

            for (int i=0;i<contenedorDeTipos.length;i++)
            {
                formulario.append(i+1+". " +contenedorDeTipos[i]+ "\n");
            }
        }
        
        // Al final del todo, terminaremos llevando el formulario a la pantalla.
        display.setCurrent(formulario);
    }
} 