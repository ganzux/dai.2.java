package calculadora;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>T�tulo: Calculadora de �lvaro</p>
 * <p>Descripci�n: Peque�o proyecto de Bienvenida, construyendo una calculadora b�sica</p>
 * <p>Copyright: CopyLeft (l) 2006 por WwW . AlvaRiTo . NeT</p>
 * <p>Empresa: iToSoFt</p>
 * @author �lvaro Alcedo Moreno
 * @version 0.5
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
