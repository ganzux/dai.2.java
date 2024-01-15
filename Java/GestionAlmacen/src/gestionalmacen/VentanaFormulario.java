package gestionalmacen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

/**
 * <p>T�tulo: Formulario de Prueba</p>
 * <p>Descripci�n: Un formulario para todos los datos del cliente</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Empresa: iToSofT</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.0 rc
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalizaci�n: 14 / XI / 2006
 */

public class VentanaFormulario extends JFrame {

////////////////////////////////////////////////////////////////////////////////
//////////////  Variables de Clase Y Objetos de la Ventana  ////////////////////
////////////////////////////////////////////////////////////////////////////////


  // Variable de clase utilizada para saber en qu� opci�n estamos:
  // 1: Altas, 2: Bajas, 3: Modificaciones, 4: Consultas por C�digo
  private int opcion=0;

  private JFrame padre;

  JPanel contentPane;
//////////////////////////////   Textos Y Cajas   //////////////////////////////
  JLabel jLabelCodigo = new JLabel();
  JTextField jTextCodigo = new JTextField();

  JLabel jLabelNIF = new JLabel();
  JTextField jTextNIF = new JTextField();
  JTextField jTextNIFLetra = new JTextField();

  JLabel jLabelNombre = new JLabel();
  JTextField jTextNombre = new JTextField();

  JLabel jLabelApellidos = new JLabel();
  JTextField jTextApellidos = new JTextField();

  JLabel jLabelDomicilio = new JLabel();
  JTextField jTextFieldDomicilio = new JTextField();

  JLabel jLabelCP = new JLabel();
  JTextField jTextFieldCP = new JTextField();

  JLabel jLabelLocalidad = new JLabel();
  JTextField jTextFieldLocalidad = new JTextField();

  JLabel jLabelTelefono = new JLabel();
  JTextField jTextFieldTelefono = new JTextField();

  JLabel jLabelMovil = new JLabel();
  JTextField jTextFieldMovil = new JTextField();

  JLabel jLabelFax = new JLabel();
  JTextField jTextFieldFax = new JTextField();

  JLabel jLabelemail = new JLabel();
  JTextField jTextFieldemail = new JTextField();

  JLabel jLabelVentas = new JLabel();
    JTextField jTextFieldVentas = new JTextField();
////////////////////////////   FIN Textos Y Cajas   ////////////////////////////

/////////////////////////////////   Botones   //////////////////////////////////
  JButton jButtonAceptar = new JButton();
  JButton jButtonCancelar = new JButton();
  JButton jButtonSalir = new JButton();
///////////////////////////////   Fin Botones   ////////////////////////////////

//////////////////////////////   Men� Superior   ///////////////////////////////
  JMenuBar jMenuBarMenu = new JMenuBar();

     JMenu jMenuMantenimiento = new JMenu();
        JMenuItem jMenuItemAltas = new JMenuItem();
        JMenuItem jMenuItemBajas = new JMenuItem();
        JMenuItem jMenuItemModificaciones = new JMenuItem();
        JMenuItem jMenuItemVolver = new JMenuItem();
     JMenu jMenuConsultas = new JMenu();

     JMenu jMenuPorImpresora = new JMenu();
        JMenuItem jMenuItemListadoPorCodigo = new JMenuItem();
        JMenuItem jMenuItemListadoPorApellidos = new JMenuItem();
     JMenuItem jMenuItemPorCodigo = new JMenuItem();
////////////////////////////   Fin Men� Superior   /////////////////////////////

////////////////////////////////////////////////////////////////////////////////
////////////  FIN Variables de Clase Y Objetos de la Ventana  //////////////////
////////////////////////////////////////////////////////////////////////////////

     //Inicializaci�n de componentes
     private void jbInit() throws Exception  {
       contentPane = (JPanel) this.getContentPane();
       contentPane.setLayout(null);
       this.setLocale(java.util.Locale.getDefault());
       this.setJMenuBar(jMenuBarMenu);
       this.setResizable(false);
       this.setSize(new Dimension(405, 430));
       this.setTitle("Mantenimiento de Clientes");

     // El siguiente C�digo cambia el Icono de la ventana :)
       ImageIcon miImagen = new ImageIcon("icono.gif");
       setIconImage(miImagen.getImage());

    /* Dise�amos el formulario: Por casa "campo" podr� 1 etiqueta de Texto y una
    caja de Texto; La caja de texto servir� para meter los datos, excepto en el
    NIF, que tendr� dos cajas, una de ellas inaccesible que generar� la letra. */

// Etiqueta C�digo
       jLabelCodigo.setText("C�digo");
       jLabelCodigo.setBounds(new Rectangle(1, 5, 43, 20));

// Caja C�digo
       jTextCodigo.setText("");
       jTextCodigo.setBounds(new Rectangle(1, 30, 75, 20));
       jTextCodigo.addKeyListener(new VentanaFormulario_jTextCodigo_keyAdapter(this));


// Etiqueta N.I.F.
       jLabelNIF.setText("N.I.F.");
       jLabelNIF.setBounds(new Rectangle(100, 5, 30, 20));

// Caja N.I.F. y caja de la letra del NIF
       jTextNIF.setText("");
       jTextNIF.setBounds(new Rectangle(100, 30, 100, 20));
       jTextNIF.addKeyListener(new VentanaFormulario_jTextNIF_keyAdapter(this));
       jTextNIFLetra.setEnabled(false);
       jTextNIFLetra.setOpaque(false);      // La Desactivamos
       jTextNIFLetra.setText("");
       jTextNIFLetra.setBounds(new Rectangle(200, 30, 20, 20));


// Etiqueta Nombre
       jLabelNombre.setText("Nombre");
       jLabelNombre.setBounds(new Rectangle(245, 5, 60, 20));

// Caja del Nombre
       jTextNombre.setText("");
       jTextNombre.setBounds(new Rectangle(245, 30, 150, 20));
       jTextNombre.addKeyListener(new VentanaFormulario_jTextNombre_keyAdapter(this));


// Etiqueta de los Apellidos
       jLabelApellidos.setText("Apellidos");
       jLabelApellidos.setBounds(new Rectangle(1, 55, 60, 20));

// Caja de los Apellidos
       jTextApellidos.setText("");
       jTextApellidos.setBounds(new Rectangle(1, 80, 395, 20));
       jTextApellidos.addKeyListener(new VentanaFormulario_jTextApellidos_keyAdapter(this));


// Etiqueta del Domicilio
       jLabelDomicilio.setText("Domicilio");
       jLabelDomicilio.setBounds(new Rectangle(1, 105, 100, 20));

// Caja del Domicilio
       jTextFieldDomicilio.setText("");
       jTextFieldDomicilio.setBounds(new Rectangle(1, 130, 395, 20));
       jTextFieldDomicilio.addKeyListener(new VentanaFormulario_jTextFieldDomicilio_keyAdapter(this));


// Etiqueta del C�digo Postal
       jLabelCP.setText("C�digo Postal");
       jLabelCP.setBounds(new Rectangle(1, 155, 90, 20));

// Caja del C�digo Postal
       jTextFieldCP.setText("");
       jTextFieldCP.setBounds(new Rectangle(1, 180, 80, 20));
       jTextFieldCP.addKeyListener(new VentanaFormulario_jTextFieldCP_keyAdapter(this));


// Etiqueta de la Localidad
       jLabelLocalidad.setText("Localidad");
       jLabelLocalidad.setBounds(new Rectangle(100, 155, 60, 20));

//Caja de la Localidad
       jTextFieldLocalidad.setText("");
       jTextFieldLocalidad.setBounds(new Rectangle(100, 180, 172, 20));
       jTextFieldLocalidad.addKeyListener(new VentanaFormulario_jTextFieldLocalidad_keyAdapter(this));


// Etiqueta del Tel�fono
       jLabelTelefono.setText("Tel�fono");
       jLabelTelefono.setBounds(new Rectangle(1, 205, 55, 20));

// Caja del Tel�fono
       jTextFieldTelefono.setText("");
       jTextFieldTelefono.setBounds(new Rectangle(1, 230, 80, 20));
       jTextFieldTelefono.addKeyListener(new VentanaFormulario_jTextFieldTelefono_keyAdapter(this));


// Etiqueta del M�vil
       jLabelMovil.setText("M�vil");
       jLabelMovil.setBounds(new Rectangle(110, 205, 113, 24));

// Caja del M�vil
       jTextFieldMovil.setText("");
       jTextFieldMovil.setBounds(new Rectangle(110, 230, 80, 20));
       jTextFieldMovil.addKeyListener(new VentanaFormulario_jTextFieldMovil_keyAdapter(this));


// Etiqueta del Fax
       jLabelFax.setText("Fax");
       jLabelFax.setBounds(new Rectangle(220, 205, 44, 20));

// Caja del Fax
       jTextFieldFax.setText("");
       jTextFieldFax.setBounds(new Rectangle(220, 230, 80, 20));
       jTextFieldFax.addKeyListener(new VentanaFormulario_jTextFieldFax_keyAdapter(this));


// Etiqueta del Mail
       jLabelemail.setText("e - mail");
       jLabelemail.setBounds(new Rectangle(1, 255, 116, 20));

// Caja del Mail
       jTextFieldemail.setText("");
       jTextFieldemail.setBounds(new Rectangle(2, 280, 188, 20));
       jTextFieldemail.addKeyListener(new VentanaFormulario_jTextFieldemail_keyAdapter(this));


// Etiqueta de las Ventas
       jLabelVentas.setText("Total Ventas");
       jLabelVentas.setBounds(new Rectangle(325, 255, 71, 20));

// Caja de las Ventas
       jTextFieldVentas.setEnabled(false);
    jTextFieldVentas.setText("");
       jTextFieldVentas.setBounds(new Rectangle(324, 280, 72, 20));
       jTextFieldVentas.addKeyListener(new VentanaFormulario_jTextFieldVentas_keyAdapter(this));


// A�adimos los objetos a la ventana
       jButtonAceptar.setBounds(new Rectangle(80, 325, 90, 35));
       jButtonAceptar.setMnemonic('A');
       jButtonAceptar.setText("Aceptar");
       jButtonAceptar.addActionListener(new VentanaFormulario_jButtonAceptar_actionAdapter(this));

       jButtonCancelar.setBounds(new Rectangle(190, 325, 90, 35));
       jButtonCancelar.setMnemonic('C');
       jButtonCancelar.setText("Cancelar");
       jButtonCancelar.addActionListener(new VentanaFormulario_jButtonCancelar_actionAdapter(this));

       jButtonSalir.setBounds(new Rectangle(300, 325, 90, 35));
       jButtonSalir.setMnemonic('S');
       jButtonSalir.setText("Salir");
       jButtonSalir.addActionListener(new VentanaFormulario_jButtonSalir_actionAdapter(this));


       jMenuMantenimiento.setMnemonic('M');
       jMenuMantenimiento.setText("Mantenimiento");

       jMenuItemAltas.setMnemonic('A');
       jMenuItemAltas.setText("Altas");
       jMenuItemAltas.addActionListener(new VentanaFormulario_jMenuItemAltas_actionAdapter(this));

       jMenuItemBajas.setMnemonic('B');
       jMenuItemBajas.setText("Bajas");
       jMenuItemBajas.addActionListener(new VentanaFormulario_jMenuItemBajas_actionAdapter(this));

       jMenuItemModificaciones.setMnemonic('M');
       jMenuItemModificaciones.setText("Modificaciones");
       jMenuItemModificaciones.addActionListener(new VentanaFormulario_jMenuItemModificaciones_actionAdapter(this));

       jMenuItemVolver.setMnemonic('V');
       jMenuItemVolver.setText("Volver");
       jMenuItemVolver.addActionListener(new VentanaFormulario_jMenuItemVolver_actionAdapter(this));

       jMenuConsultas.setMnemonic('C');
       jMenuConsultas.setText("Consultas");

       jMenuPorImpresora.setMnemonic('I');
       jMenuPorImpresora.setText("Por Impresora");

       jMenuItemListadoPorCodigo.setMnemonic('L');
       jMenuItemListadoPorCodigo.setText("Listado por C�digo");
       jMenuItemListadoPorCodigo.addActionListener(new VentanaFormulario_jMenuItemListadoPorCodigo_actionAdapter(this));

       jMenuItemListadoPorApellidos.setMnemonic('I');
       jMenuItemListadoPorApellidos.setText("Listado por Apellidos");
       jMenuItemListadoPorApellidos.addActionListener(new VentanaFormulario_jMenuItemListadoPorApellidos_actionAdapter(this));

       jMenuItemPorCodigo.setMnemonic('P');
       jMenuItemPorCodigo.setText("Por C�digo");
       jMenuItemPorCodigo.addActionListener(new VentanaFormulario_jMenuItemPorCodigo_actionAdapter(this));

                 /*/////////////\\\\\\\\\\\\\\
                 \\\\\\\\\\\\\\\////////////*/

       contentPane.add(jLabelCodigo, null);
       contentPane.add(jTextCodigo, null);

       contentPane.add(jLabelNIF, null);
       contentPane.add(jTextNIF, null);
       contentPane.add(jTextNIFLetra, null);

       contentPane.add(jLabelNombre, null);
       contentPane.add(jTextNombre, null);

       contentPane.add(jLabelApellidos, null);
       contentPane.add(jTextApellidos, null);

       contentPane.add(jLabelDomicilio, null);
       contentPane.add(jTextFieldDomicilio, null);

       contentPane.add(jLabelCP, null);
       contentPane.add(jTextFieldCP, null);

       contentPane.add(jLabelLocalidad, null);
       contentPane.add(jTextFieldLocalidad, null);

       contentPane.add(jLabelMovil, null);
       contentPane.add(jTextFieldMovil, null);

       contentPane.add(jLabelFax, null);
       contentPane.add(jTextFieldFax, null);

       contentPane.add(jLabelTelefono, null);
       contentPane.add(jTextFieldTelefono, null);

       contentPane.add(jLabelemail, null);
       contentPane.add(jTextFieldemail, null);

       contentPane.add(jLabelVentas, null);
       contentPane.add(jTextFieldVentas, null);

       contentPane.add(jButtonAceptar, null);
       contentPane.add(jButtonSalir, null);
       contentPane.add(jButtonCancelar, null);

       jMenuBarMenu.add(jMenuMantenimiento);
       jMenuBarMenu.add(jMenuConsultas);

       jMenuMantenimiento.add(jMenuItemAltas);
       jMenuMantenimiento.add(jMenuItemBajas);
       jMenuMantenimiento.add(jMenuItemModificaciones);
       jMenuMantenimiento.addSeparator();
       jMenuMantenimiento.add(jMenuItemVolver);

       jMenuConsultas.add(jMenuPorImpresora);
       jMenuConsultas.add(jMenuItemPorCodigo);
       jMenuPorImpresora.add(jMenuItemListadoPorCodigo);
       jMenuPorImpresora.add(jMenuItemListadoPorApellidos);

       DesHabilitaFormulario(false);
     }// Fin de la inicializaci�n de los componentes



////////////////////////////////////////////////////////////////////////////////
////////////////////////   M�todos de la Clase   ///////////////////////////////
////////////////////////////////////////////////////////////////////////////////

  //Constructor por defecto
  public VentanaFormulario(JFrame padre) {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      this.padre=padre;
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }//Fin del Constructor


  //Modificado para NO poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    /*super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }*/
  }

/*            COMENTARIOS Y RESUMEN DE LOS M�TODOS UTILIZADOS


1.  private void DesHabilitaFormulario(boolean opcion)
    M�todo que deshabilita o habilita el formulario juntos con los botones Aceptar, Cancelar y Salir

2.  private void BorrarFormulario()
    M�todo que borra todo el formulario

3.  private void EscribeMensaje(String cadena1, String cadena2)
    M�todo privado que recibe 2 cadenas de texto y genera una ventana de error comprensible para el usuario

4.  private int MensajeSiNo(String cadena1, String cadena2)
    M�todo privado que recibe 2 cadenas de texto y genera una ventana con las opciones SI y NO,
    devolviendo 0 si responde afirmativamente.

5.  private void EscribeError(String cadena1, String cadena2, String cadena3)
    Heredado de una versi�n anterior del Soft, �ste m�todo privado recibe varias cadenas de texto y
    genera una ventana de error comprensible para el usuario que es utilizada �nicamente al validar
    los campos, ya que todos los mensajes son del tipo "El campo XXXX es obligatorio, s�lo puede
    contener XXXXXX y su longitud m�xima es de XXXXX caracteres."

6.  private String Rellena(String cadena,int numerodeceros)
    El m�todo recibe una cadena y un n�mero, completando la cadena hasta ese n�mero de cifras
    con ceros  por la izquierda

7.  private String GeneraLetra(String DNI)
    El m�todo devuelve la letra en forma String de un D.N.I. facilitado

8.  private Cliente RecuperaDatos()
    M�todo que recupera los valores de la ventana y devuelve un objeto de clase Cliente

9.  private void MuestraCliente(String code)
    M�todo que recibe un entero, se conecta a la base de datos, busca ese codigo
    y muestra su configuraci�n en el formulario

10. private boolean ValidarDatos()
    El M�todo ValidarDatos "mira" todos los datos del formulario, devolviedno
    true si son correctos o false si hay alg�n error y mandando el foco al error

11. private void ConfiguraFormulario(int opcion,String titulo,String boton,char memoria)
    Dado que en todas las opciones repetimos el mismo proceso una y otra vez, he
    creado un m�todo que, pas�ndole los valores adecuados, simplifica dicha tarea.
    Las tareas que realizar� son:
    a) Dar el valor a la variable de clase 'opcion' con el valor opcion
    b) Deshabilitar los men�s de arriba (Mantenimiento y Consultas)
    c) Renombrar la Ventana con la cadena 'titulo'
    d) Deshabilitas todos los men�s y los dejamos en blanco
    e) Habilita la caja C�digo y le pasamos el foco
    f) Cambiam el T�tulo del bot�n aceptar a la variable boton, y le damos acceso directo, activando el bot�n

 */


  // M�todo que deshabilita o habilita el formulario
  private void DesHabilitaFormulario(boolean opcion){
    // Primero Des/Habilitamos los campos editables
    jTextCodigo.setEditable(opcion);
    jTextNIF.setEditable(opcion);
    jTextNombre.setEditable(opcion);
    jTextApellidos.setEditable(opcion);
    jTextFieldDomicilio.setEditable(opcion);
    jTextFieldCP.setEditable(opcion);
    jTextFieldLocalidad.setEditable(opcion);
    jTextFieldTelefono.setEditable(opcion);
    jTextFieldMovil.setEditable(opcion);
    jTextFieldFax.setEditable(opcion);
    jTextFieldemail.setEditable(opcion);
    // El campo Ventas siempre deshabilitado
    jTextFieldVentas.setEditable(false);
    // Y despu�s los botones
    jButtonAceptar.setEnabled(opcion);
    jButtonCancelar.setEnabled(opcion);
    jButtonSalir.setEnabled(opcion);
    }// Fin de DesHabilitaFormulario()


  // M�todo que borra todo el formulario
  private void BorrarFormulario(){
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
  }// BorrarFormulario


  // M�todo privado que recibe 2 cadenas de texto y genera una ventana de
  // error comprensible para el usuario
  private void EscribeMensaje(String cadena1, String cadena2){
    // Genramos la pantalla
    JOptionPane.showConfirmDialog(this, cadena2, cadena1,
                                  JOptionPane.CLOSED_OPTION);
  }//Fin de EscribeMensaje


// M�todo privado que recibe 2 cadenas de texto y genera una ventana con las opciones
// SI y NO, devolviendo 0 si responde afirmativamente.
  private int MensajeSiNo(String cadena1, String cadena2){

    // Genramos la pantalla y la devolvemos
    return JOptionPane.showConfirmDialog(this, cadena2, cadena1,
                                         JOptionPane.YES_NO_OPTION);
  }//Fin de MensajeSiNo


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


  /*El siguiente m�todo recibe una cadena y un n�mero, y completa la cadena
   hasta ese n�mero de cifras rellen�ndolo por la izquierda  */
  private String Rellena(String cadena,int numerodeceros){
    while (cadena.length() < numerodeceros)
      cadena="0"+cadena;     // Concatenaci�n ;)
    return cadena;
  }


  // El siguiente m�todo devuelve la letra en forma String de un NIF facilitado
  private String GeneraLetra(String DNI){

  //Rellenamos con ceros a la izquierda hasta 8 d�gitos:
  DNI=Rellena(DNI,8);

  // En la variable resto metemos el resto de la divisi�n entera del NIF entre 23
  int resto = Integer.parseInt(jTextNIF.getText()) % 23;

  // Declaramos una variable con las letras del DNI ordenadas seg�n el resto
  String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

  // Escribimos la letra en la casilla deshabilitada
  String letrareal = letras.charAt(resto) + "";

  return letrareal;
  }// fin del generaLetra


  // M�todo que recupera los valores de la ventana y devuelve un Cliente
  private Cliente RecuperaDatos(){

    Cliente cliente = new Cliente();

    cliente.setApellidos(jTextApellidos.getText());
    cliente.setCodigo(jTextCodigo.getText());
    cliente.setCp(jTextFieldCP.getText());
    cliente.setDomicilio(jTextFieldDomicilio.getText());
    cliente.setEmail(jTextFieldemail.getText());
    cliente.setFax(jTextFieldFax.getText());
    cliente.setLocalidad(jTextFieldLocalidad.getText());
    cliente.setMovil(jTextFieldMovil.getText());
    cliente.setTelefono(jTextFieldTelefono.getText());
    cliente.setNif(jTextNIF.getText());
    cliente.setNombre(jTextNombre.getText());

    return cliente;
  }//Fin de RecuperaDatos


  // M�todo que recibe un entero, se conecta a la base de datos, busca ese codigo
  // y muestra su configuraci�n en el formulario
  private void MuestraCliente(String code){
    // Buscamos en la base de datos ese c�digo
    GestorBD conexion = new GestorBD();
    MuestraCliente(conexion.BuscarCliente(code));
  }// Fin de MuestraConfiguracion


  private void MuestraCliente(Cliente cliente){
    jTextApellidos.setText(cliente.getApellidos());
    jTextFieldCP.setText(cliente.getCp());
    jTextFieldDomicilio.setText(cliente.getDomicilio());
    jTextFieldemail.setText(cliente.getEmail());
    jTextFieldFax.setText(cliente.getFax());
    jTextFieldLocalidad.setText(cliente.getLocalidad());
    jTextFieldMovil.setText(cliente.getMovil());
    jTextFieldTelefono.setText(cliente.getTelefono());
    jTextNIF.setText(cliente.getNif());
    jTextNombre.setText(cliente.getNombre());
    jTextFieldVentas.setText(String.valueOf(cliente.getVentas()));

    jTextNIFLetra.setText(GeneraLetra(cliente.getNif()));
  }//MuestraCliente


  // El M�todo ValidarDatos "mira" todos los datos del formulario, devolviedno
  // true si son correctos o false si hay alg�n error y mandando el foco al error
  private boolean ValidarDatos(){

    // Supondremos en principio que los datos son correctos
    boolean testigo =true;

    // Empezaremos validando el DNI:
    // Si la cadena son letras o m�s de ocho n�meros
    if(!jTextNIF.getText().matches("[0-9]+") || jTextNIF.getText().length()>8){
      // Error con mi funci�n y el foco al error
      EscribeError("NIF", "n�meros", "de ocho cifras");
      jTextNIF.grabFocus();
      jTextNIF.selectAll();
      testigo=false; // Se ha generado un Error
    }//if

    // En caso de no haber problemas con el DNI:
    else {
      // Llamamos a la funci�n que genera la letra del NIF y la escribimos
      jTextNIFLetra.setText(GeneraLetra(jTextNIF.getText()));

      // deshabilitamos el campo
      jTextNIF.setEditable(false);

      // Segundo IF: Que el campo Nombre cumpla los requisitos
      if ( (jTextNombre.getText().compareTo("") == 0) ||
          ! (jTextNombre.getText().matches("[A-Za-z ������������]+")) ||
          (jTextNombre.getText().length() > 15)) {
        EscribeError("Nombre", "letras", "menor o igual a 16");
        jTextNombre.grabFocus();
        jTextNombre.selectAll();
        testigo = false; // Se ha generado un Error
      }

      // Siguiente IF: Requisitos del campo apellidos
      else if ( (jTextApellidos.getText().compareTo("") == 0) ||
               ! (jTextApellidos.getText().matches("[A-Za-z ������������]+")) ||
               (jTextApellidos.getText().length() > 30)) {
        EscribeError("Apellidos", "letras", "menor o igual a 30");
        jTextApellidos.grabFocus();
        jTextApellidos.selectAll();
        testigo = false; // Se ha generado un Error
      }

      // Siguiente IF: Requisitos del campo domicilio
      else if ( (jTextFieldDomicilio.getText().compareTo("") == 0) ||
               ! (jTextFieldDomicilio.getText().matches(
          "[A-Za-z ������������0-9]+")) ||
               (jTextFieldDomicilio.getText().length() > 40)) {
        EscribeError("Domicilio", "letras y n�meros", "menor o igual a 40");
        jTextFieldDomicilio.grabFocus();
        jTextFieldDomicilio.selectAll();
        testigo = false; // Se ha generado un Error
      }

      // Siguiente IF: Requisitos del C�digo Postal
      else if ( (jTextFieldCP.getText().compareTo("") == 0) ||
               ! (jTextFieldCP.getText().matches("[0-9]+")) ||
               (jTextFieldCP.getText().length() != 5)) {
        EscribeError("C�digo Postal", "n�meros", "de 5 d�gitos");
        jTextFieldCP.grabFocus();
        jTextFieldCP.selectAll();
        testigo = false; // Se ha generado un Error
      }

      // Siguiente IF: Requisitos de la Localidad
      else if ( (jTextFieldLocalidad.getText().compareTo("") == 0) ||
               ! (
          jTextFieldLocalidad.getText().matches("[a-zA-Z ���������U��]+")) ||
               (jTextFieldLocalidad.getText().length() > 20)) {
        EscribeError("Localidad", "letras", "menor o igual a 20");
        jTextFieldLocalidad.grabFocus();
        jTextFieldLocalidad.selectAll();
        testigo = false; // Se ha generado un Error
      }

// Los siguientes requisitos s�lo se dan si est�n escritos los campos; o sea,
// los tel�fonos de 9 d�gitos y el mail

      // Siguiente IF: Requisitos del telefono, S�LO SI EST� ESCRITO
      else if ( (jTextFieldTelefono.getText().compareTo("") != 0) &&
              ( (jTextFieldTelefono.getText().length() != 9) ||
                !jTextFieldTelefono.getText().matches("[0-9]+"))) {
        EscribeError("Tel�fono No ", "d�gitos", "de 9 d�gitos");
        jTextFieldTelefono.grabFocus();
        jTextFieldTelefono.selectAll();
        testigo = false; // Se ha generado un Error
      }//fin de los requisitos del tel�fono

      // Siguiente IF: Requisitos del m�vil, S�LO SI EST� ESCRITO
      else if ( (jTextFieldMovil.getText().compareTo("") != 0) &&
                ( (jTextFieldMovil.getText().length() != 9) ||
                !jTextFieldMovil.getText().matches("[0-9]+"))) {
        EscribeError("M�vil No ", "d�gitos", "de 9 d�gitos");
        jTextFieldMovil.grabFocus();
        jTextFieldMovil.selectAll();
        testigo = false; // Se ha generado un Error
      }//fin de los requisitos del movil

      // Siguiente IF: Requisitos del Fax, S�LO SI EST� ESCRITO
      else if ( (jTextFieldFax.getText().compareTo("") != 0) &&
                ( (jTextFieldFax.getText().length() != 9) ||
                !jTextFieldFax.getText().matches("[0-9]+"))) {
        EscribeError("Fax No ", "d�gitos", "de 9 d�gitos");
        jTextFieldFax.grabFocus();
        jTextFieldFax.selectAll();
        testigo = false; // Se ha generado un Error
      }//fin de los requisitos del tel�fono


      // Siguiente IF: Requisitos del e-mail, S�LO SI EST� ESCRITO
      else if ( (jTextFieldemail.getText().compareTo("") != 0) &&
               (jTextFieldemail.getText().length() > 20)) {
        EscribeError("E-Mail no", "@, n�meros y letras", "de 20 d�gitos");
        jTextFieldemail.grabFocus();
        jTextFieldemail.selectAll();
        testigo = false; // Se ha generado un Error}

      }//fin de los requisitos del mail

    }//fin del else

  /* Si no se ha producido ning�n if es que ha pasado por todos los campos. */

  return testigo;
}// Fin de ValidarDatos


/* Dado que en todas las opciones repetimos el mismo proceso una y otra vez, he
   creado un m�todo que, pas�ndole los valores adecuados, simplifica dicha tarea*/
  private void ConfiguraFormulario(int opcion,String titulo,String boton,char memoria){

    // Damos el valor a la variable de clase 'opcion'
    this.opcion=opcion;

    // Deshabilitamos los men�s de arriba y el boton Aceptar
    jMenuConsultas.setEnabled(false);
    jMenuMantenimiento.setEnabled(false);
    jButtonAceptar.setEnabled(false);

    // Renombramos la Ventana
    this.setTitle("Mantenimiento de Clientes -- "+titulo);

    // Deshabilitamos todos los men�s y los dejamos en blanco
    DesHabilitaFormulario(false);
    BorrarFormulario();
    // Habilitamos la caja C�digo
    jTextCodigo.setEditable(true);
    // Y le pasamos el foco
    jTextCodigo.grabFocus();

    // Cambiamos el T�tulo del bot�n aceptar a la variable boton, y le damos acceso directo
    jButtonAceptar.setText(boton);
    jButtonAceptar.setMnemonic(memoria);

    // Y activamos el bot�n Salir
    jButtonSalir.setEnabled(true);
  }// Fin de OpcionElegida


////////////////////////////////////////////////////////////////////////////////
//////////////////////   FIN M�todos de la Clase   /////////////////////////////
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
/////////////////////   ACCIONES EN EL FORMULARIO   ////////////////////////////
////////////////////////////////////////////////////////////////////////////////


////////////////////          INTROS EN LAS CAJAS          /////////////////////

// CODIGO: En �ste caso tambi�n comprueba que sea un n�mero lo que introducimos
// de menos de 7 cifras, rellen�ndolo con ceros por la izquierda si fuere necesario
  void jTextCodigo_keyPressed(KeyEvent e) {

    // Si presiona Intro y est� en Altas, bajas, modificaciones o consultas:
    if (e.getKeyCode()==10 && opcion!=0){

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
          jTextCodigo.setText(Rellena(jTextCodigo.getText(),6));
          String code = jTextCodigo.getText();

          // Buscamos en la base de datos ese c�digo
          GestorBD conexion = new GestorBD();

          // Seg�n la opci�n escogida, buscamos el C�digo
          switch(opcion){

            // En caso de que la opci�n sea Altas
            case 1:
              // Si ese c�digo no existe
              if (conexion.BuscarCliente(code).getCodigo() == null){
                //Activamos el resto de opciones
                DesHabilitaFormulario(true);
                // bloqueamos el codigo y el Ventas
                jTextCodigo.setEditable(false);
                jTextNIF.grabFocus(); // y mandamos el cursor a la siguiente celda
              }//fin deque no exista el c�digo

              // Sin embargo, si existe el c�digo, damos el Error
              else{
                EscribeMensaje("Error","Ese c�digo ya existe, por lo que no puede introducirlo de nuevo"+
                               "\n\nSi desea modificarlo, salga del men� y pulse Modificaciones");
                jTextCodigo.setEditable(true);
                jTextCodigo.grabFocus();
                jTextCodigo.selectAll();
              }//fin de que exista el c�digo

            break;

            // En caso de que sea Bajas o Modificaciones
            case 2:
            case 3:
              /* Si el C�digo NO Existe, mensaje de error */
              if (conexion.BuscarCliente(code).getCodigo() == null){
                EscribeMensaje("Error","Ese c�digo no existe, por lo que no puede modificarlo o borrarlo"+
                               "\n\nSi desea a�adirlo, salga del men� y pulse A�adir");
                jTextCodigo.setEditable(true);
                jTextCodigo.grabFocus();
                jTextCodigo.selectAll();
              }//Fin de que No exista el c�digo

              else{// Sin embargo, si el c�digo S� que existe
                if (opcion==2){
                  // Deshabilitamos el formulario
                  DesHabilitaFormulario(false);
                  // Mostramos la configuraci�n
                  MuestraCliente(jTextCodigo.getText());
                  // Habilitamos los botones Aceptar (con foco) y Cancelar
                  jButtonAceptar.setEnabled(true);
                  jButtonAceptar.grabFocus();
                  jButtonCancelar.setEnabled(true);
                }// Opcion es 2, bajas

                else{// Opcion es 3
                  // Habilitamos el formulario
                  DesHabilitaFormulario(true);
                  // Mostramos la configuraci�n
                  MuestraCliente(jTextCodigo.getText());
                  // Habilitamos los botones Aceptar y Cancelar
                  jButtonAceptar.setEnabled(true);
                  jButtonCancelar.setEnabled(true);
                  // Deshabilitamos Cosigo y pasamos el foco al nombre
                  jTextCodigo.setEditable(false);
                  jTextNIF.grabFocus();
                }// Opcion es 3, modificaciones
                jButtonSalir.setEnabled(true);
              }// El C�digo S� existe
            break;

          // Mostrar
          case 4:
            /* Si el C�digo Existe, muestralo */
            if (conexion.BuscarCliente(code).getCodigo() != null){
              MuestraCliente(jTextCodigo.getText());
              jTextCodigo.setEditable(false);
              jButtonAceptar.grabFocus();
              jButtonAceptar.setEnabled(true);
            }//Fin de que No exista el c�digo

              else{// Sin embargo, si el c�digo NO existe, error
                EscribeMensaje("Error","Ese c�digo no existe"+
                               "\nRevise la Sintaxis");
                jTextCodigo.setEditable(true);
                jTextCodigo.grabFocus();
                jTextCodigo.selectAll();

              }// El C�digo S� existe

            break;
         }//SWITCH
        }// else (la cadena es num�rica)
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
      jButtonAceptar.grabFocus();
  }


// Ventas: �ste caso se manda al bot�n ACEPTAR
  void jTextFieldVentas_keyPressed(KeyEvent e) {
    if (e.getKeyCode()==10)
      jButtonAceptar.grabFocus();
  }

////////////////////        FIN INTROS EN LAS CAJAS         ////////////////////


///////////////////         ACCIONES DE LOS BOTONES         ////////////////////

// Codificaci�n del Evento ACTIONPERFORMED del bot�n ENTER
  void jButtonAceptar_actionPerformed(ActionEvent e) {

    // Miramos el valor de la variable global 'opcion'
    switch(opcion){

      // Altas
      case 1:
        // Si los datos son correctos
        if (ValidarDatos()){
          // Buscamos en la base de datos ese c�digo
          GestorBD conexion = new GestorBD();

          // Si al lanzar AnadirCliente devuelve true (operaci�n correcta)
          if (conexion.AnadirCliente(RecuperaDatos())){
            // Mensaje de OK
            EscribeMensaje("Correcto","Los datos se han almacenado con �xito");
            // Volvemos al inicio de Altas
            BorrarFormulario();
            DesHabilitaFormulario(false);
            jTextCodigo.setEditable(true);
            }
          // Sin embargo, si la respuesta es false
          else
            EscribeMensaje("Error","Ha ocurrido un error al grabar el fichero\nConsulte con el administrador");
        jButtonSalir.setEnabled(true);
        }
      break;
      // Fin de las altas

      // Bajas
      case 2:

        int aseguradora = MensajeSiNo("� Est� segur@ ?","Los Datos se van a Eliminar.\nEsta operaci�n no tiene vuelta atr�s.\n�Est� seguro?");

        if (aseguradora==0){
          // Borra los datos
          GestorBD conexion = new GestorBD();
          if (conexion.BorrarCliente(RecuperaDatos())){
            // Mensaje de OK
            EscribeMensaje("Correcto","Los datos se han borrado con �xito");
            // Volvemos al inicio de Altas
            BorrarFormulario();
            DesHabilitaFormulario(false);
            jTextCodigo.setEditable(true);
          }
          jButtonSalir.setEnabled(true);
        }
        // Si elije NO, seguimos igual.
      break;
      // Fin d las bajas

    // Modificaciones
    case 3:
      // Si los datos son correctos
      if (ValidarDatos()){
        // Conexi�n a la BBDD
        GestorBD conexion = new GestorBD();

        /* A la hora de modificar un cliente ten�amos dos alternativas: O bien utilizamos
           un m�todo (programado) UPDATE ( ModificaCliente(Cliente) ), o bien damos de
           baja al cliente y le volvemos a dar de alta.

           Aunque creo qur se tarda menos en hacer el UPDATE, he decidido dar de baja y
           luego dar de alta porque el a�o pasado ( I D.A.I. ) en Sistemas, en el programa
           en Linux, Coralio sugiri� que lo hici�semos as�.

           No obstante, dejo aqu� comentada la l�nea del UPDATE:

           conexion.ModificaCliente(RecuperaDatos());

         */

        // Borra los datos de la BBDD
        conexion.BorrarCliente(RecuperaDatos());
        // Guardamos los nuevos datos con el codigo antiguo
        conexion.AnadirCliente(RecuperaDatos());
        // Mensaje de OK
        EscribeMensaje("Correcto", "Los datos se han modificado con �xito");
        // Volvemos al inicio de Modificaciones
        BorrarFormulario();
        DesHabilitaFormulario(false);
        jTextCodigo.setEditable(true);
      }
      jButtonSalir.setEnabled(true);
    break;
    // Fin d las modificaciones


    // Consultas
    case 4:
      // Borramos el formulario
      BorrarFormulario();
      // Y llevamos el foco al campo C�digo, habilit�ndolo
      jTextCodigo.setEditable(true);
      jTextCodigo.grabFocus();
      jButtonSalir.setEnabled(true);
    break;
    // Fin de las Consultas

    }//switch

    // Desactivamos todos los campos, ponemos los valores a cero y nos quedamos en la opci�n
  }// Bot�n ACEPTAR


  // Bot�n VOLVER
  void jMenuItemVolver_actionPerformed(ActionEvent e) {
    padre.setEnabled(true);
    this.dispose();
  }// Bot�n Volver


// Acciones del Bot�n Cancelar
  void jButtonCancelar_actionPerformed(ActionEvent e) {

    int aseguradora=1;
    // Comprobamos que no haya datos, o sea, que el campo CODIGO no tenga nada
    if (jTextCodigo.getText().compareTo("")!=0)
      // Nos aseguraremos de si desea cancelar los datos o no
      aseguradora = MensajeSiNo("� Atenci�n !","Hay datos en el formulario\n"+
                                     "�Est� segur@ de que desea cancelarlos?");

    // Si ha decidido cancelarlos
    if (aseguradora==0){
      // borra todos los campos, los desactiva y activa el codigo
      DesHabilitaFormulario(false);
      BorrarFormulario();
      // Activa el campos C�digo
      jTextCodigo.setEditable(true);
      // Y manda el cursor a C�digo
      jTextCodigo.grabFocus();
    }// fin de cuando ha decidido cancelar los datos

    // Como estamos dentro de una opci�n (Codigo habilitado), activamos Salir
    jButtonSalir.setEnabled(true);

  }// Bot�n cancelar


  // Bot�n Salir
  void jButtonSalir_actionPerformed(ActionEvent e) {

      // Salimos de las opciones
      opcion = 0;
      // Activamos el Men� Mantenimiento y Consultas
      jMenuMantenimiento.setEnabled(true);
      jMenuConsultas.setEnabled(true);

      // restauramos el bot�n Aceptar
      jButtonAceptar.setText("Aceptar");
      jButtonAceptar.setMnemonic('A');

      // Ponemos el t�tulo a la ventana
      this.setTitle("Mantenimiento de Clientes");

      // Inhabilitamos todo el formulario
      DesHabilitaFormulario(false);

      // Y lo borramos
      BorrarFormulario();

  }// Bot�n Salir

///////////////////       FIN ACCIONES DE LOS BOTONES        ///////////////////


////////////////////     ACCIONES DE LA BARRA DE MEN�      /////////////////////

  // ALTAS
  void jMenuItemAltas_actionPerformed(ActionEvent e) {
    ConfiguraFormulario(1,"Altas","Guardar",'G');
  }// ALTAS

  // BAJAS
  void jMenuItemBajas_actionPerformed(ActionEvent e) {
    ConfiguraFormulario(2,"Bajas","Borrar",'B');
  }// BAJAS

  // MODIFICACIONES
  void jMenuItemModificaciones_actionPerformed(ActionEvent e) {
    ConfiguraFormulario(3,"Modificaciones","Editar",'E');
  }// MODIFICACIONES

  // Consultas
  void jMenuItemPorCodigo_actionPerformed(ActionEvent e) {
    ConfiguraFormulario(4,"Consultas","Nueva",'N');
  }

  // Listados por C�digo
  void jMenuItemListadoPorCodigo_actionPerformed(ActionEvent e) {
   new Imprimir("codigo",MensajeSiNo("Opciones de impresi�n","�Desea Usted Imprimir con cuadr�cula?"));
}

  void jMenuItemListadoPorApellidos_actionPerformed(ActionEvent e) {
    new Imprimir("apellidos",MensajeSiNo("Opciones de impresi�n","�Desea Usted Imprimir con cuadr�cula?"));
  }///// Listado por C�digo

///////////////////    FIN ACCIONES DE LA BARRA DE MEN�      ///////////////////

} // fin del jframe


////////////////////////////////////////////////////////////////////////////////
//////////////////////                                 /////////////////////////
//////////////////////  R E S T O  D E L  C � D I G O  /////////////////////////
//////////////////////                                 /////////////////////////
////////////////////////////////////////////////////////////////////////////////

class VentanaFormulario_jButtonCancelar_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jButtonCancelar_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonCancelar_actionPerformed(e);
  }
}

class VentanaFormulario_jTextCodigo_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextCodigo_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextCodigo_keyPressed(e);
  }
}

class VentanaFormulario_jTextNIF_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextNIF_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextNIF_keyPressed(e);
  }
}

class VentanaFormulario_jTextNombre_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextNombre_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextNombre_keyPressed(e);
  }
}

class VentanaFormulario_jTextApellidos_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextApellidos_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextApellidos_keyPressed(e);
  }
}

class VentanaFormulario_jTextFieldDomicilio_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextFieldDomicilio_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldDomicilio_keyPressed(e);
  }
}

class VentanaFormulario_jTextFieldCP_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextFieldCP_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldCP_keyPressed(e);
  }
}

class VentanaFormulario_jTextFieldLocalidad_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextFieldLocalidad_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldLocalidad_keyPressed(e);
  }
}

class VentanaFormulario_jTextFieldTelefono_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextFieldTelefono_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldTelefono_keyPressed(e);
  }
}

class VentanaFormulario_jTextFieldMovil_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextFieldMovil_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldMovil_keyPressed(e);
  }
}

class VentanaFormulario_jTextFieldFax_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextFieldFax_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldFax_keyPressed(e);
  }
}

class VentanaFormulario_jTextFieldemail_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextFieldemail_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldemail_keyPressed(e);
  }
}

class VentanaFormulario_jTextFieldVentas_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaFormulario adaptee;

  VentanaFormulario_jTextFieldVentas_keyAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldVentas_keyPressed(e);
  }
}

class VentanaFormulario_jButtonAceptar_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jButtonAceptar_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonAceptar_actionPerformed(e);
  }
}

class VentanaFormulario_jMenuItemVolver_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jMenuItemVolver_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemVolver_actionPerformed(e);
  }
}

class VentanaFormulario_jMenuItemAltas_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jMenuItemAltas_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemAltas_actionPerformed(e);
  }
}

class VentanaFormulario_jButtonSalir_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jButtonSalir_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonSalir_actionPerformed(e);
  }
}

class VentanaFormulario_jMenuItemBajas_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jMenuItemBajas_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemBajas_actionPerformed(e);
  }
}

class VentanaFormulario_jMenuItemModificaciones_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jMenuItemModificaciones_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemModificaciones_actionPerformed(e);
  }
}

class VentanaFormulario_jMenuItemPorCodigo_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jMenuItemPorCodigo_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemPorCodigo_actionPerformed(e);
  }
}

class VentanaFormulario_jMenuItemListadoPorCodigo_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jMenuItemListadoPorCodigo_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemListadoPorCodigo_actionPerformed(e);
  }
}

class VentanaFormulario_jMenuItemListadoPorApellidos_actionAdapter implements java.awt.event.ActionListener {
  VentanaFormulario adaptee;

  VentanaFormulario_jMenuItemListadoPorApellidos_actionAdapter(VentanaFormulario adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemListadoPorApellidos_actionPerformed(e);
  }
}
