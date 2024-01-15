package calculadora;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>T�tulo: Ejercicio de prueba de inicio de curso</p>
 * <p>Descripci�n: Creamos una ventana</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Empresa: iTo Soft</p>
 * @author �lvaro
 * @version 1.0
 */

public class calculadora {
  boolean packFrame = false;

  //Construir la aplicaci�n
  public calculadora() {
    Marco1 frame = new Marco1();
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
    new calculadora();
  }
}