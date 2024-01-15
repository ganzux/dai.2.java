/*

	                   ÁLVARO ALCEDO MORENO   2º D.A.I.

Clase GestorBD: Nos encontramos con una típica clase de Gestión de Bases de Datos.
· He creado un vector público llamado errores, donde podré almacenar objetos de la clase
clientes para poder reportarlos. El que sea público es por comodidad de Getters y Setters.
Cada vez que se produzca un error al dar un alta, modificacion o baja, añadiré un elemento
al vector.

*/

import java.util.Vector;
import java.sql.*;

public class GestorBD {

  // Vector donde guardaremos objetos de clase Cliente que hayan generado errores
  public Vector errores = new Vector();

  private Connection con;    // Variables de clase utilizadas
  private Statement stmt;    // para las coneciones a la BD


////////////////////////////   CONSTRUCTOR   ///////////////////////////////////
  public GestorBD() {

    // PRIMER TRY: Conectamos a la base de datos
    try{
      // Conectamos a la base de datos
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // Línea de conexión
    }
    catch(Exception e){
     /* System.out.println("Error en Driver OBDC");
      System.out.println(e.getMessage());*/
    }

    // SEGUNDO TRY: Accedemos a los datos y verificamos opciones
    try{
      con = DriverManager.getConnection("jdbc:odbc:badedeexamen", "", "");
      con.setAutoCommit(false);
      stmt = con.createStatement();
    }
    catch(SQLException e){
     /* System.out.println("Error en la conexión");
                System.out.println(e.getMessage());*/
    }

  }// Constructor
////////////////////////////  FIN CONSTRUCTOR   ////////////////////////////////



/*
Método BuscarCliente ( String codigo )
Éste método lanzará una SELECT sobre la base de datos buscando si existe o no un cliente que tenga
el código que se le pasa como parámetro.
Devolverá TRUE si lo encuentra y FALSE si no lo encuentra.

Realmente lo tenía codificado con que devolviese el cliente, pero no hacía falta.
*/
///////////////////////////   BUSCAR CLIENTE   /////////////////////////////////

 // Devuelve un booleano
 public boolean BuscarCliente(String codigo){

   ResultSet rs = null;
   Cliente micliente = null;
   boolean find = false;

// Primero lanzaremos la sentencia SQL
   try{
     String sentencia = "SELECT * FROM Clientes WHERE codigo = '"+codigo+"'";
     rs = stmt.executeQuery(sentencia);
         // Si existe cliente, rs.next es true, si no es false.
         find = rs.next();
   }

   catch(Exception e){
     /*System.out.println("Error SQL al buscar el Cliente");
                System.out.println(e.getMessage());*/
                find = false;
   }

   return find;
 }// Fin de BuscarCliente




/*
 Método void AnadirCliente(Cliente cliente)
Si el cliente no existe, lo da de alta lanzando la sentencia.
Si el cliente existe, graba ese cliente en el vector de errores, sin modificar la BD.
 */
///////////////////////////   AÑADIR CLIENTE   /////////////////////////////////
public void AnadirCliente(Cliente cliente){

    try {

      // Sentencia SQL
      String sentencia = "INSERT INTO Clientes VALUES ('" + cliente.getCodigo() +
          "','" + cliente.getNif() + "','"+cliente.getApellidos() + "','"
          +cliente.getNombre() + "','" +cliente.getDomicilio() + "','"
          +cliente.getCp() + "','"+ cliente.getLocalidad() + "','"
          + cliente.getTelefono() + "','" + cliente.getMovil() + "','"
          + cliente.getFax() + "','"+ cliente.getVentas()+"')";

                // Si el Cliente no existe
                if ( BuscarCliente ( cliente.getCodigo() ) == false )
                        {
                        // La ejecutamos, dando de alta
                        stmt.executeUpdate(sentencia);

                        // Guardamos los cambios en la tabla
                        con.commit();
                        }

                // Sin embargo, si el cliente ya existe, grabamos el Cliente en el Vector de Errores
                else
                        {
                        errores.addElement (cliente);
                        }

    }

    catch (Exception e) {
    /*  System.out.println("Error SQL al insertar el Cliente");
                System.out.println(e.getMessage());*/
    }
  }// Fin de AnadirCliente



/*
 Método void BorrarCliente(Cliente cliente)
Si el cliente existe, lo da de baja lanzando la sentencia.
Si el cliente no existe, graba ese cliente en el vector de errores, sin modificar la BD.
 */ 
///////////////////////////   BORRAR CLIENTE   /////////////////////////////////
 public void BorrarCliente(Cliente cliente){

     try {
       // Sentencia SQL
       String sentencia = "DELETE * FROM clientes WHERE codigo = '"+cliente.getCodigo()+"'";


                   // Si el Cliente existe
                if ( BuscarCliente ( cliente.getCodigo() ) == true )
                        {
                        // La ejecutamos, dando de baja
                        stmt.executeUpdate(sentencia);

                        // Guardamos los cambios en la tabla
                        con.commit();
                        }

                // Sin embargo, si el cliente no existe, grabamos el Cliente en el Vector de Errores
                else
                        {
                        errores.addElement (cliente);
                        }
     }// try

     catch (Exception e) {
      /* System.out.println("Error SQL al borrar el Cliente");
                System.out.println(e.getMessage());*/
     }
   }// Fin de BorrarCliente



/*
 Método void ModificaCliente(Cliente cli)
Si el cliente existe, modifica los campos que el enunciado dice
Si el cliente no existe, graba ese cliente en el vector de errores, sin modificar la BD.
 */ 
///////////////////////////   UPDATE CLIENTE   /////////////////////////////////
  public void ModificarCliente(Cliente cli)
     {
       try
       {
         // Cargamos la sentencia en un String
         String sentencia = "UPDATE \"clientes\" SET domicilio = '" + cli.getDomicilio()+
                       "', cp = '" + cli.getCp()+
                       "', localidad = '" + cli.getLocalidad()+
                       "', telefono = '" +cli.getTelefono()+
                       "', movil = '" + cli.getMovil()+
                       "', fax = '" + cli.getFax()+
             "' WHERE codigo = '" + cli.getCodigo()+"'";


                   // Si el Cliente existe
                if ( BuscarCliente ( cli.getCodigo() ) == true )
                        {
                        // La ejecutamos, modificando
                        stmt.executeUpdate(sentencia);

                        // Guardamos los cambios en la tabla
                        con.commit();
                        }

                // Sin embargo, si el cliente no existe, grabamos el Cliente en el Vector de Errores
                else
                        {
                        errores.addElement (cli);
                        }
     }// try

       catch(Exception e){
         /*System.out.println("Error SQL al modificar el cliente");
         System.out.println(e.getMessage());*/
       }//catch
     }// Fin de UPDATE CLIENTE

}// Fin de la clase