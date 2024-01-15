package tienda;

/**
 * <p>Título: Tienda de ordenadores</p>
 * <p>Descripción: <Pequeño proyrecto para la gestión de una tienda de ordenadores/p>
 * <p>Copyright: CopyLeft (c) 2006</p>
 * <p>Empresa: iTo Soft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.0
 * <p>Inicio: 5 / X / 2006</p>
 * <p>Fin: 10 / X / 2006</p>
 */


public class Venta {

/////////////////////////////   ATRIBUTOS   ////////////////////////////////////
  private String nombre="";                 //                                //
  private int localidad=0;                  // Pondremos un atributo por cada //
  private int procesador=0;                 // campo que queramos guardar del //
  private int memoria=0;                    // formulario, siendo todos ellos //
  private int monitor=0;                    // PRIVADOS y accediendo a través //
  private int hd=0;                         // de los métodos GET Y SET, ha-  //
  private boolean opcion1=false;            // ciendo un GET y un SET por ca- //
  private boolean opcion2=false;            // da atributo, siendo aquellos   //
  private boolean opcion3=false;            // de público acceso.             //
  private boolean opcion4=false;            //                                //
////////////////////////////////////////////////////////////////////////////////

////////////////////////////  GETTERS Y SETTERS  ///////////////////////////////

  // Nombre
  public String getNombre(){
    return nombre;
  }
  public void setNombre(String nombre){
    this.nombre=nombre;
  }

  // Localidad
  public int getLocalidad(){
    return localidad;
  }
  public void setLocalidad(int localidad){
    this.localidad=localidad;
  }

  // Procesador
  public int getProcesador(){
    return procesador;
  }
  public void setProcesador(int procesador){
    this.procesador=procesador;
  }

  // Memoria
  public int getMemoria(){
    return memoria;
  }
  public void setMemoria(int memoria){
    this.memoria=memoria;
  }

  // Monitor
  public int getMonitor(){
    return monitor;
  }
  public void setMonitor(int monitor){
    this.monitor=monitor;
  }

  // HD
  public int getHD(){
    return hd;
  }
  public void setHD(int hd){
    this.hd=hd;
  }

  // Opcion 1
  public boolean getOpcion1(){
    return opcion1;
  }
  public void setOpcion1(boolean opcion1){
    this.opcion1=opcion1;
  }

  // Opcion 2
  public boolean getOpcion2(){
    return opcion2;
  }
  public void setOpcion2(boolean opcion2){
    this.opcion2=opcion2;
  }

  // Opcion 3
  public boolean getOpcion3(){
    return opcion3;
  }
  public void setOpcion3(boolean opcion3){
    this.opcion3=opcion3;
  }

  // Opcion 4
  public boolean getOpcion4(){
    return opcion4;
  }
  public void setOpcion4(boolean opcion4){
    this.opcion4=opcion4;
  }
//////////////////////  FIN DE LOS GETTERS Y SETTERS  //////////////////////////

  public Venta() {
  }// Constructor Vacío

  // Constructor con todos los atributos (por si algún día hiciese falta)
  public Venta(String nombre,int localidad,int procesador,int memoria,int monitor,int hd,boolean op1,boolean op2,boolean op3,boolean op4){
    this.nombre=nombre;
    this.localidad=localidad;
    this.procesador=procesador;
    this.memoria=memoria;
    this.monitor=monitor;
    this.hd=hd;
    this.opcion1=op1;
    this.opcion2=op2;
    this.opcion3=op3;
    this.opcion4=op4;
  }// Constructor al que le paso todos los atributos

}// Fin de la clase Venta
