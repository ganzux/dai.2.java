/* Gracias a esta clase tendremos acceso a un explorador de archivos que "mirará"
    el contenido tanto de la memoria interna del teléfono como de las posibles
    tarjetas de memoria que se hayen insertadas.
    Esto es posible gracias a la especificación JSR-75, que da acceso al sistema
    de archivos.
    Es IMPRESCINDIBLE dar permisos de acceso a los archivos a la aplicación,
    porque si no la aplicación no funcionará correctamente y se producirán
    excepciones.
 
    Más información sobre THREADS:
    http://www.webtaller.com/construccion/lenguajes/java/lecciones/threads_java.php
 
    Para optimizar su rendimiento y compatibilizarlo con versiones y APIs anteriores,
    en vez de usar todos los métodos de la Interface FileConnection (léase getName,
    isDirectory, list...), lo vamos a hacer por comparaciones en las cadenas que
    guardaremos. Si el último caracter es / (constante SEP_CHR), estaremos en un
    directorio; si no lo es, será un archivo.
 
 
 
 */


import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.file.*;
import java.util.*;
import java.io.*;
import javax.microedition.io.*;


// CLASE PRINCIPAL, QUE ABARCA TODO EL MIDLET
// Implementamos el CommandListener para poder utilizar los menús
public class Explorer extends MIDlet implements CommandListener {
  
////////////////////////////////////// ATRIBUTOS QUE UTILIZAREMOS TODO EL TIEMPO
  // 4 variables finales y estáticas, para poder navegar
  private final static String ARRIBA = "..";
  private final static String PRINCIPAL = "/";
  private final static String SEP_STR = "/";
  private final static char   SEP_CHR = '/';  

  // Variable de tipo String para el nombre del directorio Actual
  private String nomDirAct;

  
  // Botones del menú
  private Command enter = new Command("Enter", Command.ITEM, 1);
  private Command atras = new Command("Atrás", Command.BACK, 2);
  private Command salir = new Command("Salir", Command.EXIT, 3);
/////////////////////////////// FIN DE ATRIBUTOS QUE UTILIZAREMOS TODO EL TIEMPO

/////////////////////////////////////////// MÉTODOS DESARROLLADOS PARA EL MIDLET
  
  // Constructor
  public Explorer() 
  {
    nomDirAct = PRINCIPAL;
  }

  // Sobreescribimos el commandAction para poder implementar el Listener
  public void commandAction(Command c, Displayable d) 
  {
    // Opción INTRO/ENTER/ACEPTAR
    if (c == enter) 
    {
      // Genero una lista con todo lo que está en la pantalla
      List lista = (List)d;
      // archivo es el String del elemento seleccionado en la lista. Para poder
      // utilizarla en el Thread es necesario que sea final
      final String archivo = lista.getString(lista.getSelectedIndex());
      // THREAD
      Thread lanza = new Thread(new Runnable() 
      {
        public void run() 
        {
          // En ésta sección podríamos haber utilizado la Interface FileConnection,  
          // y preguntar por los métodos isDirectory o isFile, pero no son compatibles
          // con todos los terminales, por lo que utilizaremos comparaciones de texto
            
          // Si el archivo acaba con SEP_STR (/) o es ARRIBA (..)
          if (archivo.endsWith(SEP_STR) || archivo.equals(ARRIBA)) 
          {
            // Llamas a acciones, para subir o bajar directorio
            acciones(archivo);
          }
          
          // En caso contrario es un archivo normal
          else
          {
            muestraArchivo(archivo);
          }
        }
      });// Así acaba el Thread
      // Inmediatamente lo lanzamos
      lanza.start();
    }//enter

    // ATRÁS/VOLVER
    else if (c == atras) 
    {
      muestraDirectorio();
    } 
    
    // SALIR
    else if (c == salir) 
    {
      destroyApp(false);
    }
  }//commandAction
  
  public String rutaFichero(){
      return nomDirAct;
  }
    
  // Inicio del Midlet
  public void startApp() 
  {
    // En principio no permitimos la navegación por archivos
    boolean disponible = false;
    
    // Si la versión del móvil permite la navegación por archivos
    if (System.getProperty("microedition.io.file.FileConnection.version") != null)
    {
      // permitimos la navegación
      disponible = true;
      try 
      {
        muestraDirectorio();
      }
      catch (SecurityException e){} 
      catch (Exception e) {}
      }//if

    // Sin embargo, si no la permites
    else
    {
      // Mensaje de Error, almacenado en StringBuffer para ahorrar memoria en la
      // concatenación
      StringBuffer texto = new StringBuffer();
      texto.append(getAppProperty("MIDlet-Name\n"));
      texto.append(getAppProperty("MIDlet-Vendor\n"));
      texto.append(disponible?"":"El API de archivos no está disponible.");
      // Se visualiza a modo de alerta
      Alert alerta = new Alert(null,texto.toString(),null,AlertType.INFO);
      alerta.setTimeout(5000);
      Display.getDisplay(this).setCurrent(alerta);
    }
    
  }// startApp
  
    void muestraDirectorio() 
  {
    // Objeto para guardar las unidades del dispositivo
    Enumeration e;
    FileConnection fc = null;
    List pantalla;
    try 
    {
      if (PRINCIPAL.equals(nomDirAct)) 
      {
        // Lista de todas las unidades
        e = FileSystemRegistry.listRoots();
        // Lo añades mediante Interface a la pantalla; lista implícita
        pantalla = new List(nomDirAct, List.IMPLICIT);
      } 
      else 
      {
        fc = (FileConnection)Connector.open("file://localhost/" + nomDirAct);
        e = fc.list();
        pantalla = new List(nomDirAct, List.IMPLICIT);
        // Arriba (..)
        pantalla.append(ARRIBA,null);
      }
      
      // Mientras la lista tenga elementos
      while (e.hasMoreElements()) 
      {
        // Lo añades a la pantalla
        String nombreArchivo = (String)e.nextElement();
        pantalla.append(nombreArchivo,null);
      }
      
      // Añade los comandos
      pantalla.setSelectCommand(enter);
      pantalla.addCommand(salir);
      pantalla.setCommandListener(this);
      
      // Cierre de fc
      if (fc != null) 
      {
        fc.close();
      }
      
      // Muestra la pantalla
      Display.getDisplay(this).setCurrent(pantalla);
    } 
    catch (IOException ioe) {}
  }
  
  void acciones(String nombreArchivo) 
  {
    // Si estamos en PRINCIPAL
    if (nomDirAct.equals(PRINCIPAL)) 
    {
      if (nombreArchivo.equals(ARRIBA)) 
      {
        // No puedes ir más arriba del del ARRIBA
        return;
      }
      nomDirAct = nombreArchivo;
    }
    
    // Sin embargo, si estamos en ARRIBA
    else if (nombreArchivo.equals(ARRIBA)) 
    {
      // Go up one directory
      // TODO use setFileConnection when implemented
      int i = nomDirAct.lastIndexOf( SEP_CHR , nomDirAct.length()-2);
      if (i != -1) 
      {
        nomDirAct = nomDirAct.substring(0, i+1);
      } 
      else 
      {
        nomDirAct = PRINCIPAL;
      }
    }
    
    // En los demás casos
    else 
    {
      nomDirAct = nomDirAct + nombreArchivo;
    }
    muestraDirectorio();
  }
  
  
  void muestraArchivo(String nombreArchivo) 
  {
    try 
    {
      // Conexión a los archivos
      FileConnection fc = (FileConnection)
      Connector.open("file://localhost/" + nomDirAct + nombreArchivo);
      // Si no existe, lanza excepción
      if (!fc.exists()) 
      {
        throw new IOException("Ese archivo No Existe");
      }
      
      /*public TextBox(String title,
               String text,
               int maxSize,
               int constraints)*/
      TextBox tb = new TextBox("¡ Ver Archivo !","file://localhost/"+nomDirAct + nombreArchivo, 1024,
              TextField.ANY | TextField.UNEDITABLE);
  
      tb.addCommand(atras);
      tb.addCommand(salir);
      tb.setCommandListener(this);

      Display.getDisplay(this).setCurrent(tb);
    }
    catch (Exception e) {}
  }
  
  
  // Método que pausa la aplicación
  public void pauseApp()
  {
  }
  
  
  // En la destrución, notificamos para el recolector de basura
  public void destroyApp(boolean unconditional)
  {
      notifyDestroyed();
  }
//////////////////////////////////// FIN DE MÉTODOS DESARROLLADOS PARA EL MIDLET
    
}// Fin de class Explorador