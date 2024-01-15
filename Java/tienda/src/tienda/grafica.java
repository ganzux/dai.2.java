package tienda;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>Título: Tienda de ordenadores</p>
 * <p>Descripción: <Pequeño proyrecto para la gestión de una tienda de ordenadores/p>
 * <p>Copyright: CopyLeft (c) 2006</p>
 * <p>Empresa: iTo Soft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.0
 * <p>Inicio: 5 / X / 2006</p>
 * <p>Fin: 10 / X / 2006</p>
 */


public class grafica {
  boolean packFrame = false;

  //Construir la aplicación
  public grafica() {
    Entorno frame = new Entorno();
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
    new grafica();
  }
}
