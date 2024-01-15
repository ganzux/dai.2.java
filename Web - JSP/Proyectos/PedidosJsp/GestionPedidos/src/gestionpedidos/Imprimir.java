package gestionpedidos;
import java.awt.*;
import java.util.Vector;
import javax.swing.*;

/**
 * <p>Título: Imprimir</p>
 * <p>Descripción: Clase que, de momento, permite imprimir los datos de clientes</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.8
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalización: 26 / XI / 2006
 */
public class Imprimir extends JFrame {

  // Atributos
  private int numLinea = 0;

  // Objeto de clase de tipo Frame
  Frame frm = new Frame("");
  // Objeto de tipo gestorBD
  GestorBD gestor = new GestorBD();

  // Constructor para la factura
  public Imprimir(){
  }

  // Construcor para el formulario
  public Imprimir(String cadena,int cuadricula) {

    ImprimeClientes(cadena,cuadricula);


  }

  public void Cabecera(int numPagina, Graphics PapelImpresora,String titulo,String orden) {

    /* La siguiente instrucción coge la fecha del sistema. Indico el paquete de la
     clase Date() que utilizo para que no se confunda entre la clase Date() del
       paquete java.sql y la clase Date() del paquete java.util. */

    java.sql.Date fechaSistema = new java.sql.Date( (new java.util.Date()).getTime());

    /* Convierto la fecha del sistema a String para imprimirla y le doy la vuelta
       para que se imprima en el formato dd-mm-aaaa. */
    String fecha = String.valueOf(fechaSistema);
    String fecha1 = fecha.substring(8, 10);
    fecha1 = fecha1 + "/" +fecha.substring(5, 7);
    fecha1 = fecha1 + "/" + fecha.substring(0, 4);

    // Ubicamos la fecha a la izquierda
    PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
    PapelImpresora.drawString("Fecha: " + fecha1, 20, numLinea);

    // Número de la página
    PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
    PapelImpresora.drawString("Página: " + numPagina, 520, numLinea);

    // Título
    PapelImpresora.setFont(new Font("courier", Font.BOLD, 12));
    PapelImpresora.drawString("LISTADO DE "+titulo+" ORDENADOS POR "+orden.toUpperCase(), 160,
                              numLinea+=20);

    // Si lo queremos ordenar por código, lo pondremos el primero
    if (orden.toUpperCase().compareTo("CODIGO")==0){
      // Campos
      PapelImpresora.setFont(new Font("courier", Font.BOLD, 5));
      PapelImpresora.drawString("Código", 20, numLinea += 20);
      PapelImpresora.setFont(new Font("courier", Font.PLAIN, 5));
      PapelImpresora.drawString("Apellidos", 43, numLinea);
      PapelImpresora.drawString("Nombre", 137, numLinea);
    }// Si era codigo

    // Sin embargo, si lo queríamos ordenar por apellidos
    else if (orden.toUpperCase().compareTo("APELLIDOS")==0){
      // Campos
      PapelImpresora.setFont(new Font("courier", Font.BOLD, 5));
      PapelImpresora.drawString("Apellidos", 20, numLinea+=20);
      PapelImpresora.setFont(new Font("courier", Font.PLAIN, 5));
      PapelImpresora.drawString("Nombre", 115, numLinea);
      PapelImpresora.drawString("Código", 162, numLinea);
    }// Si era por apellidos

    // rESTO DE LA CABECERa
    PapelImpresora.drawString("Domicilio", 187, numLinea);
    PapelImpresora.drawString("C.P.", 312, numLinea);
    PapelImpresora.drawString("Localidad", 335, numLinea);
    PapelImpresora.drawString("Teléfono", 400, numLinea);
    PapelImpresora.drawString("Móvil", 433, numLinea);
    PapelImpresora.drawString("Fax", 467, numLinea);
    PapelImpresora.drawString("e-mail", 503, numLinea);
    PapelImpresora.setFont(new Font("courier", Font.BOLD, 5));
    numLinea += 10;

    PapelImpresora.drawRect(18,61,550,13);

    PapelImpresora.setFont(new Font("courier", Font.PLAIN, 5));
  } // Fin de la cabecera


  // Método privado que recibe 2 cadenas de texto y genera una ventana de
  // error comprensible para el usuario
  private void EscribeMensaje(String cadena1, String cadena2){
  // Genramos la pantalla
  JOptionPane.showConfirmDialog(this, cadena2, cadena1,
                                JOptionPane.CLOSED_OPTION);
}//Fin de EscribeMensaje


  public void ImprimeClientes(String cadena,int cuadricula) {
    // Creamos un cliente vacío
    Cliente cli = new Cliente();
    // y un vector donde volcamos todos los clientes ordenados por la cadena
    Vector vClientes = gestor.BuscarTodosLosClientes(cadena);

    // Caso 1 : NO HAY CLIENTES PARA IMPRIMIR
    if (vClientes.size() == 0)
      EscribeMensaje("Gestión de Artículos","No hay clientes para imprimir");

    // Caso 2: SÍ HAY CLIENTES PARA IMPRIMIR
    else {
      // Sacamos la ventana de impresión
      PrintJob TrabajoImpresion = frm.getToolkit().
          getPrintJob(frm, "", null);

      /* La instrucción anterior abre el cuadro de diálogo de imprimir. Si en
         este cuadro se pulsa el botón Cancelar, al crear el objeto Graphics
         se produce una excepción. Cuando se pulsa el botón Cancelar en el
         cuadro de diálogo de imprimir, el objeto PrintJob devuelve el valor
         null. Al preguntar por el valor null evitamos que se produzca la
         excepción mencionada. */

      if (TrabajoImpresion != null) {
        Graphics PapelImpresora = TrabajoImpresion.getGraphics();
        int numPagina = 1;
        numLinea = 30;
        Cabecera(numPagina, PapelImpresora,"CLIENTES",cadena.toUpperCase());
        int i = 0;
        while (i < vClientes.size()) {
          cli = (Cliente) vClientes.elementAt(i);

          // Si el orden era por codigo
          if (cadena.toUpperCase().compareTo("CODIGO") == 0) {
            PapelImpresora.drawString(cli.getCodigo(), 20, numLinea += 20);
            PapelImpresora.drawString(cli.getApellidos(), 43, numLinea);
            PapelImpresora.drawString(cli.getNombre(), 137, numLinea);
          } //Fin del ordenamiento por código

          // Sin embargo, si era por apellidos
          else if (cadena.toUpperCase().compareTo("APELLIDOS") == 0) {
            PapelImpresora.drawString(cli.getApellidos(), 20, numLinea += 20);
            PapelImpresora.drawString(cli.getNombre(), 115, numLinea);
            PapelImpresora.drawString(cli.getCodigo(), 162, numLinea);
          }

          // Imprimimos el resto de los campos:

          PapelImpresora.drawString(cli.getDomicilio(), 187, numLinea);
          PapelImpresora.drawString(cli.getCp(), 312, numLinea);
          PapelImpresora.drawString(cli.getLocalidad(), 335, numLinea);
          PapelImpresora.drawString(cli.getTelefono(), 400, numLinea);
          PapelImpresora.drawString(cli.getMovil(), 433, numLinea);
          PapelImpresora.drawString(cli.getFax(), 467, numLinea);
          PapelImpresora.drawString(cli.getEmail(), 503, numLinea);

          i++;

          // Las siguientes instrucciones generan la cuadrícula en caso de haberlo dicho
          // con el parámetro correspondiente (cuadricula = 0)
          if (cuadricula==0){
            // Si el orden primario es campo, apellidos, nombre
            if (cadena.toUpperCase().compareTo("CODIGO") == 0) {
              PapelImpresora.drawRect(18, numLinea - 11, 22, 20);  // Código
              PapelImpresora.drawRect(18, numLinea - 11, 117, 20); // Apellidos
              PapelImpresora.drawRect(18, numLinea - 11, 166, 20); // Nombre
            }

            // Sin embargo, si lo ordenamos por Apellidos
            else if (cadena.toUpperCase().compareTo("APELLIDOS") == 0) {
              PapelImpresora.drawRect(18, numLinea - 11, 95, 20); // Apellidos
              PapelImpresora.drawRect(18, numLinea - 11, 143, 20); // Nombre
              PapelImpresora.drawRect(18, numLinea - 11, 166, 20);  // Código
            }

            // Ahora los comunes
            PapelImpresora.drawRect(18, numLinea - 11, 292, 20); // Domicilio
            PapelImpresora.drawRect(18, numLinea - 11, 314, 20); // C.P.
            PapelImpresora.drawRect(18, numLinea - 11, 380, 20); // Localidad
            PapelImpresora.drawRect(18, numLinea - 11, 413, 20); // telefono
            PapelImpresora.drawRect(18, numLinea - 11, 446, 20); // movil
            PapelImpresora.drawRect(18, numLinea - 11, 482, 20); // fax
            PapelImpresora.drawRect(18, numLinea - 11, 550, 20); // email
          }// Fin de que se imprima la cuadrícula


          /* Imprimo la página representada por PapelImpresora con el método
             dispose(). Vuelvo a crear el objeto PapelImpresora y, de esta
           forma, se imprime la página en la impresora. Cuando salgo del bucle
             realizo la misma operación porque si no vuelvo a crear el objeto
             PapelImpresora no se imprime la última página, aunque ejecute el
             método end() o el método finalice() del objeto TrabajoImpresión.
             No sé por qué ocurre esto. */

          if (numLinea > 770) {
            PapelImpresora.dispose();
            PapelImpresora = TrabajoImpresion.getGraphics();
            numPagina += 1;
            numLinea = 30;
            Cabecera(numPagina, PapelImpresora,"CLIENTES",cadena.toUpperCase());
          }
        }


        // Imprimo la última página.

        PapelImpresora.dispose();
        PapelImpresora = TrabajoImpresion.getGraphics();

        /* El trabajo de impresión se imprime. Si no se ejecuta el método end(),
           el trabajo de impresión se imprime cuando se finaliza la ejecución
           del proyecto. */

        TrabajoImpresion.end();

      }// Fin del botón IMPRIMIR en el cuadro de diáloo de Windows
    }// Fin del else, que sí existan Clientes
  }// Fin de ImprimeClientes



////////////////////////////////////////////////////////////////////////////////
////////////////////////                                   /////////////////////
////////////////////////         ZONA DE FACTURAS          /////////////////////
////////////////////////                                   /////////////////////
////////////////////////////////////////////////////////////////////////////////


  // Cabecera para las Facturas
  public void CabeceraFacturas(int numPagina, Graphics PapelImpresora,Cliente emp,Cliente cli, String num_fac) {

  /* La siguiente instrucción coge la fecha del sistema. Indico el paquete de la
   clase Date() que utilizo para que no se confunda entre la clase Date() del
     paquete java.sql y la clase Date() del paquete java.util. */

  java.sql.Date fechaSistema = new java.sql.Date( (new java.util.Date()).getTime());

  /* Convierto la fecha del sistema a String para imprimirla y le doy la vuelta
     para que se imprima en el formato dd-mm-aaaa. */
  String fecha = String.valueOf(fechaSistema);
  String fecha1 = fecha.substring(8, 10);
  fecha1 = fecha1 + "/" +fecha.substring(5, 7);
  fecha1 = fecha1 + "/" + fecha.substring(0, 4);

  // Ponemos el nombre de la empresa y su nif
  PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
  PapelImpresora.drawString("Empresa: "+emp.getNombre(), 20, numLinea);
  PapelImpresora.drawString("CIF: "+emp.getNif(), 400, numLinea);

  numLinea += 20;

  // Dirección de la empresa y teléfono
  PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
  PapelImpresora.drawString("Domicilio: "+emp.getDomicilio(), 20, numLinea);
  PapelImpresora.drawString("Teléfono: "+emp.getTelefono(), 400, numLinea);

  numLinea += 20;

  // Localidad y Movil
  PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
  PapelImpresora.drawString("Localidad: "+emp.getLocalidad(), 20, numLinea);
  PapelImpresora.drawString("Movil: "+emp.getMovil(), 400, numLinea);

  numLinea += 20;

  // C.P. y Fax
  PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
  PapelImpresora.drawString("C.P. : "+emp.getCp(), 20, numLinea);
  PapelImpresora.drawString("Fax: "+emp.getFax(), 400, numLinea);

  numLinea += 20;

  // Mail y WEb
  PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
  PapelImpresora.drawString("e-mail : "+emp.getEmail(), 20, numLinea);
  PapelImpresora.drawString("Página WEB: WWW.AlVaRiTo.NeT", 400, numLinea);

  numLinea += 35;

  // Ubicamos la fecha a la izquierda
  PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
  PapelImpresora.drawString("Fecha: " + fecha1, 20, numLinea);

  // Y el número de factura a la derecha
  PapelImpresora.drawString("Factura Número: " +num_fac , 400, numLinea);

  numLinea +=20;

  // Número de la página
  PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
  PapelImpresora.drawString("Página: " + numPagina, 400, numLinea);

  // rESTO DE LA CABECERa
  PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
  numLinea +=25;
  PapelImpresora.drawString("Cliente: "+cli.getCodigo(), 75, numLinea);
  numLinea +=17;
  PapelImpresora.drawString("N.I.F.: "+cli.getNif(), 75, numLinea);
  PapelImpresora.drawString("Dirección: "+cli.getDomicilio(),300, numLinea);
  numLinea +=17;
  PapelImpresora.drawString("Nombre: "+cli.getApellidos()+", "+cli.getNombre(), 75, numLinea);
  PapelImpresora.drawString("Localidad : "+cli.getLocalidad()+", "+cli.getCp(),300, numLinea);
  numLinea += 35;

  PapelImpresora.drawString("Artículo",125,numLinea);
  PapelImpresora.drawString("Unidades",275,numLinea);
  PapelImpresora.drawString("Precio",350,numLinea);
  PapelImpresora.drawString("Importe",425,numLinea);

  numLinea += 25;
  PapelImpresora.setFont(new Font("courier", Font.PLAIN, 10));
} // Fin de la cabecera de la factura


// Función que recibe una cadena y un entero, y devuelve una cadena que cortará por la izquierda
// hasta tantas cifras como enteros a partir del punto
  private String decimal (String cadena, int num){

    // Inicializamos retorno
    String retorno="0.0";

    // posicion será el carácter donde encontrmos el punto
    int posicion = cadena.indexOf( "." );

    // Si la longitud de la cadena es mayor o igual que posicion+num+1
    if (cadena.length() >= posicion+num+1)
      // damos a retorno la subcadena desde la pos 0 hasta posicion+num+1(q coja 2 decimales)
      retorno = cadena.substring(0,posicion+num+1);
    // Si por el contrario es menor
    else
      retorno = cadena;


    // retornamos retorno
    return retorno;
  }// Fin de decimal


  // Funcion que recibe un float e imprime el total de las ventas
  private void ImprimeTotal(Graphics PapelImpresora, float total, int numLinea){
    String tot = String.valueOf(total*1.07);
    tot = decimal (tot,2);
    PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
    PapelImpresora.drawString("Total Factura (7% I.V.A. Incluído): "+tot,350,numLinea+25);

  }// Fin de Imprime Total


  // El Siguiente método emite una factura, habiéndole pasado un vector de Lineas de Artículos
  public void ImprimeFactura(Vector vLineas,Cliente cli,String num_fac, Cliente emp){

  float total =0;

  // Caso 1 : NO HAY ARTÍCULOS PARA IMPRIMIR
  if (vLineas.size() == 0)
    EscribeMensaje("Gestión de Artículos","No hay artículos para imprimir");

  // Caso 2: SÍ HAY ARTÍCULOS PARA IMPRIMIR
  else {
    // Sacamos la ventana de impresión
    PrintJob TrabajoImpresion = frm.getToolkit().
        getPrintJob(frm, "", null);

    /* La instrucción anterior abre el cuadro de diálogo de imprimir. Si en
       este cuadro se pulsa el botón Cancelar, al crear el objeto Graphics
       se produce una excepción. Cuando se pulsa el botón Cancelar en el
       cuadro de diálogo de imprimir, el objeto PrintJob devuelve el valor
       null. Al preguntar por el valor null evitamos que se produzca la
       excepción mencionada. */

    if (TrabajoImpresion != null) {
      Graphics PapelImpresora = TrabajoImpresion.getGraphics();
      int numPagina = 1;
      numLinea =30;
      CabeceraFacturas(numPagina, PapelImpresora,emp,cli,num_fac);

      LineaFactura line = new LineaFactura();

      int i = 0;

      while (i < vLineas.size()) {
        line = (LineaFactura) vLineas.elementAt(i);
        // Imprimimos los campos:
        PapelImpresora.drawString(line.getArticulo(),125,numLinea);
        PapelImpresora.drawString(line.StringDeUnidades(),275,numLinea);
        PapelImpresora.drawString(line.StringDePrecio(),350,numLinea);
        PapelImpresora.drawString(line.StringDeImporte(),425,numLinea);

        // Guardamos el importe total en una variable temporal
        total = total + line.IntDeImporte();

        numLinea += 25;

        i++;

        /* Imprimo la página representada por PapelImpresora con el método
           dispose(). Vuelvo a crear el objeto PapelImpresora y, de esta
         forma, se imprime la página en la impresora. Cuando salgo del bucle
           realizo la misma operación porque si no vuelvo a crear el objeto
           PapelImpresora no se imprime la última página, aunque ejecute el
           método end() o el método finalice() del objeto TrabajoImpresión.
           No sé por qué ocurre esto. */

        if (numLinea > 770) {
          PapelImpresora.dispose();
          PapelImpresora = TrabajoImpresion.getGraphics();
          numPagina += 1;
          numLinea = 30;
          CabeceraFacturas(numPagina, PapelImpresora,emp,cli,num_fac);
        }
      }

      // Imprimimos el Total de las Ventas
      ImprimeTotal(PapelImpresora,total,numLinea);

      // Imprimo la última página.

      PapelImpresora.dispose();
      PapelImpresora = TrabajoImpresion.getGraphics();

      /* El trabajo de impresión se imprime. Si no se ejecuta el método end(),
         el trabajo de impresión se imprime cuando se finaliza la ejecución
         del proyecto. */

      TrabajoImpresion.end();

    }// Fin del botón IMPRIMIR en el cuadro de diáloo de Windows
  }// Fin del else, que sí existan Clientes


  }// Fin de ImprimeFactura


}// Fin de la clase
