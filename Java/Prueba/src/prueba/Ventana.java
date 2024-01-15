package prueba;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Título: Ejercicio de prueba de inicio de curso</p>
 * <p>Descripción: Creamos una ventana</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro
 * @version 1.0
 */

public class Ventana extends JFrame {
  JPanel contentPane;
  JButton Escribir = new JButton();
  JButton Borrar = new JButton();
  JLabel jLabel1 = new JLabel();

  //Construir el marco
  public Ventana() {
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
    Escribir.setBounds(new Rectangle(40, 61, 120, 54));
    Escribir.setFont(new java.awt.Font("Dialog", 0, 25));
    Escribir.setActionCommand("Escribir");
    Escribir.setMnemonic('E');
    Escribir.setText("Escribir");
    Escribir.addActionListener(new Ventana_Escribir_actionAdapter(this));
    contentPane.setLayout(null);
    this.getContentPane().setBackground(UIManager.getColor("Button.background"));
    this.setForeground(Color.black);
    this.setLocale(java.util.Locale.getDefault());
    this.setJMenuBar(null);
    this.setResizable(false);
    this.setSize(new Dimension(400, 300));
    this.setState(Frame.NORMAL);
    this.setTitle("Soy una Ventana de Windows :)");
    Borrar.setBounds(new Rectangle(172, 61, 120, 54));
    Borrar.setEnabled(false);
    Borrar.setFont(new java.awt.Font("Dialog", 0, 25));
    Borrar.setMnemonic('B');
    Borrar.setSelected(false);
    Borrar.setText("Borrar");
    Borrar.addActionListener(new Ventana_Borrar_actionAdapter(this));
    jLabel1.setFont(new java.awt.Font("Bodoni MT", 3, 33));
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setToolTipText("");
    jLabel1.setText("");
    jLabel1.setBounds(new Rectangle(14, 135, 252, 153));
    contentPane.add(Escribir, null);
    contentPane.add(Borrar, null);
    contentPane.add(jLabel1, null);
  }

  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  void Escribir_actionPerformed(ActionEvent e) {
    jLabel1.setText("El Gato Tom :)");
    Borrar.setEnabled(true);
    Escribir.setEnabled(false);
  }

  void Borrar_actionPerformed(ActionEvent e) {
    jLabel1.setText("");
    Borrar.setEnabled(false);
    Escribir.setEnabled(true);

  }
}

class Ventana_Escribir_actionAdapter implements java.awt.event.ActionListener {
  Ventana adaptee;

  Ventana_Escribir_actionAdapter(Ventana adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.Escribir_actionPerformed(e);
  }
}

class Ventana_Borrar_actionAdapter implements java.awt.event.ActionListener {
  Ventana adaptee;

  Ventana_Borrar_actionAdapter(Ventana adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.Borrar_actionPerformed(e);
  }
}
