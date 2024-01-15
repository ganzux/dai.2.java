package gestionalmacen;
import java.awt.*;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>T�tulo: Imprimir</p>
 * <p>Descripci�n: Clase que, de momento, permite imprimir los datos de clientes</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.0
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalizaci�n: 14 / XI / 2006
 */
public class Imprimir extends JFrame {

  // Atributos
  private int numLinea = 0;

  // Objeto de clase de tipo Frame
  Frame frm = new Frame("");
  // Objeto de tipo gestorBD
  GestorBD gestor = new GestorBD();

  // Constructor
  public Imprimir(String cadena,int cuadricula) {

    ImprimeClientes(cadena,cuadricula);


  }

  public void Cabecera(int numPagina, Graphics PapelImpresora,String titulo,String orden) {

    /* La siguiente instrucci�n coge la fecha del sistema. Indico el paquete de la
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

    // N�mero de la p�gina
    PapelImpresora.setFont(new Font("courier", Font.BOLD, 10));
    PapelImpresora.drawString("P�gina: " + numPagina, 520, numLinea);

    // T�tulo
    PapelImpresora.setFont(new Font("courier", Font.BOLD, 12));
    PapelImpresora.drawString("LISTADO DE "+titulo+" ORDENADOS POR "+orden.toUpperCase(), 160,
                              numLinea+=20);

    // Si lo queremos ordenar por c�digo, lo pondremos el primero
    if (orden.toUpperCase().compareTo("CODIGO")==0){
      // Campos
      PapelImpresora.setFont(new Font("courier", Font.BOLD, 5));
      PapelImpresora.drawString("C�digo", 20, numLinea += 20);
      PapelImpresora.setFont(new Font("courier", Font.PLAIN, 5));
      PapelImpresora.drawString("Apellidos", 43, numLinea);
      PapelImpresora.drawString("Nombre", 137, numLinea);
    }// Si era codigo

    // Sin embargo, si lo quer�amos ordenar por apellidos
    else if (orden.toUpperCase().compareTo("APELLIDOS")==0){
      // Campos
      PapelImpresora.setFont(new Font("courier", Font.BOLD, 5));
      PapelImpresora.drawString("Apellidos", 20, numLinea+=20);
      PapelImpresora.setFont(new Font("courier", Font.PLAIN, 5));
      PapelImpresora.drawString("Nombre", 115, numLinea);
      PapelImpresora.drawString("C�digo", 162, numLinea);
    }// Si era por apellidos

    // rESTO DE LA CABECERa
    PapelImpresora.drawString("Domicilio", 187, numLinea);
    PapelImpresora.drawString("C.P.", 312, numLinea);
    PapelImpresora.drawString("Localidad", 335, numLinea);
    PapelImpresora.drawString("Tel�fono", 400, numLinea);
    PapelImpresora.drawString("M�vil", 433, numLinea);
    PapelImpresora.drawString("Fax", 467, numLinea);
    PapelImpresora.drawString("e-mail", 503, numLinea);
    PapelImpresora.setFont(new Font("courier", Font.BOLD, 5));
    numLinea += 10;

    PapelImpresora.drawRect(18,61,550,13);

    PapelImpresora.setFont(new Font("courier", Font.PLAIN, 5));
  } // Fin de la cabecera


  // M�todo privado que recibe 2 cadenas de texto y genera una ventana de
  // error comprensible para el usuario
  private void EscribeMensaje(String cadena1, String cadena2){
  // Genramos la pantalla
  JOptionPane.showConfirmDialog(this, cadena2, cadena1,
                                JOptionPane.CLOSED_OPTION);
}//Fin de EscribeMensaje


  public void ImprimeClientes(String cadena,int cuadricula) {
    // Creamos un cliente vac�o
    Cliente cli = new Cliente();
    // y un vector donde volcamos todos los clientes ordenados por la cadena
    Vector vClientes = gestor.BuscarTodosLosClientes(cadena);

    // Caso 1 : NO HAY CLIENTES PARA IMPRIMIR
    if (vClientes.size() == 0)
      EscribeMensaje("Gesti�n de Art�culos","No hay clientes para imprimir");

    // Caso 2: S� HAY CLIENTES PARA IMPRIMIR
    else {
      // Sacamos la ventana de impresi�n
      PrintJob TrabajoImpresion = frm.getToolkit().
          getPrintJob(frm, "", null);

      /* La instrucci�n anterior abre el cuadro de di�logo de imprimir. Si en
         este cuadro se pulsa el bot�n Cancelar, al crear el objeto Graphics
         se produce una excepci�n. Cuando se pulsa el bot�n Cancelar en el
         cuadro de di�logo de imprimir, el objeto PrintJob devuelve el valor
         null. Al preguntar por el valor null evitamos que se produzca la
         excepci�n mencionada. */

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
          } //Fin del ordenamiento por c�digo

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

          // Las siguientes instrucciones generan la cuadr�cula en caso de haberlo dicho
          // con el par�metro correspondiente (cuadricula = 0)
          if (cuadricula==0){
            // Si el orden primario es campo, apellidos, nombre
            if (cadena.toUpperCase().compareTo("CODIGO") == 0) {
              PapelImpresora.drawRect(18, numLinea - 11, 22, 20);  // C�digo
              PapelImpresora.drawRect(18, numLinea - 11, 117, 20); // Apellidos
              PapelImpresora.drawRect(18, numLinea - 11, 166, 20); // Nombre
            }

            // Sin embargo, si lo ordenamos por Apellidos
            else if (cadena.toUpperCase().compareTo("APELLIDOS") == 0) {
              PapelImpresora.drawRect(18, numLinea - 11, 95, 20); // Apellidos
              PapelImpresora.drawRect(18, numLinea - 11, 143, 20); // Nombre
              PapelImpresora.drawRect(18, numLinea - 11, 166, 20);  // C�digo
            }

            // Ahora los comunes
            PapelImpresora.drawRect(18, numLinea - 11, 292, 20); // Domicilio
            PapelImpresora.drawRect(18, numLinea - 11, 314, 20); // C.P.
            PapelImpresora.drawRect(18, numLinea - 11, 380, 20); // Localidad
            PapelImpresora.drawRect(18, numLinea - 11, 413, 20); // telefono
            PapelImpresora.drawRect(18, numLinea - 11, 446, 20); // movil
            PapelImpresora.drawRect(18, numLinea - 11, 482, 20); // fax
            PapelImpresora.drawRect(18, numLinea - 11, 550, 20); // email
          }// Fin de que se imprima la cuadr�cula


          /* Imprimo la p�gina representada por PapelImpresora con el m�todo
             dispose(). Vuelvo a crear el objeto PapelImpresora y, de esta
           forma, se imprime la p�gina en la impresora. Cuando salgo del bucle
             realizo la misma operaci�n porque si no vuelvo a crear el objeto
             PapelImpresora no se imprime la �ltima p�gina, aunque ejecute el
             m�todo end() o el m�todo finalice() del objeto TrabajoImpresi�n.
             No s� por qu� ocurre esto. */

          if (numLinea > 770) {
            PapelImpresora.dispose();
            PapelImpresora = TrabajoImpresion.getGraphics();
            numPagina += 1;
            numLinea = 30;
            Cabecera(numPagina, PapelImpresora,"CLIENTES",cadena.toUpperCase());
          }
        }


        // Imprimo la �ltima p�gina.

        PapelImpresora.dispose();
        PapelImpresora = TrabajoImpresion.getGraphics();

        /* El trabajo de impresi�n se imprime. Si no se ejecuta el m�todo end(),
           el trabajo de impresi�n se imprime cuando se finaliza la ejecuci�n
           del proyecto. */

        TrabajoImpresion.end();

      }// Fin del bot�n IMPRIMIR en el cuadro de di�loo de Windows
    }// Fin del else, que s� existan Clientes
  }// Fin de ImprimeClientes
}// Fin de la clase
