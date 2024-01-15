package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Título: </p>
 * <p>Descripción: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Empresa: </p>
 * @author sin atribuir
 * @version 1.0
 */

public class Menu extends JFrame {
  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu Archivo = new JMenu();
  JMenu AcercaDe = new JMenu();
  JMenuItem Salir = new JMenuItem();
  JMenu jMenu1 = new JMenu();
  JMenuItem Impresora = new JMenuItem();
  JMenuItem email = new JMenuItem();
  JMenuItem Ayuda = new JMenuItem();

  //Construir el marco
  public Menu() {
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
    this.setJMenuBar(jMenuBar1);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Menu de Eduardito");
    Archivo.setMnemonic('A');
    Archivo.setSelectedIcon(null);
    Archivo.setText("Archivo");
    AcercaDe.setActionCommand("");
    AcercaDe.setMnemonic('D');
    AcercaDe.setSelectedIcon(null);
    AcercaDe.setText("Acerca de");
    Salir.setMnemonic('S');
    Salir.setText("Salir");
    Salir.addActionListener(new Menu_Salir_actionAdapter(this));
    jMenu1.setMnemonic('E');
    jMenu1.setText("Enviar");
    Impresora.setMnemonic('I');
    Impresora.setSelectedIcon(null);
    Impresora.setText("Impresora");
    Impresora.addActionListener(new Menu_Impresora_actionAdapter(this));
    email.setMnemonic('E');
    email.setText("e-mail");
    email.addActionListener(new Menu_email_actionAdapter(this));
    Ayuda.setMnemonic('J');
    Ayuda.setText("Java");
    Ayuda.addActionListener(new Menu_Ayuda_actionAdapter(this));
    jMenuBar1.add(Archivo);
    jMenuBar1.add(AcercaDe);
    Archivo.add(jMenu1);
    Archivo.add(Salir);
    jMenu1.add(Impresora);
    jMenu1.add(email);
    AcercaDe.add(Ayuda);



  }

  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  void ventana_confirmacion(String cadena) {

    String mensaje="";
        mensaje = "" +cadena ;


    JOptionPane.showConfirmDialog(this, mensaje, "**Confirmacion**",
                                  JOptionPane.CLOSED_OPTION);
  }

  void Impresora_actionPerformed(ActionEvent e) {

    ventana_confirmacion("Se ha enviado a la Impresora correctamente");
  }

  void email_actionPerformed(ActionEvent e) {

    ventana_confirmacion("El e-mail se envió satisfactoriamente");
  }

  void Ayuda_actionPerformed(ActionEvent e) {

    ventana_confirmacion("Cargando información...");
  }

  void Salir_actionPerformed(ActionEvent e) {

    ventana_confirmacion("Adios y Gracias");
  }

}

class Menu_Impresora_actionAdapter implements java.awt.event.ActionListener {
  Menu adaptee;

  Menu_Impresora_actionAdapter(Menu adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.Impresora_actionPerformed(e);
  }
}

class Menu_email_actionAdapter implements java.awt.event.ActionListener {
  Menu adaptee;

  Menu_email_actionAdapter(Menu adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.email_actionPerformed(e);
  }
}

class Menu_Ayuda_actionAdapter implements java.awt.event.ActionListener {
  Menu adaptee;

  Menu_Ayuda_actionAdapter(Menu adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.Ayuda_actionPerformed(e);
  }
}

class Menu_Salir_actionAdapter implements java.awt.event.ActionListener {
  Menu adaptee;

  Menu_Salir_actionAdapter(Menu adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.Salir_actionPerformed(e);
  }
}
