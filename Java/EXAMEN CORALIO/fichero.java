/*
	                   ÁLVARO ALCEDO MORENO   2º D.A.I.

Clase Fichero:  En esta clase tenemos 4 métodos y un atributo
· El vector almacenará los clientes que borremos. He decidido hacerlo así para no tener tanto código
y poder usar el mismo método para el fichero de errores y el de borrados.

· Constructor Fichero vacío.

· Méstodo EscribeMensaje

· Método void LeeClientes():
	El método realizará una conexión a la base de datos por medio de la clase GestorBD
	y abrirá el fichero "movimientos.dat" para lectura. Los datos del fichero los volcará
	en un objeto de la clase Cliente, hasta que llegue al último campo, de tipo texto, donde
	evaluará su contenido (IF) .
	- Si es una A, dará de alta al cliente
	- Si es una B, lo dará de baja y llamará al Método Graba
	- Si es una C, lo modificará.
	Si el fichero no existe, dará un mensaje de error al usuario, mediante el método EscribeMensaje
	Cuando termina de leer el fichero, graba los errores producidos en un fichero, llamando al Método Graba

· Método void Graba(Vector clientes,String nombre,boolean opcion):
	El método Graba el fichero de Errores y borrados; le pasaremos un Vector de clientes, donde estará
	almacenado o bien todos los clientes que dieron error, o bien el cliente que se dio de baja; también le pasaremos
	el nombre del fichero y un valor booleano, para el modo append o no.
	
	El proceso comienza abriendo el fichero "nombre" en modo escritura; según la opción que le pasemos
	se abrirá en modo append o no; si es el fichero de errores, el modo le pasaremos FALSE, por lo que siempre
	se creará el fichero desde cero. Sin embargo, si es de borrados, le pasaremos TRUE, por lo que se vreará o
	abrirá en modo append.
	
	Será entonces cuando grabemos los datos del cliente en el fichero.

*/
import java.util.Vector;
import javax.swing.*;
import java.io.*;

public class Fichero extends JFrame{

        Vector borrados = new Vector();

  // Constructor vacío
  public Fichero() {}



  private void EscribeMensaje(String cadena1, String cadena2){
    // Genramos la pantalla
    JOptionPane.showConfirmDialog(this, cadena2, cadena1,
                                  JOptionPane.CLOSED_OPTION);
  }//Fin de EscribeMensaje



  // El siguiente método lee el fichero secuencial, y hace las operaciones en la BD.
  public void LeeClientes(){

    try{
      // Lo primero será crear un objeto de clase GestorBD para poder guardar los datos, eliminar...
      GestorBD conexion = new GestorBD();
      
      // Objeto de la clase FileInputStream, para caragr los datos de movimientos.dat
      FileInputStream VentasIn = new FileInputStream("movimientos.dat");
      // entrada está declarado para poder cargar valores de texto UTF8
      DataInputStream entrada = new DataInputStream(VentasIn);
      
      Cliente cli = new Cliente();  // Objeto donde guardaremos temporalmente el cliente con sus datos
      
      // Guardamos los datos del fichero en el objeto de clase Cliente
      cli.setCodigo( (String) entrada.readUTF() );
      cli.setNif( (String) entrada.readUTF() );
      cli.setNombre( (String) entrada.readUTF() );
      cli.setApellidos( (String) entrada.readUTF() );
      cli.setDomicilio( (String) entrada.readUTF() );
      cli.setCp( (String) entrada.readUTF() );
      cli.setLocalidad( (String) entrada.readUTF() );
      cli.setTelefono( (String) entrada.readUTF() );
      cli.setMovil( (String) entrada.readUTF() );
      cli.setFax( (String) entrada.readUTF() );
      cli.setVentas ( entrada.readDouble() );
      cli.setOperacion ( entrada.readUTF() );
      
      // Ahora verificaremos el último campo del fichero, de tipo text; si es A, B o M, haciendo lo suyo en cada caso
      // Como ya hemos guardado ese dato, tendremos que preguntar por el del objeto donde se guardó
      
      // En caso de que sea un alta, daremos de alta al cliente
      if (cli.getOperacion().compareTo("A") == 0)
        conexion.AnadirCliente(cli);
        
      // En caso de que sea una baja, daremos de baja al cliente
      else if (cli.getOperacion().compareTo("B") == 0)
      {
        // Borramos de la BD
        conexion.BorrarCliente(cli);
        // Metemos en el vector de borrados el cliente
        borrados.addElement(cli);
        // guardamos en Fichero de Borrados
        Graba(borrados,"borrados.dat",true);
        // Y eliminamos el vector de borrados
        borrados.removeAllElements();                
      }
      
      // En caso de que sea una modificación, lo modificaremos
      else
        conexion.ModificarCliente(cli);

      // Cerramos todo
      entrada.close();
      VentasIn.close();

          // Cuando termina de leer el fichero, grabamos los errores
          // O sea, si ha habido errores, la variable no está vacía
          if ( conexion.errores.isEmpty() == false )
                {
                // Grabamos todos los errores, pasandole el Vector, nombre del fichero y modo de apertura
                Graba(conexion.errores,"errores.log",false);
                // Mandamos un mensaje al usuario
                EscribeMensaje("Hubo Errores","Los errores se han almacenado en fichero.");
                }

    }// Try MostrarVentas

    catch(FileNotFoundException e1){
      EscribeMensaje("Error","No existe fichero de movimientos");
    }//FileNotFoundException

    catch(EOFException e2){
      EscribeMensaje("Información General","No hay más datos para procesar");
    }//EOFException

    catch(Exception e3){
       EscribeMensaje("Error General","Resto de errores");
    }//Exception

  }// Fin de LeeClientes


  /* El siguiente método Graba el fichero de Errores y borrados; le pasaremos un Vector de clientes, donde estará
        almacenado o bien todos los clientes que dieron error, o bien el cliente que se dio de baja; también le pasaremos
        el nombre del fichero y un valor booleano, para el modo append o no*/
    public void Graba(Vector clientes,String nombre,boolean opcion) {
    try{
        // Objeto de la clase FileOutputStream, para guardar los datos en nombre; aquí le pasamos la opcion 
        FileOutputStream VentasOut = new FileOutputStream(nombre,opcion);
        // salida está declarado para poder guardar valores de texto UTF8
        DataOutputStream salida = new DataOutputStream(VentasOut);

        Cliente c = new Cliente();  // Objeto donde guardaremos temporalmente el cliente con sus datos

                // Mientras haya clientes en el vector
        while(clientes.size()>0){

          // A c (objeto de clase Cliente) le pasamos los valores del vector
          c = (Cliente) clientes.elementAt(0);

          // Y escribimos en el fichero todos sus datos
          salida.writeUTF(c.getCodigo());
          salida.writeUTF(c.getNif());
          salida.writeUTF(c.getApellidos());
          salida.writeUTF(c.getNombre());
          salida.writeUTF(c.getDomicilio());
          salida.writeUTF(c.getCp());
          salida.writeUTF(c.getLocalidad());
          salida.writeUTF(c.getTelefono());
          salida.writeUTF(c.getMovil());
          salida.writeUTF(c.getFax());
          salida.writeDouble(c.getVentas());
		  // Si la opcion es FALSE, son errores; grabaremos pues también qué error dio
		  if ( opcion == false )
			salida.writeUTF(c.getOperacion());
		  // Si la opcion era true, estábamos en el fichero de borrados, y ahí no se graba ese dato

          // Una vez guardado el elemento lo elimanaremos del Vector; los vectores, que son dináminos,
          // se mueven, pasando un lugar para arriba; por ello siempre guardaremos el vector [0]
          clientes.remove(0);
        }// Fin del WHILE que recorre tantas veces como clientes haya almacenados

        salida.close();       // Terminaremos cerrando el Archivo
        VentasOut.close();    // Sin olvidarnos de que son 2
    }// TRY de GuardarErrores

    catch(Exception error){
      // Mensaje de error
      EscribeMensaje("Error en disco","Error al grabar en disco.\nCompruebe que el disco no esté lleno ni protegido contra escritura");
    }

  }// Fin de Graba
}// clase