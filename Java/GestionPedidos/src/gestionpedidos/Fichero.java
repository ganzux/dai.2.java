package gestionpedidos;

import java.io.*;

/**
 * <p>T�tulo: Fichero</p>
 * <p>Descripci�n: Clase para gestionar el fichero con el n�mero de factura</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author �lvaro Alcedo Moreno
 * @version 1.0
 * Fecha de inicio: 21 / XI / 2006
 * Fecha de finalizaci�n: 26 / XI / 2006
 */


public class Fichero {
  public Fichero() {
  }

  public String NumeroDeFactura(){
    try{
      // Objeto de la clase FileOutputStream, para guardar los datos en ventas.dat
      // El segundo par�metro significa que, si el fichero no existe, se comportar�
      // como el constructor FileOutputStream("ventas.dat");
      // Este constructor siempre crea el fichero, por lo que si el fichero
      // ya exist�a los datos almacenados en �l se pierden.
      // Lo que haremos, pues, ser� leer el contenido del fichero (un entero) y alma-
      // cenarlo en una variable temporal de tipo entero; seguidamente volveremos a
      // crear el fichero incrementando un entero al contenido.

      // Lo primero leemos el fichero
      FileInputStream FicheroIn   = new FileInputStream ("ventas.dat");

      // para poder leer
      DataInputStream  entrada    = new DataInputStream (FicheroIn);

      // Guardamos en la variable entera el contenido
      int numerodefactura = entrada.readInt();

      // Cerramos ambos archivos
      entrada.close();
      FicheroIn.close();

      // Incrementamos en uno el valor del entero
      numerodefactura++;

      // Ahora forzaremos a crear el fichero, independientemente de si existe o no
      FileOutputStream FicheroOut = new FileOutputStream("ventas.dat", false);

      // para poder grabar
      DataOutputStream salida     = new DataOutputStream(FicheroOut);

      // Grabamos el entero
      salida.writeInt(numerodefactura);

      // Cerramos
      salida.close();
      FicheroOut.close();

      return String.valueOf(numerodefactura);

    }// Fin del TRY

    // Si el Fichero no existe, lo creamos con el contenido 0
    catch(FileNotFoundException e){
      // Try obligado
      try{
        // Ahora forzaremos a crear el fichero, independientemente de si existe o no
        FileOutputStream FicheroOut = new FileOutputStream("ventas.dat");

        // para poder grabar
        DataOutputStream salida = new DataOutputStream(FicheroOut);

        // Grabamos el primer entero (1)
        salida.writeInt(1);

        // Cerramos
        salida.close();
        FicheroOut.close();

        // Devolvemos el primer n�mero de factura por haberse generado un Catch, un error
        return "1";
      }// Fin del TTRy Obligado
      catch (Exception e3){
        // Devolvemos la factura 0
        return "0";
      }// Fin del catch obligado
    }// Fin del cath de FileNotFoundException

    // Otras Excepciones
    catch(IOException e1){
      // Devolvemos la factura 0 por haberse generado un Catch, un error
      return "0";
    }//otras excepciones

  }// NumeroDeFactura

}// clase
