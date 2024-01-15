package gestionalmacen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>T�tulo: Ventana Principal</p>
 * <p>Descripci�n: ventana de inicio, de presenaci�n. Con todas las opciones iniciales</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.0
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalizaci�n: 14 / XI / 2006
 */

public class VentanaPrincipal extends JFrame {
  JPanel contentPane;

////////////////////////////////////////////////////////////////////////////////
  JMenuBar jMenuBarMenu = new JMenuBar();

  JMenu jMenuMantenimiento = new JMenu();
    JMenuItem jMenuItemClientes = new JMenuItem();
    JMenuItem jMenuItemProveedores = new JMenuItem();
    JMenuItem jMenuItemArticulos = new JMenuItem();
    JMenuItem jMenuItemSalir = new JMenuItem();


  JMenu jMenuAyuda = new JMenu();
    JMenuItem jMenuItemCentro = new JMenuItem();
    JMenuItem jMenuItemAcerca = new JMenuItem();
////////////////////////////////////////////////////////////////////////////////

  //Constructor
  public VentanaPrincipal() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }


  // M�todo privado que recibe varias cadenas de texto y genera una ventana de
// error comprensible para el usuario
  private void EscribeMensaje(String cadena1, String cadena2){
// Genramos la pantalla
    JOptionPane.showConfirmDialog(this, cadena2, cadena1,
                              JOptionPane.CLOSED_OPTION);
  }//Fin de EscribeMensaje


/* M�todo privado que recibe varias cadenas de texto y genera un mensaje con
   los botones S� / NO y devuelve un valor ENTERO seg�n se presione uno
   u otro bot�n.                                                              */
  private int MensajeSiNo(String cad1,String cad2){

     int res=JOptionPane.showConfirmDialog(this, cad2 , cad1 ,
                             JOptionPane.YES_NO_OPTION);

   return res;
  }// Fin de MensajeSiNo



  private void Salir(String mensaje){
  // Preguntamos si est� segur@
  int aseguradora = MensajeSiNo("� Atenci�n !", mensaje);

  // Si ha respondido afirmativamente:
  if (aseguradora == 0){
    EscribeMensaje("Adi�s", "Esperamos que disfrutase de la aplicaci�n");
    System.exit(0);
  }
}// Fin del m�todo que repgunta para salir



  //Inicializaci�n de componentes
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Gesti�n de Almacen");

    // El siguiente C�digo cambia el Icono de la ventana :)
    ImageIcon miIcono = new ImageIcon("icono.gif");
    setIconImage(miIcono.getImage());

////////////////////////////////////////////////////////////////////////////////
////////////////////////    MEN� HORIZINTAL   //////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    this.setJMenuBar(jMenuBarMenu);
    this.setResizable(false);

//// OPCI�N MANTENIMIENTO
    jMenuMantenimiento.setText("Mantenimiento");
    jMenuMantenimiento.setMnemonic('M');

      jMenuItemClientes.setText("Clientes");
      jMenuItemClientes.setMnemonic('C');

      jMenuItemProveedores.setText("Proveedores");
      jMenuItemProveedores.setEnabled(false);
    jMenuItemProveedores.setMnemonic('P');

      jMenuItemArticulos.setText("Art�culos");
      jMenuItemArticulos.setEnabled(false);
    jMenuItemArticulos.setMnemonic('A');

      jMenuItemSalir.setText("Salir");
    jMenuItemSalir.addActionListener(new VentanaPrincipal_jMenuItemSalir_actionAdapter(this));
      jMenuItemSalir.setMnemonic('S');

//// OPCI�N CONSULTAS

//// OPCI�N AYUDA
    jMenuAyuda.setText("Ayuda");
    jMenuAyuda.setMnemonic('U');

      jMenuItemCentro.setText("Centro de ayuda y Soporte T�cnico");
    jMenuItemCentro.addActionListener(new VentanaPrincipal_jMenuItemCentro_actionAdapter(this));
      jMenuItemCentro.setMnemonic('C');

      jMenuItemAcerca.setText("Acerca de");
      jMenuItemAcerca.setMnemonic('A');


    jMenuItemAcerca.addActionListener(new VentanaPrincipal_jMenuItemAcerca_actionAdapter(this));
    jMenuItemClientes.addActionListener(new VentanaFormulario_jMenuItemFormulario_actionAdapter(this));
////////////////////////////////////////////////////////////////////////////////

    jMenuBarMenu.add(jMenuMantenimiento);
    jMenuBarMenu.add(jMenuAyuda);

    jMenuMantenimiento.add(jMenuItemClientes);
    jMenuMantenimiento.add(jMenuItemProveedores);
    jMenuMantenimiento.add(jMenuItemArticulos);
    jMenuMantenimiento.addSeparator();
    jMenuMantenimiento.add(jMenuItemSalir);

    jMenuAyuda.add(jMenuItemCentro);
    jMenuAyuda.addSeparator();
    jMenuAyuda.add(jMenuItemAcerca);
////////////////////////////////////////////////////////////////////////////////
////////////////////////   FIN MEN� HORIZINTAL   ///////////////////////////////
////////////////////////////////////////////////////////////////////////////////
  }

  //Modificado para NO poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
   /* super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }*/
  }

////////////////////////////////////////////////////////////////////////////////
/////////////////////////   M�TODOS Y OPCIONES   ///////////////////////////////
////////////////////////////////////////////////////////////////////////////////

  // M�todo Centrar
  private void Centrar(JFrame ventana){
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = ventana.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    ventana.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    ventana.setVisible(true);

  }// Fin del m�todo Centrar

// MEN� ACERCA DE
  void jMenuItemAcerca_actionPerformed(ActionEvent e) {
    // Damos valores a los textos de la ventana Acerca De
    String titulo="Acerca de...";
    String titulo2="Informaci�n Gesti�n de Almac�n 0.1";
    String texto="Para m�s info. consulte con su farmac�utico";

    // Creamos una ventana Acerca De
    VentanaAcercaDe informacion = new VentanaAcercaDe(this,titulo,titulo2,texto);
    // Ponemos esta ventana sin que se pueda tocar
    setEnabled(false);
    // Centramos la nueva Ventana, para lo cula llamaremos al m�todo Centrar
    Centrar(informacion);
    // Y la mostramos
    informacion.show();
  }// Fin de Acerca de

  // MEN� CENTRO DE AYUDA Y SOPORTE T�CNICO
  void jMenuItemCentro_actionPerformed(ActionEvent e) {
    // Damos valores a los textos de la ventana Acerca De
    String titulo="Ayuda y Soporte T�cnico";
    String titulo2="Ayuda Gesti�n de Almac�n 0.1";
    String texto="Para obtener ayuda llame al Sco. T�cnico: 629-737-616";

    // Creamos una ventana Acerca De
    VentanaAcercaDe ayuda = new VentanaAcercaDe(this,titulo,titulo2,texto);

    // Ponemos esta ventana sin que se pueda tocar
    setEnabled(false);
    // Centramos la nueva Ventana, para lo cula llamaremos al m�todo Centrar
    Centrar(ayuda);
    // Y la mostramos
    ayuda.show();
  }// FIN DE LA AYUDA Y EL SOPORTE T�CNICO


  // MEN� GESTIONAR CLIENTES
  void jMenuItemClientes_actionPerformed(ActionEvent e) {
    // Creamos una ventana Formulario
    VentanaFormulario formulario = new VentanaFormulario(this);
    // Ponemos esta ventana sin que se pueda tocar
    setEnabled(false);
    // Centramos la nueva Ventana, para lo cula llamaremos al m�todo Centrar
    Centrar(formulario);
    // Y la mostramos
    formulario.show();
  }

  void jMenuItemSalir_actionPerformed(ActionEvent e) {
    Salir("�Realmente desea salir de la aplicaci�n?\n\n"+
          "�sta operaci�n no tiene vuelta atr�s");

  }////// FIN DE LA GESTI�N DE LOS CLIENTES
}// class

////////////////////////////////////////////////////////////////////////////////
//////////////////////                                 /////////////////////////
//////////////////////  R E S T O  D E L  C � D I G O  /////////////////////////
//////////////////////                                 /////////////////////////
////////////////////////////////////////////////////////////////////////////////

class VentanaPrincipal_jMenuItemAcerca_actionAdapter implements java.awt.event.ActionListener {
  VentanaPrincipal adaptee;

  VentanaPrincipal_jMenuItemAcerca_actionAdapter(VentanaPrincipal adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemAcerca_actionPerformed(e);
  }
}

class VentanaFormulario_jMenuItemFormulario_actionAdapter implements java.awt.event.ActionListener {
  VentanaPrincipal adaptee;

  VentanaFormulario_jMenuItemFormulario_actionAdapter(VentanaPrincipal adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemClientes_actionPerformed(e);
  }
}

class VentanaPrincipal_jMenuItemCentro_actionAdapter implements java.awt.event.ActionListener {
  VentanaPrincipal adaptee;

  VentanaPrincipal_jMenuItemCentro_actionAdapter(VentanaPrincipal adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemCentro_actionPerformed(e);
  }
}

class VentanaPrincipal_jMenuItemSalir_actionAdapter implements java.awt.event.ActionListener {
  VentanaPrincipal adaptee;

  VentanaPrincipal_jMenuItemSalir_actionAdapter(VentanaPrincipal adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemSalir_actionPerformed(e);
  }
}
