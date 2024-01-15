package gestionalmacen;
import java.sql.*;
import java.sql.Connection;
import java.util.Vector;


/**
 * <p>T�tulo: GestorBD</p>
 * <p>Descripci�n: Clase que gestiona una base de datos por OBDC Mediante el Driver de Access
 * , llam�ndose la base "basededatos".</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.0
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalizaci�n: 14 / XI / 2006
*/

public class GestorBD {

  private Connection con;    // Variables de clase utilizadas
  private Statement stmt;    // para las coneciones a la BD


////////////////////////////   CONSTRUCTOR   ///////////////////////////////////
  public GestorBD() {

    // PRIMER TRY: Conectamos a la base de datos
    try{
      // Conectamos a la base de datos
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // L�nea de conexi�n
    }
    catch(Exception e){
     /* System.out.println("Error en Driver OBDC");
      System.out.println(e.getMessage());*/
    }

    // SEGUNDO TRY: Accedemos a los datos y verificamos opciones
    try{
      con = DriverManager.getConnection("jdbc:odbc:basededatos", "", "");
      con.setAutoCommit(false);
      stmt = con.createStatement();
    }
    catch(SQLException e){
     /* System.out.println("Error en la conexi�n");
      System.out.println(e.getMessage());*/
    }

  }// Constructor


///////////////////////////   BUSCAR CLIENTE   /////////////////////////////////
 public Cliente BuscarCliente(String codigo){

   ResultSet rs = null;
   Cliente micliente = null;

// Primero lanzaremos la sentencia SQL
   try{
     String sentencia = "SELECT * FROM clientes WHERE codigo = '"+codigo+"'";
     rs = stmt.executeQuery(sentencia);
   }

   catch(Exception e){
     /*System.out.println("Error SQL al buscar el Cliente");
     System.out.println(e.getMessage());*/
   }

// Y despu�s recuperaremos el Cliente
   try{
     if (rs.next() == true){                   // Si existe ese cliente

       micliente = new Cliente (rs.getString("codigo"),rs.getString("nif"),rs.getString("nombre"),
                                rs.getString("apellidos"),rs.getString("domicilio"),rs.getString("cp"),
                                rs.getString("localidad"),rs.getString("telefono"),rs.getString("movil"),
                                rs.getString("fax"),rs.getString("email"),rs.getInt("ventas"));

       /*System.out.println("Cliente Encontrado");*/
     }//if

     else{
       /*System.out.println("Cliente NO Encontrado");*/
       micliente = new Cliente();
     }
   }//try

   catch (Exception e){
     /*System.out.println("Error en la b�squeda del Cliente");
     System.out.println(e.getMessage());*/
   }

   return micliente;
 }// Fin de BuscarCliente


///////////////////////////   A�ADIR CLIENTE   /////////////////////////////////
public boolean AnadirCliente(Cliente cliente){

/* El siguiente m�todo guarda los datos del formulario en la base de datos.
   Seg�n la teor�a de Bases De Datos relacional, TODO lo que puede ser calculado,
   NUNCA debe ser almacenado. �Por qu�? Sencillo: Un dato almacenado que puede ser
   calculado, puede llegar a conllevar ambig�edad, lo que se traduce en la
   inconsistencia de la base de datos; recordemos que la inconsistencia es lo peor
   que le puede pasar a una base de datos, pudiendo provocar errores a medio o largo plazo.
   Es por ello que la letra del DNI no se almacena sino que siempre se calcula.
   Pienso que es mejor gastar tiempo de proceso en un peque�o c�lculo antes que poner
   en juego la integridad estructural de todo el proyecto.                                 */

    try {
      // Sentencia SQL
      String sentencia = "INSERT INTO clientes VALUES ('" + cliente.getCodigo() +
          "','" + cliente.getNif() + "','"+cliente.getNombre() + "','"
          +cliente.getApellidos() + "','" +cliente.getDomicilio() + "','"
          +cliente.getCp() + "','"+ cliente.getLocalidad() + "','"
          + cliente.getTelefono() + "','" + cliente.getMovil() + "','"
          + cliente.getFax() + "','"+ cliente.getEmail() + "','"
          + cliente.getVentas()+"')";

      // La ejecutamos
      stmt.executeUpdate(sentencia);

      // Guardamos los cambios en la tabla
      con.commit();

      // Como todo ha ido bien, devolvemos true
      return true;
    }

    catch (Exception e) {
    /*  System.out.println("Error SQL al insertar el Cliente");
      System.out.println(e.getMessage());*/
      // Si hay excepciones devolvemos false
      return false;
    }
  }// Fin de AnadirCliente


///////////////////////////   BORRAR CLIENTE   /////////////////////////////////
 public boolean BorrarCliente(Cliente cliente){

     try {
       // Sentencia SQL
       String sentencia = "DELETE * FROM clientes WHERE codigo = '"+cliente.getCodigo()+"'";

       // La ejecutamos
       stmt.executeUpdate(sentencia);

       // Guardamos los cambios en la tabla
       con.commit();

       // Como todo ha ido bien, devolvemos true
       return true;
     }

     catch (Exception e) {
      /* System.out.println("Error SQL al borrar el Cliente");
       System.out.println(e.getMessage());*/
       // Si hay excepciones devolvemos false
       return false;
     }
   }// Fin de BorrarCliente

 //////////////////////   BUSCAR TODOS LOS CLIENTES   //////////////////////////
  public Vector BuscarTodosLosClientes(String campo){

    ResultSet rs = null;              // Para la base de datos
    Cliente clientemp;                 // Para guardar el cliente temporalmente
    Vector misclientes = new Vector();  // Vector donde almacenaremos todos los clientes

// Primero lanzaremos la sentencia SQL
    try{
      String sentencia = "SELECT * FROM clientes ORDER BY "+campo;
      rs = stmt.executeQuery(sentencia);
    }

    catch(Exception e){
      /*System.out.println("Error SQL al buscar el Cliente");
      System.out.println(e.getMessage());*/
    }

// Y despu�s recuperaremos el Cliente
    try{
      while (rs.next() == true){                   // Si existe ese cliente

        // Creamos un cliente temporal
        clientemp = new Cliente (rs.getString("codigo"),rs.getString("nif"),rs.getString("nombre"),
                                 rs.getString("apellidos"),rs.getString("domicilio"),rs.getString("cp"),
                                 rs.getString("localidad"),rs.getString("telefono"),rs.getString("movil"),
                                 rs.getString("fax"),rs.getString("email"),rs.getInt("ventas"));

        // Y se lo pasamos al Vector
        misclientes.add(clientemp);
      }//if

    }//try

    catch (Exception e){
      /*System.out.println("Error en la b�squeda del Cliente");
      System.out.println(e.getMessage());*/
    }

    return misclientes;
  }// Fin de BuscarTodosLosClientes


///////////////////////////   UPDATE CLIENTE   /////////////////////////////////
  public void ModificaCliente(Cliente cli)
     {
       try
       {
         /////////////////////////////////////////////////////
         //   Recordemos la sintaxis del UPDATE M�LTIPLE:   //
         //                                                 //
         // UPDATE "table_name"                             //
         // SET column_1 = [value1], column_2 = [value2]    //
         // WHERE {condition}                               //
         /////////////////////////////////////////////////////

         // Cargamos la sentencia en un String
         String sentencia = "UPDATE \"clientes\" SET codigo = '" +cli.getCodigo()+
                       "', nif = '" + cli.getNif()+
                       "', nombre = '" + cli.getNombre()+
                       "', apellidos = '" + cli.getApellidos()+
                       "', domicilio = '" + cli.getDomicilio()+
                       "', cp = '" + cli.getCp()+
                       "', localidad = '" + cli.getLocalidad()+
                       "', telefono = '" +cli.getTelefono()+
                       "', movil = '" + cli.getMovil()+
                       "', fax = '" + cli.getFax()+
                       "', email = '" + cli.getEmail()+
             "' WHERE codigo = '" + cli.getCodigo()+"'";
         // Y la lanzamos
         System.out.println(sentencia);
         stmt.executeUpdate(sentencia);

         // Guardamos los cambios en la tabla
         con.commit();
       }//try

       catch(Exception e){
         /*System.out.println("Error SQL al modificar el cliente");
         System.out.println(e.getMessage());*/
       }//catch
     }// Fin de UPDATE CLIENTE

}// clase
