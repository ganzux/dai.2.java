package gestionalmacen;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>T�tulo: Principal</p>
 * <p>Descripci�n: Clase principal</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.0
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalizaci�n: 14 / XI / 2006
 */

public class Principal {
  boolean packFrame = false;

  //Construir la aplicaci�n
  public Principal() {
    VentanaPrincipal frame = new VentanaPrincipal();
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
    new Principal();
  }
}
