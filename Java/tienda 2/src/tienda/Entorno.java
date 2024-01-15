// Paquete tienda
package tienda;

// Importamos las distintas clases
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;          // Uso de Vectores
import java.io.*;                 // Ficherillos


/**
 * <p>T�tulo: Tienda de ordenadores</p>
 * <p>Descripci�n: <Peque�o proyrecto para la gesti�n de una tienda de ordenadores/p>
 * <p>Copyright: CopyLeft (c) 2006</p>
 * <p>Empresa: iTo Soft</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.2
 * <p>Inicio: 23 / X / 2006</p>
 * <p>Fin: 23 / X / 2006</p>
 */

// Iniciamos la clase Entorno
public class Entorno extends JFrame {
  JPanel contentPane;

////////////////////////////////////////////////////////////////////////////////
///////////////////////  VARIABLES DE CLASE Y OBJETOS   ////////////////////////
////////////////////////////////////////////////////////////////////////////////

  // Vector para almacenar los datos, variable DE CLASE
  Vector clientes = new Vector();
  // Vector para almacenar los nombres, variable DE CLASE
  Vector nombres  = new Vector();

  // Nombre
  JLabel jLabelnombre = new JLabel();
  JTextField jTextFieldnombrecliente = new JTextField();

  // Localidad
  JLabel jLabellocalidad = new JLabel();
  JComboBox jComboBoxlocalidad = new JComboBox();

  // Lista
  JLabel jLabellista = new JLabel();
  JScrollPane jScrollPanelista = new JScrollPane();
  JList jListlista = new JList();

  // Procesador
  JLabel jLabelprocesador = new JLabel();
  ButtonGroup buttonGroupprocesador = new ButtonGroup();
  JRadioButton jRadioButtonprocesador1 = new JRadioButton();
  JRadioButton jRadioButtonprocesador2 = new JRadioButton();
  JRadioButton jRadioButtonprocesador3 = new JRadioButton();
  JRadioButton jRadioButtonprocesador4 = new JRadioButton();

  // Memoria
  JLabel jLabelmemoria = new JLabel();
  ButtonGroup buttonGroupmemoria = new ButtonGroup();
  JRadioButton jRadioButtonmemoria1 = new JRadioButton();
  JRadioButton jRadioButtonmemoria2 = new JRadioButton();
  JRadioButton jRadioButtonmemoria3 = new JRadioButton();
  JRadioButton jRadioButtonmemoria4 = new JRadioButton();

  // Monitor
  JLabel jLabelmonitor = new JLabel();
  ButtonGroup buttonGroupmonitor = new ButtonGroup();
  JRadioButton jRadioButtonmonitor1 = new JRadioButton();
  JRadioButton jRadioButtonmonitor2 = new JRadioButton();
  JRadioButton jRadioButtonmonitor3 = new JRadioButton();
  JRadioButton jRadioButtonmonitor4 = new JRadioButton();

  // Disco duro
  JLabel jLabelhd = new JLabel();
  ButtonGroup buttonGrouphd = new ButtonGroup();
  JRadioButton jRadioButtonhd1 = new JRadioButton();
  JRadioButton jRadioButtonhd2 = new JRadioButton();
  JRadioButton jRadioButtonhd3 = new JRadioButton();
  JRadioButton jRadioButtonhd4 = new JRadioButton();

  // Opciones
  JLabel jLabelopciones = new JLabel();
  JCheckBox jCheckBoxopcion1 = new JCheckBox();
  JCheckBox jCheckBoxopcion2 = new JCheckBox();
  JCheckBox jCheckBoxopcion3 = new JCheckBox();
  JCheckBox jCheckBoxopcion4 = new JCheckBox();

  // Botones
  JButton jButtoncancelar = new JButton();
  JButton jButtonsalir = new JButton();
  JButton jButtonanadir = new JButton();
  JButton jButtoneliminar = new JButton();
  JButton jButtonbuscar = new JButton();
  JButton jButtonmostrarventas = new JButton();
  JButton jButtonguardarventas = new JButton();


  //Construir el marco
  public Entorno() {
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

 /////////////////////////   COSAS DE LA VENTANA  //////////////////////////////

    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setResizable(false);
    this.setSize(new Dimension(800, 519));
    this.setTitle("Tienda de la empresa iToSoFt S.L.");

    // El siguiente C�digo cambia el Icono de la ventana :)
    ImageIcon miIcono = new ImageIcon("icono.gif");
    setIconImage(miIcono.getImage());

////////////////////////////////////////////////////////////////////////////////

////////////////////////   NOMBRE DEL CLIENTE  /////////////////////////////////
    jLabelnombre.setFont(new java.awt.Font("Times New Roman", 0, 16));
    jLabelnombre.setToolTipText("");
    jLabelnombre.setText("Nombre del Cliente");
    jLabelnombre.setBounds(new Rectangle(15, 20, 158, 25));

    jTextFieldnombrecliente.setFont(new java.awt.Font("Dialog", 0, 16));
    jTextFieldnombrecliente.setText("");
    jTextFieldnombrecliente.setBounds(new Rectangle(150, 20, 170, 25));
    jTextFieldnombrecliente.grabFocus();
////////////////////////////////////////////////////////////////////////////////

////////////////////////////   LOCALIDAD    ////////////////////////////////////
    jLabellocalidad.setBounds(new Rectangle(15, 60, 86, 25));
    jLabellocalidad.setText("Localidad");
    jLabellocalidad.setToolTipText("");
    jLabellocalidad.setFont(new java.awt.Font("Times New Roman", 0, 16));

    jComboBoxlocalidad.setEnabled(false);
    jComboBoxlocalidad.setFont(new java.awt.Font("Dialog", 0, 16));
    jComboBoxlocalidad.setBounds(new Rectangle(150, 60, 142, 25));
    // Insertamos las localidades
    jComboBoxlocalidad.addItem("Villalba");
    jComboBoxlocalidad.addItem("Alpedrete");
    jComboBoxlocalidad.addItem("Galapagar");
    jComboBoxlocalidad.addItem("Guadarrama");
    jComboBoxlocalidad.addItem("Moralzarzal");
    jComboBoxlocalidad.addItem("El Boalo");
////////////////////////////////////////////////////////////////////////////////

///////////////////////////////  LISTA   ///////////////////////////////////////
    jLabellista.setBounds(new Rectangle(448, 22, 145, 25));
    jLabellista.setText("Lista de Clientes");
    jLabellista.setToolTipText("");
    jLabellista.setFont(new java.awt.Font("Times New Roman", 0, 16));

    jListlista.setFont(new java.awt.Font("Dialog", 0, 17));
    jListlista.addFocusListener(new Entorno_jListlista_focusAdapter(this));

    jScrollPanelista.setFont(new java.awt.Font("Dialog", 1, 25));
    jScrollPanelista.setBounds(new Rectangle(565, 20, 185, 110));
////////////////////////////////////////////////////////////////////////////////

/////////////////////////////  PROCESADOR  /////////////////////////////////////
    // Texto
    jLabelprocesador.setBounds(new Rectangle(15, 150, 120, 25));
    jLabelprocesador.setText("Procesador");
    jLabelprocesador.setToolTipText("");
    jLabelprocesador.setFont(new java.awt.Font("Times New Roman", 1, 16));

    // Procesador 1
    jRadioButtonprocesador1.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonprocesador1.setEnabled(false);
    jRadioButtonprocesador1.setText("P4 3.6  64b");
    jRadioButtonprocesador1.setBounds(new Rectangle(15, 190, 120, 25));

    // Procesador 2
    jRadioButtonprocesador2.setBounds(new Rectangle(15, 240, 120, 25));
    jRadioButtonprocesador2.setEnabled(false);
    jRadioButtonprocesador2.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonprocesador2.setText("Core 2  2.67");


    // Procesador 3
    jRadioButtonprocesador3.setBounds(new Rectangle(15, 290, 120, 25));
    jRadioButtonprocesador3.setEnabled(false);
    jRadioButtonprocesador3.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonprocesador3.setSelected(true);
    jRadioButtonprocesador3.setText("AM2 4800 DC");

    // Procesador 4
    jRadioButtonprocesador4.setBounds(new Rectangle(15, 340, 120, 25));
    jRadioButtonprocesador4.setEnabled(false);
    jRadioButtonprocesador4.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonprocesador4.setText("AM2 3400+");

    // Lo agrupamos
    buttonGroupprocesador.add(jRadioButtonprocesador1);
    buttonGroupprocesador.add(jRadioButtonprocesador2);
    buttonGroupprocesador.add(jRadioButtonprocesador3);
    buttonGroupprocesador.add(jRadioButtonprocesador4);
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////  MEMORIA  /////////////////////////////////////
    // Texto
    jLabelmemoria.setFont(new java.awt.Font("Times New Roman", 1, 16));
    jLabelmemoria.setToolTipText("");
    jLabelmemoria.setText("Memoria");
    jLabelmemoria.setBounds(new Rectangle(150, 150, 120, 25));

    // Memoria 1
    jRadioButtonmemoria1.setBounds(new Rectangle(150, 190, 120, 25));
    jRadioButtonmemoria1.setEnabled(false);
    jRadioButtonmemoria1.setText("512 Mb.");
    jRadioButtonmemoria1.setFont(new java.awt.Font("Dialog", 0, 15));

    // Memoria 2
    jRadioButtonmemoria2.setBounds(new Rectangle(150, 240, 120, 25));
    jRadioButtonmemoria2.setEnabled(false);
    jRadioButtonmemoria2.setText("1024 Mb.");
    jRadioButtonmemoria2.setSelected(true);
    jRadioButtonmemoria2.setFont(new java.awt.Font("Dialog", 0, 15));

    // Memoria 3
    jRadioButtonmemoria3.setBounds(new Rectangle(150, 290, 120, 25));
    jRadioButtonmemoria3.setEnabled(false);
    jRadioButtonmemoria3.setText("2048 Mb.");
    jRadioButtonmemoria3.setFont(new java.awt.Font("Dialog", 0, 15));

    // Memoria 4
    jRadioButtonmemoria4.setBounds(new Rectangle(150, 340, 120, 25));
    jRadioButtonmemoria4.setEnabled(false);
    jRadioButtonmemoria4.setText("3072 Mb.");
    jRadioButtonmemoria4.setFont(new java.awt.Font("Dialog", 0, 15));

    // A�adimos los radiobutton a un grupo
    buttonGroupmemoria.add(jRadioButtonmemoria1);
    buttonGroupmemoria.add(jRadioButtonmemoria2);
    buttonGroupmemoria.add(jRadioButtonmemoria3);
    buttonGroupmemoria.add(jRadioButtonmemoria4);
////////////////////////////////////////////////////////////////////////////////

///////////////////////////////  MONITOR  //////////////////////////////////////
    // Texto
    jLabelmonitor.setBounds(new Rectangle(285, 150, 120, 25));
    jLabelmonitor.setText("Monitor");
    jLabelmonitor.setToolTipText("");
    jLabelmonitor.setFont(new java.awt.Font("Times New Roman", 1, 16));

    // Monitor 1
    jRadioButtonmonitor1.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonmonitor1.setEnabled(false);
    jRadioButtonmonitor1.setText("CRT  21\"");
    jRadioButtonmonitor1.setBounds(new Rectangle(282, 190, 113, 25));

    // Monitor 2
    jRadioButtonmonitor2.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonmonitor2.setEnabled(false);
    jRadioButtonmonitor2.setText("TFT  17\"");
    jRadioButtonmonitor2.setBounds(new Rectangle(282, 240, 113, 25));

    // Monitor 3
    jRadioButtonmonitor3.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonmonitor3.setEnabled(false);
    jRadioButtonmonitor3.setText("TFT  19\"");
    jRadioButtonmonitor3.setSelected(true);
    jRadioButtonmonitor3.setBounds(new Rectangle(282, 290, 113, 25));

    // Monitor 4
    jRadioButtonmonitor4.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonmonitor4.setEnabled(false);
    jRadioButtonmonitor4.setText("TFT  20\"");
    jRadioButtonmonitor4.setBounds(new Rectangle(282, 340, 113, 25));

    // Agrupamos
    buttonGroupmonitor.add(jRadioButtonmonitor1);
    buttonGroupmonitor.add(jRadioButtonmonitor2);
    buttonGroupmonitor.add(jRadioButtonmonitor3);
    buttonGroupmonitor.add(jRadioButtonmonitor4);
////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////   HD   ///////////////////////////////////////
    // Texto
    jLabelhd.setFont(new java.awt.Font("Times New Roman", 1, 16));
    jLabelhd.setToolTipText("");
    jLabelhd.setText("Disco Duro");
    jLabelhd.setBounds(new Rectangle(420, 150, 120, 25));

    // HD 1
    jRadioButtonhd1.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonhd1.setEnabled(false);
    jRadioButtonhd1.setBounds(new Rectangle(415, 190, 113, 25));
    jRadioButtonhd1.setText("ATA  160 Gb.");

    // HD 2
    jRadioButtonhd2.setBounds(new Rectangle(415, 240, 113, 25));
    jRadioButtonhd2.setEnabled(false);
    jRadioButtonhd2.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonhd2.setText("ATA  320 Gb.");

    // HD 3
    jRadioButtonhd3.setBounds(new Rectangle(415, 290, 131, 25));
    jRadioButtonhd3.setEnabled(false);
    jRadioButtonhd3.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonhd3.setText("SATA 2 160 Gb.");

    // HD 4
    jRadioButtonhd4.setBounds(new Rectangle(415, 340, 132, 25));
    jRadioButtonhd4.setEnabled(false);
    jRadioButtonhd4.setFont(new java.awt.Font("Dialog", 0, 15));
    jRadioButtonhd4.setSelected(true);
    jRadioButtonhd4.setText("SATA 2 400 Gb.");

    // Agrupaci�n de HDs
    buttonGrouphd.add(jRadioButtonhd1);
    buttonGrouphd.add(jRadioButtonhd2);
    buttonGrouphd.add(jRadioButtonhd3);
    buttonGrouphd.add(jRadioButtonhd4);
////////////////////////////////////////////////////////////////////////////////

//////////////////////////////   OPCIONES   ////////////////////////////////////
    // Texto
    jLabelopciones.setBounds(new Rectangle(600, 150, 120, 25));
    jLabelopciones.setText("Opciones");
    jLabelopciones.setToolTipText("");
    jLabelopciones.setFont(new java.awt.Font("Times New Roman", 1, 16));

    // Opci�n 1
    jCheckBoxopcion1.setFont(new java.awt.Font("Dialog", 0, 15));
    jCheckBoxopcion1.setEnabled(false);
    jCheckBoxopcion1.setText("Grabadora DVD DL LS");
    jCheckBoxopcion1.setSelected(true);
    jCheckBoxopcion1.setBounds(new Rectangle(590, 195, 180, 15));

    // Opci�n 2
    jCheckBoxopcion2.setFont(new java.awt.Font("Dialog", 0, 15));
    jCheckBoxopcion2.setEnabled(false);
    jCheckBoxopcion2.setText("Tarjeta WiFi");
    jCheckBoxopcion2.setSelected(true);
    jCheckBoxopcion2.setBounds(new Rectangle(590, 245, 180, 15));

    // Opci�n 3
    jCheckBoxopcion3.setFont(new java.awt.Font("Dialog", 0, 15));
    jCheckBoxopcion3.setEnabled(false);
    jCheckBoxopcion3.setText("Ventilador 15 cm.");
    jCheckBoxopcion3.setBounds(new Rectangle(590, 295, 180, 15));

    // Opci�n 4
    jCheckBoxopcion4.setFont(new java.awt.Font("Dialog", 0, 15));
    jCheckBoxopcion4.setEnabled(false);
    jCheckBoxopcion4.setText("WebCam");
    jCheckBoxopcion4.setBounds(new Rectangle(590, 345, 180, 15));
////////////////////////////////////////////////////////////////////////////////

//////////////////////////////    BOTONES    ///////////////////////////////////
    // Bot�n Cancelar
    jButtoncancelar.setBounds(new Rectangle(630, 400, 100, 40));
    jButtoncancelar.setFont(new java.awt.Font("Dialog", 0, 16));
    jButtoncancelar.setMnemonic('C');
    jButtoncancelar.setText("Cancelar");

    // Bot�n Salir
    jButtonsalir.setBounds(new Rectangle(630, 445, 100, 40));
    jButtonsalir.setFont(new java.awt.Font("Dialog", 0, 16));
    jButtonsalir.setMnemonic('S');
    jButtonsalir.setText("Salir");

    // Bot�n A�adir
    jButtonanadir.setBounds(new Rectangle(25, 400, 100, 40));
    jButtonanadir.setEnabled(false);
    jButtonanadir.setFont(new java.awt.Font("Dialog", 0, 16));
    jButtonanadir.setMnemonic('A');
    jButtonanadir.setText("A�adir");

    // Bot�n Buscar
    jButtonbuscar.setBounds(new Rectangle(130, 400, 100, 40));
    jButtonbuscar.setEnabled(false);
    jButtonbuscar.setFont(new java.awt.Font("Dialog", 0, 16));
    jButtonbuscar.setMnemonic('B');
    jButtonbuscar.setText("Buscar");

    // Bot�n Eliminar
    jButtoneliminar.setBounds(new Rectangle(235, 400, 100, 40));
    jButtoneliminar.setEnabled(false);
    jButtoneliminar.setFont(new java.awt.Font("Dialog", 0, 16));
    jButtoneliminar.setMnemonic('E');
    jButtoneliminar.setText("Eliminar");

    // Bot�n Mostrar Ventas
    jButtonmostrarventas.setText("Mostrar Ventas");
    jButtonmostrarventas.setMnemonic('M');
    jButtonmostrarventas.setFont(new java.awt.Font("Dialog", 0, 16));
    jButtonmostrarventas.setBounds(new Rectangle(422, 400, 150, 40));
    jButtonmostrarventas.setEnabled(true);

    // Bot�n Guardar Ventas
    jButtonguardarventas.setBounds(new Rectangle(423, 445, 150, 40));
    jButtonguardarventas.setEnabled(true);
    jButtonguardarventas.setFont(new java.awt.Font("Dialog", 0, 16));
    jButtonguardarventas.setMnemonic('G');
    jButtonguardarventas.setText("Guardar Ventas");
////////////////////////////////////////////////////////////////////////////////

/////////////////      A�ADIMOS TODOS LOS ELEMENTOS     ////////////////////////

    // Nombre
    contentPane.add(jLabelnombre, null);
    contentPane.add(jTextFieldnombrecliente, null);

    // Localidad
    contentPane.add(jLabellocalidad, null);
    contentPane.add(jComboBoxlocalidad, null);

    // Lista
    contentPane.add(jLabellista, null);
    contentPane.add(jScrollPanelista, null);

    // Procesador
    contentPane.add(jLabelprocesador, null);
    contentPane.add(jRadioButtonprocesador1, null);
    contentPane.add(jRadioButtonprocesador2, null);
    contentPane.add(jRadioButtonprocesador3, null);
    contentPane.add(jRadioButtonprocesador4, null);

    // Memoria
    contentPane.add(jLabelmemoria, null);
    contentPane.add(jRadioButtonmemoria1, null);
    contentPane.add(jRadioButtonmemoria2, null);
    contentPane.add(jRadioButtonmemoria3, null);
    contentPane.add(jRadioButtonmemoria4, null);

    // Monitor
    contentPane.add(jLabelmonitor, null);
    contentPane.add(jRadioButtonmonitor1, null);
    contentPane.add(jRadioButtonmonitor2, null);
    contentPane.add(jRadioButtonmonitor3, null);
    contentPane.add(jRadioButtonmonitor4, null);

    // HD
    contentPane.add(jLabelhd, null);
    contentPane.add(jRadioButtonhd1, null);
    contentPane.add(jRadioButtonhd2, null);
    contentPane.add(jRadioButtonhd3, null);
    contentPane.add(jRadioButtonhd4, null);

    // Opciones
    contentPane.add(jLabelopciones, null);
    contentPane.add(jCheckBoxopcion1, null);
    contentPane.add(jCheckBoxopcion2, null);
    contentPane.add(jCheckBoxopcion3, null);
    contentPane.add(jCheckBoxopcion4, null);

    // Botones
    contentPane.add(jButtoncancelar, null);// Cancelar
    contentPane.add(jButtonsalir, null);// Salir
    contentPane.add(jButtonanadir, null);// A�adir
    contentPane.add(jButtoneliminar, null);// Eliminar
    contentPane.add(jButtonbuscar, null);// Buscar
    contentPane.add(jButtonmostrarventas, null);// Mostrar Ventas
    contentPane.add(jButtonguardarventas, null);// Guardar Ventas

////////////////////////////////////////////////////////////////////////////////

/////////////////////////// ACCIONES CODIFICADAS ///////////////////////////////

    jTextFieldnombrecliente.addKeyListener(new Entorno_jTextFieldnombrecliente_keyAdapter(this));

    jButtoncancelar.addActionListener(new Entorno_jButtoncancelar_actionAdapter(this));
    jButtonanadir.addActionListener(new Entorno_jButtonanadir_actionAdapter(this));
    jButtonbuscar.addActionListener(new Entorno_jButtonbuscar_actionAdapter(this));
    jButtoneliminar.addActionListener(new Entorno_jButtoneliminar_actionAdapter(this));
    jButtonsalir.addActionListener(new Entorno_jButtonsalir_actionAdapter(this));

    jButtonguardarventas.addActionListener(new Entorno_jButtonguardarventas_actionAdapter(this));
    jButtonmostrarventas.addActionListener(new Entorno_jButtonmostrarventas_actionAdapter(this));

    jListlista.addMouseListener(new Entorno_jListlista_mouseAdapter(this));
    jListlista.addKeyListener(new Entorno_jListlista_keyAdapter(this));

////////////////////////////////////////////////////////////////////////////////
  }

  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {

    // comentado para que no se cierre con la X superior derecha
    /* super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }*/
  }

////////////////////////////////////////////////////////////////////////////////
////    I N I C I O    D E    L O S    M � T O D O S    D E    C L A S E    ////
////////////////////////////////////////////////////////////////////////////////

/* M�todos, en su mayor parte privados, que utilizaremos en la clase. EXPLICACI�N:

1.   void EscribeMensaje (String cadena1, String cadena2)
         {
          Escribe un mensaje comprensible para el usuario.
         }

2.   int MensajeSiNo (String cadena1, String cadena2)
         {
          Escribe un mensaje comprensible para el usuario, devolviendo 0 si
          el usuario presiona la opci�n S�.
         }

3.   void ActivadorDesactivador (boolean opcion)
         {
          Activa o desactiva todas las opciones del panel, excepto cancelar y salir.
          Si es TRUE, desactivar� el nombre, y si es FALSE lo activar�, borrando su
          contenido y llevando a �l el foco.
          �ste m�todo tambi�n marca la configuraci�n por defecto.
         }

4.   boolean CBActivo (JCheckBox caja)
         {
          �ste m�todo nos devolver� true si el checbox pasado est� activo, o false
          si no lo est�. Ha sido desarrollado porque la estructura ha sido utilizada
          muchas veces, aunque su complejidad sea m�nima y sus l�neas escasas.
         }

5.   int DimeActivo (JRadioButton B1, JRadioButton B2, JRadioButton B3, JRadioButton B4)
         {
          Al m�todo le pasaremos 4 JRadioButton, y nos devolver� el que est� activo
          SEG�N EL ORDEN QUE LE PASEMOS.
         }

6.   void ActivaRadio (JRadioButton B1, JRadioButton B2, JRadioButton B3, JRadioButton B4, int i)
         {
          Al m�todo le pasaremos 4 JRadioButton y un entero. Ya que en Java los
          objetos se pasan por referencia, podremos activar el radiobutton que
          queramos mediante un m�todo. En nuestro caso activaremos el n�mero i.
         }

7.   void ActicaOpciones (JCheckBox B1, JCheckBox B2, JCheckBox B3, JCheckBox B4,
                          boolean  op1, boolean  op2, boolean  op3, boolean  op4)
         {
          Le pasaremos 4 JchekBox y 4 booleanos; el m�todo los activar� teniendo
          en cuenta que ir�n siempre en orden B1-op1, B2--op2, B3--op3 y B4--op4.
         }

8.   void MuestraConfiguracion (int i)
         {
          Crea un objeto de clase Venta, llamando al vector[i], y llama a la funcion
          MuestraConfiguracion(Venta v), gracias al polimorfismo.
         }

9.   void MuestraConfiguracion (Venta v)
          {
          El fin del m�todo ser� mostrar la configuraci�n mediante un objeto que le
          pasaremos; para ello rellenaremos con los datos almacenados en el objeto
          }


10.   Venta GuardaEnClase()
         {
          El m�todo devolver� un objeto de clase Venta con todas las opciones que
          el formulario tenga.

          �ste m�todo s�lo se utiliza una vez en todo el programa, pero su separaci�n
          como m�todo permite una mejor visualizaci�n del mismo.
         }

11.  void ActDesEliminar()
        {
         El m�todo comprobar� si la lista de nombres JList est� o no vac�a.
         En caso afirmativo, desactivar� el bot�n Eliminar y viceversa.
        }

12.  void Salir(String mensaje)
        {
         El m�todo preguntar� si el usuario desea salir; en caso afirmativo saldr�
         de la aplicaci�n; en caso negativo pondr� el formulario est�ndar.
        }
*/


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


// M�todo privado que recibe un booleano y activa o desactiva las opciones:
  private void ActivadorDesactivador(boolean opcion){

    // Ponemos color blanco al texto
    jTextFieldnombrecliente.setOpaque(true);

    // Activamos/Desactivamos Localidad
    jComboBoxlocalidad.setEnabled(opcion);

    // Y deshabilitamos el bot�n eliminar
    jButtoneliminar.setEnabled(opcion);

    // Activamos/Desactivamos los procesadores
    jRadioButtonprocesador1.setEnabled(opcion);
    jRadioButtonprocesador2.setEnabled(opcion);
    jRadioButtonprocesador3.setEnabled(opcion);
    jRadioButtonprocesador4.setEnabled(opcion);

    // Activamos/Desactivamos las memorias
    jRadioButtonmemoria1.setEnabled(opcion);
    jRadioButtonmemoria2.setEnabled(opcion);
    jRadioButtonmemoria3.setEnabled(opcion);
    jRadioButtonmemoria4.setEnabled(opcion);

    // Activamos/Desactivamos los monitores
    jRadioButtonmonitor1.setEnabled(opcion);
    jRadioButtonmonitor2.setEnabled(opcion);
    jRadioButtonmonitor3.setEnabled(opcion);
    jRadioButtonmonitor4.setEnabled(opcion);

    // Activamos/Desactivamos los discos duros
    jRadioButtonhd1.setEnabled(opcion);
    jRadioButtonhd2.setEnabled(opcion);
    jRadioButtonhd3.setEnabled(opcion);
    jRadioButtonhd4.setEnabled(opcion);

    // Activamos/Desactivamos las opciones
    jCheckBoxopcion1.setEnabled(opcion);
    jCheckBoxopcion2.setEnabled(opcion);
    jCheckBoxopcion3.setEnabled(opcion);
    jCheckBoxopcion4.setEnabled(opcion);

    // Activamos/Desactivamos los botones A�adir y Buscar y Eliminar
    jButtonanadir.setEnabled(opcion);
    jButtonbuscar.setEnabled(opcion);

    // Marcamos la configuraci�n est�ndar
    jCheckBoxopcion1.setSelected(true);
    jCheckBoxopcion2.setSelected(true);
    jCheckBoxopcion3.setSelected(false);
    jCheckBoxopcion4.setSelected(false);
    jRadioButtonhd4.setSelected(true);
    jRadioButtonprocesador3.setSelected(true);
    jRadioButtonmemoria2.setSelected(true);
    jRadioButtonmonitor3.setSelected(true);
    jComboBoxlocalidad.setSelectedIndex(0);
    jButtoneliminar.setEnabled(false);

    // Si la opcion es TRUE, desactivaremos el campo del nombre
    if (opcion==true){
      jTextFieldnombrecliente.setEnabled(false);
      jTextFieldnombrecliente.setEditable(false);
    }
    // En caso de ser FALSE, la activaremos borrando su contenido y con foco
    else{
      jTextFieldnombrecliente.setEnabled(true);
      jTextFieldnombrecliente.setEditable(true);
      jTextFieldnombrecliente.setText("");
      jTextFieldnombrecliente.grabFocus();
    }
  }// Fin de ActivadorDesactivador


  // M�todo que recine un CheckBox, devolviendo true si est� Activo o False si no lo est�
  private boolean CBActivo(JCheckBox cb){
    // Supondremos en principio que la variable estar� desactivada
    boolean retorno = false;

    // Si el CheckBox est� activo ponemos la variable TRUE
    if (cb.isSelected()==true)
      retorno=true;

    return retorno;
  }// Fin de CBActivo


  // M�todo que recibe 4 radiobutton y devuelve la posici�n del que est� activo
   private int DimeActivo(JRadioButton b1, JRadioButton b2, JRadioButton b3, JRadioButton b4){
     int activo=0;

    if (b1.isSelected()==true)
      activo=1;

    else if (b2.isSelected()==true)
      activo=2;

    else if (b3.isSelected()==true)
      activo=3;

    else
      activo=4;

     return activo;
   }// Fin del metodo que me dice qu� bot�n est� activo


   // M�todo que recibe 4 radiobutton y un entero y activa el numero que se le da
   // ya que en Java los objetos se pasan por REFERENCIA
   private void ActivaRadio(JRadioButton b1, JRadioButton b2, JRadioButton b3, JRadioButton b4, int i){

     // Casos que puede ser i:
     switch (i)
     {
     case 1:
       b1.setSelected(true);
     break;

     case 2:
       b2.setSelected(true);
     break;

     case 3:
       b3.setSelected(true);
     break;

     case 4:
       b4.setSelected(true);
     break;
     }// Fin del switch(i)

   }// Fin del metodo que activa un radiobutton


 // M�todo que recibe 4 CheckBox y 4 booleanos y activa o desactiva dependiendo de ellos
   private void ActivaOpciones(JCheckBox b1, JCheckBox b2, JCheckBox b3, JCheckBox b4,boolean op1,boolean op2,boolean op3,boolean op4){

     b1.setSelected(op1);
     b2.setSelected(op2);
     b3.setSelected(op3);
     b4.setSelected(op4);

   }// Fin del metodo que activa opciones


// M�todo privado que muestra la configuraci�n seg�n un �ndice pasado como parametro
   private void MuestraConfiguracion(int i){

    // Creamos un objeto "comprador" de clase Venta
    Venta comprador = new Venta();
    // Y le "pasamos" los valores del Vector clientes haciendo un CAST
    comprador = (Venta) clientes.elementAt(i);

    // Rellenamos el formulario con sus datos, llamando al metodo de igual nombre
    // gracias al POLIMORFISMO de Java
    MuestraConfiguracion(comprador);

  }// Fin de MuestraConfiguracion1


// M�todo privado que muestra la configuraci�n seg�n un Objeto pasado como parametro
   private void MuestraConfiguracion(Venta v){

    // Rellenamos el formulario con sus datos
    jTextFieldnombrecliente.setText(v.getNombre());
    jComboBoxlocalidad.setSelectedIndex(v.getLocalidad());
    ActivaRadio(jRadioButtonprocesador1,jRadioButtonprocesador2,jRadioButtonprocesador3,jRadioButtonprocesador4,v.getProcesador());
    ActivaRadio(jRadioButtonmemoria1,jRadioButtonmemoria2,jRadioButtonmemoria3,jRadioButtonmemoria4,v.getMemoria());
    ActivaRadio(jRadioButtonmonitor1,jRadioButtonmonitor2,jRadioButtonmonitor3,jRadioButtonmonitor4,v.getMonitor());
    ActivaRadio(jRadioButtonhd1,jRadioButtonhd2,jRadioButtonhd3,jRadioButtonhd4,v.getHD());
    ActivaOpciones(jCheckBoxopcion1, jCheckBoxopcion2, jCheckBoxopcion3, jCheckBoxopcion4, v.getOpcion1(), v.getOpcion2(), v.getOpcion3(), v.getOpcion4() );

  }// Fin de MuestraConfiguracion2


// M�todo que guarda todas las opciones que aparecen en pantalla:
  private Venta GuardaEnClase(){

    /* Creo un objeto de clase Venta, llamando al constructor por defecto.
       Aqu� podr�a llamar al constructor que recibe todos los par�metros, pero
       quedar�a poco claro y demasiado largo el c�digo fuente.                */
    Venta comprador = new Venta();


    // Guardamos el nombre como un String llamando al m�todo setNombre
    comprador.setNombre(jTextFieldnombrecliente.getText());

    // Guardamos la localidad como un Entero llamando al m�todo setLocalidad
    comprador.setLocalidad(jComboBoxlocalidad.getSelectedIndex());

    /* Los RadioButton los guardaremos por n�meros, seg�n el que est� activo.
     Para ello llamaremos a los diferentes SETTERS de los atributos PROCESADOR,
     MEMORIA, MONITOR y HD de la clase VENTA, que reciben un n�mero Entero.
     Para hayar ese N�mero he desarrollado un M�TODO privado llamado DimeActivo
     que recibe cuatro RADIOBUTTON EN ORDEN y devuelve cual de ellos est� activo*/
    comprador.setProcesador( DimeActivo(jRadioButtonprocesador1,jRadioButtonprocesador2,jRadioButtonprocesador3,jRadioButtonprocesador4) );
    comprador.setMemoria( DimeActivo(jRadioButtonmemoria1,jRadioButtonmemoria2,jRadioButtonmemoria3,jRadioButtonmemoria4) );
    comprador.setMonitor( DimeActivo(jRadioButtonmonitor1,jRadioButtonmonitor2,jRadioButtonmonitor3,jRadioButtonmonitor4) );
    comprador.setHD( DimeActivo(jRadioButtonhd1,jRadioButtonhd2,jRadioButtonhd3,jRadioButtonhd4) );


    // Guardamos las Opciones. Ahora llamaremos a un m�todo CBActivo, que recine
    // un CheckBox,  devolviendo true si est� Activo o False si no lo est�
    comprador.setOpcion1(CBActivo(jCheckBoxopcion1));
    comprador.setOpcion2(CBActivo(jCheckBoxopcion2));
    comprador.setOpcion3(CBActivo(jCheckBoxopcion3));
    comprador.setOpcion4(CBActivo(jCheckBoxopcion4));

    // Devolvemos el objeto creado, pero ya lleno de informaci�n
    return comprador;

  }// Fin del m�todo GuardaEnClase


// M�todo que activar� o desactivar� el bot�n eliminar si y s�lo si la lista
// no est� vac�a, desactiv�ndolo en caso de estar vac�a
  private void ActDesEliminar(){
    // si no est� vac�a la lista...
    if (nombres.isEmpty()==false){
      // Activamos ELIMINAR, desactivamos A�ADIR, BUSCAR y el nombre
      jButtoneliminar.setEnabled(true);
      jButtonanadir.setEnabled(false);
      jButtonbuscar.setEnabled(false);
      jTextFieldnombrecliente.setEnabled(false);
      jTextFieldnombrecliente.setOpaque(false);
      // Mostramos la configuraci�n del Usuario seleccionado
      MuestraConfiguracion(jListlista.getSelectedIndex());

    }//Fin de si la lista no est� vac�a

    // En caso de que la lista est� vac�a, desactivamos el bot�n eliminar
    else
      jButtoneliminar.setEnabled(false);

  }// Fin del avtivador desactivador del bot�n eliminar

  private void Salir(String mensaje){
    // Preguntamos si est� segur@
    int aseguradora = MensajeSiNo("� Atenci�n !", mensaje);

    // Si ha respondido afirmativamente:
    if (aseguradora == 0){
      EscribeMensaje("Adi�s", "Esperamos que disfrutase de la aplicaci�n");
      System.exit(0);
    }

    // Si decide no salir ponemos todo a cero
    else
      ActivadorDesactivador(false);

  }// Fin del m�todo que repgunta para salir

////////////////////////////////////////////////////////////////////////////////
/////////////////////   FIN DE LOS M�TODOS DE CLASE   //////////////////////////
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//////////////  INICIO DE LA CODIFICACI�N DE BOTONES Y ACCIONES  ///////////////
////////////////////////////////////////////////////////////////////////////////

// Cuando se presiona cualquier tecla en el nombre jTextFieldnombrecliente
  void jTextFieldnombrecliente_keyPressed(KeyEvent e) {
    // Si la tecla es enter
    if (e.getKeyCode()==10){
      // Si no es un campo de texto o su longitud supera los 15 caracteres

      if (!jTextFieldnombrecliente.getText().matches("[a-zA-Z������������ ]+") || jTextFieldnombrecliente.getText().length()>15){
        // Mensaje de error
        EscribeMensaje("Error", "El campo Nombre es obligatorio; S�lo puede contener letras\ny su longitud no ha de superar los 15 caracteres.");
        // Llevamos el foco otra vez al nombre y seleccionamos el texto
        jTextFieldnombrecliente.grabFocus();
        jTextFieldnombrecliente.selectAll();
      }// Fin del error

      // Sin embargo, si es cadena es de texto y menor de 16
      else{
        // Activamos las casillas y desactivamos el nombre
        ActivadorDesactivador(true);
        // Y llevamos el foco a la localidad
        jComboBoxlocalidad.grabFocus();
      }// Fin del else

    }// Fin de si la tecla es enter

  }// Fin de si se presiona cualquier tecla del nombre


// Bot�n Cancelar
  void jButtoncancelar_actionPerformed(ActionEvent e) {
    // Desactivamos todas las casillas excepto el nombre
    ActivadorDesactivador(false);
  }// Fin del bot�n cancelar


//Bot�n A�adir
  void jButtonanadir_actionPerformed(ActionEvent e) {

    // Objeto de clase venta, donde guardaremos temporalmente los datos de la venta
    Venta compradores = new Venta();

    // Llamamos al M�todo GuardaEnClase, rellenando los atributos de compradores
    compradores = GuardaEnClase();

    // En el vector clientes meteremos todos los datos; podr�amos habernos ahorrado
    // el crear el objeto compradores, pero la legibilidad es m�s importante que
    // el ahorro de memoria ;)
    clientes.addElement(compradores);
    // Y en el nombres, s�lo los nombres
    nombres.addElement(jTextFieldnombrecliente.getText());

    // Activamos la lista si estuviese desactivada
    jListlista.setVisible(true);

    // De la siguiente manera incluiremos el nombre en la lista
    jListlista.setListData(nombres);
    jScrollPanelista.getViewport().setView(jListlista);

    // Y terminaremos poniendo El formulario "a cero"
    ActivadorDesactivador(false);
  }// Bot�n A�adir


// Empezamos con el Bot�n Buscar
  void jButtonbuscar_actionPerformed(ActionEvent e) {

    // Empiezo poniendo un bool como "No encontrado" y un sigue a cero
    boolean encontrado=false;
    int sigue = 0;

    // Vamos a recorrer la lista de los nombres, busc�ndolos, mientras no lleguemos
    // al l�mite de tama�o Y mientras quera seguir el usuario (o sea, sigue == 0)
    for (int i=0;i<nombres.size() && sigue==0;i++){

      // Si el texto de la caja coincide con alguno del array de nombres
      if (jTextFieldnombrecliente.getText().compareTo(nombres.elementAt(i))==0){

        // Ponemos el booleano como verdadero
        encontrado=true;

        // Llamamos a la funci�n que muestra la configuraci�n MuestraConfiguracion(i);
        MuestraConfiguracion(i);

        // Y preguntamos si desea seguir buscando
        sigue = MensajeSiNo("� Encontrado !", "Nombre encontrado\n�Desea continuar con la b�squeda?");
      }// Fin del acierto encontrando

    }// Fin del bucle for que recorre los nombres

    // Si no ha encontrado ning�n nombre
    if (encontrado==false)
      EscribeMensaje("Error","Ese nombre no existe\nRevise la Sintaxis");
    // Sin embargo, Si encontr� alguno Y respondi� que s� a seguir buscando
    else if (sigue==0)
      EscribeMensaje("Fin","No hay m�s registros para mostrar");

    // Volvemos al estado inicial
    ActivadorDesactivador(false);

  }// Fin del Bot�n Buscar

// Comenzamos al hacer click en la lista
  void jListlista_mouseClicked(MouseEvent e) {

    ActDesEliminar();

  }// Fin de CLICK en la lista


// Bot�n eliminar
  void jButtoneliminar_actionPerformed(ActionEvent e) {

    // Preguntamos si est� seguro
    int aseguradora = MensajeSiNo("� Atenci�n !", "Se va a eliminar un registro\n�sta operaci�n no tiene vuelta atr�s\n�Desea continuar con la Eliminaci�n?");

    // Si ha respondido afirmativamente:
    if (aseguradora==0)
    {
      // indice es un entero al que le pasamos el indice seleccionado
      int indice=jListlista.getSelectedIndex();
      // Lo eliminamos de ambos Vectores
      nombres.remove(indice);
      clientes.remove(indice);

      // Si la lista est� vac�a, desactivamos el JList
      if(nombres.size()==0)
        jListlista.setVisible(false);

    }// Fin de la eliminaci�n

    else
      EscribeMensaje("Informaci�n","No se han eliminado registros");

    // Y volvemos a mostrar la configuraci�n de la lista
   jListlista.setListData(nombres);
   // Dejamos el formulario "a cero"
   ActivadorDesactivador(false);

  }// Fin del Bot�n Eliminar


// Bot�n Salir
  void jButtonsalir_actionPerformed(ActionEvent e) {

    // Si hay datos para guardar avisamos al usuario, suspendiendo el cierre de la aplicaci�n
    if (nombres.size()>0){

      String mensaje = "Hay datos que no ha sido guardados.";
      mensaje+="\n�sta operaci�n no tiene vuelta atr�s\n\n�Desea Salir?";

      Salir(mensaje);

    }// Fin de si hay datos para guardar

  // Si no hay datos para guardar
  else
    Salir("�sta operaci�n no tiene vuelta atr�s\n\n�Desea Salir?");

}// Fin del bot�n Salir


  // Cuando se "suelta" una tecla en el JListlista
  void jListlista_keyReleased(KeyEvent e) {
    ActDesEliminar();
  }// "soltar" tecla en la caja de nombres


  // Cuando la lista tenga el foco
  void jListlista_focusGained(FocusEvent e) {
    // SI NO HAY NING�N ELEMENTO SEleccionado
    if (jListlista.isSelectionEmpty()==true){
      // que seleccione el primero
      jListlista.setSelectedIndex(0);
    }

  }


  // Bot�n Guardar Ventas
  void jButtonguardarventas_actionPerformed(ActionEvent e) {
    try{

      // En caso de que la lista no est� vac�a, la recorreremos y guardaremos
      if (nombres.isEmpty()==false){

        // Objeto de la clase FileOutputStream, para guardar los datos en ventas.dat
        FileOutputStream VentasOut = new FileOutputStream("ventas.dat",true);
        // salida est� declarado para poder guardar valores de texto UTF8
        DataOutputStream salida = new DataOutputStream(VentasOut);

        Venta v = new Venta();  // Objeto donde guardaremos temporalmente el cliente con sus datos

        while(nombres.size()>0){

          // A v (objeto de clase Venta) le pasamos los valores del vector
          v = (Venta) clientes.elementAt(0);

          // Y escribimos en el fichero todos sus datos
          salida.writeUTF(v.getNombre());
          salida.writeInt(v.getLocalidad());

          salida.writeInt(v.getProcesador());
          salida.writeInt(v.getMemoria());
          salida.writeInt(v.getMonitor());
          salida.writeInt(v.getHD());

          salida.writeBoolean(v.getOpcion1());
          salida.writeBoolean(v.getOpcion2());
          salida.writeBoolean(v.getOpcion3());
          salida.writeBoolean(v.getOpcion4());

          // Una vez guardado el elemento lo elimanaremos de ambos Vectores; los vectores, que son din�minos,
          // se mueven, pasando un lugar para arriba; por ello siempre guardaremos el vector [0]
          // Recargaremos la lista de nombres, conforme los hayamos guardado Y borrado
          clientes.remove(0);
          nombres.remove(0);
          jListlista.setListData(nombres);

        }// Fin del WHILE que recorre tantas veces como clientes haya almacenados

        salida.close();       // Terminaremos cerrando el Archivo
        VentasOut.close();    // Sin olvidarnos de que son 2

      }//Fin de que existan datos a guardar

      // Por el contrario, en caso de que no existan datos para guardar
      else
        EscribeMensaje("Error","No existen datos para guardar");

    }// TRY de GuardarVentas

    catch(Exception error){
      // Mensaje de error
      EscribeMensaje("Error en disco","Error al grabar en disco.\nCompruebe que el disco no est� lleno ni protegido contra escritura");
    }

    finally{
      ActivadorDesactivador(false);
    }//Finally

  }// Fin de Guardar Ventas


  // Inicio de la codificaci�n de Mostrar Ventas
  void jButtonmostrarventas_actionPerformed(ActionEvent e) {
    try{

      // Objeto de la clase FileInputStream, para caragr los datos de ventas.dat
      FileInputStream VentasIn = new FileInputStream("ventas.dat");
      // entrada est� declarado para poder cargar valores de texto UTF8
      DataInputStream entrada = new DataInputStream(VentasIn);

      int sigue=0;            // Variable aseguradora para el bucle

      Venta v = new Venta();  // Objeto donde guardaremos temporalmente el cliente con sus datos

      while (sigue == 0){
        // Guardamos los datos en el objeto de clase Venta
        v.setNombre( (String) entrada.readUTF());
        v.setLocalidad(entrada.readInt());

        v.setProcesador(entrada.readInt());
        v.setMemoria(entrada.readInt());
        v.setMonitor(entrada.readInt());
        v.setHD(entrada.readInt());

        v.setOpcion1(entrada.readBoolean());
        v.setOpcion2(entrada.readBoolean());
        v.setOpcion3(entrada.readBoolean());
        v.setOpcion4(entrada.readBoolean());

        // Los mostramos en la pantalla
        MuestraConfiguracion(v);

        // Preguntamos si desea cointinuar
        sigue = MensajeSiNo("Pregunta","�Desea Continuar con la muestra?");

      }// fin del While

      // Cerramos todo
      entrada.close();
      VentasIn.close();

    }// Try MostrarVentas

    catch(FileNotFoundException e1){
      EscribeMensaje("Error","No existe fichero de datos");
    }//FileNotFoundException

    catch(EOFException e2){
      EscribeMensaje("Informaci�n General","No hay m�s datos para mostrar");
    }//EOFException

    catch(Exception e3){
      // EscribeMensaje("Error General","Resto de errores");
    }//Exception

    finally{
      ActivadorDesactivador(false);
    }//Finally

  }// Fin de Mostrar Ventas

////////////////////////////////////////////////////////////////////////////////
////////////////  FIN DE LA CODIFICACI�N DE BOTONES Y ACCIONES  ////////////////
////////////////////////////////////////////////////////////////////////////////

}// Fin de la clase

class Entorno_jTextFieldnombrecliente_keyAdapter extends java.awt.event.KeyAdapter {
  Entorno adaptee;

  Entorno_jTextFieldnombrecliente_keyAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextFieldnombrecliente_keyPressed(e);
  }
}

class Entorno_jButtoncancelar_actionAdapter implements java.awt.event.ActionListener {
  Entorno adaptee;

  Entorno_jButtoncancelar_actionAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtoncancelar_actionPerformed(e);
  }
}

class Entorno_jButtonanadir_actionAdapter implements java.awt.event.ActionListener {
  Entorno adaptee;

  Entorno_jButtonanadir_actionAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonanadir_actionPerformed(e);
  }
}

class Entorno_jButtonbuscar_actionAdapter implements java.awt.event.ActionListener {
  Entorno adaptee;

  Entorno_jButtonbuscar_actionAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonbuscar_actionPerformed(e);
  }
}

class Entorno_jButtoneliminar_actionAdapter implements java.awt.event.ActionListener {
  Entorno adaptee;

  Entorno_jButtoneliminar_actionAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtoneliminar_actionPerformed(e);
  }
}

class Entorno_jListlista_mouseAdapter extends java.awt.event.MouseAdapter {
  Entorno adaptee;

  Entorno_jListlista_mouseAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jListlista_mouseClicked(e);
  }
}

class Entorno_jButtonsalir_actionAdapter implements java.awt.event.ActionListener {
  Entorno adaptee;

  Entorno_jButtonsalir_actionAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonsalir_actionPerformed(e);
  }
}

class Entorno_jListlista_keyAdapter extends java.awt.event.KeyAdapter {
  Entorno adaptee;

  Entorno_jListlista_keyAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }

  public void keyReleased(KeyEvent e) {
    adaptee.jListlista_keyReleased(e);
  }
}

class Entorno_jListlista_focusAdapter extends java.awt.event.FocusAdapter {
  Entorno adaptee;

  Entorno_jListlista_focusAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void focusGained(FocusEvent e) {
    adaptee.jListlista_focusGained(e);
  }
}

class Entorno_jButtonguardarventas_actionAdapter implements java.awt.event.ActionListener {
  Entorno adaptee;

  Entorno_jButtonguardarventas_actionAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonguardarventas_actionPerformed(e);
  }
}

class Entorno_jButtonmostrarventas_actionAdapter implements java.awt.event.ActionListener {
  Entorno adaptee;

  Entorno_jButtonmostrarventas_actionAdapter(Entorno adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonmostrarventas_actionPerformed(e);
  }
}
