/*
 * principal.java
 *
 * Created on 6 de marzo de 2007, 10:45
 */

import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.media.control.VideoControl;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import java.io.*;



/**
 *
 * @author  alumno2dai
 * @version
 */
public class Principal extends MIDlet implements CommandListener,ItemStateListener,ItemCommandListener,Control,PlayerListener{
    
    private Display display;
    private Form form;
    private Command salir,volver,aceptar,reproducir;
    private Player player;
    private VideoControl videoControl;
    private TextField textTiempo;
    private List menu;
    private VolumeControl volumeControl; 
    private Gauge gauge;
    private Gauge gauge2;
    private CustomItem customItem;
    private Image imagen;
    private Image imagen2;
    private Ticker ticker;
    private Canvas canvas;
    private CustomItem customItem2;
    private InputStream video;
   
    
    public Principal(){
        
        salir = new Command("Salir", Command.EXIT, 2);
        
        volver = new Command("Volver", Command.BACK, 0);
       
        aceptar = new Command("Aceptar",Command.SCREEN,0);

        reproducir = new Command("Reproducir",Command.OK,0);
    }
    public void startApp() {
        
        display = Display.getDisplay(this);
        
        menu = new List("Reproductor Video",List.IMPLICIT);
        // Añado los elementos del menú
        
        menu.append("Reproducir video",null);
        
        // Añado los comandos que me interesan
        menu.addCommand(salir);
        menu.setCommandListener(this);
        display.setCurrent(menu);
        
        //CustomItem con el icono del sonido para modificar el volumen con las teclas 4,5 y 6
        customItem=new CustomItem("") {
            int altura=32;
            int anchura=32;
            
            
            protected int getMinContentWidth() {
                return anchura;
            }

            protected int getMinContentHeight() {
                return altura;
            }

            protected int getPrefContentWidth(int i) {
                return getMinContentWidth();
            }

            protected int getPrefContentHeight(int i) {
                return getMinContentHeight();
            }
            protected void keyPressed(int keyCode){
                
                if(keyCode==52){
                    if(volumeControl.getLevel()>0){
                        volumeControl.setLevel(volumeControl.getLevel()-10);
                    }
                    else{
                       repaint();
                    }
                    
                }
                else if(keyCode==54){
                   if(volumeControl.getLevel()<100){
                        volumeControl.setLevel(volumeControl.getLevel()+10);
                        repaint();
                    }
                    
                }
                else if(keyCode==53){
                    if(volumeControl.getLevel()>0){
                        volumeControl.setLevel(0);
                        repaint();
                    }
                    else{
                        volumeControl.setLevel(50);
                        repaint();
                    }
                }
                
            }

            protected void paint(Graphics g, int i, int i0) {
                try{
                    if(volumeControl.getLevel()>0){
                        InputStream img = getClass().getResourceAsStream("s.png");
                        imagen=Image.createImage(img);
                    }
                    else{
                        InputStream img2 = getClass().getResourceAsStream("s2.png");
                        imagen=Image.createImage(img2);
                    }
                    
                }
                catch(Exception e){}
                g.drawImage(imagen,anchura,altura,g.VCENTER|g.HCENTER);
                
            }
        };
        
        
        //CustomItem con el icono del reproductor para modificar el video con las teclas 1,2 y 3
        customItem2=new CustomItem("") {
            int altura=64;
            int anchura=64;
            
            
            protected int getMinContentWidth() {
                return anchura;
            }

            protected int getMinContentHeight() {
                return altura;
            }

            protected int getPrefContentWidth(int i) {
                return getMinContentWidth();
            }

            protected int getPrefContentHeight(int i) {
                return getMinContentHeight();
            }
            protected void keyPressed(int keyCode){
            try
            {  
                
              if(keyCode==53){
                
                    
                   if(player.getState()==player.PREFETCHED){
                        player.start();
                        repaint();
                   }
                   else{
                        player.stop();
                        repaint();
                   }
                   
              }
              if(keyCode==52){
                    if(player.getState()==player.STARTED){
                        player.stop();
                        player.setMediaTime(player.getMediaTime()-1000000);
                        player.start();
                    }
                   
              }
              if(keyCode==54){
                    if(player.getState()==player.STARTED){
                        player.stop();
                        player.setMediaTime(player.getMediaTime()+1000000);
                        player.start();
                    }
                   
              }
              
              
            }
            catch(Exception me){}    
          }
            
          protected void keyRepeated(int keyCode){
            try{
                if(keyCode==52){
                    if(player.getState()==player.STARTED){
                        player.stop();
                        player.setMediaTime(player.getMediaTime()-1000000);
                        player.start();
                    }
                   
              }
                if(keyCode==54){
                    if(player.getState()==player.STARTED){
                        player.stop();
                        player.setMediaTime(player.getMediaTime()+1000000);
                        player.start();
                    }
                   
              }
            
            }
            catch(Exception e){}
          
          }

            protected void paint(Graphics g, int i, int i0) {
                try{
                    if(player.getState()==player.PREFETCHED){
                        InputStream img = getClass().getResourceAsStream("reproductorParado.png");
                        imagen=Image.createImage(img);
                    }
                    else{
                        InputStream img2 = getClass().getResourceAsStream("reproductorMarcha.png");
                        imagen=Image.createImage(img2);
                    
                    }
                    
                }
                catch(Exception e){}
                g.drawImage(imagen,anchura,altura,g.VCENTER|g.HCENTER);
                
            }
        };
        
        
        canvas =new Canvas() {

            protected void paint(Graphics graphics) {
            }
        };
    }
    
    public void pauseApp() {}
    
    public void destroyApp(boolean unconditional) {}
    
    public void commandAction(Command c, Displayable s) {
        if (c == salir) {
            destroyApp(true);
            notifyDestroyed();
        } 
        
       
        else if (c == volver){
            
            player.close();
            player=null;
            video=null;
            videoControl=null;
            volumeControl=null;
            display.setCurrent(menu);
            
        }
        else{
            
           if(menu.getSelectedIndex()==0){
                
                verVideo(0);
            }
        
        }
        
    }
  
    public void verVideo(long tiempo) {
        try {
            form=new Form("Video");
            
            video = getClass().getResourceAsStream("ito.mpg");
            player = Manager.createPlayer(video, "video/mpeg");
            player.addPlayerListener(this);
            player.prefetch();
            player.realize();
            
            /*if(tiempo!=0){
                player.setMediaTime(tiempo*1000000);
            }
            else{
                //hago que se reproduzca de forma indefinida
                player.setLoopCount(-1);
            }*/
            
            videoControl = (VideoControl) player.getControl("VideoControl");
            volumeControl=(VolumeControl)player.getControl("VolumeControl");
            
            ticker=new Ticker("Reproductor de Video");
            form.setTicker(ticker);
            
           // Si el objeto vc ha cogido el control
          if (videoControl != null)
            {
            // Cast de vc a un objeto Item, para poderlo agregar al formulario
            Item item =  (Item)videoControl.initDisplayMode(VideoControl.USE_GUI_PRIMITIVE,null);
            // lo agregamos
            form.append(item);
            
            videoControl.setDisplayLocation(videoControl.getDisplayHeight()/2,videoControl.getDisplayWidth()/2);
            videoControl.setDisplaySize(232,180);
            //he creado 2 objetos gauge con los que controlo el tamaño de video y el volumen
            //gauge=new Gauge("Volumen",true,4,2);
            //gauge2=new Gauge("Tamaño",true,4,4);

            //form.append("Duracion: "+String.valueOf((float)player.getDuration()/1000000));
            //form.append(gauge);
            //form.append(gauge2);
            
            form.append(customItem);
            form.append(customItem2);
            
            form.addCommand(volver);
            
            
            textTiempo=new TextField("Tiempo en seg","",30,TextField.NUMERIC);
            textTiempo.addCommand(aceptar);
            textTiempo.setItemCommandListener(this);
            form.append(textTiempo);
            
            
            form.setItemStateListener (this);
            form.setCommandListener(this);
            
            // displayamos el formulario

            display.setCurrent(form);
            // y Start!
            player.start();

            }
          }
      catch (Exception e){
            
        }
    }

    //Metodo que controla los eventos sobre los objetos Gauge y modifica el volumen y el tamaño del video
    public void itemStateChanged(Item item) {
       if(item==gauge){
        volumeControl.setLevel(gauge.getValue()*20);
       }
       else if(item==gauge2){
           try{
            videoControl.setDisplaySize(gauge2.getValue()*58,gauge2.getValue()*45);
           }
           catch(Exception e){}
       }
    }

    public void playerUpdate(Player player, String event, Object object) {
      if(event.equals(PlayerListener.STOPPED)){
        ticker.setString("Reproduccion Pausado");
        
      }
      else if(event.equals(PlayerListener.STARTED)){
        ticker.setString("Reproductor Activo");
                
      }
      else if(event.equals(PlayerListener.END_OF_MEDIA)){
        ticker.setString("Reproduccion Finalizada");
      }
   
      
    
    }

    public void commandAction(Command command, Item item) {
        
        if(item==textTiempo&&command==aceptar){
            try {
                    player.stop();
                
                    player.setMediaTime(Long.parseLong(textTiempo.getString())*1000000);
                    
                    player.start();
                } catch (Exception ex) {}
    
            }
        }
        
            
        
       

    
}




