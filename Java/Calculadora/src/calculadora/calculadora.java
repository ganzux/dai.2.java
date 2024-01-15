package calculadora;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>Título: Calculadora de Álvaro</p>
 * <p>Descripción: Pequeño proyecto de Bienvenida, construyendo una calculadora básica</p>
 * <p>Copyright: CopyLeft (l) 2006 por WwW . AlvaRiTo . NeT</p>
 * <p>Empresa: iToSoFt</p>
 * @author Álvaro Alcedo Moreno
 * @version 0.5
 */


public class calculadora {
  boolean packFrame = false;

  //Construir la aplicación
  public calculadora() {
    Marco1 frame = new Marco1();
    //Validar marcos que tienen tamaños preestablecidos
    //Empaquetar marcos que cuentan con información de tamaño preferente útil. Ej. de su diseño.
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

  //Método Main
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
