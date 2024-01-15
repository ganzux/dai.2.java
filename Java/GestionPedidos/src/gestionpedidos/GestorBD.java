package gestionpedidos;
import java.sql.*;
import java.sql.Connection;
import java.util.Vector;


/**
 * <p>Título: GestorBD</p>
 * <p>Descripción: Clase que gestiona una base de datos por OBDC Mediante el Driver de Access
 * , llamándose la base "basededatos2".</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.5
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalización: 26 / XI / 2006
*/

public class GestorBD {

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
      con = DriverManager.getConnection("jdbc:odbc:basededatos", "", "");
      con.setAutoCommit(false);
      stmt = con.createStatement();
    }
    catch(SQLException e){
     /* System.out.println("Error en la conexión");
      System.out.println(e.getMessage());*/
    }

  }// Constructor


///////////////////////////   BUSCAR CLIENTE   /////////////////////////////////
// V 1.1 : Se añade la tabla donde se va a buscar el cliente o el proveedor
 public Cliente BuscarCliente(String codigo, String tabla){

   ResultSet rs = null;
   Cliente micliente = null;

// Primero lanzaremos la sentencia SQL
   try{
     String sentencia = "SELECT * FROM "+tabla.toLowerCase()+" WHERE codigo = '"+codigo+"'";
     rs = stmt.executeQuery(sentencia);
   }

   catch(Exception e){
     /*System.out.println("Error SQL al buscar el Cliente");
     System.out.println(e.getMessage());*/
   }

// Y después recuperaremos el Cliente
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
     /*System.out.println("Error en la búsqueda del Cliente");
     System.out.println(e.getMessage());*/
   }

   return micliente;
 }// Fin de BuscarCliente


///////////////////////////   AÑADIR CLIENTE   /////////////////////////////////
public boolean AnadirCliente(Cliente cliente){

/* El siguiente método guarda los datos del formulario en la base de datos.
   Según la teoría de Bases De Datos relacional, TODO lo que puede ser calculado,
   NUNCA debe ser almacenado. ¿Por qué? Sencillo: Un dato almacenado que puede ser
   calculado, puede llegar a conllevar ambigüedad, lo que se traduce en la
   inconsistencia de la base de datos; recordemos que la inconsistencia es lo peor
   que le puede pasar a una base de datos, pudiendo provocar errores a medio o largo plazo.
   Es por ello que la letra del DNI no se almacena sino que siempre se calcula.
   Pienso que es mejor gastar tiempo de proceso en un pequeño cálculo antes que poner
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

// Y después recuperaremos el Cliente
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
      /*System.out.println("Error en la búsqueda del Cliente");
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
         //   Recordemos la sintaxis del UPDATE MÚLTIPLE:   //
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
         stmt.executeUpdate(sentencia);

         // Guardamos los cambios en la tabla
         con.commit();
       }//try

       catch(Exception e){
         /*System.out.println("Error SQL al modificar el cliente");
         System.out.println(e.getMessage());*/
       }//catch
     }// Fin de UPDATE CLIENTE


///////////////////////////   BUSCAR ARTÍCULO   ////////////////////////////////

    public Articulo BuscarArticulo(String codigo){

      ResultSet rs = null;
      Articulo miarticulo = null;

// Primero lanzaremos la sentencia SQL
      try{
        String sentencia = "SELECT * FROM articulos WHERE codigo = '"+codigo+"'";
        rs = stmt.executeQuery(sentencia);
      }

      catch(Exception e){
        /*System.out.println("Error SQL al buscar el Artículo");
        System.out.println(e.getMessage());*/
      }

// Y después recuperaremos el Cliente
      try{
        if (rs.next() == true){                   // Si existe ese cliente

          miarticulo = new Articulo(rs.getString("codigo"),rs.getString("descripcion"),
                                    rs.getInt("stock"),rs.getInt("stockminimo"),
                                    rs.getFloat("preciocompra"),rs.getFloat("precioventa"));

          /*System.out.println("Artículo Encontrado");*/
        }//if

        else{
          /*System.out.println("Artículo NO Encontrado");*/
          miarticulo = new Articulo();
        }
      }//try

      catch (Exception e){
        /*System.out.println("Error en la búsqueda del Articulo");
        System.out.println(e.getMessage());*/
      }

      return miarticulo;
    }// Fin de BuscarArticulo


  //////////////////////////   UPDATE ARTÍCULO   ///////////////////////////////
    public void ModificaArticulo(Articulo art)
       {
         try
         {
           // Cargamos la sentencia en un String
           String sentencia = "UPDATE \"articulos\" SET stock = '"
               +art.getStock()+"' WHERE codigo = '" + art.getCodigo()+"'";

           // Y la lanzamos
           stmt.executeUpdate(sentencia);

         }//try

         catch(Exception e){
           /*System.out.println("Error SQL al modificar el articulo");
           System.out.println(e.getMessage());*/
         }//catch
       }// Fin de UPDATE ARTICULO


// Método por el cual añadimos más ventas a un cliente
    public void SumaVentas(String codigo, String asumar, String tabla)
   {
     try
     {

       // Convertimos asumar en entero
       float total = new Float (asumar).floatValue();

       // Añadimos a "total" las ventas de ese Cliente
       total = total + BuscarCliente(codigo,tabla).getVentas();

       // Cargamos la sentencia en un String
       String sentencia = "UPDATE \""+tabla+"\" SET ventas = " + total +
           " WHERE codigo = '" + codigo+"'";

       // Y la lanzamos
       stmt.executeUpdate(sentencia);

     }//try

     catch(Exception e){
       System.out.println("Error SQL al modificar el totalventas");
       System.out.println(e.getMessage());
     }//catch
   }// Fin de UPDATE CLIENTE



  // Método Commit
  public void commit(){
    try{
      con.commit();
    }// try

    catch (Exception e){
      System.out.println("Error en COMMIT");
      System.out.println(e.getMessage());
    }
  }// Fin del commit


  // Método RollBack
  public void rollback(){
    try{
      con.rollback();
    }// try

    catch (Exception e){
      System.out.println("Error en ROLLBACK");
      System.out.println(e.getMessage());
    }
  }// Fin del RollBack

  public void Historifica(String cod, String art, String unidades, String fecha){
    try {
      // Sentencia SQL
      String sentencia = "INSERT INTO historico VALUES ('" + cod +
          "','" + art + "','" + unidades + "','" +fecha+ "')";

      // La ejecutamos
      stmt.executeUpdate(sentencia);
    }// try

    catch (Exception e){
      System.out.println("Error en tabla Historico");
      System.out.println(e.getMessage());
    }


  }


}// clase
