package lectordenumeros;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>T�tulo: Lector de Numeros</p>
 * <p>Descripci�n: Intento de leer n�meros</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author �lvaro Alcedo Moreno
 * @version 0.2a
 */

public class main {
  boolean packFrame = false;

  //Construir la aplicaci�n
  public main() {
    principal frame = new principal();
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
    new main();
  }
}
