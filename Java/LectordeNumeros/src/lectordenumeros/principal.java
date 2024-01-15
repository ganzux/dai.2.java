package lectordenumeros;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Título: Lector de Numeros</p>
 * <p>Descripción: Intento de leer números</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 0.2a
 */

public class principal extends JFrame {
  JPanel contentPane;
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuFile = new JMenu();
  JMenuItem jMenuFileExit = new JMenuItem();
  JMenu jMenuHelp = new JMenu();
  JMenuItem jMenuHelpAbout = new JMenuItem();
  JLabel statusBar = new JLabel();
  JTextField texto = new JTextField();
  JTextField texto2 = new JTextField();

  //Construir el marco
  public principal() {
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
    contentPane.setLayout(null);
    this.setContentPane(contentPane);
    this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    this.setLocale(java.util.Locale.getDefault());
    this.setResizable(false);
    this.setSize(new Dimension(400, 300));
    this.setState(Frame.NORMAL);
    this.setTitle("Ventana de iTo");
    statusBar.setText(" ");
    statusBar.setBounds(new Rectangle(0, 285, 400, 15));
    jMenuFile.setText("Archivo");
    jMenuFileExit.setText("Salir");
    jMenuFileExit.addActionListener(new principal_jMenuFileExit_ActionAdapter(this));
    jMenuHelp.setText("Ayuda");
    jMenuHelpAbout.setText("Acerca de");
    jMenuHelpAbout.addActionListener(new principal_jMenuHelpAbout_ActionAdapter(this));
    texto.setFont(new java.awt.Font("Comic Sans MS", 1, 35));
    texto.setVerifyInputWhenFocusTarget(true);
    texto.setText("");
    texto.setBounds(new Rectangle(103, 44, 202, 63));
    texto.addKeyListener(new principal_texto_keyAdapter(this));
    texto2.setEditable(false);
    texto2.setText("");
    texto2.setBounds(new Rectangle(37, 128, 343, 61));
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenuHelp);
    this.setJMenuBar(jMenuBar1);
    contentPane.add(statusBar, null);
    contentPane.add(texto, null);
    contentPane.add(texto2, null);
  }

  //Realizar Archivo | Salir
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }

  //Realizar Ayuda | Acerca de
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
    principal_AcercaDe dlg = new principal_AcercaDe(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.pack();
    dlg.show();
  }

  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      jMenuFileExit_actionPerformed(null);
    }
  }

  // Función lee
  private String lee (String cadena){
    String devolucion="Por favor, inserte números.";
    if (cadena.matches("[0-9]+")){
      int contador=0;
      for (contador=cadena.length();contador>0;contador--){
        switch (cadena.charAt(contador)){

          case 1:
            devolucion= "uno";
            break;

          case 2:
            devolucion="2";
            break;

          case 3:
            devolucion="3";
            break;

        }//switch
      }//for
    }//fi
    return devolucion;
  }//fin de lee

  void texto_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10){
      texto2.setText(lee(texto.getText()));
    }
  }

}

class principal_jMenuFileExit_ActionAdapter implements ActionListener {
  principal adaptee;

  principal_jMenuFileExit_ActionAdapter(principal adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuFileExit_actionPerformed(e);
  }
}

class principal_jMenuHelpAbout_ActionAdapter implements ActionListener {
  principal adaptee;

  principal_jMenuHelpAbout_ActionAdapter(principal adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuHelpAbout_actionPerformed(e);
  }
}

class principal_texto_keyAdapter extends java.awt.event.KeyAdapter {
  principal adaptee;

  principal_texto_keyAdapter(principal adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.texto_keyPressed(e);
  }
}
