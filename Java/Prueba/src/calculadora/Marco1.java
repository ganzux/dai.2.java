package calculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Título: Ejercicio de prueba de inicio de curso</p>
 * <p>Descripción: Creamos una ventana</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Empresa: iTo Soft</p>
 * @author Álvaro
 * @version 1.0
 */

public class Marco1 extends JFrame {
  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();

  //Construir el marco
  public Marco1() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Inicialización de componentes
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Calculadora");
  }

  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }
}
