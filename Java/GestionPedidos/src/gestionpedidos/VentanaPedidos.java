package gestionpedidos;

import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Título: VentanaPedidos</p>
 * <p>Descripción: Clase para gestionar el pedido de clientes y proveedores</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.1
 * Fecha de inicio: 21 / XI / 2006
 * Fecha de finalización: 26 / XI / 2006
 */


public class VentanaPedidos extends JFrame  {

  // variable utilizada para saber si estamos con clientes o proveedores
  private int opcion = 0;

  // La conexión se hará al principio de la clase
  GestorBD conexion = new GestorBD();

  // Aquí guardaremos el Cliente, para poder imprimir sus datos
  Cliente cli = new Cliente();

  // Y por último Declararemos un vector donde almacenar las lineas de pedido
  Vector vLineas = new Vector();

  // Utilizaremos un Cliente miempresa para guardar los datos de mi empresa
  Cliente miempresa = new Cliente("invalid","B-123456","iToSoft","",
                 "Calle Real nº 8","28413","El Boalo","911123456","666123456","911111111","info@miempresa.es",0);


  //miempresa.setNombre("iToSoft");

  private JFrame padre;
  JPanel contentPane;
  JMenuBar jMenuBar = new JMenuBar();
  JMenu jMenuPedidos = new JMenu();
  JMenuItem jMenuItemCliente = new JMenuItem();
  JMenuItem jMenuItemProveedor = new JMenuItem();
  JMenuItem jMenuItemVolver = new JMenuItem();
  JTextField jTextNIF = new JTextField();
  JTextField jTextCodigo = new JTextField();
  JLabel jLabelApellidos = new JLabel();
  JTextField jTextFieldDomicilio = new JTextField();
  JTextField jTextApellidos = new JTextField();
  JLabel jLabelCP = new JLabel();
  JTextField jTextFieldVentas = new JTextField();
  JLabel jLabelLocalidad = new JLabel();
  JTextField jTextFieldLocalidad = new JTextField();
  JLabel jLabelNIF = new JLabel();
  JTextField jTextFieldCP = new JTextField();
  JLabel jLabelCodigo = new JLabel();
  JLabel jLabelVentas = new JLabel();
  JLabel jLabelNombre = new JLabel();
  JLabel jLabelDomicilio = new JLabel();
  JTextField jTextNombre = new JTextField();
  JLabel jLabelSeparador = new JLabel();
  JTextField jTextArticulo = new JTextField();
  JLabel jLabelArticulo = new JLabel();
  JTextField jTextDescripcion = new JTextField();
  JLabel jLabelDescripcion = new JLabel();
  JLabel jLabelUnidades = new JLabel();
  JTextField jTextUnidades = new JTextField();
  JLabel jLabelStock = new JLabel();
  JTextField jTextStock = new JTextField();
  JLabel jLabelPrecio = new JLabel();
  JTextField jTextPrecio = new JTextField();
  JTextField jTextImporte = new JTextField();
  JLabel jLabelImporte = new JLabel();
  JButton jButtonFactura = new JButton();
  JButton jButtonAceptar = new JButton();
  JButton jButtonSalir = new JButton();
  JButton jButtonCancelarPedido = new JButton();
  JButton jButtonCancelarTodo = new JButton();

  private void jbInit() throws Exception  {
    contentPane = (JPanel)this.getContentPane();
    contentPane.setLayout(null);
    this.setLocale(java.util.Locale.getDefault());
    this.setJMenuBar(jMenuBar);
    this.setResizable(false);
    this.setSize(new Dimension(405, 460));
    this.setTitle("Gestión de Almacén - Pedidos");

    // El siguiente Código cambia el Icono de la ventana :)
    ImageIcon miImagen = new ImageIcon("icono.gif");
    setIconImage(miImagen.getImage());

    // Barra horizontal de arriba
    jMenuPedidos.setMnemonic('P');
    jMenuPedidos.setText("Pedidos");

    jMenuItemCliente.setMnemonic('C');
    jMenuItemCliente.setText("Cliente");
    jMenuItemCliente.addActionListener(new VentanaPedidos_jMenuItemCliente_actionAdapter(this));

    jMenuItemProveedor.setMnemonic('P');
    jMenuItemProveedor.setText("Proveedor");
    jMenuItemProveedor.addActionListener(new VentanaPedidos_jMenuItemProveedor_actionAdapter(this));

    jMenuItemVolver.setMnemonic('V');
    jMenuItemVolver.setText("Volver");
    jMenuItemVolver.addActionListener(new VentanaPedidos_jMenuItemVolver_actionAdapter(this));

    // Elementos de cajas y textos

    jLabelCodigo.setText("Código");
    jLabelCodigo.setBounds(new Rectangle(0, 0, 43, 20));
    jTextCodigo.setEditable(false);
    jTextCodigo.setText("");
    jTextCodigo.setBounds(new Rectangle(0, 25, 75, 20));
    jTextCodigo.addKeyListener(new VentanaPedidos_jTextCodigo_keyAdapter(this));

    jLabelNIF.setText("N.I.F.");
    jLabelNIF.setBounds(new Rectangle(99, 0, 30, 20));
    jTextNIF.setEditable(false);
    jTextNIF.setText("");
    jTextNIF.setBounds(new Rectangle(99, 25, 116, 20));

    jLabelNombre.setText("Nombre");
    jLabelNombre.setBounds(new Rectangle(244, 0, 60, 20));
    jTextNombre.setEditable(false);
    jTextNombre.setText("");
    jTextNombre.setBounds(new Rectangle(244, 25, 150, 20));

    jLabelApellidos.setText("Apellidos");
    jLabelApellidos.setBounds(new Rectangle(0, 50, 60, 20));
    jTextApellidos.setEditable(false);
    jTextApellidos.setText("");
    jTextApellidos.setBounds(new Rectangle(0, 75, 395, 20));

    jLabelDomicilio.setText("Domicilio");
    jLabelDomicilio.setBounds(new Rectangle(0, 100, 100, 20));
    jTextFieldDomicilio.setEditable(false);
    jTextFieldDomicilio.setText("");
    jTextFieldDomicilio.setBounds(new Rectangle(0, 125, 395, 20));

    jLabelCP.setText("Código Postal");
    jLabelCP.setBounds(new Rectangle(0, 150, 90, 20));
    jTextFieldCP.setEditable(false);
    jTextFieldCP.setText("");
    jTextFieldCP.setBounds(new Rectangle(0, 175, 80, 20));

    jLabelLocalidad.setText("Localidad");
    jLabelLocalidad.setBounds(new Rectangle(99, 150, 60, 20));
    jTextFieldLocalidad.setEditable(false);
    jTextFieldLocalidad.setText("");
    jTextFieldLocalidad.setBounds(new Rectangle(99, 175, 172, 20));

    jLabelVentas.setText("Total Ventas");
    jLabelVentas.setBounds(new Rectangle(324, 153, 71, 20));
    jTextFieldVentas.setEnabled(false);
    jTextFieldVentas.setEditable(false);
    jTextFieldVentas.setText("");
    jTextFieldVentas.setBounds(new Rectangle(314, 175, 81, 20));

    // Barra separadora
    for(int i=0;i<67;i++)
      jLabelSeparador.setText(jLabelSeparador.getText()+"_");
    jLabelSeparador.setBounds(new Rectangle(0, 195, 410, 20));

    // Parte de abajo
    jLabelArticulo.setBounds(new Rectangle(0, 215, 43, 20));
    jLabelArticulo.setText("Artículo");
    jTextArticulo.setBounds(new Rectangle(0, 240, 75, 20));
    jTextArticulo.addKeyListener(new VentanaPedidos_jTextArticulo_keyAdapter(this));
    jTextArticulo.setEditable(false);
    jTextArticulo.setText("");

    jLabelDescripcion.setText("Descripción");
    jLabelDescripcion.setBounds(new Rectangle(107, 216, 119, 20));
    jTextDescripcion.setEditable(false);
    jTextDescripcion.setText("");
    jTextDescripcion.setBounds(new Rectangle(107, 240, 224, 20));

    jLabelUnidades.setText("Unidades");
    jLabelUnidades.setBounds(new Rectangle(0, 272, 57, 20));
    jTextUnidades.setEditable(false);
    jTextUnidades.setText("");
    jTextUnidades.setBounds(new Rectangle(0, 297, 75, 20));
    jTextUnidades.addKeyListener(new VentanaPedidos_jTextUnidades_keyAdapter(this));

    jLabelStock.setText("Stock");
    jLabelStock.setBounds(new Rectangle(100, 272, 57, 20));
    jTextStock.setBounds(new Rectangle(100, 297, 75, 20));
    jTextStock.setEnabled(false);
    jTextStock.setEditable(false);
    jTextStock.setText("");

    jLabelPrecio.setText("Precio");
    jLabelPrecio.setBounds(new Rectangle(200, 272, 57, 20));
    jTextPrecio.setBounds(new Rectangle(200, 297, 75, 20));
    jTextPrecio.setEnabled(false);
    jTextPrecio.setEditable(false);
    jTextPrecio.setText("");

    jLabelImporte.setText("Importe");
    jLabelImporte.setBounds(new Rectangle(300, 272, 57, 20));
    jTextImporte.setEnabled(false);
    jTextImporte.setEditable(false);
    jTextImporte.setText("");
    jTextImporte.setBounds(new Rectangle(300, 297, 75, 20));

    jButtonFactura.setText("F");
    jButtonFactura.addActionListener(new VentanaPedidos_jButtonFactura_actionAdapter(this));
    jButtonFactura.setBounds(new Rectangle(100, 340, 80, 30));
    jButtonFactura.setEnabled(false);
    jButtonFactura.setMnemonic('F');

    jButtonAceptar.setText("Aceptar");
    jButtonAceptar.addActionListener(new VentanaPedidos_jButtonAceptar_actionAdapter(this));
    jButtonAceptar.setBounds(new Rectangle(200, 340, 80, 30));
    jButtonAceptar.setEnabled(false);
    jButtonAceptar.setFocusPainted(true);
    jButtonAceptar.setMnemonic('A');

    jButtonSalir.setText("Salir");
    jButtonSalir.addActionListener(new VentanaPedidos_jButtonSalir_actionAdapter(this));
    jButtonSalir.setMnemonic('S');
    jButtonSalir.setBounds(new Rectangle(300, 340, 80, 30));
    jButtonSalir.setEnabled(false);

    jButtonCancelarPedido.setText("Cancelar Pedido");
    jButtonCancelarPedido.addActionListener(new VentanaPedidos_jButtonCancelarPedido_actionAdapter(this));
    jButtonCancelarPedido.setMnemonic('P');
    jButtonCancelarPedido.setBounds(new Rectangle(100, 380, 130, 30));
    jButtonCancelarPedido.setEnabled(false);

    jButtonCancelarTodo.setText("Cancelar Todo");
    jButtonCancelarTodo.addActionListener(new VentanaPedidos_jButtonCancelarTodo_actionAdapter(this));
    jButtonCancelarTodo.setBounds(new Rectangle(250, 380, 130, 30));
    jButtonCancelarTodo.setEnabled(false);
    jButtonCancelarTodo.setMnemonic('C');

    // Ponemos en orden la barra horizontal
    jMenuBar.add(jMenuPedidos);
    jMenuPedidos.add(jMenuItemCliente);
    jMenuPedidos.add(jMenuItemProveedor);
    jMenuPedidos.addSeparator();
    jMenuPedidos.add(jMenuItemVolver);

    // Addeamos todo
    contentPane.add(jTextNIF, null);
    contentPane.add(jTextCodigo, null);
    contentPane.add(jLabelApellidos, null);
    contentPane.add(jTextFieldDomicilio, null);
    contentPane.add(jTextApellidos, null);
    contentPane.add(jLabelCP, null);
    contentPane.add(jLabelLocalidad, null);
    contentPane.add(jTextFieldLocalidad, null);
    contentPane.add(jLabelNIF, null);
    contentPane.add(jTextFieldCP, null);
    contentPane.add(jLabelCodigo, null);
    contentPane.add(jLabelNombre, null);
    contentPane.add(jLabelDomicilio, null);
    contentPane.add(jTextNombre, null);
    contentPane.add(jLabelVentas, null);
    contentPane.add(jTextFieldVentas, null);
    contentPane.add(jLabelSeparador, null);
    contentPane.add(jTextArticulo, null);
    contentPane.add(jLabelArticulo, null);
    contentPane.add(jTextDescripcion, null);
    contentPane.add(jLabelDescripcion, null);
    contentPane.add(jTextUnidades, null);
    contentPane.add(jLabelUnidades, null);
    contentPane.add(jLabelStock, null);
    contentPane.add(jTextStock, null);
    contentPane.add(jLabelPrecio, null);
    contentPane.add(jTextPrecio, null);
    contentPane.add(jLabelImporte, null);
    contentPane.add(jTextImporte, null);
    contentPane.add(jButtonFactura, null);
    contentPane.add(jButtonAceptar, null);
    contentPane.add(jButtonSalir, null);
    contentPane.add(jButtonCancelarPedido, null);
    contentPane.add(jButtonCancelarTodo, null);
  }// JBinit


  public VentanaPedidos(JFrame padre) {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      this.padre=padre;
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }// Constructor

  //Modificado para NO poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    /*super.processWindowEvent(e);
       if (e.getID() == WindowEvent.WINDOW_CLOSING) {
         System.exit(0);
       }*/
  }



////////////////////////////////////////////////////////////////////////////////
//////////////////  M É T O D O S   D E   L A   C L A S E  /////////////////////
////////////////////////////////////////////////////////////////////////////////

/*                            Métodos Utilizados:

   1. private void ConfiguraFormulario(int opcion,String titulo)
      Cambia los parámetros comunes para la gestión de proveedores o clientes

   2. private void CeroArriba()
   3. private void CeroAbajo()
   4. private void PonerACero()
      Pone "a cero" la parte de arriba, la parte de abajo, o ambas.

   5. private void Inicio()
      Llama a PonerACero(); y deshabilita TODOS los campos
      También eliminará todo del vector de las lineas de factura

   6. private void EscribeMensaje(String cadena1, String cadena2)
      Escribe un mensaje de advertencia o error al usuario

   7. private String Rellena(String cadena,int numerodeceros)
      Rellena con ceros una cadena por la izquierda

   8. private void MuestraCliente(String code, String tabla)
   9. private void MuestraCliente(Cliente cliente)
      Muestra un cliente/proveedor pasándole un código y una tabla o un cliente

  10. private void MuestraArticulo(String code)
  11. private void MuestraArticulo(Articulo articulo)
      Muestra un Artículo pasándole un artículo o su código

  12. private boolean RestaUnidades()
  13. private boolean SumaUnidades()
      Suma o resta Unidades al Stock de un artículo

  14. private void CalculaImporte()
      Calcula el importe e Unidades * Precio (de venta o compra según sea cli o prov)
*/




  // Método que configura el formulario según parámetros
  private void ConfiguraFormulario(int opcion,String titulo){

    // Damos el valor a la variable de clase 'opcion'
    this.opcion=opcion;

    // Deshabilitamos los menús de arriba
    jMenuPedidos.setEnabled(false);

    // Renombramos la Ventana
    this.setTitle("Gestión de Almacén - Pedidos -- "+titulo);

    // Habilitamos la caja Código
    jTextCodigo.setEditable(true);
    // Y le pasamos el foco
    jTextCodigo.grabFocus();

    // Activamos el botón Salir
    jButtonSalir.setEnabled(true);

    // Renombramos el Botón Finalizar / Factura
    if (opcion ==1)
      jButtonFactura.setText("Factura");

    else if (opcion == 2)
      jButtonFactura.setText("Finalizar");

  }// Fin de ConfiguraFormulario


  // Método que pone "A cero" la parte alta del formulario
  private void CeroArriba(){
    jTextCodigo.setText("");
    jTextApellidos.setText("");
    jTextFieldCP.setText("");
    jTextFieldDomicilio.setText("");
    jTextFieldLocalidad.setText("");
    jTextFieldVentas.setText("");
    jTextNIF.setText("");
    jTextNombre.setText("");
  }// Fin De CeroArriba


  // Método que pone "A cero" la parte baja del formulario
  private void CeroAbajo(){
    jTextArticulo.setText("");
    jTextDescripcion.setText("");
    jTextImporte.setText("");
    jTextPrecio.setText("");
    jTextStock.setText("");
    jTextUnidades.setText("");
  }// Fin de CeroAbajo


  // Método que restaura el texto del formulario
  private void PonerACero(){
    // Parte de Arriba
    CeroArriba();
    // Parte de Abajo
    CeroAbajo();
  }//Fin de PonerACero;


  // Todo deshabilitado y "a cero"
  private void Inicio(){
  PonerACero();
  jButtonAceptar.setEnabled(false);
  jButtonCancelarPedido.setEnabled(false);
  jButtonCancelarTodo.setEnabled(false);
  jButtonFactura.setEnabled(false);
  jButtonSalir.setEnabled(false);
  jTextArticulo.setEditable(false);
  jTextCodigo.setEditable(false);
  jTextUnidades.setEditable(false);
  jMenuPedidos.setEnabled(true);
  jButtonFactura.setText("F");
  // Renombramos la Ventana
  this.setTitle("Gestión de Almacén - Pedidos");

  // Y borramos el contenido del vector de artículos
  vLineas.removeAllElements();
  }


  // Método privado que recibe 2 cadenas de texto y genera una ventana de
  // error comprensible para el usuario
  private void EscribeMensaje(String cadena1, String cadena2){
    // Genramos la pantalla
    JOptionPane.showConfirmDialog(this, cadena2, cadena1,
                                  JOptionPane.CLOSED_OPTION);
  }//Fin de EscribeMensaje


  /*El siguiente método recibe una cadena y un número, y completa la cadena
    hasta ese número de cifras rellenándolo por la izquierda  */
  private String Rellena(String cadena,int numerodeceros){
    while (cadena.length() < numerodeceros)
      cadena="0"+cadena;     // Concatenación ;)
    return cadena;
  }// Fin de Rellena


  // Método que recibe un entero, se conecta a la base de datos, busca ese codigo
  // y muestra su configuración en el formulario
  private void MuestraCliente(String code, String tabla){
    MuestraCliente(conexion.BuscarCliente(code,tabla));
  }// Fin de MuestraConfiguracion


  private void MuestraCliente(Cliente cliente){
    jTextApellidos.setText(cliente.getApellidos());
    jTextFieldCP.setText(cliente.getCp());
    jTextFieldDomicilio.setText(cliente.getDomicilio());
    jTextFieldLocalidad.setText(cliente.getLocalidad());
    jTextNIF.setText(cliente.getNif());
    jTextNombre.setText(cliente.getNombre());
    jTextFieldVentas.setText(String.valueOf(cliente.getVentas()));
  }//MuestraCliente

  // Método que recibe un entero, se conecta a la base de datos, busca ese codigo
  // y muestra el artículo en el formulario
  private void MuestraArticulo(String code){
    MuestraArticulo(conexion.BuscarArticulo(code));
  }// Fin de MuestraConfiguracion


  private void MuestraArticulo(Articulo articulo){
    jTextArticulo.setText(articulo.getCodigo());
    jTextDescripcion.setText(articulo.getDescripcion());
    jTextStock.setText(String.valueOf(articulo.getStock()));

    // Si la opcion es un cliente
    if (opcion==1)
      jTextPrecio.setText(String.valueOf(articulo.getPrecioventa()));
    // Sin embargo, si es un proveedor
    else if (opcion==2)
      jTextPrecio.setText(String.valueOf(articulo.getPreciocompra()));

  }//MuestraCliente

  private boolean RestaUnidades(){

    boolean retorno = true;

    int stock = new Integer(jTextStock.getText()).intValue();
    int unida = new Integer(jTextUnidades.getText()).intValue();

    // Si se pueden restar unidades, las restamos
    if (stock >= unida && unida > 0)
      stock = stock - unida;

    // Si no, mensaje de error
    else{
      EscribeMensaje("Error", "No hay unidades suficientes");
      jTextUnidades.selectAll();
      jTextUnidades.grabFocus();
      retorno = false;
    }

    jTextStock.setText(String.valueOf(stock));

    return retorno;

  }// Fin de resta unidades

  private boolean SumaUnidades(){

    boolean retorno = true;

    int stock = new Integer(jTextStock.getText()).intValue();
    int unida = new Integer(jTextUnidades.getText()).intValue();

    // Si la Unidad es cero, error
    if (unida == 0){
    EscribeMensaje("Error","Las unidades han de ser mayores de 1");
    retorno = false;
    }

    stock = stock + unida;

    jTextStock.setText(String.valueOf(stock));

    return retorno;

  }// Fin de resta unidades


  // Método que calcula el importe total según los datos del formulario
  private void CalculaImporte(){

    float unidades = new Float(jTextUnidades.getText()).floatValue();
    float precio   = new Float(jTextPrecio.getText()).floatValue();

    float total = unidades * precio;

    jTextImporte.setText(String.valueOf(total));

  }


////////////////////////////////////////////////////////////////////////////////
//////////////  F I N  M É T O D O S   D E   L A   C L A S E  //////////////////
////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////
/////////////////////          A C C I O N E S          ////////////////////////
////////////////////////////////////////////////////////////////////////////////

  // Botón VOLVER
  void jMenuItemVolver_actionPerformed(ActionEvent e) {
      padre.setEnabled(true);
      this.dispose();
    }

  // Pedidos / Clientes
  void jMenuItemCliente_actionPerformed(ActionEvent e) {
    // Configuramos el formulario:
    ConfiguraFormulario(1,"Clientes");
  }

  // Pedidos / Proveedores
  void jMenuItemProveedor_actionPerformed(ActionEvent e) {
    // Configuramos el formulario:
    ConfiguraFormulario(2,"Proveedores");
  }

  //Botón Salir
  void jButtonSalir_actionPerformed(ActionEvent e) {

    // Deshacemos las modificaciones
    conexion.rollback();

    //Volvemos al Inicio
    Inicio();

    // Y desactivamos el Botón Salir, saliendo de todas las opciones
    jButtonSalir.setEnabled(false);
    opcion = 0;
  }// Botón Salir


  // INTRO DEL CÓDIGO
  void jTextCodigo_keyPressed(KeyEvent e) {

  // Si presiona Intro y la opcion no es 0:
  if (e.getKeyCode()==10 && opcion!=0){

    // Si la cadena no es numérica o su longi es > de 6 damos el error
    if (!jTextCodigo.getText().matches("[0-9]+") ||
        jTextCodigo.getText().length() > 6) {
      // Llamamos a una función que recibe tres Strings y genera un mensaje de Error
      EscribeMensaje( "Error", "El Código ha de ser numérico y de seis cifras");
      // Y situamos el cursor sobre el error. Ésta dinámica la seguiremos en todos
      jTextCodigo.grabFocus();
      jTextCodigo.selectAll();
    }

    // En caso contrario, que es numérica
    else { //Llamamos a la función rellena:
      jTextCodigo.setText(Rellena(jTextCodigo.getText(), 6));
      String code = jTextCodigo.getText();

      String tabla = new String();

      if (opcion == 1)
        tabla = "clientes";
      else if (opcion == 2)
        tabla = "proveedores";


      // Si encuentra el Cliente o el proveedor
      if (conexion.BuscarCliente(code,tabla).getCodigo() != null){
        // Primero que lo guarde en su variable
        cli = conexion.BuscarCliente(code,tabla);
        // que lo muestre
        MuestraCliente(code,tabla);
        // Deshabilita el Código
        jTextCodigo.setEditable(false);
        // Y habilita el código de producto, pasándole el foco
        jTextArticulo.setEditable(true);
        jTextArticulo.grabFocus();
        // Y habiliamos el Cancelar Todo
        jButtonCancelarTodo.setEnabled(true);

      }// Fin de que Exista el Cliente

      // si no lo encuentra
      else{
        // Llamamos a una función que recibe tres Strings y genera un mensaje de Error
        EscribeMensaje("Error", "Ese Código de "+tabla+" No existe");
      // Y situamos el cursor sobre el error.
      jTextCodigo.grabFocus();
      jTextCodigo.selectAll();
      }// Fin de que no encuentre Cliente

    }
  }

  }

  // KeyPressed del Artículo
  void jTextArticulo_keyPressed(KeyEvent e) {

    // Si presiona Intro y esamos en un opcion:
    if (e.getKeyCode()==10 && opcion != 0){

      // Si la cadena no es numérica o su longi es > de 6 damos el error
      if (!jTextArticulo.getText().matches("[0-9]+") ||
          jTextArticulo.getText().length() > 6) {
        // Llamamos a una función que recibe Strings y genera un mensaje de Error
        EscribeMensaje( "Error", "El Código ha de ser numérico y de seis cifras");
        // Y situamos el cursor sobre el error. Ésta dinámica la seguiremos en todos
        jTextArticulo.grabFocus();
        jTextArticulo.selectAll();
      }// if: cadena numérica


      // En caso contrario, que es numérica
      else { //Llamamos a la función rellena:

        jTextArticulo.setText(Rellena(jTextArticulo.getText(), 6));
        String code = jTextArticulo.getText();

        // Si encuentra el Artículo
        if (conexion.BuscarArticulo(code).getCodigo() != null){
          // que lo muestre
          MuestraArticulo(code);
          // Deshabilita el Código
          jTextArticulo.setEditable(false);
          // Habilitamos las unidades y le pasamos el foco
          jTextUnidades.setEditable(true);
          jTextUnidades.grabFocus();

          // Habilitamos el Botón CancelarPedido
          jButtonCancelarPedido.setEnabled(true);

        }// Fin de que Exista el Articulo

        // Si el artículo, sin embargo, no existe:
        else{
          EscribeMensaje( "Error", "Ese artículo o existe; revise el número");
          // Y situamos el cursor sobre el error. Ésta dinámica la seguiremos en todos
          jTextArticulo.grabFocus();
          jTextArticulo.selectAll();
        }// Fin de que no exista el artículo


      }// Else: cadena sí numérica


    }// Presionado del Enter

  }// Keypressed del artículo


  // KeyPressed de Unidades
  void jTextUnidades_keyPressed(KeyEvent e) {
    // Si presiona Intro:
    if (e.getKeyCode()==10){

      // Si la cadena no es numérica o su longi es > de 6 ó 0 damos el error
      if (!jTextUnidades.getText().matches("[0-9]+") ||
          jTextUnidades.getText().length() > 6 ||
          jTextUnidades.getText().length() == 0) {
        // Llamamos a una función que recibe tres Strings y genera un mensaje de Error
        EscribeMensaje( "Error", "Las unidades han de ser numéricas y de seis cifras");
        // Y situamos el cursor sobre el error. Ésta dinámica la seguiremos en todos
        jTextUnidades.grabFocus();
        jTextUnidades.selectAll();
      }// if: cadena numérica


      // En caso contrario, que es numérica
      else {

        // En ella guardaremos si la suma o resta ha sido efectuada con éxito
        boolean op = true;

        // Si es Clientes
        if (opcion == 1)
          op = RestaUnidades();

        // Sin embargo, si en proveedor
        else if (opcion ==2)
          op = SumaUnidades();


        // Si la suma o la resta salió Bien
        if (op == true){

          // Calculamos el Importe
          CalculaImporte();

          // Deshabilitamos la caja de Unidades
          jTextUnidades.setEditable(false);
          // Y habilitamos el Botón Aceptar
          jButtonAceptar.setEnabled(true);
          // El foco a Aceptar
          jButtonAceptar.grabFocus();
        }// fi

      }//else
  }// introa
}// KeyPressed de Unidades

  void jButtonCancelarPedido_actionPerformed(ActionEvent e) {
    // Ponemos "a cero" el Pedido
    jTextArticulo.setText("");
    jTextUnidades.setText("");
    jTextDescripcion.setText("");
    jTextStock.setText("");
    jTextPrecio.setText("");
    jTextImporte.setText("");
    // deshabilitamos este botón y las unidades
    jButtonCancelarPedido.setEnabled(false);
    jTextUnidades.setEditable(false);
    // Deshabilitando también el botón Aceptar
    jButtonAceptar.setEnabled(false);
    // Y habilitamos Artículo y le pasamos el Foco:
    jTextArticulo.setEditable(true);
    jTextArticulo.grabFocus();
  }

  void jButtonAceptar_actionPerformed(ActionEvent e) {
    // Hacemos el UPDATE de la tabla articulos, para lo cual primero guardamos el cliente
    // y luego se lo pasamos a la sentencia UPDATE:
    int estock = new Integer (jTextStock.getText()).intValue();

    Articulo art = new Articulo(jTextArticulo.getText(),estock);
    conexion.ModificaArticulo(art);

    // Aquí guardaremos una P para Proveedores y una C para Clientes; en principio será P
    String cp = "p";

    // Si es un cliente
    if (opcion == 1){
      conexion.SumaVentas(jTextCodigo.getText(), jTextImporte.getText(),"clientes");

      // Actualizamos el TotalVentas, dependiendo de si es cliente o proveedor
      jTextFieldVentas.setText(String.valueOf
                               (conexion.BuscarCliente(jTextCodigo.getText(),"clientes").getVentas()));


      // Añadimos el artículo al Vector de Lineas
      int unidad = new Integer(jTextUnidades.getText()).intValue();
      float precio = new Float(jTextPrecio.getText()).floatValue();
      LineaFactura line = new LineaFactura(jTextDescripcion.getText(),unidad,precio);
      vLineas.addElement(line);

      // La variable es, pues, C
      cp = "c";
    }

    // Si es un proveedor
    else if (opcion == 2){
      conexion.SumaVentas(jTextCodigo.getText(), jTextImporte.getText(),"proveedores");

      // Actualizamos el TotalVentas, dependiendo de si es cliente o proveedor
      jTextFieldVentas.setText
          (String.valueOf(conexion.BuscarCliente(jTextCodigo.getText(),"proveedores").getVentas()));

    }


    // Cargamos la fecha del Sistema
    /* La siguiente instrucción coge la fecha del sistema. Indico el paquete de la
      clase Date() que utilizo para que no se confunda entre la clase Date() del
        paquete java.sql y la clase Date() del paquete java.util. */

    java.sql.Date fechaSistema = new java.sql.Date( (new java.util.Date()).getTime());

    /* Convierto la fecha del sistema a String en el formato dd-mm-aaaa. */
    String fecha = String.valueOf(fechaSistema);
    String fecha1 = fecha.substring(8, 10);
    fecha1 = fecha1 + "/" +fecha.substring(5, 7);
    fecha1 = fecha1 + "/" + fecha.substring(0, 4);

    // Grabamos la tabla Histórica
    conexion.Historifica(cp+jTextCodigo.getText(),jTextArticulo.getText(),jTextUnidades.getText(),fecha1);


    // Deshabilitamos Aceptar y Cancelar Pedido
    jButtonAceptar.setEnabled(false);
    jButtonCancelarPedido.setEnabled(false);
    // Habilitamos Factura y Cancelar Todo
    jButtonFactura.setEnabled(true);
    jButtonCancelarTodo.setEnabled(true);
    // Dehabilitamos Unidades
    jTextUnidades.setEditable(false);
    // Habilitamos Artículo y le pasamos el foco
    jTextArticulo.setEditable(true);
    jTextArticulo.grabFocus();
    // Borramos la parte de abajo:
    CeroAbajo();

      }

  void jButtonFactura_actionPerformed(ActionEvent e) {
    // Guardamos
    conexion.commit();

    // Volvemos al Inicio
    Inicio();

    // Imprimimos la Factura si es un cliente
    if (opcion == 1){
      Imprimir i = new Imprimir();
      Fichero file = new Fichero();
      i.ImprimeFactura(vLineas,cli,file.NumeroDeFactura(),miempresa);
    }

  }

  void jButtonCancelarTodo_actionPerformed(ActionEvent e) {
    // Borramos todo
    conexion.rollback();

    // Ponemos todo en blanco, deshabilitando
    PonerACero();
    jTextArticulo.setEditable(false);
    jTextUnidades.setEditable(false);

    jButtonFactura.setEnabled(false);
    jButtonCancelarPedido.setEnabled(false);
    jButtonCancelarTodo.setEnabled(false);
    jButtonAceptar.setEnabled(false);

    jTextCodigo.setEditable(true);
    jTextCodigo.grabFocus();

    // Y borramos el contenido del vector de artículos
    vLineas.removeAllElements();
  }////CancelarTodo


////////////////////////////////////////////////////////////////////////////////
//////////////////        F I N   A C C I O N E S          /////////////////////
////////////////////////////////////////////////////////////////////////////////

}//class

class VentanaPedidos_jMenuItemVolver_actionAdapter implements java.awt.event.ActionListener {
  VentanaPedidos adaptee;

  VentanaPedidos_jMenuItemVolver_actionAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemVolver_actionPerformed(e);
  }
}

class VentanaPedidos_jMenuItemCliente_actionAdapter implements java.awt.event.ActionListener {
  VentanaPedidos adaptee;

  VentanaPedidos_jMenuItemCliente_actionAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemCliente_actionPerformed(e);
  }
}

class VentanaPedidos_jMenuItemProveedor_actionAdapter implements java.awt.event.ActionListener {
  VentanaPedidos adaptee;

  VentanaPedidos_jMenuItemProveedor_actionAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemProveedor_actionPerformed(e);
  }
}

class VentanaPedidos_jButtonSalir_actionAdapter implements java.awt.event.ActionListener {
  VentanaPedidos adaptee;

  VentanaPedidos_jButtonSalir_actionAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonSalir_actionPerformed(e);
  }
}

class VentanaPedidos_jTextCodigo_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaPedidos adaptee;

  VentanaPedidos_jTextCodigo_keyAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextCodigo_keyPressed(e);
  }
}

class VentanaPedidos_jTextArticulo_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaPedidos adaptee;

  VentanaPedidos_jTextArticulo_keyAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextArticulo_keyPressed(e);
  }
}

class VentanaPedidos_jTextUnidades_keyAdapter extends java.awt.event.KeyAdapter {
  VentanaPedidos adaptee;

  VentanaPedidos_jTextUnidades_keyAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.jTextUnidades_keyPressed(e);
  }
}

class VentanaPedidos_jButtonCancelarPedido_actionAdapter implements java.awt.event.ActionListener {
  VentanaPedidos adaptee;

  VentanaPedidos_jButtonCancelarPedido_actionAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonCancelarPedido_actionPerformed(e);
  }
}

class VentanaPedidos_jButtonAceptar_actionAdapter implements java.awt.event.ActionListener {
  VentanaPedidos adaptee;

  VentanaPedidos_jButtonAceptar_actionAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonAceptar_actionPerformed(e);
  }
}

class VentanaPedidos_jButtonFactura_actionAdapter implements java.awt.event.ActionListener {
  VentanaPedidos adaptee;

  VentanaPedidos_jButtonFactura_actionAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonFactura_actionPerformed(e);
  }
}

class VentanaPedidos_jButtonCancelarTodo_actionAdapter implements java.awt.event.ActionListener {
  VentanaPedidos adaptee;

  VentanaPedidos_jButtonCancelarTodo_actionAdapter(VentanaPedidos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonCancelarTodo_actionPerformed(e);
  }
}
