/*
J2ME: The Complete Reference

James Keogh

Publisher: McGraw-Hill

ISBN 0072227109

*/
// jad file (Please verify the jar size first)
/*
MIDlet-Name: fileconnection
MIDlet-Version: 1.0
MIDlet-Vendor: MyCompany
MIDlet-Jar-URL: fileconnection.jar
MIDlet-1: fileconnection, , fileconnection
MicroEdition-Configuration: CLDC-1.0
MicroEdition-Profile: MIDP-1.0
MIDlet-JAR-SIZE: 100

*/
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.*;
import javax.microedition.io.*;

public class FileConnection extends MIDlet implements CommandListener {
  private Command exit, start;
  private Display display;
  private Form form;
  public FileConnection () 
  {
    display = Display.getDisplay(this);
    exit = new Command("Exit", Command.EXIT, 1);
    start = new Command("Start", Command.EXIT, 1);
    form = new Form("Write To File");
    form.addCommand(exit);
    form.addCommand(start);
    form.setCommandListener(this);
  }
  public void startApp() throws MIDletStateChangeException 
  {
    display.setCurrent(form);
  }
  public void pauseApp() 
  {
  }
  public void destroyApp(boolean unconditional) 
  {
  }
  public void commandAction(Command command, Displayable displayable) 
  {
    if (command == exit) 
    {
      destroyApp(false);
      notifyDestroyed();
    }
    else if (command == start) 
    {
      try 
      {
        OutputConnection connection = (OutputConnection)                     
          Connector.open("file://e:/myfile.txt;append=true", Connector.WRITE );
        OutputStream out = connection.openOutputStream();
        PrintStream output = new PrintStream( out );
        output.println( "This is a test." );
        out.close();
        connection.close();
        Alert alert = new Alert("Completed", "Data Written", null, null);
        alert.setTimeout(Alert.FOREVER);
        alert.setType(AlertType.ERROR);
        display.setCurrent(alert);      
      }
      catch( ConnectionNotFoundException error )
       {
         Alert alert = new Alert(
              "Error", "Cannot access file.", null, null);
         alert.setTimeout(Alert.FOREVER);
         alert.setType(AlertType.ERROR);
         display.setCurrent(alert);      
        }
        catch( IOException error )
        {
         Alert alert = new Alert("Error", error.toString(), null, null);
         alert.setTimeout(Alert.FOREVER);
         alert.setType(AlertType.ERROR);
         display.setCurrent(alert);      
        }
    }
  }
}