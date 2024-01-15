package formulario;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>T�tulo: Formulario de Prueba</p>
 * <p>Descripci�n: Un formulario del que validaremos los datos</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Empresa: iToSofT</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.0 rc
 */

public class Marco1 extends JFrame {
  JPanel contentPane;

  JLabel jLabelCodigo = new JLabel();
  JLabel jLabelCodigo2 = new JLabel();
  JTextField jTextCodigo = new JTextField();

  JLabel jLabelNIF = new JLabel();
  JLabel jLabelNIF2 = new JLabel();
  JTextField jTextNIF = new JTextField();
  JTextField jTextNIFLetra = new JTextField();

  JLabel jLabelNombre = new JLabel();
  JLabel jLabelNombre2 = new JLabel();
  JTextField jTextNombre = new JTextField();

  JLabel jLabelApellidos = new JLabel();
  JLabel jLabelApellidos2 = new JLabel();
  JTextField jTextApellidos = new JTextField();

  JLabel jLabelDomicilio = new JLabel();
  JLabel jLabelDomicilio2 = new JLabel();
  JTextField jTextFieldDomicilio = new JTextField();

  JLabel jLabelCP = new JLabel();
  JLabel jLabelCP2 = new JLabel();
  JTextField jTextFieldCP = new JTextField();

  JLabel jLabelLocalidad = new JLabel();
  JLabel jLabelLocalidad2 = new JLabel();
  JTextField jTextFieldLocalidad = new JTextField();

  JLabel jLabelTelefono = new JLabel();
  JLabel jLabelTelefono2 = new JLabel();
  JTextField jTextFieldTelefono = new JTextField();

  JLabel jLabelMovil = new JLabel();
  JLabel jLabelMovil2 = new JLabel();
  JTextField jTextFieldMovil = new JTextField();

  JLabel jLabelFax = new JLabel();
  JLabel jLabelFax2 = new JLabel();
  JTextField jTextFieldFax = new JTextField();

  JLabel jLabelemail = new JLabel();
  JLabel jLabelemail2 = new JLabel();
  JTextField jTextFieldemail = new JTextField();

  JLabel jLabelVentas = new JLabel();
  JLabel jLabelVentas2 = new JLabel();
  JTextField jTextFieldVentas = new JTextField();
  JButton jButtonAceptar = new JButton();
  JButton jButtonBorrar = new JButton();



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

  //Inicializaci�n de componentes
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setLocale(java.util.Locale.getDefault());
    this.setResizable(false);
    this.setSize(new Dimension(405, 385));
    this.setTitle("Formulario de Prueba");

  // El siguiente C�digo cambia el Icono de la ventana :)
    ImageIcon miImagen = new ImageIcon("icono.gif");
    setIconImage(miImagen.getImage());

/* Dise�amos el formulario: Por casa "campo" podr� 2 etiquetas de Texto y una
caja de Texto; las dos etiquetas ser�n para el texto y la letra subrayada
de acceso r�pido. La caja de texto servir� para meter los datos, excepto en el
NIF, que tendr� dos cajas, una de ellas inaccesible que generar� la letra. */

// Etiqueta C�digo
    jLabelCodigo.setText("C�digo");
    jLabelCodigo.setBounds(new Rectangle(1, 1, 43, 20));
    // La letra en rojo
    jLabelCodigo2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelCodigo2.setForeground(Color.red);
    jLabelCodigo2.setText("C");
    jLabelCodigo2.setBounds(new Rectangle(1, 1, 60, 20));

// Caja C�digo
    jTextCodigo.setFocusAccelerator('C');  // Acceso R�pido: C
    jTextCodigo.setText("");
    jTextCodigo.setBounds(new Rectangle(1, 25, 75, 20));
    jTextCodigo.addKeyListener(new Marco1_jTextCodigo_keyAdapter(this));


// Etiqueta N.I.F.
    jLabelNIF.setText("N.I.F.");
    jLabelNIF.setBounds(new Rectangle(100, 1, 30, 20));
    // la letra en rojo
    jLabelNIF2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelNIF2.setForeground(Color.red);
    jLabelNIF2.setText("N");
    jLabelNIF2.setBounds(new Rectangle(100, 1, 50, 20));

// Caja N.I.F. y caja de la letra del NIF
    jTextNIF.setFocusAccelerator('N');     // Acceso R�pido: N
    jTextNIF.setText("");
    jTextNIF.setBounds(new Rectangle(100, 25, 100, 20));
    jTextNIF.addKeyListener(new Marco1_jTextNIF_keyAdapter(this));
    jTextNIFLetra.setEnabled(false);
    jTextNIFLetra.setOpaque(false);      // La Desactivamos
    jTextNIFLetra.setText("");
    jTextNIFLetra.setBounds(new Rectangle(200, 25, 20, 20));


// Etiqueta Nombre
    jLabelNombre.setText("Nombre");
    jLabelNombre.setBounds(new Rectangle(245, 1, 60, 20));
    // La letra en rojo
    jLabelNombre2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelNombre2.setForeground(Color.red);
    jLabelNombre2.setText("o");
    jLabelNombre2.setBounds(new Rectangle(252, 1, 21, 20));

// Caja del Nombre
    jTextNombre.setFocusAccelerator('O');  // Acceso R�pido: O
    jTextNombre.setText("");
    jTextNombre.setBounds(new Rectangle(245, 25, 150, 20));
    jTextNombre.addKeyListener(new Marco1_jTextNombre_keyAdapter(this));


// Etiqueta de los Apellidos
    jLabelApellidos.setText("Apellidos");
    jLabelApellidos.setBounds(new Rectangle(1, 50, 60, 20));
    // Tecla roja
    jLabelApellidos2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelApellidos2.setForeground(Color.red);
    jLabelApellidos2.setText("s");
    jLabelApellidos2.setBounds(new Rectangle(38, 50, 23, 20));

// Caja de los Apellidos
    jTextApellidos.setFocusAccelerator('S');// Acceso R�pido: S
    jTextApellidos.setText("");
    jTextApellidos.setBounds(new Rectangle(1, 75, 395, 20));
    jTextApellidos.addKeyListener(new Marco1_jTextApellidos_keyAdapter(this));


// Etiqueta del Domicilio
    jLabelDomicilio.setText("Domicilio");
    jLabelDomicilio.setBounds(new Rectangle(1, 100, 100, 20));
    // texto en rojo
    jLabelDomicilio2.setEnabled(true);
    jLabelDomicilio2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelDomicilio2.setForeground(Color.red);
    jLabelDomicilio2.setText("D");
    jLabelDomicilio2.setBounds(new Rectangle(1, 100, 100, 20));

// Caja del Domicilio
    jTextFieldDomicilio.setFocusAccelerator('D'); // Acceso R�pido: D
    jTextFieldDomicilio.setText("");
    jTextFieldDomicilio.setBounds(new Rectangle(1, 125, 395, 20));
    jTextFieldDomicilio.addKeyListener(new Marco1_jTextFieldDomicilio_keyAdapter(this));


// Etiqueta del C�digo Postal
    jLabelCP.setText("C�digo Postal");
    jLabelCP.setBounds(new Rectangle(1, 150, 90, 20));
    // texto en rojo
    jLabelCP2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelCP2.setForeground(Color.red);
    jLabelCP2.setText("P");
    jLabelCP2.setBounds(new Rectangle(36, 150, 54, 20));

// Caja del C�digo Postal
    jTextFieldCP.setFocusAccelerator('P'); // Acceso R�pido: P
    jTextFieldCP.setText("");
    jTextFieldCP.setBounds(new Rectangle(1, 175, 80, 20));
    jTextFieldCP.addKeyListener(new Marco1_jTextFieldCP_keyAdapter(this));


// Etiqueta de la Localidad
    jLabelLocalidad.setText("Localidad");
    jLabelLocalidad.setBounds(new Rectangle(100, 150, 60, 20));
    // texto en rojo
    jLabelLocalidad2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelLocalidad2.setForeground(Color.red);
    jLabelLocalidad2.setText("L");
    jLabelLocalidad2.setBounds(new Rectangle(100, 150, 60, 20));

//Caja de la Localidad
    jTextFieldLocalidad.setFocusAccelerator('L'); //Acceso R�pido: L
    jTextFieldLocalidad.setText("");
    jTextFieldLocalidad.setBounds(new Rectangle(100, 175, 172, 20));
    jTextFieldLocalidad.addKeyListener(new Marco1_jTextFieldLocalidad_keyAdapter(this));


// Etiqueta del Tel�fono
    jLabelTelefono.setText("Tel�fono");
    jLabelTelefono.setBounds(new Rectangle(1, 200, 55, 20));
    // TEXTO EN ROJO
    jLabelTelefono2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelTelefono2.setForeground(Color.red);
    jLabelTelefono2.setText("T");
    jLabelTelefono2.setBounds(new Rectangle(1, 200, 55, 20));

// Caja del Tel�fono
    jTextFieldTelefono.setFocusAccelerator('T'); //Acceso R�pido: T
    jTextFieldTelefono.setText("");
    jTextFieldTelefono.setBounds(new Rectangle(1, 225, 80, 20));
    jTextFieldTelefono.addKeyListener(new Marco1_jTextFieldTelefono_keyAdapter(this));


// Etiqueta del M�vil
    jLabelMovil.setText("M�vil");
    jLabelMovil.setBounds(new Rectangle(110, 200, 113, 24));
    // texto en rojo
    jLabelMovil2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelMovil2.setForeground(Color.red);
    jLabelMovil2.setText("M");
    jLabelMovil2.setBounds(new Rectangle(110, 200, 113, 24));

// Caja del M�vil
    jTextFieldMovil.setFocusAccelerator('M'); // Acceso R�pido: M
    jTextFieldMovil.setText("");
    jTextFieldMovil.setBounds(new Rectangle(110, 225, 80, 20));
    jTextFieldMovil.addKeyListener(new Marco1_jTextFieldMovil_keyAdapter(this));


// Etiqueta del Fax
    jLabelFax.setText("Fax");
    jLabelFax.setBounds(new Rectangle(220, 200, 44, 20));
    // texto en rojo
    jLabelFax2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelFax2.setForeground(Color.red);
    jLabelFax2.setText("F");
    jLabelFax2.setBounds(new Rectangle(220, 200, 44, 20));

// Caja del Fax
    jTextFieldFax.setFocusAccelerator('F'); // Acceso R�pido: F
    jTextFieldFax.setText("");
    jTextFieldFax.setBounds(new Rectangle(220, 225, 80, 20));
    jTextFieldFax.addKeyListener(new Marco1_jTextFieldFax_keyAdapter(this));


// Etiqueta del Mail
    jLabelemail.setText("e - mail");
    jLabelemail.setBounds(new Rectangle(1, 250, 116, 20));
    //texto en rojo
    jLabelemail2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelemail2.setForeground(Color.red);
    jLabelemail2.setText("e");
    jLabelemail2.setBounds(new Rectangle(1, 250, 116, 20));

// Caja del Mail
    jTextFieldemail.setFocusAccelerator('E'); // Acceso R�pido: E
    jTextFieldemail.setText("");
    jTextFieldemail.setBounds(new Rectangle(2, 275, 188, 20));
    jTextFieldemail.addKeyListener(new Marco1_jTextFieldemail_keyAdapter(this));


// Etiqueta de las Ventas
    jLabelVentas.setText("Total Ventas");
    jLabelVentas.setBounds(new Rectangle(325, 250, 71, 20));
    // texto en rojo
    jLabelVentas2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelVentas2.setForeground(Color.red);
    jLabelVentas2.setText("V");
    jLabelVentas2.setBounds(new Rectangle(351, 250, 22, 20));

// Caja de las Ventas
    jTextFieldVentas.setFocusAccelerator('V'); // Acceso R�pido: V
    jTextFieldVentas.setText("");
    jTextFieldVentas.setBounds(new Rectangle(324, 275, 72, 20));
    jTextFieldVentas.addKeyListener(new Marco1_jTextFieldVentas_keyAdapter(this));



// A�adimos los objetos a la ventana

    jButtonAceptar.setBounds(new Rectangle(86, 320, 90, 35));
    jButtonAceptar.setMnemonic('A');
    jButtonAceptar.setText("Aceptar");
    jButtonAceptar.addActionListener(new Marco1_jButtonAceptar_actionAdapter(this));

    jButtonBorrar.setBounds(new Rectangle(214, 320, 90, 35));
    jButtonBorrar.setMnemonic('B');
    jButtonBorrar.setText("Borrar");
    jButtonBorrar.addActionListener(new Marco1_jButtonBorrar_actionAdapter(this));

    contentPane.add(jLabelCodigo, null);
    contentPane.add(jLabelCodigo2, null);
    contentPane.add(jTextCodigo, null);

    contentPane.add(jLabelNIF, null);
    contentPane.add(jLabelNIF2, null);
    contentPane.add(jTextNIF, null);
    contentPane.add(jTextNIFLetra, null);

    contentPane.add(jLabelNombre, null);
    contentPane.add(jLabelNombre2, null);
    contentPane.add(jTextNombre, null);

    contentPane.add(jLabelApellidos, null);
    contentPane.add(jLabelApellidos2, null);
    contentPane.add(jTextApellidos, null);

    contentPane.add(jLabelDomicilio, null);
    contentPane.add(jLabelDomicilio2, null);
    contentPane.add(jTextFieldDomicilio, null);

    contentPane.add(jLabelCP, null);
    contentPane.add(jLabelCP2, null);
    contentPane.add(jTextFieldCP, null);

    contentPane.add(jLabelLocalidad, null);
    contentPane.add(jLabelLocalidad2, null);
    contentPane.add(jTextFieldLocalidad, null);

    contentPane.add(jLabelMovil, null);
    contentPane.add(jLabelMovil2, null);
    contentPane.add(jTextFieldMovil, null);

    contentPane.add(jLabelFax, null);
    contentPane.add(jLabelFax2, null);
    contentPane.add(jTextFieldFax, null);

    contentPane.add(jLabelTelefono2, null);
    contentPane.add(jLabelTelefono, null);
    contentPane.add(jTextFieldTelefono, null);

    contentPane.add(jLabelemail, null);
    contentPane.add(jLabelemail2, null);
    contentPane.add(jTextFieldemail, null);

    contentPane.add(jLabelVentas, null);
    contentPane.add(jLabelVentas2, null);
    contentPane.add(jTextFieldVentas, null);

    contentPane.add(jButtonAceptar, null);
    contentPane.add(jButtonBorrar, null);
  }


  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }


// Acciones del Bot�n Cancelar
  void jButtonBorrar_actionPerformed(ActionEvent e) {
// El bot�n cancelar borra todos los campos
    jTextCodigo.setText("");
    jTextNIF.setText("");
    jTextNIFLetra.setText("");
    jTextNombre.setText("");
    jTextApellidos.setText("");
    jTextFieldDomicilio.setText("");
    jTextFieldCP.setText("");
    jTextFieldLocalidad.setText("");
    jTextFieldTelefono.setText("");
    jTextFieldMovil.setText("");
    jTextFieldTelefono.setText("");
    jTextFieldFax.setText("");
    jTextFieldemail.setText("");
    jTextFieldVentas.setText("");
// Activa los campos C�digo y NIF
    jTextCodigo.setEditable(true);
    jTextNIF.setEditable(true);
// Y manda el cursor a C�digo
    jTextCodigo.grabFocus();
  }// Bot�n cerrar


// M�todo privado que recibe varias cadenas de texto y genera una ventana de
// error comprensible para el usuario
  private void EscribeError(String cadena1, String cadena2, String cadena3){
    String mensaje;
// Concatenamos los mensajes para que se vea el c�digo mejor
    mensaje = "El campo "+cadena1+" es obligatorio, \n";
    mensaje+= "s�lo puede contener "+cadena2+"\n";
    mensaje+= "y la longitud ha de ser "+cadena3+".";
// Genramos la pantalla
    JOptionPane.showConfirmDialog(this, mensaje, "Error",
                              JOptionPane.CLOSED_OPTION);
  }//Fin de EscribeError

/*El siguiente m�todo recibe una cadena y un n�mero, y completa la cadena hasta
  ese n�mero de cifras rellen�ndolo por la izquierda  */
private String rellena(String cadena,int numerodeceros){
  while (cadena.length() < numerodeceros)
    cadena="0"+cadena;     // Concatenaci�n ;)
  return cadena;
}

// El siguiente m�todo devuelve la letra en forma String de un NIF facilitado
private String generaLetra(String DNI){

//Rellenamos con ceros a la izquierda hasta 8 d�gitos:
  DNI=rellena(DNI,8);

// En la variable resto metemos el resto de la divisi�n entera del NIF entre 23
  int resto = Integer.parseInt(jTextNIF.getText()) % 23;

// Declaramos una variable con las letras del DNI ordenadas seg�n el resto
  String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

// Escribimos la letra en la casilla deshabilitada
  String letrareal = letras.charAt(resto) + "";

  return letrareal;
}// fin del generaLetra

//////////////////////////  FIN DE LOS M�TODOS UTILIZADOS  /////////////////////


// Las siguientes Funciones Codifican que cuando se pulse ENTER, el FOCO pase a
// la casilla posterior

// CODIGO: En �ste caso tambi�n comprueba que sea un n�mero lo que introducimos
// de menos de 7 cifras, rellen�ndolo con ceros por la izquierda si fuere necesario
  void jTextCodigo_keyPressed(KeyEvent e) {
    // Si presiona Intro:
    if (e.getKeyCode()==10){

    // Si la cadena no es num�rica o su longi es > de 6 damos el error
      if (!jTextCodigo.getText().matches("[0-9]+") || jTextCodigo.getText().length()>6)
      {
// Llamamos a una funci�n que recibe tres Strings y genera un mensaje de Error
        EscribeError("C�digo", "n�meros", "de seis cifras");
// Y situamos el cursor sobre el error. �sta din�mica la seguiremos en todos
        jTextCodigo.grabFocus();
        jTextCodigo.selectAll();
      }

    // En caso contrario, que es num�rica
      else { //Llamamos a la funci�n rellena:
          jTextCodigo.setText(rellena(jTextCodigo.getText(),6));
          // bloqueamos la casilla
        jTextCodigo.setEditable(false);
        jTextNIF.grabFocus();// y mandamos el cursor a la siguiente celda
      }
    }
  }// Fin del Enter de C�digo


// NIF
  void jTextNIF_keyPressed(KeyEvent e) {
// Si pulsamos Intro:
  if (e.getKeyCode()==10)
      jTextNombre.grabFocus();
  }// Fin del NIF


//Nombre
void jTextNombre_keyPressed(KeyEvent e) {
  if (e.getKeyCode()==10)
    jTextApellidos.grabFocus();
}


// Apellidos
  void jTextApellidos_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jTextFieldDomicilio.grabFocus();
  }


// Domicilio
  void jTextFieldDomicilio_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jTextFieldCP.grabFocus();
  }


// C�digo Postal
  void jTextFieldCP_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jTextFieldLocalidad.grabFocus();
  }


// Localidad
  void jTextFieldLocalidad_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jTextFieldTelefono.grabFocus();
  }


// Telefono
  void jTextFieldTelefono_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jTextFieldMovil.grabFocus();
  }


// Movil
  void jTextFieldMovil_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jTextFieldFax.grabFocus();
  }


// Fax
  void jTextFieldFax_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jTextFieldemail.grabFocus();
  }


// E-mail
  void jTextFieldemail_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jTextFieldVentas.grabFocus();
  }


// Ventas: �ste caso se manda al bot�n ACEPTAR
  void jTextFieldVentas_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jButtonAceptar.grabFocus();
  }

// FIN de los ENTER


// Codificaci�n del Evento ACTIONPERFORMED del bot�n ENTER
  void jButtonAceptar_actionPerformed(ActionEvent e) {

// Empezaremos validando el DNI:
// Si la cadena son letras o m�s de ocho n�meros
    if(!jTextNIF.getText().matches("[0-9]+") || jTextNIF.getText().length()>8){
// Error con mi funci�n y el foco al error
      EscribeError("NIF", "n�meros", "de ocho cifras");
      jTextNIF.grabFocus();
      jTextNIF.selectAll();
    }

    else {
// En caso contrario, Si la cadena son menos de 9 n�meros (doble comprobaci�n):
// Llamamos a la funci�n que genera la letra del NIF y la escribimos
      jTextNIFLetra.setText(generaLetra(jTextNIF.getText()));

// deshabilitamos el campo
      jTextNIF.setEditable(false);
      // fin de si la cadena son menos de nueve n�meros


// Segundo IF: Que el campo Nombre cumpla los requisitos
      if ( (jTextNombre.getText().compareTo("") == 0) ||
          ! (jTextNombre.getText().matches("[A-Za-z ������������]+")) ||
          (jTextNombre.getText().length() > 15)) {
        EscribeError("Nombre", "letras", "menor o igual a 16");
        jTextNombre.grabFocus();
        jTextNombre.selectAll();
      }

// Siguiente IF: Requisitos del campo apellidos
      else if ( (jTextApellidos.getText().compareTo("") == 0) ||
               ! (jTextApellidos.getText().matches("[A-Za-z ������������]+")) ||
               (jTextApellidos.getText().length() > 30)) {
        EscribeError("Apellidos", "letras", "menor o igual a 30");
        jTextApellidos.grabFocus();
        jTextApellidos.selectAll();
      }

// Siguiente IF: Requisitos del campo domicilio
      else if ( (jTextFieldDomicilio.getText().compareTo("") == 0) ||
               ! (
               jTextFieldDomicilio.getText().matches("[A-Za-z ������������0-9]+")) ||
               (jTextFieldDomicilio.getText().length() > 40)) {
        EscribeError("Domicilio", "letras y n�meros", "menor o igual a 40");
        jTextFieldDomicilio.grabFocus();
        jTextFieldDomicilio.selectAll();
      }

// Siguiente IF: Requisitos del C�digo Postal
      else if ( (jTextFieldCP.getText().compareTo("") == 0) ||
               ! (jTextFieldCP.getText().matches("[0-9]+")) ||
               (jTextFieldCP.getText().length() != 5)) {
        EscribeError("C�digo Postal", "n�meros", "de 5 d�gitos");
        jTextFieldCP.grabFocus();
        jTextFieldCP.selectAll();
      }

// Siguiente IF: Requisitos de la Localidad
      else if ( (jTextFieldLocalidad.getText().compareTo("") == 0) ||
               ! (
               jTextFieldLocalidad.getText().matches("[a-zA-Z ���������U��]+")) ||
               (jTextFieldLocalidad.getText().length() > 20)) {
        EscribeError("Localidad", "letras", "menor o igual a 20");
        jTextFieldLocalidad.grabFocus();
        jTextFieldLocalidad.selectAll();
      }

// Siguiente IF: Requisitos de Telefono
      else if ( (jTextFieldTelefono.getText().compareTo("") == 0) ||
               ! (jTextFieldTelefono.getText().matches("[0-9]+")) ||
               (jTextFieldTelefono.getText().length() != 9)) {
        EscribeError("Telefono", "n�meros", "de 9 d�gitos");
        jTextFieldTelefono.grabFocus();
        jTextFieldTelefono.selectAll();
      }

// Siguiente IF: Requisitos de M�vil
      else if ( (jTextFieldMovil.getText().compareTo("") == 0) ||
               ! (jTextFieldMovil.getText().matches("[0-9]+")) ||
               (jTextFieldMovil.getText().length() != 9)) {
        EscribeError("M�vil", "n�meros", "de 9 d�gitos");
        jTextFieldMovil.grabFocus();
        jTextFieldMovil.selectAll();
      }

// Siguiente IF: Requisitos de Fax
      else if ( (jTextFieldFax.getText().compareTo("") == 0) ||
               ! (jTextFieldFax.getText().matches("[0-9]+")) ||
               (jTextFieldFax.getText().length() != 9)) {
        EscribeError("Fax", "n�meros", "de 9 d�gitos");
        jTextFieldFax.grabFocus();
        jTextFieldFax.selectAll();
      }

// Siguiente IF: Requisitos del mail
      else if ( (jTextFieldemail.getText().compareTo("") == 0) ||
               ! (jTextFieldemail.getText().matches("[0-9a-zA-Z@.]+")) ||
               (jTextFieldemail.getText().length() > 20)) {
        EscribeError("E-Mail", "letras, n�meros, @ y puntos",
                     "de 20 d�gitos o menos");
        jTextFieldemail.grabFocus();
        jTextFieldemail.selectAll();
      }

      /* Si no se ha producido ning�n if es que ha pasado por todos los campos. */
      else {
        // Mensaje que dice que los datos han sido correctos
        String mensaje = "Datos procesados correctamente";
        JOptionPane.showConfirmDialog(this, mensaje, "Correcto",
                                      JOptionPane.CLOSED_OPTION);
      }
    }//fin del else
  }
} // fin del jframe


class Marco1_jButtonBorrar_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_jButtonBorrar_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonBorrar_actionPerformed(e);
  }
}

class Marco1_jTextCodigo_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextCodigo_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextCodigo_keyPressed(e);
  }
}

class Marco1_jTextNIF_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextNIF_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextNIF_keyPressed(e);
  }
}

class Marco1_jTextNombre_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextNombre_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextNombre_keyPressed(e);
  }
}

class Marco1_jTextApellidos_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextApellidos_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextApellidos_keyPressed(e);
  }
}

class Marco1_jTextFieldDomicilio_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextFieldDomicilio_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldDomicilio_keyPressed(e);
  }
}

class Marco1_jTextFieldCP_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextFieldCP_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldCP_keyPressed(e);
  }
}

class Marco1_jTextFieldLocalidad_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextFieldLocalidad_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldLocalidad_keyPressed(e);
  }
}

class Marco1_jTextFieldTelefono_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextFieldTelefono_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldTelefono_keyPressed(e);
  }
}

class Marco1_jTextFieldMovil_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextFieldMovil_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldMovil_keyPressed(e);
  }
}

class Marco1_jTextFieldFax_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextFieldFax_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldFax_keyPressed(e);
  }
}

class Marco1_jTextFieldemail_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextFieldemail_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldemail_keyPressed(e);
  }
}

class Marco1_jTextFieldVentas_keyAdapter extends java.awt.event.KeyAdapter {
  Marco1 adaptee;

  Marco1_jTextFieldVentas_keyAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldVentas_keyPressed(e);
  }
}

class Marco1_jButtonAceptar_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_jButtonAceptar_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonAceptar_actionPerformed(e);
  }
}
