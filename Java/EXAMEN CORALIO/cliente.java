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
  private double ventas;
  private String operacion;		// Aunque la operacion no sea propiamente un atributo, por diseño puedo permitirme almacenarlo

  // Constructor vacío
  public Cliente() {
  }

  // Constructor al que pasamos todos los valores
  public Cliente(String codigo,String nif, String nombre, String apellidos,
                 String domicilio, String cp, String localidad, String telefono,
                 String movil, String fax, double ventas, String operacion){
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
    this.operacion=operacion;
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
  public String getOperacion() {
    return operacion;
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
  public double getVentas() {
    return ventas;
  }
  public void setVentas(double ventas) {
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
  public void setoperacion(String operacion) {
    this.operacion = operacion;
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
  
}// class