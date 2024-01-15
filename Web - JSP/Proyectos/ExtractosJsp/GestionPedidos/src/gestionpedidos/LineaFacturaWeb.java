package gestionpedidos;

/**
 * <p>Título: LineaFactura</p>
 * <p>Descripción: Porque toda factura está formada por... Líneas de factura</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.0
 * Fecha de inicio: 26 / XI / 2006
 * Fecha de finalización: 26 / XI / 2006
 */


public class LineaFacturaWeb {

  private String articulo;
  private String descripcion;
  private String unidades;
  private String precio;
  private String importe;
  private String fecha;

  public LineaFacturaWeb(){}

  public LineaFacturaWeb(String articulo, String descripcion, String unidades, String precio, String importe) {
    this.articulo = articulo;
    this.descripcion = descripcion;
    this.unidades = unidades;
    this.precio   = precio;
    this.importe = importe;
  }

  public LineaFacturaWeb(String fecha, String articulo, String unidades) {
    this.articulo = articulo;
    this.unidades = unidades;
    this.fecha = fecha;
}


  public String getFecha(){
    return fecha;
  }

  public void setFecha(String fecha){
    this.fecha=fecha;
  }

  public String getArticulo() {
    return articulo;
  }
  public void setArticulo(String articulo) {
    this.articulo = articulo;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public String getImporte() {
    return importe;
  }
  public String getPrecio() {
    return precio;
  }
  public String getUnidades() {
    return unidades;
  }
  public void setUnidades(String unidades) {
    this.unidades = unidades;
  }
  public void setPrecio(String precio) {
    this.precio = precio;
  }
  public void setImporte(String importe) {
    this.importe = importe;
  }

  public int ImporteEntero(){
    return Integer.parseInt(importe);
  }


}
