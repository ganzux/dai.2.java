package tienda;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>T�tulo: Tienda de ordenadores</p>
 * <p>Descripci�n: <Peque�o proyrecto para la gesti�n de una tienda de ordenadores/p>
 * <p>Copyright: CopyLeft (c) 2006</p>
 * <p>Empresa: iTo Soft</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.0
 * <p>Inicio: 5 / X / 2006</p>
 * <p>Fin: 10 / X / 2006</p>
 */


public class grafica {
  boolean packFrame = false;

  //Construir la aplicaci�n
  public grafica() {
    Entorno frame = new Entorno();
    //Validar marcos que tienen tama�os preestablecidos
    //Empaquetar marcos que cuentan con informaci�n de tama�o preferente �til. Ej. de su dise�o.
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Centrar la ventana
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }

  //M�todo Main
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new grafica();
  }
}
