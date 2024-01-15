package calculadora;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>Título: Ejercicio de prueba de inicio de curso</p>
 * <p>Descripción: Creamos una ventana</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Empresa: iTo Soft</p>
 * @author Álvaro
 * @version 1.0
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