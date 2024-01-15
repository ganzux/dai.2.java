package gestionpedidos;

/**
 * <p>Título: Cliente</p>
 * <p>Descripción: Clase que guarda un cliente</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.5
 * Fecha de inicio: 2 / XI / 2006
 * Fecha de finalización: 26 / XI / 2006
 */

public class Cliente {

  // Atributos
  private String codigo;
  private String nif;
  private String nombre;
  private String apellidos;
  private String domicilio;
  private String cp;
  private String localidad;
  private String telefono;
  private String movil;
  private String fax;
  private String email;
  private int ventas;

  // Constructor vacío
  public Cliente() {
  }

  // Constructor al que pasamos todos los valores
  public Cliente(String codigo,String nif, String nombre, String apellidos,
                 String domicilio, String cp, String localidad, String telefono,
                 String movil, String fax, String email, int ventas){
    this.codigo=codigo;
    this.nif=nif;
    this.nombre=nombre;
    this.apellidos=apellidos;
    this.domicilio=domicilio;
    this.cp=cp;
    this.localidad=localidad;
    this.telefono=telefono;
    this.movil=movil;
    this.fax=fax;
    this.email=email;
    this.ventas=ventas;
  }

  // GETTERS Y SETTERS
  public String getApellidos() {
    return apellidos;
  }
  public String getCodigo() {
    return codigo;
  }
  public String getCp() {
    return cp;
  }
  public String getDomicilio() {
    return domicilio;
  }
  public String getEmail() {
    return email;
  }
  public String getFax() {
    return fax;
  }
  public String getLocalidad() {
    return localidad;
  }
  public String getMovil() {
    return movil;
  }
  public String getNif() {
    return nif;
  }
  public String getTelefono() {
    return telefono;
  }
  public String getNombre() {
    return nombre;
  }
  public int getVentas() {
    return ventas;
  }
  public void setVentas(int ventas) {
    this.ventas = ventas;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setNif(String nif) {
    this.nif = nif;
  }
  public void setMovil(String movil) {
    this.movil = movil;
  }
  public void setLocalidad(String localidad) {
    this.localidad = localidad;
  }
  public void setFax(String fax) {
    this.fax = fax;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }
  public void setCp(String cp) {
    this.cp = cp;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public void EraseAll(){
    codigo    = null;
    nif       = null;
    nombre    = null;
    apellidos = null;
    domicilio = null;
    cp        = null;
    localidad = null;
    telefono  = null;
    movil     = null;
    fax       = null;
    email     = null;
    ventas    = 0;

  }
}// class
