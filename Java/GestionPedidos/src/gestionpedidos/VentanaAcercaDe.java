package gestionpedidos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * <p>Título: VentanaAcercaDe</p>
 * <p>Descripción: Ventana de prueba para coemntarios "Acerca de" y "Soporte Técnico"</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.0
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalización: 14 / XI / 2006
 */

public class VentanaAcercaDe extends JFrame {
  JToggleButton jToggleButtonVolver = new JToggleButton();

  // Variable de clase de tipo JFrame llamada padre
  private JFrame padre;
  private String titulo;
  private String titulo2;
  private String texto;
  // Título de los créditos
  JLabel jLabelTexto = new JLabel();
  JLabel jLabelTextoExtendido = new JLabel();
  JLabel jLabellogo = new JLabel();

  // Constructor; por defecto le vamos a pasar un objeto de tipo JFrame
  public VentanaAcercaDe(JFrame padre, String titulo,String titulo2,String texto) {

    // Probamos a lanzar el método jbInit
    try {
      // Le decimos que la varible padre es la ventana actual
      this.padre=padre;
      this.titulo=titulo;
      this.titulo2=titulo2;
      this.texto=texto;
      jbInit();
    }
    // Y capturamos las Excepciones
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  // MÉTODO jbInit
  void jbInit() throws Exception {

///////////////////////////////// BOTÓN VOLVER /////////////////////////////////
    jToggleButtonVolver.setText("VOLVER");
    jToggleButtonVolver.setFont(new java.awt.Font("Monotype Corsiva", 1, 25));
    jToggleButtonVolver.setMnemonic('V');
    jToggleButtonVolver.setBounds(new Rectangle(120, 300, 180, 61));
    jToggleButtonVolver.addActionListener(new VentanaAcercaDe_jToggleButtonVolver_actionAdapter(this));
/////////////////////////////// FIN BOTÓN VOLVER ///////////////////////////////

/////////////////////////////////// VENTANA ////////////////////////////////////
    this.getContentPane().setLayout(null);
    this.setLocale(java.util.Locale.getDefault());
    this.setResizable(false);
    this.setSize(new Dimension(405, 399));
    this.setTitle(titulo);
    this.addWindowListener(new VentanaAcercaDe_this_windowAdapter(this));
///////////////////////////////// FIN VENTANA //////////////////////////////////


  // El siguiente Código cambia el Icono de la ventana :)
  ImageIcon miIcono = new ImageIcon("icono.gif");
  setIconImage(miIcono.getImage());
  // Imagen de fondo
  ImageIcon miFondo = new ImageIcon("fondo.jpg");

  jLabelTexto.setFont(new java.awt.Font("Dialog", 1, 20));
  jLabelTexto.setText(titulo2);
  jLabelTexto.setBounds(new Rectangle(1, 155, 390, 60));
  jLabelTextoExtendido.setFont(new java.awt.Font("Dialog", 0, 14));
  jLabelTextoExtendido.setText(texto);
  jLabelTextoExtendido.setBounds(new Rectangle(1, 185, 390, 109));

  jLabellogo.setBounds(new Rectangle(0, 0, 400, 150));
  jLabellogo.setIcon(miFondo);

  jToggleButtonVolver.grabFocus();

  this.getContentPane().add(jToggleButtonVolver, null);
  this.getContentPane().add(jLabelTexto, null);
  this.getContentPane().add(jLabelTextoExtendido, null);
  this.getContentPane().add(jLabellogo, null);
  }// Fin del  Método JbInit


  // BOTÓN VOLVER
  void jToggleButtonVolver_actionPerformed(ActionEvent e) {
    padre.setEnabled(true);
    this.dispose();
  }// botón volver


  // Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      padre.setEnabled(true);
      this.dispose();
    }//fi
  }/////////salir


}//class

class VentanaAcercaDe_jToggleButtonVolver_actionAdapter implements java.awt.event.ActionListener {
  VentanaAcercaDe adaptee;

  VentanaAcercaDe_jToggleButtonVolver_actionAdapter(VentanaAcercaDe adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jToggleButtonVolver_actionPerformed(e);
  }
}

class VentanaAcercaDe_this_windowAdapter extends java.awt.event.WindowAdapter {
  VentanaAcercaDe adaptee;
  VentanaAcercaDe_this_windowAdapter(VentanaAcercaDe adaptee) {
    this.adaptee = adaptee;
  }
}
